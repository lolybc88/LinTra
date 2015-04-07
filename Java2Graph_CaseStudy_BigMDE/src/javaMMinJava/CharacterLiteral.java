package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class CharacterLiteral extends Expression implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String escapedValue;

	public CharacterLiteral() {
	}

	public CharacterLiteral(String id, String escapedValue, Comment comments,
			CompilationUnit originalCompilationUnit, ClassFile originalClassFile) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.escapedValue = escapedValue;

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

	public void setEscapedValue(String escapedValue) {
		this.escapedValue = escapedValue;
	}

	public String getEscapedValue() {
		return escapedValue;
	}

}
