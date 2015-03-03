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
import transfo.LinTraParameters;
import transfo.ModelFlags;
import transfo.Range;
import transfo.TraceFunction;

public class ReduceGraph implements ITransformation {

	private static final String E2E = "e2e";
	private static final String N2N = "n2n";
	
	volatile IArea srcArea, srcModelFlagsArea,
			currentIdArea, idCorrespondencesArea1, idCorrespondencesArea2,
			trgArea, trgModelFlagsArea;
	
	public ReduceGraph(IArea srcArea, IArea srcModelFlagsArea,
			IArea currentIdArea, IArea idCorrespondencesArea1, IArea idCorrespondencesArea2,
			IArea trgArea, IArea trgModelFlagsArea) throws BlackboardException {
		this.srcArea = srcArea;
		this.srcModelFlagsArea = srcModelFlagsArea;
		this.currentIdArea = currentIdArea;
		this.idCorrespondencesArea1 = idCorrespondencesArea1;
		this.idCorrespondencesArea2 = idCorrespondencesArea2;
		this.trgArea = trgArea;
		this.trgModelFlagsArea = trgModelFlagsArea;
	}

	@Override
	public void transform(
			Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException, InterruptedException {
		List<IdentifiableElement> ies = new LinkedList<IdentifiableElement>();
		
		List<IdentifiableElement> idCorrespondances = new LinkedList<IdentifiableElement>(); 
				
		for (IdentifiableElement e : objs) {
			if (e instanceof Node){
				if(((Node) e).getSize()>5){
					String trgId = TraceFunction.create(e.getId(), N2N);
					Node n = new Node("", trgId, ((Node) e).getName(), ((Node) e).getType(), ((Node) e).getSize()); 
					ies.add(n);
				}
			} else if (e instanceof Edge) {
				Node n1 = (Node) readFromSource(((Edge) e).getSourceId());
				Node n2 = (Node) readFromSource(((Edge) e).getTargetId());
				if(n1!=null && n2!=null && n1.getSize()>5  && n2.getSize()>5){
//					System.out.println(e + " " + n1 + " " + n2);
					String trgId = TraceFunction.create(e.getId(),E2E);
					Edge edge = new Edge("", trgId,
							TraceFunction.resolve(trgId2Id(((Edge) e).getSourceId()), N2N),
							TraceFunction.resolve(trgId2Id(((Edge) e).getTargetId()), N2N));
					ies.add(edge);
				}
			}
		}
		
		Range rangeOfIds = requestRangeOfIds(ies.size());
		
		double id = rangeOfIds.getMinID();
		for (IdentifiableElement ie : ies){
			ie.setId(Double.toString(id));
			id++;
			idCorrespondances.add(new IdCorrespondence(ie.getTrgId(), Double.toString(id)));
		}
		
		idCorrespondencesArea2.writeAll(idCorrespondances);
		trgArea.writeAll(ies);
		updateModelFlags(rangeOfIds.getMaxID());
//		System.out.println("T2 wrote elems");
	}
	
	public void updateModelFlags(double id) throws BlackboardException, InterruptedException{
		/* every time the current id is updated, the maxId in the model area must be updated */
		ModelFlags modelFlags = takeModelFlags();
		if (modelFlags.getMaxIdStored()<id){
			modelFlags.setMaxIdStored(id);
		}
		trgModelFlagsArea.write(modelFlags);
		synchronized (this) {
		    notifyAll();
		}
	}
	
	private IdentifiableElement readFromSource(String trgId) throws BlackboardException, InterruptedException {
		String id = trgId2Id(trgId);
		if (id==null){
			System.out.println("No correspondance id found in correspondancesArea for trgId=" + trgId);
			return null; //element is not in the blackboard and it won't be
		} else {
			IdentifiableElement e = srcArea.read(id);
			
			if (e==null){
				ModelFlags maf = readModelFlags(srcModelFlagsArea);
				
				while (!maf.isComplete() && e==null){ // the element we are trying to read is not available yet
					synchronized (this) {
						wait();	
					}
					e = srcArea.read(id);
					maf = readModelFlags(srcModelFlagsArea);
				}
				
				if (maf.isComplete() && e==null){
					return null; //the element doesn't exist and it won't
				} else {
					return e;
				}
			} else {
				return e;
			}
		}
	}

	private String trgId2Id(String trgId) throws BlackboardException, InterruptedException {
		IdCorrespondence idC = (IdCorrespondence) idCorrespondencesArea1.read(trgId);
		if (idC==null){
			ModelFlags maf = readModelFlags(srcModelFlagsArea);
			while (!maf.isComplete() && idC == null){
				synchronized (this) {
					wait();
				}
				idC = (IdCorrespondence) idCorrespondencesArea1.read(trgId);
				maf = readModelFlags(srcModelFlagsArea);
			}
			if (maf.isComplete() && idC==null){
				return null; //the element doesn't exist and it won't
			} else {
				return idC.getNewId();
			}
		}
		return idC.getNewId();
	}
	
	private ModelFlags readModelFlags(IArea area) throws BlackboardException, InterruptedException {
		ModelFlags modelFlags = (ModelFlags)area.read(LinTraParameters.MODEL_FLAGS_ID);
		while (modelFlags==null){ //it might be null if it isn't in the Area because the agent(s) who is(are) loading the model is/are updating it
			modelFlags = (ModelFlags)area.read(LinTraParameters.MODEL_FLAGS_ID);
		}
		return modelFlags;
	}
	
	private Range requestRangeOfIds(int numberOfIds) throws BlackboardException, InterruptedException {
		CurrentId cid = (CurrentId) currentIdArea.take(LinTraParameters.CURRENT_AREA_ID); 
		while (cid == null){
			cid = (CurrentId) currentIdArea.take(LinTraParameters.CURRENT_AREA_ID);
		}
		double id0 = cid.getCurrentId();
		cid.increase(numberOfIds);
		Range r = new Range(id0, id0+numberOfIds-1);
		
		currentIdArea.write(cid);
//		System.out.println("T2 notifies");
//		notifyAll();
		return r;
	}
	
	private ModelFlags takeModelFlags() throws BlackboardException, InterruptedException {
		ModelFlags modelFlags = (ModelFlags)trgModelFlagsArea.take(LinTraParameters.MODEL_FLAGS_ID);
		while (modelFlags==null){ //it might be null if it isn't in the Area because the agent(s) who is(are) loading the model is/are updating it 
			synchronized (this) {
				wait();
			}
			modelFlags = (ModelFlags)trgModelFlagsArea.take(LinTraParameters.MODEL_FLAGS_ID);
		}
		return modelFlags;
	}
	
//	private String askForNewId() throws BlackboardException, InterruptedException {
//		if (rangeOfIds.getCurrent()>=rangeOfIds.getMaxID()){
//			rangeOfIds = requestRangeOfIds(rangeWidth);
//		}
//		String id = Double.toString(rangeOfIds.next());
//		return id;
//	}

}
