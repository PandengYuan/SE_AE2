package business;

 class Factory {

	 public ListOfObjects getListOfObjects(String string) {
		ListOfObjects listOfObjects = null;
		if (string.equals("ListOfCourses")) {
			listOfObjects = new ListOfCourses();
		}else if (string.equals("ListOfTeachers")) {
			listOfObjects = new ListOfTeachers();
		}
		return listOfObjects;
		
	}
}
