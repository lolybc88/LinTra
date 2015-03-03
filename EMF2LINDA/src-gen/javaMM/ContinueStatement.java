package javaMM;

import java.io.Serializable;

public class ContinueStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String labelID;
	Boolean labelIsComposed = false;

	public ContinueStatement() {
	}

	public ContinueStatement(String id, String[] commentsID,
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
