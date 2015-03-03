import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import movies.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Parser {
	
	private static final String PERSON = "PERSON";
	private static final String MOVIE = "MOVIE";
	static Map<String, String> noNumericId2Id = new HashMap<String, String>();
	static double idCounter = 1;
	
	public static void main(String[] args) throws Exception {
		
//		String in = "C:/Users/Atenea/Dropbox/PhD/wsLinda/Movies_addRoot/imdb-all-3531618.xmi";
//		String out = "C:/Users/Atenea/Dropbox/PhD/wsLinda/Movies_addRoot/imdb-all-3531618-onlyAlphanumeric.xmi";
		
//		String in = "C:/Users/Loli/Dropbox/PhD/wsLinda/Movies_addRoot/imdb-0010000-97017.xmi";
//		String out = "C:/Users/Loli/Dropbox/PhD/wsLinda/Movies_addRoot/imdb-0010000-97017-onlyAlphanumeric.xmi";
		
//		String folder = "C:/Users/Atenea/Desktop/IMDb_/models/";
		String folder = "/home/loli/IST_2014/imdb/xmi/";
		String fileName = "imdb-all-3531618";
		
		String in = folder+fileName+".movies";
		String out = folder+fileName+".xmi";
		
		removeProblematicCharacters(in, out);
		
		eMF2Ser("file:"+out, folder+fileName+".ser");

		System.out.println("Done!");
		
	}

	private static void removeProblematicCharacters(String inPath, String outPath) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(inPath);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(outPath);
		BufferedWriter bw = new BufferedWriter(fw);
		
//		int n = 1;
		String line = br.readLine();
		while (line!=null/* && n<500*/){
//			System.out.println(line);
			line = line.replaceAll("[^a-zA-Z0-9\\s<>:\"=/,;#\\.\\&?]", "");
			bw.write(line+"\n");
			line  = br.readLine();
//			n++;
		}
		br.close();
		bw.close();
	}
	
	public static void eMF2Ser(String xMIPath, String serPath) throws IOException {
		MoviesPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(xMIPath), true);
		
		FileOutputStream saveFile = new FileOutputStream(serPath);
		ObjectOutputStream save = new ObjectOutputStream(saveFile);
		
		for (int i=0; i<resource.getContents().size(); i++){
			EObject e = resource.getContents().get(i);
			if (e instanceof Movie){
				Movie movie = (Movie) e;
				String noNumericId = MOVIE+ movie.getTitle()+movie.getYear()+movie.getRating()+movie.getPersons();
				String id = getOrGenerateId(noNumericId);
				jIMDb.Movie jMovie = new jIMDb.Movie(id, getPersonsids(movie.getPersons()), ((Movie) e).getTitle(), ((Movie) e).getRating(), ((Movie) e).getYear(), ((Movie) e).getType().toString());
				save.writeObject(jMovie);
			} else if (e instanceof Person){
				Person person = (Person) e;
				String noNumericId = PERSON + person.getName()+person.getMovies();
				String id = getOrGenerateId(noNumericId);
				if (e instanceof Actor){
					jIMDb.Actor jActor = new jIMDb.Actor(id, getMoviesIds(person.getMovies()), person.getName());
					save.writeObject(jActor);
				} else if (e instanceof Actress){
					jIMDb.Actress jActress = new jIMDb.Actress(id, getMoviesIds(person.getMovies()), person.getName());
					save.writeObject(jActress);
				}
			}
		}
		save.close();
	}
	
	private static String[] getMoviesIds(EList<Movie> movies) {
		if (movies != null) {
			String[] ids = new String[movies.size()];
			for (int i = 0; i < movies.size(); i++) {
				String key = MOVIE+ movies.get(i).getTitle()+movies.get(i).getYear()+movies.get(i).getRating()+movies.get(i).getPersons();
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

	private static String[] getPersonsids(EList<Person> persons) {
		if (persons != null) {
			String[] ids = new String[persons.size()];
			for (int i = 0; i < persons.size(); i++) {
				String key = PERSON+persons.get(i).getName()+persons.get(i).getMovies();
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

	private static String getOrGenerateId(String noNumericId) {
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
}
