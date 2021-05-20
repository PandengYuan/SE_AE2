package business;

 class ListOfTrainings implements ListOfObjects{

	private	String[] list;
	private	int	i, max, it;

	public ListOfTrainings() {
		max = 10;
		list = new String[max];
		i = 0;
	}

	@Override
	public void add(Object o) {
		 if(o instanceof Requirement) {
			 if (find(((Requirement) o).getContent()) == null) {
				 list[i++] = ((Requirement) o).getContent(); 
			 }
		 }	
	}

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

	@Override
	public String find(String n) {
		for (int j = 0; j < i; j++)
			if (list[j].equals(n))
				return list[j];
		return null;
	}

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

	@Override
	public int size() {
		return i;
	}
}
