package javaMM;

import java.io.Serializable;

public abstract class AbstractMethodInvocation extends ASTNode
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	String methodID;
	Boolean methodIsComposed = false;

	String[] argumentsID;
	Boolean argumentsIsComposed = true;

	String[] typeArgumentsID;
	Boolean typeArgumentsIsComposed = true;

	public AbstractMethodInvocation() {
	}

	public AbstractMethodInvocation(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String methodID, String[] argumentsID, String[] typeArgumentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.methodID = methodID;
		this.argumentsID = argumentsID;
		this.typeArgumentsID = typeArgumentsID;
	}

	public void setMethod(String methodID) {
		this.methodID = methodID;
	}

	public String getMethod() {
		return methodID;
	}

	public void setArguments(String[] argumentsID) {
		this.argumentsID = argumentsID;
	}

	public String[] getArguments() {
		return argumentsID;
	}

	public void setTypeArguments(String[] typeArgumentsID) {
		this.typeArgumentsID = typeArgumentsID;
	}

	public String[] getTypeArguments() {
		return typeArgumentsID;
	}

}
