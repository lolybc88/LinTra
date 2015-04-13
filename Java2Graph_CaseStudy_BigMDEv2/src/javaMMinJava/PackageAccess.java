package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class PackageAccess extends NamespaceAccess implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String packageID;
	Boolean packageIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

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
