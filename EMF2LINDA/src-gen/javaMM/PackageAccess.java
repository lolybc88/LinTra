package javaMM;

import java.io.Serializable;

public class PackageAccess extends NamespaceAccess implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String packageID;
	Boolean packageIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;

	public PackageAccess() {
	}

	public PackageAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String packageID, String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.packageID = packageID;
		this.qualifierID = qualifierID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPackage(String packageID) {
		this.packageID = packageID;
	}

	public String getPackage() {
		return packageID;
	}

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

}
