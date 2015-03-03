package javaMM;

import java.io.Serializable;

public class Archive extends NamedElement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String originalFilePath;

	String[] classFilesID;
	Boolean classFilesIsComposed = true;

	String manifestID;
	Boolean manifestIsComposed = true;

	public Archive() {
	}

	public Archive(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String originalFilePath, String[] classFilesID, String manifestID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.id = id;

		this.originalFilePath = originalFilePath;

		this.classFilesID = classFilesID;
		this.manifestID = manifestID;
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

	public void setClassFiles(String[] classFilesID) {
		this.classFilesID = classFilesID;
	}

	public String[] getClassFiles() {
		return classFilesID;
	}

	public void setManifest(String manifestID) {
		this.manifestID = manifestID;
	}

	public String getManifest() {
		return manifestID;
	}

}
