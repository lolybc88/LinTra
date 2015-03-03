package classmm;

import java.io.Serializable;

public class Method extends NamedElt implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String ownerID;
	Boolean ownerIsComposed = false;

	String[] paramsID;
	Boolean paramsIsComposed = true;

	public Method() {
	}

	public Method(String id, String name, String ownerID, String[] paramsID) {
		super(name);

		this.id = id;

		this.ownerID = ownerID;
		this.paramsID = paramsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOwner(String ownerID) {
		this.ownerID = ownerID;
	}

	public String getOwner() {
		return ownerID;
	}

	public void setParams(String[] paramsID) {
		this.paramsID = paramsID;
	}

	public String[] getParams() {
		return paramsID;
	}

}
