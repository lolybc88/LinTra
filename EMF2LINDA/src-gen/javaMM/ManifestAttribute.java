package javaMM;

import java.io.Serializable;

public class ManifestAttribute implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String key;
	String value;

	public ManifestAttribute() {
	}

	public ManifestAttribute(String id, String key, String value) {
		super();

		this.id = id;

		this.key = key;
		this.value = value;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
