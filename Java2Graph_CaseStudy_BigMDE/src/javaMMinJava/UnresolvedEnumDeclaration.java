package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class UnresolvedEnumDeclaration extends EnumDeclaration implements
		Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public UnresolvedEnumDeclaration() {
	}

	public UnresolvedEnumDeclaration(String id, String name, Boolean proxy,
			Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation[] annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, TypeAccess[] usagesInTypeAccess,
			BodyDeclaration[] bodyDeclarations, Comment[] commentsBeforeBody,
			Comment[] commentsAfterBody, Package package_,
			TypeAccess[] superInterfaces, EnumConstantDeclaration[] enumConstants) {

		super(id, name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier,
				usagesInTypeAccess, bodyDeclarations, commentsBeforeBody,
				commentsAfterBody, package_, superInterfaces, enumConstants);

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