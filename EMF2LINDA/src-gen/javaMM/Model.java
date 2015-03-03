package javaMM;

import java.io.Serializable;

public class Model implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String name;

	String[] ownedElementsID;
	Boolean ownedElementsIsComposed = true;

	String[] orphanTypesID;
	Boolean orphanTypesIsComposed = true;

	String[] unresolvedItemsID;
	Boolean unresolvedItemsIsComposed = true;

	String[] compilationUnitsID;
	Boolean compilationUnitsIsComposed = true;

	String[] classFilesID;
	Boolean classFilesIsComposed = true;

	String[] archivesID;
	Boolean archivesIsComposed = true;

	public Model() {
	}

	public Model(String id, String name, String[] ownedElementsID,
			String[] orphanTypesID, String[] unresolvedItemsID,
			String[] compilationUnitsID, String[] classFilesID,
			String[] archivesID) {
		super();

		this.id = id;

		this.name = name;

		this.ownedElementsID = ownedElementsID;
		this.orphanTypesID = orphanTypesID;
		this.unresolvedItemsID = unresolvedItemsID;
		this.compilationUnitsID = compilationUnitsID;
		this.classFilesID = classFilesID;
		this.archivesID = archivesID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setOwnedElements(String[] ownedElementsID) {
		this.ownedElementsID = ownedElementsID;
	}

	public String[] getOwnedElements() {
		return ownedElementsID;
	}

	public void setOrphanTypes(String[] orphanTypesID) {
		this.orphanTypesID = orphanTypesID;
	}

	public String[] getOrphanTypes() {
		return orphanTypesID;
	}

	public void setUnresolvedItems(String[] unresolvedItemsID) {
		this.unresolvedItemsID = unresolvedItemsID;
	}

	public String[] getUnresolvedItems() {
		return unresolvedItemsID;
	}

	public void setCompilationUnits(String[] compilationUnitsID) {
		this.compilationUnitsID = compilationUnitsID;
	}

	public String[] getCompilationUnits() {
		return compilationUnitsID;
	}

	public void setClassFiles(String[] classFilesID) {
		this.classFilesID = classFilesID;
	}

	public String[] getClassFiles() {
		return classFilesID;
	}

	public void setArchives(String[] archivesID) {
		this.archivesID = archivesID;
	}

	public String[] getArchives() {
		return archivesID;
	}

}
