package abcMM;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class A extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String cID;
	Boolean cIsComposed = false;

	public A(String id, String trgId, String name, String cID) {

		super(name);

		this.id = id;
		this.trgId = trgId;
		
		this.cID = cID;
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

	@Override
	public String toString() {
		return "A [id=" + id + ", trgId=" + trgId + ", cID=" + cID + ", name=" + name + "]";
	}

}
