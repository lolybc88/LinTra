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

public class DBLP_v3 implements ITransformation {

	IArea srcArea, trgArea;
	final int year = 2010;

	public DBLP_v3(IArea srcArea, IArea trgArea) {
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
				if (icmtAuthor){
					jICMTAuthor.Author exA = new jICMTAuthor.Author(
						TraceFunction.create(a.getId(), "rule 1"), a.getName(), -1, active, null, null);
					outObjs.add(exA);
				}
//				System.out.println(exA);
			}
		}
		trgArea.writeAll(outObjs);
	}

}
