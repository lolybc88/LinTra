package javaMM;

import java.io.Serializable;

public class NumberLiteral extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String tokenValue;

	public NumberLiteral() {
	}

	public NumberLiteral(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String tokenValue) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.tokenValue = tokenValue;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public String getTokenValue() {
		return tokenValue;
	}

}
