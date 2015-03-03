package javaMM;

import java.io.Serializable;

public abstract class NamespaceAccess extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	public NamespaceAccess() {
	}

	public NamespaceAccess(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

	}

}
