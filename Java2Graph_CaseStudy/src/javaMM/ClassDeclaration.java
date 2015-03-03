/**
 */
package javaMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javaMM.ClassDeclaration#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see javaMM.JavaMMPackage#getClassDeclaration()
 * @model
 * @generated
 */
public interface ClassDeclaration extends TypeDeclaration {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' containment reference.
	 * @see #setSuperClass(TypeAccess)
	 * @see javaMM.JavaMMPackage#getClassDeclaration_SuperClass()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	TypeAccess getSuperClass();

	/**
	 * Sets the value of the '{@link javaMM.ClassDeclaration#getSuperClass <em>Super Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' containment reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(TypeAccess value);

} // ClassDeclaration
