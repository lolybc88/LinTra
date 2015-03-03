package javaMM;

import java.io.Serializable;

public class MethodRefParameter extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String name;
	Boolean varargs;

	String typeID;
	Boolean typeIsComposed = true;

	public MethodRefParameter() {
	}

	public MethodRefParameter(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean varargs, String typeID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.name = name;
		this.varargs = varargs;

		this.typeID = typeID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

}
