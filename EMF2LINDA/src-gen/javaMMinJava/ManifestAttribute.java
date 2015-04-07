package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class ManifestAttribute implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

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

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
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
