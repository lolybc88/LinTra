package blackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.ClassFilter;
import com.tangosol.util.Filter;
import com.tangosol.util.aggregator.Count;

//public class CoherenceBackboard implements IBlackboard {
//	
//	/* *********************************************************************** */
//	/*             TO DO 
//	/* *********************************************************************** */
//	
//	
//	NamedCache ts;
//	Collection<IArea> areas;
//
//	public CoherenceBackboard(String name) {
//		ts = CacheFactory.getCache(name);
//		areas = new LinkedList<IArea>();
//	}
//
//	@Override
//	public void put(Object ob1, Object ob2) {
//		ts.put(ob1, ob2);
//	}
//
//	@Override
//	public int size() {
//		return ts.size();
//	}
//
//	@Override
//	public void clear() {
//		ts.clear();
//	}
//
//	@Override
//	public void destroy() {
//		ts.destroy();
//	}
//
//	@Override
//	public Object get(Object key) {
//		return ts.get(key);
//	}
//
//	@Override
//	public Map getAll(Collection<Object> keys) {
//		return ts.getAll(keys);
//	}
//
//	@Override
//	public void putAll(Map<Object, Object> map) {
//		ts.putAll(map);
//	}
//
//	@Override
//	public void print() {
//		Set<Map.Entry<Object, Object>> entries = ts.entrySet();
//		for (Map.Entry<Object, Object> e : entries) {
//			System.out.println("* "+e.getValue());
//		}
//	}
//	
//	@Override
//	public int count(String className) throws ClassNotFoundException{
//		Class clazz = Class.forName(className);
//		Filter filter = new ClassFilter(clazz);
////		Filter filter = new AndFilter(new ClassFilter(c), new EqualsFilter("isAbstract", false));
//		return (Integer) ts.aggregate(filter, new Count());
//	}
//
//	
//	
//	
//}
