package javaMM;

import java.io.Serializable;

public class AnonymousClassDeclaration extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String[] bodyDeclarationsID;
	Boolean bodyDeclarationsIsComposed = true;

	String classInstanceCreationID;
	Boolean classInstanceCreationIsComposed = false;

	public AnonymousClassDeclaration() {
	}

	public AnonymousClassDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String[] bodyDeclarationsID, String classInstanceCreationID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.bodyDeclarationsID = bodyDeclarationsID;
		this.classInstanceCreationID = classInstanceCreationID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBodyDeclarations(String[] bodyDeclarationsID) {
		this.bodyDeclarationsID = bodyDeclarationsID;
	}

	public String[] getBodyDeclarations() {
		return bodyDeclarationsID;
	}

	public void setClassInstanceCreation(String classInstanceCreationID) {
		this.classInstanceCreationID = classInstanceCreationID;
	}

	public String getClassInstanceCreation() {
		return classInstanceCreationID;
	}

}
