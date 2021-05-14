package business;

public interface ListOfObject {

	public  void add(Object o);
	
	public void sub(Object o);
	
	public Object find(String n) ;
	
	public String toString() ;
	
	public void reset();
	
	public Object next();
	
	public	boolean	hasNext();
	
}
