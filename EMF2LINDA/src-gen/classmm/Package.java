package classmm;

import java.io.Serializable;

public class Package extends NamedElt implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String[] classesID;
	Boolean classesIsComposed = true;

	public Package() {
	}

	public Package(String id, String name, String[] classesID) {
		super(name);

		this.id = id;

		this.classesID = classesID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClasses(String[] classesID) {
		this.classesID = classesID;
	}

	public String[] getClasses() {
		return classesID;
	}

}
