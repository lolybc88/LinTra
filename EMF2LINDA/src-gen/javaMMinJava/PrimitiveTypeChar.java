package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class PrimitiveTypeChar extends PrimitiveType
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public PrimitiveTypeChar() {
	}

	public PrimitiveTypeChar(String id, String name, Boolean proxy,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			TypeAccess usagesInTypeAccess) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, usagesInTypeAccess);

		this.id = id;

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

}
