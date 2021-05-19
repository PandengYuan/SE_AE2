package business;

public class Requirement {

	private String requirementID;
	private int number;
	private String content;
	//IDs of suitable teachers
	private String IDs;
	
	protected Requirement(String requirementID, int number, String content) {
		this.requirementID = requirementID;
		this.number = number;
		this.content = content;
	}
	
	protected String getRequirementID() {
		return requirementID;
	}
	
	protected int getNumber() {
		return number;
	}
	
	protected String getContent() {
		return content;
	}
	
	protected void setIDs(String iDs) {
		IDs = iDs;
	}
	
	@Override
	public String toString() {
		return "\t["+requirementID+"]: [Number staff required : "+number+", Training content: "+content+"]\n\t\t[IDs of suitable teachers]: ["+IDs+"]";
	}
	
	
}
