package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class UnresolvedVariableDeclarationFragment
		extends
			VariableDeclarationFragment
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public UnresolvedVariableDeclarationFragment() {
	}

	public UnresolvedVariableDeclarationFragment(String id, String name,
			Boolean proxy, int extraArrayDimensions, Comment comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			Expression initializer, SingleVariableAccess usageInVariableAccess,
			AbstractVariablesContainer variablesContainer) {

		super(id,name, proxy, extraArrayDimensions, comments,
				originalCompilationUnit, originalClassFile, usagesInImports,
				initializer, usageInVariableAccess, variablesContainer);

		this.id = id;

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

}
