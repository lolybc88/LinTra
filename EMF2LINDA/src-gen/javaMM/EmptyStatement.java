package javaMM;

import java.io.Serializable;

public class EmptyStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public EmptyStatement() {
	}

	public EmptyStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
