package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class ReturnStatement extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ReturnStatement() {
	}

	public ReturnStatement(String id, String[] commentsID,
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

	@Override
	public String toString() {
		return "ReturnStatement [id=" + id + ", expressionID=" + expressionID
				+ ", trgId=" + trgId + ", commentsID="
				+ Arrays.toString(commentsID) + ", originalCompilationUnitID="
				+ originalCompilationUnitID + ", originalClassFileID="
				+ originalClassFileID + "]";
	}

}
