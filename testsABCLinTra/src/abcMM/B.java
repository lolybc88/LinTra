package abcMM;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class B extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String cID;
	Boolean cIsComposed = false;

	String aID;
	Boolean aIsComposed = false;

	public B(String id, String trgId, String name, String cID, String aID) {

		super(name);

		this.id = id;
		this.trgId = trgId;

		this.cID = cID;
		this.aID = aID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public void setC(String cID) {
		this.cID = cID;
	}

	public String getC() {
		return cID;
	}

	public void setA(String aID) {
		this.aID = aID;
	}

	public String getA() {
		return aID;
	}

	@Override
	public String toString() {
		return "B [id=" + id + ", trgId=" + trgId + ", cID=" + cID + ", aID="
				+ aID + ", name=" + name + "]";
	}

}
