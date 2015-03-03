/**
 */
package ICMTAuthor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ICMTAuthor.Author#getName <em>Name</em>}</li>
 *   <li>{@link ICMTAuthor.Author#getNumOfPapers <em>Num Of Papers</em>}</li>
 *   <li>{@link ICMTAuthor.Author#isActive <em>Active</em>}</li>
 *   <li>{@link ICMTAuthor.Author#getPublishesIn <em>Publishes In</em>}</li>
 *   <li>{@link ICMTAuthor.Author#getCoauthor <em>Coauthor</em>}</li>
 * </ul>
 * </p>
 *
 * @see ICMTAuthor.ICMTAuthorPackage#getAuthor()
 * @model
 * @generated
 */
public interface Author extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ICMTAuthor.ICMTAuthorPackage#getAuthor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ICMTAuthor.Author#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Num Of Papers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Papers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Papers</em>' attribute.
	 * @see #setNumOfPapers(int)
	 * @see ICMTAuthor.ICMTAuthorPackage#getAuthor_NumOfPapers()
	 * @model
	 * @generated
	 */
	int getNumOfPapers();

	/**
	 * Sets the value of the '{@link ICMTAuthor.Author#getNumOfPapers <em>Num Of Papers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Of Papers</em>' attribute.
	 * @see #getNumOfPapers()
	 * @generated
	 */
	void setNumOfPapers(int value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see ICMTAuthor.ICMTAuthorPackage#getAuthor_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link ICMTAuthor.Author#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Publishes In</b></em>' reference list.
	 * The list contents are of type {@link ICMTAuthor.Conference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publishes In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publishes In</em>' reference list.
	 * @see ICMTAuthor.ICMTAuthorPackage#getAuthor_PublishesIn()
	 * @model
	 * @generated
	 */
	EList<Conference> getPublishesIn();

	/**
	 * Returns the value of the '<em><b>Coauthor</b></em>' reference list.
	 * The list contents are of type {@link ICMTAuthor.Author}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coauthor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coauthor</em>' reference list.
	 * @see ICMTAuthor.ICMTAuthorPackage#getAuthor_Coauthor()
	 * @model
	 * @generated
	 */
	EList<Author> getCoauthor();

} // Author
