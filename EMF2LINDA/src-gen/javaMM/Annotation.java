package javaMM;

import java.io.Serializable;

public class Annotation extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String typeID;
	Boolean typeIsComposed = true;

	String[] valuesID;
	Boolean valuesIsComposed = true;

	public Annotation() {
	}

	public Annotation(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String typeID, String[] valuesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.typeID = typeID;
		this.valuesID = valuesID;
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

	public void setValues(String[] valuesID) {
		this.valuesID = valuesID;
	}

	public String[] getValues() {
		return valuesID;
	}

}
