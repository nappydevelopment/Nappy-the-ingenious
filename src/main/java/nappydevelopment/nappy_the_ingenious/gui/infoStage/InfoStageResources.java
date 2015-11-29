
package nappydevelopment.nappy_the_ingenious.gui.infoStage;

//### IMPORTS ##############################################################################################################################
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;


public class InfoStageResources {
	
	StringProperty stageTitleText;
	
	StringProperty lblTitleText;
	StringProperty lblDescriptionText;
	StringProperty lblDevelopedByText;
	StringProperty lblName1Text;
	StringProperty lblName2Text;
	StringProperty lblName3Text;
	StringProperty lblName4Text;
	
	StringProperty lblNappyDevelopmentText;
	StringProperty lblOurBlogText;
	StringProperty lblBlogText;
	StringProperty lblOurEmailText;
	StringProperty lblEmailText;
	
	Image imvLogoImage;
	Image impPic1Image;
	Image impPic2Image;
	Image impPic3Image;
	Image impPic4Image;
	
//### CONSTRUCTORS #########################################################################################################################
	
	public InfoStageResources() {
		
		this.stageTitleText = new SimpleStringProperty("Nappy, the ingenious - Info");
		
		this.lblTitleText = new SimpleStringProperty("Nappy, the ingenious");
		this.lblDescriptionText = new SimpleStringProperty();
		
		this.lblDevelopedByText = new SimpleStringProperty();
		this.lblName1Text = new SimpleStringProperty("Manuel Bothner");
		this.lblName2Text = new SimpleStringProperty("Marc Mahler");
		this.lblName3Text = new SimpleStringProperty("Marvin Zerulla");
		this.lblName4Text = new SimpleStringProperty("Mehmet Ali Incekara");
		
		this.lblNappyDevelopmentText = new SimpleStringProperty("nappydevelopment");
		this.lblOurBlogText = new SimpleStringProperty();
		this.lblBlogText = new SimpleStringProperty("https://nappydevelopment.wordpress.com/");
		this.lblOurEmailText = new SimpleStringProperty();
		this.lblEmailText  = new SimpleStringProperty("nappydevelopment@gmail.com");
		
		this.imvLogoImage = new Image(GlobalReferences.IMAGES_PATH + "general/logo.png");
	}
	
//### PUBLIC METHODS #######################################################################################################################

	void setTextsToEnglish() {
		this.lblDescriptionText.setValue("A Simpsons quiz game");
		this.lblDevelopedByText.setValue("Developed by");
		this.lblOurBlogText.setValue("Our blog");
		this.lblOurEmailText.setValue("Our email-adress");
	}
	
	void setTextsToGerman() {
		this.lblDescriptionText.setValue("Ein Simpsons Quiz");
		this.lblDevelopedByText.setValue("Entwickelt von");
		this.lblOurBlogText.setValue("Unser Blog");
		this.lblOurEmailText.setValue("Unsere E-Mail-Adresse");
	}
	
}
//### EOF ##################################################################################################################################