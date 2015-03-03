package mm;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class Author implements IdentifiableElement, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	String[] records;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public Author(String id, String name, String[] records) {
		super();
		this.id = id;
		this.name = name;
		this.records = records;
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
	
	public String[] getRecords() {
		return records;
	}

	public void setRecords(String[] records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", records="
				+ Arrays.toString(records) + "]";
	}
}
