package javaMM;

import java.io.Serializable;

public class CastExpression extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String expressionID;
	Boolean expressionIsComposed = true;

	String typeID;
	Boolean typeIsComposed = true;

	public CastExpression() {
	}

	public CastExpression(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String expressionID, String typeID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.expressionID = expressionID;
		this.typeID = typeID;
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

	public void setType(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return typeID;
	}

}
