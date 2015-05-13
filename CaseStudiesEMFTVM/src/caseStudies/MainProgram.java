package caseStudies;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import javaMM.JavaMMPackage;
import movies.impl.MoviesPackageImpl;

import org.eclipse.m2m.atl.core.*;

import DBLP.impl.DBLPPackageImpl;
import GraphMM.impl.GraphMMPackageImpl;
import ICMTAuthor.impl.ICMTAuthorPackageImpl;

public class MainProgram {

	public static void main(String[] args) throws Exception {
		
//		imbd();
		
//		dblp();
		
//		java2graph();
		
		public2private();
		
	}

	private static void public2private() throws Exception {
		FileWriter fw = new FileWriter("/home/loli/execTime.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		String[] cc = { "0.1"/*, "0.2", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "all"*/ };
		for (String c : cc) {
			System.out.println("-- " + c + " --");
			bw.write(c+"\n");

			for (int i=0; i<1; i++){
//				 String model = "file://C:/Users/Atenea/Desktop/eclipseModel/eclipseModels-CaseStudy/eclipseModel-"+c+".xmi";
//				 String model = "file://C:/Users/Loli/Dropbox/PhD/Atenea02/wsLinTra/CaseStudies/eclipseModel-0.1.xmi";
	
				String model = "/home/loli/IST_2014/eclip/xmi/eclipseModel-" + c + ".xmi";
//				String model = "file:C:/Users/Loli/Desktop/LinTraGit/CaseStudiesEMFTVM/public2private/Blackboard_java.xmi";
				
				TransfoRunnerInplaceEMFTVM tr2 = new TransfoRunnerInplaceEMFTVM();
				double t = tr2.runTransformation(
						"http://www.eclipse.org/MoDisco/Java/0.2.incubation/java", JavaMMPackage.eINSTANCE, "Java",
						model, "public2private/out.xmi", "public2private/", "Public2Private");
				
				System.out.println(t);
				bw.write(t+"\n");
				bw.flush();
			}
		}
		bw.close();
		
	}

	private static void java2graph() throws MalformedURLException, FileNotFoundException, ATLCoreException, IOException {
		FileWriter fw = new FileWriter("/home/loli/execTime.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		String[] cc = { /*"0.1", "0.2", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0",*/ "3.5", "4.0", "all" };
		for (String c : cc) {
			System.out.println("-- " + c + " --");
			bw.write(c+"\n");

			for (int i=0; i<1; i++){
//				 String model = "file://C:/Users/Atenea/Desktop/eclipseModel/eclipseModels-CaseStudy/eclipseModel-"+c+".xmi";
//				 String model = "file://C:/Users/Loli/Dropbox/PhD/Atenea02/wsLinTra/CaseStudies/eclipseModel-0.1.xmi";
	
				String model = "/home/loli/IST_2014/eclip/xmi/eclipseModel-" + c + ".xmi";
	
				TransfoRunnerEMFTVM tr2 = new TransfoRunnerEMFTVM();
				
				double t = tr2.runTransformation("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java", JavaMMPackage.eINSTANCE, "MM",
						"http://www.eclipse.org/MoDisco/Java/0.2.incubation/java", JavaMMPackage.eINSTANCE, "MM1", model,
						"java2graph/out.xmi", "java2graph/", "IdentityJava");
				
//				double t = tr2.runTransformation("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java", JavaMMPackage.eINSTANCE, "MM",
//						"http://graph", GraphMMPackageImpl.eINSTANCE, "MM1", model,
//						"java2graph/out.xmi", "java2graph/", "Java2Graph");
				
//				double t = tr2.runTransformation("http://graph", JavaMMPackage.eINSTANCE, "MM",
//						"http://graph", GraphMMPackageImpl.eINSTANCE, "MM1", model, 
//						"java2graph/out.xmi", "java2graph/", "ReduceGraph");
				
				System.out.println(t);
				bw.write(t+"\n");
				bw.flush();
			}
		}
		bw.close();
	}

	private static void dblp() throws MalformedURLException, FileNotFoundException, ATLCoreException, IOException {
		
	
//		for (int i = 0; i < 10; i++) {
			TransfoRunnerEMFTVM tr2 = new TransfoRunnerEMFTVM();
			double t = tr2.runTransformation("http://dblp.com", DBLPPackageImpl.eINSTANCE, "MM",
					"http://AuthorInfo", ICMTAuthorPackageImpl.eINSTANCE, "MM1", "dblp/dblp.xmi",
					"dblp/out.xmi", "dblp/", "DBLP_v2");
			System.out.println(t);

//		}
		
	}

	private static void imbd() throws ATLCoreException, IOException,
			MalformedURLException, FileNotFoundException {
		String[] cc = {
//				"imdb-0010400-100024.xmi",
//				"imdb-0027800-200319.xmi",
//				"imdb-0084400-500716.xmi",
//				"imdb-0200000-1013510.xmi",
//				"imdb-0335000-1511287.xmi",
//				"imdb-0492000-2019707.xmi",
				"imdb-0650000-2509987.xmi",
//				"imdb-0820000-3017435.xmi",
//				"imdb-all-3531618.xmi"
				};
		for (String c : cc){
			System.out.println("-- " + c + " --");
			for (int i = 0; i < 5; i++) {
		TransfoRunnerEMFTVM tr2 = new TransfoRunnerEMFTVM();
		double t = tr2.runTransformation("http://movies/1.0", MoviesPackageImpl.eINSTANCE, "MM",
							  "http://movies/1.0", MoviesPackageImpl.eINSTANCE, "MM1",
							  "/home/loli/IST_2014/imdb/xmi/"+c, "imdb/out.xmi",
							  "imdb/", "FindCouplesIMDb");
		System.out.println(t);
		tr2 = null;
		System.gc();
			}
		}
	}
	
}
