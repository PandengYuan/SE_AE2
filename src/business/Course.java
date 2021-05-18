package business;

public class Course extends Object{
	
	private String courseID;
	private String courseName;
	private ListOfRequirements listOfRequirements;
	
	protected Course(String courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
	}
	
	protected String getCourseID() {
		return courseID;
	}

	protected ListOfRequirements getListOfRequirements() {
		return listOfRequirements;
	}
	protected void setListOfRequirements(ListOfRequirements listOfRequirements) {
		this.listOfRequirements = listOfRequirements;
	}

	@Override
	public String toString() {
		return "[CourseID: "+courseID+", CourseName: "+courseName+"] "
				+ "\nTeaching Requirements: \n"+listOfRequirements+" \n";
	}
	
}
