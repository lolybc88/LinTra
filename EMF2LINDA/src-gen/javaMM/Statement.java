package javaMM;

import java.io.Serializable;

public abstract class Statement extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	public Statement() {
	}

	public Statement(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

	}

}
