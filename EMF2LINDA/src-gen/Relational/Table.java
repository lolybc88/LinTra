package Relational;

public class Table {

	String id;

	String name;

	String pkeyID;
	Boolean pkeyIsComposed = false;

	String[] colsID;
	Boolean colsIsComposed = false;

	String[] fkeysID;
	Boolean fkeysIsComposed = false;

	Boolean isTransformed;

	public Table() {
	}

	public Table(String name, String pkey, String[] cols, String[] fkeys) {
		super();

		this.name = name;

		this.pkeyID = pkey;

		this.colsID = cols;

		this.fkeysID = fkeys;

		isTransformed = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPkey(String pkey) {
		this.pkeyID = pkey;
	}

	public String getPkey() {
		return pkeyID;
	}

	public void setCols(String[] cols) {
		this.colsID = cols;
	}

	public String[] getCols() {
		return colsID;
	}

	public void setFkeys(String[] fkeys) {
		this.fkeysID = fkeys;
	}

	public String[] getFkeys() {
		return fkeysID;
	}

}
