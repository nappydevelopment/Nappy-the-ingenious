package nappydevelopment.nappyTheIngenious.data;

import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;

//### IMPORTS ##############################################################################################################################
public enum Answer {
	NO("No", "Nein"), YES("Yes", "Ja"), DONT_KNOW("I don't know", "Ich weiß nicht");
	
	private final String textEnglish;
	private final String textGerman;
	
	private Answer(final String eng, final String ger) {
		this.textEnglish = eng;
		this.textGerman = ger;
	}
	
	public String getText() {
		if(Settings.getLanguage() == Language.ENGLISH) {
			return this.textEnglish;
		}
		else {
			return this.textGerman;
		}
	}

	public static Answer fromBool(final boolean b) {
		Answer ans;
		if(b){
			ans = Answer.YES;
		}else{
			ans = Answer.NO;
		}
		return ans;
	}
}

//### EOF ##################################################################################################################################