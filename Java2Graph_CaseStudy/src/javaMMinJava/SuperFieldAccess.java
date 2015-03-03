package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class SuperFieldAccess extends AbstractTypeQualifiedExpression
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String fieldID;
	Boolean fieldIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public SuperFieldAccess() {
	}

	public SuperFieldAccess(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String qualifierID, String fieldID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				qualifierID);

		this.id = id;

		this.fieldID = fieldID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setField(String fieldID) {
		this.fieldID = fieldID;
	}

	public String getField() {
		return fieldID;
	}

}
