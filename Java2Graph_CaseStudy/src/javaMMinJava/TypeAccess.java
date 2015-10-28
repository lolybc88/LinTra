package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class TypeAccess extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String typeID;
	Boolean typeIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

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

	@Override
	public String toString() {
		return "TypeAccess [id=" + id + ", typeID=" + typeID
				+ ", typeIsComposed=" + typeIsComposed + ", qualifierID="
				+ qualifierID + ", qualifierIsComposed=" + qualifierIsComposed
				+ ", trgId=" + trgId + ", commentsID="
				+ Arrays.toString(commentsID) + ", commentsIsComposed="
				+ commentsIsComposed + ", originalCompilationUnitID="
				+ originalCompilationUnitID
				+ ", originalCompilationUnitIsComposed="
				+ originalCompilationUnitIsComposed + ", originalClassFileID="
				+ originalClassFileID + ", originalClassFileIsComposed="
				+ originalClassFileIsComposed + "]";
	}

}
