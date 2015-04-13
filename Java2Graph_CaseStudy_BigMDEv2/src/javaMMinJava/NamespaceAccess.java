package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class NamespaceAccess extends ASTNode implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	public NamespaceAccess() {
	}

	public NamespaceAccess(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

	}

}
