package javaMMinJava;

import blackboard.IdentifiableElement;

import java.io.Serializable;

public class Package extends NamedElement implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String[] ownedElementsID;
	Boolean ownedElementsIsComposed = false;
	
	String modelID;
	Boolean modelIsComposed = false;
	

	String[] ownedPackagesID;
	Boolean ownedPackagesIsComposed = true;

	String packageID;
	Package package_;
	Boolean packageIsComposed = false;

	String[] usagesInPackageAccessID;
	Boolean usagesInPackageAccessIsComposed = false;

	public Package() {
	}

	public Package(String id, String[] commentsID,
			String originalClassFileID,
			String originalCompilationUnitID,
			String name, Boolean proxy,
			String[] usagesInImportsID, 
			String[] ownedElementsID, 
			String modelID,
			String[] ownedPackagesID,
			String packageID, Package package_,
			String[] usagesInPackageAccessID) {

		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);
		
		this.id = id;
		
		this.ownedElementsID = ownedElementsID;
		this.modelID = modelID;
		this.ownedPackagesID = ownedPackagesID;
		this.packageID = packageID;
		this.usagesInPackageAccessID = usagesInPackageAccessID;

		this.package_ = package_;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public void setPackage(Package package_) {
		this.package_ = package_;
	}

	public Package getPackage() {
		return package_;
	}

	public String[] getOwnedElementsID() {
		return ownedElementsID;
	}

	public void setOwnedElementsID(String[] ownedElementsID) {
		this.ownedElementsID = ownedElementsID;
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public String[] getOwnedPackagesID() {
		return ownedPackagesID;
	}

	public void setOwnedPackagesID(String[] ownedPackagesID) {
		this.ownedPackagesID = ownedPackagesID;
	}

	public String getPackageID() {
		return packageID;
	}

	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}

	public void setPackage_(Package package_) {
		this.package_ = package_;
	}

	public String[] getUsagesInPackageAccessID() {
		return usagesInPackageAccessID;
	}

	public void setUsagesInPackageAccessID(String[] usagesInPackageAccessID) {
		this.usagesInPackageAccessID = usagesInPackageAccessID;
	}

}
