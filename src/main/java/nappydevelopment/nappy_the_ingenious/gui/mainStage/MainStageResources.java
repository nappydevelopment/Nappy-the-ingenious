//### MainStageResources.java ##############################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.mainStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;

/* MainStageResources [class]: Contains the resources for the main-stage like images, component-texts etc.: *//**
 *
 * @author Manuel Bothner
 *
 */
public class MainStageResources {

//### ATTRIBUTES ###########################################################################################################################

	StringProperty stageTitleText;

	//### Texts for general components #############################################################

	//Menu-Texts:
	StringProperty mnuGameText;
	StringProperty mniNewGameText;
	StringProperty mniAbortGameText;
	StringProperty mniStatisticText;
	StringProperty mniSettingsText;
	StringProperty mniExitText;
	StringProperty mnuHelpText;
	StringProperty mniHelpText;
	StringProperty mniWikiText;
	StringProperty mniInfoText;

	//### Texts for start-view components ##########################################################

	//Button-Texts:
	StringProperty btnNewGameText;
	StringProperty btnStatisticText;
	StringProperty btnWikiText;
	StringProperty btnHelpText;

	//### Texts for gamemode1 components ###########################################################

	StringProperty btnYesText;
	StringProperty btnNoText;
	StringProperty btnIdontKnow;
	
	String iThinkYourCharacterIs;
	String iDontKnowYourCharacterText;
	
	String btnYesTextYes;
	String btnYesTextRight;
	String btnNoTextNo;
	String btnNoTextWrong;
	String btnIdontKnowTextIdontKnow;
	String btnIdontKnowTextContinue;
	String btnIdontKnowTextIknow;

	//### Abort Dialog Texts #######################################################################

	String abortGameDialogTitle;
	String abortGameDialogHeaderText;
	String abortGameDialogContentText;
	String abortGameDialogBtnApplyText;
	String abortGameDialogBtnCancelText;
	
	String enterNameDialogBtnApplyText;
	String enterNameDialogBtnCancelText;
	String enterNameDialogTitle;
	String enterNameDialogHeaderText;
	String enterNameDialogContentText;
	
	String statusDialogGM1Title;
	String statusDialogGM1BtnApplyText;
	String statusDialogGM1BtnCancelText;
	String statusDialogGM1BtnOkText;
	String statusDialogGM1StatusTextRight1;
	String statusDialogGM1StatusTextRight2;
	String statusDialogGM1StatusTextRight3;
	String statusDialogGM1StatusTextRight4;
	String statusDialogGM1StatusTextWrong;
	String statusDialogGM1Question;

	//### Images for the menu-bar ##################################################################

	Image mniNewGameIcon;
	Image mniAbortGameIcon;
	Image mniStatisticIcon;
	Image mniSettingsIcon;
	Image mniExitIcon;

	Image mniHelpIcon;
	Image mniWikiIcon;
	Image mniInfoIcon;

	//### Images for the buttons ###################################################################

	Image btnNewGameIcon;
	Image btnStatistikIcon;
	Image btnWikiIcon;
	Image btnHelpIcon;

	//### Images ###################################################################################

	Image imvNoOfQuestIcon;
	Image imvKnowledgeIcon;
	Image imvNappyImageGM1;
	Image imvNappyImageGM2;
	
	//### Statistik-Kram #############################################################################



//### CONSTRUCTORS #########################################################################################################################

	/* MainStageResources [constructor]: Default constructor to create a MainStageResources-object *//**
	 *
	 */
	MainStageResources() {

		this.stageTitleText = new SimpleStringProperty("Nappy, the ingenious");

		//### Texts for general components #############################################################

		//Menu-Texts:
		this.mnuGameText = new SimpleStringProperty();
		this.mniNewGameText = new SimpleStringProperty();
		this.mniAbortGameText = new SimpleStringProperty();
		this.mniStatisticText = new SimpleStringProperty();
		this.mniSettingsText = new SimpleStringProperty();
		this.mniExitText = new SimpleStringProperty();
		this.mnuHelpText = new SimpleStringProperty();
		this.mniHelpText = new SimpleStringProperty();
		this.mniWikiText = new SimpleStringProperty();
		this.mniInfoText = new SimpleStringProperty();

		//### Texts for start-view components ##########################################################

		//Button-Texts:
		this.btnNewGameText = new SimpleStringProperty();
		this.btnStatisticText = new SimpleStringProperty();
		this.btnWikiText = new SimpleStringProperty();
		this.btnHelpText = new SimpleStringProperty();

		//### Texts for gamemode1 components ###########################################################

		this.btnYesText = new SimpleStringProperty();
		this.btnNoText = new SimpleStringProperty();
		this.btnIdontKnow = new SimpleStringProperty();
		
		this.iThinkYourCharacterIs = null;
		this.iDontKnowYourCharacterText = null;

		//### Images for the menu-bar ##################################################################

		this.mniNewGameIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/new_game.png");
		this.mniAbortGameIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/abort_game.png");
		this.mniStatisticIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/statistic.png");
		this.mniSettingsIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/settings.png");
		this.mniExitIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/exit.png");

		this.mniHelpIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/help.png");
		this.mniWikiIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/wiki.png");
		this.mniInfoIcon = new Image(GlobalReferences.ICONS_PATH + "16x16/info.png");

		//### Images for the buttons ###################################################################

		this.btnNewGameIcon = new Image(GlobalReferences.ICONS_PATH + "32x32/new_game.png");
		this.btnStatistikIcon = new Image(GlobalReferences.ICONS_PATH + "32x32/statistic.png");
		this.btnWikiIcon = new Image(GlobalReferences.ICONS_PATH + "32x32/wiki.png");
		this.btnHelpIcon = new Image(GlobalReferences.ICONS_PATH + "32x32/help.png");

		//### Images ###################################################################################

		this.imvNoOfQuestIcon = new Image(GlobalReferences.ICONS_PATH + "32x32/counter.png");
		this.imvKnowledgeIcon = new Image(GlobalReferences.ICONS_PATH + "32x32/knowledge.png");
		this.imvNappyImageGM1 = new Image(GlobalReferences.IMAGES_PATH + "general/nappy_gamemode1.png");
		this.imvNappyImageGM2 = new Image(GlobalReferences.IMAGES_PATH + "general/nappy_gamemode2_fit_size.png");
	}

//### PUBLIC METHODS #######################################################################################################################

	/* setTextsToEnglish [method]: Method that sets all texts of the main-stage to English *//**
	 *
	 */
	void setTextsToEnglish() {

		//Menu-Texts:
		this.mnuGameText.setValue("Game");
		this.mniNewGameText.setValue("New Game");
		this.mniAbortGameText.setValue("Abort Game");
		this.mniStatisticText.setValue("Statistic");
		this.mniSettingsText.setValue("Settings");
		this.mniExitText.setValue("Exit");
		this.mnuHelpText.setValue("Help");
		this.mniHelpText.setValue("Instructions");
		this.mniWikiText.setValue("Wiki");
		this.mniInfoText.setValue("Info");

		//Button-Texts:
		this.btnNewGameText.setValue("New Game");
		this.btnStatisticText.setValue("Statistic");
		this.btnWikiText.setValue("Wiki");
		this.btnHelpText.setValue("Instructions");
		this.btnYesText.setValue("Yes");
		this.btnNoText.setValue("No");
		this.btnIdontKnow.setValue("I don't know");
		
		//Abort-Dialog-Texts:
		this.abortGameDialogTitle = "Nappy, the ingenious";
		this.abortGameDialogHeaderText = "Abort game?";
		this.abortGameDialogContentText = "Do you really want to abort the current game?\n"
										+ "Notice: Aborted games will not listed in the statistic!\n\n";
		this.abortGameDialogBtnApplyText = "Abort game";
		this.abortGameDialogBtnCancelText = "Cancel";

		//Enter-Name-Texts:
		this.enterNameDialogTitle = "Nappy, the ingenious";
		this.enterNameDialogHeaderText = "Please enter your name!";
		this.enterNameDialogContentText = "Your name:";
		this.enterNameDialogBtnApplyText = "Add to statistic";
		this.enterNameDialogBtnCancelText = "Cancel";
		
		this.statusDialogGM1Title = "Nappy, the ingenious - Status game mode 1";
		this.statusDialogGM1BtnApplyText = "Yes";
		this.statusDialogGM1BtnCancelText = "No";
		this.statusDialogGM1BtnOkText = "Ok";
		this.statusDialogGM1StatusTextRight1 = "Nappy guessed your character ";
		this.statusDialogGM1StatusTextRight2 = " correctly.";
		this.statusDialogGM1StatusTextRight3 = "Nappy needed ";
		this.statusDialogGM1StatusTextRight4 = " questions.";
		this.statusDialogGM1StatusTextWrong = "Nappy could not correctly guess your character";
 		this.statusDialogGM1Question = "Do you want to try to beat Nappy and play the game mode 2?";
		
		this.iDontKnowYourCharacterText = "I don't know your character!";
		this.iThinkYourCharacterIs = "I think your character is";
		
		this.btnYesTextYes = "Yes";
		this.btnYesTextRight = "Right";
		this.btnNoTextNo = "No";
		this.btnNoTextWrong = "Wrong";
		this.btnIdontKnowTextIdontKnow = "I don't know";
		this.btnIdontKnowTextContinue = "Continue";
		this.btnIdontKnowTextIknow = "I think I know your character";
		
	}

	/* setTextsToGerman [method]: Method that sets all texts of the main-stage to German *//**
	 *
	 */
	void setTextsToGerman() {

		//Menu-Texts:
		this.mnuGameText.setValue("Spiel");
		this.mniNewGameText.setValue("Neues Spiel");
		this.mniAbortGameText.setValue("Spiel Abbrechen");
		this.mniStatisticText.setValue("Statistik");
		this.mniSettingsText.setValue("Einstellungen");
		this.mniExitText.setValue("Beenden");
		this.mnuHelpText.setValue("Hilfe");
		this.mniHelpText.setValue("Spielanleitung");
		this.mniWikiText.setValue("Wiki");
		this.mniInfoText.setValue("Info");

		//Button-Texts:
		this.btnNewGameText.setValue("Neues Spiel");
		this.btnStatisticText.setValue("Statistik");
		this.btnWikiText.setValue("Wiki");
		this.btnHelpText.setValue("Spielanleitung");
		this.btnYesText.setValue("Ja");
		this.btnNoText.setValue("Nein");
		this.btnIdontKnow.setValue("Ich weiß nicht");
		
		//Abort-Dialog-Texts:
		this.abortGameDialogTitle = "Nappy, the ingenious";
		this.abortGameDialogHeaderText = "Spiel abbrechen?";
		this.abortGameDialogContentText = "Möchten Sie das aktuelle Spiel wirklich abbrechen?\n"
										+ "Hinweis: Abgebrochene Spiele werden nicht in die Statistik aufgenommen!\n\n";
		this.abortGameDialogBtnApplyText = "Spiel abbrechen";
		this.abortGameDialogBtnCancelText = "Abbrechen";

		this.enterNameDialogTitle = "Nappy, the ingenious";
		this.enterNameDialogHeaderText = "Bitte gib deinen Namen ein!";
		this.enterNameDialogContentText = "Dein Name:";
		this.enterNameDialogBtnApplyText = "In die Statistik aufnehmen";
		this.enterNameDialogBtnCancelText = "Abbrechen";
		
		this.statusDialogGM1Title = "Nappy, the ingenious - Status Spielmodus 1";
		this.statusDialogGM1BtnApplyText = "Ja";
		this.statusDialogGM1BtnCancelText = "Nein";
		this.statusDialogGM1BtnOkText = "Ok";
		this.statusDialogGM1StatusTextRight1 = "Nappy hat deinen Charakter ";
		this.statusDialogGM1StatusTextRight2 = " richtig erraten.";
		this.statusDialogGM1StatusTextRight3 = "Nappy hat dafür ";
		this.statusDialogGM1StatusTextRight4 = " Fragen gebraucht.";
		this.statusDialogGM1StatusTextWrong = "Nappy konnte deinen Character nicht richtig erraten.";
 		this.statusDialogGM1Question = "Möchtest du versuchen Nappy zu schlagen und den zweiten Spielmodus spielen?";
		
		this.iDontKnowYourCharacterText = "Ich kenne deinen Charakter nicht!";
		this.iThinkYourCharacterIs = "Ich denke dein Charakter ist";
		
		this.btnYesTextYes = "Ja";
		this.btnYesTextRight = "Richtig";
		this.btnNoTextNo = "Nein";
		this.btnNoTextWrong = "Falsch";
		this.btnIdontKnowTextIdontKnow = "Ich weiß nicht";
		this.btnIdontKnowTextContinue = "Fortfahren";
		this.btnIdontKnowTextIknow = "Ich glaube ich kennen deinen Character";

	}

	
	void setBtnYesTextToYes() {
		this.btnYesText.set(this.btnYesTextYes);
	}
	
	void setBtnYesTextToRight() {
		this.btnYesText.set(this.btnYesTextRight);
	}
	
	void setBtnNoTextToNo() {
		this.btnNoText.set(this.btnNoTextNo);
	}

	void setBtnNoTextToWrong() {
		this.btnNoText.set(this.btnNoTextWrong);
	}
	
	void setBtnIdontKnowTextToIdontKnow() {
		this.btnIdontKnow.set(this.btnIdontKnowTextIdontKnow);
	}
	
	void setBtnIdontKnowTextToContinue() {
		this.btnIdontKnow.set(this.btnIdontKnowTextContinue);
	}
	
	void setBtnIdontKnowTextToIknow() {
		this.btnIdontKnow.set(this.btnIdontKnowTextIknow);
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################