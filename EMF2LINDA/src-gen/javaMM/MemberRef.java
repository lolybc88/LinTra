package javaMM;

import java.io.Serializable;

public class MemberRef extends ASTNode implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;

	String memberID;
	Boolean memberIsComposed = false;

	String qualifierID;
	Boolean qualifierIsComposed = true;

	public MemberRef() {
	}

	public MemberRef(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String memberID, String qualifierID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID);

		this.id = id;

		this.memberID = memberID;
		this.qualifierID = qualifierID;
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

	public void setQualifier(String qualifierID) {
		this.qualifierID = qualifierID;
	}

	public String getQualifier() {
		return qualifierID;
	}

}
