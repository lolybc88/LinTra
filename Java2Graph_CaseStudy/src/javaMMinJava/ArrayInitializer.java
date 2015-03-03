package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ArrayInitializer extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String[] expressionsID;
	Boolean expressionsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ArrayInitializer() {
	}

	public ArrayInitializer(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String[] expressionsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.expressionsID = expressionsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setExpressions(String[] expressionsID) {
		this.expressionsID = expressionsID;
	}

	public String[] getExpressions() {
		return expressionsID;
	}

}
