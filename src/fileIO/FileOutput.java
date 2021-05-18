package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOutput {

	public static void writeDataToFile(ArrayList<String> arrayList, String fileAddress) {
		System.out.println("Start to write data...\n");
		FileWriter fw = getConnection(fileAddress);
		try {
			fw.write("\n\n");
			
			for (String string: arrayList) {
				fw.write(string);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		closeFileWriter(fw);
		
		System.out.println("Write data finished.");
		
	}

	
	private static FileWriter getConnection(String fileAddress) {
		
		FileWriter fr = null;

		try {
			fr = new FileWriter(fileAddress, true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fr;
	}
	
	private static void closeFileWriter(FileWriter fr) {
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
