package javaMMinJava;

import java.io.Serializable;

import blackboard.IdentifiableElement;

public class EnumConstantDeclaration extends BodyDeclaration implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;

	String anonymousClassDeclarationID;
	Boolean anonymousClassDeclarationIsComposed = true;

	String[] argumentsID;
	Boolean argumentsIsComposed = true;
	
	int extraArrayDimensions;
	String initializerID; Boolean initializerIsComposed = true;
	String[] usageInVariableAccessID; Boolean usageInVariableAccessIsComposed = false;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public EnumConstantDeclaration() { }

	public EnumConstantDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID,
			int extraArrayDimensions, String initializerID,
			String[] usageInVariableAccessID,
			String anonymousClassDeclarationID, String[] argumentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID);

		this.id = id;

		this.anonymousClassDeclarationID = anonymousClassDeclarationID;
		this.argumentsID = argumentsID;
		
		this.extraArrayDimensions = extraArrayDimensions;
		this.initializerID = initializerID;
		this.usageInVariableAccessID = usageInVariableAccessID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAnonymousClassDeclaration(String anonymousClassDeclarationID) {
		this.anonymousClassDeclarationID = anonymousClassDeclarationID;
	}

	public String getAnonymousClassDeclaration() {
		return anonymousClassDeclarationID;
	}

	public void setArguments(String[] argumentsID) {
		this.argumentsID = argumentsID;
	}

	public String[] getArguments() {
		return argumentsID;
	}

	public String getInitializer() {
		return initializerID;
	}

	public int getExtraArrayDimensions() {
		return extraArrayDimensions;
	}

	public String[] getUsageInVariableAccess() {
		return usageInVariableAccessID;
	}

}
