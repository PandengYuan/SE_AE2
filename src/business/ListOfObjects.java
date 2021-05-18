package business;

interface ListOfObjects {

	public void add(Object o);
	
	public void sub(Object o);
	
	public Object find(String n) ;
	
	public String toString() ;
	
	public void reset();
	
	public Object next();
	
	public	boolean	hasNext();
	
	public int size();
	
}
