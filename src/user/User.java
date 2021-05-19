package user;

import business.AppInterface;

public class User {
	
	private AppInterface appInterface;
	
	public User(AppInterface appInterface) {
		this.appInterface = appInterface;
	}
	
	protected AppInterface getAppInterface() {
		return appInterface;
	}
	
}

