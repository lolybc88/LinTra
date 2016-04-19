package blackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

import blackboard.IBlackboard.Policy;

public class CopyOfHashMapArea implements IArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	volatile String name;
	volatile Policy policy;
	volatile Semaphore semaphore;
	volatile Map<String, IdentifiableElement> area;

	public CopyOfHashMapArea(String name, Policy p) {
		this.name = name;
		this.policy = p;
		semaphore = new Semaphore(1, true);
		area = new ConcurrentHashMap<String, IdentifiableElement>();
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized Policy getPolicy() {
		return policy;
	}

	public synchronized void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public synchronized Semaphore getSemaphore() {
		return semaphore;
	}

	public synchronized void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public synchronized Map<String, IdentifiableElement> getArea() {
		return area;
	}

	public synchronized void setArea(Map<String, IdentifiableElement> area) {
		this.area = area;
	}

	@Override
	public synchronized IdentifiableElement read(String id) throws BlackboardException {
		try{
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				e = area.get(id);
				semaphore.release();
			} else{
				e = area.get(id);
			}
			return e;
		} catch (InterruptedException e){
			throw new BlackboardException();
		} catch (NullPointerException e){
			e.printStackTrace();
			return null;
		}
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

	private synchronized Collection<IdentifiableElement> readAllAux(Collection<String> ids) {
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		for(String id : ids){
			if (area.get(id)!=null){
				out.add(area.get(id));
			}
		}
		return out;
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
		try {  
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				elems = readAux(n);
				semaphore.release();
			} else {
				elems = readAux(n);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private synchronized Collection<IdentifiableElement> readAux(int n) {
		if (area.keySet().size() < n){
			return area.values();
		} else {
			String[] keys =  toArray(area.keySet()); // I've decided to load the keys instead of the values directly because a set of String is not as heavy as a set of IdentifiableElements
			Collection<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
			for (int i=0; i<n; i++){
				elems.add(area.get(keys[i]));
			}
			return elems;
		}
	}

	@Override
	public synchronized IdentifiableElement take(String id) throws BlackboardException {
		try {
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				e = area.remove(id);
				semaphore.release();
			} else {
				e = area.remove(id);
			}
			return e;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	@Override
	public synchronized Collection<IdentifiableElement> takeAll(Collection<String> ids) throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				elems = takeAllAux(ids);
				semaphore.release();
			} else {
				elems = takeAllAux(ids);
			}
			return elems;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	private synchronized Collection<IdentifiableElement> takeAllAux(Collection<String> ids) {
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		for(String id : ids){
			IdentifiableElement e = area.remove(id); 
			if (e != null){
				out.add(e);
			}
		}
		return out;
	}

	@Override
	public synchronized Collection<IdentifiableElement> take(ISearch searchMethod) throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				elems = searchMethod.search(this);
				removeElements(elems);
				semaphore.release();
			} else {
				elems = searchMethod.search(this);
				removeElements(elems);
			}
			return elems;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	@Override
	public synchronized Collection<IdentifiableElement> take(int n) throws BlackboardException {
		try {  
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				elems = takeAux(n);
				semaphore.release();
			} else {
				elems = takeAux(n);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}
	
	private synchronized Collection<IdentifiableElement> takeAux(int n) {
		Collection<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		if (area.keySet().size() < n){
			elems = area.values();
			area.clear();
		} else {
			String[] keys = toArray(area.keySet()); // I've decided to load the keys instead of the values directly because a set of String is not as heavy as a set of IdentifiableElements
			for (int i=0; i<n; i++){
				elems.add(area.remove(keys[i]));
			}
		}
		return elems;
	}

	private synchronized String[] toArray(Set<String> keySet) {
		String[] array = new String[keySet.size()];
		int i = 0;
		for (String s : keySet){
			array[i] = s;
			i++;
		}
		return array;
	}

	private synchronized void removeElements(Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems){
			area.remove(e.getId());
		}
	}

	@Override
	public synchronized boolean write(IdentifiableElement elem) throws BlackboardException {
		try {
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_WRITE)){
				semaphore.acquire();
				area.put(elem.getId(), elem);
				semaphore.release();
			} else {
				area.put(elem.getId(), elem);
			}
			return true;
		} catch (InterruptedException e){
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

	private synchronized void writeAllAux(Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems){
			area.put(e.getId(), e);
		}
	}

	@Override
	public synchronized int size() {
		return area.keySet().size();
	}

	@Override
	public synchronized boolean clear() {
		area.clear();
		return area.keySet().size()==0;
	}
	
	@Override
	public void destroy() {
		area.clear();
		area = null;
	}

	@Override
	public synchronized void print() {
		System.out.println("*Area: "+name+"*");
		for (String id : area.keySet()){
			System.out.println(area.get(id));
		}
	}
	
	@Override
	public synchronized boolean equals(Object o){
		return o instanceof CopyOfHashMapArea && ((CopyOfHashMapArea) o).getName().equals(name);		
	}

	@Override
	public synchronized String toString() {
		return "HashMapArea [name=" + name + ", policy=" + policy
				+ ", semaphore=" + semaphore + ", area=" + area + "]";
	}
	
}
