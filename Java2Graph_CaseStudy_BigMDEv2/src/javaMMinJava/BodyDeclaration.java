package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class BodyDeclaration extends NamedElement
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String abstractTypeDeclarationID;
	Boolean abstractTypeDeclarationIsComposed = false;

	String[] annotationsID;
	Boolean annotationsIsComposed = true;

	String anonymousClassDeclarationOwnerID;
	Boolean anonymousClassDeclarationOwnerIsComposed = false;

	String modifierID;
	Modifier modifier;
	Boolean modifierIsComposed = true;

	public BodyDeclaration() { }

	public BodyDeclaration(String[] commentsID, 
			String originalCompilationUnitID, 
			String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier) {
		
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.abstractTypeDeclarationID = abstractTypeDeclarationID;
		
		this.annotationsID = annotationsID;
		
		this.anonymousClassDeclarationOwnerID = anonymousClassDeclarationOwnerID;
		
		this.modifierID = modifierID;
		
		this.modifier = modifier;
	}

	public void setAbstractTypeDeclaration(String abstractTypeDeclarationID) {
		this.abstractTypeDeclarationID = abstractTypeDeclarationID;
	}

	public String getAbstractTypeDeclaration() {
		return abstractTypeDeclarationID;
	}

	public void setAnnotations(String[] annotationsID) {
		this.annotationsID = annotationsID;
	}

	public String[] getAnnotations() {
		return annotationsID;
	}

	public void setAnonymousClassDeclarationOwner(
			String anonymousClassDeclarationOwnerID) {
		this.anonymousClassDeclarationOwnerID = anonymousClassDeclarationOwnerID;
	}

	public String getAnonymousClassDeclarationOwner() {
		return anonymousClassDeclarationOwnerID;
	}

	public void setModifierID(String modifierID) {
		this.modifierID = modifierID;
	}

	public String getModifierID() {
		return modifierID;
	}

	public Modifier getModifier() {
		return modifier;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

}