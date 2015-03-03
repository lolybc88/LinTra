package javaMM;

import java.io.Serializable;

public class IfStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;

	String thenStatementID;
	Boolean thenStatementIsComposed = true;

	String elseStatementID;
	Boolean elseStatementIsComposed = true;

	public IfStatement() {
	}

	public IfStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String expressionID, String thenStatementID, String elseStatementID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.expressionID = expressionID;
		this.thenStatementID = thenStatementID;
		this.elseStatementID = elseStatementID;
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

	public void setThenStatement(String thenStatementID) {
		this.thenStatementID = thenStatementID;
	}

	public String getThenStatement() {
		return thenStatementID;
	}

	public void setElseStatement(String elseStatementID) {
		this.elseStatementID = elseStatementID;
	}

	public String getElseStatement() {
		return elseStatementID;
	}

}
