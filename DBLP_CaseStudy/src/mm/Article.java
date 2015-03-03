package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Article extends Record implements IdentifiableElement, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String title, month, volume;
	int fromPage, toPage, number, year;
	String journalId;
	
	String trgId;
	
	public String getJournalId() {
		return journalId;
	}

	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}
	
	public Article(String id, String ee, String url, String key, String[] authorsIds,
			String mdate, String title, String month, int fromPage,
			int toPage, int number, String volume, String journalId, int year) {
		super(ee, url, key, authorsIds, mdate);
		this.id = id;
		this.title = title;
		this.month = month;
		this.fromPage = fromPage;
		this.toPage = toPage;
		this.number = number;
		this.volume = volume;
		this.journalId = journalId;
		this.year = year;
	}
	public Article() {
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
}
