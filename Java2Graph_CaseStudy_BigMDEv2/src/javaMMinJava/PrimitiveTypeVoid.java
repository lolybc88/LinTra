package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class PrimitiveTypeVoid extends PrimitiveType implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	public PrimitiveTypeVoid() {
	}

	public PrimitiveTypeVoid(String id, String[] commentsID,
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
