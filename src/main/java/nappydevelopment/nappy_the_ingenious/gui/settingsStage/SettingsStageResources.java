//### SettingsStageResources.java ##########################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.settingsStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;

/* SettingsStageResources [class]: Contains the resources for the settings-stage like images, component-texts etc.: *//**
 *
 * @author Manuel Bothner
 *
 */
public class SettingsStageResources {

	StringProperty stageTitleText;

	//Setting-Components-Text:
	StringProperty lblLanguageText;
	StringProperty rdbGerman;
	StringProperty rdbEnglish;
	StringProperty lblColorScheme;
	StringProperty rdbBright;
	StringProperty rdbDark;
	StringProperty lblGameMode;
	StringProperty rdbBothModes;
	StringProperty rdbOnlyMode1;
	//Button-Texts:
	StringProperty btnAbort;
	StringProperty btnApply;
	//Icon:
	Image stageIcon16x16;
	Image stageIcon32x32;

//### CONSTRUCTORS #########################################################################################################################

	/* SettingsStageResources [constructor]: Default constructor to create a SettingsStageResources-object *//**
	 *
	 */
	SettingsStageResources() {

		this.stageTitleText = new SimpleStringProperty();

		//Setting-Components-Text:
		this.lblLanguageText = new SimpleStringProperty();
		this.rdbGerman = new SimpleStringProperty();
		this.rdbEnglish = new SimpleStringProperty();
		this.lblColorScheme = new SimpleStringProperty();
		this.rdbBright = new SimpleStringProperty();
		this.rdbDark = new SimpleStringProperty();
		this.lblGameMode = new SimpleStringProperty();
		this.rdbBothModes = new SimpleStringProperty();
		this.rdbOnlyMode1 = new SimpleStringProperty();
		//Button-Texts:
		this.btnAbort = new SimpleStringProperty();
		this.btnApply = new SimpleStringProperty();
		//Icon:
		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/settings.png");
	}

//### PUBLIC METHODS #######################################################################################################################

	/* setTextsToEnglish [method]: Method that sets all texts of the settings-stage to English *//**
	 *
	 */
	void setTextsToEnglish() {

		this.stageTitleText.setValue("Nappy, the ingenious - Settings");
		this.lblLanguageText.setValue("Language");
		this.rdbGerman.setValue("German");
		this.rdbEnglish.setValue("English");
		this.lblColorScheme.setValue("Colorscheme");
		this.rdbBright.setValue("Bright");
		this.rdbDark.setValue("Dark");
		this.lblGameMode.setValue("Gamemode");
		this.rdbBothModes.setValue("Both modes");
		this.rdbOnlyMode1.setValue("Only mode 1");
		this.btnAbort.setValue("Abort");
		this.btnApply.setValue("Apply");
	}

	/* setTextsToGerman [method]: Method that sets all texts of the settings-stage to German *//**
	 *
	 */
	void setTextsToGerman() {

		this.stageTitleText.setValue("Nappy, the ingenious - Einstellungen");
		this.lblLanguageText.setValue("Sprache");
		this.rdbGerman.setValue("Deutsch");
		this.rdbEnglish.setValue("Englisch");
		this.lblColorScheme.setValue("Farbschema");
		this.rdbBright.setValue("Hell");
		this.rdbDark.setValue("Dunkel");
		this.lblGameMode.setValue("Spielmodus");
		this.rdbBothModes.setValue("Beide Modi");
		this.rdbOnlyMode1.setValue("Nur Spielmodus 1");
		this.btnAbort.setValue("Abbrechen");
		this.btnApply.setValue("Übernehmen");
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################