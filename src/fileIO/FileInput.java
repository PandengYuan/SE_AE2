package fileIO;


import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import business.Course;
import business.ListOfCourse;
import business.ListOfObject;
import business.ListOfTeacher;
import people.Teacher;


public class FileInput {
	

	public static ListOfObject[] loadFile(String fileAddress) {
		System.out.println("Start to load file...\n");
		ListOfObject[] listOfObject = new ListOfObject[2];
		listOfObject[0] = loadListOfCourse(fileAddress);
		listOfObject[1] = loadListOfTeacher(fileAddress);
		System.out.println("Load file finished.\n");
		return listOfObject;
		
	}
	
	public static FileReader getConnection(String fileAddress) {
		
		FileReader fr = null;
		try {
			fr = new FileReader(fileAddress);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return fr;
	}
	
	public static void closeFileReader(FileReader fr) {
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ListOfCourse loadListOfCourse(String fileAddress) {
		
		ListOfCourse listOfCourse = new ListOfCourse();
		
		FileReader fr = getConnection(fileAddress);
		
		Scanner s = new Scanner(fr);
		
		while(s.hasNextLine()) {
			
			String[] tokens = s.nextLine().split("\t");
			
			if (tokens[0].contains("C")) {
				listOfCourse.add(new Course(tokens[0], tokens[1]));
			}

		}
		
		s.close();
		closeFileReader(fr);
	
		return listOfCourse;
	}
	
	public static ListOfTeacher loadListOfTeacher(String fileAddress) {
		
		ListOfTeacher listOfTeacher = new ListOfTeacher();
		
		FileReader fr = getConnection(fileAddress);
		
		Scanner s = new Scanner(fr);
		
		while(s.hasNextLine()) {
			
			String[] tokens = s.nextLine().split("\t");
			
			if (tokens[0].contains("T")) {
				listOfTeacher.add(new Teacher(tokens[0], tokens[1], tokens[2]));
			}

		}
		
		s.close();
		closeFileReader(fr);
	
		return listOfTeacher;
	}
	

}
