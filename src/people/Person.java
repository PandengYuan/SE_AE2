package people;


public class Person {
	
	
	private String character;
	private String name;
	
	
	public Person(String character, String name) {
		this.character = character;
		this.name = name;
	}
	

	public String getName() {
		return name;
	}


	public String toString(){
		return "Character: "+character+", Name: "+name;
	}


}
