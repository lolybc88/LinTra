package jIMDb;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class Person implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String name;

	String[] moviesID;

	public Person(String[] moviesID, String name) {

		super();

		this.name = name;

		this.moviesID = moviesID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMovies(String[] moviesID) {
		this.moviesID = moviesID;
	}

	public String[] getMovies() {
		return moviesID;
	}

}
