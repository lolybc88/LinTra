package jICMTAuthor;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Author implements IdentifiableElement, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	int numberPapers;
	String[] publishingIn;
	boolean active;
	String[] coauthors;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Author(String id, String name, int numberPapers, boolean active, String[] publishingIn, String[] coauthors) {
		super();
		this.id = id;
		this.name = name;
		this.numberPapers = numberPapers;
		this.publishingIn = publishingIn;
		this.active = active;
		this.coauthors = coauthors;
	}
	
	public Author() {
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

	public synchronized int getNumberPapers() {
		return numberPapers;
	}

	public synchronized void setNumberPapers(int numberPapers) {
		this.numberPapers = numberPapers;
	}
	
	public synchronized String[] getPublishingIn() {
		return publishingIn;
	}

	public synchronized void setPublishingIn(String[] publishingIn) {
		this.publishingIn = publishingIn;
	}

	public synchronized boolean isActive() {
		return active;
	}

	public synchronized void setActive(boolean active) {
		this.active = active;
	}

	public synchronized String[] getCoauthors() {
		return coauthors;
	}

	public synchronized void setCoauthors(String[] coauthors) {
		this.coauthors = coauthors;
	}
}
