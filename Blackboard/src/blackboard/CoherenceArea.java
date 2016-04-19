package blackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Semaphore;

import blackboard.IBlackboard.Policy;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.tangosol.coherence.component.application.console.Coherence;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CoherenceArea implements IArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	Policy policy;
	Semaphore semaphore;
	NamedCache area;

	public CoherenceArea(String name, Policy p) {
		this.name = name;
		this.policy = p;
		semaphore = new Semaphore(1, true);
		area = CacheFactory.getCache(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public Map<String, IdentifiableElement> getArea() {
		return area;
	}

	public void setarea(NamedCache area) {
		this.area = area;
	}

	@Override
	public IdentifiableElement read(String id) throws BlackboardException {
		try {
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
				semaphore.acquire();
				e = (IdentifiableElement) area.get(id);
				semaphore.release();
			} else {
				e = (IdentifiableElement) area.get(id);
			}
			return e;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	@Override
	public Collection<IdentifiableElement> readAll(Collection<String> ids)
			throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
				semaphore.acquire();
				elems = readAllAux(ids);
				semaphore.release();
			} else {
				elems = readAllAux(ids);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private Collection<IdentifiableElement> readAllAux(Collection<String> ids) {
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		for (String id : ids) {
			if (area.get(id)!=null){
				out.add((IdentifiableElement) area.get(id));
			}
		}
		return out;
	}

	@Override
	public Collection<IdentifiableElement> read(ISearch searchMethod)
			throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
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
	public Collection<IdentifiableElement> read(int n) throws BlackboardException {
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

	private Collection<IdentifiableElement> readAux(int n) {
		if (area.keySet().size() < n){
			return area.values();
		} else {
			// I've decided to load the keys instead of the values because a set
			// of String does not require as much memory a set of IdentifiableElements.
			// Nevertheless, this decision may affect the performance because we
			// need to access for every key to the area to get its value
			String[] keys = (String[]) area.keySet().toArray(); 
			LinkedList<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
			for (int i=0; i<n; i++){
				elems.add((IdentifiableElement) area.get(keys[i]));
			}
			return elems;
		}
	}

	@Override
	public IdentifiableElement take(String id) throws BlackboardException {
		try {
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
				semaphore.acquire();
				e = (IdentifiableElement) area.remove(id);
				semaphore.release();
			} else {
				e = (IdentifiableElement) area.remove(id);
			}
			return e;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	@Override
	public Collection<IdentifiableElement> takeAll(Collection<String> ids)
			throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
				semaphore.acquire();
				elems = takeAllAux(ids);
				semaphore.release();
			} else {
				elems = takeAllAux(ids);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private Collection<IdentifiableElement> takeAllAux(Collection<String> ids) {
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		for (String id : ids) {
			IdentifiableElement e = (IdentifiableElement) area.remove(id);
			if (e != null) {
				out.add(e);
			}
		}
		return out;
	}

	@Override
	public Collection<IdentifiableElement> take(ISearch searchMethod)
			throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
				semaphore.acquire();
				elems = searchMethod.search(this);
				removeElements(elems);
				semaphore.release();
			} else {
				elems = searchMethod.search(this);
				removeElements(elems);
			}
			return elems;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}
	
	@Override
	public Collection<IdentifiableElement> take(int n) throws BlackboardException {
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
	
	private Collection<IdentifiableElement> takeAux(int n) {
		LinkedList<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		if (area.keySet().size() < n){
			elems = (LinkedList<IdentifiableElement>) area.values();
			area.clear();
		} else {
			String[] keys = (String[]) area.keySet().toArray(); // I've decided to load the keys instead of the values directly because a set of String is not as heavy as a set of IdentifiableElements
			for (int i=0; i<n; i++){
				elems.add((IdentifiableElement) area.remove(keys[i]));
			}
		}
		return elems;
	}

	private void removeElements(Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems) {
			area.remove(e.getId());
		}
	}

	@Override
	public boolean write(IdentifiableElement elem) throws BlackboardException {
		try {
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_WRITE)) {
				semaphore.acquire();
				area.put(elem.getId(), elem);
				semaphore.release();
			} else {
				area.put(elem.getId(), elem);
			}
			return true;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	@Override
	public boolean writeAll(Collection<IdentifiableElement> elems)
			throws BlackboardException {
		try {
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_WRITE)) {
				semaphore.acquire();
				writeAllAux(elems);
				semaphore.release();
			} else {
				writeAllAux(elems);
			}
			return true;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private void writeAllAux(Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems) {
			area.put(e.getId(), e);
		}
	}

	@Override
	public int size() {
		return area.keySet().size();
	}

	@Override
	public boolean clear() {
		area.clear();
		return area.keySet().size() == 0;
	}
	
	@Override
	public void destroy() {
		area.destroy();
	}
	
	@Override
	public void print() {
		System.out.println("*Area: " + name + "*");
		for (Object id : area.keySet()) {
			System.out.println(area.get(id));
		}
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof CoherenceArea
				&& ((CoherenceArea) o).getName().equals(name);
	}

}
