package xml2xmiSAX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class readAndPrint {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(
				"C:/Users/Atenea/Desktop/DBLP/dblp.xml"));
		
		BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/Atenea/Desktop/dblp-part0.xml"));

		String line;
		int lines = 0;
		while ((line = in.readLine()) != null) {
//			if (lines==0 || lines==1 || lines>0){
//				if (!line.equals("")){
//					out.write(line+"\n");
//				}
//			}
			System.out.println(line);
			lines++;
		}
		System.out.println(lines);
		in.close();
		out.close();
		System.out.println("Done!");

	}

}
