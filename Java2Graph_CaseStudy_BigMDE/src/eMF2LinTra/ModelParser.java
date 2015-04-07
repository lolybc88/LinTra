package eMF2LinTra;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javaMM.JavaMMFactory;
import javaMM.JavaMMPackage;
import javaMM.Model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import blackboard.IdentifiableElement;

public class ModelParser {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		eMFModel2LinTraModel("C:/Users/Atenea/Desktop/eclipseModel/eclipseModels2",
				"C:/Users/Atenea/Desktop/eclipseModel/eclipseModel-4.ser");
//		joinEMFModels("C:/Users/Atenea/Desktop/eclipseModel/eclipseModels2", "eclipseModel-all.xmi");
		
		System.out.println("\nDone!");
	}
	
	public static void eMFModel2LinTraModel(String folderPath, String modelPath) throws IOException {
		List<Model> models = getEMFModels(folderPath);
		@SuppressWarnings("unchecked")
		Map<EObject, String> map = createObjects2IdsMap((List<EObject>) (List<?>) models);
		List<IdentifiableElement> elems = createJavaObjects(models, map);
		System.out.println("#elems: "+elems.size());
		
		writeSer(elems, modelPath);
	}
	
	public static void joinEMFModels(String folderPath, String modelName) throws IOException {
		
		JavaMMPackage.eINSTANCE.eClass();
	    JavaMMFactory factory = JavaMMFactory.eINSTANCE;
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("*", new XMIResourceFactoryImpl());
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.createResource(URI.createURI("xmiModels/"+modelName));
		
		List<Model> models = getEMFModels(folderPath);
		
		for (Model model : models){
			System.out.println(model.getName());
			resource.getContents().add(model);
		}
		resource.save(Collections.EMPTY_MAP);
	    
	}

	public static Model getEMFModel(String pathXMI) throws IOException {
		JavaMMPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(pathXMI), true);
		javaMM.Model javaModel = (javaMM.Model) resource.getContents().get(0);
		return javaModel;
	}

	public static List<Model> getEMFModels(String folderPath)
			throws IOException {
		List<Model> models = new LinkedList<Model>();
		File folder = new File(folderPath);
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				models.add(getEMFModel("file:" + folderPath + "/" + fileEntry.getName()));
			}
		}
		return models;
	}

	private static void writeSer(List<IdentifiableElement> elems, String path)
			throws IOException {
		FileOutputStream saveFile = new FileOutputStream(path);
		ObjectOutputStream save = new ObjectOutputStream(saveFile);
		for (IdentifiableElement o : elems) {
			save.writeObject(o);
		}
		save.close();
	}

	private static List<IdentifiableElement> createJavaObjects(
			List<Model> models, Map<EObject, String> map) {
		List<IdentifiableElement> jObjects = new LinkedList<IdentifiableElement>();
		for (Model m : models) {
			jObjects.addAll(createJavaObjectsRecursive(m, map));
		}
		return jObjects;
	}

	static int elemsXMI = 0;

	private static List<IdentifiableElement> createJavaObjectsRecursive(
			EObject elem, Map<EObject, String> map) {
		IdentifiableElement jo = transformEMF2Java(elem, map);
		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		elemsXMI++;
		elems.add(jo);
		if (elem.eAllContents() != null) {
			for (EObject o : elem.eContents()) {
				elems.addAll(createJavaObjectsRecursive(o, map));
			}
		}
		return elems;
	}

	@SuppressWarnings("unchecked")
	private static IdentifiableElement transformEMF2Java(EObject elem,
			Map<EObject, String> map) {

		if (elem instanceof javaMM.Annotation) {
			javaMM.Annotation e = (javaMM.Annotation) elem;
			return new javaMMinJava.Annotation(map.get(e),
					e.getComments().get(0),
					e.getOriginalCompilationUnit(),
					e.getOriginalClassFile(),
					e.getType(),
					e.getValues().get(0));
		}
		if (elem instanceof javaMM.Archive) {
			javaMM.Archive e = (javaMM.Archive) elem;
			return new javaMMinJava.Archive(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), e.getOriginalFilePath(),
					toIds((EList<EObject>) (EList<?>) e.getClassFiles(), map),
					map.get(e.getManifest()));
		}
		if (elem instanceof javaMM.AssertStatement) {
			javaMM.AssertStatement e = (javaMM.AssertStatement) elem;
			return new javaMMinJava.AssertStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getMessage()),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.AnnotationMemberValuePair) {
			javaMM.AnnotationMemberValuePair e = (javaMM.AnnotationMemberValuePair) elem;
			return new javaMMinJava.AnnotationMemberValuePair(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getMember()), map.get(e.getValue()));
		}
		if (elem instanceof javaMM.AnnotationTypeDeclaration) {
			javaMM.AnnotationTypeDeclaration e = (javaMM.AnnotationTypeDeclaration) elem;
			return new javaMMinJava.AnnotationTypeDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map));
		}
		if (elem instanceof javaMM.AnnotationTypeMemberDeclaration) {
			javaMM.AnnotationTypeMemberDeclaration e = (javaMM.AnnotationTypeMemberDeclaration) elem;
			return new javaMMinJava.AnnotationTypeMemberDeclaration(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), map.get(e.getDefault()), map.get(e
							.getType()), toIds(
							(EList<EObject>) (EList<?>) e.getUsages(), map));
		}
		if (elem instanceof javaMM.AnonymousClassDeclaration) {
			javaMM.AnonymousClassDeclaration e = (javaMM.AnonymousClassDeclaration) elem;
			return new javaMMinJava.AnonymousClassDeclaration(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map), map.get(e.getClassInstanceCreation()));
		}
		if (elem instanceof javaMM.ArrayAccess) {
			javaMM.ArrayAccess e = (javaMM.ArrayAccess) elem;
			return new javaMMinJava.ArrayAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getArray()),
					map.get(e.getIndex()));
		}
		if (elem instanceof javaMM.ArrayCreation) {
			javaMM.ArrayCreation e = (javaMM.ArrayCreation) elem;
			return new javaMMinJava.ArrayCreation(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					toIds((EList<EObject>) (EList<?>) e.getDimensions(), map),
					map.get(e.getInitializer()), map.get(e.getType()));
		}
		if (elem instanceof javaMM.ArrayInitializer) {
			javaMM.ArrayInitializer e = (javaMM.ArrayInitializer) elem;
			return new javaMMinJava.ArrayInitializer(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					toIds((EList<EObject>) (EList<?>) e.getExpressions(), map));
		}
		if (elem instanceof javaMM.ArrayLengthAccess) {
			javaMM.ArrayLengthAccess e = (javaMM.ArrayLengthAccess) elem;
			return new javaMMinJava.ArrayLengthAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getArray()));
		}
		if (elem instanceof javaMM.ArrayType) {
			javaMM.ArrayType e = (javaMM.ArrayType) elem;
			return new javaMMinJava.ArrayType(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map), e.getDimensions(),
					map.get(e.getElementType()));
		}
		if (elem instanceof javaMM.Assignment) {
			javaMM.Assignment e = (javaMM.Assignment) elem;
			return new javaMMinJava.Assignment(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e
							.getLeftHandSide()), e.getOperator().getLiteral(),
					map.get(e.getRightHandSide()));
		}
		if (elem instanceof javaMM.BooleanLiteral) {
			javaMM.BooleanLiteral e = (javaMM.BooleanLiteral) elem;
			return new javaMMinJava.BooleanLiteral(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.isValue());
		}
		if (elem instanceof javaMM.BlockComment) {
			javaMM.BlockComment e = (javaMM.BlockComment) elem;
			return new javaMMinJava.BlockComment(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getContent(),
					e.isEnclosedByParent(), e.isPrefixOfParent());
		}
		if (elem instanceof javaMM.Block) {
			javaMM.Block e = (javaMM.Block) elem;
			return new javaMMinJava.Block(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), toIds(
							(EList<EObject>) (EList<?>) e.getStatements(), map));
		}
		if (elem instanceof javaMM.BreakStatement) {
			javaMM.BreakStatement e = (javaMM.BreakStatement) elem;
			return new javaMMinJava.BreakStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getLabel()));
		}
		if (elem instanceof javaMM.CastExpression) {
			javaMM.CastExpression e = (javaMM.CastExpression) elem;
			return new javaMMinJava.CastExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()), map.get(e.getType()));
		}
		if (elem instanceof javaMM.CatchClause) {
			javaMM.CatchClause e = (javaMM.CatchClause) elem;
			return new javaMMinJava.CatchClause(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getException()), map.get(e.getBody()));
		}
		if (elem instanceof javaMM.CharacterLiteral) {
			javaMM.CharacterLiteral e = (javaMM.CharacterLiteral) elem;
			return new javaMMinJava.CharacterLiteral(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getEscapedValue());
		}
		if (elem instanceof javaMM.ClassFile) {
			javaMM.ClassFile e = (javaMM.ClassFile) elem;
			return new javaMMinJava.ClassFile(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), e.getOriginalFilePath(),
					map.get(e.getType()), map.get(e.getAttachedSource()),
					map.get(e.getPackage()));
		}
		if (elem instanceof javaMM.ClassInstanceCreation) {
			javaMM.ClassInstanceCreation e = (javaMM.ClassInstanceCreation) elem;
			return new javaMMinJava.ClassInstanceCreation(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					map.get(e.getMethod()),
					toIds((EList<EObject>) (EList<?>) e.getArguments(), map),
					toIds((EList<EObject>) (EList<?>) e.getTypeArguments(), map),
					map.get(e.getAnonymousClassDeclaration()), map.get(e
							.getExpression()), map.get(e.getType()));
		}
		if (elem instanceof javaMM.ConstructorDeclaration) {
			javaMM.ConstructorDeclaration e = (javaMM.ConstructorDeclaration) elem;
			return new javaMMinJava.ConstructorDeclaration(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), map.get(e.getBody()),
					toIds((EList<EObject>) (EList<?>) e.getParameters(), map),
					toIds((EList<EObject>) (EList<?>) e.getThrownExceptions(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getTypeParameters(),
							map),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInDocComments(), map), toIds(
							(EList<EObject>) (EList<?>) e.getUsages(), map));
		}
		if (elem instanceof javaMM.ConditionalExpression) {
			javaMM.ConditionalExpression e = (javaMM.ConditionalExpression) elem;
			return new javaMMinJava.ConditionalExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e
							.getElseExpression()), map.get(e.getExpression()),
					map.get(e.getThenExpression()));
		}
		if (elem instanceof javaMM.ConstructorInvocation) {
			javaMM.ConstructorInvocation e = (javaMM.ConstructorInvocation) elem;
			return new javaMMinJava.ConstructorInvocation(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					map.get(e.getMethod()),
					toIds((EList<EObject>) (EList<?>) e.getArguments(), map),
					toIds((EList<EObject>) (EList<?>) e.getTypeArguments(), map));
		}
		if (elem instanceof javaMM.ClassDeclaration) {
			javaMM.ClassDeclaration e = (javaMM.ClassDeclaration) elem;
			return new javaMMinJava.ClassDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getTypeParameters(),
							map), map.get(e.getSuperClass()));
		}
		if (elem instanceof javaMM.CompilationUnit) {
			javaMM.CompilationUnit e = (javaMM.CompilationUnit) elem;
			return new javaMMinJava.CompilationUnit(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), e.getOriginalFilePath(),
					toIds((EList<EObject>) (EList<?>) e.getCommentList(), map),
					toIds((EList<EObject>) (EList<?>) e.getImports(), map),
					map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getTypes(), map));
		}
		if (elem instanceof javaMM.ContinueStatement) {
			javaMM.ContinueStatement e = (javaMM.ContinueStatement) elem;
			return new javaMMinJava.ContinueStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getLabel()));
		}
		if (elem instanceof javaMM.DoStatement) {
			javaMM.DoStatement e = (javaMM.DoStatement) elem;
			return new javaMMinJava.DoStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()), map.get(e.getBody()));
		}
		if (elem instanceof javaMM.EmptyStatement) {
			javaMM.EmptyStatement e = (javaMM.EmptyStatement) elem;
			return new javaMMinJava.EmptyStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()));
		}
		if (elem instanceof javaMM.EnhancedForStatement) {
			javaMM.EnhancedForStatement e = (javaMM.EnhancedForStatement) elem;
			return new javaMMinJava.EnhancedForStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getBody()),
					map.get(e.getExpression()), map.get(e.getParameter()));
		}
		if (elem instanceof javaMM.EnumConstantDeclaration) {
			javaMM.EnumConstantDeclaration e = (javaMM.EnumConstantDeclaration) elem;
			return new javaMMinJava.EnumConstantDeclaration(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), e.getExtraArrayDimensions(),
					map.get(e.getInitializer()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsageInVariableAccess(), map), map.get(e
							.getAnonymousClassDeclaration()), toIds(
							(EList<EObject>) (EList<?>) e.getArguments(), map));
		}
		if (elem instanceof javaMM.EnumDeclaration) {
			javaMM.EnumDeclaration e = (javaMM.EnumDeclaration) elem;
			return new javaMMinJava.EnumDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getEnumConstants(),
							map));
		}
		if (elem instanceof javaMM.ExpressionStatement) {
			javaMM.ExpressionStatement e = (javaMM.ExpressionStatement) elem;
			return new javaMMinJava.ExpressionStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.FieldAccess) {
			javaMM.FieldAccess e = (javaMM.FieldAccess) elem;
			return new javaMMinJava.FieldAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getField()),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.FieldDeclaration) {
			javaMM.FieldDeclaration e = (javaMM.FieldDeclaration) elem;
			return new javaMMinJava.FieldDeclaration(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), map.get(e.getType()), toIds(
							(EList<EObject>) (EList<?>) e.getFragments(), map));
		}
		if (elem instanceof javaMM.ForStatement) {
			javaMM.ForStatement e = (javaMM.ForStatement) elem;
			return new javaMMinJava.ForStatement(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					map.get(e.getExpression()),
					toIds((EList<EObject>) (EList<?>) e.getUpdaters(), map),
					toIds((EList<EObject>) (EList<?>) e.getInitializers(), map),
					map.get(e.getBody()));
		}
		if (elem instanceof javaMM.IfStatement) {
			javaMM.IfStatement e = (javaMM.IfStatement) elem;
			return new javaMMinJava.IfStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()), map.get(e.getThenStatement()),
					map.get(e.getElseStatement()));
		}
		if (elem instanceof javaMM.ImportDeclaration) {
			javaMM.ImportDeclaration e = (javaMM.ImportDeclaration) elem;
			return new javaMMinJava.ImportDeclaration(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.isStatic(), map.get(e
							.getImportedElement()));
		}
		if (elem instanceof javaMM.InfixExpression) {
			javaMM.InfixExpression e = (javaMM.InfixExpression) elem;
			return new javaMMinJava.InfixExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getOperator()
							.getLiteral(), map.get(e.getRightOperand()),
					map.get(e.getLeftOperand()),
					toIds((EList<EObject>) (EList<?>) e.getExtendedOperands(),
							map));
		}
		if (elem instanceof javaMM.Initializer) {
			javaMM.Initializer e = (javaMM.Initializer) elem;
			return new javaMMinJava.Initializer(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), map.get(e.getBody()));
		}
		if (elem instanceof javaMM.InstanceofExpression) {
			javaMM.InstanceofExpression e = (javaMM.InstanceofExpression) elem;
			return new javaMMinJava.InstanceofExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e
							.getRightOperand()), map.get(e.getLeftOperand()));
		}
		if (elem instanceof javaMM.InterfaceDeclaration) {
			javaMM.InterfaceDeclaration e = (javaMM.InterfaceDeclaration) elem;
			return new javaMMinJava.InterfaceDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getTypeParameters(),
							map));
		}
		if (elem instanceof javaMM.Javadoc) {
			javaMM.Javadoc e = (javaMM.Javadoc) elem;
			return new javaMMinJava.Javadoc(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getContent(),
					e.isEnclosedByParent(), e.isPrefixOfParent(), toIds(
							(EList<EObject>) (EList<?>) e.getTags(), map));
		}
		if (elem instanceof javaMM.LabeledStatement) {
			javaMM.LabeledStatement e = (javaMM.LabeledStatement) elem;
			return new javaMMinJava.LabeledStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getBody()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInBreakStatements(), map),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInContinueStatements(), map));
		}
		if (elem instanceof javaMM.LineComment) {
			javaMM.LineComment e = (javaMM.LineComment) elem;
			return new javaMMinJava.LineComment(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getContent(),
					e.isEnclosedByParent(), e.isPrefixOfParent());
		}
		if (elem instanceof javaMM.Manifest) {
			javaMM.Manifest e = (javaMM.Manifest) elem;
			return new javaMMinJava.Manifest(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getMainAttributes(), map),
					toIds((EList<EObject>) (EList<?>) e.getEntryAttributes(),
							map));
		}
		if (elem instanceof javaMM.ManifestAttribute) {
			javaMM.ManifestAttribute e = (javaMM.ManifestAttribute) elem;
			return new javaMMinJava.ManifestAttribute(map.get(e), e.getKey(),
					e.getValue());
		}
		if (elem instanceof javaMM.ManifestEntry) {
			javaMM.ManifestEntry e = (javaMM.ManifestEntry) elem;
			return new javaMMinJava.ManifestEntry(map.get(e), e.getName(),
					toIds((EList<EObject>) (EList<?>) e.getAttributes(), map));
		}
		if (elem instanceof javaMM.MemberRef) {
			javaMM.MemberRef e = (javaMM.MemberRef) elem;
			return new javaMMinJava.MemberRef(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getMember()),
					map.get(e.getQualifier()));
		}
		if (elem instanceof javaMM.MethodDeclaration) {
			javaMM.MethodDeclaration e = (javaMM.MethodDeclaration) elem;
			return new javaMMinJava.MethodDeclaration(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), map.get(e.getBody()),
					toIds((EList<EObject>) (EList<?>) e.getParameters(), map),
					toIds((EList<EObject>) (EList<?>) e.getThrownExceptions(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getTypeParameters(),
							map),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInDocComments(), map), toIds(
							(EList<EObject>) (EList<?>) e.getUsages(), map),
					e.getExtraArrayDimensions(), map.get(e.getReturnType()),
					map.get(e.getRedefinedMethodDeclaration()), toIds(
							(EList<EObject>) (EList<?>) e.getRedefinitions(),
							map));
		}
		if (elem instanceof javaMM.MethodInvocation) {
			javaMM.MethodInvocation e = (javaMM.MethodInvocation) elem;
			return new javaMMinJava.MethodInvocation(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					map.get(e.getMethod()),
					toIds((EList<EObject>) (EList<?>) e.getArguments(), map),
					toIds((EList<EObject>) (EList<?>) e.getTypeArguments(), map),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.MethodRef) {
			javaMM.MethodRef e = (javaMM.MethodRef) elem;
			return new javaMMinJava.MethodRef(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getMethod()),
					map.get(e.getQualifier()), toIds(
							(EList<EObject>) (EList<?>) e.getParameters(), map));
		}
		if (elem instanceof javaMM.MethodRefParameter) {
			javaMM.MethodRefParameter e = (javaMM.MethodRefParameter) elem;
			return new javaMMinJava.MethodRefParameter(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(),
					e.isVarargs(), map.get(e.getType()));
		}
		if (elem instanceof javaMM.Model) {
			javaMM.Model e = (javaMM.Model) elem;
			return new javaMMinJava.Model(map.get(e), e.getName(), toIds(
					(EList<EObject>) (EList<?>) e.getOwnedElements(), map),
					toIds((EList<EObject>) (EList<?>) e.getOrphanTypes(), map),
					toIds((EList<EObject>) (EList<?>) e.getUnresolvedItems(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCompilationUnits(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getClassFiles(), map),
					toIds((EList<EObject>) (EList<?>) e.getArchives(), map));
		}
		if (elem instanceof javaMM.Modifier) {
			javaMM.Modifier e = (javaMM.Modifier) elem;
			return new javaMMinJava.Modifier(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getVisibility()
							.getLiteral(), e.getInheritance().getLiteral(),
					e.isStatic(), e.isTransient(), e.isVolatile(),
					e.isNative(), e.isStrictfp(), e.isSynchronized(), map.get(e
							.getBodyDeclaration()), map.get(e
							.getSingleVariableDeclaration()), map.get(e
							.getVariableDeclarationStatement()), map.get(e
							.getVariableDeclarationExpression()));
		}
		if (elem instanceof javaMM.NumberLiteral) {
			javaMM.NumberLiteral e = (javaMM.NumberLiteral) elem;
			return new javaMMinJava.NumberLiteral(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getTokenValue());
		}
		if (elem instanceof javaMM.NullLiteral) {
			javaMM.NullLiteral e = (javaMM.NullLiteral) elem;
			return new javaMMinJava.NullLiteral(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()));
		}
		if (elem instanceof javaMM.Package) {
			javaMM.Package e = (javaMM.Package) elem;
			return new javaMMinJava.Package(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getOwnedElements(),
							map), map.get(e.getModel()), toIds(
							(EList<EObject>) (EList<?>) e.getOwnedPackages(),
							map), map.get(e.getPackage()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInPackageAccess(), map));
		}
		if (elem instanceof javaMM.PackageAccess) {
			javaMM.PackageAccess e = (javaMM.PackageAccess) elem;
			return new javaMMinJava.PackageAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getPackage()),
					map.get(e.getQualifier()));
		}
		if (elem instanceof javaMM.ParameterizedType) {
			javaMM.ParameterizedType e = (javaMM.ParameterizedType) elem;
			return new javaMMinJava.ParameterizedType(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map), map.get(e.getType()), toIds(
							(EList<EObject>) (EList<?>) e.getTypeArguments(),
							map));
		}
		if (elem instanceof javaMM.ParenthesizedExpression) {
			javaMM.ParenthesizedExpression e = (javaMM.ParenthesizedExpression) elem;
			return new javaMMinJava.ParenthesizedExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.PostfixExpression) {
			javaMM.PostfixExpression e = (javaMM.PostfixExpression) elem;
			return new javaMMinJava.PostfixExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getOperator()
							.getLiteral(), map.get(e.getOperand()));
		}
		if (elem instanceof javaMM.PrefixExpression) {
			javaMM.PrefixExpression e = (javaMM.PrefixExpression) elem;
			return new javaMMinJava.PrefixExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getOperator()
							.getLiteral(), map.get(e.getOperand()));
		}
		if (elem instanceof javaMM.PrimitiveType) {
			javaMM.PrimitiveType e = (javaMM.PrimitiveType) elem;
			return new javaMMinJava.PrimitiveType(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeBoolean) {
			javaMM.PrimitiveTypeBoolean e = (javaMM.PrimitiveTypeBoolean) elem;
			return new javaMMinJava.PrimitiveTypeBoolean(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeByte) {
			javaMM.PrimitiveTypeByte e = (javaMM.PrimitiveTypeByte) elem;
			return new javaMMinJava.PrimitiveTypeByte(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeChar) {
			javaMM.PrimitiveTypeChar e = (javaMM.PrimitiveTypeChar) elem;
			return new javaMMinJava.PrimitiveTypeChar(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeDouble) {
			javaMM.PrimitiveTypeDouble e = (javaMM.PrimitiveTypeDouble) elem;
			return new javaMMinJava.PrimitiveTypeDouble(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeShort) {
			javaMM.PrimitiveTypeShort e = (javaMM.PrimitiveTypeShort) elem;
			return new javaMMinJava.PrimitiveTypeShort(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeFloat) {
			javaMM.PrimitiveTypeFloat e = (javaMM.PrimitiveTypeFloat) elem;
			return new javaMMinJava.PrimitiveTypeFloat(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeInt) {
			javaMM.PrimitiveTypeInt e = (javaMM.PrimitiveTypeInt) elem;
			return new javaMMinJava.PrimitiveTypeInt(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeLong) {
			javaMM.PrimitiveTypeLong e = (javaMM.PrimitiveTypeLong) elem;
			return new javaMMinJava.PrimitiveTypeLong(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.PrimitiveTypeVoid) {
			javaMM.PrimitiveTypeVoid e = (javaMM.PrimitiveTypeVoid) elem;
			return new javaMMinJava.PrimitiveTypeVoid(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.ReturnStatement) {
			javaMM.ReturnStatement e = (javaMM.ReturnStatement) elem;
			return new javaMMinJava.ReturnStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.SingleVariableAccess) {
			javaMM.SingleVariableAccess e = (javaMM.SingleVariableAccess) elem;
			return new javaMMinJava.SingleVariableAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getVariable()),
					map.get(e.getQualifier()));
		}
		if (elem instanceof javaMM.SingleVariableDeclaration) {
			javaMM.SingleVariableDeclaration e = (javaMM.SingleVariableDeclaration) elem;
			return new javaMMinJava.SingleVariableDeclaration(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), e.getExtraArrayDimensions(), map.get(e
							.getInitializer()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsageInVariableAccess(), map), map.get(e
							.getModifier()), e.isVarargs(),
					map.get(e.getType()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getMethodDeclaration()), map.get(e
							.getCatchClause()), map.get(e
							.getEnhancedForStatement()));
		}
		if (elem instanceof javaMM.StringLiteral) {
			javaMM.StringLiteral e = (javaMM.StringLiteral) elem;
			return new javaMMinJava.StringLiteral(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getEscapedValue());
		}
		if (elem instanceof javaMM.SuperConstructorInvocation) {
			javaMM.SuperConstructorInvocation e = (javaMM.SuperConstructorInvocation) elem;
			return new javaMMinJava.SuperConstructorInvocation(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					map.get(e.getMethod()),
					toIds((EList<EObject>) (EList<?>) e.getArguments(), map),
					toIds((EList<EObject>) (EList<?>) e.getTypeArguments(), map),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.SuperFieldAccess) {
			javaMM.SuperFieldAccess e = (javaMM.SuperFieldAccess) elem;
			return new javaMMinJava.SuperFieldAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getQualifier()), map.get(e.getField()));
		}
		if (elem instanceof javaMM.SuperMethodInvocation) {
			javaMM.SuperMethodInvocation e = (javaMM.SuperMethodInvocation) elem;
			return new javaMMinJava.SuperMethodInvocation(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					map.get(e.getQualifier()),
					map.get(e.getMethod()),
					toIds((EList<EObject>) (EList<?>) e.getArguments(), map),
					toIds((EList<EObject>) (EList<?>) e.getTypeArguments(), map));
		}
		if (elem instanceof javaMM.SwitchCase) {
			javaMM.SwitchCase e = (javaMM.SwitchCase) elem;
			return new javaMMinJava.SwitchCase(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.isDefault(), map.get(e
							.getExpression()));
		}
		if (elem instanceof javaMM.SwitchStatement) {
			javaMM.SwitchStatement e = (javaMM.SwitchStatement) elem;
			return new javaMMinJava.SwitchStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()), toIds(
							(EList<EObject>) (EList<?>) e.getStatements(), map));
		}
		if (elem instanceof javaMM.SynchronizedStatement) {
			javaMM.SynchronizedStatement e = (javaMM.SynchronizedStatement) elem;
			return new javaMMinJava.SynchronizedStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getBody()),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.TagElement) {
			javaMM.TagElement e = (javaMM.TagElement) elem;
			return new javaMMinJava.TagElement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getTagName(), toIds(
							(EList<EObject>) (EList<?>) e.getFragments(), map));
		}
		if (elem instanceof javaMM.TextElement) {
			javaMM.TextElement e = (javaMM.TextElement) elem;
			return new javaMMinJava.TextElement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getText());
		}
		if (elem instanceof javaMM.ThisExpression) {
			javaMM.ThisExpression e = (javaMM.ThisExpression) elem;
			return new javaMMinJava.ThisExpression(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getQualifier()));
		}
		if (elem instanceof javaMM.ThrowStatement) {
			javaMM.ThrowStatement e = (javaMM.ThrowStatement) elem;
			return new javaMMinJava.ThrowStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()));
		}
		if (elem instanceof javaMM.TryStatement) {
			javaMM.TryStatement e = (javaMM.TryStatement) elem;
			return new javaMMinJava.TryStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getBody()),
					map.get(e.getFinally()), toIds(
							(EList<EObject>) (EList<?>) e.getCatchClauses(),
							map));
		}
		if (elem instanceof javaMM.TypeAccess) {
			javaMM.TypeAccess e = (javaMM.TypeAccess) elem;
			return new javaMMinJava.TypeAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getType()),
					map.get(e.getQualifier()));
		}
		if (elem instanceof javaMM.TypeDeclarationStatement) {
			javaMM.TypeDeclarationStatement e = (javaMM.TypeDeclarationStatement) elem;
			return new javaMMinJava.TypeDeclarationStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e
							.getDeclaration()));
		}
		if (elem instanceof javaMM.TypeLiteral) {
			javaMM.TypeLiteral e = (javaMM.TypeLiteral) elem;
			return new javaMMinJava.TypeLiteral(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getType()));
		}
		if (elem instanceof javaMM.TypeParameter) {
			javaMM.TypeParameter e = (javaMM.TypeParameter) elem;
			return new javaMMinJava.TypeParameter(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getBounds(), map));
		}
		if (elem instanceof javaMM.UnresolvedItem) {
			javaMM.UnresolvedItem e = (javaMM.UnresolvedItem) elem;
			return new javaMMinJava.UnresolvedItem(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map));
		}
		if (elem instanceof javaMM.UnresolvedItemAccess) {
			javaMM.UnresolvedItemAccess e = (javaMM.UnresolvedItemAccess) elem;
			return new javaMMinJava.UnresolvedItemAccess(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getElement()),
					map.get(e.getQualifier()));
		}
		if (elem instanceof javaMM.UnresolvedAnnotationDeclaration) {
			javaMM.UnresolvedAnnotationDeclaration e = (javaMM.UnresolvedAnnotationDeclaration) elem;
			return new javaMMinJava.UnresolvedAnnotationDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map));
		}
		if (elem instanceof javaMM.UnresolvedAnnotationTypeMemberDeclaration) {
			javaMM.UnresolvedAnnotationTypeMemberDeclaration e = (javaMM.UnresolvedAnnotationTypeMemberDeclaration) elem;
			return new javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration(
					map.get(e), toIds(
							(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), map.get(e.getDefault()), map.get(e
							.getType()), toIds(
							(EList<EObject>) (EList<?>) e.getUsages(), map));
		}
		if (elem instanceof javaMM.UnresolvedClassDeclaration) {
			javaMM.UnresolvedClassDeclaration e = (javaMM.UnresolvedClassDeclaration) elem;
			return new javaMMinJava.UnresolvedClassDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getTypeParameters(),
							map), map.get(e.getSuperClass()));
		}
		if (elem instanceof javaMM.UnresolvedEnumDeclaration) {
			javaMM.UnresolvedEnumDeclaration e = (javaMM.UnresolvedEnumDeclaration) elem;
			return new javaMMinJava.UnresolvedEnumDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getEnumConstants(),
							map));
		}
		if (elem instanceof javaMM.UnresolvedInterfaceDeclaration) {
			javaMM.UnresolvedInterfaceDeclaration e = (javaMM.UnresolvedInterfaceDeclaration) elem;
			return new javaMMinJava.UnresolvedInterfaceDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getTypeParameters(),
							map));
		}
		if (elem instanceof javaMM.UnresolvedLabeledStatement) {
			javaMM.UnresolvedLabeledStatement e = (javaMM.UnresolvedLabeledStatement) elem;
			return new javaMMinJava.UnresolvedLabeledStatement(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getBody()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInBreakStatements(), map),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInContinueStatements(), map));
		}
		if (elem instanceof javaMM.UnresolvedMethodDeclaration) {
			javaMM.UnresolvedMethodDeclaration e = (javaMM.UnresolvedMethodDeclaration) elem;
			return new javaMMinJava.UnresolvedMethodDeclaration(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()), map.get(e
							.getModifier()), map.get(e.getBody()),
					toIds((EList<EObject>) (EList<?>) e.getParameters(), map),
					toIds((EList<EObject>) (EList<?>) e.getThrownExceptions(),
							map), toIds(
							(EList<EObject>) (EList<?>) e.getTypeParameters(),
							map),
					toIds((EList<EObject>) (EList<?>) e
							.getUsagesInDocComments(), map), toIds(
							(EList<EObject>) (EList<?>) e.getUsages(), map),
					e.getExtraArrayDimensions(), map.get(e.getReturnType()),
					map.get(e.getRedefinedMethodDeclaration()), toIds(
							(EList<EObject>) (EList<?>) e.getRedefinitions(),
							map));
		}
		if (elem instanceof javaMM.UnresolvedSingleVariableDeclaration) {
			javaMM.UnresolvedSingleVariableDeclaration e = (javaMM.UnresolvedSingleVariableDeclaration) elem;
			return new javaMMinJava.UnresolvedSingleVariableDeclaration(
					map.get(e), toIds(
							(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), e.getExtraArrayDimensions(), map.get(e
							.getInitializer()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsageInVariableAccess(), map), map.get(e
							.getModifier()), e.isVarargs(),
					map.get(e.getType()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getMethodDeclaration()), map.get(e
							.getCatchClause()), map.get(e
							.getEnhancedForStatement()));
		}
		if (elem instanceof javaMM.UnresolvedType) {
			javaMM.UnresolvedType e = (javaMM.UnresolvedType) elem;
			return new javaMMinJava.UnresolvedType(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map));
		}
		if (elem instanceof javaMM.UnresolvedTypeDeclaration) {
			javaMM.UnresolvedTypeDeclaration e = (javaMM.UnresolvedTypeDeclaration) elem;
			return new javaMMinJava.UnresolvedTypeDeclaration(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					map.get(e.getAbstractTypeDeclaration()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map),
					map.get(e.getAnonymousClassDeclarationOwner()),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getBodyDeclarations(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsBeforeBody(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getCommentsAfterBody(),
							map), map.get(e.getPackage()), toIds(
							(EList<EObject>) (EList<?>) e.getSuperInterfaces(),
							map));
		}
		if (elem instanceof javaMM.UnresolvedVariableDeclarationFragment) {
			javaMM.UnresolvedVariableDeclarationFragment e = (javaMM.UnresolvedVariableDeclarationFragment) elem;
			return new javaMMinJava.UnresolvedVariableDeclarationFragment(
					map.get(e), toIds(
							(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), e.getExtraArrayDimensions(), map.get(e
							.getInitializer()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsageInVariableAccess(), map), map.get(e
							.getVariablesContainer()));
		}
		if (elem instanceof javaMM.VariableDeclarationExpression) {
			javaMM.VariableDeclarationExpression e = (javaMM.VariableDeclarationExpression) elem;
			return new javaMMinJava.VariableDeclarationExpression(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getType()),
					toIds((EList<EObject>) (EList<?>) e.getFragments(), map),
					map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map));
		}
		if (elem instanceof javaMM.VariableDeclarationFragment) {
			javaMM.VariableDeclarationFragment e = (javaMM.VariableDeclarationFragment) elem;
			return new javaMMinJava.VariableDeclarationFragment(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), e.getName(), e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map), e.getExtraArrayDimensions(), map.get(e
							.getInitializer()),
					toIds((EList<EObject>) (EList<?>) e
							.getUsageInVariableAccess(), map), map.get(e
							.getVariablesContainer()));
		}
		if (elem instanceof javaMM.VariableDeclarationStatement) {
			javaMM.VariableDeclarationStatement e = (javaMM.VariableDeclarationStatement) elem;
			return new javaMMinJava.VariableDeclarationStatement(map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()), map.get(e.getType()),
					toIds((EList<EObject>) (EList<?>) e.getFragments(), map),
					e.getExtraArrayDimensions(), map.get(e.getModifier()),
					toIds((EList<EObject>) (EList<?>) e.getAnnotations(), map));
		}
		if (elem instanceof javaMM.WildCardType) {
			javaMM.WildCardType e = (javaMM.WildCardType) elem;
			return new javaMMinJava.WildCardType(
					map.get(e),
					toIds((EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()),
					map.get(e.getOriginalClassFile()),
					e.getName(),
					e.isProxy(),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInImports(),
							map),
					toIds((EList<EObject>) (EList<?>) e.getUsagesInTypeAccess(),
							map), e.isUpperBound(), map.get(e.getBound()));
		}
		if (elem instanceof javaMM.WhileStatement) {
			javaMM.WhileStatement e = (javaMM.WhileStatement) elem;
			return new javaMMinJava.WhileStatement(map.get(e), toIds(
					(EList<EObject>) (EList<?>) e.getComments(), map),
					map.get(e.getOriginalCompilationUnit()), map.get(e
							.getOriginalClassFile()),
					map.get(e.getExpression()), map.get(e.getBody()));
		}

		return null;
	}

	private static IdentifiableElement[] toIds(EList<EObject> objs, Map<EObject, String> map) {
		IdentifiableElement[] ids = new IdentifiableElement[objs.size()];
		for (int i = 0; i < objs.size(); i++) {
			ids[i] = transformEMF2Java(objs.get(i), map);
		}
		return ids;
	}

	private static Map<EObject, String> createObjects2IdsMap(List<EObject> elem) {
		Map<EObject, String> objects2Ids = new HashMap<EObject, String>();
		for (EObject e : elem) {
			objects2Ids.putAll(createObjects2IdsMapRecursive(e));
		}
		return objects2Ids;
	}

	static double currentId = 1;

	private static Map<EObject, String> createObjects2IdsMapRecursive(
			EObject elem) {
		Map<EObject, String> m = new HashMap<EObject, String>();
		m.put(elem, Double.toString(currentId));
		currentId++;
		if (elem.eAllContents() != null) {
			for (EObject o : elem.eContents()) {
				m.putAll(createObjects2IdsMapRecursive(o));
			}
		}
		return m;
	}

	private static void printRecursive(EObject elem, int level) {
		if (elem.eAllContents() == null) {
			for (int i = 0; i < level; i++) {
				System.out.print("\t");
			}
			System.out.println(elem);
		} else {
			System.out.println(elem);
			for (EObject o : elem.eContents()) {
				for (int i = 0; i < level; i++) {
					System.out.print("\t");
				}
				printRecursive(o, level + 1);
			}
		}
	}
}
