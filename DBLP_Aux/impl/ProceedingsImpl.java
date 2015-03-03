/**
 */
package DBLP.impl;

import DBLP.DBLPPackage;
import DBLP.Editor;
import DBLP.Organization;
import DBLP.Proceedings;
import DBLP.Publisher;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proceedings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DBLP.impl.ProceedingsImpl#getTitile <em>Titile</em>}</li>
 *   <li>{@link DBLP.impl.ProceedingsImpl#getYear <em>Year</em>}</li>
 *   <li>{@link DBLP.impl.ProceedingsImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link DBLP.impl.ProceedingsImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link DBLP.impl.ProceedingsImpl#getSponsoredBy <em>Sponsored By</em>}</li>
 *   <li>{@link DBLP.impl.ProceedingsImpl#getMonth <em>Month</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProceedingsImpl extends RecordImpl implements Proceedings {
	/**
	 * The default value of the '{@link #getTitile() <em>Titile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitile()
	 * @generated
	 * @ordered
	 */
	protected static final String TITILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitile() <em>Titile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitile()
	 * @generated
	 * @ordered
	 */
	protected String titile = TITILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected static final String YEAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected String year = YEAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<Editor> editors;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected Publisher publisher;

	/**
	 * The cached value of the '{@link #getSponsoredBy() <em>Sponsored By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSponsoredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Organization> sponsoredBy;

	/**
	 * The default value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected static final int MONTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected int month = MONTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProceedingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.PROCEEDINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitile() {
		return titile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitile(String newTitile) {
		String oldTitile = titile;
		titile = newTitile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__TITILE, oldTitile, titile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYear(String newYear) {
		String oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectResolvingEList<Editor>(Editor.class, this, DBLPPackage.PROCEEDINGS__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Publisher getPublisher() {
		if (publisher != null && publisher.eIsProxy()) {
			InternalEObject oldPublisher = (InternalEObject)publisher;
			publisher = (Publisher)eResolveProxy(oldPublisher);
			if (publisher != oldPublisher) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.PROCEEDINGS__PUBLISHER, oldPublisher, publisher));
			}
		}
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Publisher basicGetPublisher() {
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(Publisher newPublisher) {
		Publisher oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__PUBLISHER, oldPublisher, publisher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Organization> getSponsoredBy() {
		if (sponsoredBy == null) {
			sponsoredBy = new EObjectResolvingEList<Organization>(Organization.class, this, DBLPPackage.PROCEEDINGS__SPONSORED_BY);
		}
		return sponsoredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonth(int newMonth) {
		int oldMonth = month;
		month = newMonth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DBLPPackage.PROCEEDINGS__TITILE:
				return getTitile();
			case DBLPPackage.PROCEEDINGS__YEAR:
				return getYear();
			case DBLPPackage.PROCEEDINGS__EDITORS:
				return getEditors();
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				if (resolve) return getPublisher();
				return basicGetPublisher();
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				return getSponsoredBy();
			case DBLPPackage.PROCEEDINGS__MONTH:
				return getMonth();
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
			case DBLPPackage.PROCEEDINGS__TITILE:
				setTitile((String)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__YEAR:
				setYear((String)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				setPublisher((Publisher)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				getSponsoredBy().clear();
				getSponsoredBy().addAll((Collection<? extends Organization>)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__MONTH:
				setMonth((Integer)newValue);
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
			case DBLPPackage.PROCEEDINGS__TITILE:
				setTitile(TITILE_EDEFAULT);
				return;
			case DBLPPackage.PROCEEDINGS__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DBLPPackage.PROCEEDINGS__EDITORS:
				getEditors().clear();
				return;
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				setPublisher((Publisher)null);
				return;
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				getSponsoredBy().clear();
				return;
			case DBLPPackage.PROCEEDINGS__MONTH:
				setMonth(MONTH_EDEFAULT);
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
			case DBLPPackage.PROCEEDINGS__TITILE:
				return TITILE_EDEFAULT == null ? titile != null : !TITILE_EDEFAULT.equals(titile);
			case DBLPPackage.PROCEEDINGS__YEAR:
				return YEAR_EDEFAULT == null ? year != null : !YEAR_EDEFAULT.equals(year);
			case DBLPPackage.PROCEEDINGS__EDITORS:
				return editors != null && !editors.isEmpty();
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				return publisher != null;
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				return sponsoredBy != null && !sponsoredBy.isEmpty();
			case DBLPPackage.PROCEEDINGS__MONTH:
				return month != MONTH_EDEFAULT;
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
		result.append(" (titile: ");
		result.append(titile);
		result.append(", year: ");
		result.append(year);
		result.append(", month: ");
		result.append(month);
		result.append(')');
		return result.toString();
	}

} //ProceedingsImpl
