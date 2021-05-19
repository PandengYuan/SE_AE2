package business;

public class Teacher {
	
	private String teacherID;
	private String name;
	private String skill;
	private ListOfTrainings listOfTrainings;

	protected Teacher(String teacherID, String name, String skill) {
		this.teacherID = teacherID;
		this.name = name;
		this.skill = skill;
		listOfTrainings = new ListOfTrainings();
	}
	

	protected String getTeacherID() {
		return teacherID;
	}
	
	protected String getSkill() {
		return skill;
	}
	
	protected ListOfTrainings getListOfTrainings() {
		return listOfTrainings;
	}
	
	@Override
	public String toString() {
		return "[TeacherID: "+teacherID+", Name: "+name+", Skill: "+skill+"] \nTraining Information: \n"+listOfTrainings+"\n";
	}


	
}
