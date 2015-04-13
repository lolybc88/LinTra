package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class FieldDeclaration extends BodyDeclaration implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;
	
	String typeID; Boolean typeIsComposed = true;
	String[] fragmentsID; Boolean fragmentsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}


	public FieldDeclaration() {
	}

	public FieldDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier,
			String typeID, String[] fragmentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier);

		this.id = id;
		this.typeID = typeID;
		this.fragmentsID = fragmentsID;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public synchronized String getTypeID() {
		return typeID;
	}

	public synchronized void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public synchronized String[] getFragmentsID() {
		return fragmentsID;
	}

	public synchronized void setFragmentsID(String[] fragmentsID) {
		this.fragmentsID = fragmentsID;
	}

}
