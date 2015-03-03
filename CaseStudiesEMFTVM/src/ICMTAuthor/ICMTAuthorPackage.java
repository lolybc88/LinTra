/**
 */
package ICMTAuthor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ICMTAuthor.ICMTAuthorFactory
 * @model kind="package"
 * @generated
 */
public interface ICMTAuthorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ICMTAuthor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ICMTAuthor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ICMTAuthor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ICMTAuthorPackage eINSTANCE = ICMTAuthor.impl.ICMTAuthorPackageImpl.init();

	/**
	 * The meta object id for the '{@link ICMTAuthor.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ICMTAuthor.impl.AuthorImpl
	 * @see ICMTAuthor.impl.ICMTAuthorPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Num Of Papers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NUM_OF_PAPERS = 1;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__ACTIVE = 2;

	/**
	 * The feature id for the '<em><b>Publishes In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__PUBLISHES_IN = 3;

	/**
	 * The feature id for the '<em><b>Coauthor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__COAUTHOR = 4;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ICMTAuthor.impl.ConferenceImpl <em>Conference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ICMTAuthor.impl.ConferenceImpl
	 * @see ICMTAuthor.impl.ICMTAuthorPackageImpl#getConference()
	 * @generated
	 */
	int CONFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Conference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Conference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link ICMTAuthor.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see ICMTAuthor.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute '{@link ICMTAuthor.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ICMTAuthor.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the attribute '{@link ICMTAuthor.Author#getNumOfPapers <em>Num Of Papers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Of Papers</em>'.
	 * @see ICMTAuthor.Author#getNumOfPapers()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_NumOfPapers();

	/**
	 * Returns the meta object for the attribute '{@link ICMTAuthor.Author#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see ICMTAuthor.Author#isActive()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Active();

	/**
	 * Returns the meta object for the reference list '{@link ICMTAuthor.Author#getPublishesIn <em>Publishes In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Publishes In</em>'.
	 * @see ICMTAuthor.Author#getPublishesIn()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_PublishesIn();

	/**
	 * Returns the meta object for the reference list '{@link ICMTAuthor.Author#getCoauthor <em>Coauthor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Coauthor</em>'.
	 * @see ICMTAuthor.Author#getCoauthor()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_Coauthor();

	/**
	 * Returns the meta object for class '{@link ICMTAuthor.Conference <em>Conference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conference</em>'.
	 * @see ICMTAuthor.Conference
	 * @generated
	 */
	EClass getConference();

	/**
	 * Returns the meta object for the attribute '{@link ICMTAuthor.Conference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ICMTAuthor.Conference#getName()
	 * @see #getConference()
	 * @generated
	 */
	EAttribute getConference_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ICMTAuthorFactory getICMTAuthorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ICMTAuthor.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ICMTAuthor.impl.AuthorImpl
		 * @see ICMTAuthor.impl.ICMTAuthorPackageImpl#getAuthor()
		 * @generated
		 */
		EClass AUTHOR = eINSTANCE.getAuthor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

		/**
		 * The meta object literal for the '<em><b>Num Of Papers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NUM_OF_PAPERS = eINSTANCE.getAuthor_NumOfPapers();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__ACTIVE = eINSTANCE.getAuthor_Active();

		/**
		 * The meta object literal for the '<em><b>Publishes In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__PUBLISHES_IN = eINSTANCE.getAuthor_PublishesIn();

		/**
		 * The meta object literal for the '<em><b>Coauthor</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__COAUTHOR = eINSTANCE.getAuthor_Coauthor();

		/**
		 * The meta object literal for the '{@link ICMTAuthor.impl.ConferenceImpl <em>Conference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ICMTAuthor.impl.ConferenceImpl
		 * @see ICMTAuthor.impl.ICMTAuthorPackageImpl#getConference()
		 * @generated
		 */
		EClass CONFERENCE = eINSTANCE.getConference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFERENCE__NAME = eINSTANCE.getConference_Name();

	}

} //ICMTAuthorPackage
