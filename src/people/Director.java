package people;

import java.util.Scanner;

import business.Course;
import business.ListOfCourse;
import business.ListOfObject;
import fileIO.FileInput;


public class Director extends Person {

	public Director(String name) {
		super("class director", name);
	}
	
	public void produceTeachingRequirements(ListOfObject listOfObject, Scanner scanner) {
		if (listOfObject instanceof ListOfCourse) {
			ListOfCourse listOfCourse = (ListOfCourse) listOfObject;
			
			System.out.println("WELCOME TO PTT SYSTEM!    " + this+"\n");
			System.out.println("As a class director, you need to produce theaching requirement for these courses as follows: \n");
			
			System.out.println(listOfCourse);
			
			listOfObject.reset();
			while (listOfCourse.hasNext()) {
				
				Course course = listOfCourse.next();
				
				System.out.println("Please edit teaching requirement for this course and end with enter key: \n");
				System.out.println(course);
				System.out.println("Edit it here: ");
				course.setTeachingRequirement(scanner.nextLine());
				//System.out.println(course);
				
			}
			
			System.out.println("Well done! You have produced teaching requirements successfully for each course. The result is as follows: \n");
			System.out.println(listOfCourse);

		}
		
	}
	
}
