package business;

import people.Teacher;

public class Course {
	
	private String courseID;
	private String courseName;
	private String teachingRequirement;
	private Teacher teacher;
	
	
	public Course(String courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
	}
	
	
	public String getCourseID() {
		return courseID;
	}

	public void setTeachingRequirement(String teachingRequirement) {
		this.teachingRequirement = teachingRequirement;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}


	@Override
	public String toString() {
		return "[CourseID: "+courseID+", CourseName: "+courseName+"] "
				+ "\nTeaching Requirement: "+teachingRequirement+" \nTeacher Information : "+teacher+" \n";
	}
	

}
