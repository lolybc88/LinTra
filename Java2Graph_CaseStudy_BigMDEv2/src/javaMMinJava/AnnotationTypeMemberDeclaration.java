package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class AnnotationTypeMemberDeclaration extends BodyDeclaration
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String defaultID;
	Boolean defaultIsComposed = true;

	String typeID;
	Boolean typeIsComposed = true;

	String[] usagesID;
	Boolean usagesIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public AnnotationTypeMemberDeclaration() {
	}

	public AnnotationTypeMemberDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID,
			String originalClassFileID, 
			String name, Boolean proxy, String[] usagesInImportsID, 
			String abstractTypeDeclarationID, 
			String[] annotationsID,
			String anonymousClassDeclarationOwnerID,
			String modifierID, Modifier modifier,
			String defaultID, String typeID, String[] usagesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				name, proxy, usagesInImportsID,
				abstractTypeDeclarationID, annotationsID,
				anonymousClassDeclarationOwnerID, modifierID, modifier);

		this.id = id;

		this.defaultID = defaultID;
		this.typeID = typeID;
		this.usagesID = usagesID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDefault(String defaultID) {
		this.defaultID = defaultID;
	}

	public String getDefault() {
		return defaultID;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

	public void setUsages(String[] usagesID) {
		this.usagesID = usagesID;
	}

	public String[] getUsages() {
		return usagesID;
	}

}
