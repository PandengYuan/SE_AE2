package user;

import business.SystemInterface;

//For all system user will include some attributes and method
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

1
