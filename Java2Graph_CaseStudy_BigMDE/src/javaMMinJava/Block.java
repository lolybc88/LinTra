package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Block extends Statement implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Statement statements;
	Boolean statementsIsComposed = true;

	public Block() {
	}

	public Block(String id,

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, Statement statements) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.statements = statements;
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

	public void setStatements(Statement statements) {
		this.statements = statements;
	}

	public Statement getStatements() {
		return statements;
	}

}
