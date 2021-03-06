/**
 */
package DBLP;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Journal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DBLP.Journal#getName <em>Name</em>}</li>
 *   <li>{@link DBLP.Journal#getArticles <em>Articles</em>}</li>
 * </ul>
 * </p>
 *
 * @see DBLP.DBLPPackage#getJournal()
 * @model
 * @generated
 */
public interface Journal extends EObject {
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
	 * @see DBLP.DBLPPackage#getJournal_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link DBLP.Journal#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Articles</b></em>' reference list.
	 * The list contents are of type {@link DBLP.Article}.
	 * It is bidirectional and its opposite is '{@link DBLP.Article#getJournal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Articles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Articles</em>' reference list.
	 * @see DBLP.DBLPPackage#getJournal_Articles()
	 * @see DBLP.Article#getJournal
	 * @model opposite="journal"
	 * @generated
	 */
	EList<Article> getArticles();

} // Journal
