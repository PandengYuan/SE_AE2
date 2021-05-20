package business;

import java.util.ArrayList;

 class Teacher {
	
	private String teacherID;
	private String name;
	private ArrayList<String> skills;
	private ListOfTrainings listOfTrainings;

	public Teacher(String teacherID, String name, ArrayList<String> skills) {
		this.teacherID = teacherID;
		this.name = name;
		this.skills = skills;
		listOfTrainings = new ListOfTrainings();
	}
	
	public String getTeacherID() {
		return teacherID;
	}
	
	public ArrayList<String> getSkills() {
		return skills;
	}
	
	public ListOfTrainings getListOfTrainings() {
		return listOfTrainings;
	}
	
	@Override
	public String toString() {
		return "[TeacherID: "+teacherID+", Name: "+name+", Skill: "+skills+"] \nTraining Information: \n"+listOfTrainings+"\n";
	}


	
}
