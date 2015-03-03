package javaMM;

import java.io.Serializable;

public class ConstructorInvocation extends AbstractMethodInvocation implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public ConstructorInvocation() {
	}

	public ConstructorInvocation(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String methodID, String[] argumentsID, String[] typeArgumentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				methodID, argumentsID, typeArgumentsID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
