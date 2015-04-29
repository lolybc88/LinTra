package testsABCLinTra;

import abcMM.*;
import blackboard.BlackboardException;
import blackboard.IArea;
import runners.MTLauncherInplace;
import transfo.CurrentId;
import transfo.ITransformation;
import transfo.LinTraParameters;

public class ABCRunner {
	
	public static void main(String[] args) throws Exception {
		
		MTLauncherInplace mtli = new MTLauncherInplace();
		mtli.createBlackboard();
		
		createModel(mtli.getSrcArea(), mtli.getTrgArea(), mtli.getCurrentIdArea());
		
		ITransformation t = new CreationAndResolveTemp(mtli.getSrcArea(), mtli.getTrgArea(), mtli.getCurrentIdArea(), mtli.getIdCorrespondencesArea());
		double time = mtli.launch(t, LinTraParameters.NUMBER_OF_THREADS_T1);
		System.out.println(time);
		System.out.println(mtli.getSrcArea().size());
		System.out.println(mtli.getTrgArea().size());
		mtli.getSrcArea().print();
		mtli.getTrgArea().print();
		mtli.getIdCorrespondencesArea().print();
		
		mtli.destroy();
	}

	private static void createModel(IArea srcArea, IArea trgArea, IArea currentIdArea) throws BlackboardException {
		A a = new A("1.0", "", "myA", null); srcArea.write(a); trgArea.write(a);
		B b = new B("2.0", "", "myB", null, "1.0"); srcArea.write(b); trgArea.write(b);
		C c1 = new C("3.0", "", "myC1"); srcArea.write(c1); trgArea.write(c1);
		C c2 = new C("4.0", "", "myC2"); srcArea.write(c2); trgArea.write(c2);
		C c3 = new C("5.0", "", "myC3"); srcArea.write(c3); trgArea.write(c3);
		CurrentId cid = new CurrentId(6.0);
		currentIdArea.write(cid);
	}
	
	
}
