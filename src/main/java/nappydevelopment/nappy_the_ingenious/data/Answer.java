package nappydevelopment.nappy_the_ingenious.data;

import nappydevelopment.nappy_the_ingenious.data.settings.Language;

//### IMPORTS ##############################################################################################################################
public enum Answer {
	NO("No", "Nein"), YES("Yes", "Ja"), DONT_KNOW("I don't know", "Ich weiß nicht");
	
	private final String textEnglish;
	private final String textGerman;
	
	private Answer(String eng, String ger) {
		this.textEnglish = eng;
		this.textGerman = ger;
	}
	
	public String getText(Language lang) {
		
		if(lang == Language.ENGLISH) {
			return this.textEnglish;
		}
		else {
			return this.textGerman;
		}
	}
}

//### EOF ##################################################################################################################################