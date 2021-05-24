package business;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemInterface {

	//attributes
	 //private static attribute part of Singleton pattern
	private static SystemInterface instance = null;
	 //contain the objects of ListOfCourses and ListOfTeachers
	private ListOfObjects[] listOfObjects;
	private Scanner scanner;
	
	//private constructor part of Singleton pattern
	private SystemInterface(ArrayList<String> fileContent, Scanner scanner) {
		//call the input processing method and assign the result set to attribute as a global variable
		listOfObjects = fileInputProcess(fileContent);
		this.scanner = scanner;
	}
	
	//public static factory method part of Singleton pattern
	public static SystemInterface getInstance(ArrayList<String> fileContent, Scanner scanner) {
		if (instance == null) {
			instance = new SystemInterface(fileContent, scanner);
		}
		return instance;
	}
	
	//the method of processing input to generate related objects
	private ListOfObjects[] fileInputProcess(ArrayList<String> fileContent) {
		
		ListOfObjects[] listOfObjects = new ListOfObjects[3];
		//use factory pattern to create several products (ListOfCourses, ListOfTeachers)
		Factory factory  = new Factory();
		listOfObjects[0] = factory.getListOfObjects("ListOfCourses"); //Store all course
		listOfObjects[1] = factory.getListOfObjects("ListOfTeachers"); //Include all teachers
		listOfObjects[2] = factory.getListOfObjects("ListOfTeachers"); //Will involve teaches who need training
		
		//file content parsing process
		for (String string : fileContent) {
			String[] tokens = string.trim().split("\t");
			if (tokens[0].equals("Course")) {
				listOfObjects[0].add(new Course(tokens[1], tokens[2]));
			}else if (tokens[0].equals("Teacher")) {
				ArrayList<String> arrayList = new ArrayList<String>();
				for (int i = 3; i < tokens.length; i++) {
					arrayList.add(tokens[i]);
				}
				listOfObjects[1].add(new Teacher(tokens[1], tokens[2], arrayList));
			}
		}		
		return listOfObjects;	
	}
	
	
	//the method of producing teaching requirements which belongs to class director
	public void produceTeachingRequirements() {
		
		System.out.println("#####################\n");
		System.out.println("WELCOME TO PTT SYSTEM!\n");
		System.out.println("As a class director, you need to produce theaching requirement for these courses as follows: \n");
		System.out.println(listOfObjects[0]);
		
		//interactive process of producing teaching requirements for each course
		listOfObjects[0].reset();
		while (listOfObjects[0].hasNext()) {
			
			Course course = (Course) listOfObjects[0].next();
			System.out.println("\n-------------------------------------------------------------------------");
			System.out.println("Please edit teaching requirement for this course according to the prompts: \n");
			System.out.println(course);
			
			
			System.out.println("how many teaching requirements you want to produce for this course? \nEdit here and end with enter key: ");
			int numberOfRequirements = scanner.nextInt();
			scanner.nextLine();
			
			//interactive process of producing details for each course requirement 
			for (int i = 1; i <= numberOfRequirements; i++) {
				
				System.out.println("\n***************");
				System.out.println("Please input the number staff required for Requirement"+i+"\nEdit here and end with enter key: ");
				int number = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Please input training content for Requirement"+i+"\nEdit here and end with enter key: ");
				String content = scanner.nextLine();
				course.getListOfRequirements().add(new Requirement("Rerquirement"+i, number, content));
			}
			
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------");
		System.out.println("Well done! You have produced teaching requirements successfully for each course. The result is as follows: \n");
		System.out.println(listOfObjects[0]);

	}
	
	//the method of choosing suitable teachers which belongs to administrator
	public void chooseSuitableTeachers() {
		
		System.out.println("#####################\n");
		System.out.println("WELCOME TO PTT SYSTEM!\n");
		System.out.println("As an administrator, you need to choose suitable teacher for these courses as follows: \n");
		System.out.println(listOfObjects[0]);
		System.out.println("You can choose from these teachers as follows: \n");
		System.out.println(listOfObjects[1]);
		
		//interactive process of choosing suitable teachers for each course
		listOfObjects[0].reset();
		while (listOfObjects[0].hasNext()) {
			
			Course course = (Course) listOfObjects[0].next();
			System.out.println("\n----------------------------------------------------------");
			System.out.println("Please choose suitable teachers for this following course: \n");
			System.out.println(course);
			
			//interactive process of choosing suitable teachers for each course requirement 
			course.getListOfRequirements().reset();
			while (course.getListOfRequirements().hasNext()) {
				
				System.out.println("***************");
				System.out.println("Please choose the ID of the teachers who are suitable for this requirement:\n"
						+ "Note: the number of IDs you need to choose should equal the number required. \n");
				Requirement requirement = course.getListOfRequirements().next();
				System.out.println(requirement);
				
				System.out.println("\nEdit IDs here, separate with space key and end with enter key: ");
				String string = scanner.nextLine();
				requirement.setIDs(string.trim());
				
				//add related training to teacher's ListOfTrainings to improve cohesion (deal with routine coupling problem)
				String[] teacherIDs = string.trim().split(" ");
				for (String teacherID : teacherIDs) {
					Teacher teacher = (Teacher) listOfObjects[1].find(teacherID);
					boolean flag = false;
					for (String skill : teacher.getSkills()) {
						if (skill.equals(requirement.getContent())) {
							flag = true;
							break;
						}
					}
					if (!flag)	teacher.getListOfTrainings().add(requirement);
				}
				
			}
		} 
		
		System.out.println("\n------------------------------------------------------------------------------------------------");
		System.out.println("Well done! You have chosen suitable staff successfully for each course. The result is as follows: \n");
		System.out.println(listOfObjects[0]);
		
	}
	
	//the method of organizing training for chosen teachers which belongs to administrator
	public void organiseTrainingForTeachers() {
		System.out.println("#####################\n");
		System.out.println("WELCOME TO PTT SYSTEM!\n");
		System.out.println("As an administrator, you need to organise training for those teachers who has been chosen. \n");
		
		//pick out teachers who have training in their listOftrainings and add them to result set
		listOfObjects[1].reset();
		while (listOfObjects[1].hasNext()) {
			Teacher teacher = (Teacher) listOfObjects[1].next();
			if (teacher.getListOfTrainings().size()!=0) {
				listOfObjects[2].add(teacher);
			}
		}
		
		System.out.println("Well done! You have organised training information successfully for each selected teacher. The result is as follows: \n");
		System.out.println(listOfObjects[2]);

	}
	
	//the method of processing output to generate output content from related objects
	public ArrayList<String> fileOutputProcess() {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(listOfObjects[0].toString());
		arrayList.add(listOfObjects[2].toString());
		return arrayList;
	}
	
}
