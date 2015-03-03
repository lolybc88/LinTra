package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Block extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String[] statementsID;
	Boolean statementsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

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
