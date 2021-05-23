package fileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 class FileInput {
	
	//read content from a file and generate an object containing file content
	public  ArrayList<String> loadFile(String fileAddress) {
		ArrayList<String> fileContent = new ArrayList<String>();  //Prepare space for storage
		System.out.println("Start to load data...");  //Give operation tips
		
		//generate FileReader object
		FileReader fr = (FileReader) getConnection(fileAddress);
		Scanner scanner = new Scanner(fr);
		//read content and store to object
		while(scanner.hasNextLine()) {
			fileContent.add(scanner.nextLine());
		}
		//close  FileReader object
		scanner.close();
		closeConnection(fr);
		System.out.println("Load data finished.");
		
		return fileContent;
	}
	
	//generate FileReader object
	private  FileReader getConnection(String fileAddress) {
		
		FileReader fr = null;
		try {
			fr = new FileReader(fileAddress);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return fr;
	}
	
	//close FileReader object
	private  void closeConnection(FileReader fr) {
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
