package javaMM;

import java.io.Serializable;

public class SwitchCase extends Statement implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	Boolean default_;

	String expressionID;
	Boolean expressionIsComposed = true;

	public SwitchCase() {
	}

	public SwitchCase(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			Boolean default_, String expressionID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.default_ = default_;

		this.expressionID = expressionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDefault(Boolean default_) {
		this.default_ = default_;
	}

	public Boolean getDefault() {
		return default_;
	}

	public void setExpression(String expressionID) {
		this.expressionID = expressionID;
	}

	public String getExpression() {
		return expressionID;
	}

}
