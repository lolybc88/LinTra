package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class TextElement extends ASTNode
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String text;

	public TextElement() {
	}

	public TextElement(
				String id,				
				String text
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.text = text ;
				
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

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
