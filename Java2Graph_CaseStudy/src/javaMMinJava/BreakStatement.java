package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class BreakStatement extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String labelID;
	Boolean labelIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public BreakStatement() {
	}

	public BreakStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String labelID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.labelID = labelID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLabel(String labelID) {
		this.labelID = labelID;
	}

	public String getLabel() {
		return labelID;
	}

}
