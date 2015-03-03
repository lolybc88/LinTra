package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ThisExpression extends AbstractTypeQualifiedExpression
		implements
			Serializable, IdentifiableElement {

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

	public ThisExpression() {
	}

	public ThisExpression(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				qualifierID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
