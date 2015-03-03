package javaMM;

import java.io.Serializable;

public class ClassDeclaration extends TypeDeclaration implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String superClassID;
	Boolean superClassIsComposed = true;

	public ClassDeclaration() {
	}

	public ClassDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, String[] superInterfacesID,
			String[] typeParametersID, String superClassID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID,
				usagesInTypeAccessID, bodyDeclarationsID, commentsBeforeBodyID,
				commentsAfterBodyID, packageID, superInterfacesID,
				typeParametersID);

		this.id = id;

		this.superClassID = superClassID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSuperClass(String superClassID) {
		this.superClassID = superClassID;
	}

	public String getSuperClass() {
		return superClassID;
	}

}
