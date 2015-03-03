package mm;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class PhDThesis extends Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String title, month;
	int year;
	String schoolId;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}
	
	public PhDThesis(String id, String ee, String url, String key, String[] authorsIds,
			String mdate, String title, String month, int year,
			String schoolId) {
		super(ee, url, key, authorsIds, mdate);
		this.id = id;
		this.title = title;
		this.month = month;
		this.year = year;
		this.schoolId = schoolId;
	}
	public PhDThesis() {
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
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
}
