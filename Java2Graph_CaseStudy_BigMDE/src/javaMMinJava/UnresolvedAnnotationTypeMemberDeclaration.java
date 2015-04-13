package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class UnresolvedAnnotationTypeMemberDeclaration extends
		AnnotationTypeMemberDeclaration implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public UnresolvedAnnotationTypeMemberDeclaration(String id, String name,
			Boolean proxy, Comment[] comments,
			CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration[] usagesInImports,
			AbstractTypeDeclaration abstractTypeDeclaration,
			Annotation[] annotations,
			AnonymousClassDeclaration anonymousClassDeclarationOwner,
			Modifier modifier, Expression default_, TypeAccess type,
			AnnotationMemberValuePair[] usages) {

		super(id, name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier,
				default_, type, usages);

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
