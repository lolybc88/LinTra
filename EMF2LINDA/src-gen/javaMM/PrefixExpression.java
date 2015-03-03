package javaMM;

import java.io.Serializable;

public class PrefixExpression extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String operator;

	String operandID;
	Boolean operandIsComposed = true;

	public PrefixExpression() {
	}

	public PrefixExpression(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String operator, String operandID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.operator = operator;

		this.operandID = operandID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperand(String operandID) {
		this.operandID = operandID;
	}

	public String getOperand() {
		return operandID;
	}

}
