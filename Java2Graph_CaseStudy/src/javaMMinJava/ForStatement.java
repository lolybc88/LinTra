package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class ForStatement extends Statement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;

	String[] updatersID;
	Boolean updatersIsComposed = true;

	String[] initializersID;
	Boolean initializersIsComposed = true;

	String bodyID;
	Boolean bodyIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public ForStatement() {
	}

	public ForStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String expressionID, String[] updatersID, String[] initializersID,
			String bodyID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.expressionID = expressionID;
		this.updatersID = updatersID;
		this.initializersID = initializersID;
		this.bodyID = bodyID;
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

	public void setUpdaters(String[] updatersID) {
		this.updatersID = updatersID;
	}

	public String[] getUpdaters() {
		return updatersID;
	}

	public void setInitializers(String[] initializersID) {
		this.initializersID = initializersID;
	}

	public String[] getInitializers() {
		return initializersID;
	}

	public void setBody(String bodyID) {
		this.bodyID = bodyID;
	}

	public String getBody() {
		return bodyID;
	}

}
