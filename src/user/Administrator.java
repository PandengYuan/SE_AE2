package user;

import business.SystemInterface;

//Responsible for fill in teachers and training
public class Administrator extends User{
	
	//constructor
	public Administrator(SystemInterface systemInterface) {
		super(systemInterface);
	}
	
	//the method of choosing suitable teachers
	public void chooseSuitableTeachers() {
		//use the chooseSuitableTeachers method of systemInterface object
		getSystemInterface().chooseSuitableTeachers();
	}
	
	//the method of organizing training for chosen teachers
	public void organiseTrainingForTeachers() {
		//use the organiseTrainingForTeachers method of systemInterface object
		getSystemInterface().organiseTrainingForTeachers();
	}
}
