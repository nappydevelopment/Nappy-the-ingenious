package nappydevelopment.nappy_the_ingenious.gui.infoStage;

//### IMPORTS ##############################################################################################################################
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class InfoStageView {

//### COMPONENTS ###########################################################################################################################

	//Scene of the stage:
	Scene scene;
		
	//Root pane (container) that contains all GUI-components:
	BorderPane bdpRootPane;
	
	GridPane gdpContentPane;
	
	GridPane gdpTop;
	Label lblTitle;
	Label lblDescription;
	ImageView imvLogo;
	
	GridPane gdpBottom;
	
	Label lblDeveloptBy;
	
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
	Label lblOurBlog;
	Label lblBlog;
	Label lblOurEmail;
	Label lblEmail;

//### CONSTRUCTORS #########################################################################################################################
	
	public InfoStageView(InfoStageResources res, EventHandler<ActionEvent> aeh) {
		
		this.initComponents(res, aeh);
		this.structureComponents();
		this.initStage();
		
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	private void initComponents(InfoStageResources res, EventHandler<ActionEvent> aeh) {
		
		this.bdpRootPane = new BorderPane();
		
		
	}
	
	private void structureComponents() {
		
	}
	
	private void initStage() {
		
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################