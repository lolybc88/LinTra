package eMF2LinTra;

import java.awt.PageAttributes.OriginType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javaMM.Annotation;
import javaMM.JavaMMFactory;
import javaMM.JavaMMPackage;
import javaMM.Model;
import javaMM.TypeAccess;
import javaMMinJava.AnnotationMemberValuePair;
import javaMMinJava.ClassFile;
import javaMMinJava.Comment;
import javaMMinJava.CompilationUnit;

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
		eMFModel2LinTraModel(
				"C:/Users/Atenea/Desktop/eclipseModel/eclipseModels2",
				"C:/Users/Atenea/Desktop/eclipseModel/eclipseModel-versionBigMDE.ser");
		// joinEMFModels("C:/Users/Atenea/Desktop/eclipseModel/eclipseModels2",
		// "eclipseModel-all.xmi");

		System.out.println("\nDone!");
	}

	public static void eMFModel2LinTraModel(String folderPath, String modelPath)
			throws IOException {
		List<Model> models = getEMFModels(folderPath);
		@SuppressWarnings("unchecked")
		Map<EObject, String> map = createObjects2IdsMap((List<EObject>) (List<?>) models);
		List<IdentifiableElement> elems = createJavaObjects(models, map);
		System.out.println("#elems: " + elems.size());

		writeSer(elems, modelPath);
	}

	public static void joinEMFModels(String folderPath, String modelName)
			throws IOException {

		JavaMMPackage.eINSTANCE.eClass();
		JavaMMFactory factory = JavaMMFactory.eINSTANCE;
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createURI("xmiModels/"
				+ modelName));

		List<Model> models = getEMFModels(folderPath);

		for (Model model : models) {
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
				models.add(getEMFModel("file:" + folderPath + "/"
						+ fileEntry.getName()));
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

	private static IdentifiableElement[] transformEMF2Java(EList<?> comments,
			Map<EObject, String> map) {

		// COMPLETE !!
		
		return null;
	}

	@SuppressWarnings("unchecked")
	private static IdentifiableElement transformEMF2Java(EObject elem,
			Map<EObject, String> map) {

		if (elem instanceof javaMM.Annotation) {
			javaMM.Annotation e = (javaMM.Annotation) elem;
			return new javaMMinJava.Annotation(
					map.get(e),
					(Comment[]) transformEMF2Java(e.getComments(), map),
					(CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(ClassFile) transformEMF2Java(e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map),
					(AnnotationMemberValuePair[]) transformEMF2Java(
							e.getValues(), map));
		}

		if (elem instanceof javaMM.Archive) {
			javaMM.Archive e = (javaMM.Archive) elem;
			return new javaMMinJava.Archive(map.get(e), e.getName(),
					e.isProxy(), e.getOriginalFilePath(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.ClassFile[]) transformEMF2Java(
							e.getClassFiles(), map),
					(javaMMinJava.Manifest) transformEMF2Java(e.getManifest(),
							map));
		}

		if (elem instanceof javaMM.AssertStatement) {
			javaMM.AssertStatement e = (javaMM.AssertStatement) elem;
			return new javaMMinJava.AssertStatement(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(e.getMessage(),
							map), (javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.AnnotationMemberValuePair) {
			javaMM.AnnotationMemberValuePair e = (javaMM.AnnotationMemberValuePair) elem;
			return new javaMMinJava.AnnotationMemberValuePair(
					map.get(e),
					e.getName(),
					e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AnnotationTypeMemberDeclaration) transformEMF2Java(
							e.getMember(), map),
					(javaMMinJava.Expression) transformEMF2Java(e.getValue(),
							map));
		}

		if (elem instanceof javaMM.AnnotationTypeDeclaration) {
			javaMM.AnnotationTypeDeclaration e = (javaMM.AnnotationTypeDeclaration) elem;
			return new javaMMinJava.AnnotationTypeDeclaration(map.get(e),
					e.getName(), e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map));
		}

		if (elem instanceof javaMM.AnnotationTypeMemberDeclaration) {
			javaMM.AnnotationTypeMemberDeclaration e = (javaMM.AnnotationTypeMemberDeclaration) elem;
			return new javaMMinJava.AnnotationTypeMemberDeclaration(
					map.get(e),
					e.getName(),
					e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.Expression) transformEMF2Java(e.getDefault(),
							map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map),
					(javaMMinJava.AnnotationMemberValuePair[]) transformEMF2Java(
							e.getUsages(), map));
		}

		if (elem instanceof javaMM.AnonymousClassDeclaration) {
			javaMM.AnonymousClassDeclaration e = (javaMM.AnonymousClassDeclaration) elem;
			return new javaMMinJava.AnonymousClassDeclaration(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.ClassInstanceCreation) transformEMF2Java(
							e.getClassInstanceCreation(), map));
		}

		if (elem instanceof javaMM.ArrayAccess) {
			javaMM.ArrayAccess e = (javaMM.ArrayAccess) elem;
			return new javaMMinJava.ArrayAccess(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(e.getArray(),
							map), (javaMMinJava.Expression) transformEMF2Java(
							e.getIndex(), map));
		}

		if (elem instanceof javaMM.ArrayCreation) {
			javaMM.ArrayCreation e = (javaMM.ArrayCreation) elem;
			return new javaMMinJava.ArrayCreation(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getDimensions(), map),
					(javaMMinJava.ArrayInitializer) transformEMF2Java(
							e.getInitializer(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map));
		}

		if (elem instanceof javaMM.ArrayInitializer) {
			javaMM.ArrayInitializer e = (javaMM.ArrayInitializer) elem;
			return new javaMMinJava.ArrayInitializer(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getExpressions(), map));
		}

		if (elem instanceof javaMM.ArrayLengthAccess) {
			javaMM.ArrayLengthAccess e = (javaMM.ArrayLengthAccess) elem;
			return new javaMMinJava.ArrayLengthAccess(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(e.getArray(),
							map));
		}

		if (elem instanceof javaMM.ArrayType) {
			javaMM.ArrayType e = (javaMM.ArrayType) elem;
			return new javaMMinJava.ArrayType(map.get(e), e.getName(),
					e.isProxy(), e.getDimensions(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getElementType(), map));
		}

		if (elem instanceof javaMM.Assignment) {
			javaMM.Assignment e = (javaMM.Assignment) elem;
			return new javaMMinJava.Assignment(map.get(e), e.getOperator()
					.toString(), (javaMMinJava.Comment[]) transformEMF2Java(
					e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getLeftHandSide(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getRightHandSide(), map));
		}

		if (elem instanceof javaMM.BooleanLiteral) {
			javaMM.BooleanLiteral e = (javaMM.BooleanLiteral) elem;
			return new javaMMinJava.BooleanLiteral(map.get(e), e.isValue(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.BlockComment) {
			javaMM.BlockComment e = (javaMM.BlockComment) elem;
			return new javaMMinJava.BlockComment(map.get(e), e.getContent(),
					e.isEnclosedByParent(), e.isPrefixOfParent(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.Block) {
			javaMM.Block e = (javaMM.Block) elem;
			return new javaMMinJava.Block(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Statement[]) transformEMF2Java(
							e.getStatements(), map));
		}

		if (elem instanceof javaMM.BreakStatement) {
			javaMM.BreakStatement e = (javaMM.BreakStatement) elem;
			return new javaMMinJava.BreakStatement(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.LabeledStatement) transformEMF2Java(
							e.getLabel(), map));
		}

		if (elem instanceof javaMM.CastExpression) {
			javaMM.CastExpression e = (javaMM.CastExpression) elem;
			return new javaMMinJava.CastExpression(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map));
		}

		if (elem instanceof javaMM.CatchClause) {
			javaMM.CatchClause e = (javaMM.CatchClause) elem;
			return new javaMMinJava.CatchClause(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.SingleVariableDeclaration) transformEMF2Java(
							e.getException(), map),
					(javaMMinJava.Block) transformEMF2Java(e.getBody(), map));
		}

		if (elem instanceof javaMM.CharacterLiteral) {
			javaMM.CharacterLiteral e = (javaMM.CharacterLiteral) elem;
			return new javaMMinJava.CharacterLiteral(map.get(e),
					e.getEscapedValue(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.ClassFile) {
			javaMM.ClassFile e = (javaMM.ClassFile) elem;
			return new javaMMinJava.ClassFile(map.get(e), e.getName(),
					e.isProxy(), e.getOriginalFilePath(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getType(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getAttachedSource(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map));
		}

		if (elem instanceof javaMM.ClassInstanceCreation) {
			javaMM.ClassInstanceCreation e = (javaMM.ClassInstanceCreation) elem;
			return new javaMMinJava.ClassInstanceCreation(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethod(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getArguments(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getTypeArguments(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclaration(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map));
		}

		if (elem instanceof javaMM.ConstructorDeclaration) {
			javaMM.ConstructorDeclaration e = (javaMM.ConstructorDeclaration) elem;
			return new javaMMinJava.ConstructorDeclaration(
					map.get(e),
					e.getName(),
					e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.Block) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.SingleVariableDeclaration[]) transformEMF2Java(
							e.getParameters(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getThrownExceptions(), map),
					(javaMMinJava.TypeParameter[]) transformEMF2Java(
							e.getTypeParameters(), map),
					(javaMMinJava.MethodRef[]) transformEMF2Java(
							e.getUsagesInDocComments(), map),
					(javaMMinJava.AbstractMethodInvocation[]) transformEMF2Java(
							e.getUsages(), map));
		}

		if (elem instanceof javaMM.ConditionalExpression) {
			javaMM.ConditionalExpression e = (javaMM.ConditionalExpression) elem;
			return new javaMMinJava.ConditionalExpression(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getElseExpression(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getThenExpression(), map));
		}

		if (elem instanceof javaMM.ConstructorInvocation) {
			javaMM.ConstructorInvocation e = (javaMM.ConstructorInvocation) elem;
			return new javaMMinJava.ConstructorInvocation(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethod(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getArguments(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getTypeArguments(), map));
		}

		if (elem instanceof javaMM.ClassDeclaration) {
			javaMM.ClassDeclaration e = (javaMM.ClassDeclaration) elem;
			return new javaMMinJava.ClassDeclaration(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map),
					(javaMMinJava.TypeParameter[]) transformEMF2Java(
							e.getTypeParameters(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getSuperClass(), map));
		}

		if (elem instanceof javaMM.CompilationUnit) {
			javaMM.CompilationUnit e = (javaMM.CompilationUnit) elem;
			return new javaMMinJava.CompilationUnit(map.get(e), e.getName(),
					e.isProxy(), e.getOriginalFilePath(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentList(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getImports(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.AbstractTypeDeclaration[]) transformEMF2Java(
							e.getTypes(), map));
		}

		if (elem instanceof javaMM.ContinueStatement) {
			javaMM.ContinueStatement e = (javaMM.ContinueStatement) elem;
			return new javaMMinJava.ContinueStatement(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.LabeledStatement) transformEMF2Java(
							e.getLabel(), map));
		}

		if (elem instanceof javaMM.DoStatement) {
			javaMM.DoStatement e = (javaMM.DoStatement) elem;
			return new javaMMinJava.DoStatement(
					map.get(e),

					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.Statement) transformEMF2Java(e.getBody(), map));
		}

		if (elem instanceof javaMM.EmptyStatement) {
			javaMM.EmptyStatement e = (javaMM.EmptyStatement) elem;
			return new javaMMinJava.EmptyStatement(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.EnhancedForStatement) {
			javaMM.EnhancedForStatement e = (javaMM.EnhancedForStatement) elem;
			return new javaMMinJava.EnhancedForStatement(
					map.get(e),

					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Statement) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.SingleVariableDeclaration) transformEMF2Java(
							e.getParameter(), map));
		}

		if (elem instanceof javaMM.EnumConstantDeclaration) {
			javaMM.EnumConstantDeclaration e = (javaMM.EnumConstantDeclaration) elem;
			return new javaMMinJava.EnumConstantDeclaration(map.get(e),
					e.getName(), e.isProxy(), e.getExtraArrayDimensions(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map), (javaMMinJava.Expression) transformEMF2Java(
							e.getInitializer(), map),
					(javaMMinJava.SingleVariableAccess[]) transformEMF2Java(
							e.getUsageInVariableAccess(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclaration(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getArguments(), map));
		}

		if (elem instanceof javaMM.EnumDeclaration) {
			javaMM.EnumDeclaration e = (javaMM.EnumDeclaration) elem;
			return new javaMMinJava.EnumDeclaration(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map),
					(javaMMinJava.EnumConstantDeclaration[]) transformEMF2Java(
							e.getEnumConstants(), map));
		}

		if (elem instanceof javaMM.ExpressionStatement) {
			javaMM.ExpressionStatement e = (javaMM.ExpressionStatement) elem;
			return new javaMMinJava.ExpressionStatement(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.FieldAccess) {
			javaMM.FieldAccess e = (javaMM.FieldAccess) elem;
			return new javaMMinJava.FieldAccess(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.SingleVariableAccess) transformEMF2Java(
							e.getField(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.FieldDeclaration) {
			javaMM.FieldDeclaration e = (javaMM.FieldDeclaration) elem;
			return new javaMMinJava.FieldDeclaration(
					map.get(e),
					e.getName(),
					e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map),
					(javaMMinJava.VariableDeclarationFragment[]) transformEMF2Java(
							e.getFragments(), map));
		}

		if (elem instanceof javaMM.ForStatement) {
			javaMM.ForStatement e = (javaMM.ForStatement) elem;
			return new javaMMinJava.ForStatement(
					map.get(e),

					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getUpdaters(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getInitializers(), map),
					(javaMMinJava.Statement) transformEMF2Java(e.getBody(), map));
		}

		if (elem instanceof javaMM.IfStatement) {
			javaMM.IfStatement e = (javaMM.IfStatement) elem;
			return new javaMMinJava.IfStatement(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.Statement) transformEMF2Java(
							e.getThenStatement(), map),
					(javaMMinJava.Statement) transformEMF2Java(
							e.getElseStatement(), map));
		}

		if (elem instanceof javaMM.ImportDeclaration) {
			javaMM.ImportDeclaration e = (javaMM.ImportDeclaration) elem;
			return new javaMMinJava.ImportDeclaration(map.get(e), e.isStatic(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.NamedElement) transformEMF2Java(
							e.getImportedElement(), map));
		}

		if (elem instanceof javaMM.InfixExpression) {
			javaMM.InfixExpression e = (javaMM.InfixExpression) elem;
			return new javaMMinJava.InfixExpression(map.get(e), e.getOperator()
					.toString(), (javaMMinJava.Comment[]) transformEMF2Java(
					e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getRightOperand(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getLeftOperand(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getExtendedOperands(), map));
		}

		if (elem instanceof javaMM.Initializer) {
			javaMM.Initializer e = (javaMM.Initializer) elem;
			return new javaMMinJava.Initializer(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map), (javaMMinJava.Block) transformEMF2Java(
							e.getBody(), map));
		}

		if (elem instanceof javaMM.InstanceofExpression) {
			javaMM.InstanceofExpression e = (javaMM.InstanceofExpression) elem;
			return new javaMMinJava.InstanceofExpression(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getRightOperand(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getLeftOperand(), map));
		}

		if (elem instanceof javaMM.InterfaceDeclaration) {
			javaMM.InterfaceDeclaration e = (javaMM.InterfaceDeclaration) elem;
			return new javaMMinJava.InterfaceDeclaration(map.get(e),
					e.getName(), e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map),
					(javaMMinJava.TypeParameter[]) transformEMF2Java(
							e.getTypeParameters(), map));
		}

		if (elem instanceof javaMM.Javadoc) {
			javaMM.Javadoc e = (javaMM.Javadoc) elem;
			return new javaMMinJava.Javadoc(map.get(e), e.getContent(),
					e.isEnclosedByParent(), e.isPrefixOfParent(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TagElement[]) transformEMF2Java(e.getTags(),
							map));
		}

		if (elem instanceof javaMM.LabeledStatement) {
			javaMM.LabeledStatement e = (javaMM.LabeledStatement) elem;
			return new javaMMinJava.LabeledStatement(
					map.get(e),
					e.getName(),
					e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.Statement) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.BreakStatement[]) transformEMF2Java(
							e.getUsagesInBreakStatements(), map),
					(javaMMinJava.ContinueStatement[]) transformEMF2Java(
							e.getUsagesInContinueStatements(), map));
		}

		if (elem instanceof javaMM.LineComment) {
			javaMM.LineComment e = (javaMM.LineComment) elem;
			return new javaMMinJava.LineComment(map.get(e), e.getContent(),
					e.isEnclosedByParent(), e.isPrefixOfParent(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.Manifest) {
			javaMM.Manifest e = (javaMM.Manifest) elem;
			return new javaMMinJava.Manifest(map.get(e),

			(javaMMinJava.ManifestAttribute[]) transformEMF2Java(
					e.getMainAttributes(), map),
					(javaMMinJava.ManifestEntry[]) transformEMF2Java(
							e.getEntryAttributes(), map));
		}

		if (elem instanceof javaMM.ManifestAttribute) {
			javaMM.ManifestAttribute e = (javaMM.ManifestAttribute) elem;
			return new javaMMinJava.ManifestAttribute(map.get(e), e.getKey(),
					e.getValue());
		}

		if (elem instanceof javaMM.ManifestEntry) {
			javaMM.ManifestEntry e = (javaMM.ManifestEntry) elem;
			return new javaMMinJava.ManifestEntry(map.get(e), e.getName(),
					(javaMMinJava.ManifestAttribute[]) transformEMF2Java(
							e.getAttributes(), map));
		}

		if (elem instanceof javaMM.MemberRef) {
			javaMM.MemberRef e = (javaMM.MemberRef) elem;
			return new javaMMinJava.MemberRef(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.NamedElement) transformEMF2Java(
							e.getMember(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getQualifier(), map));
		}

		if (elem instanceof javaMM.MethodDeclaration) {
			javaMM.MethodDeclaration e = (javaMM.MethodDeclaration) elem;
			return new javaMMinJava.MethodDeclaration(
					map.get(e),
					e.getName(),
					e.isProxy(),
					e.getExtraArrayDimensions(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.Block) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.SingleVariableDeclaration[]) transformEMF2Java(
							e.getParameters(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getThrownExceptions(), map),
					(javaMMinJava.TypeParameter[]) transformEMF2Java(
							e.getTypeParameters(), map),
					(javaMMinJava.MethodRef[]) transformEMF2Java(
							e.getUsagesInDocComments(), map),
					(javaMMinJava.AbstractMethodInvocation[]) transformEMF2Java(
							e.getUsages(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getReturnType(), map),
					(javaMMinJava.MethodDeclaration) transformEMF2Java(
							e.getRedefinedMethodDeclaration(), map),
					(javaMMinJava.MethodDeclaration[]) transformEMF2Java(
							e.getRedefinitions(), map));
		}

		if (elem instanceof javaMM.MethodInvocation) {
			javaMM.MethodInvocation e = (javaMM.MethodInvocation) elem;
			return new javaMMinJava.MethodInvocation(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethod(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getArguments(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getTypeArguments(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.MethodRef) {
			javaMM.MethodRef e = (javaMM.MethodRef) elem;
			return new javaMMinJava.MethodRef(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethod(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getQualifier(), map),
					(javaMMinJava.MethodRefParameter[]) transformEMF2Java(
							e.getParameters(), map));
		}

		if (elem instanceof javaMM.MethodRefParameter) {
			javaMM.MethodRefParameter e = (javaMM.MethodRefParameter) elem;
			return new javaMMinJava.MethodRefParameter(map.get(e), e.getName(),
					e.isVarargs(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map));
		}

		if (elem instanceof javaMM.Model) {
			javaMM.Model e = (javaMM.Model) elem;
			return new javaMMinJava.Model(map.get(e), e.getName(),
					(javaMMinJava.Package[]) transformEMF2Java(
							e.getOwnedElements(), map),
					(javaMMinJava.Type[]) transformEMF2Java(e.getOrphanTypes(),
							map),
					(javaMMinJava.UnresolvedItem[]) transformEMF2Java(
							e.getUnresolvedItems(), map),
					(javaMMinJava.CompilationUnit[]) transformEMF2Java(
							e.getCompilationUnits(), map),
					(javaMMinJava.ClassFile[]) transformEMF2Java(
							e.getClassFiles(), map),
					(javaMMinJava.Archive[]) transformEMF2Java(e.getArchives(),
							map));
		}

		if (elem instanceof javaMM.Modifier) {
			javaMM.Modifier e = (javaMM.Modifier) elem;
			return new javaMMinJava.Modifier(
					map.get(e),
					e.getVisibility().toString(),
					e.getInheritance().toString(),
					e.isStatic(),
					e.isTransient(),
					e.isVolatile(),
					e.isNative(),
					e.isStrictfp(),
					e.isSynchronized(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.BodyDeclaration) transformEMF2Java(
							e.getBodyDeclaration(), map),
					(javaMMinJava.SingleVariableDeclaration) transformEMF2Java(
							e.getSingleVariableDeclaration(), map),
					(javaMMinJava.VariableDeclarationStatement) transformEMF2Java(
							e.getVariableDeclarationStatement(), map),
					(javaMMinJava.VariableDeclarationExpression) transformEMF2Java(
							e.getVariableDeclarationExpression(), map));
		}

		if (elem instanceof javaMM.NumberLiteral) {
			javaMM.NumberLiteral e = (javaMM.NumberLiteral) elem;
			return new javaMMinJava.NumberLiteral(map.get(e),
					e.getTokenValue(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.NullLiteral) {
			javaMM.NullLiteral e = (javaMM.NullLiteral) elem;
			return new javaMMinJava.NullLiteral(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.Package) {
			javaMM.Package e = (javaMM.Package) elem;
			return new javaMMinJava.Package(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration[]) transformEMF2Java(
							e.getOwnedElements(), map),
					(javaMMinJava.Model) transformEMF2Java(e.getModel(), map),
					(javaMMinJava.Package[]) transformEMF2Java(
							e.getOwnedPackages(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.PackageAccess[]) transformEMF2Java(
							e.getUsagesInPackageAccess(), map));
		}

		if (elem instanceof javaMM.PackageAccess) {
			javaMM.PackageAccess e = (javaMM.PackageAccess) elem;
			return new javaMMinJava.PackageAccess(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.PackageAccess) transformEMF2Java(
							e.getQualifier(), map));
		}

		if (elem instanceof javaMM.ParameterizedType) {
			javaMM.ParameterizedType e = (javaMM.ParameterizedType) elem;
			return new javaMMinJava.ParameterizedType(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getTypeArguments(), map));
		}

		if (elem instanceof javaMM.ParenthesizedExpression) {
			javaMM.ParenthesizedExpression e = (javaMM.ParenthesizedExpression) elem;
			return new javaMMinJava.ParenthesizedExpression(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.PostfixExpression) {
			javaMM.PostfixExpression e = (javaMM.PostfixExpression) elem;
			return new javaMMinJava.PostfixExpression(map.get(e), e
					.getOperator().toString(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(e.getOperand(),
							map));
		}

		if (elem instanceof javaMM.PrefixExpression) {
			javaMM.PrefixExpression e = (javaMM.PrefixExpression) elem;
			return new javaMMinJava.PrefixExpression(map.get(e), e
					.getOperator().toString(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(e.getOperand(),
							map));
		}

		if (elem instanceof javaMM.PrimitiveType) {
			javaMM.PrimitiveType e = (javaMM.PrimitiveType) elem;
			return new javaMMinJava.PrimitiveType(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeBoolean) {
			javaMM.PrimitiveTypeBoolean e = (javaMM.PrimitiveTypeBoolean) elem;
			return new javaMMinJava.PrimitiveTypeBoolean(map.get(e),
					e.getName(), e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeByte) {
			javaMM.PrimitiveTypeByte e = (javaMM.PrimitiveTypeByte) elem;
			return new javaMMinJava.PrimitiveTypeByte(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeChar) {
			javaMM.PrimitiveTypeChar e = (javaMM.PrimitiveTypeChar) elem;
			return new javaMMinJava.PrimitiveTypeChar(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeDouble) {
			javaMM.PrimitiveTypeDouble e = (javaMM.PrimitiveTypeDouble) elem;
			return new javaMMinJava.PrimitiveTypeDouble(map.get(e),
					e.getName(), e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeShort) {
			javaMM.PrimitiveTypeShort e = (javaMM.PrimitiveTypeShort) elem;
			return new javaMMinJava.PrimitiveTypeShort(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeFloat) {
			javaMM.PrimitiveTypeFloat e = (javaMM.PrimitiveTypeFloat) elem;
			return new javaMMinJava.PrimitiveTypeFloat(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeInt) {
			javaMM.PrimitiveTypeInt e = (javaMM.PrimitiveTypeInt) elem;
			return new javaMMinJava.PrimitiveTypeInt(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeLong) {
			javaMM.PrimitiveTypeLong e = (javaMM.PrimitiveTypeLong) elem;
			return new javaMMinJava.PrimitiveTypeLong(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.PrimitiveTypeVoid) {
			javaMM.PrimitiveTypeVoid e = (javaMM.PrimitiveTypeVoid) elem;
			return new javaMMinJava.PrimitiveTypeVoid(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.ReturnStatement) {
			javaMM.ReturnStatement e = (javaMM.ReturnStatement) elem;
			return new javaMMinJava.ReturnStatement(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.SingleVariableAccess) {
			javaMM.SingleVariableAccess e = (javaMM.SingleVariableAccess) elem;
			return new javaMMinJava.SingleVariableAccess(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.VariableDeclaration) transformEMF2Java(
							e.getVariable(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getQualifier(), map));
		}

		if (elem instanceof javaMM.SingleVariableDeclaration) {
			javaMM.SingleVariableDeclaration e = (javaMM.SingleVariableDeclaration) elem;
			return new javaMMinJava.SingleVariableDeclaration(map.get(e),
					e.getName(), e.isProxy(), e.getExtraArrayDimensions(),
					e.isVarargs(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getInitializer(), map),
					(javaMMinJava.SingleVariableAccess[]) transformEMF2Java(
							e.getUsageInVariableAccess(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map), (javaMMinJava.TypeAccess) transformEMF2Java(
							e.getType(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethodDeclaration(), map),
					(javaMMinJava.CatchClause) transformEMF2Java(
							e.getCatchClause(), map),
					(javaMMinJava.EnhancedForStatement) transformEMF2Java(
							e.getEnhancedForStatement(), map));
		}

		if (elem instanceof javaMM.StringLiteral) {
			javaMM.StringLiteral e = (javaMM.StringLiteral) elem;
			return new javaMMinJava.StringLiteral(map.get(e), e
					.getEscapedValue().toString(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.SuperConstructorInvocation) {
			javaMM.SuperConstructorInvocation e = (javaMM.SuperConstructorInvocation) elem;
			return new javaMMinJava.SuperConstructorInvocation(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethod(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getArguments(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getTypeArguments(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.SuperFieldAccess) {
			javaMM.SuperFieldAccess e = (javaMM.SuperFieldAccess) elem;
			return new javaMMinJava.SuperFieldAccess(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getQualifier(), map),
					(javaMMinJava.SingleVariableAccess) transformEMF2Java(
							e.getField(), map));
		}

		if (elem instanceof javaMM.SuperMethodInvocation) {
			javaMM.SuperMethodInvocation e = (javaMM.SuperMethodInvocation) elem;
			return new javaMMinJava.SuperMethodInvocation(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getQualifier(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethod(), map),
					(javaMMinJava.Expression[]) transformEMF2Java(
							e.getArguments(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getTypeArguments(), map));
		}

		if (elem instanceof javaMM.SwitchCase) {
			javaMM.SwitchCase e = (javaMM.SwitchCase) elem;
			return new javaMMinJava.SwitchCase(map.get(e), e.isDefault(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.SwitchStatement) {
			javaMM.SwitchStatement e = (javaMM.SwitchStatement) elem;
			return new javaMMinJava.SwitchStatement(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.Statement[]) transformEMF2Java(
							e.getStatements(), map));
		}

		if (elem instanceof javaMM.SynchronizedStatement) {
			javaMM.SynchronizedStatement e = (javaMM.SynchronizedStatement) elem;
			return new javaMMinJava.SynchronizedStatement(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Block) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.TagElement) {
			javaMM.TagElement e = (javaMM.TagElement) elem;
			return new javaMMinJava.TagElement(map.get(e), e.getTagName(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ASTNode[]) transformEMF2Java(
							e.getFragments(), map));
		}

		if (elem instanceof javaMM.TextElement) {
			javaMM.TextElement e = (javaMM.TextElement) elem;
			return new javaMMinJava.TextElement(map.get(e), e.getText(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map));
		}

		if (elem instanceof javaMM.ThisExpression) {
			javaMM.ThisExpression e = (javaMM.ThisExpression) elem;
			return new javaMMinJava.ThisExpression(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getQualifier(), map));
		}

		if (elem instanceof javaMM.ThrowStatement) {
			javaMM.ThrowStatement e = (javaMM.ThrowStatement) elem;
			return new javaMMinJava.ThrowStatement(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map));
		}

		if (elem instanceof javaMM.TryStatement) {
			javaMM.TryStatement e = (javaMM.TryStatement) elem;
			return new javaMMinJava.TryStatement(
					map.get(e),

					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Block) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.Block) transformEMF2Java(e.getFinally(), map),
					(javaMMinJava.CatchClause[]) transformEMF2Java(
							e.getCatchClauses(), map));
		}

		if (elem instanceof javaMM.TypeAccess) {
			javaMM.TypeAccess e = (javaMM.TypeAccess) elem;
			return new javaMMinJava.TypeAccess(map.get(e),

			(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Type) transformEMF2Java(e.getType(), map),
					(javaMMinJava.NamespaceAccess) transformEMF2Java(
							e.getQualifier(), map));
		}

		if (elem instanceof javaMM.TypeDeclarationStatement) {
			javaMM.TypeDeclarationStatement e = (javaMM.TypeDeclarationStatement) elem;
			return new javaMMinJava.TypeDeclarationStatement(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getDeclaration(), map));
		}

		if (elem instanceof javaMM.TypeLiteral) {
			javaMM.TypeLiteral e = (javaMM.TypeLiteral) elem;
			return new javaMMinJava.TypeLiteral(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map));
		}

		if (elem instanceof javaMM.TypeParameter) {
			javaMM.TypeParameter e = (javaMM.TypeParameter) elem;
			return new javaMMinJava.TypeParameter(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getBounds(), map));
		}

		if (elem instanceof javaMM.UnresolvedItem) {
			javaMM.UnresolvedItem e = (javaMM.UnresolvedItem) elem;
			return new javaMMinJava.UnresolvedItem(map.get(e), e.getName(),
					e.eIsProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map));
		}

		if (elem instanceof javaMM.UnresolvedItemAccess) {
			javaMM.UnresolvedItemAccess e = (javaMM.UnresolvedItemAccess) elem;
			return new javaMMinJava.UnresolvedItemAccess(map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.UnresolvedItem) transformEMF2Java(
							e.getElement(), map),
					(javaMMinJava.ASTNode) transformEMF2Java(e.getQualifier(),
							map));
		}

		if (elem instanceof javaMM.UnresolvedAnnotationDeclaration) {
			javaMM.UnresolvedAnnotationDeclaration e = (javaMM.UnresolvedAnnotationDeclaration) elem;
			return new javaMMinJava.UnresolvedAnnotationDeclaration(map.get(e),
					e.getName(), e.eIsProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map));
		}

		if (elem instanceof javaMM.UnresolvedAnnotationTypeMemberDeclaration) {
			javaMM.UnresolvedAnnotationTypeMemberDeclaration e = (javaMM.UnresolvedAnnotationTypeMemberDeclaration) elem;
			return new javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration(
					map.get(e),
					e.getName(),
					e.eIsProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.Expression) transformEMF2Java(e.getDefault(),
							map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map),
					(javaMMinJava.AnnotationMemberValuePair[]) transformEMF2Java(
							e.getUsages(), map));
		}

		if (elem instanceof javaMM.UnresolvedClassDeclaration) {
			javaMM.UnresolvedClassDeclaration e = (javaMM.UnresolvedClassDeclaration) elem;
			return new javaMMinJava.UnresolvedClassDeclaration(map.get(e),
					e.getName(), e.eIsProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map),
					(javaMMinJava.TypeParameter[]) transformEMF2Java(
							e.getTypeParameters(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getSuperClass(), map));
		}

		if (elem instanceof javaMM.UnresolvedEnumDeclaration) {
			javaMM.UnresolvedEnumDeclaration e = (javaMM.UnresolvedEnumDeclaration) elem;
			return new javaMMinJava.UnresolvedEnumDeclaration(map.get(e),
					e.getName(), e.eIsProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map),
					(javaMMinJava.EnumConstantDeclaration[]) transformEMF2Java(
							e.getEnumConstants(), map));
		}

		if (elem instanceof javaMM.UnresolvedInterfaceDeclaration) {
			javaMM.UnresolvedInterfaceDeclaration e = (javaMM.UnresolvedInterfaceDeclaration) elem;
			return new javaMMinJava.UnresolvedInterfaceDeclaration(map.get(e),
					e.getName(), e.eIsProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map),
					(javaMMinJava.TypeParameter[]) transformEMF2Java(
							e.getTypeParameters(), map));
		}

		if (elem instanceof javaMM.UnresolvedLabeledStatement) {
			javaMM.UnresolvedLabeledStatement e = (javaMM.UnresolvedLabeledStatement) elem;
			return new javaMMinJava.UnresolvedLabeledStatement(
					map.get(e),
					e.getName(),
					e.eIsProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.Statement) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.BreakStatement[]) transformEMF2Java(
							e.getUsagesInBreakStatements(), map),
					(javaMMinJava.ContinueStatement[]) transformEMF2Java(
							e.getUsagesInContinueStatements(), map));
		}

		if (elem instanceof javaMM.UnresolvedMethodDeclaration) {
			javaMM.UnresolvedMethodDeclaration e = (javaMM.UnresolvedMethodDeclaration) elem;
			return new javaMMinJava.UnresolvedMethodDeclaration(
					map.get(e),
					e.getName(),
					e.eIsProxy(),
					e.getExtraArrayDimensions(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.Block) transformEMF2Java(e.getBody(), map),
					(javaMMinJava.SingleVariableDeclaration[]) transformEMF2Java(
							e.getParameters(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getThrownExceptions(), map),
					(javaMMinJava.TypeParameter[]) transformEMF2Java(
							e.getTypeParameters(), map),
					(javaMMinJava.MethodRef[]) transformEMF2Java(
							e.getUsagesInDocComments(), map),
					(javaMMinJava.AbstractMethodInvocation[]) transformEMF2Java(
							e.getUsages(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(
							e.getReturnType(), map),
					(javaMMinJava.MethodDeclaration) transformEMF2Java(
							e.getRedefinedMethodDeclaration(), map),
					(javaMMinJava.MethodDeclaration[]) transformEMF2Java(
							e.getRedefinitions(), map));
		}

		if (elem instanceof javaMM.UnresolvedSingleVariableDeclaration) {
			javaMM.UnresolvedSingleVariableDeclaration e = (javaMM.UnresolvedSingleVariableDeclaration) elem;
			return new javaMMinJava.UnresolvedSingleVariableDeclaration(
					map.get(e), e.getName(), e.isProxy(),
					e.getExtraArrayDimensions(), e.isVarargs(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getInitializer(), map),
					(javaMMinJava.SingleVariableAccess[]) transformEMF2Java(
							e.getUsageInVariableAccess(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map), (javaMMinJava.TypeAccess) transformEMF2Java(
							e.getType(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AbstractMethodDeclaration) transformEMF2Java(
							e.getMethodDeclaration(), map),
					(javaMMinJava.CatchClause) transformEMF2Java(
							e.getCatchClause(), map),
					(javaMMinJava.EnhancedForStatement) transformEMF2Java(
							e.getEnhancedForStatement(), map));
		}

		if (elem instanceof javaMM.UnresolvedType) {
			javaMM.UnresolvedType e = (javaMM.UnresolvedType) elem;
			return new javaMMinJava.UnresolvedType(map.get(e), e.getName(),
					e.isProxy(), (javaMMinJava.Comment[]) transformEMF2Java(
							e.getComments(), map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map));
		}

		if (elem instanceof javaMM.UnresolvedTypeDeclaration) {
			javaMM.UnresolvedTypeDeclaration e = (javaMM.UnresolvedTypeDeclaration) elem;
			return new javaMMinJava.UnresolvedTypeDeclaration(map.get(e),
					e.getName(), e.isProxy(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.AbstractTypeDeclaration) transformEMF2Java(
							e.getAbstractTypeDeclaration(), map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map),
					(javaMMinJava.AnonymousClassDeclaration) transformEMF2Java(
							e.getAnonymousClassDeclarationOwner(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.BodyDeclaration[]) transformEMF2Java(
							e.getBodyDeclarations(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsBeforeBody(), map),
					(javaMMinJava.Comment[]) transformEMF2Java(
							e.getCommentsAfterBody(), map),
					(javaMMinJava.Package) transformEMF2Java(e.getPackage(),
							map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getSuperInterfaces(), map));
		}

		if (elem instanceof javaMM.UnresolvedVariableDeclarationFragment) {
			javaMM.UnresolvedVariableDeclarationFragment e = (javaMM.UnresolvedVariableDeclarationFragment) elem;
			return new javaMMinJava.UnresolvedVariableDeclarationFragment(
					map.get(e),
					e.getName(),
					e.eIsProxy(),
					e.getExtraArrayDimensions(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getInitializer(), map),
					(javaMMinJava.SingleVariableAccess[]) transformEMF2Java(
							e.getUsageInVariableAccess(), map),
					(javaMMinJava.AbstractVariablesContainer) transformEMF2Java(
							e.getVariablesContainer(), map));
		}

		if (elem instanceof javaMM.VariableDeclarationExpression) {
			javaMM.VariableDeclarationExpression e = (javaMM.VariableDeclarationExpression) elem;
			return new javaMMinJava.VariableDeclarationExpression(
					map.get(e),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map),
					(javaMMinJava.VariableDeclarationFragment[]) transformEMF2Java(
							e.getFragments(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map));
		}

		if (elem instanceof javaMM.VariableDeclarationFragment) {
			javaMM.VariableDeclarationFragment e = (javaMM.VariableDeclarationFragment) elem;
			return new javaMMinJava.VariableDeclarationFragment(
					map.get(e),
					e.getName(),
					e.eIsProxy(),
					e.getExtraArrayDimensions(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getInitializer(), map),
					(javaMMinJava.SingleVariableAccess[]) transformEMF2Java(
							e.getUsageInVariableAccess(), map),
					(javaMMinJava.AbstractVariablesContainer) transformEMF2Java(
							e.getVariablesContainer(), map));
		}

		if (elem instanceof javaMM.VariableDeclarationStatement) {
			javaMM.VariableDeclarationStatement e = (javaMM.VariableDeclarationStatement) elem;
			return new javaMMinJava.VariableDeclarationStatement(
					map.get(e),
					e.getExtraArrayDimensions(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getType(),
							map),
					(javaMMinJava.VariableDeclarationFragment[]) transformEMF2Java(
							e.getFragments(), map),
					(javaMMinJava.Modifier) transformEMF2Java(e.getModifier(),
							map),
					(javaMMinJava.Annotation[]) transformEMF2Java(
							e.getAnnotations(), map));
		}

		if (elem instanceof javaMM.WildCardType) {
			javaMM.WildCardType e = (javaMM.WildCardType) elem;
			return new javaMMinJava.WildCardType(map.get(e), e.getName(),
					e.eIsProxy(), e.isUpperBound(),
					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.ImportDeclaration[]) transformEMF2Java(
							e.getUsagesInImports(), map),
					(javaMMinJava.TypeAccess[]) transformEMF2Java(
							e.getUsagesInTypeAccess(), map),
					(javaMMinJava.TypeAccess) transformEMF2Java(e.getBound(),
							map));
		}

		if (elem instanceof javaMM.WhileStatement) {
			javaMM.WhileStatement e = (javaMM.WhileStatement) elem;
			return new javaMMinJava.WhileStatement(
					map.get(e),

					(javaMMinJava.Comment[]) transformEMF2Java(e.getComments(),
							map),
					(javaMMinJava.CompilationUnit) transformEMF2Java(
							e.getOriginalCompilationUnit(), map),
					(javaMMinJava.ClassFile) transformEMF2Java(
							e.getOriginalClassFile(), map),
					(javaMMinJava.Expression) transformEMF2Java(
							e.getExpression(), map),
					(javaMMinJava.Statement) transformEMF2Java(e.getBody(), map));
		}

		return null;
	}

	private static IdentifiableElement[] toIds(EList<EObject> objs,
			Map<EObject, String> map) {
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
