package javaMM;

import java.io.Serializable;

public class TypeParameter extends Type implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String[] boundsID;
	Boolean boundsIsComposed = true;

	public TypeParameter() {
	}

	public TypeParameter(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String[] usagesInTypeAccessID, String[] boundsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, usagesInTypeAccessID);

		this.id = id;

		this.boundsID = boundsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBounds(String[] boundsID) {
		this.boundsID = boundsID;
	}

	public String[] getBounds() {
		return boundsID;
	}

}
