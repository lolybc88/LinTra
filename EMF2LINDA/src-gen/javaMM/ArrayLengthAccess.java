package javaMM;

import java.io.Serializable;

public class ArrayLengthAccess extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String arrayID;
	Boolean arrayIsComposed = true;

	public ArrayLengthAccess() {
	}

	public ArrayLengthAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String arrayID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.arrayID = arrayID;
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

}
