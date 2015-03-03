package javaMM;

import java.io.Serializable;

public class InstanceofExpression extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String rightOperandID;
	Boolean rightOperandIsComposed = true;

	String leftOperandID;
	Boolean leftOperandIsComposed = true;

	public InstanceofExpression() {
	}

	public InstanceofExpression(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String rightOperandID, String leftOperandID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.rightOperandID = rightOperandID;
		this.leftOperandID = leftOperandID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
