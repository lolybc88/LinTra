package prefuseGraphInJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Node implements Serializable, IdentifiableElement {
	
	private static final long serialVersionUID = 1L;
	
	String id, trgId;
	private String name, type;
	private double size; 
	
	public Node() {}
	
	public Node(String id, String targetId, String name, String type, double size) {
		this.id = id;
		this.trgId = targetId;
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public  String getId() {
		return id;
	}

	public  void setId(String id) {
		this.id = id;
	}

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

	public  String getTrgId() {
		return trgId;
	}

	public  void setTrgId(String targetId) {
		this.trgId = targetId;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", trgId=" + trgId + ", name=" + name
				+ ", type=" + type + ", size=" + size + "]";
	}
	
}
