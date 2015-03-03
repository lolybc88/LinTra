package xml2xmiSAX;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mm.Record;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import DBLP.*;
import DBLP.impl.*;

public class Xml2Model extends DefaultHandler {

	private static final String AUTHOR = "Author:";
	private static final String EDITOR = "Editor:";
	private static final String RECORD = "Record:";
	private static final String JOURNAL = "Journal:";
	private static final String ORGANIZATION = "Organization:";
	private static final String SCHOOL = "School:";
	private static final String PUBLISHER = "Publisher:";
	String pathXML;
	Map<String, String> noNumericId2Id = new HashMap<String, String>();
	double idCounter = 1;
	int collisions = 0;

	public Xml2Model(String pathxml) {
		pathXML = pathxml;
	}

	Map<String, AuthorImpl> authors = new HashMap<String, AuthorImpl>();
	List<RecordImpl> records = new LinkedList<RecordImpl>();
	Map<String, JournalImpl> journals = new HashMap<String, JournalImpl>();
	Map<String, EditorImpl> editors = new HashMap<String, EditorImpl>();
	Map<String, OrganizationImpl> organizations = new HashMap<String, OrganizationImpl>();
	Map<String, PublisherImpl> publishers = new HashMap<String, PublisherImpl>();
	Map<String, SchoolImpl> schools = new HashMap<String, SchoolImpl>();

	public void getXml() {
		try {

			System.out.println("Parsing XML and creating entities...");
			// obtain and configure a SAX based parser
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

			// obtain object for SAX parser
			SAXParser saxParser = saxParserFactory.newSAXParser();

			// default handler for SAX handler class
			// all three methods are written in handler's body
			DefaultHandler defaultHandler = new DefaultHandler() {

				int numElems = 0;
				int maxNumElems = 20000; // -1 to not fix a maximum
				boolean enD = false;
				private String temp;
				private RecordImpl record;
				private boolean inProceedingsOpen, articleOpen,
						proceedingsOpen, bookOpen, inCollectionOpen,
						phdThesisOpen, mastersThesisOpen, wwwOpen;

				// this method is called every time the parser gets an open tag
				// '<'
				// identifies which tag is being open at time by assigning an
				// open flag
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					if (!enD){
					temp = "";
					if (qName.equalsIgnoreCase("inproceedings")) {
						inProceedingsOpen = true;
						record = new InProceedingsImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
//						record = null;
					}
					if (qName.equalsIgnoreCase("article")) {
						articleOpen = true;
						record = new ArticleImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
					}
					if (qName.equalsIgnoreCase("proceedings")) {
						proceedingsOpen = true;
						record = new ProceedingsImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
//						record = null;
					}
					if (qName.equalsIgnoreCase("book")) {
						bookOpen = true;
						record = new BookImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
//						record = null;
					}
					if (qName.equalsIgnoreCase("incollection")) {
						inCollectionOpen = true;
						record = new InCollectionImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
//						record=null;
					}
					if (qName.equalsIgnoreCase("phdthesis")) {
						phdThesisOpen = true;
						record = new PhDThesisImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
					}
					if (qName.equalsIgnoreCase("mastersthesis")) {
						mastersThesisOpen = true;
						record = new MastersThesisImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
					}
					if (qName.equalsIgnoreCase("www")) {
						wwwOpen = true;
						record = new WwwImpl();
						record.setMdate(attributes.getValue("mdate"));
						record.setKey(attributes.getValue("key"));
//						record = null;
					}
					}
				}

				public void characters(char[] buffer, int start, int length) {
					if (!enD){
					temp = new String(buffer, start, length);
					}
				}

				// calls by the parser whenever '>' end tag is found in xml makes tags flag to 'close'
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					
					if (!enD){
					
					if (qName.equalsIgnoreCase("inproceedings")) {
						inProceedingsOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (qName.equalsIgnoreCase("article")) {
						articleOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (qName.equalsIgnoreCase("proceedings")) {
						proceedingsOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (qName.equalsIgnoreCase("book")) {
						bookOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (qName.equalsIgnoreCase("incollection")) {
						inCollectionOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (qName.equalsIgnoreCase("phdthesis")) {
						phdThesisOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (qName.equalsIgnoreCase("mastersthesis")) {
						mastersThesisOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (qName.equalsIgnoreCase("www")) {
						wwwOpen = false;
						records.add(record); numElems++;
						if (maxNumElems!=-1 && numElems>=maxNumElems){ enD = true; }
					}
					if (record!=null){
						if (qName.equalsIgnoreCase("author")) {
							processAuthor();
						}
						if (qName.equalsIgnoreCase("title")) {
							processTitle();
						}
						if (qName.equalsIgnoreCase("pages")) {
							processPages();
						}
						if (qName.equalsIgnoreCase("year")) {
							processYear();
						}
						if (qName.equalsIgnoreCase("month")) {
							processMonth();
						}
						if (qName.equalsIgnoreCase("booktitle")) {
							processBooktitle();
						}
						if (qName.equalsIgnoreCase("ee")) {
							processEE();
						}
						if (qName.equalsIgnoreCase("url")) {
							processURL();
						}
						if (qName.equalsIgnoreCase("volume")) {
							processVolume();
						}
						if (qName.equalsIgnoreCase("journal")) {
							processJournal();
						}
						if (qName.equalsIgnoreCase("number")) {
							processNumber();
						}
						if (qName.equalsIgnoreCase("editor")) {
							processEditor();
						}
						if (qName.equalsIgnoreCase("isbn")) {
							processISBN();
						}
						if (qName.equalsIgnoreCase("series")) {
							processSeries();
						}
						if (qName.equalsIgnoreCase("publisher")) {
							processPublisher();
						}
						if (qName.equalsIgnoreCase("school")) {
							processSchool();
						}
						if (qName.equalsIgnoreCase("organization")) {
							processOrganization();
						}
					}
				}
				}

				private void processOrganization() {
					OrganizationImpl organization = new OrganizationImpl();
					organization.setName(temp);

					if (inCollectionOpen) {
						if (organizations.containsKey(organization
								.getName())) {
							((InCollectionImpl) record)
									.setSponsoredBy(organizations
											.get(organization.getName()));
						} else {
							organizations.put(organization.getName(),
									organization); numElems++;
							((InCollectionImpl) record)
									.setSponsoredBy(organization);
						}
					}
					if (inProceedingsOpen) {
						if (organizations.containsKey(organization
								.getName())) {
							((InProceedingsImpl) record)
									.setOrganization(organizations
											.get(organization.getName()));
						} else {
							organizations.put(organization.getName(),
									organization); numElems++;
							((InProceedingsImpl) record)
									.setOrganization(organization);
						}
					}
					if (proceedingsOpen) {
						if (organizations.containsKey(organization
								.getName())) {
							((ProceedingsImpl) record).getSponsoredBy()
									.add(organizations.get(organization
											.getName()));
						} else {
							organizations.put(organization.getName(),
									organization); numElems++;
							((ProceedingsImpl) record).getSponsoredBy()
									.add(organization);
						}
					}
				}

				private void processSchool() {
					SchoolImpl school = new SchoolImpl();
					school.setName(temp);

					if (phdThesisOpen) {
						if (schools.containsKey(school.getName())) {
							((PhDThesisImpl) record).setSchool(schools
									.get(school.getName()));
						} else {
							schools.put(school.getName(), school); numElems++;
							((PhDThesisImpl) record).setSchool(school);
						}
					}
					if (mastersThesisOpen) {
						if (schools.containsKey(school.getName())) {
							((MastersThesisImpl) record).setSchool(schools
									.get(school.getName()));
						} else {
							schools.put(school.getName(), school); numElems++;
							((MastersThesisImpl) record).setSchool(school);
						}
					}
				}

				private void processPublisher() {
					PublisherImpl publisher = new PublisherImpl();
					publisher.setName(temp);
					if (proceedingsOpen) {
						if (publishers.containsKey(publisher.getName())) {
							((ProceedingsImpl) record)
									.setPublisher(publishers.get(publisher
											.getName()));
						} else {
							publishers.put(publisher.getName(), publisher); numElems++;
							((ProceedingsImpl) record)
									.setPublisher(publisher);
						}
					}
					if (bookOpen) {
						if (publishers.containsKey(publisher.getName())) {
							((BookImpl) record).setPublisher(publishers
									.get(publisher.getName()));
						} else {
							publishers.put(publisher.getName(), publisher); numElems++;
							((BookImpl) record).setPublisher(publisher);
						}
					}
				}

				private void processSeries() {
					if (bookOpen) {
						((BookImpl) record).setSeries(temp);
					}
				}

				private void processISBN() {
					if (proceedingsOpen) {
						((ProceedingsImpl) record).setIsbn(temp);
					}
					if (bookOpen) {
						((BookImpl) record).setIsbn(temp);
					}
				}

				private void processEditor() {
					EditorImpl editor = new EditorImpl();
					editor.setName(temp);
					if (proceedingsOpen) {
						if (editors.containsKey(editor.getName())) {
							((ProceedingsImpl) record).getEditors().add(
									editors.get(editor.getName()));
						} else {
							editors.put(editor.getName(), editor); numElems++;
							((ProceedingsImpl) record).getEditors().add(
									editor);
						}
					}
					if (wwwOpen) {
						if (editors.containsKey(editor.getName())) {
							((WwwImpl) record).getEditors().add(
									editors.get(editor.getName()));
						} else {
							editors.put(editor.getName(), editor); numElems++;
							((WwwImpl) record).getEditors().add(editor);
						}
					}
				}

				private void processNumber() {
					if (temp != null && !temp.equals("")) {
						try {
							int number = Integer.parseInt(temp);
							if (articleOpen) {
								((ArticleImpl) record).setNumber(number);
							}
						} catch (NumberFormatException e) {
//								System.err.println(e);
						}
					}
				}

				private void processJournal() {
					if (articleOpen) {
						JournalImpl journal = new JournalImpl();
						journal.setName(temp);
						journal.getArticles().add((ArticleImpl)record);
						if (journals.containsKey(journal.getName())) {
							((ArticleImpl) record).setJournal(journals
									.get(journal.getName()));
						} else {
							journals.put(journal.getName(), journal); numElems++;
							((ArticleImpl) record).setJournal(journal);
						}
					}
				}

				private void processVolume() {
					if (articleOpen) {
						((ArticleImpl) record).setVolume(temp);
					}
				}

				private void processURL() {
					if (inProceedingsOpen) {
						((InProceedingsImpl) record).setUrl(temp);
					}
					if (articleOpen) {
						((ArticleImpl) record).setUrl(temp);
					}
					if (proceedingsOpen) {
						((ProceedingsImpl) record).setUrl(temp);
					}
					if (bookOpen) {
						((BookImpl) record).setUrl(temp);
					}
					if (inCollectionOpen) {
						((InCollectionImpl) record).setUrl(temp);
					}
					if (phdThesisOpen) {
						((PhDThesisImpl) record).setUrl(temp);
					}
					if (mastersThesisOpen) {
						((MastersThesisImpl) record).setUrl(temp);
					}
					if (wwwOpen) {
						((WwwImpl) record).setUrl(temp);
					}
				}

				private void processEE() {
					if (inProceedingsOpen) {
						((InProceedingsImpl) record).setEe(temp);
					}
					if (proceedingsOpen) {
						((ProceedingsImpl) record).setEe(temp);
					}
					if (articleOpen) {
						((ArticleImpl) record).setEe(temp);
					}
					if (bookOpen) {
						((BookImpl) record).setEe(temp);
					}
					if (inCollectionOpen) {
						((InCollectionImpl) record).setEe(temp);
					}
					if (phdThesisOpen) {
						((PhDThesisImpl) record).setEe(temp);
					}
					if (mastersThesisOpen) {
						((MastersThesisImpl) record).setEe(temp);
					}
					if (wwwOpen) {
						((WwwImpl) record).setEe(temp);
					}
				}

				private void processBooktitle() {
					if (inProceedingsOpen) {
						((InProceedingsImpl) record).setBootitle(temp);
					}
					if (inCollectionOpen) {
						((InCollectionImpl) record).setBookTitle(temp);
					}
				}

				private void processMonth() {
					if (inProceedingsOpen) {
						((InProceedingsImpl) record).setMonth(temp);
					}
					if (articleOpen) {
						((ArticleImpl) record).setMonth(temp);
					}
					if (proceedingsOpen) {
						((ProceedingsImpl) record).setMonth(temp);
					}
					if (bookOpen) {
						((BookImpl) record).setMonth(temp);
					}
					if (inCollectionOpen) {
						((InCollectionImpl) record).setMonth(temp);
					}
					if (phdThesisOpen) {
						((PhDThesisImpl) record).setMonth(temp);
					}
					if (mastersThesisOpen) {
						((MastersThesisImpl) record).setMonth(temp);
					}
					if (wwwOpen) {
						((WwwImpl) record).setMonth(temp);
					}
				}

				private void processYear() {
					if (temp != null && !temp.equals("")) {
						int year = Integer.parseInt(temp);
						if (inProceedingsOpen) {
							((InProceedingsImpl) record).setYear(year);
						}
						if (articleOpen) {
							((ArticleImpl) record).setYear(year);
						}
						if (proceedingsOpen) {
							((ProceedingsImpl) record).setYear(year);
						}
						if (bookOpen) {
							((BookImpl) record).setYear(year);
						}
						if (inCollectionOpen) {
							((InCollectionImpl) record).setYear(year);
						}
						if (phdThesisOpen) {
							((PhDThesisImpl) record).setYear(year);
						}
						if (mastersThesisOpen) {
							((MastersThesisImpl) record).setYear(year);
						}
						if (wwwOpen) {
							((WwwImpl) record).setYear(year);
						}
					}
				}

				private void processPages() {
					String from, to;
					if (temp.contains("-")) {
						from = temp.substring(0, temp.indexOf("-"));
						to = temp.substring(temp.lastIndexOf("-") + 1,
								temp.length());
					} else {
						from = temp;
						to = "";
					}
						if (inProceedingsOpen) {
							if (!from.isEmpty()) {
								try {
									((InProceedingsImpl) record).setFromPage(Integer.parseInt(from));
								} catch (NumberFormatException n){
									((InProceedingsImpl) record).setFromPage(-1);
								}
							}
							if (!to.isEmpty()) {
								try {
									((InProceedingsImpl) record).setToPage(Integer.parseInt(to));
								} catch (NumberFormatException n){
									((InProceedingsImpl) record).setToPage(-1);
								}
							}
						}
						if (articleOpen) {
							if (!from.isEmpty()) {
								try {
									((ArticleImpl) record).setFromPage(Integer.parseInt(from));
								} catch (NumberFormatException n){
									((ArticleImpl) record).setFromPage(-1);
								} 
							}
							if (!to.isEmpty()) {
								try {
									((ArticleImpl) record).setToPage(Integer.parseInt(to));
								} catch (NumberFormatException e){
									((ArticleImpl) record).setToPage(-1);
								}
							}
						}
						if (inCollectionOpen) {
							if (!from.isEmpty()) {
								try {
									((InCollectionImpl) record).setFromPage(Integer.parseInt(from));
								} catch (NumberFormatException n){
									((InCollectionImpl) record).setFromPage(-1);
								}
							}
							if (!to.isEmpty()) {
								try {
									((InCollectionImpl) record).setToPage(Integer.parseInt(to));
								} catch (NumberFormatException n){
									((InCollectionImpl) record).setToPage(-1);
								}
							}
						}
				}

				private void processTitle() {
					if (inProceedingsOpen) {
						((InProceedingsImpl) record).setTitle(temp);
					}
					if (articleOpen) {
						((ArticleImpl) record).setTitle(temp);
					}
					if (proceedingsOpen) {
						((ProceedingsImpl) record).setTitle(temp);
					}
					if (bookOpen) {
						((BookImpl) record).setTitle(temp);
					}
					if (inCollectionOpen) {
						((InCollectionImpl) record).setTitle(temp);
					}
					if (phdThesisOpen) {
						((PhDThesisImpl) record).setTitle(temp);
					}
					if (mastersThesisOpen) {
						((MastersThesisImpl) record).setTitle(temp);
					}
					if (wwwOpen) {
						((WwwImpl) record).setTitle(temp);
					}
				}

				private void processAuthor() {
					AuthorImpl author = new AuthorImpl();
					author.setName(temp);
					if (authors.containsKey(author.getName())) {
						authors.get(author.getName()).getRecords().add(record);
					} else {
						author.getRecords().add(record);
					}
					if (inProceedingsOpen) {
						if (authors.containsKey(author.getName())) {
							((InProceedingsImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((InProceedingsImpl) record).getAuthors().add(
									author);
						}
					}
					if (articleOpen) {
						if (authors.containsKey(author.getName())) {
							((ArticleImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((ArticleImpl) record).getAuthors().add(author);
						}
					}
					if (proceedingsOpen) {
						if (authors.containsKey(author.getName())) {
							((ProceedingsImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((ProceedingsImpl) record).getAuthors().add(
									author);
						}
					}
					if (bookOpen) {
						if (authors.containsKey(author.getName())) {
							((BookImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((BookImpl) record).getAuthors().add(author);
						}
					}
					if (inCollectionOpen) {
						if (authors.containsKey(author.getName())) {
							((InCollectionImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((InCollectionImpl) record).getAuthors().add(
									author);
						}
					}
					if (phdThesisOpen) {
						if (authors.containsKey(author.getName())) {
							((PhDThesisImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((PhDThesisImpl) record).getAuthors().add(
									author);
						}
					}
					if (mastersThesisOpen) {
						if (authors.containsKey(author.getName())) {
							((MastersThesisImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((MastersThesisImpl) record).getAuthors().add(
									author);
						}
					}
					if (wwwOpen) {
						if (authors.containsKey(author.getName())) {
							((WwwImpl) record).getAuthors().add(
									authors.get(author.getName()));
						} else {
							authors.put(author.getName(), author); numElems++;
							((WwwImpl) record).getAuthors().add(author);
						}
					}
				}
			};

			// parse the XML specified in the given path and uses supplied
			// handler to parse the document
			// this calls startElement(), endElement() and character() methods
			// accordingly
			double time0 = System.currentTimeMillis();

			// InputStream is = new FileInputStream(pathXML);
			// saxParser.parse(new BufferedInputStream(is), defaultHandler);
			// System.out.println((System.currentTimeMillis() - time0)/1000);

			saxParser.parse(pathXML, defaultHandler);
			
			

			printSummary(time0);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	private void printSummary(double time0) {
		System.out.println("** SUMMARY **");
		System.out.println("Time parsing the XML file: " + (System.currentTimeMillis() - time0) / 1000);
		System.out.println("Number of records: " + records.size());
		System.out.println("Number of authors: " + authors.size());
		System.out.println("Number of editors: " + editors.size());
		System.out.println("Number of journals: " + journals.size());
		System.out.println("Number of organizations: " + organizations.size());
		System.out.println("Number of publishers: " + publishers.size());
		System.out.println("Number of schools: " + schools.size());
	}



	public void writeXMI(String pathXMI) {
		// Initialize the model
		DBLPPackage.eINSTANCE.eClass();
		// Retrieve the default factory singleton
		DBLPFactory factory = DBLPFactory.eINSTANCE;

		// As of here we preparing to save the model content
		// Register the XMI resource factory for the .website extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// create a resource
		Resource resource = resSet.createResource(URI.createURI(pathXMI));

		System.out.println("Adding to XMI resource...");
		for (RecordImpl r : records) {
			resource.getContents().add(r);
		}
		for (AuthorImpl a : authors.values()) {
			resource.getContents().add(a);
		}
		for (JournalImpl j : journals.values()) {
			resource.getContents().add(j);
		}
		for (Publisher p : publishers.values()) {
			resource.getContents().add(p);
		}
		for (School s : schools.values()) {
			resource.getContents().add(s);
		}
		for (EditorImpl e : editors.values()) {
			resource.getContents().add(e);
		}
		for (OrganizationImpl o : organizations.values()) {
			resource.getContents().add(o);
		}

		// now save the content.
		try {
			System.out.println("Saving XMI resource...");
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	public void writeSer(String path) throws IOException {
		FileOutputStream saveFile = new FileOutputStream(path);
		ObjectOutputStream save = new ObjectOutputStream(saveFile);

		for (RecordImpl r : records) {
			String noNumericId;
			String idRecord = getOrGenerateId(RECORD+r.getKey());
			Record rec = null;
			if (r instanceof ArticleImpl) {
				ArticleImpl a = ((ArticleImpl) r);
				String journalId = "";
				if (a.getJournal() != null) {
					noNumericId = JOURNAL+a.getJournal().getName();
					journalId = getOrGenerateId(noNumericId);
				}
				rec = new mm.Article(idRecord, a.getEe(), a.getUrl(),
						a.getKey(), getAuthorIds(a.getAuthors()), a.getMdate(),
						a.getTitle(), a.getMonth(), a.getFromPage(),
						a.getToPage(), a.getNumber(), a.getVolume(), journalId, a.getYear());
			} else if (r instanceof BookImpl) {
				BookImpl b = ((BookImpl) r);
				String publisherId = "";
				if (b.getPublisher() != null) {
					noNumericId = PUBLISHER+b.getPublisher().getName();
					publisherId = getOrGenerateId(noNumericId);
				}
				rec = new mm.Book(idRecord, b.getEe(), b.getUrl(), b.getKey(),
						getAuthorIds(b.getAuthors()), b.getMdate(),
						b.getTitle(), b.getMonth(), b.getSeries(), b.getIsbn(),
						b.getYear(), b.getVolume(), b.getEdition(), publisherId);
			} else if (r instanceof InCollectionImpl) {
				InCollectionImpl ic = ((InCollectionImpl) r);
				String sponsorId = "", publisherId = "";
				if (ic.getSponsoredBy() != null) {
					noNumericId = ORGANIZATION+ic.getSponsoredBy().getName();
					sponsorId = getOrGenerateId(noNumericId);
				}
				if (ic.getPublisher() != null) {
					noNumericId = PUBLISHER+ic.getPublisher().getName();
					publisherId = getOrGenerateId(noNumericId);
				}
				rec = new mm.InCollection(idRecord, ic.getEe(), ic.getUrl(),
						ic.getKey(), getAuthorIds(ic.getAuthors()),
						ic.getMdate(), ic.getTitle(), ic.getBookTitle(),
						ic.getMonth(), ic.getYear(), ic.getFromPage(),
						ic.getToPage(), sponsorId,
						getEditorIds(ic.getEditors()), publisherId);
			} else if (r instanceof InProceedingsImpl) {
				InProceedingsImpl ip = ((InProceedingsImpl) r);
				String sponsorId = "", publisherId = "";
				if (ip.getOrganization() != null) {
					noNumericId = ORGANIZATION+ip.getOrganization().getName();
					sponsorId = getOrGenerateId(noNumericId);
				}
				if (ip.getPublisher() != null) {
					noNumericId = PUBLISHER+ip.getPublisher().getName();
					publisherId = getOrGenerateId(noNumericId);
				}
				rec = new mm.InProceedings(idRecord, ip.getEe(), ip.getUrl(),
						ip.getKey(), getAuthorIds(ip.getAuthors()),
						ip.getMdate(), ip.getTitle(), ip.getBootitle(),
						ip.getMonth(), ip.getYear(), ip.getFromPage(),
						ip.getToPage(), sponsorId, publisherId,
						getEditorIds(ip.getEditors()));
			} else if (r instanceof MastersThesisImpl) {
				MastersThesisImpl m = ((MastersThesisImpl) r);
				String schoolId = "";
				if (m.getSchool() != null) {
					if (m.getSchool() != null) {
						noNumericId = SCHOOL+m.getSchool().getName();
						schoolId = getOrGenerateId(noNumericId);
					}
				}
				rec = new mm.MastersThesis(idRecord, m.getEe(), m.getUrl(),
						m.getKey(), getAuthorIds(m.getAuthors()), m.getMdate(),
						m.getTitle(), m.getMonth(), m.getYear(), schoolId);
			} else if (r instanceof PhDThesisImpl) {
				PhDThesisImpl p = ((PhDThesisImpl) r);
				String schoolId = "";
				if (p.getSchool() != null) {
					noNumericId = SCHOOL+p.getSchool().getName();
					schoolId = getOrGenerateId(noNumericId);
				}
				rec = new mm.PhDThesis(idRecord, p.getEe(), p.getUrl(),
						p.getKey(), getAuthorIds(p.getAuthors()), p.getMdate(),
						p.getTitle(), p.getMonth(), p.getYear(), schoolId);
			} else if (r instanceof ProceedingsImpl) {
				ProceedingsImpl p = ((ProceedingsImpl) r);
				String publisherId = "";
				if (p.getPublisher() != null) {
					noNumericId = PUBLISHER+p.getPublisher().getName();
					publisherId = getOrGenerateId(noNumericId);
				}
				rec = new mm.Proceedings(idRecord, p.getEe(), p.getUrl(),
						p.getKey(), getAuthorIds(p.getAuthors()), p.getMdate(),
						p.getTitle(), p.getMonth(), p.getIsbn(), p.getYear(),
						getEditorIds(p.getEditors()),
						getOrganizationIds(p.getSponsoredBy()), publisherId);
			} else if (r instanceof WwwImpl) {
				WwwImpl w = ((WwwImpl) r);
				rec = new mm.Www(idRecord, w.getEe(), w.getUrl(), w.getKey(),
						getAuthorIds(w.getAuthors()), w.getMdate(),
						w.getTitle(), w.getMonth(), w.getYear(),
						getEditorIds(w.getEditors()));
			}
			save.writeObject(rec);
		}
		for (AuthorImpl a : authors.values()) {
			String noNumericId = AUTHOR+a.getName();
			String id;
			id = getOrGenerateId(noNumericId);
			mm.Author auth = new mm.Author(id, a.getName(), getRecordIds(a.getRecords()));
			save.writeObject(auth);
		}
		for (JournalImpl j : journals.values()) {
			String noNumericId = JOURNAL+j.getName();
			String id;
			id = getOrGenerateId(noNumericId);
			mm.Journal jour = new mm.Journal(id, j.getName(),
					getArticleIds(j.getArticles()));
			save.writeObject(jour);
		}
		for (PublisherImpl p : publishers.values()) {
			String noNumericId = PUBLISHER+p.getName();
			String id;
			id = getOrGenerateId(noNumericId);
			mm.Publisher pub = new mm.Publisher(id, p.getName(), p.getAddress());
			save.writeObject(pub);
		}
		for (SchoolImpl s : schools.values()) {
			String noNumericId = SCHOOL+s.getName();
			String id;
			id = getOrGenerateId(noNumericId);
			mm.School sc = new mm.School(id, s.getName(), s.getAddress());
			save.writeObject(sc);
		}
		for (EditorImpl e : editors.values()) {
			String noNumericId = EDITOR+e.getName();
			String id = getOrGenerateId(noNumericId);
			mm.Editor ed = new mm.Editor(id, e.getName());
			save.writeObject(ed);
		}
		for (OrganizationImpl o : organizations.values()) {
			String noNumericId = ORGANIZATION+o.getName();
			String id;
			id = getOrGenerateId(noNumericId);
			mm.Organization or = new mm.Organization(id, o.getName());
			save.writeObject(or);
		}
		save.close(); // This also closes saveFile.
		System.out.println("Done");
	}

	private String getOrGenerateId(String noNumericId) {
		String id;
		if (noNumericId2Id.containsKey(noNumericId)) {
			id = noNumericId2Id.get(noNumericId);
		} else {
			id = Double.toString(idCounter);
			noNumericId2Id.put(noNumericId, id);
			idCounter++;
		}
		return id;
	}
	
//	private Integer getHashCodeFromId(String id){
//		Integer hashCode;
//		if (id2HashCode.containsKey(id)) {
//			hashCode = id2HashCode.get(id);
//			return hashCode;
//		} else {
//			return -1;
//		}
//	}

	private String[] getRecordIds(EList<DBLP.Record> records2) {
		if (records2 != null) {
			String[] ids = new String[records2.size()];
			for (int i = 0; i < records2.size(); i++) {
				String key = RECORD+records2.get(i).getKey();
				if (noNumericId2Id.containsKey(key)) {
					ids[i] = noNumericId2Id.get(key);
				} else {
					ids[i] = Double.toString(idCounter);
					noNumericId2Id.put(key, Double.toString(idCounter));
					idCounter++;
				}
			}
			return ids;
		} else {
			return null;
		}
	}

	private String[] getArticleIds(EList<DBLP.Article> articles) {
		if (articles != null) {
			String[] ids = new String[articles.size()];
			for (int i = 0; i < articles.size(); i++) {
				String key = RECORD+articles.get(i).getKey();
				if (noNumericId2Id.containsKey(key)) {
					ids[i] = noNumericId2Id.get(key);
				} else {
					ids[i] = Double.toString(idCounter);
					noNumericId2Id.put(key, Double.toString(idCounter));
					idCounter++;
				}
			}
			return ids;
		} else {
			return null;
		}
	}

	private String[] getEditorIds(EList<DBLP.Editor> editors2) {
		if (editors2 != null) {
			String[] ids = new String[editors2.size()];
			for (int i = 0; i < editors2.size(); i++) {
				String key = EDITOR+editors2.get(i).getName();
				if (noNumericId2Id.containsKey(key)) {
					ids[i] = noNumericId2Id.get(key);
				} else {
					ids[i] = Double.toString(idCounter);
					noNumericId2Id.put(key,
							Double.toString(idCounter));
					idCounter++;
				}
			}
			return ids;
		} else {
			return null;
		}
	}

	private String[] getOrganizationIds(EList<DBLP.Organization> sponsoredBy) {
		if (sponsoredBy != null) {
			String[] ids = new String[sponsoredBy.size()];
			for (int i = 0; i < sponsoredBy.size(); i++) {
				String key = ORGANIZATION+sponsoredBy.get(i).getName();
				if (noNumericId2Id.containsKey(key)) {
					ids[i] = noNumericId2Id.get(key);
				} else {
					ids[i] = Double.toString(idCounter);
					noNumericId2Id.put(key, Double.toString(idCounter));
					idCounter++;
				}
			}
			return ids;
		} else {
			return null;
		}
	}

	private String[] getAuthorIds(EList<Author> authors) {
		if (authors != null) {
			String[] ids = new String[authors.size()];
			for (int i = 0; i < authors.size(); i++) {
				String key = AUTHOR+authors.get(i).getName();
				if (noNumericId2Id.containsKey(key)) {
					ids[i] = noNumericId2Id.get(key);
				} else {
					ids[i] = Double.toString(idCounter);
					noNumericId2Id.put(key,
							Double.toString(idCounter));
					idCounter++;
				}
			}
			return ids;
		} else {
			return null;
		}
	}

}
