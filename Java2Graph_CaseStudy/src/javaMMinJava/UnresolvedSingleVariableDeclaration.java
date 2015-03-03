package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class UnresolvedSingleVariableDeclaration
		extends
			SingleVariableDeclaration implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	public UnresolvedSingleVariableDeclaration() {
	}

	public UnresolvedSingleVariableDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			int extraArrayDimensions, String initializerID,
			String[] usageInVariableAccessID, String modifierID,
			Boolean varargs, String typeID, String[] annotationsID,
			String methodDeclarationID, String catchClauseID,
			String enhancedForStatementID) {
		super(id, commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, extraArrayDimensions, initializerID,
				usageInVariableAccessID, modifierID, varargs, typeID,
				annotationsID, methodDeclarationID, catchClauseID,
				enhancedForStatementID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
