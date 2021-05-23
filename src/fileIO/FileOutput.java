package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

 class FileOutput {

	//write content to a file from an object 
	public void writeDataToFile(ArrayList<String> arrayList, String fileAddress) {
		System.out.println("Start to write data...\n");  //Give operation tips
		
		//generate FileWriter object
		FileWriter fw = getConnection(fileAddress);
		//write content to file
		try {
			fw.write("\n\n");
			for (String string: arrayList) {
				fw.write(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//close FileWriter object
		closeConnection(fw);
		System.out.println("Write data finished.");
		
	}
	
	//generate FileWriter object
	private FileWriter getConnection(String fileAddress) {
		FileWriter fr = null;
		try {
			fr = new FileWriter(fileAddress, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fr;
	}
	
	//close FileWriter object
	private  void closeConnection(FileWriter fr) {
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Please make sure that the file path and read and write permissions are correct.
	 // If there is no write permission, the write will be an exception.
	
}
