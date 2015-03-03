package xml2xmiSAX;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveHTMLEncoding {

	public static void main(String[] args) throws IOException {

		// The XML DBLP file uses the HTML encoding for foreign language
		// characters (http://www.thesauruslex.com/typo/eng/enghtml.htm). That
		// encoding doesn't work well with SAX (for example the
		// string H&eacute;llo (H�llo) is split into two strings by SAX when it
		// should be only one) so we need to remove that encoding before
		// extracting the XMI model from the XML file
		BufferedReader in = new BufferedReader(new FileReader(
				"C:/Users/Atenea/Desktop/dblp.xml"));
		BufferedWriter out = new BufferedWriter(new FileWriter(
				"C:/Users/Atenea/Desktop/dblp-noHTMLEncoding.xml"));

		String line;
		while ((line = in.readLine()) != null) {
			
	
				String newLine = line;
				while (newLine.contains("&#") && newLine.contains(";")) {
					newLine = newLine.replaceFirst("\\&\\#.*\\;", "");
				}
				while (newLine.contains("&") && newLine.contains(";")){
					newLine = newLine.replaceFirst("\\&[a-zA-Z].*?\\;", newLine.charAt(newLine.indexOf("&") + 1) + ""); 
				}
				if (newLine.contains("<sup>")){ //Superindex
					newLine = newLine.replace("<sup>", "");
				}
				if (newLine.contains("</sup>")){
					newLine = newLine.replace("</sup>", "");
				}
				if (newLine.contains("<sub>")){ //Subindex
					newLine = newLine.replace("<sub>", "");
				}
				if (newLine.contains("</sub>")){
					newLine = newLine.replace("</sub>", "");
				}
				if (newLine.contains("<i>")){ //italic
					newLine = newLine.replace("<i>", "");
				}
				if (newLine.contains("</i>")){
					newLine = newLine.replace("</i>", "");
				}
				if (newLine.contains("<b>")){ //bold
					newLine = newLine.replace("<b>", "");
				}
				if (newLine.contains("</b>")){
					newLine = newLine.replace("</b>", "");
				}
				/** Mistakes found that must be corrected, otherwise the XML file is not well-formed */
				if (newLine.contains("<author bibtex=\"Hans {Kleine Buning</author>")){
					newLine = newLine.replace("<author bibtex=\"Hans {Kleine Buning</author>", "<author> Hans Kleine Buning</author>");
				}
				if (newLine.contains("<author bibtex=\"Luis {de la Fuente Valentin</author>")){
					newLine = newLine.replace("<author bibtex=\"Luis {de la Fuente Valentin</author>", "");
				}
				/***/
				out.write(newLine);
	
//			 System.out.println(line);
		}
		in.close();
		out.close();
		System.out.println("Done!");
	}

}
