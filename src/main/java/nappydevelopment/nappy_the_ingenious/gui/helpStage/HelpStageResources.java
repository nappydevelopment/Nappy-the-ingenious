package nappydevelopment.nappy_the_ingenious.gui.helpStage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//### IMPORTS ##############################################################################################################################
public class HelpStageResources {

//### ATTRIBUTES ###########################################################################################################################
	
	StringProperty stageTitleText;

//### CONSTRUCTORS #########################################################################################################################
	
	HelpStageResources() {
		this.stageTitleText = new SimpleStringProperty();
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	void setTextsToEnglish() {
		
		this.stageTitleText.setValue("Nappy, the ingenious - Instruction");
	
	}
	
	void setTextsToGerman() {
		
		this.stageTitleText.setValue("Nappy, the ingenious - Spielanleitung");
		
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################