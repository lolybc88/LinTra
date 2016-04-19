package MavenPrj.MavenPrj;

import java.util.Iterator;
import java.util.Map;
 
import java.util.Set;
import java.util.UUID;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.ServerStatistics;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
 
public class DemoHotRod {
 
    private RemoteCacheManager cacheManager;
    private RemoteCache<String, Object> cache;
 
    public DemoHotRod() {
 
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("127.0.0.1")
                .port(Integer.parseInt("11222"));
        cacheManager = new RemoteCacheManager(builder.build());
 
        cache = cacheManager.getCache("default");
 
//        cache.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
 
//        System.out.println("Dumping cache Data");
//        System.out.println("==========================");
        Set set = this.cache.keySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        //Print cache statistics
//        ServerStatistics stats = cache.stats();
//        for (Map.Entry stat : stats.getStatsMap().entrySet()) {
//            System.out.println(stat.getKey() + " : " + stat.getValue());
//        }
 
    }
 
    public static void main(String[] args) {
 
        DemoHotRod manager = new DemoHotRod();
 
    }
 
}