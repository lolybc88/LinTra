package jIMDb;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class Group implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	double avgRating;

	String[] commonMoviesID;

	public Group(String[] commonMoviesID, double d) {

		super();

		this.avgRating = d;

		this.commonMoviesID = commonMoviesID;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setCommonMovies(String[] commonMoviesID) {
		this.commonMoviesID = commonMoviesID;
	}

	public String[] getCommonMovies() {
		return commonMoviesID;
	}

}
