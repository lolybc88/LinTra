package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class BreakStatement extends Statement implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	LabeledStatement label;
	Boolean labelIsComposed = false;

	public BreakStatement() {
	}

	public BreakStatement(String id,

	Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, LabeledStatement label) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.label = label;
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

	public void setLabel(LabeledStatement label) {
		this.label = label;
	}

	public LabeledStatement getLabel() {
		return label;
	}

}
