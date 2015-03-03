package classmm;

import java.io.Serializable;

public abstract class NamedElt implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;

	public NamedElt() {
	}

	public NamedElt(String name) {
		super();

		this.name = name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
