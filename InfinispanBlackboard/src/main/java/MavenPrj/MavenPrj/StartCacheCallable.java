package MavenPrj.MavenPrj;

import java.io.Serializable;
import java.util.Set;

import org.infinispan.distexec.DistributedCallable;

import infinispan.com.google.common.cache.Cache;

public class StartCacheCallable<K, V> implements DistributedCallable<K, V, Void>, Serializable {
private static final long serialVersionUID = 8331682008912636780L;
private final String cacheName;
private transient Cache<K, V> cache;


public StartCacheCallable(String cacheName) {
   this.cacheName = cacheName;
}

@Override
public Void call() throws Exception {
   ((org.infinispan.Cache<K, V>) cache).getCacheManager().getCache(cacheName); // start the cache
   return null;
}

@Override
public void setEnvironment(org.infinispan.Cache<K, V> cache, Set<K> inputKeys) {
	this.cache = (Cache<K, V>) cache;
}

}