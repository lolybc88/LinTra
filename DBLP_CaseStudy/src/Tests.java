import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Tests {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		

//		print("/home/loli/IST_2014/dblp.xmi", "/home/loli/IST_2014/dblp.xmi2");
		
		copy("/home/loli/IST_2014/dblp.xmi", "/home/loli/IST_2014/dblp.xmi2");
		
	}
	
	private static void copy(String inPath, String outPath) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(inPath);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(outPath);
		BufferedWriter bw = new BufferedWriter(fw);
		
		int n = 1;
		String line = br.readLine();
		while (line!=null && n<10000){
			bw.write(line+"\n");
			n++;
			line = br.readLine();
		}
		br.close();
		bw.close();
	}
	
	private static void print(String inPath, String outPath) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(inPath);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(outPath);
		BufferedWriter bw = new BufferedWriter(fw);
		
		int n = 1;
		String line = br.readLine();
		while (line!=null/* && n<500*/){
//			if (n==1508399){
//				System.out.println(line);
//			}
			if (line.contains("<DBLP:Article") && line.contains("volume")){
//				System.out.println(line);
				line = line.replaceAll("volume=\".*\"", "");
//				System.out.println(line);
			}
			bw.write(line+"\n");
//			line = line.replaceAll("[^a-zA-Z0-9\\s<>:\"=/,;#\\.\\&?]", "");
			line  = br.readLine();
			n++;
		}
		br.close();
		bw.close();
	}

}
