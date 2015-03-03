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

public class DBLP_v4 implements ITransformation {

	private static final String RULE_1 = "rule 1";
	IArea srcArea, trgArea;
	final int year = 2010;

	public DBLP_v4(IArea srcArea, IArea trgArea) {
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
				boolean icmtAuthor = false;
				int k = 0;
				List<InProceedings> inProc = new LinkedList<InProceedings>();
				while (!active && k < recordsIds.length) {
					IdentifiableElement elem = srcArea.read(recordsIds[k]);
					if (elem instanceof InProceedings){
						inProc.add((InProceedings)elem);
						if (((InProceedings) elem).getBooktitle().contains("ICMT")){
							icmtAuthor = true;
							if (icmtAuthor && ((InProceedings) elem).getYear() >= year) {
								active = true;
							}
						}
					}
					k++;
				}
				if(icmtAuthor && !active){
					LinkedList<Conference> conferences = conferences(inProc);
					String[] ids = getIds(conferences);
					jICMTAuthor.Author exA = new jICMTAuthor.Author(
							TraceFunction.create(a.getId(), RULE_1), a.getName(), -1, active, ids, null);		
					outObjs.add(exA);
					outObjs.addAll(conferences);
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

	private LinkedList<Conference> conferences(List<InProceedings> inProc) throws BlackboardException {
		/**
		 * Conferences in which the author is now publishing
		 */
		LinkedList<Conference> outObjs = new LinkedList<Conference>();
		for (InProceedings inP : inProc){
			if (inP.getYear()>=year){
				Conference conference = new jICMTAuthor.Conference(TraceFunction.create(inP.getId(), RULE_1), inP.getBooktitle());
				if (!outObjs.contains(conference)){
					outObjs.add(conference);
				}
			}
		}
		return outObjs;
	}
}
