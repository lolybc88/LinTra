package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class NullLiteral extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public NullLiteral() {
	}

	public NullLiteral(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
