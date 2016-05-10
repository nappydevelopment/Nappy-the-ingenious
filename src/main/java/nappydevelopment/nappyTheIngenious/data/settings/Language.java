package nappydevelopment.nappyTheIngenious.data.settings;
//### IMPORTS ##############################################################################################################################
public enum Language {
	GERMAN("DE"),
	ENGLISH("EN");

	private String code;
	Language(String c){
		code = c;
	}
	public String getCode(){
		return code;
	}
}

//### EOF ##################################################################################################################################