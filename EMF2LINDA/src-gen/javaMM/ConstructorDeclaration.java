package javaMM;

import java.io.Serializable;

public class ConstructorDeclaration extends AbstractMethodDeclaration
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public ConstructorDeclaration() {
	}

	public ConstructorDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			String bodyID, String[] parametersID, String[] thrownExceptionsID,
			String[] typeParametersID, String[] usagesInDocCommentsID,
			String[] usagesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID,
				bodyID, parametersID, thrownExceptionsID, typeParametersID,
				usagesInDocCommentsID, usagesID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
