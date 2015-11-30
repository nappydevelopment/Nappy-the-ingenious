//### HelpStageResources.java ##############################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.helpStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;

/* HelpStageResources [class]: Contains the resources for the help-stage like images, component-texts etc.: *//**
 * 
 * @author Manuel Bothner
 *
 */
public class HelpStageResources {

//### ATTRIBUTES ###########################################################################################################################
	
	StringProperty stageTitleText;
	
	//Stage icon:
	Image stageIcon16x16;
	Image stageIcon32x32;
	
//### CONSTRUCTORS #########################################################################################################################
	
	/* HelpStageResources [constructor]: Default constructor to create a HelpStageResources-object *//**
	 * 
	 */
	HelpStageResources() {
		
		this.stageTitleText = new SimpleStringProperty();
		//Icon:
		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/help.png");
		this.stageIcon32x32 = new Image(GlobalReferences.ICONS_PATH + "32x32/help.png");
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	/* setTextsToEnglish [method]: Method that sets all texts of the help-stage to English *//**
	 * 
	 */
	void setTextsToEnglish() {
		
		this.stageTitleText.setValue("Nappy, the ingenious - Instructions");
	
	}
	
	/* setTextsToGerman [method]: Method that sets all texts of the help-stage to German *//**
	 * 
	 */
	void setTextsToGerman() {
		
		this.stageTitleText.setValue("Nappy, the ingenious - Spielanleitung");
		
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################