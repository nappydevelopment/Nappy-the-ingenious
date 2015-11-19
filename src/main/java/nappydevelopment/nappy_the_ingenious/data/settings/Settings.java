package nappydevelopment.nappy_the_ingenious.data.settings;
//### IMPORTS ##############################################################################################################################

public class Settings {
	
//### ATTRIBUTES ###########################################################################################################################

	private static Language language = Language.GERMAN;
	private static ColorScheme coloScheme = ColorScheme.BRIGHT;
	private static GameMode gameMode = GameMode.BOTH_MODES;

//### GETTER/SETTER ########################################################################################################################
	
	public static ColorScheme getColoScheme() {
		return coloScheme;
	}

	public static void setColoScheme(ColorScheme coloScheme) {
		Settings.coloScheme = coloScheme;
	}

	public static GameMode getGameMode() {
		return gameMode;
	}

	public static void setGameMode(GameMode gameMode) {
		Settings.gameMode = gameMode;
	}

	public static Language getLanguage() {
		return language;
	}

	public static void setLanguage(Language language) {
		Settings.language = language;
		
	}

	
//### METHODS ##############################################################################################################################	

}
//### EOF ##################################################################################################################################