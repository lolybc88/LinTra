package jIMDb;

import blackboard.IdentifiableElement;

import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String title;
	double rating;
	int year;
	String type;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	String[] personsID;

	public Movie(String id, String[] personsID, String title, double rating,
			int year, String type) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.year = year;
		this.type = type;
		this.personsID = personsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setPersons(String[] personsID) {
		this.personsID = personsID;
	}

	public String[] getPersons() {
		return personsID;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title
				+ ", rating=" + rating + ", year=" + year + ", type=" + type
				+ ", personsID=" + Arrays.toString(personsID) + "]";
	}
}
