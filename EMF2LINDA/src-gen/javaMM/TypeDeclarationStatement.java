package javaMM;

import java.io.Serializable;

public class TypeDeclarationStatement extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String declarationID;
	Boolean declarationIsComposed = true;

	public TypeDeclarationStatement() {
	}

	public TypeDeclarationStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String declarationID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.declarationID = declarationID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDeclaration(String declarationID) {
		this.declarationID = declarationID;
	}

	public String getDeclaration() {
		return declarationID;
	}

}
