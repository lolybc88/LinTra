/**
 */
package javaMM.impl;

import java.util.Collection;
import javaMM.AnnotationMemberValuePair;
import javaMM.AnnotationTypeMemberDeclaration;
import javaMM.Expression;
import javaMM.JavaMMPackage;
import javaMM.TypeAccess;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Type Member Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link javaMM.impl.AnnotationTypeMemberDeclarationImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link javaMM.impl.AnnotationTypeMemberDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link javaMM.impl.AnnotationTypeMemberDeclarationImpl#getUsages <em>Usages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationTypeMemberDeclarationImpl extends BodyDeclarationImpl implements AnnotationTypeMemberDeclaration {
	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected Expression default_;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeAccess type;

	/**
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationMemberValuePair> usages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationTypeMemberDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaMMPackage.Literals.ANNOTATION_TYPE_MEMBER_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefault(Expression newDefault, NotificationChain msgs) {
		Expression oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT, oldDefault, newDefault);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(Expression newDefault) {
		if (newDefault != default_) {
			NotificationChain msgs = null;
			if (default_ != null)
				msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT, null, msgs);
			if (newDefault != null)
				msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT, null, msgs);
			msgs = basicSetDefault(newDefault, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT, newDefault, newDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeAccess getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypeAccess newType, NotificationChain msgs) {
		TypeAccess oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeAccess newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationMemberValuePair> getUsages() {
		if (usages == null) {
			usages = new EObjectWithInverseResolvingEList<AnnotationMemberValuePair>(AnnotationMemberValuePair.class, this, JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__USAGES, JavaMMPackage.ANNOTATION_MEMBER_VALUE_PAIR__MEMBER);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__USAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsages()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT:
				return basicSetDefault(null, msgs);
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE:
				return basicSetType(null, msgs);
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__USAGES:
				return ((InternalEList<?>)getUsages()).basicRemove(otherEnd, msgs);
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
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT:
				return getDefault();
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE:
				return getType();
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__USAGES:
				return getUsages();
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
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT:
				setDefault((Expression)newValue);
				return;
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE:
				setType((TypeAccess)newValue);
				return;
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends AnnotationMemberValuePair>)newValue);
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
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT:
				setDefault((Expression)null);
				return;
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE:
				setType((TypeAccess)null);
				return;
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__USAGES:
				getUsages().clear();
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
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__DEFAULT:
				return default_ != null;
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__TYPE:
				return type != null;
			case JavaMMPackage.ANNOTATION_TYPE_MEMBER_DECLARATION__USAGES:
				return usages != null && !usages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationTypeMemberDeclarationImpl
