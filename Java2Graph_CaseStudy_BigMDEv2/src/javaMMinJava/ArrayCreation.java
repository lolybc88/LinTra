package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ArrayCreation extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String[] dimensionsID;
	Boolean dimensionsIsComposed = true;

	String initializerID;
	Boolean initializerIsComposed = true;

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

	public ArrayCreation() {
	}

	public ArrayCreation(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String[] dimensionsID, String initializerID, String typeID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.dimensionsID = dimensionsID;
		this.initializerID = initializerID;
		this.typeID = typeID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDimensions(String[] dimensionsID) {
		this.dimensionsID = dimensionsID;
	}

	public String[] getDimensions() {
		return dimensionsID;
	}

	public void setInitializer(String initializerID) {
		this.initializerID = initializerID;
	}

	public String getInitializer() {
		return initializerID;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

}
