package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class ArrayCreation extends Expression implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Expression dimensions;
	Boolean dimensionsIsComposed = true;

	ArrayInitializer initializer;
	Boolean initializerIsComposed = true;

	TypeAccess type;
	Boolean typeIsComposed = true;

	public ArrayCreation() {
	}

	public ArrayCreation(String id,

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, Expression dimensions,
			ArrayInitializer initializer, TypeAccess type) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.dimensions = dimensions;
		this.initializer = initializer;
		this.type = type;
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

	public void setDimensions(Expression dimensions) {
		this.dimensions = dimensions;
	}

	public Expression getDimensions() {
		return dimensions;
	}

	public void setInitializer(ArrayInitializer initializer) {
		this.initializer = initializer;
	}

	public ArrayInitializer getInitializer() {
		return initializer;
	}

	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

}
