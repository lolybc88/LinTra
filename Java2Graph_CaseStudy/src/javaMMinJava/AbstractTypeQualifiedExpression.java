package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class AbstractTypeQualifiedExpression extends Expression
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String qualifierID;
	Boolean qualifierIsComposed = true;

	public AbstractTypeQualifiedExpression() {
	}

	public AbstractTypeQualifiedExpression(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.qualifierID = qualifierID;
	}

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

}
