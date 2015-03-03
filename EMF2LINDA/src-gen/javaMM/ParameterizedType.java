package javaMM;

import java.io.Serializable;

public class ParameterizedType extends Type implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String typeID;
	Boolean typeIsComposed = true;

	String[] typeArgumentsID;
	Boolean typeArgumentsIsComposed = true;

	public ParameterizedType() {
	}

	public ParameterizedType(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String[] usagesInTypeAccessID, String typeID,
			String[] typeArgumentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, usagesInTypeAccessID);

		this.id = id;

		this.typeID = typeID;
		this.typeArgumentsID = typeArgumentsID;
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

	public void setTypeArguments(String[] typeArgumentsID) {
		this.typeArgumentsID = typeArgumentsID;
	}

	public String[] getTypeArguments() {
		return typeArgumentsID;
	}

}
