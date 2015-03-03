/**
 */
package ICMTAuthor.impl;

import ICMTAuthor.Author;
import ICMTAuthor.Conference;
import ICMTAuthor.ICMTAuthorPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ICMTAuthor.impl.AuthorImpl#getName <em>Name</em>}</li>
 *   <li>{@link ICMTAuthor.impl.AuthorImpl#getNumOfPapers <em>Num Of Papers</em>}</li>
 *   <li>{@link ICMTAuthor.impl.AuthorImpl#isActive <em>Active</em>}</li>
 *   <li>{@link ICMTAuthor.impl.AuthorImpl#getPublishesIn <em>Publishes In</em>}</li>
 *   <li>{@link ICMTAuthor.impl.AuthorImpl#getCoauthor <em>Coauthor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuthorImpl extends MinimalEObjectImpl.Container implements Author {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumOfPapers() <em>Num Of Papers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfPapers()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_OF_PAPERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumOfPapers() <em>Num Of Papers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfPapers()
	 * @generated
	 * @ordered
	 */
	protected int numOfPapers = NUM_OF_PAPERS_EDEFAULT;

	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPublishesIn() <em>Publishes In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishesIn()
	 * @generated
	 * @ordered
	 */
	protected EList<Conference> publishesIn;

	/**
	 * The cached value of the '{@link #getCoauthor() <em>Coauthor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoauthor()
	 * @generated
	 * @ordered
	 */
	protected EList<Author> coauthor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICMTAuthorPackage.Literals.AUTHOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ICMTAuthorPackage.AUTHOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumOfPapers() {
		return numOfPapers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumOfPapers(int newNumOfPapers) {
		int oldNumOfPapers = numOfPapers;
		numOfPapers = newNumOfPapers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ICMTAuthorPackage.AUTHOR__NUM_OF_PAPERS, oldNumOfPapers, numOfPapers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ICMTAuthorPackage.AUTHOR__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Conference> getPublishesIn() {
		if (publishesIn == null) {
			publishesIn = new EObjectResolvingEList<Conference>(Conference.class, this, ICMTAuthorPackage.AUTHOR__PUBLISHES_IN);
		}
		return publishesIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Author> getCoauthor() {
		if (coauthor == null) {
			coauthor = new EObjectResolvingEList<Author>(Author.class, this, ICMTAuthorPackage.AUTHOR__COAUTHOR);
		}
		return coauthor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ICMTAuthorPackage.AUTHOR__NAME:
				return getName();
			case ICMTAuthorPackage.AUTHOR__NUM_OF_PAPERS:
				return getNumOfPapers();
			case ICMTAuthorPackage.AUTHOR__ACTIVE:
				return isActive();
			case ICMTAuthorPackage.AUTHOR__PUBLISHES_IN:
				return getPublishesIn();
			case ICMTAuthorPackage.AUTHOR__COAUTHOR:
				return getCoauthor();
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
			case ICMTAuthorPackage.AUTHOR__NAME:
				setName((String)newValue);
				return;
			case ICMTAuthorPackage.AUTHOR__NUM_OF_PAPERS:
				setNumOfPapers((Integer)newValue);
				return;
			case ICMTAuthorPackage.AUTHOR__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case ICMTAuthorPackage.AUTHOR__PUBLISHES_IN:
				getPublishesIn().clear();
				getPublishesIn().addAll((Collection<? extends Conference>)newValue);
				return;
			case ICMTAuthorPackage.AUTHOR__COAUTHOR:
				getCoauthor().clear();
				getCoauthor().addAll((Collection<? extends Author>)newValue);
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
			case ICMTAuthorPackage.AUTHOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ICMTAuthorPackage.AUTHOR__NUM_OF_PAPERS:
				setNumOfPapers(NUM_OF_PAPERS_EDEFAULT);
				return;
			case ICMTAuthorPackage.AUTHOR__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case ICMTAuthorPackage.AUTHOR__PUBLISHES_IN:
				getPublishesIn().clear();
				return;
			case ICMTAuthorPackage.AUTHOR__COAUTHOR:
				getCoauthor().clear();
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
			case ICMTAuthorPackage.AUTHOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ICMTAuthorPackage.AUTHOR__NUM_OF_PAPERS:
				return numOfPapers != NUM_OF_PAPERS_EDEFAULT;
			case ICMTAuthorPackage.AUTHOR__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case ICMTAuthorPackage.AUTHOR__PUBLISHES_IN:
				return publishesIn != null && !publishesIn.isEmpty();
			case ICMTAuthorPackage.AUTHOR__COAUTHOR:
				return coauthor != null && !coauthor.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", numOfPapers: ");
		result.append(numOfPapers);
		result.append(", active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //AuthorImpl
