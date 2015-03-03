package javaMM;

import java.io.Serializable;

public class ArrayType extends Type implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	int dimensions;

	String elementTypeID;
	Boolean elementTypeIsComposed = true;

	public ArrayType() {
	}

	public ArrayType(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String[] usagesInTypeAccessID, int dimensions, String elementTypeID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, usagesInTypeAccessID);

		this.id = id;

		this.dimensions = dimensions;

		this.elementTypeID = elementTypeID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}

	public int getDimensions() {
		return dimensions;
	}

	public void setElementType(String elementTypeID) {
		this.elementTypeID = elementTypeID;
	}

	public String getElementType() {
		return elementTypeID;
	}

}
