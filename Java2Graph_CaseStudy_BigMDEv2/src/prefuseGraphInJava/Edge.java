package prefuseGraphInJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Edge implements Serializable, IdentifiableElement {
	
	private static final long serialVersionUID = 1L;
	
	String id, trgId;
	private String sourceId, targetId;
	
	public Edge() { }
	
	public Edge(String id, String trgId, String sourceId, String targetId) {
		this.id = id;
		this.trgId = trgId;
		this.sourceId = sourceId;
		this.targetId = targetId;
	}

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getSourceId() {
		return sourceId;
	}

	public synchronized void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public synchronized String getTargetId() {
		return targetId;
	}

	public synchronized void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public synchronized String getTrgId() {
		return trgId;
	}

	public synchronized void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	@Override
	public synchronized String toString() {
		return "Edge [id=" + id + ", trgId=" + trgId + ", sourceId=" + sourceId
				+ ", targetId=" + targetId + "]";
	}
	
}
