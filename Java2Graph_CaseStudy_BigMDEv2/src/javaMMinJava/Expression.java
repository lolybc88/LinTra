package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class Expression extends ASTNode implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	public Expression() {
	}

	public Expression(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

	}

}
