package mutations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.engine.parser.AtlParser;


public class ATLFile2Model {

	String atlFile;
	String atlModel;

	public ATLFile2Model(String atlFile, String atlModel) {
		this.atlFile = atlFile;
		this.atlModel = atlModel;
	}

	public void injectATLTrafo() throws FileNotFoundException, ATLCoreException {

		AtlParser parser=new AtlParser();

		InputStream stream = new FileInputStream(atlFile);
		IModel parseToModel = parser.parseToModel(stream);
   
		IExtractor extractor = new EMFExtractor();
		extractor.extract(parseToModel, atlModel);
	}
	
	public static void main(String args[]) throws FileNotFoundException, ATLCoreException {
		ATLFile2Model injector;

		injector = new ATLFile2Model("Example/CopyTransformation/copyTrans.atl", "Example/CopyTransformation/copyTrans_injected.xmi");
		injector.injectATLTrafo();
	
	}
}
