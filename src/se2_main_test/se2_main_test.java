package se2_main_test;


import java.util.Scanner;

import business.SystemInterface;
import fileIO.DataManagement;
import user.Administrator;
import user.Director;


public class se2_main_test {
	
	public static void main(String[] args) {
		
		String dataAddress = "C:\\file.txt";
		
		//initialize systemInterface with required input data
		SystemInterface systemInterface =  SystemInterface.getInstance(new DataManagement().loadData(dataAddress), new Scanner(System.in));
		
		//initialize users
		Director director = new Director(systemInterface);
		Administrator administrator = new Administrator(systemInterface);
		
		//business execution
		director.produceTeachingRequirements();
		administrator.chooseSuitableTeachers();
		administrator.organiseTrainingForTeachers();

		//write updated data to file
		new DataManagement().writeData(systemInterface.fileOutputProcess(), dataAddress);
		
	}

}1
