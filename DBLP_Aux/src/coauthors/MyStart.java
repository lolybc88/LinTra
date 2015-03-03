package coauthors;

import java.util.Map;

import DBLP.impl.AuthorImpl;

public class MyStart {
       
    private static void path(Person p1, Person p2) {
        CoauthorPath cp = new CoauthorPath(p1,p2);
        Person path[] = cp.getPath();
        int i;
        System.out.println("# of Person objects = " + Person.numberOfPersons());
        if (path == null) {
            System.out.println("<"+p1+","+p2+"> not connected");
            return;
        }
        
        for (i=0; i<path.length; i++) {
            System.out.println(i + ": " + path[i] + " " + 
                    path[i].getNumberOfPublications() + " " +
                    (path[i].getPersonRecord()==null?" ":"*"));
        }
        System.out.println();
    }
    
	private static String buildURI(AuthorImpl author) {
		
		/**
		 * Work on this!!! For example: "Alan T. Murray" -> "m/Murray:Alan_T="
		 */
		String s;
		if (!author.getName().contains(" ")){
			s = author.getName().substring(0, 1) + "/" + author.getName();
		} else {
			String name = author.getName().substring(0, author.getName().indexOf(" "));
			String surname = author.getName().substring(author.getName().indexOf(" ")+1, author.getName().length());
			String extra = "";
			if (surname.contains(" ")){
				extra = surname.substring(0, surname.indexOf(" "));
				surname = surname.substring(surname.indexOf(" ")+1, surname.length());
			}
			s = surname.substring(0, 1).toLowerCase()+"/" +surname+":"+name;
			if (!extra.equals("")){
				s = s + "_" +extra;
			}
		}
		s.replace(".", "=");
		s.replace("-", "=");
		return s;
	}
    
    public static void main(String[] args) throws InterruptedException {
    	
    	ParserAuthors pa = new ParserAuthors("C:/Users/Atenea/Desktop/dblp-noHTMLEncoding.xml");
    	Map<String, AuthorImpl> authors = pa.getAuthors();
    	
    	for (AuthorImpl a : authors.values()){
    		System.out.println(a);
    		String uri = buildURI(a); // System.out.println(uri);
    		Person pNow = Person.create(a.getName(), uri);
    		Person ca[] = pNow.getCoauthors();
    		for (Person p : ca) {
    			System.out.println("\t"+p);
    		}
    		Thread.sleep(1100); //The server doesn't allow us to make so many requests. We have to wait at least 1 second between a request and the following one.
    	}
    	
//		AuthorImpl author = new AuthorImpl();
//		author.setName("Michael Ley");
//		String uri = buildURI(author);
//		System.out.println(uri);
//		
//		Person pNow = Person.create(author.getName(), uri);
//		Person ca[] = pNow.getCoauthors();
//		for (Person p : ca) {
//			System.out.println(p);
//		}
    }

}
