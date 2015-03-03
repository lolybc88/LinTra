package javaMM;

import java.io.Serializable;

public class PrimitiveTypeInt extends PrimitiveType implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public PrimitiveTypeInt() {
	}

	public PrimitiveTypeInt(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String[] usagesInTypeAccessID) {
		super(id, commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, usagesInTypeAccessID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
