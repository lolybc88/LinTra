package transformations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javaMMinJava.ClassDeclaration;
import javaMMinJava.CompilationUnit;
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

public class JavaTests_NoChain implements ITransformation {

	private static final String TO_EDGE = "toEdge";
	private static final String TO_NODE = "toNode";
	
	IArea srcArea, trgArea;

	public JavaTests_NoChain(IArea srcArea, IArea trgArea)
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
			
			if (ie instanceof javaMMinJava.Annotation) {
//				System.out.println(ie.toString());
				String typeId = ((javaMMinJava.Annotation) ie).getType();
				javaMMinJava.TypeAccess annotationTypeAccess = (TypeAccess) srcArea.read(typeId);
//				System.out.println("\t" + annotationTypeAccess);
				IdentifiableElement annotationType = srcArea.read(annotationTypeAccess.getType());
				
				if (annotationType.toString().contains("Singleton")){
//					System.out.println(ie);
//					System.out.println("\t"+annotationTypeAccess);
//					System.out.println("\t\t"+annotationType);
					
					String compUnitId = ((javaMMinJava.Annotation) ie).getOriginalCompilationUnit();
					javaMMinJava.CompilationUnit compUnit = (javaMMinJava.CompilationUnit) srcArea.read(compUnitId);
					System.out.println(compUnit);
					
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
