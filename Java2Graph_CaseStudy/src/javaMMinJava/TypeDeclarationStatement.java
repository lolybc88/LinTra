package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class TypeDeclarationStatement extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String declarationID;
	Boolean declarationIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

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

	@Override
	public String toString() {
		return "TypeDeclarationStatement [id=" + id + ", declarationID="
				+ declarationID + ", declarationIsComposed="
				+ declarationIsComposed + ", trgId=" + trgId + ", commentsID="
				+ Arrays.toString(commentsID) + ", commentsIsComposed="
				+ commentsIsComposed + ", originalCompilationUnitID="
				+ originalCompilationUnitID
				+ ", originalCompilationUnitIsComposed="
				+ originalCompilationUnitIsComposed + ", originalClassFileID="
				+ originalClassFileID + ", originalClassFileIsComposed="
				+ originalClassFileIsComposed + "]";
	}

}
