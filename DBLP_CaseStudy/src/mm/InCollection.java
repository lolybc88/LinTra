package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class InCollection extends Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String title, bookTitle, month;
	int year, fromPage, toPage;
	String[] editorIds;
	String publisherId, organizationIds;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}
	
	public InCollection(String id, String ee, String url, String key, String[] authorsIds,
			String mdate, String title, String bookTitle,
			String month, int year, int fromPage, int toPage,
			String organizationIds, String[] editorIds,
			String publisherId) {
		super(ee, url, key, authorsIds, mdate);
		this.id = id;
		this.title = title;
		this.bookTitle = bookTitle;
		this.month = month;
		this.year = year;
		this.fromPage = fromPage;
		this.toPage = toPage;
		this.organizationIds = organizationIds;
		this.editorIds = editorIds;
		this.publisherId = publisherId;
	}
	public InCollection() {
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
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
	public int getFromPage() {
		return fromPage;
	}
	public void setFromPage(int fromPage) {
		this.fromPage = fromPage;
	}
	public int getToPage() {
		return toPage;
	}
	public void setToPage(int toPage) {
		this.toPage = toPage;
	}
	public String getOrganizationIds() {
		return organizationIds;
	}
	public void setOrganizationIds(String organizationIds) {
		this.organizationIds = organizationIds;
	}
	public String[] getEditorIds() {
		return editorIds;
	}
	public void setEditorIds(String[] editorIds) {
		this.editorIds = editorIds;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

}
