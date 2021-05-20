package business;

 class ListOfRequirements implements ListOfObjects{

	private	Requirement[] list;
	private	int	i, max, it;

	public ListOfRequirements() {
		max = 10;
		list = new Requirement[max];
		i = 0;
	}

	@Override
	public void add(Object o) {
		 if(o instanceof Requirement) {
			 if (find(((Requirement) o).getRequirementID()) == null) {
				 list[i++] = (Requirement)o; 
			 }
		 }	
	}

	@Override
	public void sub(Object o) {
		if(o instanceof Requirement) {
			int	j;
			for (j = 0; j < i; j++)
				if (list[j].getRequirementID().equals(((Requirement) o).getRequirementID()))
					break;
			i--;
			for (; j < i; j++)
				list[j] = list[j+1];
		}		
	}

	@Override
	public Requirement find(String n) {
		for (int j = 0; j < i; j++)
			if (list[j].getRequirementID().equals(n))
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
				string += list[j]+"\n";
			}
		}
		return string;
	}
	
	@Override
	public void reset() {
		it = 0;
	}

	@Override
	public Requirement next() {
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
