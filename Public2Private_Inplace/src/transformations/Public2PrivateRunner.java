package transformations;

import runners.MTLauncherInplace;
import transfo.ITransformation;
import transfo.LinTraParameters;

public class Public2PrivateRunner {
	
	public static void main(String[] args) throws Exception {
		
		MTLauncherInplace mtli = new MTLauncherInplace();
		mtli.createBlackboard();
		mtli.loadModel("C:/Users/Atenea/Desktop/eclipseModel/eclipseModels-CaseStudy/eclipseModel-0.1.ser");
		
		ITransformation t = new Public2Private(mtli.getSrcArea(), mtli.getTrgArea());
		double time = mtli.launch(t, LinTraParameters.NUMBER_OF_THREADS_T1);
		System.out.println(time);
		System.out.println(mtli.getSrcArea().size());
		System.out.println(mtli.getTrgArea().size());
		
		mtli.destroy();
	}
}
