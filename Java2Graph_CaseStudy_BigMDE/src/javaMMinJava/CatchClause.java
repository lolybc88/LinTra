package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class CatchClause extends Statement implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	SingleVariableDeclaration exception;
	Boolean exceptionIsComposed = true;

	Block body;
	Boolean bodyIsComposed = true;

	public CatchClause() {
	}

	public CatchClause(String id,

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, SingleVariableDeclaration exception,
			Block body) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.exception = exception;
		this.body = body;
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

	public void setException(SingleVariableDeclaration exception) {
		this.exception = exception;
	}

	public SingleVariableDeclaration getException() {
		return exception;
	}

	public void setBody(Block body) {
		this.body = body;
	}

	public Block getBody() {
		return body;
	}

}
