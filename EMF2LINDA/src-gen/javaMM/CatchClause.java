package javaMM;

import java.io.Serializable;

public class CatchClause extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String exceptionID;
	Boolean exceptionIsComposed = true;

	String bodyID;
	Boolean bodyIsComposed = true;

	public CatchClause() {
	}

	public CatchClause(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String exceptionID, String bodyID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.exceptionID = exceptionID;
		this.bodyID = bodyID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setException(String exceptionID) {
		this.exceptionID = exceptionID;
	}

	public String getException() {
		return exceptionID;
	}

	public void setBody(String bodyID) {
		this.bodyID = bodyID;
	}

	public String getBody() {
		return bodyID;
	}

}
