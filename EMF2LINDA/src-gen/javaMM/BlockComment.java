package javaMM;

import java.io.Serializable;

public class BlockComment extends Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public BlockComment() {
	}

	public BlockComment(String id, String[] commentsID,
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
