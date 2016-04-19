package nappydevelopment.nappy_the_ingenious.data.settings;
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