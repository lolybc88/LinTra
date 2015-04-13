package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ConditionalExpression extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String elseExpressionID;
	Boolean elseExpressionIsComposed = true;

	String expressionID;
	Boolean expressionIsComposed = true;

	String thenExpressionID;
	Boolean thenExpressionIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ConditionalExpression() {
	}

	public ConditionalExpression(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String elseExpressionID, String expressionID,
			String thenExpressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.elseExpressionID = elseExpressionID;
		this.expressionID = expressionID;
		this.thenExpressionID = thenExpressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setElseExpression(String elseExpressionID) {
		this.elseExpressionID = elseExpressionID;
	}

	public String getElseExpression() {
		return elseExpressionID;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

	public void setThenExpression(String thenExpressionID) {
		this.thenExpressionID = thenExpressionID;
	}

	public String getThenExpression() {
		return thenExpressionID;
	}

}
