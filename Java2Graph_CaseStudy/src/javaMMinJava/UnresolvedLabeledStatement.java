package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class UnresolvedLabeledStatement extends LabeledStatement
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	public UnresolvedLabeledStatement() {
	}

	public UnresolvedLabeledStatement(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String bodyID, String[] usagesInBreakStatementsID,
			String[] usagesInContinueStatementsID) {
		super(id, commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, bodyID, usagesInBreakStatementsID,
				usagesInContinueStatementsID);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
