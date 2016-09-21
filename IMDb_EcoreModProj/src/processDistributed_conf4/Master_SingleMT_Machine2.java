package processDistributed_conf4;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import transfo.*;
import blackboard.BlackboardException;
import blackboard.HashMapArea;
import blackboard.IArea;
import blackboard.IBlackboard.Policy;
import blackboard.IdentifiableElement;

public class Master_SingleMT_Machine2 implements IMaster {

	IArea workToDoArea, srcArea;
	int numThreads;
	
	public Master_SingleMT_Machine2(IArea workTODOArea, IArea srcModelArea, int numThreads) {
		this.workToDoArea = workTODOArea;
    	this.srcArea = srcModelArea;
    	this.numThreads = numThreads;
	}
	
	public synchronized void organizeWork(IArea area, double cutId, double maxId) throws BlackboardException {
		/* Inizialize workTODOArea */
    	ToDo todo_machine1 = new ToDo(); 
    	double i = cutId;
    	int increase = computeOptimalIncrease(numThreads, maxId, LinTraParameters.JOB_SIZE);
    	while(i<maxId){
    		todo_machine1.add(new Job(i+1, i+increase));
    		i=i+increase;
    	}
    	workToDoArea.write(todo_machine1);
	}

	private synchronized int computeOptimalIncrease(int numThreads, double maxId, int workExcerptSize) {
		int increase;
		if (maxId / numThreads <  1){
    		increase = 1;
    	} else if (maxId / numThreads <  workExcerptSize){
    		increase = (int) (maxId / numThreads);
    	} else {
    		increase = workExcerptSize;
    	}
		return increase;
	}
	
}
