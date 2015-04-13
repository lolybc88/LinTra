package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ClassInstanceCreation extends AbstractMethodInvocation implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String anonymousClassDeclarationID;
	Boolean anonymousClassDeclarationIsComposed = true;

	String expressionID;
	Boolean expressionIsComposed = true;

	String typeID;
	Boolean typeIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ClassInstanceCreation() {
	}

	public ClassInstanceCreation(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String methodID, String[] argumentsID, String[] typeArgumentsID,
			String anonymousClassDeclarationID, String expressionID,
			String typeID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				methodID, argumentsID, typeArgumentsID);

		this.id = id;

		this.anonymousClassDeclarationID = anonymousClassDeclarationID;
		this.expressionID = expressionID;
		this.typeID = typeID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAnonymousClassDeclaration(String anonymousClassDeclarationID) {
		this.anonymousClassDeclarationID = anonymousClassDeclarationID;
	}

	public String getAnonymousClassDeclaration() {
		return anonymousClassDeclarationID;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

}
