package javaMM;

import java.io.Serializable;

public class ThisExpression extends AbstractTypeQualifiedExpression
		implements
			Serializable {

	private static final long serialVersionUID = 1L;

	String id;

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
