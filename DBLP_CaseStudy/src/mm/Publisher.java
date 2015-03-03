package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Publisher implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String name, address;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}
	
	public Publisher(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public synchronized String getAddress() {
		return address;
	}
	public synchronized void setAddress(String address) {
		this.address = address;
	}
	
}
