package se2_main;

import java.util.Scanner;
import business.ListOfObject;
import fileIO.FileInput;
import fileIO.FileOutput;
import people.Administrator;
import people.Director;

public class se2_main {

	public static void main(String[] args) {
		
		System.out.println("WELCOME TO PTT SYSTEM!");
		
		String fileAddress = "C:\\file.txt";
		ListOfObject[] listOfObject = FileInput.loadFile(fileAddress);
		
		
		Director director = new Director("Bob");
		Administrator administrator = new Administrator("Oscar");
		
		Scanner scanner = new Scanner(System.in);
		director.produceTeachingRequirements(listOfObject[0], scanner);
		administrator.chooseSuitableTeachers(listOfObject[0], listOfObject[1], scanner);
		administrator.organiseTrainingForTeachers(listOfObject[0], scanner);
		scanner.close();

		FileOutput.writeDataToFile(listOfObject, fileAddress);
		
	}

}
