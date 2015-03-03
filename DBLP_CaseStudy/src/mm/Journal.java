package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Journal extends Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	String[] articlesIds;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}
	
	public Journal(String id, String name, String[] articlesIds) {
		super();
		this.id = id;
		this.name = name;
		this.articlesIds = articlesIds;
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
	public String[] getArticlesIds() {
		return articlesIds;
	}
	public void setArticlesIds(String[] articlesIds) {
		this.articlesIds = articlesIds;
	}
}
