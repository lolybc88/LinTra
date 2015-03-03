package javaMM;

import java.io.Serializable;

public abstract class NamedElement extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;
	Boolean proxy;

	String[] usagesInImportsID;
	Boolean usagesInImportsIsComposed = false;

	public NamedElement() {
	}

	public NamedElement(String[] commentsID, String originalCompilationUnitID,
			String originalClassFileID, String name, Boolean proxy,
			String[] usagesInImportsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.name = name;
		this.proxy = proxy;

		this.usagesInImportsID = usagesInImportsID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setProxy(Boolean proxy) {
		this.proxy = proxy;
	}

	public Boolean getProxy() {
		return proxy;
	}

	public void setUsagesInImports(String[] usagesInImportsID) {
		this.usagesInImportsID = usagesInImportsID;
	}

	public String[] getUsagesInImports() {
		return usagesInImportsID;
	}

}
