package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class AbstractMethodDeclaration extends BodyDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	Block body;
	Boolean bodyIsComposed = true;

	SingleVariableDeclaration parameters;
	Boolean parametersIsComposed = true;

	TypeAccess thrownExceptions;
	Boolean thrownExceptionsIsComposed = true;

	TypeParameter typeParameters;
	Boolean typeParametersIsComposed = true;

	MethodRef usagesInDocComments;
	Boolean usagesInDocCommentsIsComposed = false;

	AbstractMethodInvocation usages;
	Boolean usagesIsComposed = false;

	public AbstractMethodDeclaration() {
	}

	public AbstractMethodDeclaration(

	String name, Boolean proxy, Comment comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, Block body,
			SingleVariableDeclaration parameters, TypeAccess thrownExceptions,
			TypeParameter typeParameters, MethodRef usagesInDocComments,
			AbstractMethodInvocation usages) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier);

		this.body = body;
		this.parameters = parameters;
		this.thrownExceptions = thrownExceptions;
		this.typeParameters = typeParameters;
		this.usagesInDocComments = usagesInDocComments;
		this.usages = usages;
	}

	public void setBody(Block body) {
		this.body = body;
	}

	public Block getBody() {
		return body;
	}

	public void setParameters(SingleVariableDeclaration parameters) {
		this.parameters = parameters;
	}

	public SingleVariableDeclaration getParameters() {
		return parameters;
	}

	public void setThrownExceptions(TypeAccess thrownExceptions) {
		this.thrownExceptions = thrownExceptions;
	}

	public TypeAccess getThrownExceptions() {
		return thrownExceptions;
	}

	public void setTypeParameters(TypeParameter typeParameters) {
		this.typeParameters = typeParameters;
	}

	public TypeParameter getTypeParameters() {
		return typeParameters;
	}

	public void setUsagesInDocComments(MethodRef usagesInDocComments) {
		this.usagesInDocComments = usagesInDocComments;
	}

	public MethodRef getUsagesInDocComments() {
		return usagesInDocComments;
	}

	public void setUsages(AbstractMethodInvocation usages) {
		this.usages = usages;
	}

	public AbstractMethodInvocation getUsages() {
		return usages;
	}

}
