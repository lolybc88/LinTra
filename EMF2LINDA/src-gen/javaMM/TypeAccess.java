package javaMM;

import java.io.Serializable;

public class TypeAccess extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String typeID;
	Boolean typeIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;

	public TypeAccess() {
	}

	public TypeAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String typeID, String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.typeID = typeID;
		this.qualifierID = qualifierID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

}
