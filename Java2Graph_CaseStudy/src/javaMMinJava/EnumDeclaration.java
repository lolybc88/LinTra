package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class EnumDeclaration extends AbstractTypeDeclaration
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String[] enumConstantsID;
	Boolean enumConstantsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public EnumDeclaration() {
	}

	public EnumDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, String[] superInterfacesID,
			String[] enumConstantsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID,
				usagesInTypeAccessID, bodyDeclarationsID, commentsBeforeBodyID,
				commentsAfterBodyID, packageID, superInterfacesID);

		this.id = id;

		this.enumConstantsID = enumConstantsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEnumConstants(String[] enumConstantsID) {
		this.enumConstantsID = enumConstantsID;
	}

	public String[] getEnumConstants() {
		return enumConstantsID;
	}

	public String[] getUsagesInTypeAccess() {
		return usagesInTypeAccessID;
	}

}
