import java.util.Collection;
import java.util.LinkedList;

import mm.*;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.TraceFunction;

public class DBLP_Identity implements ITransformation {

	final String AUTHOR = "author";
	final String ARTICLE = "article";
	final String BOOK = "book";
	final String EDITOR = "editor";
	final String INCOLLECTION = "incollection";
	final String INPROCEEDINGS = "inproceedings";
	final String JOURNAL = "journal";
	final String MASTERTHESIS = "masterthesis";
	final String ORGANIZATION = "orgaization";
	final String PHDTHESIS = "phdthesis";
	final String PROCEEDINGS = "proceedings";
	final String PUBLISHER = "publisher";
	final String SCHOOL = "school";
	final String WWW = "www";
	
	IArea srcArea, trgArea;
	
	public DBLP_Identity(IArea srcArea, IArea trgArea) {
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
				outObjs.add(new Author(TraceFunction.create(a.getId(), AUTHOR), a.getName(), a.getRecords()));
			}
			if (o instanceof Article) {
				Article a = ((Article) o);
				outObjs.add(new Article(TraceFunction.create(a.getId(), ARTICLE), a.getEe(), a.getUrl(), a
						.getKey(), a.getAuthors(), a.getMdate(), a.getTitle(),
						a.getMonth(), a.getFromPage(), a.getToPage(), a
								.getNumber(), a.getVolume(), a.getJournalId(), a.getYear()));
			}
			if (o instanceof Book) {
				Book b = ((Book) o);
				outObjs.add(new Book(TraceFunction.create(b.getId(), BOOK), b.getEe(), b.getUrl(), b
						.getKey(), b.getAuthors(), b.getMdate(), b.getTitle(),
						b.getMonth(), b.getSeries(), b.getIsbn(), b.getYear(),
						b.getVolume(), b.getEdition(), b.getPublisherId()));
			}
			if (o instanceof Editor) {
				Editor e = ((Editor) o);
				outObjs.add(new Editor(TraceFunction.create(e.getId(), EDITOR), e.getName()));
			}
			if (o instanceof InCollection) {
				InCollection in = ((InCollection) o);
				outObjs.add(new InCollection(TraceFunction.create(in.getId(), INCOLLECTION), in.getEe(), in
						.getUrl(), in.getKey(), in.getAuthors(), in.getMdate(),
						in.getTitle(), in.getBookTitle(), in.getMonth(), in
								.getYear(), in.getFromPage(), in.getToPage(),
						in.getOrganizationIds(), in.getEditorIds(), in
								.getPublisherId()));
			}
			if (o instanceof InProceedings) {
				InProceedings in = ((InProceedings) o);
				outObjs.add(new InProceedings(TraceFunction.create(in.getId(), INPROCEEDINGS), in.getEe(), in
						.getUrl(), in.getKey(), in.getAuthors(), in.getMdate(),
						in.getTitle(), in.getBooktitle(), in.getMonth(), in
								.getYear(), in.getFromPage(), in.getToPage(),
						in.getOrganizationId(), in.getPublisherId(), in
								.getEditorIds()));
			}
			if (o instanceof Journal) {
				Journal j = ((Journal) o);
				outObjs.add(new Journal(TraceFunction.create(j.getId(), JOURNAL), j.getName(), j
						.getArticlesIds()));
			}
			if (o instanceof MastersThesis) {
				MastersThesis m = ((MastersThesis) o);
				outObjs.add(new MastersThesis(TraceFunction.create(m.getId(), MASTERTHESIS), m.getEe(), m.getUrl(),
						m.getKey(), m.getAuthors(), m.getMdate(), m.getTitle(),
						m.getMonth(), m.getYear(), m.getSchoolId()));
			}
			if (o instanceof Organization) {
				Organization org = ((Organization) o);
				outObjs.add(new Organization(TraceFunction.create(org.getId(), ORGANIZATION), org.getName()));
			}
			if (o instanceof PhDThesis) {
				PhDThesis p = ((PhDThesis) o);
				outObjs.add(new PhDThesis(TraceFunction.create(p.getId(), PHDTHESIS), p.getEe(), p.getUrl(), p
						.getKey(), p.getAuthors(), p.getMdate(), p.getTitle(),
						p.getMonth(), p.getYear(), p.getSchoolId()));
			}
			if (o instanceof Proceedings) {
				Proceedings p = ((Proceedings) o);
				outObjs.add(new Proceedings(TraceFunction.create(p.getId(), PROCEEDINGS), p.getEe(), p.getUrl(), p
						.getKey(), p.getAuthors(), p.getMdate(), p.getTitle(),
						p.getMonth(), p.getIsbn(), p.getYear(), p
								.getEditorIds(), p.getSponsoredByIds(), p
								.getPublisherId()));
			}
			if (o instanceof Publisher) {
				Publisher p = ((Publisher) o);
				outObjs.add(new Publisher(TraceFunction.create(p.getId(), PUBLISHER), p.getName(), p
						.getAddress()));
			}
			if (o instanceof School) {
				School sc = ((School) o);
				outObjs.add(new School(TraceFunction.create(sc.getId(), SCHOOL), sc.getName(), sc.getAdress()));
			}
			if (o instanceof Www) {
				Www w = ((Www) o);
				outObjs.add(new Www(TraceFunction.create(w.getId(), WWW), w.getEe(), w.getUrl(), w
						.getKey(), w.getAuthors(), w.getMdate(), w.getTitle(),
						w.getMonth(), w.getYear(), w.getEditorIds()));
			}
		}
		trgArea.writeAll(outObjs);
	}
}
