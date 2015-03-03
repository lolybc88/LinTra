package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Modifier extends ASTNode implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String visibility;
	String inheritance;
	Boolean static_;
	Boolean transient_;
	Boolean volatile_;
	Boolean native_;
	Boolean strictfp_;
	Boolean synchronized_;

	String bodyDeclarationID;
	Boolean bodyDeclarationIsComposed = false;

	String singleVariableDeclarationID;
	Boolean singleVariableDeclarationIsComposed = false;

	String variableDeclarationStatementID;
	Boolean variableDeclarationStatementIsComposed = false;

	String variableDeclarationExpressionID;
	Boolean variableDeclarationExpressionIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Modifier() {
	}

	public Modifier(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String visibility, String inheritance, Boolean static_,
			Boolean transient_, Boolean volatile_, Boolean native_,
			Boolean strictfp_, Boolean synchronized_, String bodyDeclarationID,
			String singleVariableDeclarationID,
			String variableDeclarationStatementID,
			String variableDeclarationExpressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.visibility = visibility;
		this.inheritance = inheritance;
		this.static_ = static_;
		this.transient_ = transient_;
		this.volatile_ = volatile_;
		this.native_ = native_;
		this.strictfp_ = strictfp_;
		this.synchronized_ = synchronized_;

		this.bodyDeclarationID = bodyDeclarationID;
		this.singleVariableDeclarationID = singleVariableDeclarationID;
		this.variableDeclarationStatementID = variableDeclarationStatementID;
		this.variableDeclarationExpressionID = variableDeclarationExpressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setInheritance(String inheritance) {
		this.inheritance = inheritance;
	}

	public String getInheritance() {
		return inheritance;
	}

	public void setStatic(Boolean static_) {
		this.static_ = static_;
	}

	public Boolean getStatic() {
		return static_;
	}

	public void setTransient(Boolean transient_) {
		this.transient_ = transient_;
	}

	public Boolean getTransient() {
		return transient_;
	}

	public void setVolatile(Boolean volatile_) {
		this.volatile_ = volatile_;
	}

	public Boolean getVolatile() {
		return volatile_;
	}

	public void setNative(Boolean native_) {
		this.native_ = native_;
	}

	public Boolean getNative() {
		return native_;
	}

	public void setStrictfp(Boolean strictfp_) {
		this.strictfp_ = strictfp_;
	}

	public Boolean getStrictfp() {
		return strictfp_;
	}

	public void setSynchronized(Boolean synchronized_) {
		this.synchronized_ = synchronized_;
	}

	public Boolean getSynchronized() {
		return synchronized_;
	}

	public void setBodyDeclaration(String bodyDeclarationID) {
		this.bodyDeclarationID = bodyDeclarationID;
	}

	public String getBodyDeclaration() {
		return bodyDeclarationID;
	}

	public void setSingleVariableDeclaration(String singleVariableDeclarationID) {
		this.singleVariableDeclarationID = singleVariableDeclarationID;
	}

	public String getSingleVariableDeclaration() {
		return singleVariableDeclarationID;
	}

	public void setVariableDeclarationStatement(
			String variableDeclarationStatementID) {
		this.variableDeclarationStatementID = variableDeclarationStatementID;
	}

	public String getVariableDeclarationStatement() {
		return variableDeclarationStatementID;
	}

	public void setVariableDeclarationExpression(
			String variableDeclarationExpressionID) {
		this.variableDeclarationExpressionID = variableDeclarationExpressionID;
	}

	public String getVariableDeclarationExpression() {
		return variableDeclarationExpressionID;
	}

}
