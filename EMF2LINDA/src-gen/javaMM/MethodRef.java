package javaMM;

import java.io.Serializable;

public class MethodRef extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String methodID;
	Boolean methodIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;

	String[] parametersID;
	Boolean parametersIsComposed = true;

	public MethodRef() {
	}

	public MethodRef(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String methodID, String qualifierID, String[] parametersID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.methodID = methodID;
		this.qualifierID = qualifierID;
		this.parametersID = parametersID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMethod(String methodID) {
		this.methodID = methodID;
	}

	public String getMethod() {
		return methodID;
	}

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

	public void setParameters(String[] parametersID) {
		this.parametersID = parametersID;
	}

	public String[] getParameters() {
		return parametersID;
	}

}