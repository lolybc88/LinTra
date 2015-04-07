package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class AbstractMethodInvocation extends ASTNode implements
		Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	AbstractMethodDeclaration method;
	Boolean methodIsComposed = false;

	Expression arguments;
	Boolean argumentsIsComposed = true;

	TypeAccess typeArguments;
	Boolean typeArgumentsIsComposed = true;

	public AbstractMethodInvocation() {
	}

	public AbstractMethodInvocation(

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, AbstractMethodDeclaration method,
			Expression arguments, TypeAccess typeArguments) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.method = method;
		this.arguments = arguments;
		this.typeArguments = typeArguments;
	}

	public void setMethod(AbstractMethodDeclaration method) {
		this.method = method;
	}

	public AbstractMethodDeclaration getMethod() {
		return method;
	}

	public void setArguments(Expression arguments) {
		this.arguments = arguments;
	}

	public Expression getArguments() {
		return arguments;
	}

	public void setTypeArguments(TypeAccess typeArguments) {
		this.typeArguments = typeArguments;
	}

	public TypeAccess getTypeArguments() {
		return typeArguments;
	}

}
