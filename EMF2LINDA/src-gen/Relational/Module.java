package Relational;

public class Module {

	String id;

	String[] columnsID;
	Boolean columnsIsComposed = true;

	String[] fkeysID;
	Boolean fkeysIsComposed = true;

	String[] tablesID;
	Boolean tablesIsComposed = true;

	Boolean isTransformed;

	public Module() {
	}

	public Module(String[] columns, String[] fkeys, String[] tables) {
		super();

		this.columnsID = columns;

		this.fkeysID = fkeys;

		this.tablesID = tables;

		isTransformed = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setColumns(String[] columns) {
		this.columnsID = columns;
	}

	public String[] getColumns() {
		return columnsID;
	}

	public void setFkeys(String[] fkeys) {
		this.fkeysID = fkeys;
	}

	public String[] getFkeys() {
		return fkeysID;
	}

	public void setTables(String[] tables) {
		this.tablesID = tables;
	}

	public String[] getTables() {
		return tablesID;
	}

}
