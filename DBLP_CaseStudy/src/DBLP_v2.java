import java.util.Collection;
import java.util.LinkedList;

import mm.*;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.TraceFunction;

public class DBLP_v2 implements ITransformation {

	IArea srcArea, trgArea; 
	
	public DBLP_v2(IArea srcArea, IArea trgArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
	}

	@Override
	public void transform(
			Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException {
		Collection<IdentifiableElement> outObjs = new LinkedList<IdentifiableElement>();
		for (Object o : objs) {
			if (o instanceof Author) {
				Author a = ((Author)o);
				String[] recordsIds = ((Author)o).getRecords();
				int n = 0;
				for(String id : recordsIds){
					IdentifiableElement elem = srcArea.read(id);
					if (elem instanceof InProceedings && ((InProceedings)elem).getBooktitle().contains("ICMT")){
						n++;
					}
				}
				if (n>0){
					jICMTAuthor.Author icmtA = new jICMTAuthor.Author(TraceFunction.create(a.getId(), "rule 1"), a.getName(), n, false, null, null);
					outObjs.add(icmtA);
//					System.out.println(icmtA);
				}
			}
		}
		trgArea.writeAll(outObjs);
	}
}
