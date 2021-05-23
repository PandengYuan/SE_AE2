package business;

 class ListOfTeachers implements ListOfObjects{
	 
	//attributes
	private	Teacher[] list;  //Use a list to store teacher references
	private	int	i, max, it;
	
	//constructor
	public ListOfTeachers() {
		max = 10;
		list = new Teacher[max];  //We assume that there are up to 10 teachers to be arranged
		i = 0;
	}
	
	//add an element to list
	@Override
	public void add(Object o) {
		 if(o instanceof Teacher) {
			 if ((find(((Teacher) o).getTeacherID()) == null)) {
				 list[i++] = (Teacher)o; 
			 }
		 }		
	}
	
	//get rid of an element from list
	@Override
	public void sub(Object o) {
		if(o instanceof Teacher) {
			int	j;
			for (j = 0; j < i; j++)
				if (list[j].getTeacherID().equals(((Teacher) o).getTeacherID()))
					break;
			i--;
			for (; j < i; j++)
				list[j] = list[j+1];
		}		
	}
	
	//find and get an element of list according to teacherID
	@Override
	public Teacher find(String n) {
		for (int j = 0; j < i; j++)
			if (list[j].getTeacherID().equals(n))
				return list[j];
		return null;
	}
	
	//get the number of elements in list
	@Override
	public int size() {
		return i;
	}
	
	//used for printing list
	@Override
	public String toString() {
		String string = "";
		for (int j = 0; j < i; j++) {
			string += list[j]+"\n";
		}
		return string;
	}
	
	//Iterator pattern
	@Override
	public void reset() {
		it = 0;
	}

	@Override
	public Teacher next() {
		return (it == i) ? null : list[it++];
	}

	@Override
	public boolean hasNext() {
		return it < i;
	}
	

}
