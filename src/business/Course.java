package business;

 class Course {
	
	private String courseID;
	private String courseName;
	private ListOfRequirements listOfRequirements;
	
	public Course(String courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
		listOfRequirements = new ListOfRequirements();
	}
	
	public String getCourseID() {
		return courseID;
	}

	public ListOfRequirements getListOfRequirements() {
		return listOfRequirements;
	}

	@Override
	public String toString() {
		return "[CourseID: "+courseID+", CourseName: "+courseName+"] "
				+ "\nTeaching Requirements: \n"+listOfRequirements+" \n";
	}
	
}
