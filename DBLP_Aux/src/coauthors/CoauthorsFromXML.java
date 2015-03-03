package coauthors;

import DBLP.impl.AuthorImpl;

public class CoauthorsFromXML {
	public static void main(String[] args) {
		
		AuthorImpl author = new AuthorImpl(); author.setName("Michael Ley");
		String uri = buildURI(author);
		System.out.println(uri);
		
	}

	private static String buildURI(AuthorImpl author) {
		String name = author.getName().substring(0, author.getName().indexOf(" "));
		String surname = author.getName().substring(author.getName().indexOf(" ")+1, author.getName().length());
		String s = "http://dblp.uni-trier.de/rec/pers/"+surname.substring(0, 1).toLowerCase()+"/" +surname+":"+name+"/xc";
		return s;
	}
}
