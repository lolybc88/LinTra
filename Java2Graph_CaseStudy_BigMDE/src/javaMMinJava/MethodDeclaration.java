package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class MethodDeclaration extends AbstractMethodDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	int extraArrayDimensions;

	TypeAccess returnType;
	Boolean returnTypeIsComposed = true;

	MethodDeclaration redefinedMethodDeclaration;
	Boolean redefinedMethodDeclarationIsComposed = false;

	MethodDeclaration[] redefinitions;
	Boolean redefinitionsIsComposed = false;

	public MethodDeclaration() {
	}

	public MethodDeclaration(String id, String name, Boolean proxy,
			int extraArrayDimensions, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation[] annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, Block body,
			SingleVariableDeclaration[] parameters, TypeAccess[] thrownExceptions,
			TypeParameter[] typeParameters, MethodRef[] usagesInDocComments,
			AbstractMethodInvocation[] usages, TypeAccess returnType,
			MethodDeclaration redefinedMethodDeclaration,
			MethodDeclaration[] redefinitions) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier, body,
				parameters, thrownExceptions, typeParameters,
				usagesInDocComments, usages);

		this.id = id;

		this.extraArrayDimensions = extraArrayDimensions;

		this.returnType = returnType;
		this.redefinedMethodDeclaration = redefinedMethodDeclaration;
		this.redefinitions = redefinitions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public void setExtraArrayDimensions(int extraArrayDimensions) {
		this.extraArrayDimensions = extraArrayDimensions;
	}

	public int getExtraArrayDimensions() {
		return extraArrayDimensions;
	}

	public void setReturnType(TypeAccess returnType) {
		this.returnType = returnType;
	}

	public TypeAccess getReturnType() {
		return returnType;
	}

	public void setRedefinedMethodDeclaration(
			MethodDeclaration redefinedMethodDeclaration) {
		this.redefinedMethodDeclaration = redefinedMethodDeclaration;
	}

	public MethodDeclaration getRedefinedMethodDeclaration() {
		return redefinedMethodDeclaration;
	}

	public void setRedefinitions(MethodDeclaration[] redefinitions) {
		this.redefinitions = redefinitions;
	}

	public MethodDeclaration[] getRedefinitions() {
		return redefinitions;
	}

}
