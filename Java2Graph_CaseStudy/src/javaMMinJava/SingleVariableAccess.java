package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class SingleVariableAccess extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String variableID;
	Boolean variableIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public SingleVariableAccess() {
	}

	public SingleVariableAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String variableID, String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.variableID = variableID;
		this.qualifierID = qualifierID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVariable(String variableID) {
		this.variableID = variableID;
	}

	public String getVariable() {
		return variableID;
	}

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

}
