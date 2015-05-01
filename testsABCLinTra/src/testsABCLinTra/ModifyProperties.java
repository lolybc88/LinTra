package testsABCLinTra;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import abcMM.*;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.CurrentId;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.IdCorrespondence;
import transfo.LinTraParameters;
import transfo.Range;
import transfo.TraceFunction;

public class ModifyProperties implements ITransformation {

	private static final String BLINKED2C = "bLinked2C";
	private static final String A2AC = "a2ac";
	IArea srcArea, trgArea, currentIdArea, idCorrespondencesArea;
	
	public ModifyProperties(IArea srcArea, IArea trgArea, IArea currentIdArea, IArea correspondencesArea, IArea deletesArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
		this.currentIdArea = currentIdArea;
		this.idCorrespondencesArea = correspondencesArea;
	}

	@Override
	public void transform(Collection<IdentifiableElement> objs,
			IMaster masterNextTransfo) throws BlackboardException, InterruptedException {
		
		LinkedList<IdentifiableElement> createdElems = new LinkedList<IdentifiableElement>();
		LinkedList<IdentifiableElement> modifiedElems = new LinkedList<IdentifiableElement>();
		LinkedList<IdentifiableElement> deletedElems = new LinkedList<IdentifiableElement>();
		List<IdentifiableElement> idCorrespondances = new LinkedList<IdentifiableElement>();
		
		for (IdentifiableElement ie : objs){
			if (ie instanceof B){
				A a = (A) srcArea.read(((B) ie).getA());
				B b = new B(ie.getId(), TraceFunction.create(ie.getId(), BLINKED2C), ((B) ie).getName()+"new", a.getC(), ((B) ie).getA());
				modifiedElems.add(b);
			}
		}
		
		Range rangeOfIds = requestRangeOfIds(createdElems.size());
		for (IdentifiableElement ie : createdElems){
			String id = Double.toString(rangeOfIds.getCurrent());
			ie.setId(id);
			idCorrespondances.add(new IdCorrespondence(ie.getTrgId(), id));
			rangeOfIds.next();
		}
		idCorrespondencesArea.writeAll(idCorrespondances);
		trgArea.writeAll(createdElems);
		trgArea.writeAll(modifiedElems);		
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
		return r;
	}

}
