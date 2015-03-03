import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import movies.MoviesFactory;
import movies.MoviesPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


public class XMIModelCreator {

	
	public static void main(String[] args) throws Exception {
		
		createSyntheticXMIModel(200000);
		System.out.println("Done!");
		
	}
	
	public static void createSyntheticXMIModel(int n) throws IOException{
		// Initialize the model
	    MoviesPackage.eINSTANCE.eClass();
	    // Retrieve the default factory singleton
	    MoviesFactory factory = MoviesFactory.eINSTANCE;
	    
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("*", new XMIResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // create a resource
	    Resource resource = resSet.createResource(URI.createURI("xmiModels/imdb-"+n+".xmi"));
	    
	    /** Create Model **/
	    for (int i=0; i<n; i++){
		    createPositive(factory, resource, i);
		    createNegative(factory, resource, i);
	    }
	    /** End model creation */

	    // now save the content.
	    try {
	      resource.save(Collections.EMPTY_MAP);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}

	private static void createPositive(MoviesFactory factory,
			Resource resource, int i) {
		movies.Movie movie1 = factory.createMovie(); movie1.setRating(10*i);
		movies.Movie movie2 = factory.createMovie(); movie2.setRating(10*i+1);
		movies.Movie movie3 = factory.createMovie(); movie3.setRating(10*i+2);
		movies.Movie movie4 = factory.createMovie(); movie4.setRating(10*i+3);
		movies.Movie movie5 = factory.createMovie(); movie5.setRating(10*i+4);
		
		movies.Actor actor1 = factory.createActor(); actor1.setName("a"+(10*i));
			actor1.getMovies().add(movie1);
			actor1.getMovies().add(movie2);
			actor1.getMovies().add(movie3);
			actor1.getMovies().add(movie4);
		movies.Actor actor2 = factory.createActor(); actor2.setName("a"+(10*i+1));
			actor2.getMovies().add(movie1);
			actor2.getMovies().add(movie2);
			actor2.getMovies().add(movie3);
			actor2.getMovies().add(movie4);
		movies.Actor actor3 = factory.createActor(); actor3.setName("a"+(10*i+2));
			actor3.getMovies().add(movie2);
			actor3.getMovies().add(movie3);
			actor3.getMovies().add(movie4);
		movies.Actor actor4 = factory.createActor(); actor4.setName("a"+(10*i+3));
			actor4.getMovies().add(movie2);
			actor4.getMovies().add(movie3);
			actor4.getMovies().add(movie4);
			actor4.getMovies().add(movie5);
		movies.Actor actor5 = factory.createActor(); actor5.setName("a"+(10*i+4));
			actor5.getMovies().add(movie2);
			actor4.getMovies().add(movie3);
			actor4.getMovies().add(movie4);
			actor4.getMovies().add(movie5);
		
		resource.getContents().add(movie1);
		resource.getContents().add(movie2);
		resource.getContents().add(movie3);
		resource.getContents().add(movie4);
		resource.getContents().add(movie5);
		resource.getContents().add(actor1);
		resource.getContents().add(actor2);
		resource.getContents().add(actor3);
		resource.getContents().add(actor4);
		resource.getContents().add(actor5);
	}

	private static void createNegative(MoviesFactory factory,
			Resource resource, int i) {
		
		movies.Movie movie1 = factory.createMovie(); movie1.setRating(10*i+5);
		movies.Movie movie2 = factory.createMovie(); movie2.setRating(10*i+6);
		movies.Movie movie3 = factory.createMovie(); movie3.setRating(10*i+7);
		movies.Movie movie4 = factory.createMovie(); movie4.setRating(10*i+8);
		movies.Movie movie5 = factory.createMovie(); movie5.setRating(10*i+9);
		
		movies.Actor actor1 = factory.createActor(); actor1.setName("a"+(10*i+5));
			actor1.getMovies().add(movie1);
			actor1.getMovies().add(movie2);
		movies.Actor actor2 = factory.createActor(); actor2.setName("a"+(10*i+6));
			actor2.getMovies().add(movie1);
			actor2.getMovies().add(movie2);
			actor2.getMovies().add(movie3);
		movies.Actor actor3 = factory.createActor(); actor3.setName("a"+(10*i+7));
			actor3.getMovies().add(movie2);
			actor3.getMovies().add(movie3);
			actor3.getMovies().add(movie4);
		movies.Actor actor4 = factory.createActor(); actor4.setName("a"+(10*i+8));
			actor4.getMovies().add(movie3);
			actor4.getMovies().add(movie4);
			actor4.getMovies().add(movie5);
		movies.Actor actor5 = factory.createActor(); actor5.setName("a"+(10*i+9));
			actor4.getMovies().add(movie4);
			actor4.getMovies().add(movie5);
		
		resource.getContents().add(movie1);
		resource.getContents().add(movie2);
		resource.getContents().add(movie3);
		resource.getContents().add(movie4);
		resource.getContents().add(movie5);
		resource.getContents().add(actor1);
		resource.getContents().add(actor2);
		resource.getContents().add(actor3);
		resource.getContents().add(actor4);
		resource.getContents().add(actor5);
	}
}