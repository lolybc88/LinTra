package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Assignment extends Expression implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String operator;

	Expression leftHandSide;
	Boolean leftHandSideIsComposed = true;

	Expression rightHandSide;
	Boolean rightHandSideIsComposed = true;

	public Assignment() {
	}

	public Assignment(String id, String operator, Comment comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, Expression leftHandSide,
			Expression rightHandSide) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.operator = operator;

		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
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

	public void setLeftHandSide(Expression leftHandSide) {
		this.leftHandSide = leftHandSide;
	}

	public Expression getLeftHandSide() {
		return leftHandSide;
	}

	public void setRightHandSide(Expression rightHandSide) {
		this.rightHandSide = rightHandSide;
	}

	public Expression getRightHandSide() {
		return rightHandSide;
	}

}
