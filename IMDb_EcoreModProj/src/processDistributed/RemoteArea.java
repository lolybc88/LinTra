package processDistributed;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.ISearch;
import blackboard.IdentifiableElement;
import blackboard.IBlackboard.Policy;

import java.net.*;
import java.awt.color.CMMException;
import java.io.*;

import javax.security.auth.Destroyable;

import distributedBlackboard.CommunProtocolKeyWords;

public class RemoteArea implements IArea {
	
	/** Comments to myself:
	 * - After we exit a synchronized block, we release the monitor, which has the effect of flushing the cache to main memory,
	 * so that writes made by this thread can be visible to other threads.
	 * -----> So synchronization is needed in setter, writes/takes and methods that modify some variables.
	 * - Do I need to synchronize getters and reads too?
	 * - Volatile variables share the visibility features of synchronized, but none of the atomicity features. This means that
	 * threads will automatically see the most up-to-date value for volatile variables.
	 * - You might prefer to use volatile variables instead of locks for one of two principal reasons: simplicity or
	 * scalability. Some idioms are easier to code and read when they use volatile variables instead of locks. In addition,
	 * volatile variables (unlike locks) cannot cause a thread to block, so they are less likely to cause scalability problems.
	 * -----> So as long as the variables are volatile, I don't need to synchronize getters, reads or any other method that doesn't
	 * modify the variable. 
	 */

	private static final long serialVersionUID = 1L;
	private volatile String name;
	private volatile Policy policy;
	private volatile Semaphore semaphore;
	
	Socket s;
	OutputStream os;
	ObjectOutputStream oos;
	InputStream is;
	ObjectInputStream ois;

	public RemoteArea(String name, Policy p) throws BlackboardException {
		this.name = name;
		this.policy = p;
		semaphore = new Semaphore(1, true);
	}
	
	public void connectToRemoteSubArea(String remoteSubAreaIP, int remoteSubAreaPort) throws BlackboardException{
		try {
			s = new Socket(remoteSubAreaIP, remoteSubAreaPort);
			os = s.getOutputStream();
			oos = new ObjectOutputStream(os);
			is = s.getInputStream();
			ois = new ObjectInputStream(is);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BlackboardException("There was a problem connecting to the remote area");
		}
	}

	public String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public Policy getPolicy() {
		return policy;
	}

	public synchronized void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public synchronized void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public synchronized IdentifiableElement read(String id) throws BlackboardException {
		int machine = routingFunction(id);
		IdentifiableElement ie = null;
		try{
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				ie = readAux(id, machine);
				semaphore.release();
			} else {
				ie = readAux(id, machine);
			}
			return ie;
		} catch (InterruptedException e){
			throw new BlackboardException();
		} catch (NullPointerException e){
			e.printStackTrace();
			return null;
		}
	}

	private IdentifiableElement readAux(String id, int machine) throws BlackboardException {
		IdentifiableElement e = readFromRemoteArea(id);
		return e;
	}
	
	private int routingFunction(String id){
		return Math.abs(id.hashCode())%2;
	}
	
	
	private synchronized IdentifiableElement readFromRemoteArea(String id) throws BlackboardException {
		IdentifiableElement ie = null;
		try {
			oos.writeObject(new String(id));
			ie = (IdentifiableElement) ois.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new BlackboardException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ie;
	}

	@Override
	public synchronized Collection<IdentifiableElement> readAll(Collection<String> ids) throws BlackboardException {
		try{
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				elems = readAllAux(ids);
				semaphore.release();
			} else{
				elems = readAllAux(ids);
			}
			return elems;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}
	
	private synchronized Collection<IdentifiableElement> readAllAux(Collection<String> ids) throws BlackboardException {
				
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		
		out.addAll(readAllFromRemoteArea(ids));
		
		return out;
		
	}
	
	private Collection<? extends IdentifiableElement> readAllFromRemoteArea(
			Collection<String> remoteIds) throws BlackboardException {
		try {
			oos.writeObject(remoteIds);
			Object o = ois.readObject();
			if (o instanceof List<?>){
				return (List<IdentifiableElement>) o;
			}
		} catch (Exception ex){
			ex.printStackTrace();
			throw new BlackboardException();
		}
		return null;
	}
	

	@Override
	public synchronized Collection<IdentifiableElement> read(ISearch searchMethod) throws BlackboardException {
		try {  
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				elems = searchMethod.search(this);
				semaphore.release();
			} else {
				elems = searchMethod.search(this);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}
	
	@Override
	public synchronized Collection<IdentifiableElement> read(int n) throws BlackboardException {
		// TO BE COMPLETED
		return null;
	}

	@Override
	public synchronized IdentifiableElement take(String id) throws BlackboardException {
		IdentifiableElement ie = null;
		try{
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				ie = takeFromRemoteArea(id);
				semaphore.release();
			} else {
				ie = takeFromRemoteArea(id);
			}
			return ie;
		} catch (InterruptedException e){
			throw new BlackboardException();
		} catch (NullPointerException e){
			e.printStackTrace();
			return null;
		}
	}

	private IdentifiableElement takeFromRemoteArea(String id) throws BlackboardException {
		IdentifiableElement ie = null;
		try {
			oos.writeObject(CommunProtocolKeyWords.TAKE);
			oos.writeObject(new String(id));
			ie = (IdentifiableElement) ois.readObject();	
		} catch (IOException e) {
			e.printStackTrace();
			throw new BlackboardException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ie;
	}

	@Override
	public synchronized Collection<IdentifiableElement> takeAll(Collection<String> ids) throws BlackboardException {
		// TO BE COMPLETED
		return null;
	}

	@Override
	public synchronized Collection<IdentifiableElement> take(ISearch searchMethod) throws BlackboardException {
		// TO BE COMPLETED
		return null;
	}

	@Override
	public synchronized Collection<IdentifiableElement> take(int n) throws BlackboardException {
		// TO BE COMPLETED
		return null;
	}

	@Override
	public synchronized boolean write(IdentifiableElement elem) throws BlackboardException {
		int machine = routingFunction(elem.getId());
		try {
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_WRITE)){
				semaphore.acquire();
				writeAux(elem, machine);
				semaphore.release();
			} else {
				writeAux(elem, machine);
			}
			return true;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}		
	}

	private void writeAux(IdentifiableElement elem, int machine)
			throws BlackboardException {

		writeIntoRemoteArea(elem);
	}
		
	public synchronized void writeIntoRemoteArea(IdentifiableElement elem) throws BlackboardException {	
		try {
			oos.writeObject(elem);
			Object o = ois.readObject();
			if (!(o instanceof String) || !(o.equals(CommunProtocolKeyWords.OK))){
				throw new BlackboardException();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new BlackboardException();
		}
	}

	@Override
	public synchronized boolean writeAll(Collection<IdentifiableElement> elems) throws BlackboardException {
		try {
			if (elems!=null){
				if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_WRITE)){
					semaphore.acquire();
					writeAllAux(elems);
					semaphore.release();
				} else {
					writeAllAux(elems);
				}
			}
			return true;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	private synchronized void writeAllAux(Collection<IdentifiableElement> elems) throws BlackboardException {
	
			writeAllIntoRemoteArea(elems);
	

	}

	
	private void writeAllIntoRemoteArea(Collection<IdentifiableElement> remoteElems) throws BlackboardException {
		try {
			oos.writeObject(remoteElems);
//			Object o = ois.readObject();
//			if ((o instanceof String) && (o.equals(CommunProtocolKeyWords.OK))){
//			} else {
//				throw new BlackboardException();
//			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new BlackboardException();
		}
	}
	

	@Override
	public synchronized int size() {
		try {
			oos.writeObject(CommunProtocolKeyWords.SIZE);
			Object o = ois.readObject();
			if (o instanceof Integer){
				return (Integer)o;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public synchronized boolean clear() {
		try{
			oos.writeObject(new String(CommunProtocolKeyWords.CLEAR));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void destroy() {
		try {
			oos.writeObject(new String(CommunProtocolKeyWords.DESTROY));
			Object o = ois.readObject();
			if (o instanceof String && o.equals(CommunProtocolKeyWords.OK)){
				oos.close();
				os.close();
				is.close();
				ois.close();
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void print() {
		// TO BE COMPLETED
	}
	
	@Override
	public synchronized boolean equals(Object o){
		return o instanceof RemoteArea && ((RemoteArea) o).getName().equals(name);		
	}

	@Override
	public synchronized String toString() {
		return "HashMapArea [name=" + name + ", policy=" + policy
				+ ", semaphore=" + semaphore + "]";
	}
	
}
