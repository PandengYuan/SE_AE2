package user;

import business.SystemInterface;

public class User {
	
	private SystemInterface systemInterface;
	
	public User(SystemInterface systemInterface) {
		this.systemInterface = systemInterface;
	}
	
	public SystemInterface getSystemInterface() {
		return systemInterface;
	}
	
}

