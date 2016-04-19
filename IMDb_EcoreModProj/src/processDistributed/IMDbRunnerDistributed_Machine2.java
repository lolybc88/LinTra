package processDistributed;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import movies.MoviesFactory;
import movies.MoviesPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import distributed.Identity;
import jIMDb.Actor;
import jIMDb.Movie;
import blackboard.BlackboardException;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import runners.MTLauncher1Input1Output;
import transfo.LinTraParameters;


public class IMDbRunnerDistributed_Machine2 {

	public static void main(String[] args) throws Exception {
		
		MTLauncher1Input1OutputDistributed_Machine2 mtLauncher =
				new MTLauncher1Input1OutputDistributed_Machine2("localhost", 9895, 9894, 9893, 9896, 9897);
		
		Thread.sleep(9000);
		
		int numThreads = LinTraParameters.NUMBER_OF_THREADS_T1;
		
		double time = mtLauncher.launch(new Identity(mtLauncher.getSrcArea(), mtLauncher.getTrgArea()), numThreads);
		System.out.println(time);
		
		System.out.println("Num elements src: " + mtLauncher.getSrcArea().size());
		System.out.println("Num elements trg: " + mtLauncher.getTrgArea().size());
			
		mtLauncher.getSrcArea().clear();
		mtLauncher.getTrgArea().clear();
		
	}
}