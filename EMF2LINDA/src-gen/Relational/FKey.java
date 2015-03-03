package Relational;

public class FKey {

	String id;

	String colsID;
	Boolean colsIsComposed = false;

	String refsID;
	Boolean refsIsComposed = false;

	Boolean isTransformed;

	public FKey() {
	}

	public FKey(String cols, String refs) {
		super();

		this.colsID = cols;

		this.refsID = refs;

		isTransformed = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCols(String cols) {
		this.colsID = cols;
	}

	public String getCols() {
		return colsID;
	}

	public void setRefs(String refs) {
		this.refsID = refs;
	}

	public String getRefs() {
		return refsID;
	}

}
