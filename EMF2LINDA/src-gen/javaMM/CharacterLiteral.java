package javaMM;

import java.io.Serializable;

public class CharacterLiteral extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String escapedValue;

	public CharacterLiteral() {
	}

	public CharacterLiteral(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String escapedValue) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.escapedValue = escapedValue;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEscapedValue(String escapedValue) {
		this.escapedValue = escapedValue;
	}

	public String getEscapedValue() {
		return escapedValue;
	}

}
