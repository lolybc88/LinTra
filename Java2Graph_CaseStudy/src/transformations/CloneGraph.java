package transformations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import prefuseGraphInJava.Edge;
import prefuseGraphInJava.Node;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.CurrentId;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.Range;
import transfo.TraceFunction;

public class CloneGraph implements ITransformation {

	IArea srcArea, currentIdArea, idCorrespondencesArea, trgArea;
	Range rangeOfIds;
	private int rangeWidth;
	
	public CloneGraph(IArea srcArea, IArea currentIdArea, IArea idCorrespondencesArea, IArea trgArea) throws BlackboardException {
		this.srcArea = srcArea;
		this.currentIdArea = currentIdArea;
		this.idCorrespondencesArea = idCorrespondencesArea;
		this.trgArea = trgArea;
		rangeWidth = 10;
	}

	@Override
	public void transform(
			Collection<IdentifiableElement> objs, IMaster master) throws BlackboardException {
		List<IdentifiableElement> ies = new LinkedList<IdentifiableElement>();
		
		rangeOfIds = requestRangeOfIds(rangeWidth);
		
		for (IdentifiableElement e : objs) {
			if (e instanceof Node){
				String trgId = TraceFunction.create(e.getId(), "n2n");
				String id = askForNewId();
				Node n = new Node(id, trgId, ((Node) e).getName(), ((Node) e).getType(), ((Node) e).getSize()); 
				ies.add(n);
			} else if (e instanceof Edge) {
				String trgId = TraceFunction.create(e.getId(), "e2e");
				String id = askForNewId();
				Edge edge = new Edge(id, trgId, trgId2Id(((Edge) e).getSourceId()), trgId2Id(((Edge) e).getTargetId()));
				ies.add(edge);
			}
		}
		trgArea.writeAll(ies);
	}
	
	private String trgId2Id(String trgId) throws BlackboardException {
		IdCorrespondence idC = (IdCorrespondence) idCorrespondencesArea.read(trgId);
		return idC.getNewId();
	}

	private Range requestRangeOfIds(int numberOfIds) throws BlackboardException {
		CurrentId cid = (CurrentId) currentIdArea.take("0.0"); 
		while (cid == null){
			cid = (CurrentId) currentIdArea.take("0.0");
		}
		double id0 = cid.getCurrentId();
		cid.increase(numberOfIds);
		Range r = new Range(id0, id0+numberOfIds-1);
		currentIdArea.write(cid);
		return r;
	}
	
	private String askForNewId() throws BlackboardException {
		if (rangeOfIds.getCurrent()==rangeOfIds.getMaxID()){
			rangeOfIds = requestRangeOfIds(rangeWidth);
		}
		String id = Double.toString(rangeOfIds.next());
		return id;
	}

}
