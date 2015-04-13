/**
 */
package javaMM.impl;

import java.util.Collection;
import javaMM.JavaMMPackage;
import javaMM.Manifest;
import javaMM.ManifestAttribute;
import javaMM.ManifestEntry;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link javaMM.impl.ManifestImpl#getMainAttributes <em>Main Attributes</em>}</li>
 *   <li>{@link javaMM.impl.ManifestImpl#getEntryAttributes <em>Entry Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManifestImpl extends MinimalEObjectImpl.Container implements Manifest {
	/**
	 * The cached value of the '{@link #getMainAttributes() <em>Main Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ManifestAttribute> mainAttributes;

	/**
	 * The cached value of the '{@link #getEntryAttributes() <em>Entry Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ManifestEntry> entryAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManifestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaMMPackage.Literals.MANIFEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ManifestAttribute> getMainAttributes() {
		if (mainAttributes == null) {
			mainAttributes = new EObjectContainmentEList<ManifestAttribute>(ManifestAttribute.class, this, JavaMMPackage.MANIFEST__MAIN_ATTRIBUTES);
		}
		return mainAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ManifestEntry> getEntryAttributes() {
		if (entryAttributes == null) {
			entryAttributes = new EObjectContainmentEList<ManifestEntry>(ManifestEntry.class, this, JavaMMPackage.MANIFEST__ENTRY_ATTRIBUTES);
		}
		return entryAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavaMMPackage.MANIFEST__MAIN_ATTRIBUTES:
				return ((InternalEList<?>)getMainAttributes()).basicRemove(otherEnd, msgs);
			case JavaMMPackage.MANIFEST__ENTRY_ATTRIBUTES:
				return ((InternalEList<?>)getEntryAttributes()).basicRemove(otherEnd, msgs);
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
			case JavaMMPackage.MANIFEST__MAIN_ATTRIBUTES:
				return getMainAttributes();
			case JavaMMPackage.MANIFEST__ENTRY_ATTRIBUTES:
				return getEntryAttributes();
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
			case JavaMMPackage.MANIFEST__MAIN_ATTRIBUTES:
				getMainAttributes().clear();
				getMainAttributes().addAll((Collection<? extends ManifestAttribute>)newValue);
				return;
			case JavaMMPackage.MANIFEST__ENTRY_ATTRIBUTES:
				getEntryAttributes().clear();
				getEntryAttributes().addAll((Collection<? extends ManifestEntry>)newValue);
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
			case JavaMMPackage.MANIFEST__MAIN_ATTRIBUTES:
				getMainAttributes().clear();
				return;
			case JavaMMPackage.MANIFEST__ENTRY_ATTRIBUTES:
				getEntryAttributes().clear();
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
			case JavaMMPackage.MANIFEST__MAIN_ATTRIBUTES:
				return mainAttributes != null && !mainAttributes.isEmpty();
			case JavaMMPackage.MANIFEST__ENTRY_ATTRIBUTES:
				return entryAttributes != null && !entryAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ManifestImpl
