import java.util.Collection;
import java.util.LinkedList;

import mm.*;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.TraceFunction;

public class DBLP_v1 implements ITransformation {

	IArea srcArea, trgArea;
	final String RuleDBLP2Coauthor = "dblp2coauthor";

	public DBLP_v1(IArea srcArea, IArea trgArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
	}

	@Override
	public void transform(
			Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException {
		Collection<IdentifiableElement> outObjs = new LinkedList<IdentifiableElement>();
		for (Object o : objs) {
			if (o instanceof InProceedings) {
				// This is one way of doing it. I could also search for Authors
				// and for each one check all his/her Records and see if they
				// have published in ICMT. Depending on the model, one approach
				// will be more efficient than the other.
				// I should implement the other transformation in order to see
				// which approach performs better.
				InProceedings inp = ((InProceedings) o);
				if (inp.getBooktitle().contains("ICMT")) {
//					System.out.println(inp);
					for (String id : inp.getAuthors()) {
						IdentifiableElement a = srcArea.read(id);
						if (a instanceof mm.Author) {
//							System.out.println((mm.Author) a);
							outObjs.add(new jICMTAuthor.Author(TraceFunction.create(a.getId(), RuleDBLP2Coauthor),
									((mm.Author) a).getName(), -1, false, null, null));
						}
					}
				}
			}
		}
		trgArea.writeAll(outObjs);
	}

}
