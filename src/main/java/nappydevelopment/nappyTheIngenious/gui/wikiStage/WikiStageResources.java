//### WikiStageResources.java ###############################################################################################################

package nappydevelopment.nappyTheIngenious.gui.wikiStage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;

import java.util.HashMap;

//### IMPORTS ##############################################################################################################################

/* WikiStageResources [class]: Contains the resources for the wiki-stage like images, component-texts etc.: *//**
 *
 * @author Manuel Bothner
 *
 */
public class WikiStageResources {

//### ATTRIBUTES ###########################################################################################################################

	HashMap<String, Image> charNameImageMap;
	
	StringProperty stageTitleText;
	
	StringProperty tbpGenderText;
	StringProperty rbtMaleText;
	StringProperty rbtFemaleText;
	StringProperty tbpAgeText;
	StringProperty rbpYoungText;
	StringProperty rbpMiddleText;
	StringProperty rbpOldText;
	
	StringProperty btnResetFilterText;

	//Stage icon:
	Image stageIcon16x16;
	Image stageIcon32x32;

	boolean selectionFlag;
	
	String confirmDialogBtnApplyText;
	String confirmDialogBtnCancelText;
	String confirmDialogTitle;
	String confirmDialogHeaderText1;
	String confirmDialogHeaderText2;
	String confirmDialogContentText;
	
//### CONSTRUCTORS #########################################################################################################################

	/* WikiStageResources [constructor]: Default constructor to create a WikiStageResources-object *//**
	 *
	 */
	WikiStageResources() {

		this.charNameImageMap = new HashMap<String, Image>();
		this.stageTitleText = new SimpleStringProperty("Nappy, the ingenious - Wiki");

		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/wiki.png");
		
		this.tbpGenderText = new SimpleStringProperty();
		this.rbtMaleText = new SimpleStringProperty();
		this.rbtFemaleText = new SimpleStringProperty();
		this.tbpAgeText = new SimpleStringProperty();
		this.rbpYoungText = new SimpleStringProperty();
		this.rbpMiddleText = new SimpleStringProperty();
		this.rbpOldText = new SimpleStringProperty();
		
		this.btnResetFilterText = new SimpleStringProperty();
		
		this.selectionFlag = false;
	}

//### PUBLIC METHODS #######################################################################################################################


	protected void changeLanguageToEnglish() {
		this.tbpGenderText.setValue("  Gender  ");
		this.rbtMaleText.setValue("Male");
		this.rbtFemaleText.setValue("Female");

		this.tbpAgeText.setValue("  Age  ");
		this.rbpYoungText.setValue("Young");
		this.rbpMiddleText.setValue("Adult");
		this.rbpOldText.setValue("Old");

		this.btnResetFilterText.setValue("Reset filter");
		
		this.confirmDialogBtnApplyText = "Yes";
		this.confirmDialogBtnCancelText = "No";
		this.confirmDialogTitle = "Nappy, the ingenious - Character selection";
		this.confirmDialogHeaderText1 = "You selected the character ";
		this.confirmDialogHeaderText2 = "";
		this.confirmDialogContentText = "Are you sure that you want to choose this character?";
		
	}

	protected void changeLanguageToGerman() {
		
		this.tbpGenderText.setValue("  Geschlecht  ");
		this.rbtMaleText.setValue("Männlich");
		this.rbtFemaleText.setValue("Weiblich");

		this.tbpAgeText.setValue("  Alter  ");
		this.rbpYoungText.setValue("Jung");
		this.rbpMiddleText.setValue("Erwachsen");
		this.rbpOldText.setValue("Alt");

		this.btnResetFilterText.setValue("Filter zurücksetzten");
		
		this.confirmDialogBtnApplyText = "Ja";
		this.confirmDialogBtnCancelText = "Nein";
		this.confirmDialogTitle = "Nappy, the ingenious - Charakter Auswahl";
		this.confirmDialogHeaderText1 = "Du hast den Charakter ";
		this.confirmDialogHeaderText2 = " ausgewählt";
		this.confirmDialogContentText = "Bist du sicher, dass du diesen Charakter wählen möchtest?";
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################