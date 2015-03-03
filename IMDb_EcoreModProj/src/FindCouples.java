import jIMDb.Actor;
import jIMDb.Couple;
import jIMDb.Movie;
import jIMDb.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import blackboard.SearchByIdRange;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.TraceFunction;


public class FindCouples implements ITransformation{

	private static final String CREATECOUPLE = "couples";
	private static final String MOVIE2MOVIE = "movie";
	private static final String PERSON2PERSON = "person";
	IArea srcArea, trgArea;
	
	public FindCouples(IArea srcArea, IArea trgArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
	}

	@Override
	public void transform(Collection<IdentifiableElement> objs, IMaster masterNextTransfo)
			throws BlackboardException {
		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
		
		for (IdentifiableElement e : objs){
			if (e instanceof jIMDb.Movie){
				elems.add(createMovie(e));
			} else if (e instanceof jIMDb.Person){
				elems.add(createPerson(e));
				List<Couple> c = createCouplesIfApplicable((Person)e);
				if (c!=null && !c.isEmpty()){
					elems.addAll(c);
				}
			}
		}
		trgArea.writeAll(elems);
	}

	private List<Couple> createCouplesIfApplicable(jIMDb.Person p1) throws BlackboardException {
		List<Couple> couples = new LinkedList<Couple>();
		
		List<IdentifiableElement> persons = getCoactors(p1);
			
		for (IdentifiableElement ie : persons){
			Person p2 = (Person) ie;
			if (p1.getName().compareTo(p2.getName())<0){
				Couple c = createCoupleIfApplicable(p1, p2);
				if (c!=null){
					couples.add(c);
				}
			}
		}
		return couples;
	}

	private List<IdentifiableElement> getCoactors(Person p1) throws BlackboardException {
		Set<String> coactorsIds = new HashSet<String>();
		
		for (String id : p1.getMovies()){
			Movie m = (Movie) srcArea.read(id);
			coactorsIds.addAll(toList(m.getPersons()));
		}
		coactorsIds.remove(p1.getId());
		List<IdentifiableElement> persons = (List<IdentifiableElement>) srcArea.readAll(coactorsIds);
		return persons;
	}

	private List<String> toList(String[] persons) {
		List<String> ids = new LinkedList<String>();
		for (String id : persons){
			ids.add(id);
		}
		return ids;
	}

	private Couple createCoupleIfApplicable(Person p1, Person p2) {
		String[] commonMovies = intersection(p1.getMovies(), p2.getMovies());
		if (commonMovies.length>=3){
			Couple c = new Couple(TraceFunction.create(p1.getId(), p2.getId(), CREATECOUPLE),
					TraceFunction.resolveAll(commonMovies, MOVIE2MOVIE),
					0.0,
					TraceFunction.resolve(p1.getId(), PERSON2PERSON),
					TraceFunction.resolve(p2.getId(), PERSON2PERSON));
			return c;
		}
		return null;
	}

	private String[] intersection(String[] movies, String[] movies2) {
		
		List<String> commonMovies = new LinkedList<String>();		
		for (String m : movies){
			int j = 0;
			boolean found = false;
			while (!found && j<movies2.length){
				if (m.equals(movies2[j])){
					found = true;
					commonMovies.add(m);
				}
				j++;
			}
		}
		return toArray(commonMovies);
	}

	private String[] toArray(List<String> commonMovies) {
		String[] ids = new String[commonMovies.size()];
		for (int i=0; i<commonMovies.size(); i++){
			ids[i] = commonMovies.get(i);
		}
		return ids;
	}

	private IdentifiableElement createPerson(IdentifiableElement e) {
		if (e instanceof Actor){
			Actor a = (Actor) e;
			jIMDb.Actor jActor = new jIMDb.Actor(TraceFunction.create(e.getId(), PERSON2PERSON),
					TraceFunction.resolveAll(((Actor) e).getMovies(), MOVIE2MOVIE), a.getName());
			return jActor;
		}
		if (e instanceof jIMDb.Actress){
			jIMDb.Actress a = (jIMDb.Actress) e;
			jIMDb.Actress jActress = new jIMDb.Actress(TraceFunction.create(e.getId(), PERSON2PERSON),
					TraceFunction.resolveAll(((Actor) e).getMovies(), MOVIE2MOVIE), a.getName());
			return jActress;
		}
		return null;
	}

	private IdentifiableElement createMovie(IdentifiableElement e) {
		jIMDb.Movie mov = (jIMDb.Movie) e;
		jIMDb.Movie jmov = new Movie(TraceFunction.create(e.getId(), MOVIE2MOVIE),
				TraceFunction.resolveAll(mov.getPersons(), PERSON2PERSON), mov.getTitle(), mov.getRating(),
				mov.getYear(), mov.getType());
		return jmov;
	}

}
