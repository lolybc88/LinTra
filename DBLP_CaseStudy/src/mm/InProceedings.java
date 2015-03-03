package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class InProceedings extends Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String title, booktitle, month;
	int year, fromPage, toPage;
	String organizationId, publisherId;
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
	
	public InProceedings(String id, String ee, String url, String key, String[] authorsIds,
			String mdate, String title, String booktitle,
			String month, int year, int fromPage, int toPage,
			String organizationId, String publisherId, String[] editorIds) {
		super(ee, url, key, authorsIds, mdate);
		this.id = id;
		this.title = title;
		this.booktitle = booktitle;
		this.month = month;
		this.year = year;
		this.fromPage = fromPage;
		this.toPage = toPage;
		this.organizationId = organizationId;
		this.publisherId = publisherId;
		this.editorIds = editorIds;
	}
	public InProceedings() {
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
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
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
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String[] getEditorIds() {
		return editorIds;
	}
	public void setEditorIds(String[] editorIds) {
		this.editorIds = editorIds;
	}

}
