package javaMMinJava;

import blackboard.IdentifiableElement;

import java.io.Serializable;

public class VariableDeclarationStatement extends Statement implements
		Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	int extraArrayDimensions;

	Modifier modifier;
	Boolean modifierIsComposed = true;

	Annotation annotations;
	Boolean annotationsIsComposed = true;
	
	TypeAccess type;
	Boolean typeIsComposed = true;

	VariableDeclarationFragment fragments;
	Boolean fragmentsIsComposed = true;


	public VariableDeclarationStatement() {
	}

	public VariableDeclarationStatement(String id, int extraArrayDimensions,
			Comment comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, TypeAccess type,
			VariableDeclarationFragment fragments, Modifier modifier,
			Annotation annotations) {

		super(comments, originalCompilationUnit, originalClassFile);

		this.id = id;

		this.extraArrayDimensions = extraArrayDimensions;

		this.modifier = modifier;
		this.annotations = annotations;
		this.type = type;
		this.fragments = fragments;
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

	public void setExtraArrayDimensions(int extraArrayDimensions) {
		this.extraArrayDimensions = extraArrayDimensions;
	}

	public int getExtraArrayDimensions() {
		return extraArrayDimensions;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public Modifier getModifier() {
		return modifier;
	}

	public void setAnnotations(Annotation annotations) {
		this.annotations = annotations;
	}

	public Annotation getAnnotations() {
		return annotations;
	}
	
	public void setType(TypeAccess type) {
		this.type = type;
	}

	public TypeAccess getType() {
		return type;
	}

	public void setFragments(VariableDeclarationFragment fragments) {
		this.fragments = fragments;
	}

	public VariableDeclarationFragment getFragments() {
		return fragments;
	}

}
