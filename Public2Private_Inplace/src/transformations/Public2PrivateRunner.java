package transformations;

import java.io.ObjectInputStream.GetField;

import runners.MTLauncherInplace;
import transfo.ITransformation;
import transfo.LinTraParameters;

public class Public2PrivateRunner {
	
	public static void main(String[] args) throws Exception {
		
		MTLauncherInplace mtli = new MTLauncherInplace();
		mtli.createBlackboard();
		mtli.loadModel("C:/Users/Atenea/Desktop/eclipseModel/eclipseModels-CaseStudy/eclipseModel-0.1.ser");
//		mtli.loadModel("C:/Users/Loli/Desktop/eclipseModel-0.1.ser");
//		mtli.loadModel("C:/Users/Loli/Desktop/LinTraGit/Public2Private_Inplace/inModels/org.eclipse.ease.engine.javascript_java.ser");
		
		ITransformation t = new Public2Private(mtli.getSrcArea(), mtli.getTrgArea(), mtli.getCurrentIdArea(), mtli.getIdCorrespondencesArea(), mtli.getDeletesArea());
		double time = mtli.launch(t, null, LinTraParameters.NUMBER_OF_THREADS_T1);
		System.out.println(time);
//		mtli.getSrcArea().print();
		System.out.println(mtli.getSrcArea().size());
		System.out.println(mtli.getTrgArea().size());
		
		mtli.destroy();
	}
}
