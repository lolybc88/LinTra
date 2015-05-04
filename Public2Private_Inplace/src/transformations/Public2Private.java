package transformations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javaMMinJava.*;
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

public class Public2Private implements ITransformation {
	
	private static final String PUBLIC2PRIVATE = "public2private";
	private static final String NONE = "none";
	private static final String PROTECTED = "protected";
	private static final String PUBLIC = "public";
	private static final String PRIVATE = "private";
	
	private IArea srcArea, trgArea, currentIdArea, idCorrespondencesArea, deletesArea;
	
	public Public2Private(IArea srcArea, IArea trgArea, IArea currentIdArea, IArea correspondencesArea, IArea deletesArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
		this.currentIdArea = currentIdArea;
		this.idCorrespondencesArea = correspondencesArea;
		this.deletesArea = deletesArea;
	}

	@Override
	public void transform(Collection<blackboard.IdentifiableElement> objs,
			IMaster masterNextTransfo) throws blackboard.BlackboardException,
			InterruptedException {
		
		/**
		 * The ATL refining execution mode transforms the elements identified by the source patterns according to the behaviour
		 * defined in the rules. Those model elements that are not explicitly affected by the rules (either directly or indirectly)
		 * remain unchanged.
		 * 
		 * Two options: 
		 * 
		 * 1) Write in the output model the elements that has been altered by the transfo and then copy the rest of the elements
		 *  
		 * 2) The target model is a copy of the source model, the source model is navigated but the updates are made in the target
		 * model.
		 * 
		 * Should we follow the second approach in LinTra? The elements have the same identifiers in both models so, although we
		 * the source model is navigated and the target updated, we know the correspondences).
		 * The advantage of this second approach is that we don't have to keep track to the elements that haven't been altered.
		 * -> If we follow this approach, how to deal with the creation of new elements?
		 * -> The deletion of elements leaves gaps in the identifiers of the output model preventing the application of MT chains.
		 *  
		 */
		
		LinkedList<IdentifiableElement> createdElems = new LinkedList<IdentifiableElement>();
		LinkedList<IdentifiableElement> modifiedElems = new LinkedList<IdentifiableElement>();
		LinkedList<IdentifiableElement> deletedElems = new LinkedList<IdentifiableElement>();
		
		List<IdentifiableElement> idCorrespondances = new LinkedList<IdentifiableElement>();
		
		for (IdentifiableElement ie : objs){
			if (ie instanceof Comment){
				deletedElems.add(ie);
			}
			else if (ie instanceof javaMMinJava.FieldDeclaration){
				String[] fragmentsIds = ((javaMMinJava.FieldDeclaration) ie).getFragmentsID();
				
				String mId = ((javaMMinJava.FieldDeclaration) ie).getModifier();
				if (mId!=null){
					javaMMinJava.Modifier mod = (Modifier) srcArea.read(mId);
					if (mod!=null){
						String visibility = mod.getVisibility();
						if (visibility.equals(PUBLIC)){
							
							// Modify the visibility 
							mod.setVisibility(PRIVATE);
							modifiedElems.add(mod);
				
				
							for (String fragmentId : fragmentsIds){
								
								javaMMinJava.VariableDeclarationFragment fragment = (javaMMinJava.VariableDeclarationFragment) srcArea.read(fragmentId);
					
								// Create the getter
								SingleVariableAccess singleVarAccess = new SingleVariableAccess("", null, null, null, fragment.getId(), null);
								singleVarAccess.setTrgId(TraceFunction.create(ie.getId(), 2, PUBLIC2PRIVATE));
								
								javaMMinJava.ReturnStatement returnS = new ReturnStatement("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null, singleVarAccess.getTrgId());
								returnS.setTrgId(TraceFunction.create(ie.getId(), 3, PUBLIC2PRIVATE));
								
								TypeAccess ta = new TypeAccess("", null, null, null, ((javaMMinJava.FieldDeclaration) ie).getTypeID(), null);
								ta.setTrgId(TraceFunction.create(ie.getId(), 4, PUBLIC2PRIVATE));
								
								javaMMinJava.Block block = new Block("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null, new String[] { returnS.getTrgId() });
								block.setTrgId(TraceFunction.create(ie.getId(), 5, PUBLIC2PRIVATE));
								
								String getterMethTrgId = TraceFunction.create(ie.getId(), 6, PUBLIC2PRIVATE); 
								String getterModTrgId = TraceFunction.create(ie.getId(), 1, PUBLIC2PRIVATE);
								
								javaMMinJava.MethodDeclaration getterMeth = new MethodDeclaration("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null,"get"+fragment.getName(),
										false, null, ((javaMMinJava.FieldDeclaration) ie).getAbstractTypeDeclaration(), null, ((javaMMinJava.FieldDeclaration) ie).getAnonymousClassDeclarationOwner(), getterModTrgId, block.getTrgId(), null, null, null, null, null, 0,  ta.getTrgId(), null, null);
								getterMeth.setTrgId(getterMethTrgId);
								
								javaMMinJava.Modifier getterMod = new Modifier("", null, null, null, PUBLIC, "none", mod.getStatic(), mod.getTransient(), mod.getVolatile(), mod.getNative(), mod.getStrictfp(), mod.getSynchronized(), getterMethTrgId, null, null, null);
								getterMod.setTrgId(getterModTrgId);
								
								createdElems.add(getterMod); createdElems.add(singleVarAccess); createdElems.add(returnS); createdElems.add(ta); createdElems.add(block); createdElems.add(getterMeth);
								
								// Create the setter
								SingleVariableAccess singleVarAccess2 = new SingleVariableAccess("", null, null, null, fragmentId, null);
								singleVarAccess2.setTrgId(TraceFunction.create(ie.getId(), 8, PUBLIC2PRIVATE));
								
								ThisExpression thisExpr = new ThisExpression("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null, null);
								thisExpr.setTrgId(TraceFunction.create(ie.getId(), 9, PUBLIC2PRIVATE));
								
								FieldAccess fieldAccess = new FieldAccess("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null, singleVarAccess2.getTrgId(), thisExpr.getTrgId());
								fieldAccess.setTrgId(TraceFunction.create(ie.getId(), 10, PUBLIC2PRIVATE));
								//
								
								SingleVariableAccess singleVarAccess3 = new SingleVariableAccess("", null, null, null, fragmentId, null);
								singleVarAccess3.setTrgId(TraceFunction.create(ie.getId(), 11, PUBLIC2PRIVATE));
								
								Assignment assign = new Assignment("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null, singleVarAccess3.getTrgId(), "=", fieldAccess.getTrgId());
								assign.setTrgId(TraceFunction.create(ie.getId(), 12, PUBLIC2PRIVATE));
								// 
							
								ExpressionStatement exprStat = new ExpressionStatement("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null, assign.getTrgId());
								exprStat.setTrgId(TraceFunction.create(ie.getId(), 13, PUBLIC2PRIVATE));

								javaMMinJava.Block block2 = new Block("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null, new String[] { exprStat.getTrgId() });
								block2.setTrgId(TraceFunction.create(ie.getId(), 14, PUBLIC2PRIVATE));
								
								String setterMethTrgId = TraceFunction.create(ie.getId(), 15, PUBLIC2PRIVATE);
								String setterModTrgId = TraceFunction.create(ie.getId(), 16, PUBLIC2PRIVATE); 
								javaMMinJava.Modifier setterMod = new Modifier("", null, null, null, PUBLIC, "none", mod.getStatic(), mod.getTransient(), mod.getVolatile(), mod.getNative(), mod.getStrictfp(), mod.getSynchronized(), setterMethTrgId, null, null, null);
								setterMod.setTrgId(setterModTrgId);
								
								javaMMinJava.MethodDeclaration setterMeth = new MethodDeclaration("", null, ((javaMMinJava.FieldDeclaration) ie).getOriginalCompilationUnit(), null,"set"+((javaMMinJava.FieldDeclaration) ie).getName(),
										false, null, ((javaMMinJava.FieldDeclaration) ie).getAbstractTypeDeclaration(), null, ((javaMMinJava.FieldDeclaration) ie).getAnonymousClassDeclarationOwner(), setterModTrgId, block2.getTrgId(), null, null, null, null, null, 0, ((javaMMinJava.FieldDeclaration) ie).getTypeID(), null, null);
								setterMeth.setTrgId(setterMethTrgId);
								
								createdElems.add(singleVarAccess2); createdElems.add(thisExpr); createdElems.add(fieldAccess); createdElems.add(singleVarAccess3); createdElems.add(assign);
								createdElems.add(exprStat); createdElems.add(block2); createdElems.add(setterMod); createdElems.add(setterMeth); 
					
							}
						}
					}
				}
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
		trgArea.takeAll(ids(deletedElems));
		deletesArea.writeAll(deletedElems);
		
	}
	
	private Collection<String> ids(LinkedList<IdentifiableElement> deletedElems) {
		LinkedList<String> ids = new LinkedList<String>();
		for (IdentifiableElement ie : deletedElems){
			ids.add(ie.getId());
		}
		return ids;
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
