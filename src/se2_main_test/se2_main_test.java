package se2_main_test;

import java.util.Scanner;

import business.AppInterface;
import fileIO.*;
import user.*;

public class se2_main_test {
	
	public static void main(String[] args) {
		
		String fileAddress = "C:\\file.txt";
		Scanner scanner = new Scanner(System.in);
		
		AppInterface appInterface = new AppInterface(FileInput.loadFile(fileAddress), scanner);
		
		Director director = new Director(appInterface);
		Administrator administrator = new Administrator(appInterface);
		
		director.produceTeachingRequirements();
		administrator.chooseSuitableTeachers();
		administrator.organiseTrainingForTeachers();
		
		FileOutput.writeDataToFile(appInterface.fileOutputProcess(), fileAddress);
		
	}

}
