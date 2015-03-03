package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class AbstractTypeDeclaration extends BodyDeclaration implements Serializable, IdentifiableElement, IType {

	private static final long serialVersionUID = 1L;

	String[] bodyDeclarationsID;
	Boolean bodyDeclarationsIsComposed = true;

	String[] commentsBeforeBodyID;
	Boolean commentsBeforeBodyIsComposed = true;

	String[] commentsAfterBodyID;
	Boolean commentsAfterBodyIsComposed = true;

	String packageID;
	Boolean packageIsComposed = false;

	String[] superInterfacesID;
	Boolean superInterfacesIsComposed = true;
	
	String[] usagesInTypeAccessID;
	Boolean usagesInTypeAccessIsComposed = false;

	public AbstractTypeDeclaration() { }

	public AbstractTypeDeclaration(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, String[] superInterfacesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID);

		this.bodyDeclarationsID = bodyDeclarationsID;
		this.commentsBeforeBodyID = commentsBeforeBodyID;
		this.commentsAfterBodyID = commentsAfterBodyID;
		this.packageID = packageID;
		this.superInterfacesID = superInterfacesID;
		
		this.usagesInImportsID = usagesInImportsID;
	}

	public void setBodyDeclarations(String[] bodyDeclarationsID) {
		this.bodyDeclarationsID = bodyDeclarationsID;
	}

	public String[] getBodyDeclarations() {
		return bodyDeclarationsID;
	}

	public void setCommentsBeforeBody(String[] commentsBeforeBodyID) {
		this.commentsBeforeBodyID = commentsBeforeBodyID;
	}

	public String[] getCommentsBeforeBody() {
		return commentsBeforeBodyID;
	}

	public void setCommentsAfterBody(String[] commentsAfterBodyID) {
		this.commentsAfterBodyID = commentsAfterBodyID;
	}

	public String[] getCommentsAfterBody() {
		return commentsAfterBodyID;
	}

	public void setPackage(String packageID) {
		this.packageID = packageID;
	}

	public String getPackage() {
		return packageID;
	}

	public void setSuperInterfaces(String[] superInterfacesID) {
		this.superInterfacesID = superInterfacesID;
	}

	public String[] getSuperInterfaces() {
		return superInterfacesID;
	}

}
