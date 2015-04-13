package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class StringLiteral extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String escapedValue;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public StringLiteral() {
	}

	public StringLiteral(String id, String[] commentsID,
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
