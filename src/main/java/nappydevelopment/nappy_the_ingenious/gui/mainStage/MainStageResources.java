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
	
//### CONSTRUCTORS #########################################################################################################################	
	
	public MainStageResources() {

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
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	public void setTextsToEnglish() {
		
		//Menu-Texts:
		mnuGameText.setValue("Game");
		mniNewGameText.setValue("New Game");
		mniAbortGameText.setValue("Abort Game");
		mniStatisticText.setValue("Statistic");
		mniSettingsText.setValue("Settings");
		mniExitText.setValue("Exit");
		mnuHelpText.setValue("Help");
		mniHelpText.setValue("Help");
		mniWikiText.setValue("Wiki");
		mniInfoText.setValue("Info");
		
		//Button-Texts:
		btnNewGameText.setValue("New Game");
		btnStatisticText.setValue("Statistic");
		btnWikiText.setValue("Wiki");
		btnHelpText.setValue("Help");
		
		btnYesText.setValue("Yes");
		btnNoText.setValue("No");
		btnIdontKnow.setValue("I don't know");
	}
	
	public void setTextsToGerman() {
		
		//Menu-Texts:
		mnuGameText.setValue("Spiel");
		mniNewGameText.setValue("Neues Spiel");
		mniAbortGameText.setValue("Spiel Abbrechen");
		mniStatisticText.setValue("Statistik");
		mniSettingsText.setValue("Einstellungen");
		mniExitText.setValue("Beenden");
		mnuHelpText.setValue("Hilfe");
		mniHelpText.setValue("Spielanleitung");
		mniWikiText.setValue("Wiki");
		mniInfoText.setValue("Info");
		
		//Button-Texts:
		btnNewGameText.setValue("Neues Spiel");
		btnStatisticText.setValue("Statistik");
		btnWikiText.setValue("Wiki");
		btnHelpText.setValue("Spielanleitung");
		
		btnYesText.setValue("Ja");
		btnNoText.setValue("Nein");
		btnIdontKnow.setValue("Ich weiﬂ nicht");
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################