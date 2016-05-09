//### WikiStageResources.java ###############################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.wikiStage;

import java.util.HashMap;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;

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

//### CONSTRUCTORS #########################################################################################################################

	/* WikiStageResources [constructor]: Default constructor to create a WikiStageResources-object *//**
	 *
	 */
	WikiStageResources() {

		this.charNameImageMap = new HashMap<String, Image>();
		this.stageTitleText = new SimpleStringProperty("Nappy, the ingenious - Wiki");
		//Icon:
		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/wiki.png");
		
		this.tbpGenderText = new SimpleStringProperty();
		this.rbtMaleText = new SimpleStringProperty();
		this.rbtFemaleText = new SimpleStringProperty();
		this.tbpAgeText = new SimpleStringProperty();
		this.rbpYoungText = new SimpleStringProperty();
		this.rbpMiddleText = new SimpleStringProperty();
		this.rbpOldText = new SimpleStringProperty();
		
		this.btnResetFilterText = new SimpleStringProperty();
		
	}

//### PUBLIC METHODS #######################################################################################################################

	/* setTextsToEnglish [method]: Method that sets all texts of the wiki-stage to English *//**
	 *
	 */
	void setTextsToEnglish() {
		
		this.tbpGenderText.setValue("  Gender  ");
		this.rbtMaleText.setValue("Male");
		this.rbtFemaleText.setValue("Female");
		
		this.tbpAgeText.setValue("  Age  ");
		this.rbpYoungText.setValue("Young");
		this.rbpMiddleText.setValue("Adult");
		this.rbpOldText.setValue("Old");
		
		this.btnResetFilterText.setValue("Reset filter");
	}

	/* setTextsToGerman [method]: Method that sets all texts of the wiki-stage to German *//**
	 *
	 */
	void setTextsToGerman() {
		
		this.tbpGenderText.setValue("  Geschlecht  ");
		this.rbtMaleText.setValue("Männlich");
		this.rbtFemaleText.setValue("Weiblich");
		
		this.tbpAgeText.setValue("  Alter  ");
		this.rbpYoungText.setValue("Jung");
		this.rbpMiddleText.setValue("Erwachsen");
		this.rbpOldText.setValue("Alt");
		
		this.btnResetFilterText.setValue("Filter zurücksetzten");
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################