package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class BooleanLiteral extends Expression implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Boolean value;

	public BooleanLiteral() {
	}

	public BooleanLiteral(String id, Boolean value, Comment comments,
			CompilationUnit originalCompilationUnit, ClassFile originalClassFile) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.value = value;

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

	public void setValue(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

}
