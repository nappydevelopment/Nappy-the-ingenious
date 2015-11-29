package nappydevelopment.nappy_the_ingenious.gui.statisticStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class StatisticStageResources {

//### ATTRIBUTES ###########################################################################################################################
	
	StringProperty stageTitleText;
	
//### CONSTRUCTORS #########################################################################################################################
	
	StatisticStageResources() {
		
		this.stageTitleText = new SimpleStringProperty();
		
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	void setTextsToEnglish() {
		this.stageTitleText.setValue("Nappy, the ingenious - Statistic");
	}
	
	void setTextsToGerman() {
		this.stageTitleText.setValue("Nappy, the ingenious - Statistik");
	}
	
}
//### EOF ##################################################################################################################################