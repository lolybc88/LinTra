package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class InfixExpression extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String operator;

	String rightOperandID;
	Boolean rightOperandIsComposed = true;

	String leftOperandID;
	Boolean leftOperandIsComposed = true;

	String[] extendedOperandsID;
	Boolean extendedOperandsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public InfixExpression() {
	}

	public InfixExpression(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String operator, String rightOperandID, String leftOperandID,
			String[] extendedOperandsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.operator = operator;

		this.rightOperandID = rightOperandID;
		this.leftOperandID = leftOperandID;
		this.extendedOperandsID = extendedOperandsID;
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

	public void setRightOperand(String rightOperandID) {
		this.rightOperandID = rightOperandID;
	}

	public String getRightOperand() {
		return rightOperandID;
	}

	public void setLeftOperand(String leftOperandID) {
		this.leftOperandID = leftOperandID;
	}

	public String getLeftOperand() {
		return leftOperandID;
	}

	public void setExtendedOperands(String[] extendedOperandsID) {
		this.extendedOperandsID = extendedOperandsID;
	}

	public String[] getExtendedOperands() {
		return extendedOperandsID;
	}

}
