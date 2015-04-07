package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class Statement extends ASTNode implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	public Statement() {
	}

	public Statement(Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile) {

		super(comments, originalCompilationUnit, originalClassFile);

	}

}
	