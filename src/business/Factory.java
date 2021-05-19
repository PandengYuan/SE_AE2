package business;

public class Factory {

	protected ListOfObjects getListOfObjects(String string) {
		ListOfObjects listOfObjects = null;
		if (string.equals("ListOfCourses")) {
			listOfObjects = new ListOfCourses();
		}else if (string.equals("ListOfTeachers")) {
			listOfObjects = new ListOfTeachers();
		}
		return listOfObjects;
		
	}
}
