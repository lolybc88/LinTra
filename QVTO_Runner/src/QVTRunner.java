
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javaMM.JavaMMPackage;
import movies.MoviesPackage;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import DBLP.DBLPPackage;
import GraphMM.GraphMMPackage;
import ICMTAuthor.ICMTAuthorPackage;

public class QVTRunner {
	
	public static void main(String[] args) throws Exception {
		
//		benchmarkIMDb();

//		benchmarkDBLP();
		
		benchmarkJava2Graph();
		
	}
	
	private static void benchmarkJava2Graph() throws Exception {
		
		JavaMMPackage.eINSTANCE.eClass();
		GraphMMPackage.eINSTANCE.eClass();
		
		String[] cc = {/* "0.1", "0.2", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5",*/ "4.0", "all" };
		for (String c : cc) {
			System.out.println("-- " + c + " --");

//			 String transfo = "file://C:/Users/Loli/Dropbox/PhD/Atenea02/wsLinTra/CaseStudiesQVTO/transforms/IdentityJava.qvto";
			// String model = "file://C:/Users/Atenea/Desktop/eclipseModel/eclipseModels-CaseStudy/eclipseModel-0.1.xmi";
//			 String model = "file://C:/Users/Loli/Dropbox/PhD/Atenea02/wsLinTra/CaseStudies/eclipseModel-0.1.xmi";

			String transfo = "file:/home/loli/Dropbox/atenea02.gisum/wsLinTra/CaseStudiesQVTO/transforms/Java2Graph.qvto";
			String model = "/home/loli/IST_2014/eclip/xmi/eclipseModel-" + c + ".xmi";

			QVTRunner runner = new QVTRunner();
			runner.runNtimes(model, transfo, 10);
		}
	}

	private static void benchmarkDBLP() throws Exception {

		DBLPPackage.eINSTANCE.eClass();
		ICMTAuthorPackage.eINSTANCE.eClass();
		
		String transfo = "file://C:/Users/Atenea/Dropbox/PhD/Atenea02/wsLinTra/CaseStudiesQVTO/transforms/IdentityDBLP.qvto";
		String model = "file://C:/Users/Atenea/Dropbox/PhD/Atenea02/wsLinTra/CaseStudies/simpleDBLP.xmi";
		
//		String transfo = "file:/home/loli/Dropbox/atenea02.gisum/wsLinTra/CaseStudiesQVTO/transforms/IdentityDBLP.qvto";
//		String model = "/home/loli/Dropbox/atenea02.gisum/wsLinTra/CaseStudies/simpleDBLP.xmi";
		//    /home/loli/Dropbox/atenea02.gisum/wsLinTra/CaseStudies/simpleDBLP.xmi
		QVTRunner runner = new QVTRunner();
		runner.runNtimes(model, transfo, 1);
		
	}

	private static void benchmarkIMDb() throws Exception {
		
		MoviesPackage.eINSTANCE.eClass();
		
//		String transfo = "file://C:/Users/Atenea/Dropbox/PhD/Atenea02/wsLinTra/CaseStudiesQVTO/transforms/FindCouples.qvto";
//		String model = "file://C:/Users/Atenea/Desktop/IMDb_/models/imdb-0010400-100024.xmi";
		
		String transfo = "file:/home/loli/Dropbox/atenea02.gisum/wsLinTra/CaseStudiesQVTO/transforms/IdentityIMDb.qvto";
		String model = "/home/loli/IST_2014/imdb/xmi/imdb-all-3531618.xmi";
		
		System.out.println("*** " + model + " ***");
		QVTRunner runner = new QVTRunner();
		runner.runNtimes(model, transfo, 5);
		
	}
	
	private void runNtimes(String model, String trafo, int times) throws Exception {
		for (int i = 1; i <= times; i++){
			double time = this.execute(model, trafo);
			System.out.println(time);
		}
	}
	
	public double execute(String from, String with) throws Exception {
		URI transformationURI = URI.createURI(with);
		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put("ecore", new EcoreResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource inResource = resourceSet.getResource(
				URI.createURI(from), true);		
		EList<EObject> inObjects = inResource.getContents();

		ModelExtent input = new BasicModelExtent(inObjects);		
		ModelExtent output = new BasicModelExtent();

		ExecutionContextImpl context = new ExecutionContextImpl();
		
		double startTime = System.currentTimeMillis();
		
		//ExecutionDiagnostic result = executor.execute(context, input, output);
		ExecutionDiagnostic result = executor.execute(context, input, output);
		
		double stopTime = System.currentTimeMillis();
		double elapsedTime = stopTime - startTime;
//		System.out.println("Transformation runtime (ms): /t" + elapsedTime);

		
 		// This code may be used to save the output model
		if(result.getSeverity() == Diagnostic.OK) {
			List<EObject> outObjects = output.getContents();
		    ResourceSet resourceSet2 = new ResourceSetImpl();
			Resource outResource = resourceSet2.createResource(
					URI.createURI(from.replaceFirst(".xmi", "out.xmi")));
			outResource.getContents().addAll(outObjects);
			outResource.save(Collections.emptyMap());
			
			outResource.unload();
		} else {		
			System.out.println(result.getMessage());
		} 
		
		inResource.unload();
		return elapsedTime / 1000;
		
	}

	public double execute(String from1, String from2, String with) throws Exception {
		URI transformationURI = URI.createURI(with);
		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put("ecore", new EcoreResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource inResource = resourceSet.getResource(
				URI.createURI(from1), true);		
		EList<EObject> inObjects = inResource.getContents();
		ModelExtent input = new BasicModelExtent(inObjects);	
		
		Resource inResource2 = resourceSet.getResource(
				URI.createURI(from2), true);		
		EList<EObject> inObjects2 = inResource2.getContents();
		ModelExtent input2 = new BasicModelExtent(inObjects2);
		
		ModelExtent output = new BasicModelExtent();

		ExecutionContextImpl context = new ExecutionContextImpl();
		
		double startTime = System.currentTimeMillis();
		
		//ExecutionDiagnostic result = executor.execute(context, input, output);
		ExecutionDiagnostic result = executor.execute(context, input, input2, output);
		
		double stopTime = System.currentTimeMillis();
		double elapsedTime = stopTime - startTime;
//		System.out.println("Transformation runtime (ms): \t" + elapsedTime);

		
 		// This code may be used to save the output model
		if(result.getSeverity() == Diagnostic.OK) {
			List<EObject> outObjects = output.getContents();
		    ResourceSet resourceSet2 = new ResourceSetImpl();
			Resource outResource = resourceSet2.createResource(
					URI.createURI(from1.replaceFirst(".xmi", "out.xmi")));
			outResource.getContents().addAll(outObjects);
			outResource.save(Collections.emptyMap());
		} else {		
			System.out.println(result.getMessage());
		} 
		return elapsedTime / 1000;
	}
}
