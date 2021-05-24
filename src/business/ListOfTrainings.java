package business;

 class ListOfTrainings implements ListOfObjects{
	 
	//attributes
	private	String[] list;
	private	int	i, max, it;
	
	//constructor
	public ListOfTrainings() {
		max = 10;
		list = new String[max];  //We assume that the teacher’s training projects will be less than 10
		i = 0;
	}
	
	//add an element to list
	@Override
	public void add(Object o) {
		 if(o instanceof Requirement) {
			 if (find(((Requirement) o).getContent()) == null) {
				 list[i++] = ((Requirement) o).getContent(); 
			 }
		 }	
	}
	
	//get rid of an element from list
	@Override
	public void sub(Object o) {
		if(o instanceof Requirement) {
			int	j;
			for (j = 0; j < i; j++)
				if (list[j].equals(((Requirement) o).getContent()))
					break;
			i--;
			for (; j < i; j++)
				list[j] = list[j+1];
		}		
	}
	
	//find and get an element of list according to a string
	@Override
	public String find(String n) {
		for (int j = 0; j < i; j++)
			if (list[j].equals(n))
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
		if (i==0) {
			return "\t[null]";
		}else {
			for (int j = 0; j < i; j++) {
				string += "\t["+list[j]+"]\n";
			}
			return string;
		}
		
	}
	
	//Iterator pattern
	@Override
	public void reset() {
		it = 0;
	}

	@Override
	public String next() {
		return (it == i) ? null : list[it++];
	}

	@Override
	public boolean hasNext() {
		return it < i;
	}

 
}
