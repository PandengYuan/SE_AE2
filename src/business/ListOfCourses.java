package business;

public class ListOfCourses implements ListOfObjects{
	
	private	Course[] list;
	private	int	i, max, it;

	protected ListOfCourses() {
		max = 10;
		list = new Course[max];
		i = 0;
	}

	@Override
	public void add(Object o) {
		 if(o instanceof Course) {
			 if (find(((Course) o).getCourseID()) == null) {
				 list[i++] = (Course)o; 
			 }
		 }	
	}

	@Override
	public void sub(Object o) {
		if(o instanceof Course) {
			int	j;
			for (j = 0; j < i; j++)
				if (list[j].getCourseID().equals(((Course) o).getCourseID()))
					break;
			i--;
			for (; j < i; j++)
				list[j] = list[j+1];
		}		
	}

	@Override
	public Course find(String n) {
		for (int j = 0; j < i; j++)
			if (list[j].getCourseID().equals(n))
				return list[j];
		return null;
	}

	@Override
	public String toString() {
		String string = "";
		for (int j = 0; j < i; j++) {
			string += list[j]+"\n";
		}
		return string;
	}
	
	@Override
	public void reset() {
		it = 0;
	}

	@Override
	public Course next() {
		return (it == i) ? null : list[it++];
	}

	@Override
	public boolean hasNext() {
		return it < i;
	}

	@Override
	public int size() {
		return i;
	}

}
