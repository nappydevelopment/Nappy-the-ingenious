//### WikiStageResources.java ###############################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.wikiStage;

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
	
	StringProperty stageTitleText;
	
	//Stage icon:
	Image stageIcon16x16;
	Image stageIcon32x32;
	
//### CONSTRUCTORS #########################################################################################################################
	
	/* WikiStageResources [constructor]: Default constructor to create a WikiStageResources-object *//**
	 * 
	 */
	WikiStageResources() {
		
		this.stageTitleText = new SimpleStringProperty("Nappy, the ingenious - Wiki");
		//Icon:
		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/wiki.png");
		this.stageIcon32x32 = new Image(GlobalReferences.ICONS_PATH + "32x32/wiki.png");
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	/* setTextsToEnglish [method]: Method that sets all texts of the wiki-stage to English *//**
	 * 
	 */
	void setTextsToEnglish() {
		
	}
	
	/* setTextsToGerman [method]: Method that sets all texts of the wiki-stage to German *//**
	 * 
	 */
	void setTextsToGerman() {
		
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################