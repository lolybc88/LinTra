package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Assignment extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String operator;

	String leftHandSideID;
	Boolean leftHandSideIsComposed = true;

	String rightHandSideID;
	Boolean rightHandSideIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Assignment() {
	}

	public Assignment(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String leftHandSideID, String operator, String rightHandSideID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.operator = operator;

		this.leftHandSideID = leftHandSideID;
		this.rightHandSideID = rightHandSideID;
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

	public void setLeftHandSide(String leftHandSideID) {
		this.leftHandSideID = leftHandSideID;
	}

	public String getLeftHandSide() {
		return leftHandSideID;
	}

	public void setRightHandSide(String rightHandSideID) {
		this.rightHandSideID = rightHandSideID;
	}

	public String getRightHandSide() {
		return rightHandSideID;
	}

}
