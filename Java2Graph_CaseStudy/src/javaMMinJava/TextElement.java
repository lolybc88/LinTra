package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class TextElement extends ASTNode implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String text;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public TextElement() {
	}

	public TextElement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String text) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.text = text;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
