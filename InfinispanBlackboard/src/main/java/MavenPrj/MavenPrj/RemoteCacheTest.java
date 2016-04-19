package MavenPrj.MavenPrj;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationChildBuilder;
import org.infinispan.manager.DefaultCacheManager;


public class RemoteCacheTest {

	public static void main(String[] args) throws MalformedURLException {
		
//		Properties props = new Properties();
//		props.put("infinispan.client.hotrod.server_list", "127.0.0.1:11222");
//		
//		RemoteCacheManager manager = new RemoteCacheManager(props);
//		System.out.println(manager.getProperties());
//		
//		RemoteCache rcache = manager.getCache();
//		
//		System.out.println("Using the cache");
//		
//		rcache.put("hello", "world");
//		rcache.put("bye", "world");
//		
//		System.out.println(rcache.get("hello"));
		
		/** *****************************/
		
		GlobalConfiguration gc = new GlobalConfigurationBuilder()
		   .transport().defaultTransport()
		   .addProperty("configurationFile", "config-files/jgroups-tcp.xml")
		   .build();
		DefaultCacheManager dcm = new DefaultCacheManager(gc);
		
		Cache<String, String> c = dcm.getCache();
		
		c.put("hello", "world");
		c.put("bye", "world");
		
		System.out.println(c.get("hello"));
	

		/** *****************************/
//		EmbeddedCacheManager manager = new DefaultCacheManager();
//		Cache<String, String> cache = manager.getCache("cacheLenovo");
//		
//		
//		DistributedExecutorService des = new DefaultExecutorService(cache);
//		List<Future<Void>> list = des.submitEverywhere(new StartCacheCallable<String, String>("cacheLenovo"));
//		for (Future<Void> future : list) {
//		   try {
//		      future.get(); // wait for task to complete
//		   } catch (InterruptedException e) {
//		   } catch (ExecutionException e) {
//		   }
//		}
		
	}
	
}