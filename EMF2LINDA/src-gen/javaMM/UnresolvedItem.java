package javaMM;

import java.io.Serializable;

public class UnresolvedItem extends NamedElement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public UnresolvedItem() {
	}

	public UnresolvedItem(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
