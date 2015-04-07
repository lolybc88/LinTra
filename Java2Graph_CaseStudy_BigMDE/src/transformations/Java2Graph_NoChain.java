package transformations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javaMMinJava.ClassDeclaration;
import javaMMinJava.FieldDeclaration;
import javaMMinJava.IType;
import javaMMinJava.Modifier;
import javaMMinJava.Package;
import javaMMinJava.TypeAccess;

import prefuseGraphInJava.Edge;
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

public class Java2Graph_NoChain implements ITransformation {

	private static final String TO_EDGE = "toEdge";
	private static final String TO_NODE = "toNode";
	
	IArea srcArea, trgArea;

	public Java2Graph_NoChain(IArea srcArea, IArea trgArea)
			throws BlackboardException {
		this.srcArea = srcArea;
		this.trgArea = trgArea;

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
		
		for (IdentifiableElement ie : elems) {
			ie.setId(ie.getTrgId());
		}
		trgArea.writeAll(elems);
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
		return e;
		
	}

}
