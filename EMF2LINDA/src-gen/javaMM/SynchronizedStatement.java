package javaMM;

import java.io.Serializable;

public class SynchronizedStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String bodyID;
	Boolean bodyIsComposed = true;

	String expressionID;
	Boolean expressionIsComposed = true;

	public SynchronizedStatement() {
	}

	public SynchronizedStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String bodyID, String expressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.bodyID = bodyID;
		this.expressionID = expressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBody(String bodyID) {
		this.bodyID = bodyID;
	}

	public String getBody() {
		return bodyID;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

}
