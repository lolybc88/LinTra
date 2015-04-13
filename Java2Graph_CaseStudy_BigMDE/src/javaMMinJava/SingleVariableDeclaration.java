package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class SingleVariableDeclaration extends VariableDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Boolean varargs;

	Modifier modifier;
	Boolean modifierIsComposed = true;

	TypeAccess type;
	Boolean typeIsComposed = true;

	Annotation[] annotations;
	Boolean annotationsIsComposed = true;

	AbstractMethodDeclaration methodDeclaration;
	Boolean methodDeclarationIsComposed = false;

	CatchClause catchClause;
	Boolean catchClauseIsComposed = false;

	EnhancedForStatement enhancedForStatement;
	Boolean enhancedForStatementIsComposed = false;

	public SingleVariableDeclaration() {
	}

	public SingleVariableDeclaration(String id, String name, Boolean proxy,
			int extraArrayDimensions, Boolean varargs, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			Expression initializer, SingleVariableAccess[] usageInVariableAccess,
			Modifier modifier, TypeAccess type, Annotation[] annotations,
			AbstractMethodDeclaration methodDeclaration,
			CatchClause catchClause, EnhancedForStatement enhancedForStatement) {

		super(name, proxy, extraArrayDimensions, comments,
				originalCompilationUnit, originalClassFile, usagesInImports,
				initializer, usageInVariableAccess);

		this.id = id;

		this.varargs = varargs;

		this.modifier = modifier;
		this.type = type;
		this.annotations = annotations;
		this.methodDeclaration = methodDeclaration;
		this.catchClause = catchClause;
		this.enhancedForStatement = enhancedForStatement;
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

	public void setVarargs(Boolean varargs) {
		this.varargs = varargs;
	}

	public Boolean getVarargs() {
		return varargs;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public Modifier getModifier() {
		return modifier;
	}

	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

	public void setAnnotations(Annotation[] annotations) {
		this.annotations = annotations;
	}

	public Annotation[] getAnnotations() {
		return annotations;
	}

	public void setMethodDeclaration(AbstractMethodDeclaration methodDeclaration) {
		this.methodDeclaration = methodDeclaration;
	}

	public AbstractMethodDeclaration getMethodDeclaration() {
		return methodDeclaration;
	}

	public void setCatchClause(CatchClause catchClause) {
		this.catchClause = catchClause;
	}

	public CatchClause getCatchClause() {
		return catchClause;
	}

	public void setEnhancedForStatement(
			EnhancedForStatement enhancedForStatement) {
		this.enhancedForStatement = enhancedForStatement;
	}

	public EnhancedForStatement getEnhancedForStatement() {
		return enhancedForStatement;
	}

}
