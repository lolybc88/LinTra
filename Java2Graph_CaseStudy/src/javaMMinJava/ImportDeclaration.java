package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ImportDeclaration extends ASTNode implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	Boolean static_;

	String importedElementID;
	Boolean importedElementIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ImportDeclaration() {
	}

	public ImportDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			Boolean static_, String importedElementID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.static_ = static_;

		this.importedElementID = importedElementID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatic(Boolean static_) {
		this.static_ = static_;
	}

	public Boolean getStatic() {
		return static_;
	}

	public void setImportedElement(String importedElementID) {
		this.importedElementID = importedElementID;
	}

	public String getImportedElement() {
		return importedElementID;
	}

}
