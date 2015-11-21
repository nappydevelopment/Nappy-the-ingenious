package nappydevelopment.nappy_the_ingenious.gui.settingsStage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//### IMPORTS ##############################################################################################################################
public class SettingsStageResources {
	
	static StringProperty stageTitleText = new SimpleStringProperty();
	
	//Setting-Components-Text:
	static StringProperty lblLanguageText = new SimpleStringProperty();
	static StringProperty rdbGerman = new SimpleStringProperty();
	static StringProperty rdbEnglish = new SimpleStringProperty();
	static StringProperty lblColorScheme = new SimpleStringProperty();
	static StringProperty rdbBright = new SimpleStringProperty();
	static StringProperty rdbDark = new SimpleStringProperty();
	static StringProperty lblGameMode = new SimpleStringProperty();
	static StringProperty rdbBothModes = new SimpleStringProperty();
	static StringProperty rdbOnlyMode1 = new SimpleStringProperty();
	//Button-Texts:
	static StringProperty btnAbort = new SimpleStringProperty();
	static StringProperty btnApply = new SimpleStringProperty();
	
//### CONSTANTS ############################################################################################################################

//### ATTRIBUTES ###########################################################################################################################

//### COMPONENTS ###########################################################################################################################

//### CONSTRUCTORS #########################################################################################################################

//### INITIAL METHODS ######################################################################################################################

//### INNER CLASSES ########################################################################################################################

//### GETTER/SETTER ########################################################################################################################

//### METHODS ##############################################################################################################################
	public static void setTextsToEnglish() {
		
		stageTitleText.setValue("Nappy, the ingenious - Settings");
		lblLanguageText.setValue("Language");
		rdbGerman.setValue("German");
		rdbEnglish.setValue("English");
		lblColorScheme.setValue("Colorscheme");
		rdbBright.setValue("Bright");
		rdbDark.setValue("Dark");
		lblGameMode.setValue("Gamemode");
		rdbBothModes.setValue("Both modes");
		rdbOnlyMode1.setValue("Only mode 1");
		btnAbort.setValue("Abort");
		btnApply.setValue("Apply");
	}
	
	public static void setTextsToGerman() {
		
		stageTitleText.setValue("Nappy, the ingenious - Einstellungen");
		lblLanguageText.setValue("Sprache");
		rdbGerman.setValue("Deutsch");
		rdbEnglish.setValue("Englisch");
		lblColorScheme.setValue("Farbschema");
		rdbBright.setValue("Hell");
		rdbDark.setValue("Dunkel");
		lblGameMode.setValue("Spielmodus");
		rdbBothModes.setValue("Beide Modi");
		rdbOnlyMode1.setValue("Nur Spielmodus 1");
		btnAbort.setValue("Abbrechen");
		btnApply.setValue("Übernehmen");
	}
	
}
//### EOF ##################################################################################################################################