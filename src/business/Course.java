package business;

 class Course {
	 
	//Attributes
	private String courseID;
	private String courseName;
	private ListOfRequirements listOfRequirements;
	
	//constructor
	public Course(String courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
		listOfRequirements = new ListOfRequirements();
	}
	
	//getter | setter
	public String getCourseID() {
		return courseID;
	}

	public ListOfRequirements getListOfRequirements() {
		return listOfRequirements;
	}
	
	//toString method
	@Override
	public String toString() {
		return "[CourseID: "+courseID+", CourseName: "+courseName+"] "
				+ "\nTeaching Requirements: \n"+listOfRequirements+" \n";
	}
	
}
