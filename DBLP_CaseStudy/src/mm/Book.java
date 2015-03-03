package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class Book extends Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String title, month, series, isbn;
	int year, volume, edition;
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
	
	public Book(String id, String ee, String url, String key, String[] authorsIds,
			String mdate, String title, String month, String series,
			String isbn, int year, int volume, int edition, String publisherId) {
		super(ee, url, key, authorsIds, mdate);
		this.id = id;
		this.title = title;
		this.month = month;
		this.series = series;
		this.isbn = isbn;
		this.year = year;
		this.volume = volume;
		this.edition = edition;
		this.publisherId = publisherId;
	}
	public Book() {
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
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
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
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherIds(String publisherId) {
		this.publisherId = publisherId;
	}
}
