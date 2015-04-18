package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class UnresolvedAnnotationTypeMemberDeclaration
		extends
			AnnotationTypeMemberDeclaration implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	public UnresolvedAnnotationTypeMemberDeclaration() {
	}

	public UnresolvedAnnotationTypeMemberDeclaration(String id,
			String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID, String name, Boolean proxy,
			String[] usagesInImportsID, String abstractTypeDeclarationID, AbstractTypeDeclaration abstractTypeDeclaration,
			String[] annotationsID, String anonymousClassDeclarationOwnerID,
			String modifierID, Modifier modifier, String defaultID, String typeID,
			String[] usagesID) {
		super(id, commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID, abstractTypeDeclaration,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier,
				defaultID, typeID, usagesID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
