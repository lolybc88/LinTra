/**
 */
package javaMM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javaMM.TagElement#getTagName <em>Tag Name</em>}</li>
 *   <li>{@link javaMM.TagElement#getFragments <em>Fragments</em>}</li>
 * </ul>
 * </p>
 *
 * @see javaMM.JavaMMPackage#getTagElement()
 * @model
 * @generated
 */
public interface TagElement extends ASTNode {
	/**
	 * Returns the value of the '<em><b>Tag Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Name</em>' attribute.
	 * @see #setTagName(String)
	 * @see javaMM.JavaMMPackage#getTagElement_TagName()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getTagName();

	/**
	 * Sets the value of the '{@link javaMM.TagElement#getTagName <em>Tag Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Name</em>' attribute.
	 * @see #getTagName()
	 * @generated
	 */
	void setTagName(String value);

	/**
	 * Returns the value of the '<em><b>Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link javaMM.ASTNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments</em>' containment reference list.
	 * @see javaMM.JavaMMPackage#getTagElement_Fragments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ASTNode> getFragments();

} // TagElement
