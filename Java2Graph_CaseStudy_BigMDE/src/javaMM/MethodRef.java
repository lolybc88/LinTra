/**
 */
package javaMM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javaMM.MethodRef#getMethod <em>Method</em>}</li>
 *   <li>{@link javaMM.MethodRef#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link javaMM.MethodRef#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see javaMM.JavaMMPackage#getMethodRef()
 * @model
 * @generated
 */
public interface MethodRef extends ASTNode {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link javaMM.AbstractMethodDeclaration#getUsagesInDocComments <em>Usages In Doc Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' reference.
	 * @see #setMethod(AbstractMethodDeclaration)
	 * @see javaMM.JavaMMPackage#getMethodRef_Method()
	 * @see javaMM.AbstractMethodDeclaration#getUsagesInDocComments
	 * @model opposite="usagesInDocComments" required="true" ordered="false"
	 * @generated
	 */
	AbstractMethodDeclaration getMethod();

	/**
	 * Sets the value of the '{@link javaMM.MethodRef#getMethod <em>Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(AbstractMethodDeclaration value);

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' containment reference.
	 * @see #setQualifier(TypeAccess)
	 * @see javaMM.JavaMMPackage#getMethodRef_Qualifier()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	TypeAccess getQualifier();

	/**
	 * Sets the value of the '{@link javaMM.MethodRef#getQualifier <em>Qualifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' containment reference.
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(TypeAccess value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link javaMM.MethodRefParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see javaMM.JavaMMPackage#getMethodRef_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodRefParameter> getParameters();

} // MethodRef
