package abcMM;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class C extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public C(String id, String trgId, String name) {
		super(name);
		this.id = id;
		this.trgId = trgId;
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

	@Override
	public String toString() {
		return "C [id=" + id + ", trgId=" + trgId + ", name=" + name + "]";
	}
}
