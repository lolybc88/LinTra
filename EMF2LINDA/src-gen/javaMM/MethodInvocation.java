package javaMM;

import java.io.Serializable;

public class MethodInvocation extends AbstractMethodInvocation implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;

	public MethodInvocation() {
	}

	public MethodInvocation(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String methodID, String[] argumentsID, String[] typeArgumentsID,
			String expressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				methodID, argumentsID, typeArgumentsID);

		this.id = id;

		this.expressionID = expressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

}
