package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class BooleanLiteral extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	Boolean value;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public BooleanLiteral() {
	}

	public BooleanLiteral(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			Boolean value) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.value = value;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

}
