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
    
	StringProperty tbpTopFivePlayerText;
	
	StringProperty lblP1PositionText;
	StringProperty lblP1NameText;
	StringProperty lblP1ValueText;
	
	StringProperty lblP2PositionText;
	StringProperty lblP2NameText;
	StringProperty lblP2ValueText;
	
	StringProperty lblP3PositionText;
	StringProperty lblP3NameText;
	StringProperty lblP3ValueText;
	
	StringProperty lblP4PositionText;
	StringProperty lblP4NameText;
	StringProperty lblP4ValueText;
	
	StringProperty lblP5PositionText;
	StringProperty lblP5NameText;
	StringProperty lblP5ValueText;
	
	StringProperty tbpTopFiveCharacterText;
	
	StringProperty lblC1PositionText;
	StringProperty lblC1NameText;
	StringProperty lblC1CounterText;
	
	StringProperty lblC2PositionText;
	StringProperty lblC2NameText;
	StringProperty lblC2CounterText;
	
	StringProperty lblC3PositionText;
	StringProperty lblC3NameText;
	StringProperty lblC3CounterText;
	
	StringProperty lblC4PositionText;
	StringProperty lblC4NameText;
	StringProperty lblC4CounterText;
	
	StringProperty lblC5PositionText;
	StringProperty lblC5NameText;
	StringProperty lblC5CounterText;
	
	StringProperty btnOkText;
	
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
        
		this.tbpTopFivePlayerText = new SimpleStringProperty();
		this.lblP1PositionText = new SimpleStringProperty();
		this.lblP1NameText = new SimpleStringProperty();
		this.lblP1ValueText = new SimpleStringProperty();
		this.lblP2PositionText = new SimpleStringProperty();
		this.lblP2NameText = new SimpleStringProperty();
		this.lblP2ValueText = new SimpleStringProperty();
		this.lblP3PositionText = new SimpleStringProperty();
		this.lblP3NameText = new SimpleStringProperty();
		this.lblP3ValueText = new SimpleStringProperty();
		this.lblP4PositionText = new SimpleStringProperty();
		this.lblP4NameText = new SimpleStringProperty();
		this.lblP4ValueText = new SimpleStringProperty();
		this.lblP5PositionText = new SimpleStringProperty();
		this.lblP5NameText = new SimpleStringProperty();
		this.lblP5ValueText = new SimpleStringProperty();
		
		this.tbpTopFiveCharacterText = new SimpleStringProperty();
		this.lblC1PositionText = new SimpleStringProperty();
		this.lblC1NameText = new SimpleStringProperty();
		this.lblC1CounterText = new SimpleStringProperty();
		this.lblC2PositionText = new SimpleStringProperty();
		this.lblC2NameText = new SimpleStringProperty();
		this.lblC2CounterText = new SimpleStringProperty();
		this.lblC3PositionText = new SimpleStringProperty();
		this.lblC3NameText = new SimpleStringProperty();
		this.lblC3CounterText = new SimpleStringProperty();
		this.lblC4PositionText = new SimpleStringProperty();
		this.lblC4NameText = new SimpleStringProperty();
		this.lblC4CounterText = new SimpleStringProperty();
		this.lblC5PositionText = new SimpleStringProperty();
		this.lblC5NameText = new SimpleStringProperty();
		this.lblC5CounterText = new SimpleStringProperty();
		
		this.btnOkText = new SimpleStringProperty();
		
		this.stageTitleText = new SimpleStringProperty();

		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/statistic.png");
		
		this.setUniversalTexts();
	}

//### PRIVATE METHODS ######################################################################################################################	
	
	void setUniversalTexts() {
		
		this.lblP1PositionText.setValue("1.");
		this.lblP1NameText.setValue("-");
		this.lblP1ValueText.setValue("-");
		this.lblP2PositionText.setValue("2.");
		this.lblP2NameText.setValue("-");
		this.lblP2ValueText.setValue("-");
		this.lblP3PositionText.setValue("3.");
		this.lblP3NameText.setValue("-");
		this.lblP3ValueText.setValue("-");
		this.lblP4PositionText.setValue("4.");
		this.lblP4NameText.setValue("-");
		this.lblP4ValueText.setValue("-");
		this.lblP5PositionText.setValue("5.");
		this.lblP5NameText.setValue("-");
		this.lblP5ValueText.setValue("-");
		
		this.lblC1PositionText.setValue("1.");
		this.lblC1NameText.setValue("-");
		this.lblC1CounterText.setValue("-");
		this.lblC2PositionText.setValue("2.");
		this.lblC2NameText.setValue("-");
		this.lblC2CounterText.setValue("-");
		this.lblC3PositionText.setValue("3.");
		this.lblC3NameText.setValue("-");
		this.lblC3CounterText.setValue("-");
		this.lblC4PositionText.setValue("4.");
		this.lblC4NameText.setValue("-");
		this.lblC4CounterText.setValue("-");
		this.lblC5PositionText.setValue("5.");
		this.lblC5NameText.setValue("-");
		this.lblC5CounterText.setValue("-");
		
		this.btnOkText.setValue("Ok");
	}
	
//### PUBLIC METHODS #######################################################################################################################

	/* setTextsToEnglish [method]: Method that sets all texts of the statistic-stage to English *//**
	 *
	 */
	void setTextsToEnglish() {
		
		this.tbpTopFivePlayerText.setValue("  Top five players  ");
		
		this.tbpTopFiveCharacterText.setValue("  Top five Simpsons characters  ");
		
		this.stageTitleText.setValue("Nappy, the ingenious - Statistic");
	}

	/* setTextsToGerman [method]: Method that sets all texts of the statistic-stage to German *//**
	 *
	 */
	void setTextsToGerman() {
		
		this.tbpTopFivePlayerText.setValue("  Top fünf Spieler  ");
		
		this.tbpTopFiveCharacterText.setValue("  Top fünf Simpsons Charakter  ");
		
		this.stageTitleText.setValue("Nappy, the ingenious - Statistik");
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################