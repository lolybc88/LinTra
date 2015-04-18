package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class ClassDeclaration extends TypeDeclaration implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String superClassID;
	Boolean superClassIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ClassDeclaration() {
	}

	public ClassDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, AbstractTypeDeclaration abstractTypeDeclaration, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID, BodyDeclaration[] bodyDeclarations,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, Package package_, String[] superInterfacesID,
			String[] typeParametersID, String superClassID) {
		
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID, abstractTypeDeclaration,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier,
				usagesInTypeAccessID, bodyDeclarationsID, bodyDeclarations, commentsBeforeBodyID,
				commentsAfterBodyID, packageID, package_, superInterfacesID,
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

	public String[] getUsagesInTypeAccess() {
		return usagesInTypeAccessID;
	}

	@Override
	public String toString() {
		return "ClassDeclaration [id=" + id + ", superClassID=" + superClassID
				+ ", superClassIsComposed=" + superClassIsComposed + ", trgId="
				+ trgId + ", typeParametersID="
				+ Arrays.toString(typeParametersID)
				+ ", typeParametersIsComposed=" + typeParametersIsComposed
				+ ", bodyDeclarationsID=" + Arrays.toString(bodyDeclarationsID)
				+ ", bodyDeclarationsIsComposed=" + bodyDeclarationsIsComposed
				+ ", commentsBeforeBodyID="
				+ Arrays.toString(commentsBeforeBodyID)
				+ ", commentsBeforeBodyIsComposed="
				+ commentsBeforeBodyIsComposed + ", commentsAfterBodyID="
				+ Arrays.toString(commentsAfterBodyID)
				+ ", commentsAfterBodyIsComposed="
				+ commentsAfterBodyIsComposed + ", packageID=" + packageID
				+ ", package_=" + package_ + ", packageIsComposed="
				+ packageIsComposed + ", superInterfacesID="
				+ Arrays.toString(superInterfacesID)
				+ ", superInterfacesIsComposed=" + superInterfacesIsComposed
				+ ", usagesInTypeAccessID="
				+ Arrays.toString(usagesInTypeAccessID)
				+ ", usagesInTypeAccessIsComposed="
				+ usagesInTypeAccessIsComposed + ", abstractTypeDeclarationID="
				+ abstractTypeDeclarationID
				+ ", abstractTypeDeclarationIsComposed="
				+ abstractTypeDeclarationIsComposed + ", annotationsID="
				+ Arrays.toString(annotationsID) + ", annotationsIsComposed="
				+ annotationsIsComposed + ", anonymousClassDeclarationOwnerID="
				+ anonymousClassDeclarationOwnerID
				+ ", anonymousClassDeclarationOwnerIsComposed="
				+ anonymousClassDeclarationOwnerIsComposed + ", modifierID="
				+ modifierID + ", modifier=" + modifier
				+ ", modifierIsComposed=" + modifierIsComposed + ", name="
				+ name + ", proxy=" + proxy + ", usagesInImportsID="
				+ Arrays.toString(usagesInImportsID)
				+ ", usagesInImportsIsComposed=" + usagesInImportsIsComposed
				+ ", commentsID=" + Arrays.toString(commentsID)
				+ ", commentsIsComposed=" + commentsIsComposed
				+ ", originalCompilationUnitID=" + originalCompilationUnitID
				+ ", originalCompilationUnitIsComposed="
				+ originalCompilationUnitIsComposed + ", originalClassFileID="
				+ originalClassFileID + ", originalClassFileIsComposed="
				+ originalClassFileIsComposed + "]";
	}

}
