package user;

import business.SystemInterface;

public class Director extends User{

	public Director(SystemInterface systemInterface) {
		super(systemInterface);
	}
	
	public void produceTeachingRequirements() {
		getSystemInterface().produceTeachingRequirements();
	}
}
