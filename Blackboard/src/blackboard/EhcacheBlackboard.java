package blackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class EhcacheBlackboard implements IBlackboard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<IArea> areas;
	
	public EhcacheBlackboard(){
		areas = new LinkedList<IArea>();
	}
	
	@Override
	public IArea createArea(String name, Policy p) {
		IArea hsA = new EhcacheArea(name, p);
		areas.add(hsA);
		return hsA;
	}

	@Override
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

	@Override
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

	@Override
	public Collection<IArea> getAllAreas() {
		return areas;
	}

	@Override
	public int size() {
		int num = 0;
		for (IArea a : areas){
			num += a.size();
		}
		return num;
	}

	@Override
	public int size(IArea area) {
		return area.size();
	}

	@Override
	public boolean clear() {
		boolean ok = true;
		int i = 0;
		while (ok && i<areas.size()){
			ok = areas.get(i).clear();
			areas.remove(i);
			i++;
		}
		return ok;
	}

	@Override
	public void print() {
		System.out.println("** Blackboard **");
		for (IArea a : areas){
			a.print();
		}
	}

	@Override
	public void printArea(IArea a) {
		a.print();
	}
}
