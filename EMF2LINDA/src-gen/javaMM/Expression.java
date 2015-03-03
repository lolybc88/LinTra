package javaMM;

import java.io.Serializable;

public abstract class Expression extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	public Expression() {
	}

	public Expression(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

	}

}
