package classmm;

import java.io.Serializable;

public class DataType extends Classifier implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public DataType() {
	}

	public DataType(String id, String name) {
		super(name);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
