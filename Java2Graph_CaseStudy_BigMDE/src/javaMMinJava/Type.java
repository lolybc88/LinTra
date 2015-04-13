package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class Type extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	TypeAccess[] usagesInTypeAccess;
	Boolean usagesInTypeAccessIsComposed = false;

	public Type() {
	}

	public Type(

	String name, Boolean proxy, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			TypeAccess[] usagesInTypeAccess) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports);

		this.usagesInTypeAccess = usagesInTypeAccess;
	}

	public void setUsagesInTypeAccess(TypeAccess[] usagesInTypeAccess) {
		this.usagesInTypeAccess = usagesInTypeAccess;
	}

	public TypeAccess[] getUsagesInTypeAccess() {
		return usagesInTypeAccess;
	}

}
