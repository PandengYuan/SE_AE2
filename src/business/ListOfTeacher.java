package business;

import people.Teacher;

public class ListOfTeacher implements ListOfObject {
	
	private	Teacher[] list;
	private	int	i, max, it;

	public ListOfTeacher() {
		max = 10;
		list = new Teacher[max];
		i = 0;
	}
	
	@Override
	public void add(Object o) {
	    if(o instanceof Teacher) {
	    	list[i++] = (Teacher)o; 
	    }
	}

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
	
	@Override
	public Teacher find(String n) {
		for (int j = 0; j < i; j++)
			if (list[j].getTeacherID().equals(n))
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
	public Teacher next() {
		return (it == i) ? null : list[it++];
	}
	
	@Override
	public	boolean	hasNext() {
		return it < i;
	}




}
