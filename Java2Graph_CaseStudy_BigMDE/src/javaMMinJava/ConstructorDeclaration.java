package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class ConstructorDeclaration extends AbstractMethodDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public ConstructorDeclaration() {
	}

	public ConstructorDeclaration(String id, String name, Boolean proxy,
			Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation[] annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, Block body,
			SingleVariableDeclaration[] parameters, TypeAccess[] thrownExceptions,
			TypeParameter[] typeParameters, MethodRef[] usagesInDocComments,
			AbstractMethodInvocation[] usages) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier, body,
				parameters, thrownExceptions, typeParameters,
				usagesInDocComments, usages);

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
