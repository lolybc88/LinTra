package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Proceedings extends Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String title, month, isbn;
	int year;
	String[] editorIds, sponsoredByIds;
	String publisherId;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}
	
	public Proceedings(String id, String ee, String url, String key, String[] authorsIds,
			String mdate, String title, String month, String isbn,
			int year, String[] editorIds, String[] sponsoredByIds,
			String publisherId) {
		super(ee, url, key, authorsIds, mdate);
		this.id = id;
		this.title = title;
		this.month = month;
		this.isbn = isbn;
		this.year = year;
		this.editorIds = editorIds;
		this.sponsoredByIds = sponsoredByIds;
		this.publisherId = publisherId;
	}
	public Proceedings() {
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public String[] getSponsoredByIds() {
		return sponsoredByIds;
	}
	public void setSponsoredByIds(String[] sponsoredByIds) {
		this.sponsoredByIds = sponsoredByIds;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

}
