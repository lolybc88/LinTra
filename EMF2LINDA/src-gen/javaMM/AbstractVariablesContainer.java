package javaMM;

import java.io.Serializable;

public abstract class AbstractVariablesContainer extends ASTNode
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	String typeID;
	Boolean typeIsComposed = true;

	String[] fragmentsID;
	Boolean fragmentsIsComposed = true;

	public AbstractVariablesContainer() {
	}

	public AbstractVariablesContainer(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String typeID, String[] fragmentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.typeID = typeID;
		this.fragmentsID = fragmentsID;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

	public void setFragments(String[] fragmentsID) {
		this.fragmentsID = fragmentsID;
	}

	public String[] getFragments() {
		return fragmentsID;
	}

}
