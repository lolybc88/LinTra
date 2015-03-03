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


public class Identity implements ITransformation{

	private static final String MOVIE2MOVIE = "movie";
	private static final String PERSON2PERSON = "person";
	IArea srcArea, trgArea;
	
	public Identity(IArea srcArea, IArea trgArea) {
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
			}
		}
		trgArea.writeAll(elems);
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
