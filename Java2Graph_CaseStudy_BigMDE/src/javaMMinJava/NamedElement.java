package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class NamedElement extends ASTNode
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String name;
	Boolean proxy;

	ImportDeclaration usagesInImports;
	Boolean usagesInImportsIsComposed = false;

	public NamedElement() {
	}

	public NamedElement(
				
				String name,				Boolean proxy
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				
				
				
				this.name = name ;
				this.proxy = proxy ;
				
				this.usagesInImports = usagesInImports ;
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

	public void setUsagesInImports(ImportDeclaration usagesInImports) {
		this.usagesInImports = usagesInImports;
	}

	public ImportDeclaration getUsagesInImports() {
		return usagesInImports;
	}

}
