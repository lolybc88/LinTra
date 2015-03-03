package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class ASTNode implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String[] commentsID;
	Boolean commentsIsComposed = true;

	String originalCompilationUnitID;
	Boolean originalCompilationUnitIsComposed = false;

	String originalClassFileID;
	Boolean originalClassFileIsComposed = false;

	public ASTNode() {
	}

	public ASTNode(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID) {
		super();

		this.commentsID = commentsID;
		this.originalCompilationUnitID = originalCompilationUnitID;
		this.originalClassFileID = originalClassFileID;
	}

	public void setComments(String[] commentsID) {
		this.commentsID = commentsID;
	}

	public String[] getComments() {
		return commentsID;
	}

	public void setOriginalCompilationUnit(String originalCompilationUnitID) {
		this.originalCompilationUnitID = originalCompilationUnitID;
	}

	public String getOriginalCompilationUnit() {
		return originalCompilationUnitID;
	}

	public void setOriginalClassFile(String originalClassFileID) {
		this.originalClassFileID = originalClassFileID;
	}

	public String getOriginalClassFile() {
		return originalClassFileID;
	}

}
