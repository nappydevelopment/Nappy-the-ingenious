package nappydevelopment.nappy_the_ingenious.data;

import nappydevelopment.nappy_the_ingenious.data.settings.Language;

import java.util.Map;

public class Question{

	private String table;
	private String attribute;
	private Map<Language, String> questions;

	public Question(String table, String attribute, Map<Language, String> questions){
		this.table = table;
		this.attribute = attribute;
		this.questions = questions;
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
}
