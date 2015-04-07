package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class TypeParameter extends Type
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	TypeAccess bounds;
	Boolean boundsIsComposed = true;

	public TypeParameter() {
	}

	public TypeParameter(String id, String name, Boolean proxy,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			TypeAccess usagesInTypeAccess, TypeAccess bounds) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, usagesInTypeAccess);

		this.id = id;

		this.bounds = bounds;
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

	public void setBounds(TypeAccess bounds) {
		this.bounds = bounds;
	}

	public TypeAccess getBounds() {
		return bounds;
	}

}
