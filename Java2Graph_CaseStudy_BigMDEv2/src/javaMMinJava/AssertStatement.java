package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class AssertStatement extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String messageID;
	Boolean messageIsComposed = true;

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

	public AssertStatement() {
	}

	public AssertStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String messageID, String expressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.messageID = messageID;
		this.expressionID = expressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMessage(String messageID) {
		this.messageID = messageID;
	}

	public String getMessage() {
		return messageID;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

}
