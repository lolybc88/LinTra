package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class Expression extends ASTNode implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	public Expression() {
	}

	public Expression(

	Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile) {

		super(comments, originalCompilationUnit, originalClassFile);

	}
			
			
			
			
			
		}
	