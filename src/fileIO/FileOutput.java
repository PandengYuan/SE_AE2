package fileIO;


import java.io.FileWriter;
import java.io.IOException;
import business.ListOfObject;

public class FileOutput {

	public static void writeDataToFile(ListOfObject[] listOfObject, String fileAddress) {
		System.out.println("Start to write data...\n");
		FileWriter fw = getConnection(fileAddress);
		try {
			fw.write("\n");
			
			for (ListOfObject o : listOfObject) {
				fw.write(o.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		closeFileWriter(fw);
		
		System.out.println("Write data finished.");
		
	}

	
	public static FileWriter getConnection(String fileAddress) {
		
		FileWriter fr = null;

		try {
			fr = new FileWriter(fileAddress, true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fr;
	}
	
	public static void closeFileWriter(FileWriter fr) {
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
