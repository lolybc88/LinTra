package javaMMinJava;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class AnnotationMemberValuePair extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	AnnotationTypeMemberDeclaration member;
	Boolean memberIsComposed = false;

	Expression value;
	Boolean valueIsComposed = true;

	public AnnotationMemberValuePair() {
	}

	public AnnotationMemberValuePair(String id, String name, Boolean proxy,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, ImportDeclaration usagesInImports,
			AnnotationTypeMemberDeclaration member, Expression value) {

		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports);

		this.id = id;

		this.member = member;
		this.value = value;
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

	public void setMember(AnnotationTypeMemberDeclaration member) {
		this.member = member;
	}

	public AnnotationTypeMemberDeclaration getMember() {
		return member;
	}

	public void setValue(Expression value) {
		this.value = value;
	}

	public Expression getValue() {
		return value;
	}

}
