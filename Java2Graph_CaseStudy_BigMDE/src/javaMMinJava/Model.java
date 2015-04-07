package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Model implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String name;

	Package ownedElements;
	Boolean ownedElementsIsComposed = true;

	Type orphanTypes;
	Boolean orphanTypesIsComposed = true;

	UnresolvedItem unresolvedItems;
	Boolean unresolvedItemsIsComposed = true;

	CompilationUnit compilationUnits;
	Boolean compilationUnitsIsComposed = true;

	ClassFile classFiles;
	Boolean classFilesIsComposed = true;

	Archive archives;
	Boolean archivesIsComposed = true;

	public Model() {
	}

	public Model(String id, String name, Package ownedElements,
			Type orphanTypes, UnresolvedItem unresolvedItems,
			CompilationUnit compilationUnits, ClassFile classFiles,
			Archive archives) {

		super();

		this.id = id;

		this.name = name;

		this.ownedElements = ownedElements;
		this.orphanTypes = orphanTypes;
		this.unresolvedItems = unresolvedItems;
		this.compilationUnits = compilationUnits;
		this.classFiles = classFiles;
		this.archives = archives;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setOwnedElements(Package ownedElements) {
		this.ownedElements = ownedElements;
	}

	public Package getOwnedElements() {
		return ownedElements;
	}

	public void setOrphanTypes(Type orphanTypes) {
		this.orphanTypes = orphanTypes;
	}

	public Type getOrphanTypes() {
		return orphanTypes;
	}

	public void setUnresolvedItems(UnresolvedItem unresolvedItems) {
		this.unresolvedItems = unresolvedItems;
	}

	public UnresolvedItem getUnresolvedItems() {
		return unresolvedItems;
	}

	public void setCompilationUnits(CompilationUnit compilationUnits) {
		this.compilationUnits = compilationUnits;
	}

	public CompilationUnit getCompilationUnits() {
		return compilationUnits;
	}

	public void setClassFiles(ClassFile classFiles) {
		this.classFiles = classFiles;
	}

	public ClassFile getClassFiles() {
		return classFiles;
	}

	public void setArchives(Archive archives) {
		this.archives = archives;
	}

	public Archive getArchives() {
		return archives;
	}

}
