package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class AnonymousClassDeclaration extends ASTNode implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	BodyDeclaration[] bodyDeclarations;
	Boolean bodyDeclarationsIsComposed = true;

	ClassInstanceCreation classInstanceCreation;
	Boolean classInstanceCreationIsComposed = false;

	public AnonymousClassDeclaration() {
	}

	public AnonymousClassDeclaration(String id,

	Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, BodyDeclaration[] bodyDeclarations,
			ClassInstanceCreation classInstanceCreation) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.bodyDeclarations = bodyDeclarations;
		this.classInstanceCreation = classInstanceCreation;
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

	public void setBodyDeclarations(BodyDeclaration[] bodyDeclarations) {
		this.bodyDeclarations = bodyDeclarations;
	}

	public BodyDeclaration[] getBodyDeclarations() {
		return bodyDeclarations;
	}

	public void setClassInstanceCreation(
			ClassInstanceCreation classInstanceCreation) {
		this.classInstanceCreation = classInstanceCreation;
	}

	public ClassInstanceCreation getClassInstanceCreation() {
		return classInstanceCreation;
	}

}
	