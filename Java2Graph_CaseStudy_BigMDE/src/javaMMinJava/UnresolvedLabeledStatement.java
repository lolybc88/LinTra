package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class UnresolvedLabeledStatement extends LabeledStatement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public UnresolvedLabeledStatement() {
	}

	public UnresolvedLabeledStatement(String id, String name, Boolean proxy,
			Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			Statement body, BreakStatement[] usagesInBreakStatements,
			ContinueStatement[] usagesInContinueStatements) {

		super(id,name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, body,
				usagesInBreakStatements, usagesInContinueStatements);

		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

}
