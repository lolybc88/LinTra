package distributedBlackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import blackboard.BlackboardException;
import blackboard.HashMapArea;
import blackboard.IArea;
import blackboard.IBlackboard;

public class DistributedBlackboard implements IBlackboard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	volatile List<IArea> areas;
	String remoteSubAreaIP;
	
	public DistributedBlackboard(String remoteSubAreaIP){
		areas = new LinkedList<IArea>();
		this.remoteSubAreaIP = remoteSubAreaIP;
	}
	
	@Override
	public IArea createArea(String name, Policy p) {
		return null;
	}
	
	public synchronized IArea createArea(String name, Policy p, int remoteSubAreaPort) {
		IArea hsA = null;
		try {
			hsA = new DistributedArea(name, p, remoteSubAreaIP, remoteSubAreaPort);
			areas.add(hsA);
		} catch (BlackboardException e) {
			e.printStackTrace();
		}
		return hsA;
	}
	
	public synchronized IArea createLocalArea(String name, Policy p) {
		IArea hsA = null;
		hsA = new HashMapArea(name, p);
		areas.add(hsA);
		return hsA;
	}
	
	@Override
	public synchronized boolean clearArea(IArea area) {
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
	public synchronized boolean destroyArea(IArea area) {
		boolean ok = false;
		boolean found = false;
		int i = 0;
		while (!found  && i<areas.size()) {
			if (areas.get(i).equals(area)) {
				areas.get(i).destroy();
				areas.remove(i);
				found = true;
			}
			i++;
		}
		return ok;
	}

	@Override
	public synchronized Collection<IArea> getAllAreas() {
		return areas;
	}

	@Override
	public synchronized int size() {
		int num = 0;
		for (IArea a : areas){
			num += a.size();
		}
		return num;
	}

	@Override
	public synchronized int size(IArea area) {
		return area.size();
	}

	@Override
	public synchronized boolean clear() {
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
	public synchronized void print() {
		System.out.println("** Blackboard **");
		for (IArea a : areas){
			a.print();
		}
	}

	@Override
	public synchronized void printArea(IArea a) {
		a.print();
	}

	@Override
	public synchronized String toString() {
		return "DistributedBlackboard [areas=" + areas + "]";
	}
}
