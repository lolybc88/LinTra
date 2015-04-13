package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class VariableDeclarationFragment extends VariableDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	AbstractVariablesContainer variablesContainer;
	Boolean variablesContainerIsComposed = false;

	public VariableDeclarationFragment() {
	}

	public VariableDeclarationFragment(String id, String name, Boolean proxy,
			int extraArrayDimensions, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			Expression initializer, SingleVariableAccess[] usageInVariableAccess,
			AbstractVariablesContainer variablesContainer) {

		super(name, proxy, extraArrayDimensions, comments,
				originalCompilationUnit, originalClassFile, usagesInImports,
				initializer, usageInVariableAccess);

		this.id = id;

		this.variablesContainer = variablesContainer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public void setVariablesContainer(
			AbstractVariablesContainer variablesContainer) {
		this.variablesContainer = variablesContainer;
	}

	public AbstractVariablesContainer getVariablesContainer() {
		return variablesContainer;
	}

}
