package testsABCLinTra;

import java.util.Collection;
import java.util.LinkedList;

import abcMM.*;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.IdCorrespondence;

public class StandardizeReferencesAndRemoveLinks implements ITransformation {

	/**
	 * The target model might have elements with references to another elements expressed either by its numeric identifier or by its target identifier
	 * - in the case that it points to an element that already existed, the reference uses the numeric id
	 * - in the case that it points to an element that has been created (that didn't exist in the source model), the reference uses the target id.
	 * This transformation standardizes the ids using the idCorrespondencesArea and set all the ids to the numeric id.
	 * 
	 * Furthermore, if the semantics for the deletion of elements implies that the references pointing to deleted elements must be
	 * removed from the target model automatically (i.e., the user doesn't need to specify explicitly that the reference is removed too),
	 * we have to do it once the transformation has been applied and all the deleted elements are known.
	 * 
	 * This second phase aims at solving these two things.
	 */
	
	IArea trgArea, idCorrespondencesArea, deletesArea;
	
	public StandardizeReferencesAndRemoveLinks(IArea trgArea, IArea idCorrespondencesArea, IArea deletesArea) {
		this.trgArea = trgArea;
		this.idCorrespondencesArea = idCorrespondencesArea;
		this.deletesArea = deletesArea;		
	}
	
	@Override
	public void transform(Collection<IdentifiableElement> objs,
			IMaster masterNextTransfo) throws BlackboardException,
			InterruptedException {
		
		LinkedList<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		
		for (IdentifiableElement ie : objs){
			if (ie instanceof A){
				// c
				String refC = ((A) ie).getC();
				if (refC!=null){
					String refCUpdated = normalizeRef(refC);
					if (refCUpdated!=null || !refC.equals(refCUpdated)){
						((A) ie).setC(refCUpdated);
						elems.add(ie);
					}
				}
			} else if (ie instanceof B){
				boolean updated = false;
				// c
				String refC = ((B) ie).getC();
				if (refC!=null){
					String refCUpdated = normalizeRef(refC);
					((B) ie).setC(refCUpdated);
					updated=true;
				}
				
				//a
				String refA = ((B) ie).getA();
				if (refA!=null){
					String refAUpdated = normalizeRef(refA);
					((B) ie).setA(refAUpdated);
					updated=true;
				}
				
				if (updated){
					elems.add(ie);
				}
			}			
		}
		trgArea.writeAll(elems);
	}

	private String normalizeRef(String id) throws BlackboardException {
		if (deletesArea.read(id)!=null){
			// the element this reference points to has been deleted
			return null;
		} else {
			IdCorrespondence idC = (IdCorrespondence) idCorrespondencesArea.read(id);
			if (idC != null){
				return idC.getNewId();
			}
		}
		return id;
	}
}
