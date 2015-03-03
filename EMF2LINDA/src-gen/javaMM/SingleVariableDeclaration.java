package javaMM;

import java.io.Serializable;

public class SingleVariableDeclaration extends VariableDeclaration
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	Boolean varargs;

	String modifierID;
	Boolean modifierIsComposed = true;

	String typeID;
	Boolean typeIsComposed = true;

	String[] annotationsID;
	Boolean annotationsIsComposed = true;

	String methodDeclarationID;
	Boolean methodDeclarationIsComposed = false;

	String catchClauseID;
	Boolean catchClauseIsComposed = false;

	String enhancedForStatementID;
	Boolean enhancedForStatementIsComposed = false;

	public SingleVariableDeclaration() {
	}

	public SingleVariableDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			int extraArrayDimensions, String initializerID,
			String[] usageInVariableAccessID, String modifierID,
			Boolean varargs, String typeID, String[] annotationsID,
			String methodDeclarationID, String catchClauseID,
			String enhancedForStatementID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, extraArrayDimensions, initializerID,
				usageInVariableAccessID);

		this.id = id;

		this.varargs = varargs;

		this.modifierID = modifierID;
		this.typeID = typeID;
		this.annotationsID = annotationsID;
		this.methodDeclarationID = methodDeclarationID;
		this.catchClauseID = catchClauseID;
		this.enhancedForStatementID = enhancedForStatementID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVarargs(Boolean varargs) {
		this.varargs = varargs;
	}

	public Boolean getVarargs() {
		return varargs;
	}

	public void setModifier(String modifierID) {
		this.modifierID = modifierID;
	}

	public String getModifier() {
		return modifierID;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

	public void setAnnotations(String[] annotationsID) {
		this.annotationsID = annotationsID;
	}

	public String[] getAnnotations() {
		return annotationsID;
	}

	public void setMethodDeclaration(String methodDeclarationID) {
		this.methodDeclarationID = methodDeclarationID;
	}

	public String getMethodDeclaration() {
		return methodDeclarationID;
	}

	public void setCatchClause(String catchClauseID) {
		this.catchClauseID = catchClauseID;
	}

	public String getCatchClause() {
		return catchClauseID;
	}

	public void setEnhancedForStatement(String enhancedForStatementID) {
		this.enhancedForStatementID = enhancedForStatementID;
	}

	public String getEnhancedForStatement() {
		return enhancedForStatementID;
	}

}
