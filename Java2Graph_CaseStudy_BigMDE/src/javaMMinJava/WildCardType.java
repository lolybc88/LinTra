package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class WildCardType extends Type
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Boolean upperBound;

	TypeAccess bound;
	Boolean boundIsComposed = true;

	public WildCardType() {
	}

	public WildCardType(String id, String name, Boolean proxy,
			Boolean upperBound, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			TypeAccess[] usagesInTypeAccess, TypeAccess bound) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, usagesInTypeAccess);

		this.id = id;

		this.upperBound = upperBound;

		this.bound = bound;
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

	public void setUpperBound(Boolean upperBound) {
		this.upperBound = upperBound;
	}

	public Boolean getUpperBound() {
		return upperBound;
	}

	public void setBound(TypeAccess bound) {
		this.bound = bound;
	}

	public TypeAccess getBound() {
		return bound;
	}

}
