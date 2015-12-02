//### StatisticStageResources.java #########################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.statisticStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;

/* StatisticStageResources [class]: Contains the resources for the statistic-stage like images, component-texts etc.: *//**
 * 
 * @author Manuel Bothner
 *
 */
public class StatisticStageResources {

//### ATTRIBUTES ###########################################################################################################################
	
	//Stage title:
	StringProperty stageTitleText;
	//Stage icon:
	Image stageIcon16x16;
	Image stageIcon32x32;
	
//### CONSTRUCTORS #########################################################################################################################
	
	/* StatisticStageResources [constructor]: Default constructor to create a StatisticStageResources-object *//**
	 * 
	 */
	StatisticStageResources() {
		
		this.stageTitleText = new SimpleStringProperty();
		
		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/statistic.png");
		
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	/* setTextsToEnglish [method]: Method that sets all texts of the statistic-stage to English *//**
	 * 
	 */
	void setTextsToEnglish() {
		this.stageTitleText.setValue("Nappy, the ingenious - Statistic");
	}
	
	/* setTextsToGerman [method]: Method that sets all texts of the statistic-stage to German *//**
	 * 
	 */
	void setTextsToGerman() {
		this.stageTitleText.setValue("Nappy, the ingenious - Statistik");
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################