package javaMM;

import java.io.Serializable;

public class SwitchStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;

	String[] statementsID;
	Boolean statementsIsComposed = true;

	public SwitchStatement() {
	}

	public SwitchStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String expressionID, String[] statementsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.expressionID = expressionID;
		this.statementsID = statementsID;
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

	public void setStatements(String[] statementsID) {
		this.statementsID = statementsID;
	}

	public String[] getStatements() {
		return statementsID;
	}

}
