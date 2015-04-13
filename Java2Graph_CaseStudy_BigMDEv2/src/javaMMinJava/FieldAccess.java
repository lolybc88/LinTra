package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class FieldAccess extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String fieldID;
	Boolean fieldIsComposed = true;

	String expressionID;
	Boolean expressionIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public FieldAccess() {
	}

	public FieldAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String fieldID, String expressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.fieldID = fieldID;
		this.expressionID = expressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setField(String fieldID) {
		this.fieldID = fieldID;
	}

	public String getField() {
		return fieldID;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

}
