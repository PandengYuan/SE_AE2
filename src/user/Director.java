package user;

import business.SystemInterface;

public class Director extends User{

	//constructor
	public Director(SystemInterface systemInterface) {
		super(systemInterface);
	}
	
	//the method of producing teaching requirements
	public void produceTeachingRequirements() {
		//use the produceTeachingRequirements method of systemInterface object
		getSystemInterface().produceTeachingRequirements();
	}
}
