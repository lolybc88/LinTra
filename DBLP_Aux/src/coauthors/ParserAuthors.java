package coauthors;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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

public class ParserAuthors extends DefaultHandler {

	String pathXML;
	
	public ParserAuthors(String pathxml){
		pathXML = pathxml;
	}
	
	Map<String, AuthorImpl> authors = new HashMap<String, AuthorImpl>();
	
	public Map<String, AuthorImpl> getAuthors() {
		try {
			
			System.out.println("Obtaining authors...");
			// obtain and configure a SAX based parser
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

			// obtain object for SAX parser
			SAXParser saxParser = saxParserFactory.newSAXParser();

			// default handler for SAX handler class
			// all three methods are written in handler's body
			DefaultHandler defaultHandler = new DefaultHandler() {

				private String temp;

				// this method is called every time the parser gets an open tag
				// '<'
				// identifies which tag is being open at time by assigning an
				// open flag
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					temp = "";
				}
				
				public void characters(char[] buffer, int start, int length) {
					temp = new String(buffer, start, length);
				}

				// calls by the parser whenever '>' end tag is found in xml
				// makes tags flag to 'close'
				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					if (qName.equalsIgnoreCase("author")) {
						AuthorImpl author = new AuthorImpl();
						author.setName(temp);
						
						authors.put(author.getName(), author);
					}
				}
			};

			// parse the XML specified in the given path and uses supplied
			// handler to parse the document
			// this calls startElement(), endElement() and character() methods
			// accordingly
			double time0 = System.currentTimeMillis();
			
//			InputStream is = new FileInputStream(pathXML);
//			saxParser.parse(new BufferedInputStream(is), defaultHandler);
//			System.out.println((System.currentTimeMillis() - time0)/1000);
			
			saxParser.parse(pathXML, defaultHandler);
			System.out.println((System.currentTimeMillis() - time0)/1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authors;
	}
}
