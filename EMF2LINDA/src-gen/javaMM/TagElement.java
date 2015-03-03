package javaMM;

import java.io.Serializable;

public class TagElement extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String tagName;

	String[] fragmentsID;
	Boolean fragmentsIsComposed = true;

	public TagElement() {
	}

	public TagElement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String tagName, String[] fragmentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.tagName = tagName;

		this.fragmentsID = fragmentsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setFragments(String[] fragmentsID) {
		this.fragmentsID = fragmentsID;
	}

	public String[] getFragments() {
		return fragmentsID;
	}

}
