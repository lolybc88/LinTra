package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class NumberLiteral extends Expression
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String tokenValue;

	public NumberLiteral() {
	}

	public NumberLiteral(
				String id,				
				String tokenValue
				,
				Comment[] comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.tokenValue = tokenValue ;
				
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

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public String getTokenValue() {
		return tokenValue;
	}

}
