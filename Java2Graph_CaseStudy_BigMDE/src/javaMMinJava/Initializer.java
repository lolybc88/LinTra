package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Initializer extends BodyDeclaration
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Block body;
	Boolean bodyIsComposed = true;

	public Initializer() {
	}

	public Initializer(String id, String name, Boolean proxy, Comment comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, Block body) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier);

		this.id = id;

		this.body = body;
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

	public void setBody(Block body) {
		this.body = body;
	}

	public Block getBody() {
		return body;
	}

}
