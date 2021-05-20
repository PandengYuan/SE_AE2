package business;

import java.util.ArrayList;

 class Teacher {
	
	//attributes
	private String teacherID;
	private String name;
	 //teacher's skills list
	private ArrayList<String> skills;
	 //a list of training which teacher should participate after being chosen
	private ListOfTrainings listOfTrainings;

	//constructor
	public Teacher(String teacherID, String name, ArrayList<String> skills) {
		this.teacherID = teacherID;
		this.name = name;
		this.skills = skills;
		listOfTrainings = new ListOfTrainings();
	}
	
	//getter | setter
	public String getTeacherID() {
		return teacherID;
	}
	
	public ArrayList<String> getSkills() {
		return skills;
	}
	
	public ListOfTrainings getListOfTrainings() {
		return listOfTrainings;
	}
	
	//toString method
	@Override
	public String toString() {
		return "[TeacherID: "+teacherID+", Name: "+name+", Skill: "+skills+"] \nTraining Information: \n"+listOfTrainings+"\n";
	}


	
}
