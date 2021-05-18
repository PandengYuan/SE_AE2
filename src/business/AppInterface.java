package business;

import java.util.ArrayList;
import java.util.Scanner;



public class AppInterface {

	private ListOfObjects[] listOfObjects;
	private Scanner scanner;
	
	public AppInterface(ArrayList<String> fileContent, Scanner scanner) {
		listOfObjects = fileInputProcess(fileContent);
		this.scanner = scanner;
	}
	
	private ListOfObjects[] fileInputProcess(ArrayList<String> fileContent) {
		
		
		ListOfObjects[] listOfObjects = new ListOfObjects[3];
		listOfObjects[0] = new ListOfCourses();
		listOfObjects[1] = new ListOfTeachers();
		
		for (int i = 0; i < fileContent.size(); i++) {
			String[] tokens = fileContent.get(i).trim().split("\t");
			if (tokens[0].equals("Course")) {
				listOfObjects[0].add(new Course(tokens[1], tokens[2]));
			}else if (tokens[0].equals("Teacher")) {
				listOfObjects[1].add(new Teacher(tokens[1], tokens[2], tokens[3]));
			}
		}		
		return listOfObjects;	
	}
	
	
	
	public void produceTeachingRequirements() {
		System.out.println("#####################\n");
		System.out.println("WELCOME TO PTT SYSTEM!\n");
		System.out.println("As a class director, you need to produce theaching requirement for these courses as follows: \n");
		
		System.out.println(listOfObjects[0]);
		
		listOfObjects[0].reset();
		while (listOfObjects[0].hasNext()) {
			
			Course course = (Course) listOfObjects[0].next();
			System.out.println("\n-------------------------------------------------------------------------");
			System.out.println("Please edit teaching requirement for this course according to the prompts: \n");
			System.out.println(course);
			
			System.out.println("how many teaching requirements you want to produce for this course? \nEdit here and end with enter key: ");
			int numberOfRequirements = scanner.nextInt();
			scanner.nextLine();
			ListOfRequirements listOfRequirements = new ListOfRequirements();
			for (int i = 1; i <= numberOfRequirements; i++) {
				System.out.println("\n***************");
				System.out.println("Please input the number staff required for Requirement0"+i+"\nEdit here and end with enter key: ");
				int number = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please input training content for Requirement0"+i+"\nEdit here and end with enter key: ");
				String content = scanner.nextLine();
				listOfRequirements.add(new Requirement("Rerquirement0"+i, number, content));
			}
			course.setListOfRequirements(listOfRequirements);
		}
		System.out.println("\n--------------------------------------------------------------------------------------------------------");
		System.out.println("Well done! You have produced teaching requirements successfully for each course. The result is as follows: \n");
		System.out.println(listOfObjects[0]);

	}
	
	public void chooseSuitableTeachers() {
		System.out.println("#####################\n");
		System.out.println("WELCOME TO PTT SYSTEM!\n");
		System.out.println("As an administrator, you need to choose suitable teacher for these courses as follows: \n");
		System.out.println(listOfObjects[0]);
		System.out.println("You can choose from these teachers as follows: \n");
		System.out.println(listOfObjects[1]);
		
		listOfObjects[0].reset();
		while (listOfObjects[0].hasNext()) {
			
			Course course = (Course) listOfObjects[0].next();
			System.out.println("\n----------------------------------------------------------");
			System.out.println("Please choose suitable teachers for this following course: \n");
			System.out.println(course);
			course.getListOfRequirements().reset();
			while (course.getListOfRequirements().hasNext()) {
				System.out.println("***************");
				System.out.println("Please choose the ID of the teachers who are suitable for this requirement:\n"
						+ "Note: the number of teachers you need to choose should equal the number it required. \n");
				Requirement requirement = course.getListOfRequirements().next();
				System.out.println(requirement);
				System.out.println("\nEdit IDs here, separate with space key and end with enter key: ");
				String string = scanner.nextLine();
				requirement.setIDs(string);
				String[] tokens = string.trim().split(" ");
				for (int i = 0; i < tokens.length; i++) {
					((ListOfTeachers) listOfObjects[1]).find(tokens[i]).getListOfTrainings().add(requirement);
				}
			}
		}
		System.out.println("\n------------------------------------------------------------------------------------------------");
		System.out.println("Well done! You have chosen suitable staff successfully for each course. The result is as follows: \n");
		System.out.println(listOfObjects[0]);
		
	}
	
	public void organiseTrainingForTeachers() {
		System.out.println("#####################\n");
		System.out.println("WELCOME TO PTT SYSTEM!\n");
		System.out.println("As an administrator, you need to organise training for those teachers who has been chosen. \n");
		ListOfTeachers listOfTeacher = new ListOfTeachers();
		listOfObjects[1].reset();
		while (listOfObjects[1].hasNext()) {
			Teacher teacher = (Teacher) listOfObjects[1].next();
			if (teacher.getListOfTrainings().size()!=0) {
				listOfTeacher.add(teacher);
			}
		}
		listOfObjects[2] = listOfTeacher;
		System.out.println("Well done! You have organised training information successfully for each selected teacher. The result is as follows: \n");
		System.out.println(listOfTeacher);

	}
	
	public ArrayList<String> fileOutputProcess() {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(listOfObjects[0].toString());
		arrayList.add(listOfObjects[2].toString());
		return arrayList;
	}
	
}
