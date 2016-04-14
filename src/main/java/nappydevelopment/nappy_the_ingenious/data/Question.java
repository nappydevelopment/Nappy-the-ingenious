package nappydevelopment.nappy_the_ingenious.data;

public class Question{

	private String table;
	private String attribute;
	private String question;

	private boolean isBoolean;

	public Question(String table, String attribute, String question){
		this.table = table;
		this.attribute = attribute;
		this.question = question;
	}
	public Question(String table, String attribute, String question, String type){
		this(table, attribute, question);
		this.isBoolean = type == "BOOLEAN";
	}

	public String getQuestion(){
		return question;
	}
	public String getAttribute(){
		return attribute;
	}
	public String getTable(){
		return table;
	}
	public boolean isBoolean(){return isBoolean;}
}
