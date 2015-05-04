package transformations;

import runners.MTLauncher1Input1Output;
import transfo.ITransformation;
import transfo.LinTraParameters;

public class Public2PrivateRunner_OutPlace {

	public static void main(String[] args) throws Exception {

//		String[] model = {"C:/Users/Loli/Desktop/eclipseModel/eclipseModel-mini.ser"};
//		String[] model = {"/home/loli/IST_2014/eclip/ser/eclipseModel-mini.ser"};
		
//		String[] model = {
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-0"};
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-1",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-2",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-3"};
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-4",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-5",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-6",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-7"};
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-8",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-9",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-10",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-11"};
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-12",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-13",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-14",
//				"C:/Users/Loli/Desktop/eclipseModel/eclipseModel.ser-15"};
		
		String[] model = {
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-0.1.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-0.2.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-0.5.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-1.0.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-1.5.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-2.0.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-2.5.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-3.0.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-3.5.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-4.0.ser",
//				"/home/loli/IST_2014/eclip/ser/eclipseModel-all.ser"
				
				"C:/Users/Atenea/Desktop/eclipseModel/eclipseModels-CaseStudy/eclipseModel-0.1.ser"
				};

		for (int k=0; k<model.length;k++){
//			System.out.println("** "+model[k]+ " **");
			
		MTLauncher1Input1Output mtLauncher1 = new MTLauncher1Input1Output();
		mtLauncher1.createBlackboard();
		mtLauncher1.loadModel(model[k]);
		
		ITransformation t1 = new Public2Private_OutPlace(
				mtLauncher1.getSrcArea(), mtLauncher1.getTrgArea());
	
		for (int i=0; i<10; i++){
			
			mtLauncher1.getTrgArea().clear();
			
			double time = mtLauncher1.launch(t1, LinTraParameters.NUMBER_OF_THREADS_T1);
		
//			System.out.println("\n\n------ SUMMARY ------\nNum elements src: " + mtLauncher1.getSrcArea().size());
//			System.out.println("Num elements trg: " + mtLauncher1.getTrgArea().size());
//			System.out.println("Tranfo time: " + time + " secs.\n");
			System.out.print(time+"\t");
		}
//		mtLauncher1.getTrg1Area().print();
//		mtLauncher1.getTrg2Area().print();

		/** Model 2 Text */
//		 prefuseGraph_M2T(mtLauncher1.getTrg2Area(), "C:/Users/Loli/Desktop/javaDependencies.xml");

		mtLauncher1.destroy();
	}
	}
}
