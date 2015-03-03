package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class TypeLiteral extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String typeID;
	Boolean typeIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public TypeLiteral() {
	}

	public TypeLiteral(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String typeID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.typeID = typeID;
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

}
