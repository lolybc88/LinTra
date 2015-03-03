package transformations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

import prefuseGraphInJava.Edge;
import javaMMinJava.*;
import javaMMinJava.Package;
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

public class Java2PrefuseGraph implements ITransformation {
	
	private static final String TO_EDGE = "toEdge";
	private static final String TO_NODE = "toNode";
	
	 IArea srcArea, srcModelFlagsArea, currentIdArea, idCorrespondencesArea, trgArea, trgModelFlagsArea;
	 ITransformation nextTransfo;

	public Java2PrefuseGraph(IArea srcArea, IArea srcModelFlagsArea,
			IArea currentIdArea, IArea idCorrespondencesArea,
			IArea trgArea, IArea trgModelFlagsArea, ITransformation nextTransfo) throws BlackboardException {
		this.srcArea = srcArea;
		this.srcModelFlagsArea = srcModelFlagsArea;
		this.currentIdArea = currentIdArea;
		this.idCorrespondencesArea = idCorrespondencesArea;
		this.trgArea = trgArea;
		this.trgModelFlagsArea = trgModelFlagsArea;
		this.nextTransfo = nextTransfo;
		
	}

	@Override
	public void transform(
			Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException, InterruptedException {
		
		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		
		List<IdentifiableElement> idCorrespondances = new LinkedList<IdentifiableElement>(); 
		
		for (IdentifiableElement ie : objs){
			
			if (ie instanceof javaMMinJava.ClassDeclaration){
				javaMMinJava.ClassDeclaration cd = (javaMMinJava.ClassDeclaration)ie;
				
				javaMMinJava.Package rootPackage = getRootPackage(cd);
				if (rootPackage==null || !rootPackage.getName().equals("java")){ //ignore the classes from Java such as Collection, String, etc.
					
						String trgId = TraceFunction.create(cd.getId(), TO_NODE);
						
						String mod = obtainType(cd);
						double size = computeSize(cd);
						
						prefuseGraphInJava.Node node = new prefuseGraphInJava.Node("", trgId, cd.getName(), mod, size);
						elems.add(node);
						
				}
			} else if (ie instanceof javaMMinJava.FieldDeclaration){
				String typeAccess = ((FieldDeclaration) ie).getTypeID();		
				
				if (typeAccess!=null){
					javaMMinJava.TypeAccess ta = (TypeAccess) readFromSource(typeAccess);
					
					if (ta!=null && ta.getType()!=null){
						String typeId = ta.getType();
	
						IdentifiableElement el = readFromSource(typeId);
						if (el instanceof IType){
							javaMMinJava.IType t = (IType) el; 
						
							if (t instanceof javaMMinJava.ClassDeclaration) {
								
								javaMMinJava.Package rootPackage = getRootPackage((ClassDeclaration)t);
								if (rootPackage==null || !rootPackage.getName().equals("java")){ //ignore the classes from Java such as Collection, String, etc.
									
									String atdId = ((javaMMinJava.FieldDeclaration) ie).getAbstractTypeDeclaration();
									if (atdId != null){
										IdentifiableElement atd = readFromSource(atdId);
										
										if (atd instanceof javaMMinJava.ClassDeclaration){
											
											javaMMinJava.Package rootPackage2 = getRootPackage((ClassDeclaration)atd);
											if (rootPackage2==null || !rootPackage2.getName().equals("java")){ 
												
												String trgId = TraceFunction.create(ie.getId(), TO_EDGE);
												prefuseGraphInJava.Edge edge = new Edge("", trgId,
														TraceFunction.resolve(atd.getId(), TO_NODE),
														TraceFunction.resolve(((javaMMinJava.ClassDeclaration) t).getId(), TO_NODE));
												elems.add(edge);
												
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		Range rangeOfIds = requestRangeOfIds(elems.size());
		for (IdentifiableElement ie : elems){
			String id = Double.toString(rangeOfIds.getCurrent());
			ie.setId(id);
			idCorrespondances.add(new IdCorrespondence(ie.getTrgId(), id));
			rangeOfIds.next();
		}
		
		idCorrespondencesArea.writeAll(idCorrespondances);
		trgArea.writeAll(elems);
		updateModelFlags(rangeOfIds.getMaxID());
		
		if (!LinTraParameters.T1_AND_THEN_T2) {
			notifyMaster(masterNextTransfo);
			notifyNextTransfo();
		}
	}

	private double computeSize(ClassDeclaration cd) throws BlackboardException, InterruptedException {
		double size = 1.0;
		String[] bdIds = cd.getBodyDeclarations();
		for(String id : bdIds){
			IdentifiableElement ie = readFromSource(id);
			if (ie instanceof javaMMinJava.FieldDeclaration){
				size++;
			}
		}
		return size;
	}

	private String obtainType(javaMMinJava.ClassDeclaration cd)
			throws BlackboardException, InterruptedException {
		
		String modId = cd.getModifier();
		Modifier mod = null;
		if (modId!=null && !modId.equals("")){
			mod = (Modifier) readFromSource(modId);
		}
		
		if (mod!=null){
			if (mod.getInheritance().equals("final")){
				return "F";
			} else if (mod.getInheritance().equals("abstract")){
				return "A";
			} else { // mod.getInheritance().equals("none")
				return "N";
			}
		} else {
			return "N";	
		}
	}
	
	private void notifyNextTransfo() {
		synchronized (nextTransfo) {
//			System.out.println("T1 notifies T2");
			nextTransfo.notifyAll();			
		}
	}

	private void notifyMaster(IMaster masterNextTransfo) {
		if (masterNextTransfo!=null) {
			synchronized (masterNextTransfo) {
//				System.out.println("T1 notifies master T2");
				masterNextTransfo.notifyAll();
			}
		}
	}

	private Range requestRangeOfIds(int numberOfIds) throws BlackboardException, InterruptedException {
		CurrentId cid = (CurrentId) currentIdArea.take(LinTraParameters.MODEL_FLAGS_ID); 
		while (cid == null){
//			System.out.println("T1 waiting");
			//wait();
//			System.out.println("T1 awakes");
			cid = (CurrentId) currentIdArea.take(LinTraParameters.MODEL_FLAGS_ID);
		}
		double id0 = cid.getCurrentId();
		cid.increase(numberOfIds);
		Range r = new Range(id0, id0+numberOfIds-1);
		
		currentIdArea.write(cid);
//		System.out.println("T1 notifies");
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
//			rangeOfIds = requestRangeOfIds(LinTraParameters.RANGE_OF_IDS_WIDTH);
////			System.out.println(Thread.currentThread().getId() + " !!!!"+rangeOfIds);
//		}
//		double id = rangeOfIds.next();
//		String idS = Double.toString(id); 
//		if (id==-1){
//			return askForNewId();
//		}
//		return idS;
//	}
	
//	private String askForNewId() throws BlackboardException, InterruptedException {
//		currentIdSem.acquire();
//		
//		double id = currentId;
//		currentId++;
//		
//		currentIdSem.release();
//		return Double.toString(id);
//	}
	
//	private String askForNewId_v2() throws BlackboardException, InterruptedException {
//		
//		double id = currentId;
//		currentId++;
//
//		return Double.toString(id);
//	}

	private void updateModelFlags(double maxId) throws BlackboardException,
			InterruptedException {
		ModelFlags modelFlags = takeModelFlags();
		if (modelFlags.getMaxIdStored()<maxId){
			modelFlags.setMaxIdStored(maxId);
		}
		trgModelFlagsArea.write(modelFlags);
		synchronized (this) {
			notifyAll();
		}
	}

	private javaMMinJava.Package getRootPackage(ClassDeclaration cd) throws BlackboardException, InterruptedException{
		String pId = cd.getPackage();
		if (cd.getPackage()!=null){
			javaMMinJava.Package p = (Package) readFromSource(pId);
			while (p!=null && p.getPackage()!=null){
				pId = p.getPackage();
				p = (Package) readFromSource(pId);
			}
			return p;
		} else {
			return null;
		}
	}
	
	private IdentifiableElement readFromSource(String id) throws BlackboardException, InterruptedException {
		
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

	private ModelFlags readModelFlags(IArea area) throws BlackboardException, InterruptedException {
		ModelFlags modelFlags = (ModelFlags)area.read(LinTraParameters.MODEL_FLAGS_ID);
		while (modelFlags==null){ //it might be null if it isn't in the Area because the agent(s) who is(are) loading the model is/are updating it
			modelFlags = (ModelFlags)area.read(LinTraParameters.MODEL_FLAGS_ID);
		}
		return modelFlags;
	}

}
