package business;

 class Requirement {

	private String requirementID;
	private int number;
	private String content;
	//IDs of suitable teachers
	private String IDs;
	
	public Requirement(String requirementID, int number, String content) {
		this.requirementID = requirementID;
		this.number = number;
		this.content = content;
	}
	
	public String getRequirementID() {
		return requirementID;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setIDs(String iDs) {
		IDs = iDs;
	}
	
	@Override
	public String toString() {
		return "\t["+requirementID+"]: [Number staff required : "+number+", Training content: "+content+"]\n\t\t[IDs of suitable teachers]: ["+IDs+"]";
	}
	
	
}
