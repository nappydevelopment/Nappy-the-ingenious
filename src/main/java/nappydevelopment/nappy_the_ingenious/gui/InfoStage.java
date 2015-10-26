package nappydevelopment.nappy_the_ingenious.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
//### IMPORTS ##############################################################################################################################
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Main;

/* InfoStage [class]: Stage for the info-window *//**
 * 
 * @author Manuel Bothner
 *
 */
public class InfoStage extends Stage {
	
//### COMPONENTS ###########################################################################################################################	
	
	private Scene startScene;
	private GridPane gdpRootPane;
	private GridPane gdpDeveloptBy;
	
	private VBox vbxTitle;
	private VBox vbxContact;
	private HBox hbxImage;
	
	private Label lblGameTitle;
	private Label lblGameDescription;
	
	private Label lblDeveloptBy;
	
	private ImageView imvNappy;
	
	private Circle cirPic1;
	private Circle cirPic2;
	private Circle cirPic3;
	private Circle cirPic4;
	private ImagePattern impPic1;
	private ImagePattern impPic2;
	private ImagePattern impPic3;
	private ImagePattern impPic4;
	private Label lblName1;
	private Label lblName2;
	private Label lblName3;
	private Label lblName4;
	
	private Label lblNappyDevelopment;
	private Label lblOurBlog;
	private Label lblBlog;
	private Label lblOurEmail;
	private Label lblEmail;
	
//### CONSTRUCTORS #########################################################################################################################	
	
	public InfoStage() {
		this.initComponents();
		this.initStage();
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	private void initComponents() {
		
		this.gdpRootPane = new GridPane();
		this.gdpRootPane.setPadding(new Insets(0,0,0,0));
		this.gdpRootPane.setGridLinesVisible(true);
		
		this.lblGameTitle = new Label("Nappy, the ingenious");
		this.lblGameDescription = new Label("Ein Simpsons Quiz");
		this.lblDeveloptBy = new Label("Entwickelt von:");
		
		this.vbxTitle = new VBox(10);
		this.vbxContact = new VBox(10);
		this.vbxContact.setPadding(new Insets(10,10,10,10));
		
		this.hbxImage = new HBox();
		this.hbxImage.setAlignment(Pos.BASELINE_RIGHT);
		this.imvNappy = new ImageView(new Image(Main.IMAGES_PATH + "general/nappy_small.png"));
		this.hbxImage.getChildren().add(this.imvNappy);
		
		this.gdpDeveloptBy = new GridPane();
		this.gdpDeveloptBy.setPadding(new Insets(10,10,10,10));
		this.gdpDeveloptBy.setHgap(10);
		this.gdpDeveloptBy.setVgap(10);
		this.gdpDeveloptBy.setGridLinesVisible(true);
		
		this.cirPic1 = new Circle();
		this.cirPic1.setRadius(16);
		this.cirPic2 = new Circle();
		this.cirPic2.setRadius(16);
		this.cirPic3 = new Circle();
		this.cirPic3.setRadius(16);
		this.cirPic4 = new Circle();
		this.cirPic4.setRadius(16);
		this.impPic1 = new ImagePattern(new Image(Main.IMAGES_PATH + "team/manu.png"));
		this.impPic2 = new ImagePattern(new Image(Main.IMAGES_PATH + "team/marc.png"));
		this.impPic3 = new ImagePattern(new Image(Main.IMAGES_PATH + "team/marvin.png"));
		this.impPic4 = new ImagePattern(new Image(Main.IMAGES_PATH + "team/ali.png"));
		this.cirPic1.setFill(this.impPic1);
		this.cirPic2.setFill(this.impPic2);
		this.cirPic3.setFill(this.impPic3);
		this.cirPic4.setFill(this.impPic4);
		this.lblName1 = new Label("Manuel Bothner");
		this.lblName2 = new Label("Marc Mahler");
		this.lblName3 = new Label("Marvin Zerulla");
		this.lblName4 = new Label("Mehmet Ali Incekara");
		
		this.gdpDeveloptBy.add(this.lblDeveloptBy, 0, 0, 2, 2);
		this.gdpDeveloptBy.add(this.cirPic1, 0, 2);
		this.gdpDeveloptBy.add(this.lblName1, 1, 2);
		this.gdpDeveloptBy.add(this.cirPic2, 0, 3);
		this.gdpDeveloptBy.add(this.lblName2, 1, 3);
		this.gdpDeveloptBy.add(this.cirPic3, 0, 4);
		this.gdpDeveloptBy.add(this.lblName3, 1, 4);
		this.gdpDeveloptBy.add(this.cirPic4, 0, 5);
		this.gdpDeveloptBy.add(this.lblName4, 1, 5);
		
		this.lblNappyDevelopment = new Label("nappydevelopment");
		this.lblOurBlog = new Label("Unser Blog:");
		this.lblBlog = new Label("https://nappydevelopment.wordpress.com/");
		this.lblOurEmail = new Label("E-Mail-Adresse:");
		this.lblEmail = new Label("nappydevelopment@gmx.de");
		
		this.vbxTitle.getChildren().addAll(this.lblGameTitle, this.lblGameDescription);
		this.vbxContact.getChildren().addAll(this.lblNappyDevelopment, this.lblOurBlog, this.lblBlog, this.lblOurEmail, this.lblEmail);
		
		this.gdpRootPane.add(this.vbxTitle, 0, 0);
		this.gdpRootPane.add(this.hbxImage, 1, 0);
		this.gdpRootPane.add(this.gdpDeveloptBy, 0, 1);
		this.gdpRootPane.add(this.vbxContact, 1, 1);
		this.gdpRootPane.setPrefSize(400, 350);

	}
	
	private void initStage() {		
		this.setTitle("Nappy, the ingenious - Info");
		this.getIcons().add(new Image(Main.ICONS_PATH + "16x16/info.png"));
		this.startScene = new Scene(this.gdpRootPane);
		this.setScene(this.startScene);
		this.setResizable(false);
	}
}
//### EOF ##################################################################################################################################