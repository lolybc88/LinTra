package javaMMinJava;

import java.io.Serializable;
import java.util.Arrays;

import blackboard.IdentifiableElement;

public class Package extends NamedElement implements Serializable, IdentifiableElement {

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
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

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

	public String[] getUsagesInPackageAccessID() {
		return usagesInPackageAccessID;
	}

	public void setUsagesInPackageAccessID(String[] usagesInPackageAccessID) {
		this.usagesInPackageAccessID = usagesInPackageAccessID;
	}

	@Override
	public String toString() {
		return "Package [id=" + id + ", ownedElementsID="
				+ Arrays.toString(ownedElementsID)
				+ ", ownedElementsIsComposed=" + ownedElementsIsComposed
				+ ", modelID=" + modelID + ", modelIsComposed="
				+ modelIsComposed + ", ownedPackagesID="
				+ Arrays.toString(ownedPackagesID)
				+ ", ownedPackagesIsComposed=" + ownedPackagesIsComposed
				+ ", packageID=" + packageID + ", packageIsComposed="
				+ packageIsComposed + ", usagesInPackageAccessID="
				+ Arrays.toString(usagesInPackageAccessID)
				+ ", usagesInPackageAccessIsComposed="
				+ usagesInPackageAccessIsComposed + "]";
	}
	
	

}
