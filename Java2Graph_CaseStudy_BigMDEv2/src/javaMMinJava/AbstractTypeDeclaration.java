package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class AbstractTypeDeclaration extends BodyDeclaration implements Serializable, IdentifiableElement, IType {

	private static final long serialVersionUID = 1L;

	String[] bodyDeclarationsID;
	BodyDeclaration[] bodyDeclarations;
	Boolean bodyDeclarationsIsComposed = true;

	String[] commentsBeforeBodyID;
	Boolean commentsBeforeBodyIsComposed = true;

	String[] commentsAfterBodyID;
	Boolean commentsAfterBodyIsComposed = true;

	String packageID;
	Package package_;
	Boolean packageIsComposed = false;

	String[] superInterfacesID;
	Boolean superInterfacesIsComposed = true;
	
	String[] usagesInTypeAccessID;
	Boolean usagesInTypeAccessIsComposed = false;

	public AbstractTypeDeclaration() { }

	public AbstractTypeDeclaration(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, AbstractTypeDeclaration abstractTypeDeclaration, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier,
			String[] usagesInTypeAccessID, String[] bodyDeclarationsID, BodyDeclaration[] bodyDeclarations,
			String[] commentsBeforeBodyID, String[] commentsAfterBodyID,
			String packageID, Package package_, String[] superInterfacesID) {
		
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID, abstractTypeDeclaration,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier);

		this.bodyDeclarationsID = bodyDeclarationsID;
		this.bodyDeclarations = bodyDeclarations;
		this.commentsBeforeBodyID = commentsBeforeBodyID;
		this.commentsAfterBodyID = commentsAfterBodyID;
		this.packageID = packageID;
		this.superInterfacesID = superInterfacesID;
		
		this.usagesInImportsID = usagesInImportsID;
		this.package_ = package_;
	}

	public void setBodyDeclarationsID(String[] bodyDeclarationsID) {
		this.bodyDeclarationsID = bodyDeclarationsID;
	}

	public String[] getBodyDeclarationsID() {
		return bodyDeclarationsID;
	}

	public BodyDeclaration[] getBodyDeclarations() {
		return bodyDeclarations;
	}

	public void setBodyDeclarations(BodyDeclaration[] bodyDeclarations) {
		this.bodyDeclarations = bodyDeclarations;
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

	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}

	public String getPackageID() {
		return packageID;
	}

	public void setSuperInterfaces(String[] superInterfacesID) {
		this.superInterfacesID = superInterfacesID;
	}

	public String[] getSuperInterfaces() {
		return superInterfacesID;
	}

	public Package getPackage() {
		return package_;
	}

	public void setPackage(Package package_) {
		this.package_ = package_;
	}
	
	

}
