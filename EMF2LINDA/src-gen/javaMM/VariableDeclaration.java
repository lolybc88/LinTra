package javaMM;

import java.io.Serializable;

public abstract class VariableDeclaration extends NamedElement
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	int extraArrayDimensions;

	String initializerID;
	Boolean initializerIsComposed = true;

	String[] usageInVariableAccessID;
	Boolean usageInVariableAccessIsComposed = false;

	public VariableDeclaration() {
	}

	public VariableDeclaration(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			int extraArrayDimensions, String initializerID,
			String[] usageInVariableAccessID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.extraArrayDimensions = extraArrayDimensions;

		this.initializerID = initializerID;
		this.usageInVariableAccessID = usageInVariableAccessID;
	}

	public void setExtraArrayDimensions(int extraArrayDimensions) {
		this.extraArrayDimensions = extraArrayDimensions;
	}

	public int getExtraArrayDimensions() {
		return extraArrayDimensions;
	}

	public void setInitializer(String initializerID) {
		this.initializerID = initializerID;
	}

	public String getInitializer() {
		return initializerID;
	}

	public void setUsageInVariableAccess(String[] usageInVariableAccessID) {
		this.usageInVariableAccessID = usageInVariableAccessID;
	}

	public String[] getUsageInVariableAccess() {
		return usageInVariableAccessID;
	}

}
