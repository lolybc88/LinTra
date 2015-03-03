package classmm;

import java.io.Serializable;

public abstract class Classifier extends NamedElt implements Serializable {

	private static final long serialVersionUID = 1L;

	public Classifier() {
	}

	public Classifier(String name) {
		super(name);

	}

}
