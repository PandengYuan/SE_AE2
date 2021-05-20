package se2_main_test;

import java.util.Scanner;

import business.SystemInterface;
import fileIO.DataManagement;
import user.Administrator;
import user.Director;


public class se2_main_test {
	
	public static void main(String[] args) {
		
		String fileAddress = "C:\\file.txt";
		Scanner scanner = new Scanner(System.in);
		
		DataManagement dataManagement = new DataManagement();
		
		SystemInterface systemInterface = new SystemInterface(dataManagement.loadData(fileAddress), scanner);
		
		Director director = new Director(systemInterface);
		Administrator administrator = new Administrator(systemInterface);
		
		director.produceTeachingRequirements();
		administrator.chooseSuitableTeachers();
		administrator.organiseTrainingForTeachers();
		
		scanner.close();
		dataManagement.writeData(systemInterface.fileOutputProcess(), fileAddress);
		
	}

}
