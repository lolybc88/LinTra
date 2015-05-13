package caseStudies;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

public class TransfoRunnerInplaceEMFTVM {

	public double runTransformation(String uriInMM, Object inMMPackageImpl, String inMMName,
			String inModelP, String outModelP,
			String moduleFolder, String moduleName
			)
					throws ATLCoreException, IOException, MalformedURLException, FileNotFoundException {
		
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(EmftvmPackage.eNS_URI,	EmftvmPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());
		
		rs.getPackageRegistry().put(uriInMM, inMMPackageImpl);
		
		// Load metamodels
		Metamodel mm1 = EmftvmFactory.eINSTANCE.createMetamodel();
		mm1.setResource(rs.getResource(URI.createURI(uriInMM), true));
		env.registerMetaModel(inMMName, mm1);
		
		
//		// Load models
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(rs.getResource(URI.createURI(inModelP, true), true));
		env.registerInOutModel("IN", inModel);


//		System.out.println("Model loaded");
		
		// Load and run module
		ModuleResolver mr = new DefaultModuleResolver(moduleFolder, rs);
		TimingData td = new TimingData();
		env.loadModule(mr, moduleName);
		td.finishLoading();
		
		double time = System.currentTimeMillis();
		env.run(td);
		double timeF = (System.currentTimeMillis() - time)/1000;
		td.finish();

		// Save models
//		outModel.getResource().save(Collections.emptyMap());
		
		env.clearModels();
		
		return timeF;
		
	}	

}