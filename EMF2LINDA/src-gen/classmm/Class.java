package classmm;

import java.io.Serializable;

public class Class extends Classifier implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	Boolean isAbstract;

	String visibility;

	String[] attID;
	Boolean attIsComposed = true;

	String[] superID;
	Boolean superIsComposed = false;

	String packageID;
	Boolean packageIsComposed = false;

	String[] methodsID;
	Boolean methodsIsComposed = true;

	public Class() {
	}

	public Class(String id, String name, Boolean isAbstract, String[] attID,
			String[] superID, String packageID, String[] methodsID,
			String visibility) {
		super(name);

		this.id = id;

		this.isAbstract = isAbstract;
		this.visibility = visibility;

		this.attID = attID;
		this.superID = superID;
		this.packageID = packageID;
		this.methodsID = methodsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIsAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public Boolean getIsAbstract() {
		return isAbstract;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setAtt(String[] attID) {
		this.attID = attID;
	}

	public String[] getAtt() {
		return attID;
	}

	public void setSuper(String[] superID) {
		this.superID = superID;
	}

	public String[] getSuper() {
		return superID;
	}

	public void setPackage(String packageID) {
		this.packageID = packageID;
	}

	public String getPackage() {
		return packageID;
	}

	public void setMethods(String[] methodsID) {
		this.methodsID = methodsID;
	}

	public String[] getMethods() {
		return methodsID;
	}

}
