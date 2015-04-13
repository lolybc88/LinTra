package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class ArrayType extends Type
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	int dimensions;

	TypeAccess elementType;
	Boolean elementTypeIsComposed = true;

	public ArrayType() {
	}

	public ArrayType(String id, String name, Boolean proxy, int dimensions,
			Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			TypeAccess[] usagesInTypeAccess, TypeAccess elementType) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, usagesInTypeAccess);

		this.id = id;

		this.dimensions = dimensions;

		this.elementType = elementType;
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

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}

	public int getDimensions() {
		return dimensions;
	}

	public void setElementType(TypeAccess elementType) {
		this.elementType = elementType;
	}

	public TypeAccess getElementType() {
		return elementType;
	}

}
