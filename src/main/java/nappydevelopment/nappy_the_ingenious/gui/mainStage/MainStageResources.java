//### MainStageResources.java ##############################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.mainStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;

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
	
	StringProperty iThinkItIsText;
	StringProperty iDontKnowYourCharacterText;

	//### Abort Dialog Texts #######################################################################

	String abortGameDialogTitle;
	String abortGameDialogHeaderText;
	String abortGameDialogContentText;
	String abortGameDialogBtnApplyText;
	String abortGameDialogBtnCancelText;

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
	Image imvNappyImage;

	//### Fragenanzahl #############################################################################

	int askedQuestions;

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
		
		this.iThinkItIsText = new SimpleStringProperty();
		this.iDontKnowYourCharacterText = new SimpleStringProperty();

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
		this.imvNappyImage = new Image(GlobalReferences.IMAGES_PATH + "general/nappy_no_border.png");

		this.askedQuestions = 0;
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
		
		this.iDontKnowYourCharacterText.setValue("I don't know your character");
		this.iThinkItIsText.setValue("I think your character is");
		
		//Abort-Dialog-Texts:
		this.abortGameDialogTitle = "Nappy, the ingenious";
		this.abortGameDialogHeaderText = "Abort game?";
		this.abortGameDialogContentText = "Do you really want to abort the current game?\n"
										+ "Notice: Aborted games will not listed in the statistic!\n\n";
		this.abortGameDialogBtnApplyText = "Abort game";
		this.abortGameDialogBtnCancelText = "Cancel";
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
		
		this.iDontKnowYourCharacterText.setValue("Ich kenne deinen Charakter nicht");
		this.iThinkItIsText.setValue("Ich denke dein Charakter ist");
		
		//Abort-Dialog-Texts:
		this.abortGameDialogTitle = "Nappy, the ingenious";
		this.abortGameDialogHeaderText = "Spiel abbrechen?";
		this.abortGameDialogContentText = "Möchten Sie das aktuelle Spiel wirklich abbrechen?\n"
										+ "Hinweis: Abgebrochene Spiele werden nicht in die Statistik aufgenommen!\n\n";
		this.abortGameDialogBtnApplyText = "Spiel abbrechen";
		this.abortGameDialogBtnCancelText = "Abbrechen";

	}

	public int getAskedQuestions(){
		return this.askedQuestions;
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################