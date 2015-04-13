package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class InfixExpression extends Expression implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String operator;

	Expression rightOperand;
	Boolean rightOperandIsComposed = true;

	Expression leftOperand;
	Boolean leftOperandIsComposed = true;

	Expression[] extendedOperands;
	Boolean extendedOperandsIsComposed = true;

	public InfixExpression() {
	}

	public InfixExpression(String id, String operator, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, Expression rightOperand,
			Expression leftOperand, Expression[] extendedOperands) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.operator = operator;

		this.rightOperand = rightOperand;
		this.leftOperand = leftOperand;
		this.extendedOperands = extendedOperands;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setRightOperand(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}

	public Expression getRightOperand() {
		return rightOperand;
	}

	public void setLeftOperand(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}

	public Expression getLeftOperand() {
		return leftOperand;
	}

	public void setExtendedOperands(Expression[] extendedOperands) {
		this.extendedOperands = extendedOperands;
	}

	public Expression[] getExtendedOperands() {
		return extendedOperands;
	}

}
