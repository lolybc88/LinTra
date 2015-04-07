package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class CastExpression extends Expression implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Expression expression;
	Boolean expressionIsComposed = true;

	TypeAccess type;
	Boolean typeIsComposed = true;

	public CastExpression() {
	}

	public CastExpression(String id,

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, Expression expression, TypeAccess type) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.expression = expression;
		this.type = type;
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

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

}
