package eMF2LinTra;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import blackboard.IdentifiableElement;

public class ModelPartitioner {

	public static void main(String[] args) throws Exception {
		String model = "/home/loli/IST_2014/eclip/ser/eclipseModel-2.5.ser";
		partition(model, 16);
	}
	
	public static void partition(String modelPath, int numOfSubmodels) throws Exception{
        
		FileOutputStream[] foss = new FileOutputStream[numOfSubmodels];
        ObjectOutputStream[] ooss = new ObjectOutputStream[numOfSubmodels];
        for (int i=0; i<numOfSubmodels; i++){
        	FileOutputStream fos = new FileOutputStream(modelPath+"-"+i);
        	foss[i] = fos;
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	ooss[i] = oos;
        }
        
        FileInputStream fis = new FileInputStream(modelPath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        
        int numObjs = 0;
        
        try{	
	        while (o != null) { 
	        	ooss[numObjs%numOfSubmodels].writeObject(((IdentifiableElement) o));
	        	numObjs++;
	        	o = ois.readObject();
	        }
        } catch (EOFException e){
        	//when this exception is thrown means that there are no more objects in the file.
        	for (int i=0; i<numOfSubmodels; i++){
            	ooss[i].close();
            	foss[i].close();
            }
//        	e.printStackTrace();
        }
        for (int i=0; i<numOfSubmodels; i++){
        	ooss[i].close();
        	foss[i].close();
        }
        System.out.println("Done!");
	}

}
