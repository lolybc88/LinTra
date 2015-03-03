package jIMDb;

import blackboard.IdentifiableElement;

import java.io.Serializable;
import java.util.Arrays;

public class Couple extends Group implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String p1ID;

	String p2ID;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Couple(String id, String[] commonMoviesID, double d,
			String p1ID, String p2ID) {

		super(commonMoviesID, d);

		this.id = id;

		this.p1ID = p1ID;
		this.p2ID = p2ID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setP1(String p1ID) {
		this.p1ID = p1ID;
	}

	public String getP1() {
		return p1ID;
	}

	public void setP2(String p2ID) {
		this.p2ID = p2ID;
	}

	public String getP2() {
		return p2ID;
	}

	@Override
	public String toString() {
		return "Couple [id=" + id + ", p1ID=" + p1ID + ", p2ID=" + p2ID
				+ ", avgRating=" + avgRating + ", commonMoviesID="
				+ Arrays.toString(commonMoviesID) + "]";
	}
}
