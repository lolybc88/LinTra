package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class PrefixExpression extends Expression
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String operator;

	Expression operand;
	Boolean operandIsComposed = true;

	public PrefixExpression() {
	}

	public PrefixExpression(
				String id,				
				String operator
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression operand ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.operator = operator ;
				
				this.operand = operand ;
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

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperand(Expression operand) {
		this.operand = operand;
	}

	public Expression getOperand() {
		return operand;
	}

}
