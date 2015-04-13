package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class TryStatement extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String bodyID;
	Boolean bodyIsComposed = true;

	String finallyID;
	Boolean finallyIsComposed = true;

	String[] catchClausesID;
	Boolean catchClausesIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public TryStatement() {
	}

	public TryStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String bodyID, String finallyID, String[] catchClausesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.bodyID = bodyID;
		this.finallyID = finallyID;
		this.catchClausesID = catchClausesID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBody(String bodyID) {
		this.bodyID = bodyID;
	}

	public String getBody() {
		return bodyID;
	}

	public void setFinally(String finallyID) {
		this.finallyID = finallyID;
	}

	public String getFinally() {
		return finallyID;
	}

	public void setCatchClauses(String[] catchClausesID) {
		this.catchClausesID = catchClausesID;
	}

	public String[] getCatchClauses() {
		return catchClausesID;
	}

}
