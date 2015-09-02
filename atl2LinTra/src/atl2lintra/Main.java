package atl2lintra;

import java.io.FileNotFoundException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import mutations.ATLFile2Model;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, ATLCoreException {
		
		ATLFile2Model atl2m = new ATLFile2Model("files/Java2Graph.atl", "files/Java2Graph.xmi");
		atl2m.injectATLTrafo();
		
		System.out.println("Done!");

	}

}
