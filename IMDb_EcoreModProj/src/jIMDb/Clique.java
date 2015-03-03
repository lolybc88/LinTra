package jIMDb;

import blackboard.IdentifiableElement;

import java.io.Serializable;

public class Clique extends Group implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String[] personsID;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Clique(String id, String[] commonMoviesID, double avgRating,
			String[] personsID) {

		super(commonMoviesID, avgRating);

		this.id = id;

		this.personsID = personsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPersons(String[] personsID) {
		this.personsID = personsID;
	}

	public String[] getPersons() {
		return personsID;
	}

}
