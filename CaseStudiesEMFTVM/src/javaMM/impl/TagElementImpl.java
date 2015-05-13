/**
 */
package javaMM.impl;

import java.util.Collection;
import javaMM.ASTNode;
import javaMM.JavaMMPackage;
import javaMM.TagElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link javaMM.impl.TagElementImpl#getTagName <em>Tag Name</em>}</li>
 *   <li>{@link javaMM.impl.TagElementImpl#getFragments <em>Fragments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TagElementImpl extends ASTNodeImpl implements TagElement {
	/**
	 * The default value of the '{@link #getTagName() <em>Tag Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagName()
	 * @generated
	 * @ordered
	 */
	protected static final String TAG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTagName() <em>Tag Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagName()
	 * @generated
	 * @ordered
	 */
	protected String tagName = TAG_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFragments() <em>Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<ASTNode> fragments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TagElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaMMPackage.Literals.TAG_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTagName(String newTagName) {
		String oldTagName = tagName;
		tagName = newTagName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.TAG_ELEMENT__TAG_NAME, oldTagName, tagName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ASTNode> getFragments() {
		if (fragments == null) {
			fragments = new EObjectContainmentEList<ASTNode>(ASTNode.class, this, JavaMMPackage.TAG_ELEMENT__FRAGMENTS);
		}
		return fragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavaMMPackage.TAG_ELEMENT__FRAGMENTS:
				return ((InternalEList<?>)getFragments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaMMPackage.TAG_ELEMENT__TAG_NAME:
				return getTagName();
			case JavaMMPackage.TAG_ELEMENT__FRAGMENTS:
				return getFragments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaMMPackage.TAG_ELEMENT__TAG_NAME:
				setTagName((String)newValue);
				return;
			case JavaMMPackage.TAG_ELEMENT__FRAGMENTS:
				getFragments().clear();
				getFragments().addAll((Collection<? extends ASTNode>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JavaMMPackage.TAG_ELEMENT__TAG_NAME:
				setTagName(TAG_NAME_EDEFAULT);
				return;
			case JavaMMPackage.TAG_ELEMENT__FRAGMENTS:
				getFragments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JavaMMPackage.TAG_ELEMENT__TAG_NAME:
				return TAG_NAME_EDEFAULT == null ? tagName != null : !TAG_NAME_EDEFAULT.equals(tagName);
			case JavaMMPackage.TAG_ELEMENT__FRAGMENTS:
				return fragments != null && !fragments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tagName: ");
		result.append(tagName);
		result.append(')');
		return result.toString();
	}

} //TagElementImpl
