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
			String[] usagesInImportsID, String abstractTypeDeclarationID,
			String[] annotationsID, String anonymousClassDeclarationOwnerID,
			String modifierID, String defaultID, String typeID,
			String[] usagesID) {
		super(id, commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID,
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
