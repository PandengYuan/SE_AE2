package business;

import java.util.ArrayList;

public class Teacher {
	
	private String teacherID;
	private String name;
	private ArrayList<String> skills;
	private ListOfTrainings listOfTrainings;

	protected Teacher(String teacherID, String name, ArrayList<String> skills) {
		this.teacherID = teacherID;
		this.name = name;
		this.skills = skills;
		listOfTrainings = new ListOfTrainings();
	}
	

	protected String getTeacherID() {
		return teacherID;
	}
	
	protected ArrayList<String> getSkills() {
		return skills;
	}
	
	protected ListOfTrainings getListOfTrainings() {
		return listOfTrainings;
	}
	
	@Override
	public String toString() {
		return "[TeacherID: "+teacherID+", Name: "+name+", Skill: "+skills+"] \nTraining Information: \n"+listOfTrainings+"\n";
	}


	
}
