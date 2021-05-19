package user;

import business.AppInterface;

public class Administrator extends User{

	public Administrator(AppInterface appInterface) {
		super(appInterface);
	}
	
	public void chooseSuitableTeachers() {
		getAppInterface().chooseSuitableTeachers();
	}
	
	public void organiseTrainingForTeachers() {
		getAppInterface().organiseTrainingForTeachers();
	}
}
