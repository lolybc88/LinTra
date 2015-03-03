package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class LineComment extends Comment implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public LineComment() {
	}

	public LineComment(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String content, Boolean enclosedByParent, Boolean prefixOfParent) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				content, enclosedByParent, prefixOfParent);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
