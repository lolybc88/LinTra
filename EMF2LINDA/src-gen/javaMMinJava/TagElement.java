package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class TagElement extends ASTNode
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String tagName;

	ASTNode fragments;
	Boolean fragmentsIsComposed = true;

	public TagElement() {
	}

	public TagElement(
				String id,				
				String tagName
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ASTNode fragments ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.tagName = tagName ;
				
				this.fragments = fragments ;
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

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setFragments(ASTNode fragments) {
		this.fragments = fragments;
	}

	public ASTNode getFragments() {
		return fragments;
	}

}
