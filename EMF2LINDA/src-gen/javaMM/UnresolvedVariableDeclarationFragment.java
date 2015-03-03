package javaMM;

import java.io.Serializable;

public class UnresolvedVariableDeclarationFragment
		extends
			VariableDeclarationFragment implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public UnresolvedVariableDeclarationFragment() {
	}

	public UnresolvedVariableDeclarationFragment(String id,
			String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID, String name, Boolean proxy,
			String[] usagesInImportsID, int extraArrayDimensions,
			String initializerID, String[] usageInVariableAccessID,
			String variablesContainerID) {
		super(id, commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, extraArrayDimensions, initializerID,
				usageInVariableAccessID, variablesContainerID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
