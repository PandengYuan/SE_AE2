package fileIO;

import java.util.ArrayList;

public class DataManagement {
	
	public  ArrayList<String> loadData(String fileAddress) {
		return new FileInput().loadFile(fileAddress);
	}
	
	public void writeData(ArrayList<String> arrayList, String fileAddress) {
		new FileOutput().writeDataToFile(arrayList, fileAddress);
	}

}
