package transformations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import prefuseGraphInJava.Edge;
import prefuseGraphInJava.Node;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import runners.MTChainLauncher;
import transfo.ITransformation;
import transfo.LinTraParameters;

public class Runner {

	public static void main(String[] args) throws Exception {

//		String[] model = {"C:/Users/Loli/Desktop/eclipseModel/eclipseModel-mini.ser"};
//		String[] model = {"/home/loli/IST_2014/eclipseModel/eclipseModel-mini.ser"};
		
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
		
		String name = "/home/loli/IST_2014/eclip/ser/eclipseModel-2.5.ser-";
		String[] model = { name + "0", name + "1", name + "2", name + "3",
				name + "4", name + "5", name + "6", name + "7", name + "8",
				name + "9", name + "10", name + "11", name + "12", name + "13",
				name + "14", name + "15"};

		
		for (int i=0; i<20; i++){
		MTChainLauncher mtLauncher1 = new MTChainLauncher();
		mtLauncher1.createBlackboard();

		ITransformation t2 = new ReduceGraph(mtLauncher1.getTrg1Area(),
				mtLauncher1.getTrg1ModelFlagsArea(),
				mtLauncher1.getCurrentIdArea2(),
				mtLauncher1.getIdCorrespondences1(),
				mtLauncher1.getIdCorrespondences2(), mtLauncher1.getTrg2Area(),
				mtLauncher1.getTrg2ModelFlagsArea());
		ITransformation t1 = new Java2PrefuseGraph(
				mtLauncher1.getSrcArea(), mtLauncher1.getSrcModelFlagsArea(),
				mtLauncher1.getCurrentIdArea(),
				mtLauncher1.getIdCorrespondences1(), mtLauncher1.getTrg1Area(),
				mtLauncher1.getTrg1ModelFlagsArea(), t2);
		
		
//		ITransformation t2 = new Identity(mtLauncher1.getTrg1Area(),
//				mtLauncher1.getTrg1ModelFlagsArea(),
//				mtLauncher1.getCurrentIdArea2(),
//				mtLauncher1.getIdCorrespondences2(), mtLauncher1.getTrg2Area(),
//				mtLauncher1.getTrg2ModelFlagsArea(), null);
//		ITransformation t1 = new Identity(
//				mtLauncher1.getSrcArea(), mtLauncher1.getSrcModelFlagsArea(),
//				mtLauncher1.getCurrentIdArea(),
//				mtLauncher1.getIdCorrespondences1(), mtLauncher1.getTrg1Area(),
//				mtLauncher1.getTrg1ModelFlagsArea(), t2);

		double time;
		if (LinTraParameters.T1_AND_THEN_T2){
			time = mtLauncher1.launch_T1_then_T2(model, t1, t2);
		} else {
			time = mtLauncher1.launch_T1_T2_in_Parallel(model, t1, t2);
		}
	

//		System.out.println("\n\n------ SUMMARY ------\nNum elements src: " + mtLauncher1.getSrcArea().size());
//		System.out.println("Num elements trg1: " + mtLauncher1.getTrg1Area().size());
//		System.out.println("Num elements trg2: " + mtLauncher1.getTrg2Area().size());
//		System.out.println("Tranfo time: " + time + " secs.\n");
		System.out.println(time);
//		mtLauncher1.getTrg1Area().print();
//		mtLauncher1.getTrg2Area().print();

		/** Model 2 Text */
//		 prefuseGraph_M2T(mtLauncher1.getTrg2Area(), "C:/Users/Loli/Desktop/javaDependencies.xml");

		mtLauncher1.destroy();
		}
	}

	private static void prefuseGraph_M2T(IArea trgArea, String path)
			throws BlackboardException, IOException {
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		bw.write("<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\">\n");
		bw.write("<graph edgedefault=\"directed\">\n");
		bw.write("<key id=\"name\" for=\"node\" attr.name=\"name\" attr.type=\"string\"/>\n");
		bw.write("<key id=\"type\" for=\"node\" attr.name=\"type\" attr.type=\"string\"/>\n");
		bw.write("<key id=\"size\" for=\"node\" attr.name=\"size\" attr.type=\"double\"/>\n");
		
		bw.write("<node id=\"0.0\"><data key=\"name\">root</data><data key=\"type\">N</data><data key=\"size\">1.0</data></node>\n");
		for (IdentifiableElement ie : trgArea.read(trgArea.size())) {
			if (ie instanceof prefuseGraphInJava.Node) {
				bw.write("<node id=\"" + ((Node) ie).getTrgId() + "\">"
							+"<data key=\"name\">" + ((Node) ie).getName().replace("<", "").replace(">", "") + "</data>"
							+ "<data key=\"type\">"+ ((Node)ie).getType() +"</data>" 
							+ "<data key=\"size\">"+ ((Node)ie).getSize() +"</data>"	
						+ "</node>\n");
				bw.write("<edge id=\"" + ((Node) ie).getTrgId()
						+ "\" source=\"0.0\" target=\""
						+ ((Node) ie).getTrgId() + "\"></edge>\n");
			} else if (ie instanceof prefuseGraphInJava.Edge) {
				bw.write("<edge id=\"" + ((Edge) ie).getTrgId()
						+ "\" source=\"" + ((Edge) ie).getSourceId()
						+ "\" target=\"" + ((Edge) ie).getTargetId()
						+ "\"></edge>\n");
			}
		}
		bw.write("</graph>\n</graphml>");
		bw.close();
	}

}
