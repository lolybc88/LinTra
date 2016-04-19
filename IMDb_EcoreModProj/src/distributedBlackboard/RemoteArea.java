package distributedBlackboard;

import java.util.LinkedList;
import java.util.List;

import blackboard.BlackboardException;
import blackboard.HashMapArea;
import blackboard.IArea;
import blackboard.IdentifiableElement;
import blackboard.IBlackboard.Policy;

import java.net.*;
import java.io.*;


public class RemoteArea implements Runnable {
	
	IArea area;
	int port;
	boolean close;

	public RemoteArea(String name, Policy p, int port) throws BlackboardException {
		area = new HashMapArea(name, p);
		this.port = port;
		close = false;
	}
	
	@Override
	public void run() {
		
		try {
		
		ServerSocket ss = new ServerSocket(port);
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		
		OutputStream os = s.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		boolean close = false;
		
		while (!close) {	
		
			Object o = ois.readObject();
			
			if (o instanceof String) {
				if (((String)o).equals(CommunProtocolKeyWords.DESTROY)) {
					// the string "close" has been received, the area must be deleted and the connection stopped
					oos.writeObject("ok");
					close = true;
				} else if (((String)o).equals(CommunProtocolKeyWords.CLEAR)) {
					area.clear();
				} else if (((String)o).equals(CommunProtocolKeyWords.SIZE)) {
					oos.writeObject((Integer)area.size());
				} else {
					// An identifier has been received, the corresponding object must be sent
					String id = (String) o;
					// System.out.println("identifier received"+id);
					IdentifiableElement ie = area.read(id);
					oos.writeObject(ie);
				}
			} else if (o instanceof IdentifiableElement) {
				// An object has been received, it has to be stored in the area
				// System.out.println("element received"+o);
				area.write((IdentifiableElement)o);
				oos.writeObject(CommunProtocolKeyWords.OK);
			} else if (o instanceof List<?>){
				if (o!=null && ((List<?>)o).size()!=0){ 
					if(((List<?>)o).get(0) instanceof String)
			        {
						// a list of identifiers has been received, the corresponding elements must be sent
						// System.out.println("list of identifiers received"+o);
						List<String> ids = (List<String>) o;
						List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();
						for (String id : ids){
							IdentifiableElement e = area.read(id);
							if (id!=null){
								elems.add(area.read(id));
							}
						}
						oos.writeObject(elems);
			        } else if (((List<?>)o).get(0) instanceof IdentifiableElement){
			        	// A list of identifiableElements has been received, they has to be stored
			        	// System.out.println("list of elements received"+o);
			        	for (Object ob : ((List<?>)o) ){
			        		area.write((IdentifiableElement)ob);
			        	}
//			        	oos.writeObject(new String(CommunProtocolKeyWords.OK));
			        }
				}
			}
		}
			
		if (close) {
			area.clear();
			is.close();
			ss.close();
			os.close();
			oos.close();
			s.close();
		}
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
	}
}
