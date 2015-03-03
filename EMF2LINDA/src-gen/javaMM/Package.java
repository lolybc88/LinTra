package javaMM;

import java.io.Serializable;

public class Package extends NamedElement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String[] ownedElementsID;
	Boolean ownedElementsIsComposed = true;

	String modelID;
	Boolean modelIsComposed = false;

	String[] ownedPackagesID;
	Boolean ownedPackagesIsComposed = true;

	String packageID;
	Boolean packageIsComposed = false;

	String[] usagesInPackageAccessID;
	Boolean usagesInPackageAccessIsComposed = false;

	public Package() {
	}

	public Package(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String[] ownedElementsID, String modelID, String[] ownedPackagesID,
			String packageID, String[] usagesInPackageAccessID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.id = id;

		this.ownedElementsID = ownedElementsID;
		this.modelID = modelID;
		this.ownedPackagesID = ownedPackagesID;
		this.packageID = packageID;
		this.usagesInPackageAccessID = usagesInPackageAccessID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOwnedElements(String[] ownedElementsID) {
		this.ownedElementsID = ownedElementsID;
	}

	public String[] getOwnedElements() {
		return ownedElementsID;
	}

	public void setModel(String modelID) {
		this.modelID = modelID;
	}

	public String getModel() {
		return modelID;
	}

	public void setOwnedPackages(String[] ownedPackagesID) {
		this.ownedPackagesID = ownedPackagesID;
	}

	public String[] getOwnedPackages() {
		return ownedPackagesID;
	}

	public void setPackage(String packageID) {
		this.packageID = packageID;
	}

	public String getPackage() {
		return packageID;
	}

	public void setUsagesInPackageAccess(String[] usagesInPackageAccessID) {
		this.usagesInPackageAccessID = usagesInPackageAccessID;
	}

	public String[] getUsagesInPackageAccess() {
		return usagesInPackageAccessID;
	}

}
