package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class AnnotationTypeDeclaration extends AbstractTypeDeclaration
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public AnnotationTypeDeclaration() {
	}

	public AnnotationTypeDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, String[] superInterfacesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID,
				usagesInTypeAccessID, bodyDeclarationsID, commentsBeforeBodyID,
				commentsAfterBodyID, packageID, superInterfacesID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getUsagesInTypeAccess() {
		return usagesInTypeAccessID;
	}

	@Override
	public String toString() {
		return "AnnotationTypeDeclaration [id=" + id + ", trgId=" + trgId
				+ ", name=" + name + "]";
	}

}
