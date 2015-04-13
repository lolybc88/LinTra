package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class UnresolvedMethodDeclaration extends MethodDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public UnresolvedMethodDeclaration() {
	}

	public UnresolvedMethodDeclaration(String id, String name, Boolean proxy,
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

		super(id,name, proxy, extraArrayDimensions, comments,
				originalCompilationUnit, originalClassFile, usagesInImports,
				abstractTypeDeclaration, annotations,
				anonymousClassDeclarationOwner, modifier, body, parameters,
				thrownExceptions, typeParameters, usagesInDocComments, usages,
				returnType, redefinedMethodDeclaration, redefinitions);

		this.id = id;

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

}
