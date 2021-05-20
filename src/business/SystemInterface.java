package business;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemInterface {

	private ListOfObjects[] listOfObjects;
	private Scanner scanner;
	
	public SystemInterface(ArrayList<String> fileContent, Scanner scanner) {
		listOfObjects = fileInputProcess(fileContent);
		this.scanner = scanner;
	}
	
	private ListOfObjects[] fileInputProcess(ArrayList<String> fileContent) {
		
		ListOfObjects[] listOfObjects = new ListOfObjects[3];
		Factory factory  = new Factory();
		listOfObjects[0] = factory.getListOfObjects("ListOfCourses");
		listOfObjects[1] = factory.getListOfObjects("ListOfTeachers");
		listOfObjects[2] = factory.getListOfObjects("ListOfTeachers");
		
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
						+ "Note: the number of IDs you need to choose should equal the number required. \n");
				Requirement requirement = course.getListOfRequirements().next();
				System.out.println(requirement);
				
				System.out.println("\nEdit IDs here, separate with space key and end with enter key: ");
				String string = scanner.nextLine();
				requirement.setIDs(string.trim());
				
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
