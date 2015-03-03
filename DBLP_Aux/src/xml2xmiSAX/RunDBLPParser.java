package xml2xmiSAX;

import java.io.IOException;


public class RunDBLPParser {
	public static void main(String args[]) throws IOException {
		
		double time0 = System.currentTimeMillis();
		
		String pathXML = "C:/Users/Atenea/Desktop/DBLP/dblp-noHTMLEncoding.xml";
//		String pathXML = "/home/loli/IST_2014/dblp-noHTMLEncoding.xml";
		
		Xml2Model xml2M = new Xml2Model(pathXML);
		xml2M.getXml();
		xml2M.writeXMI("src/dblp-simplified.xmi");
//		xml2M.writeSer("src/dblp.ser");
		
		System.out.println("Time spent: " + (System.currentTimeMillis()-time0)/1000);
	}
}
