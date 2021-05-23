package business;

 class Factory {
	 
	 //the factory of constructing the object of ListOfCourses and ListOfTeachers (part of factory pattern)
	 public ListOfObjects getListOfObjects(String string) {
		ListOfObjects listOfObjects = null;
		if (string.equals("ListOfCourses")) {
			listOfObjects = new ListOfCourses();
		}else if (string.equals("ListOfTeachers")) {
			listOfObjects = new ListOfTeachers();
		}
		//return the object we asked
		return listOfObjects;
		
	}
}
