package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public abstract class BodyDeclaration extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	AbstractTypeDeclaration abstractTypeDeclaration;
	Boolean abstractTypeDeclarationIsComposed = false;

	Annotation annotations;
	Boolean annotationsIsComposed = true;

	AnonymousClassDeclaration anonymousClassDeclarationOwner;
	Boolean anonymousClassDeclarationOwnerIsComposed = false;

	Modifier modifier;
	Boolean modifierIsComposed = true;

	public BodyDeclaration() {
	}

	public BodyDeclaration(String name, Boolean proxy, Comment comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports);

		this.abstractTypeDeclaration = abstractTypeDeclaration;
		this.annotations = annotations;
		this.anonymousClassDeclarationOwner = anonymousClassDeclarationOwner;
		this.modifier = modifier;
	}

	public void setAbstractTypeDeclaration(
			AbstractTypeDeclaration abstractTypeDeclaration) {
		this.abstractTypeDeclaration = abstractTypeDeclaration;
	}

	public AbstractTypeDeclaration getAbstractTypeDeclaration() {
		return abstractTypeDeclaration;
	}

	public void setAnnotations(Annotation annotations) {
		this.annotations = annotations;
	}

	public Annotation getAnnotations() {
		return annotations;
	}

	public void setAnonymousClassDeclarationOwner(
			AnonymousClassDeclaration anonymousClassDeclarationOwner) {
		this.anonymousClassDeclarationOwner = anonymousClassDeclarationOwner;
	}

	public AnonymousClassDeclaration getAnonymousClassDeclarationOwner() {
		return anonymousClassDeclarationOwner;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public Modifier getModifier() {
		return modifier;
	}

}
