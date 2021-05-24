package business;

//main interface for lists
 interface ListOfObjects {
	 
	//add an element to list
	public void add(Object o);
	
	//get rid of an element from list
	public void sub(Object o);
	
	//find and get an element of list according to a string
	public Object find(String n);
	
	//get the number of elements in list
	public int size();
	
	//used for printing list
	public String toString();
	
	//Iterator pattern
	public void reset();
	public Object next();
	public	boolean	hasNext();
	
} 
