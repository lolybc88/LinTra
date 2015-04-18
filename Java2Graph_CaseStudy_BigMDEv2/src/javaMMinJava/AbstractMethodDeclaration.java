package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public abstract class AbstractMethodDeclaration extends BodyDeclaration
		implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String bodyID;
	Boolean bodyIsComposed = true;

	String[] parametersID;
	Boolean parametersIsComposed = true;

	String[] thrownExceptionsID;
	Boolean thrownExceptionsIsComposed = true;

	String[] typeParametersID;
	Boolean typeParametersIsComposed = true;

	String[] usagesInDocCommentsID;
	Boolean usagesInDocCommentsIsComposed = false;

	String[] usagesID;
	Boolean usagesIsComposed = false;

	public AbstractMethodDeclaration() {
	}

	public AbstractMethodDeclaration(String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, AbstractTypeDeclaration abstractTypeDeclaration, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier,
			String bodyID, String[] parametersID, String[] thrownExceptionsID,
			String[] typeParametersID, String[] usagesInDocCommentsID,
			String[] usagesID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID, abstractTypeDeclaration,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier);

		this.bodyID = bodyID;
		this.parametersID = parametersID;
		this.thrownExceptionsID = thrownExceptionsID;
		this.typeParametersID = typeParametersID;
		this.usagesInDocCommentsID = usagesInDocCommentsID;
		this.usagesID = usagesID;
	}

	public void setBody(String bodyID) {
		this.bodyID = bodyID;
	}

	public String getBody() {
		return bodyID;
	}

	public void setParameters(String[] parametersID) {
		this.parametersID = parametersID;
	}

	public String[] getParameters() {
		return parametersID;
	}

	public void setThrownExceptions(String[] thrownExceptionsID) {
		this.thrownExceptionsID = thrownExceptionsID;
	}

	public String[] getThrownExceptions() {
		return thrownExceptionsID;
	}

	public void setTypeParameters(String[] typeParametersID) {
		this.typeParametersID = typeParametersID;
	}

	public String[] getTypeParameters() {
		return typeParametersID;
	}

	public void setUsagesInDocComments(String[] usagesInDocCommentsID) {
		this.usagesInDocCommentsID = usagesInDocCommentsID;
	}

	public String[] getUsagesInDocComments() {
		return usagesInDocCommentsID;
	}

	public void setUsages(String[] usagesID) {
		this.usagesID = usagesID;
	}

	public String[] getUsages() {
		return usagesID;
	}

}
