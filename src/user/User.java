package user;

import business.SystemInterface;

public class User {
	
	//attributes
	private SystemInterface systemInterface;
	
	//constructor
	public User(SystemInterface systemInterface) {
		setSystemInterface(systemInterface);
	}
	
	//getter | setter
	private void setSystemInterface(SystemInterface systemInterface) {
		this.systemInterface = systemInterface;
	}

	public SystemInterface getSystemInterface() {
		return systemInterface;
	}
	
}

