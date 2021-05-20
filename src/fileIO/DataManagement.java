package fileIO;

import java.util.ArrayList;

public class DataManagement {
	
	//the method of loading data
	public  ArrayList<String> loadData(String fileAddress) {
		//use the loadFile method of FileInput object
		return new FileInput().loadFile(fileAddress);
	}
	
	//the method of writing data
	public void writeData(ArrayList<String> arrayList, String fileAddress) {
		//use the writeDataToFile method of FileOutput object
		new FileOutput().writeDataToFile(arrayList, fileAddress);
	}

}
