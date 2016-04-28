package nappydevelopment.nappy_the_ingenious.data;

import nappydevelopment.nappy_the_ingenious.data.settings.Language;

public class Question{

	private final String table;
	private final String attribute;
	private final String question;
	private final Language lang;

	public Question(
			String table,
			String attribute,
			Language lang,
			String question
	){
		this.table = table;
		this.attribute = attribute;
		this.question = question;
		this.lang = lang;
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
	public Language getLanguage(){
		return lang;
	}
}
