//### HelpStageResources.java ##############################################################################################################

package nappydevelopment.nappyTheIngenious.gui.helpStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;

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
	}

//### PUBLIC METHODS #######################################################################################################################

	protected void changeLanguageToEnglish(){
		this.stageTitleText.setValue("Nappy, the ingenious - Instructions");
	}

	protected void changeLanguageToGerman(){
		this.stageTitleText.setValue("Nappy, the ingenious - Spielanleitung");
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################