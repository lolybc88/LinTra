package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ThrowStatement extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

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

	public ThrowStatement() {
	}

	public ThrowStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String expressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.expressionID = expressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

}
