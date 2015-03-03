package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Javadoc extends Comment implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String[] tagsID;
	Boolean tagsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Javadoc() {
	}

	public Javadoc(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String content, Boolean enclosedByParent, Boolean prefixOfParent,
			String[] tagsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				content, enclosedByParent, prefixOfParent);

		this.id = id;

		this.tagsID = tagsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTags(String[] tagsID) {
		this.tagsID = tagsID;
	}

	public String[] getTags() {
		return tagsID;
	}

}
