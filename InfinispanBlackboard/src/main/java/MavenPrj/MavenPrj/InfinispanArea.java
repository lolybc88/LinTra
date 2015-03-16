package MavenPrj.MavenPrj;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Semaphore;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.context.Flag;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.persistence.leveldb.configuration.LevelDBStoreConfigurationBuilder;

import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IBlackboard.Policy;
import blackboard.ISearch;
import blackboard.IdentifiableElement;

public class InfinispanArea implements IArea {

	private static final long serialVersionUID = 1L;
	volatile Policy policy;
	volatile Semaphore semaphore;
	Cache<String, IdentifiableElement> area;
	String name;

	public InfinispanArea(String name, Policy p, EmbeddedCacheManager manager)
			throws IOException {

//		ConfigurationBuilder b = new ConfigurationBuilder();
//		b.persistence().passivation(true).addSingleFileStore().purgeOnStartup(true)
//				.location("/tmp/inifinspanData")
//				.eviction().eviction().strategy(EvictionStrategy.LRU).maxEntries(10000);
		
		LevelDBStoreConfigurationBuilder b = new ConfigurationBuilder()
		.eviction().strategy(EvictionStrategy.LRU).maxEntries(100000)
		.persistence().addStore(LevelDBStoreConfigurationBuilder.class).purgeOnStartup(true)
		.location("../InfinispanBlackboard/temp/level/").expiredLocation("../InfinispanBlackboard/temp/levelexpire/");
		
		final Configuration c = b.build();

		// Configuration c = new ConfigurationBuilder()
		// .persistence()
		// .passivation(true)
		// .addSingleFileStore()
		// .preload(false)
		// .shared(false)
		// .fetchPersistentState(false)
		// .ignoreModifications(false)
		// .purgeOnStartup(true)
		// // .location(System.getProperty("java.io.tmpdir"))
		// .location("C:/infinispan")
		// .async()
		// .enabled(false)
		// .threadPoolSize(5)
		// .singleton()
		// .enabled(false)
		// .pushStateWhenCoordinator(true)
		// .pushStateTimeout(20000)
		// .eviction()
		// .strategy(EvictionStrategy.LRU).maxEntries(1000)
		// // .expiration().wakeUpInterval(5000l).lifespan(1000l).maxIdle(500l)
		// .clustering()
		// .build();

		manager.defineConfiguration(name, c);

		area = manager.getCache(name);
		this.name = name;
		this.policy = p;
		semaphore = new Semaphore(1, true);

	}

	public Cache<String, IdentifiableElement> getArea() {
		return area;
	}

	public void setArea(Cache<String, IdentifiableElement> area) {
		this.area = area;
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

	public IdentifiableElement read(String id) throws BlackboardException {
		try {
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
				semaphore.acquire();
				e = (IdentifiableElement) (area.get(id));
				semaphore.release();
			} else {
				e = (IdentifiableElement) (area.get(id));
			}
			return e;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

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

	private synchronized Collection<IdentifiableElement> readAllAux(
			Collection<String> ids) {
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		// String idsS = "";
		for (String id : ids) {
			if (area.get(id) != null) {
				// idsS += id + ", ";
				// System.out.println(id);
				out.add(area.get(id));
			}
		}
		// System.out.println(idsS);
		return out;
	}

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

	public Collection<IdentifiableElement> read(int n)
			throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
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
		if (area.keySet().size() < n) {
			return area.values();
		} else {
			String[] keys = toArray(area.keySet()); // I've decided to load the
													// keys instead of the
													// values directly because a
													// set of String is not as
													// heavy as a set of
													// IdentifiableElements
			Collection<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
			for (int i = 0; i < n; i++) {
				elems.add(area.get(keys[i]));
			}
			return elems;
		}
	}

	private synchronized String[] toArray(Set<String> keySet) {
		String[] array = new String[keySet.size()];
		int i = 0;
		for (String s : keySet) {
			array[i] = s;
			i++;
		}
		return array;
	}

	public IdentifiableElement take(String id) throws BlackboardException {
		try {
			IdentifiableElement e;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
				semaphore.acquire();
				e = area.remove(id);
				semaphore.release();
			} else {
				e = area.remove(id);
			}
			return e;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

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

	private synchronized Collection<IdentifiableElement> takeAllAux(
			Collection<String> ids) {
		Collection<IdentifiableElement> out = new LinkedList<IdentifiableElement>();
		for (String id : ids) {
			IdentifiableElement e = area.remove(id);
			if (e != null) {
				out.add(e);
			}
		}
		return out;
	}

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

	private synchronized void removeElements(
			Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems) {
			area.remove(e.getId());
		}
	}

	public Collection<IdentifiableElement> take(int n)
			throws BlackboardException {
		try {
			Collection<IdentifiableElement> elems;
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_READ)) {
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
		if (area.keySet().size() < n) {
			elems = area.values();
			area.clear();
		} else {
			String[] keys = toArray(area.keySet()); // I've decided to load the
													// keys instead of the
													// values directly because a
													// set of String is not as
													// heavy as a set of
													// IdentifiableElements
			for (int i = 0; i < n; i++) {
				elems.add(area.remove(keys[i]));
			}
		}
		return elems;
	}

	public boolean write(IdentifiableElement elem) throws BlackboardException {
		try {
			if (policy.equals(Policy.ALWAYS_LOCK)
					|| policy.equals(Policy.LOCK_TO_WRITE)) {
				semaphore.acquire();
				area.getAdvancedCache().withFlags(Flag.SKIP_CACHE_LOAD)
						.put(elem.getId(), elem);
				semaphore.release();
			} else {
				area.getAdvancedCache().withFlags(Flag.SKIP_CACHE_LOAD)
						.put(elem.getId(), elem);
			}
			return true;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	public boolean writeAll(Collection<IdentifiableElement> elems)
			throws BlackboardException {
		try {
			if (elems != null) {
				if (policy.equals(Policy.ALWAYS_LOCK)
						|| policy.equals(Policy.LOCK_TO_WRITE)) {
					semaphore.acquire();
					writeAllAux(elems);
					semaphore.release();
				} else {
					writeAllAux(elems);
				}
			}
			return true;
		} catch (InterruptedException e) {
			throw new BlackboardException();
		}
	}

	private synchronized void writeAllAux(Collection<IdentifiableElement> elems) {
		for (IdentifiableElement e : elems) {
			if (area.containsKey(e.getId())) {
				System.out.println("--->" + area.get(e.getId())
						+ " is being overwritten by " + e);
			}
			area.put(e.getId(), e);
		}
	}

	public int size() {
		return area.keySet().size();
	}

	public boolean clear() {
		area.clear();
		return area.keySet().size() == 0;
	}

	public void print() {
		System.out.println("*Area: " + name + "*");
		for (String id : area.keySet()) {
			System.out.println(area.get(id));
		}
	}

	public synchronized String toString() {
		return "HashMapArea [name=" + name + ", policy=" + policy
				+ ", semaphore=" + semaphore + ", area=" + area + "]";
	}

}
