package javaMM;

import java.io.Serializable;

public class EnhancedForStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String bodyID;
	Boolean bodyIsComposed = true;

	String expressionID;
	Boolean expressionIsComposed = true;

	String parameterID;
	Boolean parameterIsComposed = true;

	public EnhancedForStatement() {
	}

	public EnhancedForStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String bodyID, String expressionID, String parameterID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.bodyID = bodyID;
		this.expressionID = expressionID;
		this.parameterID = parameterID;
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

	public void setParameter(String parameterID) {
		this.parameterID = parameterID;
	}

	public String getParameter() {
		return parameterID;
	}

}
