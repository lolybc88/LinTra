package classmm;

import java.io.Serializable;

public class Attribute extends NamedElt implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	Boolean multivalued;

	String visibility;

	String typeID;
	Boolean typeIsComposed = false;

	String ownerID;
	Boolean ownerIsComposed = false;

	public Attribute() {
	}

	public Attribute(String id, String name, Boolean multivalued,
			String typeID, String ownerID, String visibility) {
		super(name);

		this.id = id;

		this.multivalued = multivalued;
		this.visibility = visibility;

		this.typeID = typeID;
		this.ownerID = ownerID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMultivalued(Boolean multivalued) {
		this.multivalued = multivalued;
	}

	public Boolean getMultivalued() {
		return multivalued;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

	public void setOwner(String ownerID) {
		this.ownerID = ownerID;
	}

	public String getOwner() {
		return ownerID;
	}

}
