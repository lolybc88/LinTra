package MavenPrj.MavenPrj;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

import blackboard.IArea;
import blackboard.IBlackboard;

public class InfinispanBlackboard implements IBlackboard {
	
	private static final long serialVersionUID = 1L;
	volatile List<IArea> areas;
	EmbeddedCacheManager manager;

	public InfinispanBlackboard() {

			manager = new DefaultCacheManager();
			areas = new LinkedList<IArea>();
		
	}
	
	
	public IArea createArea(String name, Policy p) {
		try {
			IArea area = new InfinispanArea(name, p, manager);
			areas.add(area);
			return area;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public boolean clearArea(IArea area) {
		boolean ok = false;
		boolean found = false;
		int i = 0;
		while (!found) {
			if (areas.get(i).equals(area)) {
				ok = areas.get(i).clear();
				found = true;
			}
			i++;
		}
		return ok;
	}

	
	public boolean destroyArea(IArea area) {
		boolean ok = false;
		boolean found = false;
		int i = 0;
		while (!found  && i<areas.size()) {
			if (areas.get(i).equals(area)) {
				areas.get(i).clear();
				areas.remove(i);
				found = true;
			}
			i++;
		}
		return ok;
	}

	
	public Collection<IArea> getAllAreas() {
		return areas;
	}

	
	public int size() {
		int num = 0;
		for (IArea a : areas){
			num += a.size();
		}
		return num;
	}

	
	public int size(IArea area) {
		return area.size();
	}

	
	public boolean clear() {
		boolean ok = true;
		int i = 0;
		while (ok && i<areas.size()){
			ok = areas.get(i).clear();
			areas.remove(i);
			i++;
		}
//		manager.stop();
		return ok;
	}

	
	public void print() {
		System.out.println("** Blackboard **");
		for (IArea a : areas){
			a.print();
		}
	}

	
	public void printArea(IArea a) {
		a.print();	
	}

}
