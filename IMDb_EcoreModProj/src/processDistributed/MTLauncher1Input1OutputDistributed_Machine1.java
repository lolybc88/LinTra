package processDistributed;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.Remote;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import transfo.IMaster;
import transfo.ITransformation;
import transfo.Master_SingleMT;
import transfo.ModelLoader_Single;
import transfo.Slave_SingleMT;
import blackboard.*;
import blackboard.IBlackboard.Policy;

public class MTLauncher1Input1OutputDistributed_Machine1 {
	
	DistributedBlackboard_Machine1 blackboard;
	IArea workTODOArea, srcModelArea, trgModelArea;
	private String remoteAreaIP;
	private int srcModelAreaPort_M1, trgModelAreaPort_M1, todoModelAreaPort_M1,
		srcModelAreaPort_M2, trgModelAreaPort_M2, todoModelAreaPort_M2;
	
	public MTLauncher1Input1OutputDistributed_Machine1(String remoteAreaIP,
			int srcModelAreaPort_M1, int trgModelAreaPort_M1,
			int todoModelAreaPort_M1, int todoModelAreaPort_M2,
			int srcModelAreaPort_M2, int trgModelAreaPort_M2) {
		this.remoteAreaIP = remoteAreaIP;
		this.srcModelAreaPort_M1 = srcModelAreaPort_M1;
		this.trgModelAreaPort_M1 = trgModelAreaPort_M1;
		this.todoModelAreaPort_M1 = todoModelAreaPort_M1;
		this.todoModelAreaPort_M2 = todoModelAreaPort_M2;
		this.srcModelAreaPort_M2 = srcModelAreaPort_M2;
		this.trgModelAreaPort_M2 = trgModelAreaPort_M2;
		
	}
	
	public IArea getSrcArea(){
		return srcModelArea;
	}
	
	public IArea getTrgArea(){
		return trgModelArea;
	}

	public void setSrcArea(IArea srcArea){
		srcModelArea = srcArea;
	}

	public void createBlackboard() throws BlackboardException{
		blackboard = new DistributedBlackboard_Machine1(remoteAreaIP);
//		workTODOArea = blackboard.createLocalArea("processorSpace", Policy.LOCK_TO_READ);
		workTODOArea = blackboard.createArea("processorSpace", Policy.LOCK_TO_READ);
		srcModelArea = blackboard.createArea("processorSpace_Src", Policy.NEVER_LOCK);
		trgModelArea = blackboard.createArea("processorSpace_Trg", Policy.NEVER_LOCK);
		
	}
	
	public void createServers() throws BlackboardException{
		// We need to create this server associated to the area for other machines to get connected to this machine and access its content
//		createServerForArea((HashMapArea)workTODOArea, todoModelAreaPort_M1);
		createServerForArea((DistributedArea_Machine1)workTODOArea, todoModelAreaPort_M1);
		createServerForArea((DistributedArea_Machine1)srcModelArea, srcModelAreaPort_M1);
		createServerForArea((DistributedArea_Machine1)trgModelArea, trgModelAreaPort_M1);
	}
	
	
	private void createServerForArea(HashMapArea area, int port) throws BlackboardException {
		Thread t = new Thread(new AreaServer(((HashMapArea)workTODOArea).getArea(), port));
		t.start();
	}
	
	private void createServerForArea(DistributedArea_Machine1 area, int port) throws BlackboardException {
		Thread t = new Thread(new AreaServer(area.getLocalSubArea(), port));
		t.start();
	}
	
	public void connectToRemoteSubAreas() throws BlackboardException{
		((DistributedArea_Machine1)workTODOArea).connectToRemoteSubArea(remoteAreaIP, todoModelAreaPort_M2);
		((DistributedArea_Machine1)srcModelArea).connectToRemoteSubArea(remoteAreaIP, srcModelAreaPort_M2);
		((DistributedArea_Machine1)trgModelArea).connectToRemoteSubArea(remoteAreaIP, trgModelAreaPort_M2);
	}

	public void loadModel(String[] modelPath) throws Exception {
		List<Thread> ts = new LinkedList<Thread>();
		for (int i=0; i<modelPath.length; i++){
			Thread t = new Thread(new ModelLoader_Single(modelPath[i], srcModelArea));
			ts.add(t);
			t.start();
		}
		for (int i=0; i<modelPath.length; i++){
			ts.get(i).join();
		}
	}
	
	public void loadModel(String modelPath) throws Exception {
		ModelLoader_Single mls = new ModelLoader_Single(modelPath, srcModelArea);
		mls.run();
	}
	
	public double launch(ITransformation transfo, int numThreads) throws Exception{
		
		double maxId = srcModelArea.size();
		
		IMaster master = new Master_SingleMT(workTODOArea, srcModelArea, numThreads);
		((Master_SingleMT)master).organizeWork(srcModelArea, maxId);
		
		double time0 = System.currentTimeMillis();
		
		List<Thread> ts = new LinkedList<Thread>();
		for (int j=0; j<numThreads; j++){
			Thread t = new Thread(new Slave_SingleMT(j, transfo, workTODOArea, srcModelArea));
			t.start();
			ts.add(t);
    	}
		for (int j=0; j<ts.size(); j++){
			ts.get(j).join();
		}
		double timeF = (System.currentTimeMillis() - time0) / 1000;
		
		return timeF;
	}

	public void destroy() {
		blackboard.destroyArea(srcModelArea);
		blackboard.destroyArea(trgModelArea);
		blackboard.destroyArea(workTODOArea);
	}
	
	public void clearTrgAndTodo(){
		blackboard.clearArea(trgModelArea);
		blackboard.clearArea(workTODOArea);
	}

	public void serialize(IArea trgArea, String modelPath) throws BlackboardException, IOException {
		
		FileOutputStream fis = new FileOutputStream(modelPath);
		ObjectOutputStream ois = new ObjectOutputStream(fis);
		
		Collection<IdentifiableElement> elems;
		while(trgArea.size()!=0){
			elems = trgArea.take(1000);
			for (IdentifiableElement ie : elems){
				ois.writeObject(ie);
			}
		}
		ois.close();
		fis.close();
	}
	
}
