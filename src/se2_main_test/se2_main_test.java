package se2_main_test;

import java.util.Scanner;

import business.AppInterface;
import fileIO.FileInput;
import fileIO.FileOutput;
import user.Administrator;
import user.Director;

public class se2_main_test {
	
	public static void main(String[] args) {
		
		String fileAddress = "C:\\file.txt";
		Scanner scanner = new Scanner(System.in);
		
		AppInterface appInterface = new AppInterface(FileInput.loadFile(fileAddress), scanner);
		
		Director director = new Director();
		Administrator administrator = new Administrator();
		director.setAppInterface(appInterface);
		administrator.setAppInterface(appInterface);
		
		director.produceTeachingRequirements();
		administrator.chooseSuitableTeachers();
		administrator.organiseTrainingForTeachers();
		
		FileOutput.writeDataToFile(appInterface.fileOutputProcess(), fileAddress);
		
		
		
	}

}
