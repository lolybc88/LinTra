package distributedBlackboard;

import blackboard.IBlackboard.Policy;

public class RemoteAreaRunner_Src {

	public static void main(String[] args) throws Exception {
		
		RemoteArea rArea = new RemoteArea("srcArea", Policy.NEVER_LOCK, 9896);
		rArea.run();
		
	}
	
}
