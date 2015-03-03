import jICMTAuthor.Conference;

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

public class DBLP_v5 implements ITransformation {

	private static final String RULE_1 = "rule 1";
	IArea srcArea, trgArea;
	final int year = 2010;

	public DBLP_v5(IArea srcArea, IArea trgArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
	}

	@Override
	public void transform(
			Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException {
		Collection<IdentifiableElement> outObjs = new LinkedList<IdentifiableElement>();
		for (Object o : objs) {
			if (o instanceof Author) {
				Author a = ((Author) o);
				String[] recordsIds = a.getRecords();
				boolean active = false;
				boolean istAuthor = false;
				int k = 0;
				List<Article> inProc = new LinkedList<Article>();
				while (!active && k < recordsIds.length) {
					IdentifiableElement elem = srcArea.read(recordsIds[k]);
					if (elem instanceof Article){
						inProc.add((Article)elem);
						String journalId = ((Article) elem).getJournalId();
						Journal j = (Journal) srcArea.read(journalId);
						if (j!=null && j.getName().contains("Information & Software Technology")){
							istAuthor = true;
							if (istAuthor && ((Article) elem).getYear() >= year) {
								active = true;
							}
						}
					}
					k++;
				}
				if(istAuthor && active){
					LinkedList<Conference> journals = journals(inProc);
					String[] ids = getIds(journals);
					jICMTAuthor.Author exA = new jICMTAuthor.Author(
							TraceFunction.create(a.getId(), RULE_1), a.getName(), -1, active, ids, null);		
					outObjs.add(exA);
					outObjs.addAll(journals);
//					System.out.println(exA);
				}
			}
		}
		trgArea.writeAll(outObjs);
	}
	
	private String[] getIds(List<Conference> conferences) {
		String ids[] = new String[conferences.size()];
		for (int i=0; i<conferences.size(); i++){
			ids[i] = conferences.get(i).getId();
		}
		return ids;
	}

	private LinkedList<Conference> journals(List<Article> articles) throws BlackboardException {
		/**
		 * Conferences in which the author is now publishing
		 */
		LinkedList<Conference> outObjs = new LinkedList<Conference>();
		for (Article a : articles){
			if (a.getYear()>=year){
				String journalId = ((Article) a).getJournalId();
				Journal j = (Journal) srcArea.read(journalId);
				Conference conference = new jICMTAuthor.Conference(TraceFunction.create(a.getId(), RULE_1), j.getName());
				outObjs.add(conference);
//				if (!outObjs.contains(conference)){
//					outObjs.add(conference);
//				}
			}
		}
		return outObjs;
	}
}
