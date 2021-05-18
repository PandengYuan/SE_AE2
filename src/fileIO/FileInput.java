package fileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
	
	public static ArrayList<String> loadFile(String fileAddress) {
		
		ArrayList<String> fileContent = new ArrayList<String>();
		FileReader fr = getConnection(fileAddress);
		Scanner scanner = new Scanner(fr);
		
		while(scanner.hasNextLine()) {
			fileContent.add(scanner.nextLine());
		}
		
		scanner.close();
		closeConnection(fr);
	
		return fileContent;
	}

	
	private static FileReader getConnection(String fileAddress) {
		
		FileReader fr = null;
		try {
			fr = new FileReader(fileAddress);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return fr;
	}
	
	private static void closeConnection(FileReader fr) {
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
