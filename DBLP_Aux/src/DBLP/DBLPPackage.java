/**
 */
package DBLP;

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
 * @see DBLP.DBLPFactory
 * @model kind="package"
 * @generated
 */
public interface DBLPPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DBLP";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://dblp.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DBLP";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DBLPPackage eINSTANCE = DBLP.impl.DBLPPackageImpl.init();

	/**
	 * The meta object id for the '{@link DBLP.impl.RecordImpl <em>Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.RecordImpl
	 * @see DBLP.impl.DBLPPackageImpl#getRecord()
	 * @generated
	 */
	int RECORD = 0;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__EE = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__URL = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__KEY = 2;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__AUTHORS = 3;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__MDATE = 4;

	/**
	 * The number of structural features of the '<em>Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.ArticleImpl <em>Article</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.ArticleImpl
	 * @see DBLP.impl.DBLPPackageImpl#getArticle()
	 * @generated
	 */
	int ARTICLE = 1;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__FROM_PAGE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TO_PAGE = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__NUMBER = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Journal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__JOURNAL = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__VOLUME = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__MONTH = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__YEAR = RECORD_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_FEATURE_COUNT = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.AuthorImpl
	 * @see DBLP.impl.DBLPPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Records</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__RECORDS = 1;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.JournalImpl <em>Journal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.JournalImpl
	 * @see DBLP.impl.DBLPPackageImpl#getJournal()
	 * @generated
	 */
	int JOURNAL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Articles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL__ARTICLES = 1;

	/**
	 * The number of structural features of the '<em>Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.BookImpl
	 * @see DBLP.impl.DBLPPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 4;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__PUBLISHER = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__MONTH = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__VOLUME = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Series</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__SERIES = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Edition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__EDITION = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Isbn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__ISBN = RECORD_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.InCollectionImpl <em>In Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.InCollectionImpl
	 * @see DBLP.impl.DBLPPackageImpl#getInCollection()
	 * @generated
	 */
	int IN_COLLECTION = 5;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Book Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__BOOK_TITLE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__YEAR = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__EDITORS = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>From Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__FROM_PAGE = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>To Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__TO_PAGE = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sponsored By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__SPONSORED_BY = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__PUBLISHER = RECORD_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__MONTH = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>In Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION_FEATURE_COUNT = RECORD_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>In Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.InProceedingsImpl <em>In Proceedings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.InProceedingsImpl
	 * @see DBLP.impl.DBLPPackageImpl#getInProceedings()
	 * @generated
	 */
	int IN_PROCEEDINGS = 6;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bootitle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__BOOTITLE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__YEAR = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>From Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__FROM_PAGE = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>To Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__TO_PAGE = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__MONTH = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__EDITORS = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__ORGANIZATION = RECORD_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__PUBLISHER = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>In Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>In Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.MastersThesisImpl <em>Masters Thesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.MastersThesisImpl
	 * @see DBLP.impl.DBLPPackageImpl#getMastersThesis()
	 * @generated
	 */
	int MASTERS_THESIS = 7;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>School</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__SCHOOL = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__MONTH = RECORD_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Masters Thesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Masters Thesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.ProceedingsImpl <em>Proceedings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.ProceedingsImpl
	 * @see DBLP.impl.DBLPPackageImpl#getProceedings()
	 * @generated
	 */
	int PROCEEDINGS = 8;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__EDITORS = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__PUBLISHER = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sponsored By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__SPONSORED_BY = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__MONTH = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Isbn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__ISBN = RECORD_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.PhDThesisImpl <em>Ph DThesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.PhDThesisImpl
	 * @see DBLP.impl.DBLPPackageImpl#getPhDThesis()
	 * @generated
	 */
	int PH_DTHESIS = 9;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__MONTH = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>School</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__SCHOOL = RECORD_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ph DThesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Ph DThesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.WwwImpl <em>Www</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.WwwImpl
	 * @see DBLP.impl.DBLPPackageImpl#getWww()
	 * @generated
	 */
	int WWW = 10;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__EDITORS = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__TITLE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__YEAR = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__MONTH = RECORD_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Www</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW_FEATURE_COUNT = RECORD_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Www</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.EditorImpl
	 * @see DBLP.impl.DBLPPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__NAME = 0;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.OrganizationImpl <em>Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.OrganizationImpl
	 * @see DBLP.impl.DBLPPackageImpl#getOrganization()
	 * @generated
	 */
	int ORGANIZATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.PublisherImpl <em>Publisher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.PublisherImpl
	 * @see DBLP.impl.DBLPPackageImpl#getPublisher()
	 * @generated
	 */
	int PUBLISHER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>Publisher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Publisher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DBLP.impl.SchoolImpl <em>School</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DBLP.impl.SchoolImpl
	 * @see DBLP.impl.DBLPPackageImpl#getSchool()
	 * @generated
	 */
	int SCHOOL = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>School</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>School</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link DBLP.Record <em>Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record</em>'.
	 * @see DBLP.Record
	 * @generated
	 */
	EClass getRecord();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Record#getEe <em>Ee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ee</em>'.
	 * @see DBLP.Record#getEe()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Ee();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Record#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see DBLP.Record#getUrl()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Url();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Record#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see DBLP.Record#getKey()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Key();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.Record#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Authors</em>'.
	 * @see DBLP.Record#getAuthors()
	 * @see #getRecord()
	 * @generated
	 */
	EReference getRecord_Authors();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Record#getMdate <em>Mdate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mdate</em>'.
	 * @see DBLP.Record#getMdate()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Mdate();

	/**
	 * Returns the meta object for class '{@link DBLP.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Article</em>'.
	 * @see DBLP.Article
	 * @generated
	 */
	EClass getArticle();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Article#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.Article#getTitle()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Article#getFromPage <em>From Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Page</em>'.
	 * @see DBLP.Article#getFromPage()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_FromPage();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Article#getToPage <em>To Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Page</em>'.
	 * @see DBLP.Article#getToPage()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_ToPage();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Article#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see DBLP.Article#getNumber()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Number();

	/**
	 * Returns the meta object for the reference '{@link DBLP.Article#getJournal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Journal</em>'.
	 * @see DBLP.Article#getJournal()
	 * @see #getArticle()
	 * @generated
	 */
	EReference getArticle_Journal();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Article#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see DBLP.Article#getVolume()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Volume();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Article#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.Article#getMonth()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Month();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Article#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.Article#getYear()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Year();

	/**
	 * Returns the meta object for class '{@link DBLP.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see DBLP.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DBLP.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.Author#getRecords <em>Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Records</em>'.
	 * @see DBLP.Author#getRecords()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_Records();

	/**
	 * Returns the meta object for class '{@link DBLP.Journal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Journal</em>'.
	 * @see DBLP.Journal
	 * @generated
	 */
	EClass getJournal();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Journal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DBLP.Journal#getName()
	 * @see #getJournal()
	 * @generated
	 */
	EAttribute getJournal_Name();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.Journal#getArticles <em>Articles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Articles</em>'.
	 * @see DBLP.Journal#getArticles()
	 * @see #getJournal()
	 * @generated
	 */
	EReference getJournal_Articles();

	/**
	 * Returns the meta object for class '{@link DBLP.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see DBLP.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Book#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.Book#getTitle()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Book#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.Book#getYear()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Year();

	/**
	 * Returns the meta object for the reference '{@link DBLP.Book#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see DBLP.Book#getPublisher()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Publisher();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Book#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.Book#getMonth()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Month();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Book#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see DBLP.Book#getVolume()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Volume();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Book#getSeries <em>Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Series</em>'.
	 * @see DBLP.Book#getSeries()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Series();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Book#getEdition <em>Edition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edition</em>'.
	 * @see DBLP.Book#getEdition()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Edition();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Book#getIsbn <em>Isbn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Isbn</em>'.
	 * @see DBLP.Book#getIsbn()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Isbn();

	/**
	 * Returns the meta object for class '{@link DBLP.InCollection <em>In Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Collection</em>'.
	 * @see DBLP.InCollection
	 * @generated
	 */
	EClass getInCollection();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InCollection#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.InCollection#getTitle()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InCollection#getBookTitle <em>Book Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Book Title</em>'.
	 * @see DBLP.InCollection#getBookTitle()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_BookTitle();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InCollection#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.InCollection#getYear()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_Year();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.InCollection#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see DBLP.InCollection#getEditors()
	 * @see #getInCollection()
	 * @generated
	 */
	EReference getInCollection_Editors();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InCollection#getFromPage <em>From Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Page</em>'.
	 * @see DBLP.InCollection#getFromPage()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_FromPage();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InCollection#getToPage <em>To Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Page</em>'.
	 * @see DBLP.InCollection#getToPage()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_ToPage();

	/**
	 * Returns the meta object for the reference '{@link DBLP.InCollection#getSponsoredBy <em>Sponsored By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sponsored By</em>'.
	 * @see DBLP.InCollection#getSponsoredBy()
	 * @see #getInCollection()
	 * @generated
	 */
	EReference getInCollection_SponsoredBy();

	/**
	 * Returns the meta object for the reference '{@link DBLP.InCollection#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see DBLP.InCollection#getPublisher()
	 * @see #getInCollection()
	 * @generated
	 */
	EReference getInCollection_Publisher();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InCollection#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.InCollection#getMonth()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_Month();

	/**
	 * Returns the meta object for class '{@link DBLP.InProceedings <em>In Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Proceedings</em>'.
	 * @see DBLP.InProceedings
	 * @generated
	 */
	EClass getInProceedings();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InProceedings#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.InProceedings#getTitle()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InProceedings#getBootitle <em>Bootitle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bootitle</em>'.
	 * @see DBLP.InProceedings#getBootitle()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Bootitle();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InProceedings#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.InProceedings#getYear()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Year();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InProceedings#getFromPage <em>From Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Page</em>'.
	 * @see DBLP.InProceedings#getFromPage()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_FromPage();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InProceedings#getToPage <em>To Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Page</em>'.
	 * @see DBLP.InProceedings#getToPage()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_ToPage();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.InProceedings#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.InProceedings#getMonth()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Month();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.InProceedings#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see DBLP.InProceedings#getEditors()
	 * @see #getInProceedings()
	 * @generated
	 */
	EReference getInProceedings_Editors();

	/**
	 * Returns the meta object for the reference '{@link DBLP.InProceedings#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Organization</em>'.
	 * @see DBLP.InProceedings#getOrganization()
	 * @see #getInProceedings()
	 * @generated
	 */
	EReference getInProceedings_Organization();

	/**
	 * Returns the meta object for the reference '{@link DBLP.InProceedings#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see DBLP.InProceedings#getPublisher()
	 * @see #getInProceedings()
	 * @generated
	 */
	EReference getInProceedings_Publisher();

	/**
	 * Returns the meta object for class '{@link DBLP.MastersThesis <em>Masters Thesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Masters Thesis</em>'.
	 * @see DBLP.MastersThesis
	 * @generated
	 */
	EClass getMastersThesis();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.MastersThesis#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.MastersThesis#getTitle()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EAttribute getMastersThesis_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.MastersThesis#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.MastersThesis#getYear()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EAttribute getMastersThesis_Year();

	/**
	 * Returns the meta object for the reference '{@link DBLP.MastersThesis#getSchool <em>School</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>School</em>'.
	 * @see DBLP.MastersThesis#getSchool()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EReference getMastersThesis_School();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.MastersThesis#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.MastersThesis#getMonth()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EAttribute getMastersThesis_Month();

	/**
	 * Returns the meta object for class '{@link DBLP.Proceedings <em>Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proceedings</em>'.
	 * @see DBLP.Proceedings
	 * @generated
	 */
	EClass getProceedings();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Proceedings#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.Proceedings#getTitle()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Proceedings#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.Proceedings#getYear()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Year();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.Proceedings#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see DBLP.Proceedings#getEditors()
	 * @see #getProceedings()
	 * @generated
	 */
	EReference getProceedings_Editors();

	/**
	 * Returns the meta object for the reference '{@link DBLP.Proceedings#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see DBLP.Proceedings#getPublisher()
	 * @see #getProceedings()
	 * @generated
	 */
	EReference getProceedings_Publisher();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.Proceedings#getSponsoredBy <em>Sponsored By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sponsored By</em>'.
	 * @see DBLP.Proceedings#getSponsoredBy()
	 * @see #getProceedings()
	 * @generated
	 */
	EReference getProceedings_SponsoredBy();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Proceedings#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.Proceedings#getMonth()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Month();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Proceedings#getIsbn <em>Isbn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Isbn</em>'.
	 * @see DBLP.Proceedings#getIsbn()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Isbn();

	/**
	 * Returns the meta object for class '{@link DBLP.PhDThesis <em>Ph DThesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ph DThesis</em>'.
	 * @see DBLP.PhDThesis
	 * @generated
	 */
	EClass getPhDThesis();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.PhDThesis#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.PhDThesis#getTitle()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EAttribute getPhDThesis_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.PhDThesis#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.PhDThesis#getYear()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EAttribute getPhDThesis_Year();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.PhDThesis#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.PhDThesis#getMonth()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EAttribute getPhDThesis_Month();

	/**
	 * Returns the meta object for the reference '{@link DBLP.PhDThesis#getSchool <em>School</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>School</em>'.
	 * @see DBLP.PhDThesis#getSchool()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EReference getPhDThesis_School();

	/**
	 * Returns the meta object for class '{@link DBLP.Www <em>Www</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Www</em>'.
	 * @see DBLP.Www
	 * @generated
	 */
	EClass getWww();

	/**
	 * Returns the meta object for the reference list '{@link DBLP.Www#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see DBLP.Www#getEditors()
	 * @see #getWww()
	 * @generated
	 */
	EReference getWww_Editors();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Www#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DBLP.Www#getTitle()
	 * @see #getWww()
	 * @generated
	 */
	EAttribute getWww_Title();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Www#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see DBLP.Www#getYear()
	 * @see #getWww()
	 * @generated
	 */
	EAttribute getWww_Year();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Www#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see DBLP.Www#getMonth()
	 * @see #getWww()
	 * @generated
	 */
	EAttribute getWww_Month();

	/**
	 * Returns the meta object for class '{@link DBLP.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see DBLP.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Editor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DBLP.Editor#getName()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_Name();

	/**
	 * Returns the meta object for class '{@link DBLP.Organization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization</em>'.
	 * @see DBLP.Organization
	 * @generated
	 */
	EClass getOrganization();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Organization#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DBLP.Organization#getName()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_Name();

	/**
	 * Returns the meta object for class '{@link DBLP.Publisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publisher</em>'.
	 * @see DBLP.Publisher
	 * @generated
	 */
	EClass getPublisher();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Publisher#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DBLP.Publisher#getName()
	 * @see #getPublisher()
	 * @generated
	 */
	EAttribute getPublisher_Name();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.Publisher#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see DBLP.Publisher#getAddress()
	 * @see #getPublisher()
	 * @generated
	 */
	EAttribute getPublisher_Address();

	/**
	 * Returns the meta object for class '{@link DBLP.School <em>School</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>School</em>'.
	 * @see DBLP.School
	 * @generated
	 */
	EClass getSchool();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.School#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DBLP.School#getName()
	 * @see #getSchool()
	 * @generated
	 */
	EAttribute getSchool_Name();

	/**
	 * Returns the meta object for the attribute '{@link DBLP.School#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see DBLP.School#getAddress()
	 * @see #getSchool()
	 * @generated
	 */
	EAttribute getSchool_Address();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DBLPFactory getDBLPFactory();

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
		 * The meta object literal for the '{@link DBLP.impl.RecordImpl <em>Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.RecordImpl
		 * @see DBLP.impl.DBLPPackageImpl#getRecord()
		 * @generated
		 */
		EClass RECORD = eINSTANCE.getRecord();

		/**
		 * The meta object literal for the '<em><b>Ee</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__EE = eINSTANCE.getRecord_Ee();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__URL = eINSTANCE.getRecord_Url();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__KEY = eINSTANCE.getRecord_Key();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD__AUTHORS = eINSTANCE.getRecord_Authors();

		/**
		 * The meta object literal for the '<em><b>Mdate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__MDATE = eINSTANCE.getRecord_Mdate();

		/**
		 * The meta object literal for the '{@link DBLP.impl.ArticleImpl <em>Article</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.ArticleImpl
		 * @see DBLP.impl.DBLPPackageImpl#getArticle()
		 * @generated
		 */
		EClass ARTICLE = eINSTANCE.getArticle();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__TITLE = eINSTANCE.getArticle_Title();

		/**
		 * The meta object literal for the '<em><b>From Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__FROM_PAGE = eINSTANCE.getArticle_FromPage();

		/**
		 * The meta object literal for the '<em><b>To Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__TO_PAGE = eINSTANCE.getArticle_ToPage();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__NUMBER = eINSTANCE.getArticle_Number();

		/**
		 * The meta object literal for the '<em><b>Journal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE__JOURNAL = eINSTANCE.getArticle_Journal();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__VOLUME = eINSTANCE.getArticle_Volume();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__MONTH = eINSTANCE.getArticle_Month();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__YEAR = eINSTANCE.getArticle_Year();

		/**
		 * The meta object literal for the '{@link DBLP.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.AuthorImpl
		 * @see DBLP.impl.DBLPPackageImpl#getAuthor()
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
		 * The meta object literal for the '<em><b>Records</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__RECORDS = eINSTANCE.getAuthor_Records();

		/**
		 * The meta object literal for the '{@link DBLP.impl.JournalImpl <em>Journal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.JournalImpl
		 * @see DBLP.impl.DBLPPackageImpl#getJournal()
		 * @generated
		 */
		EClass JOURNAL = eINSTANCE.getJournal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOURNAL__NAME = eINSTANCE.getJournal_Name();

		/**
		 * The meta object literal for the '<em><b>Articles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOURNAL__ARTICLES = eINSTANCE.getJournal_Articles();

		/**
		 * The meta object literal for the '{@link DBLP.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.BookImpl
		 * @see DBLP.impl.DBLPPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__TITLE = eINSTANCE.getBook_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__YEAR = eINSTANCE.getBook_Year();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__PUBLISHER = eINSTANCE.getBook_Publisher();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__MONTH = eINSTANCE.getBook_Month();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__VOLUME = eINSTANCE.getBook_Volume();

		/**
		 * The meta object literal for the '<em><b>Series</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__SERIES = eINSTANCE.getBook_Series();

		/**
		 * The meta object literal for the '<em><b>Edition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__EDITION = eINSTANCE.getBook_Edition();

		/**
		 * The meta object literal for the '<em><b>Isbn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__ISBN = eINSTANCE.getBook_Isbn();

		/**
		 * The meta object literal for the '{@link DBLP.impl.InCollectionImpl <em>In Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.InCollectionImpl
		 * @see DBLP.impl.DBLPPackageImpl#getInCollection()
		 * @generated
		 */
		EClass IN_COLLECTION = eINSTANCE.getInCollection();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__TITLE = eINSTANCE.getInCollection_Title();

		/**
		 * The meta object literal for the '<em><b>Book Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__BOOK_TITLE = eINSTANCE.getInCollection_BookTitle();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__YEAR = eINSTANCE.getInCollection_Year();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_COLLECTION__EDITORS = eINSTANCE.getInCollection_Editors();

		/**
		 * The meta object literal for the '<em><b>From Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__FROM_PAGE = eINSTANCE.getInCollection_FromPage();

		/**
		 * The meta object literal for the '<em><b>To Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__TO_PAGE = eINSTANCE.getInCollection_ToPage();

		/**
		 * The meta object literal for the '<em><b>Sponsored By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_COLLECTION__SPONSORED_BY = eINSTANCE.getInCollection_SponsoredBy();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_COLLECTION__PUBLISHER = eINSTANCE.getInCollection_Publisher();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__MONTH = eINSTANCE.getInCollection_Month();

		/**
		 * The meta object literal for the '{@link DBLP.impl.InProceedingsImpl <em>In Proceedings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.InProceedingsImpl
		 * @see DBLP.impl.DBLPPackageImpl#getInProceedings()
		 * @generated
		 */
		EClass IN_PROCEEDINGS = eINSTANCE.getInProceedings();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__TITLE = eINSTANCE.getInProceedings_Title();

		/**
		 * The meta object literal for the '<em><b>Bootitle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__BOOTITLE = eINSTANCE.getInProceedings_Bootitle();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__YEAR = eINSTANCE.getInProceedings_Year();

		/**
		 * The meta object literal for the '<em><b>From Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__FROM_PAGE = eINSTANCE.getInProceedings_FromPage();

		/**
		 * The meta object literal for the '<em><b>To Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__TO_PAGE = eINSTANCE.getInProceedings_ToPage();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__MONTH = eINSTANCE.getInProceedings_Month();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS__EDITORS = eINSTANCE.getInProceedings_Editors();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS__ORGANIZATION = eINSTANCE.getInProceedings_Organization();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS__PUBLISHER = eINSTANCE.getInProceedings_Publisher();

		/**
		 * The meta object literal for the '{@link DBLP.impl.MastersThesisImpl <em>Masters Thesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.MastersThesisImpl
		 * @see DBLP.impl.DBLPPackageImpl#getMastersThesis()
		 * @generated
		 */
		EClass MASTERS_THESIS = eINSTANCE.getMastersThesis();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTERS_THESIS__TITLE = eINSTANCE.getMastersThesis_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTERS_THESIS__YEAR = eINSTANCE.getMastersThesis_Year();

		/**
		 * The meta object literal for the '<em><b>School</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASTERS_THESIS__SCHOOL = eINSTANCE.getMastersThesis_School();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTERS_THESIS__MONTH = eINSTANCE.getMastersThesis_Month();

		/**
		 * The meta object literal for the '{@link DBLP.impl.ProceedingsImpl <em>Proceedings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.ProceedingsImpl
		 * @see DBLP.impl.DBLPPackageImpl#getProceedings()
		 * @generated
		 */
		EClass PROCEEDINGS = eINSTANCE.getProceedings();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__TITLE = eINSTANCE.getProceedings_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__YEAR = eINSTANCE.getProceedings_Year();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEEDINGS__EDITORS = eINSTANCE.getProceedings_Editors();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEEDINGS__PUBLISHER = eINSTANCE.getProceedings_Publisher();

		/**
		 * The meta object literal for the '<em><b>Sponsored By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEEDINGS__SPONSORED_BY = eINSTANCE.getProceedings_SponsoredBy();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__MONTH = eINSTANCE.getProceedings_Month();

		/**
		 * The meta object literal for the '<em><b>Isbn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__ISBN = eINSTANCE.getProceedings_Isbn();

		/**
		 * The meta object literal for the '{@link DBLP.impl.PhDThesisImpl <em>Ph DThesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.PhDThesisImpl
		 * @see DBLP.impl.DBLPPackageImpl#getPhDThesis()
		 * @generated
		 */
		EClass PH_DTHESIS = eINSTANCE.getPhDThesis();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PH_DTHESIS__TITLE = eINSTANCE.getPhDThesis_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PH_DTHESIS__YEAR = eINSTANCE.getPhDThesis_Year();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PH_DTHESIS__MONTH = eINSTANCE.getPhDThesis_Month();

		/**
		 * The meta object literal for the '<em><b>School</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PH_DTHESIS__SCHOOL = eINSTANCE.getPhDThesis_School();

		/**
		 * The meta object literal for the '{@link DBLP.impl.WwwImpl <em>Www</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.WwwImpl
		 * @see DBLP.impl.DBLPPackageImpl#getWww()
		 * @generated
		 */
		EClass WWW = eINSTANCE.getWww();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WWW__EDITORS = eINSTANCE.getWww_Editors();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WWW__TITLE = eINSTANCE.getWww_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WWW__YEAR = eINSTANCE.getWww_Year();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WWW__MONTH = eINSTANCE.getWww_Month();

		/**
		 * The meta object literal for the '{@link DBLP.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.EditorImpl
		 * @see DBLP.impl.DBLPPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__NAME = eINSTANCE.getEditor_Name();

		/**
		 * The meta object literal for the '{@link DBLP.impl.OrganizationImpl <em>Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.OrganizationImpl
		 * @see DBLP.impl.DBLPPackageImpl#getOrganization()
		 * @generated
		 */
		EClass ORGANIZATION = eINSTANCE.getOrganization();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__NAME = eINSTANCE.getOrganization_Name();

		/**
		 * The meta object literal for the '{@link DBLP.impl.PublisherImpl <em>Publisher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.PublisherImpl
		 * @see DBLP.impl.DBLPPackageImpl#getPublisher()
		 * @generated
		 */
		EClass PUBLISHER = eINSTANCE.getPublisher();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLISHER__NAME = eINSTANCE.getPublisher_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLISHER__ADDRESS = eINSTANCE.getPublisher_Address();

		/**
		 * The meta object literal for the '{@link DBLP.impl.SchoolImpl <em>School</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DBLP.impl.SchoolImpl
		 * @see DBLP.impl.DBLPPackageImpl#getSchool()
		 * @generated
		 */
		EClass SCHOOL = eINSTANCE.getSchool();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHOOL__NAME = eINSTANCE.getSchool_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHOOL__ADDRESS = eINSTANCE.getSchool_Address();

	}

} //DBLPPackage
