package classmm;

import java.io.Serializable;

public class Parameter extends NamedElt implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String typeID;
	Boolean typeIsComposed = false;

	String ownerID;
	Boolean ownerIsComposed = false;

	public Parameter() {
	}

	public Parameter(String id, String name, String typeID, String ownerID) {
		super(name);

		this.id = id;

		this.typeID = typeID;
		this.ownerID = ownerID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
