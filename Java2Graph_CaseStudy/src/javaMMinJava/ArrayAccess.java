package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ArrayAccess extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String arrayID;
	Boolean arrayIsComposed = true;

	String indexID;
	Boolean indexIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ArrayAccess() {
	}

	public ArrayAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String arrayID, String indexID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.arrayID = arrayID;
		this.indexID = indexID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setArray(String arrayID) {
		this.arrayID = arrayID;
	}

	public String getArray() {
		return arrayID;
	}

	public void setIndex(String indexID) {
		this.indexID = indexID;
	}

	public String getIndex() {
		return indexID;
	}

}
