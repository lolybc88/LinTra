/**
 */
package javaMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Break Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javaMM.BreakStatement#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see javaMM.JavaMMPackage#getBreakStatement()
 * @model
 * @generated
 */
public interface BreakStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link javaMM.LabeledStatement#getUsagesInBreakStatements <em>Usages In Break Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference.
	 * @see #setLabel(LabeledStatement)
	 * @see javaMM.JavaMMPackage#getBreakStatement_Label()
	 * @see javaMM.LabeledStatement#getUsagesInBreakStatements
	 * @model opposite="usagesInBreakStatements" ordered="false"
	 * @generated
	 */
	LabeledStatement getLabel();

	/**
	 * Sets the value of the '{@link javaMM.BreakStatement#getLabel <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(LabeledStatement value);

} // BreakStatement
