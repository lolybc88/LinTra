package javaMM;

import java.io.Serializable;

public class MethodDeclaration extends AbstractMethodDeclaration
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	int extraArrayDimensions;

	String returnTypeID;
	Boolean returnTypeIsComposed = true;

	String redefinedMethodDeclarationID;
	Boolean redefinedMethodDeclarationIsComposed = false;

	String[] redefinitionsID;
	Boolean redefinitionsIsComposed = false;

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

}
