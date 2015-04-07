package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class LineComment extends Comment
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public LineComment() {
	}

	public LineComment(String id, String content, Boolean enclosedByParent,
			Boolean prefixOfParent, Comment comments,
			CompilationUnit originalCompilationUnit, ClassFile originalClassFile) {

		super(content, enclosedByParent, prefixOfParent, comments,
				originalCompilationUnit, originalClassFile);

		this.id = id;

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

}
