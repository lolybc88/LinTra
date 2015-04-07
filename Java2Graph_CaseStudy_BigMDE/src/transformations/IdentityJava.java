package transformations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

import prefuseGraphInJava.Edge;
import javaMMinJava.*;
import javaMMinJava.Package;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import transfo.CurrentId;
import transfo.IMaster;
import transfo.ITransformation;
import transfo.LinTraParameters;
import transfo.ModelFlags;
import transfo.Range;
import transfo.TraceFunction;

public class IdentityJava implements ITransformation {

	IArea srcArea, srcModelFlagsArea, currentIdArea, idCorrespondencesArea,
			trgArea, trgModelFlagsArea;
	ITransformation nextTransfo;

	public IdentityJava(IArea srcArea, IArea srcModelFlagsArea,
			IArea currentIdArea, IArea idCorrespondencesArea, IArea trgArea,
			IArea trgModelFlagsArea, ITransformation nextTransfo)
			throws BlackboardException {
		this.srcArea = srcArea;
		this.srcModelFlagsArea = srcModelFlagsArea;
		this.currentIdArea = currentIdArea;
		this.idCorrespondencesArea = idCorrespondencesArea;
		this.trgArea = trgArea;
		this.trgModelFlagsArea = trgModelFlagsArea;
		this.nextTransfo = nextTransfo;

	}

	@Override
	public void transform(Collection<IdentifiableElement> objs,
			IMaster masterNextTransfo) throws BlackboardException,
			InterruptedException {

		List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();

		List<IdentifiableElement> idCorrespondances = new LinkedList<IdentifiableElement>();

		for (IdentifiableElement ie : objs) {

			transf(elems, ie);

		}

		Range rangeOfIds = requestRangeOfIds(elems.size());
		for (IdentifiableElement ie : elems) {
			String id = Double.toString(rangeOfIds.getCurrent());
			ie.setId(id);
			idCorrespondances.add(new IdCorrespondence(ie.getTrgId(), id));
			rangeOfIds.next();
		}

		idCorrespondencesArea.writeAll(idCorrespondances);
		trgArea.writeAll(elems);
		updateModelFlags(rangeOfIds.getMaxID());

		if (!LinTraParameters.T1_AND_THEN_T2) {
			notifyMaster(masterNextTransfo);
			notifyNextTransfo();
		}
	}

	private void notifyNextTransfo() {
		if (nextTransfo != null){
			synchronized (nextTransfo) {
				// System.out.println("T1 notifies T2");
				nextTransfo.notifyAll();
			}
		}
	}

	private void notifyMaster(IMaster masterNextTransfo) {
		if (masterNextTransfo != null) {
			synchronized (masterNextTransfo) {
				// System.out.println("T1 notifies master T2");
				masterNextTransfo.notifyAll();
			}
		}
	}

	private Range requestRangeOfIds(int numberOfIds)
			throws BlackboardException, InterruptedException {
		CurrentId cid = (CurrentId) currentIdArea
				.take(LinTraParameters.MODEL_FLAGS_ID);
		while (cid == null) {
			// System.out.println("T1 waiting");
			// wait();
			// System.out.println("T1 awakes");
			cid = (CurrentId) currentIdArea
					.take(LinTraParameters.MODEL_FLAGS_ID);
		}
		double id0 = cid.getCurrentId();
		cid.increase(numberOfIds);
		Range r = new Range(id0, id0 + numberOfIds - 1);

		currentIdArea.write(cid);
		// System.out.println("T1 notifies");
		// notifyAll();
		return r;
	}

	private ModelFlags takeModelFlags() throws BlackboardException,
			InterruptedException {
		ModelFlags modelFlags = (ModelFlags) trgModelFlagsArea
				.take(LinTraParameters.MODEL_FLAGS_ID);
		while (modelFlags == null) { // it might be null if it isn't in the Area
										// because the agent(s) who is(are)
										// loading the model is/are updating it
			synchronized (this) {
				wait();
			}
			modelFlags = (ModelFlags) trgModelFlagsArea
					.take(LinTraParameters.MODEL_FLAGS_ID);
		}
		return modelFlags;
	}

	private void updateModelFlags(double maxId) throws BlackboardException,
			InterruptedException {
		ModelFlags modelFlags = takeModelFlags();
		if (modelFlags.getMaxIdStored() < maxId) {
			modelFlags.setMaxIdStored(maxId);
		}
		trgModelFlagsArea.write(modelFlags);
		synchronized (this) {
			notifyAll();
		}
	}

	private javaMMinJava.Package getRootPackage(ClassDeclaration cd)
			throws BlackboardException, InterruptedException {
		String pId = cd.getPackage();
		if (cd.getPackage() != null) {
			javaMMinJava.Package p = (Package) readFromSource(pId);
			while (p != null && p.getPackage() != null) {
				pId = p.getPackage();
				p = (Package) readFromSource(pId);
			}
			return p;
		} else {
			return null;
		}
	}

	private IdentifiableElement readFromSource(String id)
			throws BlackboardException, InterruptedException {

		IdentifiableElement e = srcArea.read(id);

		if (e == null) {
			ModelFlags maf = readModelFlags(srcModelFlagsArea);

			while (!maf.isComplete() && e == null) { // the element we are
														// trying to read is not
														// available yet
				synchronized (this) {
					wait();
				}
				e = srcArea.read(id);
				maf = readModelFlags(srcModelFlagsArea);
			}

			if (maf.isComplete() && e == null) {
				return null; // the element doesn't exist and it won't
			} else {
				return e;
			}
		} else {
			return e;
		}

	}

	private ModelFlags readModelFlags(IArea area) throws BlackboardException,
			InterruptedException {
		ModelFlags modelFlags = (ModelFlags) area
				.read(LinTraParameters.MODEL_FLAGS_ID);
		while (modelFlags == null) { // it might be null if it isn't in the Area
										// because the agent(s) who is(are)
										// loading the model is/are updating it
			modelFlags = (ModelFlags) area
					.read(LinTraParameters.MODEL_FLAGS_ID);
		}
		return modelFlags;
	}

	private void transf(List<IdentifiableElement> elems, IdentifiableElement ie) {
		if (ie instanceof javaMMinJava.Annotation) {
			String trgId = TraceFunction.create(ie.getId(), "Annotation");
			javaMMinJava.Annotation oe = new javaMMinJava.Annotation("",
					TraceFunction.resolveAll(
							((javaMMinJava.Annotation) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.Annotation) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.Annotation) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.Annotation) ie).getType(), "type"),
					TraceFunction.resolveAll(
							((javaMMinJava.Annotation) ie).getValues(),
							"values"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Archive) {
			String trgId = TraceFunction.create(ie.getId(), "Archive");
			javaMMinJava.Archive oe = new javaMMinJava.Archive("",
					TraceFunction.resolveAll(
							((javaMMinJava.Archive) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.Archive) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.Archive) ie).getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.Archive) ie).getName(),
					((javaMMinJava.Archive) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.Archive) ie).getUsagesInImports(),
							"usagesInImports"),
					((javaMMinJava.Archive) ie).getOriginalFilePath(),
					TraceFunction.resolveAll(
							((javaMMinJava.Archive) ie).getClassFiles(),
							"classFiles"), TraceFunction.resolve(
							((javaMMinJava.Archive) ie).getManifest(),
							"manifest"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.AssertStatement) {
			String trgId = TraceFunction.create(ie.getId(), "AssertStatement");
			javaMMinJava.AssertStatement oe = new javaMMinJava.AssertStatement(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.AssertStatement) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.AssertStatement) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.AssertStatement) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.AssertStatement) ie).getMessage(),
							"message"),
					TraceFunction.resolve(
							((javaMMinJava.AssertStatement) ie).getExpression(),
							"expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.AnnotationMemberValuePair) {
			String trgId = TraceFunction.create(ie.getId(),
					"AnnotationMemberValuePair");
			javaMMinJava.AnnotationMemberValuePair oe = new javaMMinJava.AnnotationMemberValuePair(
					"", TraceFunction.resolveAll(
							((javaMMinJava.AnnotationMemberValuePair) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationMemberValuePair) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.AnnotationMemberValuePair) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.AnnotationMemberValuePair) ie).getName(),
					((javaMMinJava.AnnotationMemberValuePair) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationMemberValuePair) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationMemberValuePair) ie)
									.getMember(), "member"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationMemberValuePair) ie)
									.getValue(), "value"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.AnnotationTypeDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"AnnotationTypeDeclaration");
			javaMMinJava.AnnotationTypeDeclaration oe = new javaMMinJava.AnnotationTypeDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.AnnotationTypeDeclaration) ie).getName(),
					((javaMMinJava.AnnotationTypeDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getPackage(), "package"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.AnnotationTypeMemberDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"AnnotationTypeMemberDeclaration");
			javaMMinJava.AnnotationTypeMemberDeclaration oe = new javaMMinJava.AnnotationTypeMemberDeclaration(
					"", TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
							.getName(),
					((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
							.getProxy(), TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getDefault(), "default"),
					TraceFunction.resolve(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getType(), "type"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnnotationTypeMemberDeclaration) ie)
									.getUsages(), "usages"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.AnonymousClassDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"AnonymousClassDeclaration");
			javaMMinJava.AnonymousClassDeclaration oe = new javaMMinJava.AnonymousClassDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.AnonymousClassDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.AnonymousClassDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.AnonymousClassDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					TraceFunction.resolveAll(
							((javaMMinJava.AnonymousClassDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolve(
							((javaMMinJava.AnonymousClassDeclaration) ie)
									.getClassInstanceCreation(),
							"classInstanceCreation"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ArrayAccess) {
			String trgId = TraceFunction.create(ie.getId(), "ArrayAccess");
			javaMMinJava.ArrayAccess oe = new javaMMinJava.ArrayAccess(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ArrayAccess) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.ArrayAccess) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.ArrayAccess) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.ArrayAccess) ie).getArray(), "array"),
					TraceFunction.resolve(
							((javaMMinJava.ArrayAccess) ie).getIndex(), "index"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ArrayCreation) {
			String trgId = TraceFunction.create(ie.getId(), "ArrayCreation");
			javaMMinJava.ArrayCreation oe = new javaMMinJava.ArrayCreation(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ArrayCreation) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.ArrayCreation) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.ArrayCreation) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolveAll(
							((javaMMinJava.ArrayCreation) ie).getDimensions(),
							"dimensions"),
					TraceFunction.resolve(
							((javaMMinJava.ArrayCreation) ie).getInitializer(),
							"initializer"),
					TraceFunction.resolve(
							((javaMMinJava.ArrayCreation) ie).getType(), "type"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ArrayInitializer) {
			String trgId = TraceFunction.create(ie.getId(), "ArrayInitializer");
			javaMMinJava.ArrayInitializer oe = new javaMMinJava.ArrayInitializer(
					"", TraceFunction.resolveAll(
							((javaMMinJava.ArrayInitializer) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ArrayInitializer) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ArrayInitializer) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolveAll(
							((javaMMinJava.ArrayInitializer) ie)
									.getExpressions(), "expressions"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ArrayLengthAccess) {
			String trgId = TraceFunction
					.create(ie.getId(), "ArrayLengthAccess");
			javaMMinJava.ArrayLengthAccess oe = new javaMMinJava.ArrayLengthAccess(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ArrayLengthAccess) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ArrayLengthAccess) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ArrayLengthAccess) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ArrayLengthAccess) ie).getArray(),
							"array"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ArrayType) {
			String trgId = TraceFunction.create(ie.getId(), "ArrayType");
			javaMMinJava.ArrayType oe = new javaMMinJava.ArrayType("",
					TraceFunction.resolveAll(
							((javaMMinJava.ArrayType) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ArrayType) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ArrayType) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.ArrayType) ie).getName(),
					((javaMMinJava.ArrayType) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.ArrayType) ie).getUsagesInImports(),
							"usagesInImports"), TraceFunction.resolveAll(
							((javaMMinJava.ArrayType) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					((javaMMinJava.ArrayType) ie).getDimensions(),
					TraceFunction.resolve(
							((javaMMinJava.ArrayType) ie).getElementType(),
							"elementType"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Assignment) {
			String trgId = TraceFunction.create(ie.getId(), "Assignment");
			javaMMinJava.Assignment oe = new javaMMinJava.Assignment("",
					TraceFunction.resolveAll(
							((javaMMinJava.Assignment) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.Assignment) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.Assignment) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.Assignment) ie).getLeftHandSide(),
							"leftHandSide"),
					((javaMMinJava.Assignment) ie).getOperator(),
					TraceFunction.resolve(
							((javaMMinJava.Assignment) ie).getRightHandSide(),
							"rightHandSide"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.BooleanLiteral) {
			String trgId = TraceFunction.create(ie.getId(), "BooleanLiteral");
			javaMMinJava.BooleanLiteral oe = new javaMMinJava.BooleanLiteral(
					"", TraceFunction.resolveAll(
							((javaMMinJava.BooleanLiteral) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.BooleanLiteral) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.BooleanLiteral) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.BooleanLiteral) ie).getValue());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.BlockComment) {
			String trgId = TraceFunction.create(ie.getId(), "BlockComment");
			javaMMinJava.BlockComment oe = new javaMMinJava.BlockComment("",
					TraceFunction.resolveAll(
							((javaMMinJava.BlockComment) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.BlockComment) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.BlockComment) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.BlockComment) ie).getContent(),
					((javaMMinJava.BlockComment) ie).getEnclosedByParent(),
					((javaMMinJava.BlockComment) ie).getPrefixOfParent());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Block) {
			String trgId = TraceFunction.create(ie.getId(), "Block");
			javaMMinJava.Block oe = new javaMMinJava.Block(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.Block) ie).getComments(), "comments"),
					TraceFunction.resolve(((javaMMinJava.Block) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.Block) ie).getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolveAll(
							((javaMMinJava.Block) ie).getStatements(),
							"statements"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.BreakStatement) {
			String trgId = TraceFunction.create(ie.getId(), "BreakStatement");
			javaMMinJava.BreakStatement oe = new javaMMinJava.BreakStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.BreakStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.BreakStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.BreakStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.BreakStatement) ie).getLabel(),
							"label"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.CastExpression) {
			String trgId = TraceFunction.create(ie.getId(), "CastExpression");
			javaMMinJava.CastExpression oe = new javaMMinJava.CastExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.CastExpression) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.CastExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.CastExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.CastExpression) ie).getExpression(),
							"expression"), TraceFunction.resolve(
							((javaMMinJava.CastExpression) ie).getType(),
							"type"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.CatchClause) {
			String trgId = TraceFunction.create(ie.getId(), "CatchClause");
			javaMMinJava.CatchClause oe = new javaMMinJava.CatchClause("",
					TraceFunction.resolveAll(
							((javaMMinJava.CatchClause) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.CatchClause) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.CatchClause) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.CatchClause) ie).getException(),
							"exception"), TraceFunction.resolve(
							((javaMMinJava.CatchClause) ie).getBody(), "body"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.CharacterLiteral) {
			String trgId = TraceFunction.create(ie.getId(), "CharacterLiteral");
			javaMMinJava.CharacterLiteral oe = new javaMMinJava.CharacterLiteral(
					"", TraceFunction.resolveAll(
							((javaMMinJava.CharacterLiteral) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.CharacterLiteral) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.CharacterLiteral) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.CharacterLiteral) ie).getEscapedValue());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ClassFile) {
			String trgId = TraceFunction.create(ie.getId(), "ClassFile");
			javaMMinJava.ClassFile oe = new javaMMinJava.ClassFile("",
					TraceFunction.resolveAll(
							((javaMMinJava.ClassFile) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ClassFile) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ClassFile) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.ClassFile) ie).getName(),
					((javaMMinJava.ClassFile) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassFile) ie).getUsagesInImports(),
							"usagesInImports"),
					((javaMMinJava.ClassFile) ie).getOriginalFilePath(),
					TraceFunction.resolve(
							((javaMMinJava.ClassFile) ie).getType(), "type"),
					TraceFunction.resolve(
							((javaMMinJava.ClassFile) ie).getAttachedSource(),
							"attachedSource"), TraceFunction.resolve(
							((javaMMinJava.ClassFile) ie).getPackage(),
							"package"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ClassInstanceCreation) {
			String trgId = TraceFunction.create(ie.getId(),
					"ClassInstanceCreation");
			javaMMinJava.ClassInstanceCreation oe = new javaMMinJava.ClassInstanceCreation(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getMethod(), "method"),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getArguments(), "arguments"),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getTypeArguments(), "typeArguments"),
					TraceFunction.resolve(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getAnonymousClassDeclaration(),
							"anonymousClassDeclaration"),
					TraceFunction.resolve(
							((javaMMinJava.ClassInstanceCreation) ie)
									.getExpression(), "expression"),
					TraceFunction.resolve(
							((javaMMinJava.ClassInstanceCreation) ie).getType(),
							"type"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ConstructorDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"ConstructorDeclaration");
			javaMMinJava.ConstructorDeclaration oe = new javaMMinJava.ConstructorDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.ConstructorDeclaration) ie).getName(),
					((javaMMinJava.ConstructorDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolve(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getBody(), "body"),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getParameters(), "parameters"),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getThrownExceptions(), "thrownExceptions"),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getTypeParameters(), "typeParameters"),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getUsagesInDocComments(),
							"usagesInDocComments"), TraceFunction.resolveAll(
							((javaMMinJava.ConstructorDeclaration) ie)
									.getUsages(), "usages"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ConditionalExpression) {
			String trgId = TraceFunction.create(ie.getId(),
					"ConditionalExpression");
			javaMMinJava.ConditionalExpression oe = new javaMMinJava.ConditionalExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.ConditionalExpression) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.ConditionalExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ConditionalExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ConditionalExpression) ie)
									.getElseExpression(), "elseExpression"),
					TraceFunction.resolve(
							((javaMMinJava.ConditionalExpression) ie)
									.getExpression(), "expression"),
					TraceFunction.resolve(
							((javaMMinJava.ConditionalExpression) ie)
									.getThenExpression(), "thenExpression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ConstructorInvocation) {
			String trgId = TraceFunction.create(ie.getId(),
					"ConstructorInvocation");
			javaMMinJava.ConstructorInvocation oe = new javaMMinJava.ConstructorInvocation(
					"", TraceFunction.resolveAll(
							((javaMMinJava.ConstructorInvocation) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.ConstructorInvocation) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ConstructorInvocation) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ConstructorInvocation) ie)
									.getMethod(), "method"),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorInvocation) ie)
									.getArguments(), "arguments"),
					TraceFunction.resolveAll(
							((javaMMinJava.ConstructorInvocation) ie)
									.getTypeArguments(), "typeArguments"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ClassDeclaration) {
			String trgId = TraceFunction.create(ie.getId(), "ClassDeclaration");
			javaMMinJava.ClassDeclaration oe = new javaMMinJava.ClassDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.ClassDeclaration) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.ClassDeclaration) ie)
							.getOriginalClassFile(), "originalClassFile"),
					((javaMMinJava.ClassDeclaration) ie).getName(),
					((javaMMinJava.ClassDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(((javaMMinJava.ClassDeclaration) ie)
							.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(((javaMMinJava.ClassDeclaration) ie)
							.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.ClassDeclaration) ie).getModifier(),
							"modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.ClassDeclaration) ie).getPackage(),
							"package"), TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"),
					TraceFunction.resolveAll(
							((javaMMinJava.ClassDeclaration) ie)
									.getTypeParameters(), "typeParameters"),
					TraceFunction.resolve(((javaMMinJava.ClassDeclaration) ie)
							.getSuperClass(), "superClass"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.CompilationUnit) {
			String trgId = TraceFunction.create(ie.getId(), "CompilationUnit");
			javaMMinJava.CompilationUnit oe = new javaMMinJava.CompilationUnit(
					"", TraceFunction.resolveAll(
							((javaMMinJava.CompilationUnit) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.CompilationUnit) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.CompilationUnit) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.CompilationUnit) ie).getName(),
					((javaMMinJava.CompilationUnit) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.CompilationUnit) ie)
									.getUsagesInImports(), "usagesInImports"),
					((javaMMinJava.CompilationUnit) ie).getOriginalFilePath(),
					TraceFunction.resolveAll(
							((javaMMinJava.CompilationUnit) ie)
									.getCommentList(), "commentList"),
					TraceFunction.resolveAll(
							((javaMMinJava.CompilationUnit) ie).getImports(),
							"imports"), TraceFunction.resolve(
							((javaMMinJava.CompilationUnit) ie).getPackage(),
							"package"), TraceFunction.resolveAll(
							((javaMMinJava.CompilationUnit) ie).getTypes(),
							"types"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ContinueStatement) {
			String trgId = TraceFunction
					.create(ie.getId(), "ContinueStatement");
			javaMMinJava.ContinueStatement oe = new javaMMinJava.ContinueStatement(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ContinueStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ContinueStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ContinueStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ContinueStatement) ie).getLabel(),
							"label"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.DoStatement) {
			String trgId = TraceFunction.create(ie.getId(), "DoStatement");
			javaMMinJava.DoStatement oe = new javaMMinJava.DoStatement("",
					TraceFunction.resolveAll(
							((javaMMinJava.DoStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.DoStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.DoStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.DoStatement) ie).getExpression(),
							"expression"), TraceFunction.resolve(
							((javaMMinJava.DoStatement) ie).getBody(), "body"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.EmptyStatement) {
			String trgId = TraceFunction.create(ie.getId(), "EmptyStatement");
			javaMMinJava.EmptyStatement oe = new javaMMinJava.EmptyStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.EmptyStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.EmptyStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.EmptyStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.EnhancedForStatement) {
			String trgId = TraceFunction.create(ie.getId(),
					"EnhancedForStatement");
			javaMMinJava.EnhancedForStatement oe = new javaMMinJava.EnhancedForStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.EnhancedForStatement) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.EnhancedForStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.EnhancedForStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.EnhancedForStatement) ie).getBody(),
							"body"), TraceFunction.resolve(
							((javaMMinJava.EnhancedForStatement) ie)
									.getExpression(), "expression"),
					TraceFunction.resolve(
							((javaMMinJava.EnhancedForStatement) ie)
									.getParameter(), "parameter"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.EnumConstantDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"EnumConstantDeclaration");
			javaMMinJava.EnumConstantDeclaration oe = new javaMMinJava.EnumConstantDeclaration(
					"", TraceFunction.resolveAll(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.EnumConstantDeclaration) ie).getName(),
					((javaMMinJava.EnumConstantDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getModifier(), "modifier"),
					((javaMMinJava.EnumConstantDeclaration) ie)
							.getExtraArrayDimensions(), TraceFunction.resolve(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getInitializer(), "initializer"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getUsageInVariableAccess(),
							"usageInVariableAccess"), TraceFunction.resolve(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getAnonymousClassDeclaration(),
							"anonymousClassDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumConstantDeclaration) ie)
									.getArguments(), "arguments"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.EnumDeclaration) {
			String trgId = TraceFunction.create(ie.getId(), "EnumDeclaration");
			javaMMinJava.EnumDeclaration oe = new javaMMinJava.EnumDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.EnumDeclaration) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.EnumDeclaration) ie)
							.getOriginalClassFile(), "originalClassFile"),
					((javaMMinJava.EnumDeclaration) ie).getName(),
					((javaMMinJava.EnumDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(((javaMMinJava.EnumDeclaration) ie)
							.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(((javaMMinJava.EnumDeclaration) ie)
							.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.EnumDeclaration) ie).getModifier(),
							"modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.EnumDeclaration) ie).getPackage(),
							"package"), TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"),
					TraceFunction.resolveAll(
							((javaMMinJava.EnumDeclaration) ie)
									.getEnumConstants(), "enumConstants"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ExpressionStatement) {
			String trgId = TraceFunction.create(ie.getId(),
					"ExpressionStatement");
			javaMMinJava.ExpressionStatement oe = new javaMMinJava.ExpressionStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.ExpressionStatement) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.ExpressionStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ExpressionStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ExpressionStatement) ie)
									.getExpression(), "expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.FieldAccess) {
			String trgId = TraceFunction.create(ie.getId(), "FieldAccess");
			javaMMinJava.FieldAccess oe = new javaMMinJava.FieldAccess(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.FieldAccess) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.FieldAccess) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.FieldAccess) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.FieldAccess) ie).getField(), "field"),
					TraceFunction.resolve(
							((javaMMinJava.FieldAccess) ie).getExpression(),
							"expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.FieldDeclaration) {
			String trgId = TraceFunction.create(ie.getId(), "FieldDeclaration");
			javaMMinJava.FieldDeclaration oe = new javaMMinJava.FieldDeclaration(
					"", TraceFunction.resolveAll(
							((javaMMinJava.FieldDeclaration) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.FieldDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.FieldDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.FieldDeclaration) ie).getName(),
					((javaMMinJava.FieldDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.FieldDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(((javaMMinJava.FieldDeclaration) ie)
							.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.FieldDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(((javaMMinJava.FieldDeclaration) ie)
							.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.FieldDeclaration) ie).getModifier(),
							"modifier"), TraceFunction.resolve(
							((javaMMinJava.FieldDeclaration) ie).getTypeID(),
							"type"), TraceFunction.resolveAll(
							((javaMMinJava.FieldDeclaration) ie)
									.getFragmentsID(), "fragments"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ForStatement) {
			String trgId = TraceFunction.create(ie.getId(), "ForStatement");
			javaMMinJava.ForStatement oe = new javaMMinJava.ForStatement("",
					TraceFunction.resolveAll(
							((javaMMinJava.ForStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ForStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ForStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ForStatement) ie).getExpression(),
							"expression"), TraceFunction.resolveAll(
							((javaMMinJava.ForStatement) ie).getUpdaters(),
							"updaters"), TraceFunction.resolveAll(
							((javaMMinJava.ForStatement) ie).getInitializers(),
							"initializers"), TraceFunction.resolve(
							((javaMMinJava.ForStatement) ie).getBody(), "body"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.IfStatement) {
			String trgId = TraceFunction.create(ie.getId(), "IfStatement");
			javaMMinJava.IfStatement oe = new javaMMinJava.IfStatement("",
					TraceFunction.resolveAll(
							((javaMMinJava.IfStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.IfStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.IfStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.IfStatement) ie).getExpression(),
							"expression"), TraceFunction.resolve(
							((javaMMinJava.IfStatement) ie).getThenStatement(),
							"thenStatement"), TraceFunction.resolve(
							((javaMMinJava.IfStatement) ie).getElseStatement(),
							"elseStatement"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ImportDeclaration) {
			String trgId = TraceFunction
					.create(ie.getId(), "ImportDeclaration");
			javaMMinJava.ImportDeclaration oe = new javaMMinJava.ImportDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ImportDeclaration) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ImportDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ImportDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.ImportDeclaration) ie).getStatic(),
					TraceFunction.resolve(((javaMMinJava.ImportDeclaration) ie)
							.getImportedElement(), "importedElement"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.InfixExpression) {
			String trgId = TraceFunction.create(ie.getId(), "InfixExpression");
			javaMMinJava.InfixExpression oe = new javaMMinJava.InfixExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.InfixExpression) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.InfixExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.InfixExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.InfixExpression) ie).getOperator(),
					TraceFunction.resolve(((javaMMinJava.InfixExpression) ie)
							.getRightOperand(), "rightOperand"),
					TraceFunction.resolve(((javaMMinJava.InfixExpression) ie)
							.getLeftOperand(), "leftOperand"),
					TraceFunction.resolveAll(
							((javaMMinJava.InfixExpression) ie)
									.getExtendedOperands(), "extendedOperands"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Initializer) {
			String trgId = TraceFunction.create(ie.getId(), "Initializer");
			javaMMinJava.Initializer oe = new javaMMinJava.Initializer("",
					TraceFunction.resolveAll(
							((javaMMinJava.Initializer) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.Initializer) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.Initializer) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.Initializer) ie).getName(),
					((javaMMinJava.Initializer) ie).getProxy(),
					TraceFunction.resolveAll(((javaMMinJava.Initializer) ie)
							.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(((javaMMinJava.Initializer) ie)
							.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.Initializer) ie).getAnnotations(),
							"annotations"), TraceFunction.resolve(
							((javaMMinJava.Initializer) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.Initializer) ie).getModifier(),
							"modifier"), TraceFunction.resolve(
							((javaMMinJava.Initializer) ie).getBody(), "body"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.InstanceofExpression) {
			String trgId = TraceFunction.create(ie.getId(),
					"InstanceofExpression");
			javaMMinJava.InstanceofExpression oe = new javaMMinJava.InstanceofExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.InstanceofExpression) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.InstanceofExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.InstanceofExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.InstanceofExpression) ie)
									.getRightOperand(), "rightOperand"),
					TraceFunction.resolve(
							((javaMMinJava.InstanceofExpression) ie)
									.getLeftOperand(), "leftOperand"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.InterfaceDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"InterfaceDeclaration");
			javaMMinJava.InterfaceDeclaration oe = new javaMMinJava.InterfaceDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.InterfaceDeclaration) ie).getName(),
					((javaMMinJava.InterfaceDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.InterfaceDeclaration) ie)
									.getPackage(), "package"), TraceFunction
							.resolveAll(
									((javaMMinJava.InterfaceDeclaration) ie)
											.getSuperInterfaces(),
									"superInterfaces"), TraceFunction
							.resolveAll(
									((javaMMinJava.InterfaceDeclaration) ie)
											.getTypeParameters(),
									"typeParameters"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Javadoc) {
			String trgId = TraceFunction.create(ie.getId(), "Javadoc");
			javaMMinJava.Javadoc oe = new javaMMinJava.Javadoc("",
					TraceFunction.resolveAll(
							((javaMMinJava.Javadoc) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.Javadoc) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.Javadoc) ie).getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.Javadoc) ie).getContent(),
					((javaMMinJava.Javadoc) ie).getEnclosedByParent(),
					((javaMMinJava.Javadoc) ie).getPrefixOfParent(),
					TraceFunction.resolveAll(
							((javaMMinJava.Javadoc) ie).getTags(), "tags"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.LabeledStatement) {
			String trgId = TraceFunction.create(ie.getId(), "LabeledStatement");
			javaMMinJava.LabeledStatement oe = new javaMMinJava.LabeledStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.LabeledStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.LabeledStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.LabeledStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.LabeledStatement) ie).getName(),
					((javaMMinJava.LabeledStatement) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.LabeledStatement) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.LabeledStatement) ie).getBody(),
							"body"), TraceFunction.resolveAll(
							((javaMMinJava.LabeledStatement) ie)
									.getUsagesInBreakStatements(),
							"usagesInBreakStatements"),
					TraceFunction.resolveAll(
							((javaMMinJava.LabeledStatement) ie)
									.getUsagesInContinueStatements(),
							"usagesInContinueStatements"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.LineComment) {
			String trgId = TraceFunction.create(ie.getId(), "LineComment");
			javaMMinJava.LineComment oe = new javaMMinJava.LineComment("",
					TraceFunction.resolveAll(
							((javaMMinJava.LineComment) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.LineComment) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.LineComment) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.LineComment) ie).getContent(),
					((javaMMinJava.LineComment) ie).getEnclosedByParent(),
					((javaMMinJava.LineComment) ie).getPrefixOfParent());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Manifest) {
			String trgId = TraceFunction.create(ie.getId(), "Manifest");
			javaMMinJava.Manifest oe = new javaMMinJava.Manifest("",
					TraceFunction.resolveAll(
							((javaMMinJava.Manifest) ie).getMainAttributes(),
							"mainAttributes"), TraceFunction.resolveAll(
							((javaMMinJava.Manifest) ie).getEntryAttributes(),
							"entryAttributes"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ManifestAttribute) {
			String trgId = TraceFunction
					.create(ie.getId(), "ManifestAttribute");
			javaMMinJava.ManifestAttribute oe = new javaMMinJava.ManifestAttribute(
					"", ((javaMMinJava.ManifestAttribute) ie).getKey(),
					((javaMMinJava.ManifestAttribute) ie).getValue());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ManifestEntry) {
			String trgId = TraceFunction.create(ie.getId(), "ManifestEntry");
			javaMMinJava.ManifestEntry oe = new javaMMinJava.ManifestEntry("",
					((javaMMinJava.ManifestEntry) ie).getName(),
					TraceFunction.resolveAll(
							((javaMMinJava.ManifestEntry) ie).getAttributes(),
							"attributes"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.MemberRef) {
			String trgId = TraceFunction.create(ie.getId(), "MemberRef");
			javaMMinJava.MemberRef oe = new javaMMinJava.MemberRef(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.MemberRef) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.MemberRef) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.MemberRef) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.MemberRef) ie).getMember(), "member"),
					TraceFunction.resolve(
							((javaMMinJava.MemberRef) ie).getQualifier(),
							"qualifier"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.MethodDeclaration) {
			String trgId = TraceFunction
					.create(ie.getId(), "MethodDeclaration");
			javaMMinJava.MethodDeclaration oe = new javaMMinJava.MethodDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.MethodDeclaration) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.MethodDeclaration) ie)
							.getOriginalClassFile(), "originalClassFile"),
					((javaMMinJava.MethodDeclaration) ie).getName(),
					((javaMMinJava.MethodDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(((javaMMinJava.MethodDeclaration) ie)
							.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(((javaMMinJava.MethodDeclaration) ie)
							.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.MethodDeclaration) ie).getModifier(),
							"modifier"),
					TraceFunction.resolve(
							((javaMMinJava.MethodDeclaration) ie).getBody(),
							"body"),
					TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie)
									.getParameters(), "parameters"),
					TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie)
									.getThrownExceptions(), "thrownExceptions"),
					TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie)
									.getTypeParameters(), "typeParameters"),
					TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie)
									.getUsagesInDocComments(),
							"usagesInDocComments"), TraceFunction.resolveAll(
							((javaMMinJava.MethodDeclaration) ie).getUsages(),
							"usages"), ((javaMMinJava.MethodDeclaration) ie)
							.getExtraArrayDimensions(), TraceFunction.resolve(
							((javaMMinJava.MethodDeclaration) ie)
									.getReturnType(), "returnType"),
					TraceFunction.resolve(((javaMMinJava.MethodDeclaration) ie)
							.getRedefinedMethodDeclaration(),
							"redefinedMethodDeclaration"), TraceFunction
							.resolveAll(((javaMMinJava.MethodDeclaration) ie)
									.getRedefinitions(), "redefinitions"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.MethodInvocation) {
			String trgId = TraceFunction.create(ie.getId(), "MethodInvocation");
			javaMMinJava.MethodInvocation oe = new javaMMinJava.MethodInvocation(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.MethodInvocation) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.MethodInvocation) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.MethodInvocation) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.MethodInvocation) ie).getMethod(),
							"method"),
					TraceFunction.resolveAll(
							((javaMMinJava.MethodInvocation) ie).getArguments(),
							"arguments"), TraceFunction.resolveAll(
							((javaMMinJava.MethodInvocation) ie)
									.getTypeArguments(), "typeArguments"),
					TraceFunction.resolve(((javaMMinJava.MethodInvocation) ie)
							.getExpression(), "expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.MethodRef) {
			String trgId = TraceFunction.create(ie.getId(), "MethodRef");
			javaMMinJava.MethodRef oe = new javaMMinJava.MethodRef(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.MethodRef) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.MethodRef) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.MethodRef) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.MethodRef) ie).getMethod(), "method"),
					TraceFunction.resolve(
							((javaMMinJava.MethodRef) ie).getQualifier(),
							"qualifier"), TraceFunction.resolveAll(
							((javaMMinJava.MethodRef) ie).getParameters(),
							"parameters"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.MethodRefParameter) {
			String trgId = TraceFunction.create(ie.getId(),
					"MethodRefParameter");
			javaMMinJava.MethodRefParameter oe = new javaMMinJava.MethodRefParameter(
					"", TraceFunction.resolveAll(
							((javaMMinJava.MethodRefParameter) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.MethodRefParameter) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.MethodRefParameter) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.MethodRefParameter) ie).getName(),
					((javaMMinJava.MethodRefParameter) ie).getVarargs(),
					TraceFunction.resolve(
							((javaMMinJava.MethodRefParameter) ie).getType(),
							"type"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Model) {
			String trgId = TraceFunction.create(ie.getId(), "Model");
			javaMMinJava.Model oe = new javaMMinJava.Model(
					"",
					((javaMMinJava.Model) ie).getName(),
					TraceFunction.resolveAll(
							((javaMMinJava.Model) ie).getOwnedElements(),
							"ownedElements"),
					TraceFunction.resolveAll(
							((javaMMinJava.Model) ie).getOrphanTypes(),
							"orphanTypes"),
					TraceFunction.resolveAll(
							((javaMMinJava.Model) ie).getUnresolvedItems(),
							"unresolvedItems"),
					TraceFunction.resolveAll(
							((javaMMinJava.Model) ie).getCompilationUnits(),
							"compilationUnits"),
					TraceFunction.resolveAll(
							((javaMMinJava.Model) ie).getClassFiles(),
							"classFiles"),
					TraceFunction.resolveAll(
							((javaMMinJava.Model) ie).getArchives(), "archives"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Modifier) {
			String trgId = TraceFunction.create(ie.getId(), "Modifier");
			javaMMinJava.Modifier oe = new javaMMinJava.Modifier(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.Modifier) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.Modifier) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.Modifier) ie).getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.Modifier) ie).getVisibility(),
					((javaMMinJava.Modifier) ie).getInheritance(),
					((javaMMinJava.Modifier) ie).getStatic(),
					((javaMMinJava.Modifier) ie).getTransient(),
					((javaMMinJava.Modifier) ie).getVolatile(),
					((javaMMinJava.Modifier) ie).getNative(),
					((javaMMinJava.Modifier) ie).getStrictfp(),
					((javaMMinJava.Modifier) ie).getSynchronized(),
					TraceFunction.resolve(
							((javaMMinJava.Modifier) ie).getBodyDeclaration(),
							"bodyDeclaration"), TraceFunction.resolve(
							((javaMMinJava.Modifier) ie)
									.getSingleVariableDeclaration(),
							"singleVariableDeclaration"),
					TraceFunction.resolve(((javaMMinJava.Modifier) ie)
							.getVariableDeclarationStatement(),
							"variableDeclarationStatement"),
					TraceFunction.resolve(((javaMMinJava.Modifier) ie)
							.getVariableDeclarationExpression(),
							"variableDeclarationExpression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.NumberLiteral) {
			String trgId = TraceFunction.create(ie.getId(), "NumberLiteral");
			javaMMinJava.NumberLiteral oe = new javaMMinJava.NumberLiteral("",
					TraceFunction.resolveAll(
							((javaMMinJava.NumberLiteral) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.NumberLiteral) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.NumberLiteral) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.NumberLiteral) ie).getTokenValue());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.NullLiteral) {
			String trgId = TraceFunction.create(ie.getId(), "NullLiteral");
			javaMMinJava.NullLiteral oe = new javaMMinJava.NullLiteral("",
					TraceFunction.resolveAll(
							((javaMMinJava.NullLiteral) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.NullLiteral) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.NullLiteral) ie)
									.getOriginalClassFile(),
							"originalClassFile"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.Package) {
			String trgId = TraceFunction.create(ie.getId(), "Package");
			javaMMinJava.Package oe = new javaMMinJava.Package(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.Package) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.Package) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.Package) ie).getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.Package) ie).getName(),
					((javaMMinJava.Package) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.Package) ie).getUsagesInImports(),
							"usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.Package) ie).getOwnedElements(),
							"ownedElements"),
					TraceFunction.resolve(
							((javaMMinJava.Package) ie).getModel(), "model"),
					TraceFunction.resolveAll(
							((javaMMinJava.Package) ie).getOwnedPackages(),
							"ownedPackages"),
					TraceFunction.resolve(
							((javaMMinJava.Package) ie).getPackage(), "package"),
					TraceFunction.resolveAll(((javaMMinJava.Package) ie)
							.getUsagesInPackageAccess(),
							"usagesInPackageAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PackageAccess) {
			String trgId = TraceFunction.create(ie.getId(), "PackageAccess");
			javaMMinJava.PackageAccess oe = new javaMMinJava.PackageAccess("",
					TraceFunction.resolveAll(
							((javaMMinJava.PackageAccess) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PackageAccess) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PackageAccess) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.PackageAccess) ie).getPackage(),
							"package"), TraceFunction.resolve(
							((javaMMinJava.PackageAccess) ie).getQualifier(),
							"qualifier"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ParameterizedType) {
			String trgId = TraceFunction
					.create(ie.getId(), "ParameterizedType");
			javaMMinJava.ParameterizedType oe = new javaMMinJava.ParameterizedType(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ParameterizedType) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ParameterizedType) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ParameterizedType) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.ParameterizedType) ie).getName(),
					((javaMMinJava.ParameterizedType) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.ParameterizedType) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.ParameterizedType) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"), TraceFunction.resolve(
							((javaMMinJava.ParameterizedType) ie).getType(),
							"type"), TraceFunction.resolveAll(
							((javaMMinJava.ParameterizedType) ie)
									.getTypeArguments(), "typeArguments"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ParenthesizedExpression) {
			String trgId = TraceFunction.create(ie.getId(),
					"ParenthesizedExpression");
			javaMMinJava.ParenthesizedExpression oe = new javaMMinJava.ParenthesizedExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.ParenthesizedExpression) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.ParenthesizedExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ParenthesizedExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ParenthesizedExpression) ie)
									.getExpression(), "expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PostfixExpression) {
			String trgId = TraceFunction
					.create(ie.getId(), "PostfixExpression");
			javaMMinJava.PostfixExpression oe = new javaMMinJava.PostfixExpression(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.PostfixExpression) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PostfixExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PostfixExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PostfixExpression) ie).getOperator(),
					TraceFunction.resolve(
							((javaMMinJava.PostfixExpression) ie).getOperand(),
							"operand"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrefixExpression) {
			String trgId = TraceFunction.create(ie.getId(), "PrefixExpression");
			javaMMinJava.PrefixExpression oe = new javaMMinJava.PrefixExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.PrefixExpression) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PrefixExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrefixExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrefixExpression) ie).getOperator(),
					TraceFunction.resolve(
							((javaMMinJava.PrefixExpression) ie).getOperand(),
							"operand"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveType) {
			String trgId = TraceFunction.create(ie.getId(), "PrimitiveType");
			javaMMinJava.PrimitiveType oe = new javaMMinJava.PrimitiveType("",
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveType) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveType) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveType) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveType) ie).getName(),
					((javaMMinJava.PrimitiveType) ie).getProxy(),
					TraceFunction.resolveAll(((javaMMinJava.PrimitiveType) ie)
							.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(((javaMMinJava.PrimitiveType) ie)
							.getUsagesInTypeAccess(), "usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeBoolean) {
			String trgId = TraceFunction.create(ie.getId(),
					"PrimitiveTypeBoolean");
			javaMMinJava.PrimitiveTypeBoolean oe = new javaMMinJava.PrimitiveTypeBoolean(
					"", TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeBoolean) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeBoolean) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeBoolean) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeBoolean) ie).getName(),
					((javaMMinJava.PrimitiveTypeBoolean) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeBoolean) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeBoolean) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeByte) {
			String trgId = TraceFunction
					.create(ie.getId(), "PrimitiveTypeByte");
			javaMMinJava.PrimitiveTypeByte oe = new javaMMinJava.PrimitiveTypeByte(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeByte) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeByte) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeByte) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeByte) ie).getName(),
					((javaMMinJava.PrimitiveTypeByte) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeByte) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeByte) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeChar) {
			String trgId = TraceFunction
					.create(ie.getId(), "PrimitiveTypeChar");
			javaMMinJava.PrimitiveTypeChar oe = new javaMMinJava.PrimitiveTypeChar(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeChar) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeChar) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeChar) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeChar) ie).getName(),
					((javaMMinJava.PrimitiveTypeChar) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeChar) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeChar) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeDouble) {
			String trgId = TraceFunction.create(ie.getId(),
					"PrimitiveTypeDouble");
			javaMMinJava.PrimitiveTypeDouble oe = new javaMMinJava.PrimitiveTypeDouble(
					"", TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeDouble) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeDouble) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeDouble) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeDouble) ie).getName(),
					((javaMMinJava.PrimitiveTypeDouble) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeDouble) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeDouble) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeShort) {
			String trgId = TraceFunction.create(ie.getId(),
					"PrimitiveTypeShort");
			javaMMinJava.PrimitiveTypeShort oe = new javaMMinJava.PrimitiveTypeShort(
					"", TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeShort) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeShort) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeShort) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeShort) ie).getName(),
					((javaMMinJava.PrimitiveTypeShort) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeShort) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeShort) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeFloat) {
			String trgId = TraceFunction.create(ie.getId(),
					"PrimitiveTypeFloat");
			javaMMinJava.PrimitiveTypeFloat oe = new javaMMinJava.PrimitiveTypeFloat(
					"", TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeFloat) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeFloat) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeFloat) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeFloat) ie).getName(),
					((javaMMinJava.PrimitiveTypeFloat) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeFloat) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeFloat) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeInt) {
			String trgId = TraceFunction.create(ie.getId(), "PrimitiveTypeInt");
			javaMMinJava.PrimitiveTypeInt oe = new javaMMinJava.PrimitiveTypeInt(
					"", TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeInt) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeInt) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeInt) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeInt) ie).getName(),
					((javaMMinJava.PrimitiveTypeInt) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeInt) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeInt) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeLong) {
			String trgId = TraceFunction
					.create(ie.getId(), "PrimitiveTypeLong");
			javaMMinJava.PrimitiveTypeLong oe = new javaMMinJava.PrimitiveTypeLong(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeLong) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeLong) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeLong) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeLong) ie).getName(),
					((javaMMinJava.PrimitiveTypeLong) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeLong) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeLong) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.PrimitiveTypeVoid) {
			String trgId = TraceFunction
					.create(ie.getId(), "PrimitiveTypeVoid");
			javaMMinJava.PrimitiveTypeVoid oe = new javaMMinJava.PrimitiveTypeVoid(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeVoid) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeVoid) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.PrimitiveTypeVoid) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.PrimitiveTypeVoid) ie).getName(),
					((javaMMinJava.PrimitiveTypeVoid) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeVoid) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(
							((javaMMinJava.PrimitiveTypeVoid) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ReturnStatement) {
			String trgId = TraceFunction.create(ie.getId(), "ReturnStatement");
			javaMMinJava.ReturnStatement oe = new javaMMinJava.ReturnStatement(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.ReturnStatement) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.ReturnStatement) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.ReturnStatement) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.ReturnStatement) ie).getExpression(),
							"expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SingleVariableAccess) {
			String trgId = TraceFunction.create(ie.getId(),
					"SingleVariableAccess");
			javaMMinJava.SingleVariableAccess oe = new javaMMinJava.SingleVariableAccess(
					"", TraceFunction.resolveAll(
							((javaMMinJava.SingleVariableAccess) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.SingleVariableAccess) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.SingleVariableAccess) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.SingleVariableAccess) ie)
									.getVariable(), "variable"),
					TraceFunction.resolve(
							((javaMMinJava.SingleVariableAccess) ie)
									.getQualifier(), "qualifier"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SingleVariableDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"SingleVariableDeclaration");
			javaMMinJava.SingleVariableDeclaration oe = new javaMMinJava.SingleVariableDeclaration(
					"", TraceFunction.resolveAll(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.SingleVariableDeclaration) ie).getName(),
					((javaMMinJava.SingleVariableDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					((javaMMinJava.SingleVariableDeclaration) ie)
							.getExtraArrayDimensions(), TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getInitializer(), "initializer"),
					TraceFunction.resolveAll(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getUsageInVariableAccess(),
							"usageInVariableAccess"), TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getModifier(), "modifier"),
					((javaMMinJava.SingleVariableDeclaration) ie).getVarargs(),
					TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getType(), "type"),
					TraceFunction.resolveAll(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getMethodDeclaration(),
							"methodDeclaration"), TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getCatchClause(), "catchClause"),
					TraceFunction.resolve(
							((javaMMinJava.SingleVariableDeclaration) ie)
									.getEnhancedForStatement(),
							"enhancedForStatement"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.StringLiteral) {
			String trgId = TraceFunction.create(ie.getId(), "StringLiteral");
			javaMMinJava.StringLiteral oe = new javaMMinJava.StringLiteral("",
					TraceFunction.resolveAll(
							((javaMMinJava.StringLiteral) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.StringLiteral) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.StringLiteral) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.StringLiteral) ie).getEscapedValue());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SuperConstructorInvocation) {
			String trgId = TraceFunction.create(ie.getId(),
					"SuperConstructorInvocation");
			javaMMinJava.SuperConstructorInvocation oe = new javaMMinJava.SuperConstructorInvocation(
					"", TraceFunction.resolveAll(
							((javaMMinJava.SuperConstructorInvocation) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.SuperConstructorInvocation) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.SuperConstructorInvocation) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.SuperConstructorInvocation) ie)
									.getMethod(), "method"),
					TraceFunction.resolveAll(
							((javaMMinJava.SuperConstructorInvocation) ie)
									.getArguments(), "arguments"),
					TraceFunction.resolveAll(
							((javaMMinJava.SuperConstructorInvocation) ie)
									.getTypeArguments(), "typeArguments"),
					TraceFunction.resolve(
							((javaMMinJava.SuperConstructorInvocation) ie)
									.getExpression(), "expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SuperFieldAccess) {
			String trgId = TraceFunction.create(ie.getId(), "SuperFieldAccess");
			javaMMinJava.SuperFieldAccess oe = new javaMMinJava.SuperFieldAccess(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.SuperFieldAccess) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.SuperFieldAccess) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.SuperFieldAccess) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.SuperFieldAccess) ie).getQualifier(),
							"qualifier"), TraceFunction.resolve(
							((javaMMinJava.SuperFieldAccess) ie).getField(),
							"field"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SuperMethodInvocation) {
			String trgId = TraceFunction.create(ie.getId(),
					"SuperMethodInvocation");
			javaMMinJava.SuperMethodInvocation oe = new javaMMinJava.SuperMethodInvocation(
					"", TraceFunction.resolveAll(
							((javaMMinJava.SuperMethodInvocation) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.SuperMethodInvocation) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.SuperMethodInvocation) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.SuperMethodInvocation) ie)
									.getQualifier(), "qualifier"),
					TraceFunction.resolve(
							((javaMMinJava.SuperMethodInvocation) ie)
									.getMethod(), "method"),
					TraceFunction.resolveAll(
							((javaMMinJava.SuperMethodInvocation) ie)
									.getArguments(), "arguments"),
					TraceFunction.resolveAll(
							((javaMMinJava.SuperMethodInvocation) ie)
									.getTypeArguments(), "typeArguments"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SwitchCase) {
			String trgId = TraceFunction.create(ie.getId(), "SwitchCase");
			javaMMinJava.SwitchCase oe = new javaMMinJava.SwitchCase("",
					TraceFunction.resolveAll(
							((javaMMinJava.SwitchCase) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.SwitchCase) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.SwitchCase) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.SwitchCase) ie).getDefault(),
					TraceFunction.resolve(
							((javaMMinJava.SwitchCase) ie).getExpression(),
							"expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SwitchStatement) {
			String trgId = TraceFunction.create(ie.getId(), "SwitchStatement");
			javaMMinJava.SwitchStatement oe = new javaMMinJava.SwitchStatement(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.SwitchStatement) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.SwitchStatement) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.SwitchStatement) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.SwitchStatement) ie).getExpression(),
							"expression"),
					TraceFunction.resolveAll(
							((javaMMinJava.SwitchStatement) ie).getStatements(),
							"statements"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.SynchronizedStatement) {
			String trgId = TraceFunction.create(ie.getId(),
					"SynchronizedStatement");
			javaMMinJava.SynchronizedStatement oe = new javaMMinJava.SynchronizedStatement(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.SynchronizedStatement) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.SynchronizedStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.SynchronizedStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.SynchronizedStatement) ie).getBody(),
							"body"), TraceFunction.resolve(
							((javaMMinJava.SynchronizedStatement) ie)
									.getExpression(), "expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.TagElement) {
			String trgId = TraceFunction.create(ie.getId(), "TagElement");
			javaMMinJava.TagElement oe = new javaMMinJava.TagElement("",
					TraceFunction.resolveAll(
							((javaMMinJava.TagElement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.TagElement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.TagElement) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.TagElement) ie).getTagName(),
					TraceFunction.resolveAll(
							((javaMMinJava.TagElement) ie).getFragments(),
							"fragments"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.TextElement) {
			String trgId = TraceFunction.create(ie.getId(), "TextElement");
			javaMMinJava.TextElement oe = new javaMMinJava.TextElement("",
					TraceFunction.resolveAll(
							((javaMMinJava.TextElement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.TextElement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.TextElement) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.TextElement) ie).getText());
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ThisExpression) {
			String trgId = TraceFunction.create(ie.getId(), "ThisExpression");
			javaMMinJava.ThisExpression oe = new javaMMinJava.ThisExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.ThisExpression) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ThisExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ThisExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ThisExpression) ie).getQualifier(),
							"qualifier"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.ThrowStatement) {
			String trgId = TraceFunction.create(ie.getId(), "ThrowStatement");
			javaMMinJava.ThrowStatement oe = new javaMMinJava.ThrowStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.ThrowStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.ThrowStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.ThrowStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.ThrowStatement) ie).getExpression(),
							"expression"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.TryStatement) {
			String trgId = TraceFunction.create(ie.getId(), "TryStatement");
			javaMMinJava.TryStatement oe = new javaMMinJava.TryStatement(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.TryStatement) ie).getComments(),
							"comments"),
					TraceFunction.resolve(((javaMMinJava.TryStatement) ie)
							.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(((javaMMinJava.TryStatement) ie)
							.getOriginalClassFile(), "originalClassFile"),
					TraceFunction.resolve(
							((javaMMinJava.TryStatement) ie).getBody(), "body"),
					TraceFunction.resolve(
							((javaMMinJava.TryStatement) ie).getFinally(),
							"finally"), TraceFunction.resolveAll(
							((javaMMinJava.TryStatement) ie).getCatchClauses(),
							"catchClauses"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.TypeAccess) {
			String trgId = TraceFunction.create(ie.getId(), "TypeAccess");
			javaMMinJava.TypeAccess oe = new javaMMinJava.TypeAccess("",
					TraceFunction.resolveAll(
							((javaMMinJava.TypeAccess) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.TypeAccess) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.TypeAccess) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.TypeAccess) ie).getType(), "type"),
					TraceFunction.resolve(
							((javaMMinJava.TypeAccess) ie).getQualifier(),
							"qualifier"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.TypeDeclarationStatement) {
			String trgId = TraceFunction.create(ie.getId(),
					"TypeDeclarationStatement");
			javaMMinJava.TypeDeclarationStatement oe = new javaMMinJava.TypeDeclarationStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.TypeDeclarationStatement) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.TypeDeclarationStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.TypeDeclarationStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.TypeDeclarationStatement) ie)
									.getDeclaration(), "declaration"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.TypeLiteral) {
			String trgId = TraceFunction.create(ie.getId(), "TypeLiteral");
			javaMMinJava.TypeLiteral oe = new javaMMinJava.TypeLiteral("",
					TraceFunction.resolveAll(
							((javaMMinJava.TypeLiteral) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.TypeLiteral) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.TypeLiteral) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.TypeLiteral) ie).getType(), "type"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.TypeParameter) {
			String trgId = TraceFunction.create(ie.getId(), "TypeParameter");
			javaMMinJava.TypeParameter oe = new javaMMinJava.TypeParameter("",
					TraceFunction.resolveAll(
							((javaMMinJava.TypeParameter) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.TypeParameter) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.TypeParameter) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.TypeParameter) ie).getName(),
					((javaMMinJava.TypeParameter) ie).getProxy(),
					TraceFunction.resolveAll(((javaMMinJava.TypeParameter) ie)
							.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(((javaMMinJava.TypeParameter) ie)
							.getUsagesInTypeAccess(), "usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.TypeParameter) ie).getBounds(),
							"bounds"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedItem) {
			String trgId = TraceFunction.create(ie.getId(), "UnresolvedItem");
			javaMMinJava.UnresolvedItem oe = new javaMMinJava.UnresolvedItem(
					"", TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedItem) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedItem) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedItem) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedItem) ie).getName(),
					((javaMMinJava.UnresolvedItem) ie).getProxy(),
					TraceFunction.resolveAll(((javaMMinJava.UnresolvedItem) ie)
							.getUsagesInImports(), "usagesInImports"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedItemAccess) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedItemAccess");
			javaMMinJava.UnresolvedItemAccess oe = new javaMMinJava.UnresolvedItemAccess(
					"", TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedItemAccess) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedItemAccess) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedItemAccess) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedItemAccess) ie)
									.getElement(), "element"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedItemAccess) ie)
									.getQualifier(), "qualifier"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedAnnotationDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedAnnotationDeclaration");
			javaMMinJava.UnresolvedAnnotationDeclaration oe = new javaMMinJava.UnresolvedAnnotationDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
							.getName(),
					((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
							.getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getPackage(), "package"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedAnnotationDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedAnnotationTypeMemberDeclaration");
			javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration oe = new javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration(
					"",
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getComments(), "comments"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getOriginalCompilationUnit(),
									"originalCompilationUnit"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getOriginalClassFile(),
									"originalClassFile"),
					((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
							.getName(),
					((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
							.getProxy(),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getUsagesInImports(),
									"usagesInImports"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getAbstractTypeDeclaration(),
									"abstractTypeDeclaration"),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getAnnotations(), "annotations"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getAnonymousClassDeclarationOwner(),
									"anonymousClassDeclarationOwner"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getModifier(), "modifier"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getDefault(), "default"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getType(), "type"),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedAnnotationTypeMemberDeclaration) ie)
											.getUsages(), "usages"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedClassDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedClassDeclaration");
			javaMMinJava.UnresolvedClassDeclaration oe = new javaMMinJava.UnresolvedClassDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedClassDeclaration) ie).getName(),
					((javaMMinJava.UnresolvedClassDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getPackage(), "package"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getTypeParameters(), "typeParameters"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedClassDeclaration) ie)
									.getSuperClass(), "superClass"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedEnumDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedEnumDeclaration");
			javaMMinJava.UnresolvedEnumDeclaration oe = new javaMMinJava.UnresolvedEnumDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedEnumDeclaration) ie).getName(),
					((javaMMinJava.UnresolvedEnumDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getPackage(), "package"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedEnumDeclaration) ie)
									.getEnumConstants(), "enumConstants"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedInterfaceDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedInterfaceDeclaration");
			javaMMinJava.UnresolvedInterfaceDeclaration oe = new javaMMinJava.UnresolvedInterfaceDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
							.getName(),
					((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
							.getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getPackage(), "package"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedInterfaceDeclaration) ie)
									.getTypeParameters(), "typeParameters"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedLabeledStatement) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedLabeledStatement");
			javaMMinJava.UnresolvedLabeledStatement oe = new javaMMinJava.UnresolvedLabeledStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedLabeledStatement) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedLabeledStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedLabeledStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedLabeledStatement) ie).getName(),
					((javaMMinJava.UnresolvedLabeledStatement) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedLabeledStatement) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedLabeledStatement) ie)
									.getBody(), "body"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedLabeledStatement) ie)
									.getUsagesInBreakStatements(),
							"usagesInBreakStatements"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedLabeledStatement) ie)
									.getUsagesInContinueStatements(),
							"usagesInContinueStatements"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedMethodDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedMethodDeclaration");
			javaMMinJava.UnresolvedMethodDeclaration oe = new javaMMinJava.UnresolvedMethodDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedMethodDeclaration) ie).getName(),
					((javaMMinJava.UnresolvedMethodDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getBody(), "body"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getParameters(), "parameters"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getThrownExceptions(), "thrownExceptions"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getTypeParameters(), "typeParameters"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getUsagesInDocComments(),
							"usagesInDocComments"), TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getUsages(), "usages"),
					((javaMMinJava.UnresolvedMethodDeclaration) ie)
							.getExtraArrayDimensions(), TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getReturnType(), "returnType"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getRedefinedMethodDeclaration(),
							"redefinedMethodDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedMethodDeclaration) ie)
									.getRedefinitions(), "redefinitions"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedSingleVariableDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedSingleVariableDeclaration");
			javaMMinJava.UnresolvedSingleVariableDeclaration oe = new javaMMinJava.UnresolvedSingleVariableDeclaration(
					"",
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getComments(), "comments"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getOriginalCompilationUnit(),
									"originalCompilationUnit"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getOriginalClassFile(),
									"originalClassFile"),
					((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
							.getName(),
					((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
							.getProxy(),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getUsagesInImports(),
									"usagesInImports"),
					((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
							.getExtraArrayDimensions(),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getInitializer(), "initializer"),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getUsageInVariableAccess(),
									"usageInVariableAccess"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getModifier(), "modifier"),
					((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
							.getVarargs(),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getType(), "type"),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getAnnotations(), "annotations"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getMethodDeclaration(),
									"methodDeclaration"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getCatchClause(), "catchClause"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedSingleVariableDeclaration) ie)
											.getEnhancedForStatement(),
									"enhancedForStatement"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedType) {
			String trgId = TraceFunction.create(ie.getId(), "UnresolvedType");
			javaMMinJava.UnresolvedType oe = new javaMMinJava.UnresolvedType(
					"", TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedType) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedType) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedType) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedType) ie).getName(),
					((javaMMinJava.UnresolvedType) ie).getProxy(),
					TraceFunction.resolveAll(((javaMMinJava.UnresolvedType) ie)
							.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(((javaMMinJava.UnresolvedType) ie)
							.getUsagesInTypeAccess(), "usagesInTypeAccess"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedTypeDeclaration) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedTypeDeclaration");
			javaMMinJava.UnresolvedTypeDeclaration oe = new javaMMinJava.UnresolvedTypeDeclaration(
					"",
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.UnresolvedTypeDeclaration) ie).getName(),
					((javaMMinJava.UnresolvedTypeDeclaration) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getAbstractTypeDeclaration(),
							"abstractTypeDeclaration"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getAnnotations(), "annotations"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getAnonymousClassDeclarationOwner(),
							"anonymousClassDeclarationOwner"),
					TraceFunction.resolve(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getUsagesInTypeAccess(),
							"usagesInTypeAccess"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getBodyDeclarations(), "bodyDeclarations"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getCommentsBeforeBody(),
							"commentsBeforeBody"), TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getCommentsAfterBody(),
							"commentsAfterBody"), TraceFunction.resolve(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getPackage(), "package"),
					TraceFunction.resolveAll(
							((javaMMinJava.UnresolvedTypeDeclaration) ie)
									.getSuperInterfaces(), "superInterfaces"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.UnresolvedVariableDeclarationFragment) {
			String trgId = TraceFunction.create(ie.getId(),
					"UnresolvedVariableDeclarationFragment");
			javaMMinJava.UnresolvedVariableDeclarationFragment oe = new javaMMinJava.UnresolvedVariableDeclarationFragment(
					"",
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
											.getComments(), "comments"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
											.getOriginalCompilationUnit(),
									"originalCompilationUnit"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
											.getOriginalClassFile(),
									"originalClassFile"),
					((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
							.getName(),
					((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
							.getProxy(),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
											.getUsagesInImports(),
									"usagesInImports"),
					((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
							.getExtraArrayDimensions(),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
											.getInitializer(), "initializer"),
					TraceFunction
							.resolveAll(
									((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
											.getUsageInVariableAccess(),
									"usageInVariableAccess"),
					TraceFunction
							.resolve(
									((javaMMinJava.UnresolvedVariableDeclarationFragment) ie)
											.getVariablesContainer(),
									"variablesContainer"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.VariableDeclarationExpression) {
			String trgId = TraceFunction.create(ie.getId(),
					"VariableDeclarationExpression");
			javaMMinJava.VariableDeclarationExpression oe = new javaMMinJava.VariableDeclarationExpression(
					"", TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationExpression) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationExpression) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationExpression) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationExpression) ie)
									.getType(), "type"),
					TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationExpression) ie)
									.getFragments(), "fragments"),
					TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationExpression) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationExpression) ie)
									.getAnnotations(), "annotations"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.VariableDeclarationFragment) {
			String trgId = TraceFunction.create(ie.getId(),
					"VariableDeclarationFragment");
			javaMMinJava.VariableDeclarationFragment oe = new javaMMinJava.VariableDeclarationFragment(
					"", TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationFragment) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationFragment) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationFragment) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.VariableDeclarationFragment) ie).getName(),
					((javaMMinJava.VariableDeclarationFragment) ie).getProxy(),
					TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationFragment) ie)
									.getUsagesInImports(), "usagesInImports"),
					((javaMMinJava.VariableDeclarationFragment) ie)
							.getExtraArrayDimensions(), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationFragment) ie)
									.getInitializer(), "initializer"),
					TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationFragment) ie)
									.getUsageInVariableAccess(),
							"usageInVariableAccess"), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationFragment) ie)
									.getVariablesContainer(),
							"variablesContainer"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.VariableDeclarationStatement) {
			String trgId = TraceFunction.create(ie.getId(),
					"VariableDeclarationStatement");
			javaMMinJava.VariableDeclarationStatement oe = new javaMMinJava.VariableDeclarationStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationStatement) ie)
									.getComments(), "comments"),
					TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationStatement) ie)
									.getType(), "type"),
					TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationStatement) ie)
									.getFragments(), "fragments"),
					((javaMMinJava.VariableDeclarationStatement) ie)
							.getExtraArrayDimensions(), TraceFunction.resolve(
							((javaMMinJava.VariableDeclarationStatement) ie)
									.getModifier(), "modifier"),
					TraceFunction.resolveAll(
							((javaMMinJava.VariableDeclarationStatement) ie)
									.getAnnotations(), "annotations"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.WildCardType) {
			String trgId = TraceFunction.create(ie.getId(), "WildCardType");
			javaMMinJava.WildCardType oe = new javaMMinJava.WildCardType("",
					TraceFunction.resolveAll(
							((javaMMinJava.WildCardType) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.WildCardType) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.WildCardType) ie)
									.getOriginalClassFile(),
							"originalClassFile"),
					((javaMMinJava.WildCardType) ie).getName(),
					((javaMMinJava.WildCardType) ie).getProxy(),
					TraceFunction.resolveAll(((javaMMinJava.WildCardType) ie)
							.getUsagesInImports(), "usagesInImports"),
					TraceFunction.resolveAll(((javaMMinJava.WildCardType) ie)
							.getUsagesInTypeAccess(), "usagesInTypeAccess"),
					((javaMMinJava.WildCardType) ie).getUpperBound(),
					TraceFunction.resolve(
							((javaMMinJava.WildCardType) ie).getBound(),
							"bound"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

		if (ie instanceof javaMMinJava.WhileStatement) {
			String trgId = TraceFunction.create(ie.getId(), "WhileStatement");
			javaMMinJava.WhileStatement oe = new javaMMinJava.WhileStatement(
					"", TraceFunction.resolveAll(
							((javaMMinJava.WhileStatement) ie).getComments(),
							"comments"), TraceFunction.resolve(
							((javaMMinJava.WhileStatement) ie)
									.getOriginalCompilationUnit(),
							"originalCompilationUnit"), TraceFunction.resolve(
							((javaMMinJava.WhileStatement) ie)
									.getOriginalClassFile(),
							"originalClassFile"), TraceFunction.resolve(
							((javaMMinJava.WhileStatement) ie).getExpression(),
							"expression"), TraceFunction.resolve(
							((javaMMinJava.WhileStatement) ie).getBody(),
							"body"));
			oe.setTrgId(trgId);
			elems.add(oe);
		}

	}

}
