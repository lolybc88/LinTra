package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class MethodRefParameter extends ASTNode
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String name;
	Boolean varargs;

	TypeAccess type;
	Boolean typeIsComposed = true;

	public MethodRefParameter() {
	}

	public MethodRefParameter(
				String id,				
				String name,				Boolean varargs
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				TypeAccess type ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.name = name ;
				this.varargs = varargs ;
				
				this.type = type ;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setVarargs(Boolean varargs) {
		this.varargs = varargs;
	}

	public Boolean getVarargs() {
		return varargs;
	}

	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

}
