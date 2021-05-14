package people;

public class Teacher extends Person {
	
	private String teacherID;
	private String skill;
	private String trainingInformation;
	

	public Teacher(String teacherID, String name, String skill) {
		super("part-time teacher", name);
		this.teacherID = teacherID;
		this.skill = skill;
	}
	

	public String getTeacherID() {
		return teacherID;
	}
	
	public void setTrainingInformation(String trainingInformation) {
		this.trainingInformation = trainingInformation;
	}


	@Override
	public String toString() {
		return "[TeacherID: "+teacherID+", Name: "+getName()+", Skill: "+skill+", Training Information: "+trainingInformation+"]";
	}

}
