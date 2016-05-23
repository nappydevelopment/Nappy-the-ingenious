//### InfoStageView.java ###################################################################################################################

package nappydevelopment.nappyTheIngenious.gui.infoStage;

//### IMPORTS ##############################################################################################################################
import java.awt.*;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import nappydevelopment.nappyTheIngenious.util.Utils;


public class InfoStageView extends Stage {

//### COMPONENTS ###########################################################################################################################

	//Scene of the stage:
	Scene scene;
		
	//Root pane (container) that contains all GUI-components:
	BorderPane bdpRootPane;
	
	GridPane gdpContentPane;
	
	Label lblTitle;
	Label lblDescription;
	ImageView imvLogo;
	
	Label lblDevelopedBy;
	
	Circle cirPic1;
	Circle cirPic2;
	Circle cirPic3;
	Circle cirPic4;
	ImagePattern impPic1;
	ImagePattern impPic2;
	ImagePattern impPic3;
	ImagePattern impPic4;
	Label lblName1;
	Label lblName2;
	Label lblName3;
	Label lblName4;;

	Label lblNappyDevelopment;
	Hyperlink linkBlog;
	Hyperlink linkMail;
    HostServices host;

//### CONSTRUCTORS #########################################################################################################################
	
	/* InfoStageView [constructor]: Constructor that creates a new info-stage-view with all gui-components *//**
	 * 
	 * @param res
	 * @param aeh
	 */
	public InfoStageView(InfoStageResources res, EventHandler<ActionEvent> aeh) {	
		this.initComponents(res, aeh);
		this.structureComponents();
		this.initStage(res);
		
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	//Method that initialize the gui-components:
	private void initComponents(InfoStageResources res, EventHandler<ActionEvent> aeh) {
		
		this.bdpRootPane = new BorderPane();
		
		this.gdpContentPane = new GridPane();
		//this.gdpContentPane.setGridLinesVisible(true);
		this.gdpContentPane.setHgap(5);
		this.gdpContentPane.setVgap(10);
		this.gdpContentPane.setPadding(new Insets(15, 15, 15, 15));
		
		this.lblTitle = new Label();
		this.lblTitle.setId("lblTitle");
		this.lblTitle.setWrapText(true);
		this.lblDescription = new Label();
		this.lblDescription.setId("lblDescription");
	
		this.lblDevelopedBy = new Label();
		this.cirPic1 = new Circle();
		this.cirPic1.setRadius(16);
		this.cirPic2 = new Circle();
		this.cirPic2.setRadius(16);
		this.cirPic3 = new Circle();
		this.cirPic3.setRadius(16);
		this.cirPic4 = new Circle();
		this.cirPic4.setRadius(16);
		this.impPic1 = new ImagePattern(new Image(GlobalReferences.IMAGES_PATH + "team/manu.png"));
		this.impPic2 = new ImagePattern(new Image(GlobalReferences.IMAGES_PATH + "team/marc.png"));
		this.impPic3 = new ImagePattern(new Image(GlobalReferences.IMAGES_PATH + "team/marvin.png"));
		this.impPic4 = new ImagePattern(new Image(GlobalReferences.IMAGES_PATH + "team/ali.png"));
		this.cirPic1.setFill(this.impPic1);
		this.cirPic2.setFill(this.impPic2);
		this.cirPic3.setFill(this.impPic3);
		this.cirPic4.setFill(this.impPic4);
		this.lblName1 = new Label();
		this.lblName2 = new Label();
		this.lblName3 = new Label();
		this.lblName4 = new Label();
		
		this.imvLogo = new ImageView(Utils.getScaledInstance(res.imvLogoImage, 200, 200, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.75, true));
		
		this.lblNappyDevelopment = new Label();

		this.linkBlog = new Hyperlink("https://nappydevelopment.wordpress.com/");
		this.linkBlog.setOnAction(aeh);
		this.linkMail = new Hyperlink("nappydevelopment@gmail.com");
		this.linkMail.setOnAction(aeh);
	}
	
	
	private void structureComponents() {
		
		this.gdpContentPane.add(this.lblTitle, 0, 0, 4, 1);
		this.gdpContentPane.add(this.lblDescription, 0, 1, 4, 1);
		this.gdpContentPane.add(this.imvLogo, 4, 0, 1, 3);
		this.gdpContentPane.add(this.lblDevelopedBy, 0, 3, 2, 1);
		this.gdpContentPane.add(this.cirPic1, 0, 4);
		this.gdpContentPane.add(this.cirPic2, 0, 5);
		this.gdpContentPane.add(this.cirPic3, 0, 6);
		this.gdpContentPane.add(this.cirPic4, 0, 7);
		this.gdpContentPane.add(this.lblName1, 1, 4);
		this.gdpContentPane.add(this.lblName2, 1, 5);
		this.gdpContentPane.add(this.lblName3, 1, 6);
		this.gdpContentPane.add(this.lblName4, 1, 7);
		this.gdpContentPane.add(this.lblNappyDevelopment, 4, 4);
		this.gdpContentPane.add(this.linkBlog, 4, 5);
		this.gdpContentPane.add(this.linkMail, 4, 6);
		
		this.bdpRootPane.setCenter(this.gdpContentPane);
		
	}
	
	private void initStage(InfoStageResources res) {
		
		this.getIcons().addAll(res.stageIcon16x16);
		this.scene = new Scene(this.bdpRootPane, 508, 426);
		this.scene.getStylesheets().add(InfoStageView.class.getResource("InfoStageCSS.css").toExternalForm());
		this.setScene(this.scene);
		this.setResizable(true);
		
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################