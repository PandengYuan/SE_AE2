package business;

public class Course {
	
	private String courseID;
	private String courseName;
	private ListOfRequirements listOfRequirements;
	
	protected Course(String courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
		listOfRequirements = new ListOfRequirements();
	}
	
	protected String getCourseID() {
		return courseID;
	}

	protected ListOfRequirements getListOfRequirements() {
		return listOfRequirements;
	}

	@Override
	public String toString() {
		return "[CourseID: "+courseID+", CourseName: "+courseName+"] "
				+ "\nTeaching Requirements: \n"+listOfRequirements+" \n";
	}
	
}
