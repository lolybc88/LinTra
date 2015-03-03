package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ConstructorInvocation extends AbstractMethodInvocation implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

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
