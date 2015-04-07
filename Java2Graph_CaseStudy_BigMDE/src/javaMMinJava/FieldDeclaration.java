package javaMMinJava;

import blackboard.IdentifiableElement;

import java.io.Serializable;

public class FieldDeclaration extends BodyDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;
	
	TypeAccess type;
	Boolean typeIsComposed = true;

	VariableDeclarationFragment fragments;
	Boolean fragmentsIsComposed = true;

	public FieldDeclaration() {
	}

	public FieldDeclaration(String id, String name, Boolean proxy,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, TypeAccess type,
			VariableDeclarationFragment fragments) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier);

		this.id = id;
		
		this.type = type;
		this.fragments = fragments;

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
	
	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

	public void setFragments(VariableDeclarationFragment fragments) {
		this.fragments = fragments;
	}

	public VariableDeclarationFragment getFragments() {
		return fragments;
	}

}
