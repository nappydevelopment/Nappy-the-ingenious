//### MainStageResources.java ##############################################################################################################

package nappydevelopment.nappyTheIngenious.gui.mainStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;

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
	StringProperty btnIdontKnowText;
	
	StringProperty btnAskQuestionText;
	
	StringProperty btnPlayAgainText;
	StringProperty btnBackToMainViewText;
	
	StringProperty lblGameResultText;
	StringProperty lblPlayerText;
	StringProperty lblGuessedCharacterText;
	StringProperty lblRightGuessText;
	StringProperty lblNoOfQuestionsText;
	StringProperty lblWhosWinnerText;
	
	//Variable Text for gui-components:
	
	//Texts for the label lblInfo:
	String lblInfoTextIKnowYourCharacter;
	String lblInfoTextIDontKnowYourCharacterText;
	String lblInfoTextPleaseSelectAQuestion;
	
	String btnYesTextYes;
	String btnYesTextRight;
	
	String btnNoTextNo;
	String btnNoTextWrong;
	
	String btnIdontKnowTextIdontKnow;
	String btnIdontKnowTextContinue;
	String btnIdontKnowTextIknow;
	
	String cmbQuestionsTextSelectAQuestion;
	String cmbQuestionsTextSelectNextQuestion;
	String cmbQuestionsTextYouveAskThisQuestionAlready;

	//### Abort Dialog Texts #######################################################################

	String abortGameDialogTitle;
	String abortGameDialogHeaderText;
	String abortGameDialogContentText;
	String abortGameDialogBtnApplyText;
	String abortGameDialogBtnCancelText;
	
	String closeProgramDialogTitle;
	String closeProgramDialogHeaderText;
	String closeProgramDialogContentText;
	String closeProgramDialogBtnApplyText;
	String closeProgramDialogBtnCancelText;
	
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
	
	String statusDialogGM2Title;
	String statusDialogGM2StatusTextRight1;
	String statusDialogGM2StatusTextRight2;
	String statusDialogGM2StatusTextRight3;
	String statusDialogGM2StatusTextRight4;
	String statusDialogGM2StatusTextWrong1;
	String statusDialogGM2StatusTextWrong2;
	String statusDialogGM2StatusTextWrong3;

	String lblWinnerText;
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
	Image imvNappyIcon;
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
		this.btnIdontKnowText = new SimpleStringProperty();
		
		this.lblInfoTextIKnowYourCharacter = null;
		this.lblInfoTextIDontKnowYourCharacterText = null;

		//### Texts for gamemode2 components ###########################################################
		
		this.btnAskQuestionText = new SimpleStringProperty();
		
		this.btnPlayAgainText = new SimpleStringProperty();
		this.btnBackToMainViewText = new SimpleStringProperty();
		
		
		this.lblGameResultText = new SimpleStringProperty();
		this.lblPlayerText = new SimpleStringProperty();
		this.lblGuessedCharacterText = new SimpleStringProperty();
		this.lblRightGuessText = new SimpleStringProperty();
		this.lblNoOfQuestionsText = new SimpleStringProperty();
		this.lblWhosWinnerText = new SimpleStringProperty();
		
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
		this.imvNappyIcon = new Image(GlobalReferences.ICONS_PATH + "32x32/icon.png");
		this.imvNappyImageGM1 = new Image(GlobalReferences.IMAGES_PATH + "general/nappy_gamemode1_2.png");
		this.imvNappyImageGM2 = new Image(GlobalReferences.IMAGES_PATH + "general/nappy_gamemode2_fit_size.png");
	}

//### PUBLIC METHODS #######################################################################################################################

	/* setTextsToEnglish [method]: Method that sets all texts of the main-stage to English *//**
	 *
	 */
	protected void setTextsToEnglish() {

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
		this.btnIdontKnowText.setValue("I don't know");
		
		this.btnAskQuestionText.setValue("Ask question");
		
		this.btnPlayAgainText.setValue("Play again");
		this.btnBackToMainViewText.setValue("Back to main view");
		
		//Abort-Dialog-Texts:
		this.abortGameDialogTitle = "Nappy, the ingenious";
		this.abortGameDialogHeaderText = "Abort game?";
		this.abortGameDialogContentText = "Do you really want to abort the current game?\n"
										+ "Notice: Aborted games will not listed in the statistic!\n\n";
		this.abortGameDialogBtnApplyText = "Abort game";
		this.abortGameDialogBtnCancelText = "Cancel";
		
		//Close-Dialog-Texts:
		this.closeProgramDialogTitle = "Nappy, the ingenious";
		this.closeProgramDialogHeaderText = "Exit program?";
		this.closeProgramDialogContentText = "Do you really want to exit the program?\n"
										+ "Notice: Your current game will aborted!\n\n";
		this.closeProgramDialogBtnApplyText = "Exit program";
		this.closeProgramDialogBtnCancelText = "Cancel";

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
		
 		this.statusDialogGM2Title = "Nappy, the ingenious - Status game mode 2";
 		this.statusDialogGM2StatusTextRight1 = "You guessed Nappy's character ";
 		this.statusDialogGM2StatusTextRight2 = " right!";
 		this.statusDialogGM2StatusTextRight3 = "You needed ";
 		this.statusDialogGM2StatusTextRight4 = " questions.";
 		this.statusDialogGM2StatusTextWrong1 = "Sorry, you don't guess the right character!";
 		this.statusDialogGM2StatusTextWrong2 = "You're tip ";
 		this.statusDialogGM2StatusTextWrong3 = " is wrong,\nNappy's character is ";
 		
 		
		this.lblInfoTextIDontKnowYourCharacterText = "I don't know your character!";
		this.lblInfoTextIKnowYourCharacter = "I think your character is";
		this.lblInfoTextPleaseSelectAQuestion = "Please select a question!";
		
		this.btnYesTextYes = "Yes";
		this.btnYesTextRight = "Right";
		this.btnNoTextNo = "No";
		this.btnNoTextWrong = "Wrong";
		this.btnIdontKnowTextIdontKnow = "I don't know";
		this.btnIdontKnowTextContinue = "Continue";
		this.btnIdontKnowTextIknow = "I think I know your character";
		
		this.cmbQuestionsTextSelectAQuestion = "Select a question...";
		this.cmbQuestionsTextSelectNextQuestion = "Select the next question...";
		this.cmbQuestionsTextYouveAskThisQuestionAlready = "You've asked this question already!";
		
		this.lblGameResultText.setValue("Game result");
		this.lblPlayerText.setValue("Player");
		this.lblGuessedCharacterText.setValue("Guessed character:");
		this.lblRightGuessText.setValue("Guessed right:");
		this.lblNoOfQuestionsText.setValue("No of questions:");
		this.lblWhosWinnerText.setValue("Winner:");
		
		this.lblWinnerText = " wins!!!";
	}

	/* setTextsToGerman [method]: Method that sets all texts of the main-stage to German *//**
	 *
	 */
	protected void setTextsToGerman() {

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
		this.btnIdontKnowText.setValue("Ich weiß nicht");
		
		this.btnAskQuestionText.setValue("Frage stellen");
		
		this.btnPlayAgainText.setValue("Nochmal spielen");
		this.btnBackToMainViewText.setValue("Zurück zur Hauptansicht");
		
		//Abort-Dialog-Texts:
		this.abortGameDialogTitle = "Nappy, the ingenious";
		this.abortGameDialogHeaderText = "Spiel abbrechen?";
		this.abortGameDialogContentText = "Möchten Sie das aktuelle Spiel wirklich abbrechen?\n"
										+ "Hinweis: Abgebrochene Spiele werden nicht in die Statistik aufgenommen!\n\n";
		this.abortGameDialogBtnApplyText = "Spiel abbrechen";
		this.abortGameDialogBtnCancelText = "Abbrechen";
		
		//Close-Dialog-Texts:
		this.closeProgramDialogTitle = "Nappy, the ingenious";
		this.closeProgramDialogHeaderText = "Programm beenden?";
		this.closeProgramDialogContentText = "Möchten Sie das Programm wirklich beenden?\n"
										+ "Hinweis: Dadurch wird das aktuelle Spiel abgebrochen!\n\n";
		this.closeProgramDialogBtnApplyText = "Programm beenden";
		this.closeProgramDialogBtnCancelText = "Abbrechen";

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
		
 		this.statusDialogGM2Title = "Nappy, the ingenious - Status Spielmodus 2";
 		this.statusDialogGM2StatusTextRight1 = "Du hast Nappys Charakter ";
 		this.statusDialogGM2StatusTextRight2 = " richtig erraten!";
 		this.statusDialogGM2StatusTextRight3 = "Du hast dafür ";
 		this.statusDialogGM2StatusTextRight4 = " Fragen gebraucht.";
 		this.statusDialogGM2StatusTextWrong1 = "Du hast Nappys Charakter leider nicht richtig erraten!";
 		this.statusDialogGM2StatusTextWrong2 = "Dein Tip ";
 		this.statusDialogGM2StatusTextWrong3 = " ist falsch,\nNappys Charakter ist ";
 		
		this.lblInfoTextIDontKnowYourCharacterText = "Ich kenne deinen Charakter nicht!";
		this.lblInfoTextIKnowYourCharacter = "Ich denke dein Charakter ist";
		this.lblInfoTextPleaseSelectAQuestion = "Bitte wähle eine Frage!";
		
		this.btnYesTextYes = "Ja";
		this.btnYesTextRight = "Richtig";
		this.btnNoTextNo = "Nein";
		this.btnNoTextWrong = "Falsch";
		this.btnIdontKnowTextIdontKnow = "Ich weiß nicht";
		this.btnIdontKnowTextContinue = "Fortfahren";
		this.btnIdontKnowTextIknow = "Ich glaube ich kennen deinen Character";
		
		this.cmbQuestionsTextSelectAQuestion = "Eine Frage wählen...";
		this.cmbQuestionsTextSelectNextQuestion = "Die nächste Frage wählen...";
		this.cmbQuestionsTextYouveAskThisQuestionAlready = "Du hast diese Frage bereits gestellt!";
		
		this.lblGameResultText.setValue("Spielergebnis");
		this.lblPlayerText.setValue("Spieler");
		this.lblGuessedCharacterText.setValue("Erratener Character:");
		this.lblRightGuessText.setValue("Richtig erraten:");
		this.lblNoOfQuestionsText.setValue("Anzahl benötigter Fragen:");
		this.lblWhosWinnerText.setValue("Gewinner:");
		
		this.lblWinnerText = " hat gewonnen!!!";
	}

	protected void setTextsToTurkish() {

		//Menu-Texts:
		this.mnuGameText.setValue("Oyun");
		this.mniNewGameText.setValue("Yeni oyun");
		this.mniAbortGameText.setValue("Oyunu iptal et");
		this.mniStatisticText.setValue("istatistik");
		this.mniSettingsText.setValue("ayarlar");
		this.mniExitText.setValue("çıkış");
		this.mnuHelpText.setValue("Yardım");
		this.mniHelpText.setValue("talimatlar");
		this.mniWikiText.setValue("Wiki");
		this.mniInfoText.setValue("bilgi");

		//Button-Texts:
		this.btnNewGameText.setValue("Yeni oyun");
		this.btnStatisticText.setValue("istatistik");
		this.btnWikiText.setValue("Wiki");
		this.btnHelpText.setValue("talimatlar");
		this.btnYesText.setValue("Evet");
		this.btnNoText.setValue("Hayir");
		this.btnIdontKnowText.setValue("Bilmiyorum");

		this.btnAskQuestionText.setValue("Soru sor");

		this.btnPlayAgainText.setValue("tekrar oyna");
		this.btnBackToMainViewText.setValue("Ana sayfaya geri dön");

		//Abort-Dialog-Texts:
		this.abortGameDialogTitle = "Nappy, the ingenious";
		this.abortGameDialogHeaderText = "Oyun iptal edilsin mi?";
		this.abortGameDialogContentText = "Gerçekten geçerli oyun iptal etmek istiyor musunuz?\n"
				+ "Uyarı: Iptal edilen oyunlar istatistiklere dahil edilmemiştir !\n\n";
		this.abortGameDialogBtnApplyText = "Oyunu iptal et";
		this.abortGameDialogBtnCancelText = "Iptal";

		//Close-Dialog-Texts:
		this.closeProgramDialogTitle = "Nappy, the ingenious";
		this.closeProgramDialogHeaderText = "Programı kapansın mı?";
		this.closeProgramDialogContentText = "Gerçekten çıkmak istiyor musunuz ?\n"
				+ "Uyarı: Böylece, geçerli oyun iptal edilir!\n\n";
		this.closeProgramDialogBtnApplyText = "Programı kapat";
		this.closeProgramDialogBtnCancelText = "Iptal";

		this.enterNameDialogTitle = "Nappy, the ingenious";
		this.enterNameDialogHeaderText = "Lütfen adınızı yazın!";
		this.enterNameDialogContentText = "Adınız:";
		this.enterNameDialogBtnApplyText = "İstatistiklere ekle";
		this.enterNameDialogBtnCancelText = "Iptal";

		this.statusDialogGM1Title = "Nappy, the ingenious - Oyun Modu 1 durum";
		this.statusDialogGM1BtnApplyText = "Evet";
		this.statusDialogGM1BtnCancelText = "Hayir";
		this.statusDialogGM1BtnOkText = "Tamam";
		this.statusDialogGM1StatusTextRight1 = "Nappy hat deinen Charakter ";
		this.statusDialogGM1StatusTextRight2 = " richtig erraten.";
		this.statusDialogGM1StatusTextRight3 = "Nappy hat dafür ";
		this.statusDialogGM1StatusTextRight4 = " Fragen gebraucht.";
		this.statusDialogGM1StatusTextWrong = "Nappy konnte deinen Character nicht richtig erraten.";
		this.statusDialogGM1Question = "Möchtest du versuchen Nappy zu schlagen und den zweiten Spielmodus spielen?";

		this.statusDialogGM2Title = "Nappy, the ingenious - Oyun Modu 2 durum";
		this.statusDialogGM2StatusTextRight1 = "Du hast Nappys Charakter ";
		this.statusDialogGM2StatusTextRight2 = " richtig erraten!";
		this.statusDialogGM2StatusTextRight3 = "Du hast dafür ";
		this.statusDialogGM2StatusTextRight4 = " Fragen gebraucht.";
		this.statusDialogGM2StatusTextWrong1 = "Du hast Nappys Charakter leider nicht richtig erraten!";
		this.statusDialogGM2StatusTextWrong2 = "Dein Tip ";
		this.statusDialogGM2StatusTextWrong3 = " ist falsch,\nNappys Charakter ist ";

		this.lblInfoTextIDontKnowYourCharacterText = "Ich kenne deinen Charakter nicht!";
		this.lblInfoTextIKnowYourCharacter = "Ich denke dein Charakter ist";
		this.lblInfoTextPleaseSelectAQuestion = "Bitte wähle eine Frage!";

		this.btnYesTextYes = "Ja";
		this.btnYesTextRight = "Richtig";
		this.btnNoTextNo = "Nein";
		this.btnNoTextWrong = "Falsch";
		this.btnIdontKnowTextIdontKnow = "Ich weiß nicht";
		this.btnIdontKnowTextContinue = "Fortfahren";
		this.btnIdontKnowTextIknow = "Ich glaube ich kennen deinen Character";

		this.cmbQuestionsTextSelectAQuestion = "Eine Frage wählen...";
		this.cmbQuestionsTextSelectNextQuestion = "Die nächste Frage wählen...";
		this.cmbQuestionsTextYouveAskThisQuestionAlready = "Du hast diese Frage bereits gestellt!";

		this.lblGameResultText.setValue("Spielergebnis");
		this.lblPlayerText.setValue("Spieler");
		this.lblGuessedCharacterText.setValue("Erratener Character:");
		this.lblRightGuessText.setValue("Richtig erraten:");
		this.lblNoOfQuestionsText.setValue("Anzahl benötigter Fragen:");
		this.lblWhosWinnerText.setValue("Gewinner:");

		this.lblWinnerText = " hat gewonnen!!!";
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
		this.btnIdontKnowText.set(this.btnIdontKnowTextIdontKnow);
	}
	
	void setBtnIdontKnowTextToContinue() {
		this.btnIdontKnowText.set(this.btnIdontKnowTextContinue);
	}
	
	void setBtnIdontKnowTextToIknow() {
		this.btnIdontKnowText.set(this.btnIdontKnowTextIknow);
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################