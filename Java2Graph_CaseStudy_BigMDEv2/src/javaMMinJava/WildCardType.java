package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class WildCardType extends Type implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	Boolean upperBound;

	String boundID;
	Boolean boundIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public WildCardType() {
	}

	public WildCardType(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String[] usagesInTypeAccessID, Boolean upperBound, String boundID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, usagesInTypeAccessID);

		this.id = id;

		this.upperBound = upperBound;

		this.boundID = boundID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUpperBound(Boolean upperBound) {
		this.upperBound = upperBound;
	}

	public Boolean getUpperBound() {
		return upperBound;
	}

	public void setBound(String boundID) {
		this.boundID = boundID;
	}

	public String getBound() {
		return boundID;
	}

}
