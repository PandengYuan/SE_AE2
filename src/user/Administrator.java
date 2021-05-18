package user;

public class Administrator extends User{

	public Administrator() {
		super("administrator");
	}
	
	public void chooseSuitableTeachers() {
		getAppInterface().chooseSuitableTeachers();
	}
	
	public void organiseTrainingForTeachers() {
		getAppInterface().organiseTrainingForTeachers();
	}
}
