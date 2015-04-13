package javaMMinJava;

import blackboard.IdentifiableElement;

import java.io.Serializable;

public class EnumConstantDeclaration extends BodyDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	AnonymousClassDeclaration anonymousClassDeclaration;
	Boolean anonymousClassDeclarationIsComposed = true;

	Expression[] arguments;
	Boolean argumentsIsComposed = true;
	
	int extraArrayDimensions;
	
	Expression initializer;
	Boolean initializerIsComposed = true;

	SingleVariableAccess[] usageInVariableAccess;
	Boolean usageInVariableAccessIsComposed = false;

	public EnumConstantDeclaration() {
	}

	public EnumConstantDeclaration(String id, String name, Boolean proxy,
			int extraArrayDimensions, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation[] annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, Expression initializer,
			SingleVariableAccess[] usageInVariableAccess,
			AnonymousClassDeclaration anonymousClassDeclaration,
			Expression[] arguments) {

		super(name, proxy, comments,
				originalCompilationUnit, originalClassFile, usagesInImports,
				abstractTypeDeclaration, annotations,
				anonymousClassDeclarationOwner, modifier);

		this.id = id;

		this.anonymousClassDeclaration = anonymousClassDeclaration;
		this.arguments = arguments;
		
		this.initializer = initializer;
		this.usageInVariableAccess = usageInVariableAccess;
		this.arguments = arguments;
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

	public void setAnonymousClassDeclaration(
			AnonymousClassDeclaration anonymousClassDeclaration) {
		this.anonymousClassDeclaration = anonymousClassDeclaration;
	}

	public AnonymousClassDeclaration getAnonymousClassDeclaration() {
		return anonymousClassDeclaration;
	}

	public void setArguments(Expression[] arguments) {
		this.arguments = arguments;
	}

	public Expression[] getArguments() {
		return arguments;
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
