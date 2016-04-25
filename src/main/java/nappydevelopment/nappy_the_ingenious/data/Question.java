package nappydevelopment.nappy_the_ingenious.data;

import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.util.Map;

public class Question{

	private String table;
	private String attribute;
	private Map<Language, String> questions;

	private boolean isBoolean;

	public Question(String table, String attribute, Map<Language, String> questions){
		this.table = table;
		this.attribute = attribute;
		this.questions = questions;
	}
	public Question(String table, String attribute, Map<Language, String> questions, String type){
		this(table, attribute, questions);
		this.isBoolean = type.equals("BOOLEAN");
	}

	public String getQuestion(Language lang){
		return questions.get(lang);
	}
	public String getAttribute(){
		return attribute;
	}
	public String getTable(){
		return table;
	}
	public boolean isBoolean(){return isBoolean;}
}
