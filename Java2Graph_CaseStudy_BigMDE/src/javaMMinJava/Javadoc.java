package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Javadoc extends Comment
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	TagElement tags;
	Boolean tagsIsComposed = true;

	public Javadoc() {
	}

	public Javadoc(String id, String content, Boolean enclosedByParent,
			Boolean prefixOfParent, Comment comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, TagElement tags) {

		super(content, enclosedByParent, prefixOfParent, comments,
				originalCompilationUnit, originalClassFile);

		this.id = id;

		this.tags = tags;
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

	public void setTags(TagElement tags) {
		this.tags = tags;
	}

	public TagElement getTags() {
		return tags;
	}

}
