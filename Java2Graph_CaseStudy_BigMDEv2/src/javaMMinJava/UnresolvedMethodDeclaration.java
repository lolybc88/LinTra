package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class UnresolvedMethodDeclaration extends MethodDeclaration
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	public UnresolvedMethodDeclaration() {
	}

	public UnresolvedMethodDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier,
			String bodyID, String[] parametersID, String[] thrownExceptionsID,
			String[] typeParametersID, String[] usagesInDocCommentsID,
			String[] usagesID, int extraArrayDimensions, String returnTypeID,
			String redefinedMethodDeclarationID, String[] redefinitionsID) {
		super(id, commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier,
				bodyID, parametersID, thrownExceptionsID, typeParametersID,
				usagesInDocCommentsID, usagesID, extraArrayDimensions,
				returnTypeID, redefinedMethodDeclarationID, redefinitionsID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
