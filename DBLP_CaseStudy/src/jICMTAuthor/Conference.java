package jICMTAuthor;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Conference implements IdentifiableElement, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Conference(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Conference() {
		// TODO Auto-generated constructor stub
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

	@Override
	public boolean equals(Object o) {
		return o instanceof Conference && ((Conference)o).getId().equals(id);
	}
	
	
	
}
