package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class ManifestEntry implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String name;

	ManifestAttribute[] attributes;
	Boolean attributesIsComposed = true;

	public ManifestEntry() {
	}

	public ManifestEntry(String id, String name, ManifestAttribute[] attributes) {

		super();

		this.id = id;

		this.name = name;

		this.attributes = attributes;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAttributes(ManifestAttribute[] attributes) {
		this.attributes = attributes;
	}

	public ManifestAttribute[] getAttributes() {
		return attributes;
	}

}
