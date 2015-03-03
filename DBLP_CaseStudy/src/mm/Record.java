package mm;

import java.io.Serializable;
import blackboard.IdentifiableElement;

public abstract class Record implements IdentifiableElement, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ee;
	String url;
	String key;
	String[] authorsIds;
	String mdate;
	
	public Record(String ee, String url, String key, String[] authorsIds,
			String mdate) {
		super();
		this.ee = ee;
		this.url = url;
		this.key = key;
		this.authorsIds = authorsIds;
		this.mdate = mdate;
	}
	public Record(){ }
	
	public String getEe() {
		return ee;
	}
	public void setEe(String ee) {
		this.ee = ee;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String[] getAuthors() {
		return authorsIds;
	}
	public void setAuthors(String[] authors) {
		this.authorsIds = authors;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
}
