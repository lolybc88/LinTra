package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class UnresolvedItemAccess extends Expression implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String elementID;
	Boolean elementIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

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
