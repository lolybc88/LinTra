package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class AbstractVariablesContainer extends ASTNode implements
		Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	TypeAccess type;
	Boolean typeIsComposed = true;

	VariableDeclarationFragment fragments;
	Boolean fragmentsIsComposed = true;

	public AbstractVariablesContainer() {
	}

	public AbstractVariablesContainer(

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, TypeAccess type,
			VariableDeclarationFragment fragments) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.type = type;
		this.fragments = fragments;
	}

	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

	public void setFragments(VariableDeclarationFragment fragments) {
		this.fragments = fragments;
	}

	public VariableDeclarationFragment getFragments() {
		return fragments;
	}

}
	