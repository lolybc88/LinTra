package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class Type extends NamedElement implements Serializable, IdentifiableElement, IType {

	private static final long serialVersionUID = 1L;

	String[] usagesInTypeAccessID;
	Boolean usagesInTypeAccessIsComposed = false;

	public Type() {
	}

	public Type(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID, String name, Boolean proxy,
			String[] usagesInImportsID, String[] usagesInTypeAccessID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID);

		this.usagesInTypeAccessID = usagesInTypeAccessID;
	}

	public void setUsagesInTypeAccess(String[] usagesInTypeAccessID) {
		this.usagesInTypeAccessID = usagesInTypeAccessID;
	}

	public String[] getUsagesInTypeAccess() {
		return usagesInTypeAccessID;
	}

}
