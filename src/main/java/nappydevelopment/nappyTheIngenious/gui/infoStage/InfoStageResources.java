//### InfoStageResources.java ##############################################################################################################

package nappydevelopment.nappyTheIngenious.gui.infoStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappyTheIngenious.GlobalReferences;

/* InfoStageResources [class]: Contains the resources for the info-stage like images, component-texts etc.: *//**
 *
 * @author Manuel Bothner, Mehmet Ali Incekara
 *
 */
public class InfoStageResources {

	StringProperty stageTitleText;

	//Stage icon:
	Image stageIcon16x16;
	Image stageIcon32x32;

	StringProperty lblTitleText;
	StringProperty lblDescriptionText;
	StringProperty lblDevelopedByText;
	StringProperty lblName1Text;
	StringProperty lblName2Text;
	StringProperty lblName3Text;
	StringProperty lblName4Text;

	StringProperty lblNappyDevelopmentText;

	Image imvLogoImage;
	Image impPic1Image;
	Image impPic2Image;
	Image impPic3Image;
	Image impPic4Image;

//### CONSTRUCTORS #########################################################################################################################

	/* InfoStageResources [constructor]: Default constructor to create a InfoStageResources-object *//**
	 *
	 */
	InfoStageResources() {

		this.stageTitleText = new SimpleStringProperty("Nappy, the ingenious - Info");

		//Icon:
		this.stageIcon16x16 = new Image(GlobalReferences.ICONS_PATH + "16x16/info.png");

		this.lblTitleText = new SimpleStringProperty("Nappy, the ingenious");
		this.lblDescriptionText = new SimpleStringProperty();

		this.lblDevelopedByText = new SimpleStringProperty();
		this.lblName1Text = new SimpleStringProperty("Manuel Bothner");
		this.lblName2Text = new SimpleStringProperty("Marc Mahler");
		this.lblName3Text = new SimpleStringProperty("Marvin Zerulla");
		this.lblName4Text = new SimpleStringProperty("Mehmet Ali Incekara");

		this.lblNappyDevelopmentText = new SimpleStringProperty("nappydevelopment");

		this.imvLogoImage = new Image(GlobalReferences.IMAGES_PATH + "general/logo.png");
	}

//### PUBLIC METHODS #######################################################################################################################

	protected void changeLanguageToGerman(){
		this.lblDescriptionText.setValue("Ein Simpsons Quiz");
		this.lblDevelopedByText.setValue("Entwickelt von");
	}

	protected void changeLanguageToEnglish(){
		this.lblDescriptionText.setValue("A Simpsons quiz game");
		this.lblDevelopedByText.setValue("Developed by");
	}


//##########################################################################################################################################
}
//### EOF ##################################################################################################################################