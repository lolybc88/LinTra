package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class LabeledStatement extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Statement body;
	Boolean bodyIsComposed = true;

	BreakStatement usagesInBreakStatements;
	Boolean usagesInBreakStatementsIsComposed = false;

	ContinueStatement usagesInContinueStatements;
	Boolean usagesInContinueStatementsIsComposed = false;

	public LabeledStatement() {
	}

	public LabeledStatement(String id, String name, Boolean proxy,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			Statement body, BreakStatement usagesInBreakStatements,
			ContinueStatement usagesInContinueStatements) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports);

		this.id = id;

		this.body = body;
		this.usagesInBreakStatements = usagesInBreakStatements;
		this.usagesInContinueStatements = usagesInContinueStatements;
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

	public void setBody(Statement body) {
		this.body = body;
	}

	public Statement getBody() {
		return body;
	}

	public void setUsagesInBreakStatements(
			BreakStatement usagesInBreakStatements) {
		this.usagesInBreakStatements = usagesInBreakStatements;
	}

	public BreakStatement getUsagesInBreakStatements() {
		return usagesInBreakStatements;
	}

	public void setUsagesInContinueStatements(
			ContinueStatement usagesInContinueStatements) {
		this.usagesInContinueStatements = usagesInContinueStatements;
	}

	public ContinueStatement getUsagesInContinueStatements() {
		return usagesInContinueStatements;
	}

}
