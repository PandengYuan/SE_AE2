package business;

 class Requirement {
	 
	//Attributes
	 //requirementID
	private String requirementID;
	 //the number of required teachers
	private int number;
	 //the content of training string
	private String content;
	 //IDs of suitable teachers
	private String IDs;
	
	//constructor
	public Requirement(String requirementID, int number, String content) {
		this.requirementID = requirementID;
		this.number = number;
		this.content = content;
	}
	
	//getter | setter
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
	
	//toString method
	@Override
	public String toString() {
		return "\t["+requirementID+"]: [Number staff required : "+number+", Training content: "+content+"]\n\t\t[IDs of suitable teachers]: ["+IDs+"]";
	}
	
	
}
