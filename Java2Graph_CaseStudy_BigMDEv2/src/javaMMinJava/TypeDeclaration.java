package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class TypeDeclaration extends AbstractTypeDeclaration
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String[] typeParametersID;
	Boolean typeParametersIsComposed = true;

	public TypeDeclaration() {
	}

	public TypeDeclaration(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, Package package_, String[] superInterfacesID,
			String[] typeParametersID) {
		
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier,
				usagesInTypeAccessID, bodyDeclarationsID, commentsBeforeBodyID,
				commentsAfterBodyID, packageID, package_, superInterfacesID);

		this.typeParametersID = typeParametersID;
	}

	public void setTypeParameters(String[] typeParametersID) {
		this.typeParametersID = typeParametersID;
	}

	public String[] getTypeParameters() {
		return typeParametersID;
	}

}
