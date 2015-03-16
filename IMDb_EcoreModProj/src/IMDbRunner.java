import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import movies.MoviesFactory;
import movies.MoviesPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import jIMDb.Actor;
import jIMDb.Movie;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import runners.MTLauncher1Input1Output;
import transfo.LinTraParameters;


public class IMDbRunner {

	public static void main(String[] args) throws Exception {
		
		String modelPath = "/home/loli/IST_2014/imdb/ser/";
//		String modelPath = "C:/Users/Atenea/Desktop/IMDb_/models/";
		
		String[] model = {
//				"imdb-0010400-100024",
//				"imdb-0027800-200319",
//				"imdb-0084400-500716",
//				"imdb-0200000-1013510",
//				"imdb-0335000-1511287",
//				"imdb-0492000-2019707",
//				"imdb-0650000-2509987",
//				"imdb-0820000-3017435",
//				"imdb-all-3531618"
				};
		
		MTLauncher1Input1Output mtLauncher = new MTLauncher1Input1Output();
		mtLauncher.createBlackboard();
		
//		for (int k=0; k<model.length; k++){
//			System.out.println(model[k]);
			
			createSyntheticData(1*10000, mtLauncher.getSrcArea());
//			mtLauncher.loadModel(modelPath+model[k]+".ser");
			System.out.println("MoDel loaDeD");
			
			for (int i=0;i<1;i++) {
			
				int numThreads = LinTraParameters.NUMBER_OF_THREADS_T1;
				double time = mtLauncher.launch(new Identity(mtLauncher.getSrcArea(), mtLauncher.getTrgArea()), numThreads);
		
				System.out.println(time);
				System.out.println("Num elements src: " + mtLauncher.getSrcArea().size());
				System.out.println("Num elements trg: " + mtLauncher.getTrgArea().size());
			
				mtLauncher.getTrgArea().clear();
//			}
			mtLauncher.getSrcArea().clear();
		}
		mtLauncher.destroy();
		
	}
	
	public static void createSyntheticXMIModel(int n, String path) throws IOException{
		// Initialize the model
	    MoviesPackage.eINSTANCE.eClass();
	    // Retrieve the default factory singleton
	    MoviesFactory factory = MoviesFactory.eINSTANCE;
	    
	    
	    movies.Movie movie = factory.createMovie();
	    movies.Actor actor = factory.createActor();
	    actor.setName("index");
	    movie.getPersons().add(actor);
	    
	    
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("movies", new XMIResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // create a resource
	    Resource resource = resSet.createResource(URI.createURI("movies/My2.movies"));
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    resource.getContents().add(movie);

	    // now save the content.
	    try {
	      resource.save(Collections.EMPTY_MAP);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
//	
//	public static void createSyntheticSERModel(int n, String path) throws IOException{
//		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
//		
//		for(int i=0; i<n; i++){
//			
//			createPoSitive(elems, i); 
//			
//			createNegative(elems, i);
//		}
//		
//		FileOutputStream fw = new FileOutputStream(path);
//		ObjectOutputStream bw = new ObjectOutputStream(fw);
//		for (IdentifiableElement ie : elems){
//			bw.writeObject(ie);
//		}
//		bw.close();
//		fw.close();
//	}
//	
	public static void createSyntheticData(int n, IArea area) throws BlackboardException{
		
		for(int i=0; i<n; i++){
			try {
			createPoSitive(area, i); 
			createNegative(area, i);
			} catch (OutOfMemoryError | NumberFormatException e){
				System.out.println(i-1);
				e.printStackTrace();
			}
		}
	}

	private static void createNegative(IArea area, int i) throws BlackboardException {
		
		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		
		String[] personsIds6 = {Double.toString(20*i+16), Double.toString(20*i+17)};
		Movie m6 = new Movie(Double.toString(20*i+11), personsIds6, "", 10*i+5, 2014, null);
		
		String[] personsIds7 = {Double.toString(20*i+16), Double.toString(20*i+17), Double.toString(20*i+18)};
		Movie m7 = new Movie(Double.toString(20*i+12), personsIds7, "", 10*i+6, 2014, null);
		
		String[] personsIds8 = {Double.toString(20*i+17), Double.toString(20*i+18), Double.toString(20*i+19)};
		Movie m8 = new Movie(Double.toString(20*i+13), personsIds8, "", 10*i+7, 2014, null);
		
		String[] personsIds9 = {Double.toString(20*i+18), Double.toString(20*i+19), Double.toString(20*i+20)};
		Movie m9 = new Movie(Double.toString(20*i+14), personsIds9, "", 10*i+8, 2014, null);
		
		String[] personsIds10 = {Double.toString(20*i+19), Double.toString(20*i+20)};
		Movie m10 = new Movie(Double.toString(20*i+15), personsIds10, "", 10*i+9, 2014, null);
		/***/
		String[] moviesIds11 = {Double.toString(20*i+11), Double.toString(20*i+12)};
		Actor a11 = new Actor(Double.toString(20*i+16), moviesIds11, "a"+Double.toString(10*i+5));
		
		String[] moviesIds12 = {Double.toString(20*i+11), Double.toString(20*i+12), Double.toString(20*i+13)};
		Actor a12 = new Actor(Double.toString(20*i+17), moviesIds12, "a"+Double.toString(10*i+6));
		
		String[] moviesIds13 = {Double.toString(20*i+12), Double.toString(20*i+13), Double.toString(20*i+14)};
		Actor a13 = new Actor(Double.toString(20*i+18), moviesIds13, "a"+Double.toString(10*i+7));
		
		String[] moviesIds14 = {Double.toString(20*i+13), Double.toString(20*i+14), Double.toString(20*i+15)};
		Actor a14 = new Actor(Double.toString(20*i+19), moviesIds14, "a"+Double.toString(10*i+8));
		
		String[] moviesIds15 = {Double.toString(20*i+14), Double.toString(20*i+15)};
		Actor a15 = new Actor(Double.toString(20*i+20), moviesIds15, "a"+Double.toString(10*i+9));
		
		elems.add(m6); elems.add(m7); elems.add(m8); elems.add(m9); elems.add(m10);
		elems.add(a11); elems.add(a12); elems.add(a13); elems.add(a14); elems.add(a15);
		
		area.writeAll(elems);
	}

	private static void createPoSitive(IArea area, int i) throws BlackboardException {
		
		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		
		String[] personsIds1 = {Double.toString(20*i+6), Double.toString(20*i+7)};
		Movie m1 = new Movie(Double.toString(20*i+1), personsIds1, "", 10*i, 2014, null);
		
		String[] personsIds2 = {Double.toString(20*i+6), Double.toString(20*i+7), Double.toString(20*i+8), Double.toString(20*i+9), Double.toString(20*i+10)};
		Movie m2 = new Movie(Double.toString(20*i+2), personsIds2, "", 10*i+1, 2014, null);
		
		String[] personsIds3 = {Double.toString(20*i+6), Double.toString(20*i+7), Double.toString(20*i+8), Double.toString(20*i+9), Double.toString(20*i+10)};
		Movie m3 = new Movie(Double.toString(20*i+3), personsIds3, "", 10*i+2, 2014, null);
		
		String[] personsIds4 = {Double.toString(20*i+6), Double.toString(20*i+7), Double.toString(20*i+8), Double.toString(20*i+9), Double.toString(20*i+10)};
		Movie m4 = new Movie(Double.toString(20*i+4), personsIds4, "", 10*i+3, 2014, null);
		
		String[] personsIds5 = {Double.toString(20*i+9), Double.toString(20*i+10)};
		Movie m5 = new Movie(Double.toString(20*i+5), personsIds5, "", 10*i+4, 2014, null);
		/***/
		String[] moviesIds1 = {m1.getId(), m2.getId(), m3.getId(), m4.getId()};
		Actor a1 = new Actor(Double.toString(20*i+6), moviesIds1, "a"+Double.toString(10*i));
		
		String[] moviesIds2 = {m1.getId(), m2.getId(), m3.getId(), m4.getId()};
		Actor a2 = new Actor(Double.toString(20*i+7), moviesIds2, "a"+Double.toString(10*i+1));
		
		String[] moviesIds3 = {m2.getId(), m3.getId(), m4.getId()};
		Actor a3 = new Actor(Double.toString(20*i+8), moviesIds3, "a"+Double.toString(10*i+2));
		
		String[] moviesIds4 = {m2.getId(), m3.getId(), m4.getId(), m5.getId()};
		Actor a4 = new Actor(Double.toString(20*i+9), moviesIds4, "a"+Double.toString(10*i+3));
		
		String[] moviesIds5 = {m2.getId(), m3.getId(), m4.getId(), m5.getId(), m5.getId()};
		Actor a5 = new Actor(Double.toString(20*i+10), moviesIds5, "a"+Double.toString(10*i+4));
		
		elems.add(m1); elems.add(m2); elems.add(m3); elems.add(m4); elems.add(m5);
		elems.add(a1); elems.add(a2); elems.add(a3); elems.add(a4); elems.add(a5);
		
		area.writeAll(elems);
	}
}
