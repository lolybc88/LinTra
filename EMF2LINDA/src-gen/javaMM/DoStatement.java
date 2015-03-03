package javaMM;

import java.io.Serializable;

public class DoStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;

	String bodyID;
	Boolean bodyIsComposed = true;

	public DoStatement() {
	}

	public DoStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String expressionID, String bodyID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.expressionID = expressionID;
		this.bodyID = bodyID;
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

	public void setBody(String bodyID) {
		this.bodyID = bodyID;
	}

	public String getBody() {
		return bodyID;
	}

}
