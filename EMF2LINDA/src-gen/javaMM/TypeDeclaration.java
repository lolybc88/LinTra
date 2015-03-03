package javaMM;

import java.io.Serializable;

public abstract class TypeDeclaration extends AbstractTypeDeclaration
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	String[] typeParametersID;
	Boolean typeParametersIsComposed = true;

	public TypeDeclaration() {
	}

	public TypeDeclaration(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, String[] superInterfacesID,
			String[] typeParametersID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID,
				usagesInTypeAccessID, bodyDeclarationsID, commentsBeforeBodyID,
				commentsAfterBodyID, packageID, superInterfacesID);

		this.typeParametersID = typeParametersID;
	}

	public void setTypeParameters(String[] typeParametersID) {
		this.typeParametersID = typeParametersID;
	}

	public String[] getTypeParameters() {
		return typeParametersID;
	}

}
