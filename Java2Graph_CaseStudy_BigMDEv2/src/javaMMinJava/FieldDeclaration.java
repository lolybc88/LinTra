package javaMMinJava;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import blackboard.IdentifiableElement;

public class FieldDeclaration extends BodyDeclaration implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id;
	
	String typeID;
	TypeAccess type;
	Boolean typeIsComposed = true;
	
	
	String[] fragmentsID; Boolean fragmentsIsComposed = true;
	
	String trgId;
	
	@Override
	public String getTrgId() {
		return trgId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public FieldDeclaration(String id, String[] commentsID,
			String originalCompilationUnitID, String originalClassFileID,
			String name, Boolean proxy, String[] usagesInImportsID,
			String abstractTypeDeclarationID, AbstractTypeDeclaration abstractTypeDeclaration, String[] annotationsID,
			String anonymousClassDeclarationOwnerID, String modifierID, Modifier modifier,
			String typeID, TypeAccess type, String[] fragmentsID) {
		super(commentsID, originalCompilationUnitID, originalClassFileID, name,
				proxy, usagesInImportsID, abstractTypeDeclarationID, abstractTypeDeclaration,
				annotationsID, anonymousClassDeclarationOwnerID, modifierID, modifier);

		this.id = id;
		this.typeID = typeID;
		this.type = type;
		this.fragmentsID = fragmentsID;

	}

	public FieldDeclaration(String string, EList<EObject> eList,
			Map<EObject, String> map, String string2, String string3,
			String name, boolean proxy, String[] ids, String string4,
			String[] ids2, String string5, String string6,
			Modifier transformEMF2Java, String string7,
			TypeAccess transformEMF2Java2, String[] ids3) {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public synchronized String getTypeID() {
		return typeID;
	}

	public synchronized void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public TypeAccess getType() {
		return type;
	}

	public void setType(TypeAccess type) {
		this.type = type;
	}

	public synchronized String[] getFragmentsID() {
		return fragmentsID;
	}

	public synchronized void setFragmentsID(String[] fragmentsID) {
		this.fragmentsID = fragmentsID;
	}

}
