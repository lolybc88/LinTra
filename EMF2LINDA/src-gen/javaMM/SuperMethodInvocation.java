package javaMM;

import java.io.Serializable;

public class SuperMethodInvocation extends AbstractMethodInvocation implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;
	
	String qualifierID;
	Boolean qualifierIsComposed = true;

	public SuperMethodInvocation() {
	}

	public SuperMethodInvocation(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String qualifierID, String methodID, String[] argumentsID,
			String[] typeArgumentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				methodID, argumentsID, typeArgumentsID);

		this.id = id;
		this.qualifierID = qualifierID;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
