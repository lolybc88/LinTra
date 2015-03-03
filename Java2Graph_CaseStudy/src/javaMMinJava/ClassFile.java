package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ClassFile extends NamedElement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String originalFilePath;

	String typeID;
	Boolean typeIsComposed = false;

	String attachedSourceID;
	Boolean attachedSourceIsComposed = false;

	String packageID;
	Boolean packageIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ClassFile() {
	}

	public ClassFile(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String originalFilePath, String typeID, String attachedSourceID,
			String packageID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.id = id;

		this.originalFilePath = originalFilePath;

		this.typeID = typeID;
		this.attachedSourceID = attachedSourceID;
		this.packageID = packageID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOriginalFilePath(String originalFilePath) {
		this.originalFilePath = originalFilePath;
	}

	public String getOriginalFilePath() {
		return originalFilePath;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

	public void setAttachedSource(String attachedSourceID) {
		this.attachedSourceID = attachedSourceID;
	}

	public String getAttachedSource() {
		return attachedSourceID;
	}

	public void setPackage(String packageID) {
		this.packageID = packageID;
	}

	public String getPackage() {
		return packageID;
	}

}
