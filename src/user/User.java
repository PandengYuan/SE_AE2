package user;

import business.AppInterface;

public class User {
	
	private String character;
	private AppInterface appInterface;
	
	public User(String character) {
		this.character = character;
	}
	
	public AppInterface getAppInterface() {
		return appInterface;
	}
	
	public void setAppInterface(AppInterface appInterface) {
		this.appInterface = appInterface;
	}
	
	@Override
	public String toString() {
		return character;
	}
	
	
}

