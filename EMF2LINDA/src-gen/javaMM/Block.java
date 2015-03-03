package javaMM;

import java.io.Serializable;

public class Block extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String[] statementsID;
	Boolean statementsIsComposed = true;

	public Block() {
	}

	public Block(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String[] statementsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.statementsID = statementsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatements(String[] statementsID) {
		this.statementsID = statementsID;
	}

	public String[] getStatements() {
		return statementsID;
	}

}
