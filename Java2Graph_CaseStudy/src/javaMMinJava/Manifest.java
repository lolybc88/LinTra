package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Manifest implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String[] mainAttributesID;
	Boolean mainAttributesIsComposed = true;

	String[] entryAttributesID;
	Boolean entryAttributesIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Manifest() {
	}

	public Manifest(String id, String[] mainAttributesID,
			String[] entryAttributesID) {
		super();

		this.id = id;

		this.mainAttributesID = mainAttributesID;
		this.entryAttributesID = entryAttributesID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMainAttributes(String[] mainAttributesID) {
		this.mainAttributesID = mainAttributesID;
	}

	public String[] getMainAttributes() {
		return mainAttributesID;
	}

	public void setEntryAttributes(String[] entryAttributesID) {
		this.entryAttributesID = entryAttributesID;
	}

	public String[] getEntryAttributes() {
		return entryAttributesID;
	}

}
