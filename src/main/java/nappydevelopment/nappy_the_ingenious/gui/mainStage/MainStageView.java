//### MainStageView.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.mainStage;

//### IMPORTS ##############################################################################################################################
import java.awt.RenderingHints;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.gui.components.VerticalProgressBar;
import nappydevelopment.nappy_the_ingenious.util.Utils;

/* MainStageView [class]: Class the represents the main-stage-view so the whole window with all gui-components *//**
 * 
 * @author Manuel Bothner
 *
 */
public class MainStageView extends Stage {

//### COMPONENTS ###########################################################################################################################

	//### Content of all views on the main-stage ###################################################
	
	//Scene of the stage:
	Scene scene;
		
	//Root pane (container) that contains all GUI-components:
	BorderPane bdpRootPane;
		
	//Components of the menu-bar:
	MenuBar mnbMenuBar;
	//First menu:
	Menu mnuGame;
	MenuItem mniNewGame;
	MenuItem mniAbortGame;
	SeparatorMenuItem smiGame1;
	MenuItem mniStatistic;
	MenuItem mniSettings;
	SeparatorMenuItem smiGame2;
	MenuItem mniExit;
	//Second menu:
	Menu mnuHelp;
	MenuItem mniHelp;
	MenuItem mniWiki;
	SeparatorMenuItem smiHelp1;
	MenuItem mniInfo;
	
	//### Content of the start-view ################################################################

	GridPane gdpStartViewContentPane;
	Button btnNewGame;
	Separator sepSVCP1;
	Button btnStatistic;
	Button btnWiki;
	Button btnHelp;
		
	//### Content of the Gamemode1 View ############################################################
	
	GridPane gdpProgressBarPic;
	
	StackPane skpPicText;
	ImageView imvNappy;
	
	GridPane gdpQuestion;
	//Text txtQuestion;
	Label lblQuestion;
	
	VBox vbxNoOfQuest;
	Label lblNoOfQuest;
	VerticalProgressBar pgbNoOfQuest;
	ImageView imvNoOfQuest;
	
	VBox vbxKnowledge;
	Label lblKnowledge;
	VerticalProgressBar pgbKnowledge;
	ImageView imvKnowledge;
	
	GridPane gdpButtons;
	Button btnYes;
	Button btnNo;
	Button btnIdontKnow;
	
	//### Content of the Gamemode2 View ############################################################
	
	
//### CONSTRUCTORS #########################################################################################################################
	
	/* MainStageView [constructor]: Constructor that creates a new main-stage-view with all gui-components *//**
	 * 
	 * @param res
	 * @param aeh
	 */
	public MainStageView(MainStageResources res, EventHandler<ActionEvent> aeh) {
		this.initComponents(res, aeh);
		this.structureComponents();
		this.initStage();
	}
	
//### INITAL METHODS #######################################################################################################################
	
	//Method that initialize the gui-components:
	private void initComponents(MainStageResources res, EventHandler<ActionEvent> aeh) {
		
		//### Initialize components of all views ###################################################
		
		this.bdpRootPane = new BorderPane();
		
		//Menu-Bar-Components:
		this.mnbMenuBar = new MenuBar();
		
		//First menu:
		this.mnuGame = new Menu();
		
		this.mniNewGame = new MenuItem();
		this.mniNewGame.setGraphic(new ImageView(res.mniNewGameIcon));
		this.mniNewGame.setOnAction(aeh);
		
		this.mniAbortGame = new MenuItem(); 
		this.mniAbortGame.setGraphic(new ImageView(res.mniAbortGameIcon));
		this.mniAbortGame.setOnAction(aeh);
		this.mniAbortGame.setDisable(true); /* CHECK IF THIS IS HERE RIGHT */
		
		this.smiGame1 = new SeparatorMenuItem();
		
		this.mniStatistic = new MenuItem();
		this.mniStatistic.setGraphic(new ImageView(res.mniStatisticIcon));
		this.mniStatistic.setOnAction(aeh);
		
		this.mniSettings = new MenuItem();
		this.mniSettings.setGraphic(new ImageView(res.mniSettingsIcon));
		this.mniSettings.setOnAction(aeh);
		
		this.smiGame2 = new SeparatorMenuItem();
		
		this.mniExit = new MenuItem();
		this.mniExit.setGraphic(new ImageView(res.mniExitIcon));
		this.mniExit.setOnAction(aeh);
		
		//Second menu:
		this.mnuHelp = new Menu();
		
		this.mniHelp = new MenuItem(); 
		this.mniHelp.setGraphic(new ImageView(res.mniHelpIcon));
		this.mniHelp.setOnAction(aeh);
		
		this.mniWiki = new MenuItem();
		this.mniWiki.setGraphic(new ImageView(res.mniWikiIcon));
		this.mniWiki.setOnAction(aeh);
		
		this.smiHelp1 = new SeparatorMenuItem();
		
		this.mniInfo = new MenuItem(); 
		this.mniInfo.setGraphic(new ImageView(res.mniInfoIcon));
		this.mniInfo.setOnAction(aeh);
		
		//### Initialize components of the start-view ##############################################
		
		this.gdpStartViewContentPane = new GridPane();
		this.gdpStartViewContentPane.setHgap(0);
		this.gdpStartViewContentPane.setVgap(15);
		
		this.btnNewGame = new Button();
		this.btnNewGame.setGraphic(new ImageView(res.btnNewGameIcon));
		this.btnNewGame.setPrefSize(150, 40);
		this.btnNewGame.setAlignment(Pos.BASELINE_LEFT);
		this.btnNewGame.setOnAction(aeh);

		this.sepSVCP1 = new Separator();
		
		this.btnWiki = new Button();
		this.btnWiki.setGraphic(new ImageView(res.btnWikiIcon));
		this.btnWiki.setPrefSize(150, 40);
		this.btnWiki.setAlignment(Pos.BASELINE_LEFT);
		this.btnWiki.setOnAction(aeh);
		
		this.btnStatistic = new Button();
		this.btnStatistic.setGraphic(new ImageView(res.btnStatistikIcon));
		this.btnStatistic.setPrefSize(150, 40);
		this.btnStatistic.setAlignment(Pos.BASELINE_LEFT);
		this.btnStatistic.setOnAction(aeh);
		
		this.btnHelp = new Button();
		this.btnHelp.setGraphic(new ImageView(res.btnHelpIcon));
		this.btnHelp.setAlignment(Pos.BASELINE_LEFT);
		this.btnHelp.setPrefSize(150, 40);
		this.btnHelp.setOnAction(aeh);
		
		//### Initialize components of the gamemode1 view ##########################################
		
		this.gdpProgressBarPic = new GridPane();
		this.gdpProgressBarPic.setPadding(new Insets(10,10,10,10));
		//Set the column-rate:
	    ColumnConstraints col1 = new ColumnConstraints();
	    col1.setPercentWidth(10);
	    ColumnConstraints col2 = new ColumnConstraints();
	    col2.setPercentWidth(80);
	    ColumnConstraints col3 = new ColumnConstraints();
	    col3.setPercentWidth(10);
	    
	    this.gdpProgressBarPic.getColumnConstraints().addAll(col1,col2,col3);
	    //this.gdpProgressBarPic.setGridLinesVisible(true);
	    this.gdpProgressBarPic.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
	    
	    this.vbxNoOfQuest = new VBox();
	    this.vbxNoOfQuest.setPadding(new Insets(0,0,10,0));
	    this.vbxNoOfQuest.setAlignment(Pos.BOTTOM_CENTER);
	    this.vbxNoOfQuest.setSpacing(10);
	    
	    this.lblNoOfQuest = new Label("0");
	    this.pgbNoOfQuest = new VerticalProgressBar(20, 440);
	    this.pgbNoOfQuest.getProgressBar().setProgress(0.0);
	    this.imvNoOfQuest = new ImageView(res.imvNoOfQuestIcon);
	    
	    this.skpPicText = new StackPane();
	    this.skpPicText.setAlignment(Pos.CENTER);
	    this.imvNappy = new ImageView(Utils.getScaledInstance(res.imvNappyImage, 524, 340, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.75, true));
	    this.imvNappy.setFitHeight(524);
	    this.imvNappy.setFitWidth(340);
	    
	    this.lblQuestion = new Label();
	    this.lblQuestion.setId("lblQuestion");
	    this.lblQuestion.setWrapText(true);
	    this.lblQuestion.setTextAlignment(TextAlignment.JUSTIFY);
	    this.lblQuestion.setText("Ist dein Charakter zwischen 20 und 60 Jahre alt?");
	    //this.lblQuestion.setPadding(new Insets(300,110,0,110));
	    //this.lblQuestion.setStyle("-fx-border-color: white;");
	    
	    this.gdpQuestion = new GridPane();
	    //this.gdpQuestion.setPrefSize(524, 340);
	    //this.gdpQuestion.setGridLinesVisible(true);
	    //Set the column-rate:
	    ColumnConstraints gdpQuestionCol1 = new ColumnConstraints();
	    gdpQuestionCol1.setPercentWidth(28);
	    ColumnConstraints gdpQuestionCol2 = new ColumnConstraints();
	    gdpQuestionCol2.setPercentWidth(41);
	    ColumnConstraints gdpQuestionCol3 = new ColumnConstraints();
	    gdpQuestionCol3.setPercentWidth(31);
	    
	    RowConstraints gdpQuestionRow1 = new RowConstraints();
	    gdpQuestionRow1.setPercentHeight(73.5);
	    RowConstraints gdpQuestionRow2 = new RowConstraints();
	    gdpQuestionRow2.setPercentHeight(22.5);
	    RowConstraints gdpQuestionRow3 = new RowConstraints();
	    gdpQuestionRow3.setPercentHeight(4);
	    
	    this.gdpQuestion.getColumnConstraints().addAll(
	    	gdpQuestionCol1,
	    	gdpQuestionCol2,
	    	gdpQuestionCol3
	    );
	    
	    this.gdpQuestion.getRowConstraints().addAll(
	    	gdpQuestionRow1,
	    	gdpQuestionRow2,
	    	gdpQuestionRow3
	    );
	    
	    
	    this.vbxKnowledge = new VBox();
	    this.vbxKnowledge.setPadding(new Insets(0,0,10,0));
	    this.vbxKnowledge.setAlignment(Pos.BOTTOM_CENTER);
	    this.vbxKnowledge.setSpacing(10);
	    
	    this.lblKnowledge = new Label("0%");
	    this.pgbKnowledge = new VerticalProgressBar(20, 440);
	    this.pgbKnowledge.getProgressBar().setProgress(0.0);
	    this.imvKnowledge = new ImageView(res.imvKnowledgeIcon);
	    
	    
		this.gdpButtons = new GridPane();
		this.gdpButtons.setPadding(new Insets(10,10,10,10));
		this.btnYes = new Button();
		//this.btnYes.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/yes.png"))));
		this.btnYes.setPrefSize(Integer.MAX_VALUE, 50);
		this.btnYes.setAlignment(Pos.CENTER);
		this.btnYes.setOnAction(aeh);
		this.btnNo = new Button();
		//this.btnNo.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/no.png"))));
		this.btnNo.setPrefSize(Integer.MAX_VALUE, 50);
		this.btnNo.setAlignment(Pos.CENTER);
		this.btnNo.setOnAction(aeh);
		this.btnIdontKnow = new Button();
		//this.btnIdontKnow.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/dont_know.png"))));
		this.btnIdontKnow.setPrefSize(Integer.MAX_VALUE, 50);
		this.btnIdontKnow.setAlignment(Pos.CENTER);
		this.btnIdontKnow.setOnAction(aeh);
		
	}
	
	//Method that structure (add components to their parent node) the gui-components:
	private void structureComponents() {
		
		//### Structure components of all views ####################################################
		
		//Add items to the game-menu:
		this.mnuGame.getItems().addAll(
			this.mniNewGame,
			this.mniAbortGame,
			this.smiGame1,
			this.mniStatistic,
			this.mniSettings, 
			this.smiGame2,
			this.mniExit
		);
		
		//Add items to the menu:
		this.mnuHelp.getItems().addAll(
			this.mniHelp,
			this.mniWiki,
			this.smiHelp1,
			this.mniInfo
		);
		
		//Add menus to the menu-bar:
		this.mnbMenuBar.getMenus().addAll(
			this.mnuGame,
			this.mnuHelp
		);
		
		//Add menu-bar to the root-pane:
		this.bdpRootPane.setTop(this.mnbMenuBar);
		
		//### Structure start-view-components ######################################################
		
		//Add components to the start-view-pane:
		this.gdpStartViewContentPane.add(this.btnNewGame, 0, 0);
		this.gdpStartViewContentPane.add(this.sepSVCP1, 0, 1);
		this.gdpStartViewContentPane.add(this.btnWiki, 0, 2);
		this.gdpStartViewContentPane.add(this.btnStatistic, 0, 3);
		this.gdpStartViewContentPane.add(this.btnHelp, 0, 4);
		this.gdpStartViewContentPane.setAlignment(Pos.CENTER);
		this.gdpStartViewContentPane.autosize();
		
		//### Structure gamemode1-view-components ##################################################
		
		this.vbxNoOfQuest.getChildren().addAll(
			this.lblNoOfQuest,
			this.pgbNoOfQuest.getProgressHolder(),
			this.imvNoOfQuest
		);
		
		//this.hbxQuestions.getChildren().add(this.lblQusetion);
		this.gdpQuestion.add(this.lblQuestion, 1, 1);
		this.skpPicText.getChildren().addAll(this.imvNappy, this.gdpQuestion);
		//this.skpPicText.getChildren().addAll(this.imvNappy, this.lblQuestion);
		
		this.vbxKnowledge.getChildren().addAll(
				this.lblKnowledge,
				this.pgbKnowledge.getProgressHolder(),
				this.imvKnowledge
			);
		
		this.gdpProgressBarPic.add(this.vbxNoOfQuest, 0, 0);
		this.gdpProgressBarPic.add(this.skpPicText, 1, 0);
		this.gdpProgressBarPic.add(this.vbxKnowledge, 2, 0);
		
		this.gdpButtons.add(this.btnYes, 0, 0);
		this.gdpButtons.add(this.btnNo, 1, 0);
		this.gdpButtons.add(this.btnIdontKnow, 0, 1, 2, 1);
		
	}
	
	//Method that initialize the stage (window) settings:
	private void initStage() {
		
		this.scene = new Scene(this.bdpRootPane, 445, 680);
		this.scene.getStylesheets().add(MainStageView.class.getResource("MainStageCSS.css").toExternalForm());
		this.setScene(this.scene);
		this.setTitle("Nappy, the ingenious");
		
		this.getIcons().addAll(
			new Image(GlobalReferences.ICONS_PATH + "16x16/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "32x32/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "48x48/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "64x64/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "128x128/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "256x256/icon.png")
		);
		this.setResizable(false);
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################