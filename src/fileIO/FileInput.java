package fileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 class FileInput {
	
	public  ArrayList<String> loadFile(String fileAddress) {
		
		ArrayList<String> fileContent = new ArrayList<String>();
		
		System.out.println("Start to load data...");
		FileReader fr = (FileReader) getConnection(fileAddress);
		Scanner scanner = new Scanner(fr);
		
		while(scanner.hasNextLine()) {
			fileContent.add(scanner.nextLine());
		}
		
		scanner.close();
		closeConnection(fr);
		System.out.println("Load data finished.");
		
		return fileContent;
	}
	
	private  FileReader getConnection(String fileAddress) {
		
		FileReader fr = null;
		try {
			fr = new FileReader(fileAddress);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return fr;
	}
	
	private  void closeConnection(FileReader fr) {
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
