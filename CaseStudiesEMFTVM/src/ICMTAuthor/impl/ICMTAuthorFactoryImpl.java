/**
 */
package ICMTAuthor.impl;

import ICMTAuthor.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ICMTAuthorFactoryImpl extends EFactoryImpl implements ICMTAuthorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ICMTAuthorFactory init() {
		try {
			ICMTAuthorFactory theICMTAuthorFactory = (ICMTAuthorFactory)EPackage.Registry.INSTANCE.getEFactory(ICMTAuthorPackage.eNS_URI);
			if (theICMTAuthorFactory != null) {
				return theICMTAuthorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ICMTAuthorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICMTAuthorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ICMTAuthorPackage.AUTHOR: return createAuthor();
			case ICMTAuthorPackage.CONFERENCE: return createConference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Author createAuthor() {
		AuthorImpl author = new AuthorImpl();
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conference createConference() {
		ConferenceImpl conference = new ConferenceImpl();
		return conference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICMTAuthorPackage getICMTAuthorPackage() {
		return (ICMTAuthorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ICMTAuthorPackage getPackage() {
		return ICMTAuthorPackage.eINSTANCE;
	}

} //ICMTAuthorFactoryImpl
