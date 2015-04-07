package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class UnresolvedSingleVariableDeclaration
		extends
			SingleVariableDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public UnresolvedSingleVariableDeclaration() {
	}

	public UnresolvedSingleVariableDeclaration(String id, String name,
			Boolean proxy, int extraArrayDimensions, Boolean varargs,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			Expression initializer, SingleVariableAccess usageInVariableAccess,
			Modifier modifier, TypeAccess type, Annotation annotations,
			AbstractMethodDeclaration methodDeclaration,
			CatchClause catchClause, EnhancedForStatement enhancedForStatement) {

		super(name, proxy, extraArrayDimensions, varargs, comments,
				originalCompilationUnit, originalClassFile, usagesInImports,
				initializer, usageInVariableAccess, modifier, type,
				annotations, methodDeclaration, catchClause,
				enhancedForStatement);

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
