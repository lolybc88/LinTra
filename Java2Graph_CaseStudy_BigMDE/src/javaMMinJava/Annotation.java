package javaMMinJava;

import blackboard.IdentifiableElement;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;

public class Annotation extends Expression implements Serializable,
		IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	TypeAccess type;
	Boolean typeIsComposed = true;

	AnnotationMemberValuePair[] values;
	Boolean valuesIsComposed = true;

	public Annotation(String id, Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, TypeAccess type,
			AnnotationMemberValuePair[] values) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.type = type;
		this.values = values;
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

	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

	public void setValues(AnnotationMemberValuePair[] values) {
		this.values = values;
	}

	public AnnotationMemberValuePair[] getValues() {
		return values;
	}

}
	