package people;

import java.util.Scanner;

import business.Course;
import business.ListOfCourse;
import business.ListOfObject;
import business.ListOfTeacher;
import fileIO.FileInput;

public class Administrator extends Person{

	public Administrator(String name) {
		super("administrator", name);
	}
	
	public void chooseSuitableTeachers(ListOfObject listOfObject0, ListOfObject listOfObject1, Scanner scanner) {
		if (listOfObject0 instanceof ListOfCourse && listOfObject1 instanceof ListOfTeacher) {
			ListOfCourse listOfCourse = (ListOfCourse) listOfObject0;
			ListOfTeacher listOfTeacher = (ListOfTeacher) listOfObject1;
			
			System.out.println("WELCOME TO PTT SYSTEM!    " + this+"\n");
			System.out.println("As an administrator, you need to choose suitable teacher for these courses as follows: \n");
			
			System.out.println(listOfCourse);
			
			System.out.println("You can choose from these teachers as follows: \n");
			System.out.println(listOfTeacher);
			
			
			listOfCourse.reset();
			while (listOfCourse.hasNext()) {
				
				Course course = listOfCourse.next();
				
				System.out.println("Please choose and input the ID of the teacher who is suitable for the following course and end with enter key: \n");
				System.out.println(course);
				System.out.println("Choose from:\n");
				System.out.println(listOfTeacher);
				System.out.println("Choose it here:");
				while (true) {
					String string = scanner.nextLine().trim();
					
					if (listOfTeacher.find(string)!=null) {
						course.setTeacher(listOfTeacher.find(string));
						break;
					}else {
						System.out.println("Invalid input! Please choose again: \n");
						System.out.println(course);
						System.out.println(listOfTeacher);
					}
				}

			}
			
			System.out.println("Well done! You have chosen suitable staff successfully for each course. The result is as follows: \n");
			System.out.println(listOfCourse);
			
		}
		
	}
	
	public void organiseTrainingForTeachers(ListOfObject listOfObject, Scanner scanner) {
		if (listOfObject instanceof ListOfCourse) {
			ListOfCourse listOfCourse = (ListOfCourse) listOfObject;
			
			System.out.println("WELCOME TO PTT SYSTEM!    " + this+"\n");
			System.out.println("As an administrator, you need to organise training for these teachers as follows: \n");
			ListOfTeacher listOfTeacher = new ListOfTeacher();
			listOfCourse.reset();
			while (listOfCourse.hasNext()) {
				listOfTeacher.add(listOfCourse.next().getTeacher());
			}
			System.out.println(listOfTeacher);
			
			
			listOfTeacher.reset();
			while (listOfTeacher.hasNext()) {
				
				Teacher teacher = listOfTeacher.next();
				
				System.out.println("Please edit training information for this teacher and end with enter key: \n");
				System.out.println(teacher);
				System.out.println("Edit it here:");
				teacher.setTrainingInformation(scanner.nextLine());
				
				
			}
			
			System.out.println("Well done! You have organised training information successfully for each suitable teacher. The result is as follows: \n");
			System.out.println(listOfTeacher);

		}
		
	}
	
	
}
