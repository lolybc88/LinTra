package blackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import blackboard.IBlackboard.Policy;

public class EhcacheArea implements IArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	Policy policy;
	Semaphore semaphore;
	Cache area;
	CacheManager manager;
	
	public EhcacheArea(String name, Policy p) {
		this.name = name;
		this.policy = p;
		semaphore = new Semaphore(1, true);
		
		//Create a singleton CacheManager using defaults
		manager = CacheManager.create();

		// Create a Cache specifying its configuration.
		area = new Cache(
				new CacheConfiguration(name, Integer.MAX_VALUE)
//				.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
//				.eternal(false)
//				.timeToLiveSeconds(60)
//				.timeToIdleSeconds(30)
//				.diskExpiryThreadIntervalSeconds(0)
//				.persistence(
//						new PersistenceConfiguration()
//								.strategy(Strategy.LOCALTEMPSWAP))
								);
		manager.addCache(area);
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

	public Cache getArea() {
		return area;
	}

	public void setArea(Cache area) {
		this.area = area;
	}

	@Override
	public IdentifiableElement read(String id) throws BlackboardException {
		try{
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				Element element = area.get(id);
				if (element!=null){
					e = (IdentifiableElement) element.getObjectValue();
				} else {
					e = null;
				}
				semaphore.release();
			} else{
				Element element = area.get(id);
				if (element!=null){
					e = (IdentifiableElement) element.getObjectValue();
				} else {
					e = null;
				}
			}
			return e;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	@Override
	public Collection<IdentifiableElement> readAll(Collection<String> ids)
			throws BlackboardException {
		try{
			Collection<IdentifiableElement> identElems;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				identElems = toIdentifiableElementCollection(area.getAll(ids).values());
				semaphore.release();
			} else{
				identElems = toIdentifiableElementCollection(area.getAll(ids).values());
			}
			return identElems;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	private Collection<IdentifiableElement> toIdentifiableElementCollection(
			Collection<Element> elements) {
		Collection<IdentifiableElement> identElems = new LinkedList<IdentifiableElement>();
		for (Element e : elements){
			identElems.add((IdentifiableElement) e.getObjectValue());
		}
		return identElems;
	}

	@Override
	public Collection<IdentifiableElement> read(ISearch searchMethod)
			throws BlackboardException {
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
	public Collection<IdentifiableElement> read(int n) throws BlackboardException {
		return null;	
	}

	@Override
	public IdentifiableElement take(String id) throws BlackboardException {
		try {
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_READ)){
				semaphore.acquire();
				Element elem = area.removeAndReturnElement(id);
				if (elem!=null){
					e = (IdentifiableElement) elem.getObjectValue();
				} else {
					e = null;
				}
				semaphore.release();
			} else {
				Element elem = area.removeAndReturnElement(id);
				if (elem!=null){
					e = (IdentifiableElement) elem.getObjectValue();
				} else {
					e = null;
				}
			}
			return e;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	@Override
	public Collection<IdentifiableElement> takeAll(Collection<String> ids)
			throws BlackboardException {
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

	private Collection<IdentifiableElement> takeAllAux(Collection<String> ids) {
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		for(String id : ids){
			Element elem = area.removeAndReturnElement(id);
			IdentifiableElement e = (IdentifiableElement) elem.getObjectValue(); 
			if (e != null){
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
	public Collection<IdentifiableElement> take(int n) throws BlackboardException {
		return null;	
	}
	
	private void removeElements(Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems){
			area.removeAndReturnElement(e.getId());
		}
	}

	@Override
	public boolean write(IdentifiableElement elem) throws BlackboardException {
		try {
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_WRITE)){
				semaphore.acquire();
				Element element = new Element(elem.getId(), elem);
				area.put(element);
				semaphore.release();
			} else {
				Element element = new Element(elem.getId(), elem);
				area.put(element);
			}
			return true;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	@Override
	public boolean writeAll(Collection<IdentifiableElement> elems)
			throws BlackboardException {
		try {
			if (policy.equals(Policy.ALWAYS_LOCK) || policy.equals(Policy.LOCK_TO_WRITE)){
				semaphore.acquire();
				writeAllAux(elems);
				semaphore.release();
			} else {
				writeAllAux(elems); 
			}
			return true;
		} catch (InterruptedException e){
			throw new BlackboardException();
		}
	}

	private void writeAllAux(Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems){
			Element element = new Element(e.getId(), e);
			area.put(element);
		}
	}

	@Override
	public int size() {
		return area.getSize();
	}

	@Override
	public boolean clear() {
		manager.clearAllStartingWith(name);
//		manager.removeCache(name);
//		manager.shutdown();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void print() {
		System.out.println("*Area: "+name+"*");
		for (String id : (Collection<String>)area.getKeys()){
			System.out.println(area.get(id));
		}
	}

	@Override
	public boolean equals(Object o){
		return o instanceof EhcacheArea && ((EhcacheArea) o).getName().equals(name);		
	}
	
}
