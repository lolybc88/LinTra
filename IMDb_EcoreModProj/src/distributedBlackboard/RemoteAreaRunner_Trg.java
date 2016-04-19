package distributedBlackboard;

import blackboard.IBlackboard.Policy;

public class RemoteAreaRunner_Trg {

	public static void main(String[] args) throws Exception {
		
		RemoteArea rArea2 = new RemoteArea("trgArea", Policy.NEVER_LOCK, 9897);
		rArea2.run();
		
	}
	
}
