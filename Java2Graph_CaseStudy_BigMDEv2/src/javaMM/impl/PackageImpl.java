/**
 */
package javaMM.impl;

import java.util.Collection;
import javaMM.AbstractTypeDeclaration;
import javaMM.JavaMMPackage;
import javaMM.Model;
import javaMM.PackageAccess;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link javaMM.impl.PackageImpl#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link javaMM.impl.PackageImpl#getModel <em>Model</em>}</li>
 *   <li>{@link javaMM.impl.PackageImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link javaMM.impl.PackageImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link javaMM.impl.PackageImpl#getUsagesInPackageAccess <em>Usages In Package Access</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends NamedElementImpl implements javaMM.Package {
	/**
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTypeDeclaration> ownedElements;

	/**
	 * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<javaMM.Package> ownedPackages;

	/**
	 * The cached value of the '{@link #getUsagesInPackageAccess() <em>Usages In Package Access</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsagesInPackageAccess()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageAccess> usagesInPackageAccess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaMMPackage.Literals.PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTypeDeclaration> getOwnedElements() {
		if (ownedElements == null) {
			ownedElements = new EObjectContainmentWithInverseEList<AbstractTypeDeclaration>(AbstractTypeDeclaration.class, this, JavaMMPackage.PACKAGE__OWNED_ELEMENTS, JavaMMPackage.ABSTRACT_TYPE_DECLARATION__PACKAGE);
		}
		return ownedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		if (eContainerFeatureID() != JavaMMPackage.PACKAGE__MODEL) return null;
		return (Model)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(Model newModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModel, JavaMMPackage.PACKAGE__MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Model newModel) {
		if (newModel != eInternalContainer() || (eContainerFeatureID() != JavaMMPackage.PACKAGE__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, JavaMMPackage.MODEL__OWNED_ELEMENTS, Model.class, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.PACKAGE__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<javaMM.Package> getOwnedPackages() {
		if (ownedPackages == null) {
			ownedPackages = new EObjectContainmentWithInverseEList<javaMM.Package>(javaMM.Package.class, this, JavaMMPackage.PACKAGE__OWNED_PACKAGES, JavaMMPackage.PACKAGE__PACKAGE);
		}
		return ownedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public javaMM.Package getPackage() {
		if (eContainerFeatureID() != JavaMMPackage.PACKAGE__PACKAGE) return null;
		return (javaMM.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackage(javaMM.Package newPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPackage, JavaMMPackage.PACKAGE__PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(javaMM.Package newPackage) {
		if (newPackage != eInternalContainer() || (eContainerFeatureID() != JavaMMPackage.PACKAGE__PACKAGE && newPackage != null)) {
			if (EcoreUtil.isAncestor(this, newPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackage != null)
				msgs = ((InternalEObject)newPackage).eInverseAdd(this, JavaMMPackage.PACKAGE__OWNED_PACKAGES, javaMM.Package.class, msgs);
			msgs = basicSetPackage(newPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaMMPackage.PACKAGE__PACKAGE, newPackage, newPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageAccess> getUsagesInPackageAccess() {
		if (usagesInPackageAccess == null) {
			usagesInPackageAccess = new EObjectWithInverseResolvingEList<PackageAccess>(PackageAccess.class, this, JavaMMPackage.PACKAGE__USAGES_IN_PACKAGE_ACCESS, JavaMMPackage.PACKAGE_ACCESS__PACKAGE);
		}
		return usagesInPackageAccess;
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
			case JavaMMPackage.PACKAGE__OWNED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElements()).basicAdd(otherEnd, msgs);
			case JavaMMPackage.PACKAGE__MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModel((Model)otherEnd, msgs);
			case JavaMMPackage.PACKAGE__OWNED_PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPackages()).basicAdd(otherEnd, msgs);
			case JavaMMPackage.PACKAGE__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((javaMM.Package)otherEnd, msgs);
			case JavaMMPackage.PACKAGE__USAGES_IN_PACKAGE_ACCESS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsagesInPackageAccess()).basicAdd(otherEnd, msgs);
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
			case JavaMMPackage.PACKAGE__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
			case JavaMMPackage.PACKAGE__MODEL:
				return basicSetModel(null, msgs);
			case JavaMMPackage.PACKAGE__OWNED_PACKAGES:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
			case JavaMMPackage.PACKAGE__PACKAGE:
				return basicSetPackage(null, msgs);
			case JavaMMPackage.PACKAGE__USAGES_IN_PACKAGE_ACCESS:
				return ((InternalEList<?>)getUsagesInPackageAccess()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JavaMMPackage.PACKAGE__MODEL:
				return eInternalContainer().eInverseRemove(this, JavaMMPackage.MODEL__OWNED_ELEMENTS, Model.class, msgs);
			case JavaMMPackage.PACKAGE__PACKAGE:
				return eInternalContainer().eInverseRemove(this, JavaMMPackage.PACKAGE__OWNED_PACKAGES, javaMM.Package.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaMMPackage.PACKAGE__OWNED_ELEMENTS:
				return getOwnedElements();
			case JavaMMPackage.PACKAGE__MODEL:
				return getModel();
			case JavaMMPackage.PACKAGE__OWNED_PACKAGES:
				return getOwnedPackages();
			case JavaMMPackage.PACKAGE__PACKAGE:
				return getPackage();
			case JavaMMPackage.PACKAGE__USAGES_IN_PACKAGE_ACCESS:
				return getUsagesInPackageAccess();
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
			case JavaMMPackage.PACKAGE__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends AbstractTypeDeclaration>)newValue);
				return;
			case JavaMMPackage.PACKAGE__MODEL:
				setModel((Model)newValue);
				return;
			case JavaMMPackage.PACKAGE__OWNED_PACKAGES:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends javaMM.Package>)newValue);
				return;
			case JavaMMPackage.PACKAGE__PACKAGE:
				setPackage((javaMM.Package)newValue);
				return;
			case JavaMMPackage.PACKAGE__USAGES_IN_PACKAGE_ACCESS:
				getUsagesInPackageAccess().clear();
				getUsagesInPackageAccess().addAll((Collection<? extends PackageAccess>)newValue);
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
			case JavaMMPackage.PACKAGE__OWNED_ELEMENTS:
				getOwnedElements().clear();
				return;
			case JavaMMPackage.PACKAGE__MODEL:
				setModel((Model)null);
				return;
			case JavaMMPackage.PACKAGE__OWNED_PACKAGES:
				getOwnedPackages().clear();
				return;
			case JavaMMPackage.PACKAGE__PACKAGE:
				setPackage((javaMM.Package)null);
				return;
			case JavaMMPackage.PACKAGE__USAGES_IN_PACKAGE_ACCESS:
				getUsagesInPackageAccess().clear();
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
			case JavaMMPackage.PACKAGE__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
			case JavaMMPackage.PACKAGE__MODEL:
				return getModel() != null;
			case JavaMMPackage.PACKAGE__OWNED_PACKAGES:
				return ownedPackages != null && !ownedPackages.isEmpty();
			case JavaMMPackage.PACKAGE__PACKAGE:
				return getPackage() != null;
			case JavaMMPackage.PACKAGE__USAGES_IN_PACKAGE_ACCESS:
				return usagesInPackageAccess != null && !usagesInPackageAccess.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PackageImpl
