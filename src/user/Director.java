package user;

public class Director extends User{

	public Director() {
		super("class director");
	}
	
	public void produceTeachingRequirements() {
		getAppInterface().produceTeachingRequirements();
	}
}
