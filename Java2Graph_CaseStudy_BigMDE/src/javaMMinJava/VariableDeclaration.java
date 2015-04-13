package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class VariableDeclaration extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	int extraArrayDimensions;

	Expression initializer;
	Boolean initializerIsComposed = true;

	SingleVariableAccess[] usageInVariableAccess;
	Boolean usageInVariableAccessIsComposed = false;

	public VariableDeclaration() {
	}

	public VariableDeclaration(

	String name, Boolean proxy, int extraArrayDimensions, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			Expression initializer, SingleVariableAccess[] usageInVariableAccess) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports);

		this.extraArrayDimensions = extraArrayDimensions;

		this.initializer = initializer;
		this.usageInVariableAccess = usageInVariableAccess;
	}

	public void setExtraArrayDimensions(int extraArrayDimensions) {
		this.extraArrayDimensions = extraArrayDimensions;
	}

	public int getExtraArrayDimensions() {
		return extraArrayDimensions;
	}

	public void setInitializer(Expression initializer) {
		this.initializer = initializer;
	}

	public Expression getInitializer() {
		return initializer;
	}

	public void setUsageInVariableAccess(
			SingleVariableAccess[] usageInVariableAccess) {
		this.usageInVariableAccess = usageInVariableAccess;
	}

	public SingleVariableAccess[] getUsageInVariableAccess() {
		return usageInVariableAccess;
	}

}
