package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class Statement extends ASTNode implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	public Statement() {
	}

	public Statement(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

	}

}
