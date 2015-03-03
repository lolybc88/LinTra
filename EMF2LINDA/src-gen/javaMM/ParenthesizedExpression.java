package javaMM;

import java.io.Serializable;

public class ParenthesizedExpression extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;

	public ParenthesizedExpression() {
	}

	public ParenthesizedExpression(String id, String[] commentsID,
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
