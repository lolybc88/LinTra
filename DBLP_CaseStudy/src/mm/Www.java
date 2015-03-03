package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Www extends Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String title, month;
	int year;
	String[] editorIds;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}
	
	public Www(String id, String ee, String url, String key, String[] authorsIds,
			String mdate, String title, String month, int year,
			String[] editorIds) {
		super(ee, url, key, authorsIds, mdate);
		this.id = id;
		this.title = title;
		this.month = month;
		this.year = year;
		this.editorIds = editorIds;
	}
	public Www() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String[] getEditorIds() {
		return editorIds;
	}
	public void setEditorIds(String[] editorIds) {
		this.editorIds = editorIds;
	}
	
}
