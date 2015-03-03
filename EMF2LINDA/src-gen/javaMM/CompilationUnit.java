package javaMM;

import java.io.Serializable;

public class CompilationUnit extends NamedElement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String originalFilePath;

	String[] commentListID;
	Boolean commentListIsComposed = false;

	String[] importsID;
	Boolean importsIsComposed = true;

	String packageID;
	Boolean packageIsComposed = false;

	String[] typesID;
	Boolean typesIsComposed = false;

	public CompilationUnit() {
	}

	public CompilationUnit(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String originalFilePath, String[] commentListID,
			String[] importsID, String packageID, String[] typesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.id = id;

		this.originalFilePath = originalFilePath;

		this.commentListID = commentListID;
		this.importsID = importsID;
		this.packageID = packageID;
		this.typesID = typesID;
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

	public void setCommentList(String[] commentListID) {
		this.commentListID = commentListID;
	}

	public String[] getCommentList() {
		return commentListID;
	}

	public void setImports(String[] importsID) {
		this.importsID = importsID;
	}

	public String[] getImports() {
		return importsID;
	}

	public void setPackage(String packageID) {
		this.packageID = packageID;
	}

	public String getPackage() {
		return packageID;
	}

	public void setTypes(String[] typesID) {
		this.typesID = typesID;
	}

	public String[] getTypes() {
		return typesID;
	}

}
