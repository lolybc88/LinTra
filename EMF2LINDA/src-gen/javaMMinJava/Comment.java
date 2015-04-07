package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class Comment extends ASTNode
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String content;
	Boolean enclosedByParent;
	Boolean prefixOfParent;

	public Comment() {
	}

	public Comment(
				
				String content,				Boolean enclosedByParent,				Boolean prefixOfParent
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				
				
				
				this.content = content ;
				this.enclosedByParent = enclosedByParent ;
				this.prefixOfParent = prefixOfParent ;
				
			}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setEnclosedByParent(Boolean enclosedByParent) {
		this.enclosedByParent = enclosedByParent;
	}

	public Boolean getEnclosedByParent() {
		return enclosedByParent;
	}

	public void setPrefixOfParent(Boolean prefixOfParent) {
		this.prefixOfParent = prefixOfParent;
	}

	public Boolean getPrefixOfParent() {
		return prefixOfParent;
	}

}
