package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class MethodDeclaration extends AbstractMethodDeclaration
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	int extraArrayDimensions;

	String returnTypeID;
	Boolean returnTypeIsComposed = true;

	String redefinedMethodDeclarationID;
	Boolean redefinedMethodDeclarationIsComposed = false;

	String[] redefinitionsID;
	Boolean redefinitionsIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public MethodDeclaration() {
	}

	public MethodDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String bodyID, String[] parametersID, String[] thrownExceptionsID,
			String[] typeParametersID, String[] usagesInDocCommentsID,
			String[] usagesID, int extraArrayDimensions, String returnTypeID,
			String redefinedMethodDeclarationID, String[] redefinitionsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID,
				bodyID, parametersID, thrownExceptionsID, typeParametersID,
				usagesInDocCommentsID, usagesID);

		this.id = id;

		this.extraArrayDimensions = extraArrayDimensions;

		this.returnTypeID = returnTypeID;
		this.redefinedMethodDeclarationID = redefinedMethodDeclarationID;
		this.redefinitionsID = redefinitionsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setExtraArrayDimensions(int extraArrayDimensions) {
		this.extraArrayDimensions = extraArrayDimensions;
	}

	public int getExtraArrayDimensions() {
		return extraArrayDimensions;
	}

	public void setReturnType(String returnTypeID) {
		this.returnTypeID = returnTypeID;
	}

	public String getReturnType() {
		return returnTypeID;
	}

	public void setRedefinedMethodDeclaration(
			String redefinedMethodDeclarationID) {
		this.redefinedMethodDeclarationID = redefinedMethodDeclarationID;
	}

	public String getRedefinedMethodDeclaration() {
		return redefinedMethodDeclarationID;
	}

	public void setRedefinitions(String[] redefinitionsID) {
		this.redefinitionsID = redefinitionsID;
	}

	public String[] getRedefinitions() {
		return redefinitionsID;
	}

	@Override
	public String toString() {
		return "MethodDeclaration [id=" + id + ", extraArrayDimensions="
				+ extraArrayDimensions + ", returnTypeID=" + returnTypeID
				+ ", returnTypeIsComposed=" + returnTypeIsComposed
				+ ", redefinedMethodDeclarationID="
				+ redefinedMethodDeclarationID + ", redefinitionsID="
				+ Arrays.toString(redefinitionsID)
				+ ", redefinitionsIsComposed=" + redefinitionsIsComposed
				+ ", trgId=" + trgId + ", bodyID=" + bodyID + ", parametersID="
				+ Arrays.toString(parametersID) + ", thrownExceptionsID="
				+ Arrays.toString(thrownExceptionsID) + ", typeParametersID="
				+ Arrays.toString(typeParametersID)
				+ ", usagesInDocCommentsID="
				+ Arrays.toString(usagesInDocCommentsID) + ", usagesID="
				+ Arrays.toString(usagesID) + ", abstractTypeDeclarationID="
				+ abstractTypeDeclarationID + ", annotationsID="
				+ Arrays.toString(annotationsID) + ", annotationsIsComposed="
				+ annotationsIsComposed + ", anonymousClassDeclarationOwnerID="
				+ anonymousClassDeclarationOwnerID + ", modifierID="
				+ modifierID + ", name=" + name + ", proxy=" + proxy
				+ ", usagesInImportsID=" + Arrays.toString(usagesInImportsID)
				+ ", commentsID=" + Arrays.toString(commentsID)
				+ ", commentsIsComposed=" + commentsIsComposed
				+ ", originalCompilationUnitID=" + originalCompilationUnitID
				+ ", originalClassFileID=" + originalClassFileID + "]";
	}

}
