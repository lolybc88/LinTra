import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import mm.*;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.TraceFunction;

public class DBLP2Coauthor implements ITransformation {

	IArea srcArea, trgArea;
	final String RuleDBLP2Coauthor = "dblp2coauthor"; 
	
	public DBLP2Coauthor(IArea srcArea, IArea trgArea) {
		this.srcArea = srcArea;
	}

	@Override
	public void transform(
			Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException {
		Collection<IdentifiableElement> outObjs = new LinkedList<IdentifiableElement>();
		for (Object o : objs) {
			if (o instanceof Author) {
				mm.Author a = ((mm.Author)o);
				String[] coauthorsIds = coauthors(a);
				jICMTAuthor.Author auth = new jICMTAuthor.Author(TraceFunction.create(a.getId(), RuleDBLP2Coauthor), a.getName(), -1, false, null, coauthorsIds);
				outObjs.add(auth);
			}
		}
		trgArea.writeAll(outObjs);
	}

	private String[] coauthors(Author a) throws BlackboardException {
		List<String> coauthorsIds = new LinkedList<String>();
		String[] recs = a.getRecords();
		for (String recId : recs){
			IdentifiableElement e = srcArea.read(recId);
			if (e != null && e instanceof Record) {
				for(String coAuthorId : ((Record) e).getAuthors()){
					coauthorsIds.add(TraceFunction.resolve(coAuthorId, RuleDBLP2Coauthor));
				}
			}
		}
		String[] coauthIds = remove(coauthorsIds, TraceFunction.resolve(a.getId(), RuleDBLP2Coauthor));
		return coauthIds;
	}

	private String[] remove(List<String> coauthorsIds, String id) {
		if (coauthorsIds!=null && coauthorsIds.size()>0){
			if (coauthorsIds.size()==1 && coauthorsIds.get(0).equals(id)){
				return null;
			} else {
				String[] ids = new String[coauthorsIds.size()-1];
				int j = 0;
				for (int i=0; i<coauthorsIds.size(); i++){
					if (j<ids.length && !coauthorsIds.get(i).equals(id)){
						ids[j] = coauthorsIds.get(i);
						j++;
					}
				}
				return ids;
			}
		} else {
			return null;
		}	
	}
}
