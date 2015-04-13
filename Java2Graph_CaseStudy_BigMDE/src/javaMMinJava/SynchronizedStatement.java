package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class SynchronizedStatement extends Statement implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Block body;
	Boolean bodyIsComposed = true;

	Expression expression;
	Boolean expressionIsComposed = true;

	public SynchronizedStatement() {
	}

	public SynchronizedStatement(String id,

	Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, Block body, Expression expression) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.body = body;
		this.expression = expression;
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

	public void setBody(Block body) {
		this.body = body;
	}

	public Block getBody() {
		return body;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

}
