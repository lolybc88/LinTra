package javaMM;

import java.io.Serializable;

public class NullLiteral extends Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	public NullLiteral() {
	}

	public NullLiteral(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
