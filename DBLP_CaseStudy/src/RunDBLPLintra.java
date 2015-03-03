import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ICMTAuthor.*;
import ICMTAuthor.impl.AuthorImpl;
import ICMTAuthor.impl.ConferenceImpl;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import runners.MTLauncher1Input1Output;
import transfo.ITransformation;
import transfo.LinTraParameters;


public class RunDBLPLintra {

	public static void main(String[] args) throws Exception {
		
		String[] model = {"/home/loli/IST_2014/dblp.ser"};
//		String[] model = {"C:/Users/Atenea/Dropbox/PhD/Atenea02/wsLinTra/DBLP_Aux/src/dblp.ser"};
		
		for (int i=0; i<20; i++){
		
//		double time0 = System.currentTimeMillis();
		MTLauncher1Input1Output mtLauncher = new MTLauncher1Input1Output();
		mtLauncher.createBlackboard();
		
		mtLauncher.loadModel(model);
		
//		System.out.println("Num elements src: " + mtLauncher.getSrcArea().size());
//		double time1 = System.currentTimeMillis();
		
		double time = launch(mtLauncher, new DBLP_v5(mtLauncher.getSrcArea(), mtLauncher.getTrgArea()));
//		double time2 = System.currentTimeMillis();
//		System.out.println("Model transformed in: "+ time + " secs.");
		System.out.println(time);
//		System.out.println("Num elements trg: " + mtLauncher.getTrgArea().size());
		
//		writeCVSFile(mtLauncher.getTrgArea(), "src/icmt_v3.cvs");
//		serializeICMTAuthorModel(mtLauncher.getTrgArea(), "src/icmt_v1.xmi");
		
		
		mtLauncher.destroy();
		
		}
		
//		double time3 = System.currentTimeMillis();
//		System.out.print("Total time: "+(time3-time0)/1000);
	}
	
	private static void writeCVSFile(IArea trgArea, String string) throws BlackboardException, IOException {
		Collection<IdentifiableElement> c = trgArea.read(trgArea.size());
		Map<String, IdentifiableElement> jElems = toCollectionToMap(c);
		c.clear();
		FileWriter fw = new FileWriter(string);
		BufferedWriter bw = new BufferedWriter(fw);
		for (IdentifiableElement e : jElems.values()){
			if (e instanceof jICMTAuthor.Author){
				jICMTAuthor.Author ja = (jICMTAuthor.Author)e;
				bw.write(ja.getName() + /*"\t" + ja.getNumberPapers()  +  "\t" + ja.isActive() + */"\n");
//				for (String id : ja.getPublishingIn()){
//					jICMTAuthor.Conference jc = (jICMTAuthor.Conference) trgArea.read(id);
//					bw.write("\t" + jc.getName() + "\n");
//				}
			}
//			if (e instanceof jICMTAuthor.Conference){
//				jICMTAuthor.Conference jc = (jICMTAuthor.Conference)e;
//				bw.write(jc.getName() + "\n");
//			}
		}
		bw.close();
		fw.close();
	}


	private static void serializeICMTAuthorModel(IArea trgArea, String pathXMI) throws BlackboardException {
		// Initialize the model
		ICMTAuthorPackage.eINSTANCE.eClass();
		// Retrieve the default factory singleton
		ICMTAuthorFactory factory = ICMTAuthorFactory.eINSTANCE;

		// As of here we preparing to save the model content
		// Register the XMI resource factory for the .website extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// create a resource
		Resource resource = resSet.createResource(URI.createURI(pathXMI));

		System.out.println("Adding to XMI resource...");
		// In order to serialize to an XMI file, the whole model will be eventually stored in the single machine memory that is serializing the model (in eobjects).
		// This happens because it is the only way to serialize the references between objects.
		Collection<IdentifiableElement> c = trgArea.read(trgArea.size());
		Map<String, IdentifiableElement> jElems = toCollectionToMap(c);
		c.clear();
		Map<String, EObject> eObjects = new HashMap<String, EObject>();
		// first iteration: we create the objects
		for (IdentifiableElement e : jElems.values()){
			if (e instanceof jICMTAuthor.Author){
				jICMTAuthor.Author ja = (jICMTAuthor.Author)e;
				ICMTAuthor.impl.AuthorImpl author = new ICMTAuthor.impl.AuthorImpl();
				author.setName(ja.getName());
				author.setActive(ja.isActive());
				author.setNumOfPapers(ja.getNumberPapers());
				eObjects.put(ja.getId(), author);
			} else if (e instanceof jICMTAuthor.Conference){
				jICMTAuthor.Conference jconf = (jICMTAuthor.Conference)e;
				ICMTAuthor.impl.ConferenceImpl conf = new ICMTAuthor.impl.ConferenceImpl();
				conf.setName(jconf.getName());
				eObjects.put(jconf.getId(), conf);
			}
		}
		// second iteration: we create the references
		for (IdentifiableElement e : jElems.values()){
			if (e instanceof jICMTAuthor.Author){
				jICMTAuthor.Author ja = (jICMTAuthor.Author)e;
				ICMTAuthor.impl.AuthorImpl author = (AuthorImpl) eObjects.get(ja.getId());
				if (ja.getPublishingIn()!=null){
					for (String id : ja.getPublishingIn()){
						ICMTAuthor.impl.ConferenceImpl conf = (ConferenceImpl) eObjects.get(id);
						if (conf!=null){
							author.getPublishesIn().add(conf);
						}
					}
				}
				if (ja.getCoauthors()!=null){
					for (String id : ja.getCoauthors()){
						ICMTAuthor.impl.AuthorImpl coauth = (AuthorImpl) eObjects.get(id);
						if (coauth!=null){
							author.getCoauthor().add(coauth);
						}
					}
				}
			}
		}
		//third iteration: add all EObject to the resource
		for (EObject e : eObjects.values()) {
			resource.getContents().add(e);
		}
		
		// now save the content.
		try {
			System.out.println("Saving XMI resource...");
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	private static Map<String, IdentifiableElement> toCollectionToMap(
			Collection<IdentifiableElement> c) {
		Map<String, IdentifiableElement> map = new HashMap<String, IdentifiableElement>();
		for (IdentifiableElement e : c){
			map.put(e.getId(), e);
		}
		return map;
	}

	private static double launch(MTLauncher1Input1Output mtLauncher, ITransformation transfo) throws Exception {
		mtLauncher.clearTrgAndTodo();
		int numThreads = LinTraParameters.NUMBER_OF_THREADS_T1;
		return mtLauncher.launch(transfo, numThreads);
	}
	
}