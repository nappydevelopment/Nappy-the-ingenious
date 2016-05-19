//### HelpStageResources.java ##############################################################################################################

package nappydevelopment.nappyTheIngenious.gui.helpStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import nappydevelopment.nappyTheIngenious.data.settings.Language;

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

	void setTextsTo(Language l) {
		switch(l){
			case ENGLISH:
				this.stageTitleText.setValue("Nappy, the ingenious - Instructions");
				break;
			case GERMAN:
				this.stageTitleText.setValue("Nappy, the ingenious - Spielanleitung");
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################