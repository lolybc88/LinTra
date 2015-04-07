package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class AbstractTypeQualifiedExpression extends Expression
		implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	TypeAccess qualifier;
	Boolean qualifierIsComposed = true;

	public AbstractTypeQualifiedExpression() {
	}

	public AbstractTypeQualifiedExpression(

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, TypeAccess qualifier) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.qualifier = qualifier;
	}

	public void setQualifier(TypeAccess qualifier) {
		this.qualifier = qualifier;
	}

	public TypeAccess getQualifier() {
		return qualifier;
	}

}
