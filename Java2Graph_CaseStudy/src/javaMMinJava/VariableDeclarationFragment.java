package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class VariableDeclarationFragment extends VariableDeclaration
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String variablesContainerID;
	Boolean variablesContainerIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public VariableDeclarationFragment() {
	}

	public VariableDeclarationFragment(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			int extraArrayDimensions, String initializerID,
			String[] usageInVariableAccessID, String variablesContainerID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, extraArrayDimensions, initializerID,
				usageInVariableAccessID);

		this.id = id;

		this.variablesContainerID = variablesContainerID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVariablesContainer(String variablesContainerID) {
		this.variablesContainerID = variablesContainerID;
	}

	public String getVariablesContainer() {
		return variablesContainerID;
	}

}
