package Relational;

public class Column {

	String id;

	String name;

	String type;

	Boolean isTransformed;

	public Column() {
	}

	public Column(String name, String type) {
		super();

		this.name = name;

		this.type = type;

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

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
