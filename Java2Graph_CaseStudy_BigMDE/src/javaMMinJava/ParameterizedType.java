package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class ParameterizedType extends Type
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	TypeAccess type;
	Boolean typeIsComposed = true;

	TypeAccess typeArguments;
	Boolean typeArgumentsIsComposed = true;

	public ParameterizedType() {
	}

	public ParameterizedType(String id, String name, Boolean proxy,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			TypeAccess usagesInTypeAccess, TypeAccess type,
			TypeAccess typeArguments) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, usagesInTypeAccess);

		this.id = id;

		this.type = type;
		this.typeArguments = typeArguments;
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

	public void setTypeArguments(TypeAccess typeArguments) {
		this.typeArguments = typeArguments;
	}

	public TypeAccess getTypeArguments() {
		return typeArguments;
	}

}
