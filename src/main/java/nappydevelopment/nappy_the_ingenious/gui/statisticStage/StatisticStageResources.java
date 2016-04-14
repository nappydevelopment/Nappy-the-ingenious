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
	
	StringProperty lblPlayerPositionTexts[];
	StringProperty lblPlayerNameTexts[];
	StringProperty lblPlayerValueTexts[];
	
	StringProperty tbpTopFiveCharacterText;
	
	StringProperty lblCharacterPositionTexts[];
	StringProperty lblCharacterNameTexts[];
	StringProperty lblCharacterCounterTexts[];
	
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
		this.lblPlayerPositionTexts = new SimpleStringProperty[5];
		this.lblPlayerNameTexts = new SimpleStringProperty[5];
		this.lblPlayerValueTexts = new SimpleStringProperty[5];
		
		for( int i = 0; i < 5; i++ ) {
			lblPlayerPositionTexts[i] = new SimpleStringProperty();
			lblPlayerNameTexts[i] = new SimpleStringProperty();
			lblPlayerValueTexts[i] = new SimpleStringProperty();
		}
		
		this.tbpTopFiveCharacterText = new SimpleStringProperty();
		this.lblCharacterPositionTexts = new SimpleStringProperty[5];
		this.lblCharacterNameTexts = new SimpleStringProperty[5];
		this.lblCharacterCounterTexts = new SimpleStringProperty[5];
		
		for( int i = 0; i < 5; i++ ) {
			lblCharacterPositionTexts[i] = new SimpleStringProperty();
			lblCharacterNameTexts[i] = new SimpleStringProperty();
			lblCharacterCounterTexts[i] = new SimpleStringProperty();
		}
		
		this.btnOkText = new SimpleStringProperty();
		
		this.stageTitleText = new SimpleStringProperty();

		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/statistic.png");
		
		this.setUniversalTexts();
	}

//### PRIVATE METHODS ######################################################################################################################	
	
	void setUniversalTexts() {
		
		for(int i = 0; i < 5; i++) {
			this.lblPlayerPositionTexts[i].setValue((i + 1) + ".");
			this.lblPlayerNameTexts[i].setValue("-");
			this.lblPlayerValueTexts[i].setValue("-");
		}

		for(int i = 0; i < 5; i++) {
			this.lblCharacterPositionTexts[i].setValue((i + 1) + ".");
			this.lblCharacterNameTexts[i].setValue("-");
			this.lblCharacterCounterTexts[i].setValue("-");
		}
		
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