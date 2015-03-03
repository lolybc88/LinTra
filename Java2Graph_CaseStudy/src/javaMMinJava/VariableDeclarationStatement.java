package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class VariableDeclarationStatement extends AbstractVariablesContainer
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	int extraArrayDimensions;

	String modifierID;
	Boolean modifierIsComposed = true;

	String[] annotationsID;
	Boolean annotationsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public VariableDeclarationStatement() {
	}

	public VariableDeclarationStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String typeID, String[] fragmentsID, int extraArrayDimensions,
			String modifierID, String[] annotationsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				typeID, fragmentsID);

		this.id = id;

		this.extraArrayDimensions = extraArrayDimensions;

		this.modifierID = modifierID;
		this.annotationsID = annotationsID;
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

	public void setModifier(String modifierID) {
		this.modifierID = modifierID;
	}

	public String getModifier() {
		return modifierID;
	}

	public void setAnnotations(String[] annotationsID) {
		this.annotationsID = annotationsID;
	}

	public String[] getAnnotations() {
		return annotationsID;
	}

}
