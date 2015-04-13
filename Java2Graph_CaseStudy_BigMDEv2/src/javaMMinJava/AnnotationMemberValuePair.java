package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class AnnotationMemberValuePair extends NamedElement
		implements
			Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String memberID;
	Boolean memberIsComposed = false;

	String valueID;
	Boolean valueIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public AnnotationMemberValuePair() {
	}

	public AnnotationMemberValuePair(String id, String[] commentsID, 
			String originalCompilationUnitID, 
			String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String memberID, String valueID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID,
				name, proxy, usagesInImportsID);

		this.id = id;

		this.memberID = memberID;
		this.valueID = valueID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMember(String memberID) {
		this.memberID = memberID;
	}

	public String getMember() {
		return memberID;
	}

	public void setValue(String valueID) {
		this.valueID = valueID;
	}

	public String getValue() {
		return valueID;
	}

}
