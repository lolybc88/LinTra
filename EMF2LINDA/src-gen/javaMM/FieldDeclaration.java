package javaMM;

import java.io.Serializable;

public class FieldDeclaration extends BodyDeclaration implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;
	
	String typeID; Boolean typeIsComposed = true;
	String[] fragmentsID; Boolean fragmentsIsComposed = true;


	public FieldDeclaration() {
	}

	public FieldDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String typeID, String[] fragmentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID);

		this.id = id;
		this.typeID = typeID;
		this.fragmentsID = fragmentsID;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
