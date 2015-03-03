package javaMM;

import java.io.Serializable;

public class UnresolvedItemAccess extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String elementID;
	Boolean elementIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;

	public UnresolvedItemAccess() {
	}

	public UnresolvedItemAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String elementID, String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.elementID = elementID;
		this.qualifierID = qualifierID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setElement(String elementID) {
		this.elementID = elementID;
	}

	public String getElement() {
		return elementID;
	}

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

}
