package user;

import business.SystemInterface;

public class Administrator extends User{

	public Administrator(SystemInterface systemInterface) {
		super(systemInterface);
	}
	
	public void chooseSuitableTeachers() {
		getSystemInterface().chooseSuitableTeachers();
	}
	
	public void organiseTrainingForTeachers() {
		getSystemInterface().organiseTrainingForTeachers();
	}
}
