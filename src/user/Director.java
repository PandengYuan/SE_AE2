package user;

import business.AppInterface;

public class Director extends User{

	public Director(AppInterface appInterface) {
		super(appInterface);
	}
	
	public void produceTeachingRequirements() {
		getAppInterface().produceTeachingRequirements();
	}
}
