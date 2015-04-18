package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class TypeAccess extends Expression implements Serializable, IdentifiableElement, IType {

	private static final long serialVersionUID = 1L;

	String id;

	String typeID;
	IType type;
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
			String typeID, IType type, String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.typeID = typeID;
		this.type = type;
		this.qualifierID = qualifierID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTypeId(String typeID) {
		this.typeID = typeID;
	}
	
	public String getTypeId() {
		return typeID;
	}

	public IType getType() {
		return type;
	}

	public void setType(IType type) {
		this.type = type;
	}

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

}
