//### MainStageView.java #########################################################################################################################

package nappydevelopment.nappyTheIngenious.gui.mainStage;

//### IMPORTS ##############################################################################################################################

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import nappydevelopment.nappyTheIngenious.data.QuestAnsElement;
import nappydevelopment.nappyTheIngenious.gui.components.VerticalProgressBar;

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
    
	//### Content of both Gamemodes ################################################################
	
	GridPane gdpProgressBarPic;

	StackPane skpPicText;
	ImageView imvNappy;

	GridPane gdpQuestion;
	HBox hbxCenterPic;
	Label lblQuestion;
	
	VBox vbxNoOfQuest;
	Label lblNoOfQuest;
	VerticalProgressBar pgbNoOfQuest;
	ImageView imvNoOfQuest;

	VBox vbxKnowledge;
	Label lblKnowledge;
	VerticalProgressBar pgbKnowledge;
	ImageView imvKnowledge;
	
	//### Content of the GameMode1 View ############################################################

	HBox hbxCharacter;
	Rectangle recCharacter;
	ImagePattern impCharacter;

	GridPane gdpButtons;
	VBox vbxInfoLabel;
	Label lblInfo;
	Button btnYes;
	Button btnNo;
	Button btnIdontKnow;

	//### Content of the GameMode2 View ############################################################
    
	Label lblAnswer;               //nc
	ComboBox<QuestAnsElement> cmbQuestions; //nc
	//Button btnIKnowTheCharacter; //handled through the btnIdontKnow!
	HBox hbxAskQuestion;
	Button btnAskQuestion;
	

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

		//Gridpane 
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
	    //this.gdpProgressBarPic.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        
	    //Initialization of the number of questions components: ####################################
	    
	    //Vertikal box for the number of questions label:
	    this.vbxNoOfQuest = new VBox();
	    this.vbxNoOfQuest.setPadding(new Insets(0,0,10,0));
	    this.vbxNoOfQuest.setAlignment(Pos.BOTTOM_CENTER);
	    this.vbxNoOfQuest.setSpacing(10);
        //Label that show the no of questions:
	    this.lblNoOfQuest = new Label("0");
	    //ProgressBar that visualize the number of questions:
	    this.pgbNoOfQuest = new VerticalProgressBar(20, 440);
	    this.pgbNoOfQuest.getProgressBar().setProgress(0.0);
	    this.pgbNoOfQuest.getProgressBar().setStyle("-fx-accent: #A2232C");
	    //ImageView for the number of questions icon:
	    this.imvNoOfQuest = new ImageView(res.imvNoOfQuestIcon);
        
	    //Initialization of the elements in the middle (nappy-pic, question, and character-image) ##
	    
	    this.skpPicText = new StackPane();
	    this.skpPicText.setAlignment(Pos.CENTER);
	    
	    this.imvNappy = new ImageView(res.imvNappyImageGM1);
	    this.imvNappy.setFitHeight(527);
	    this.imvNappy.setFitWidth(340);

	    this.lblQuestion = new Label();
	    this.lblQuestion.setId("lblQuestion");
	    this.lblQuestion.setWrapText(true);
	    this.lblQuestion.setTextAlignment(TextAlignment.JUSTIFY);

	    this.hbxCenterPic = new HBox();
	    this.hbxCenterPic.setAlignment(Pos.CENTER);

	    this.gdpQuestion = new GridPane();
	    this.gdpQuestion.setAlignment(Pos.CENTER);
	    
	    //Set the column-rate:
	    ColumnConstraints gdpQuestionCol1 = new ColumnConstraints();
	    gdpQuestionCol1.setPercentWidth(28);
	    ColumnConstraints gdpQuestionCol2 = new ColumnConstraints();
	    gdpQuestionCol2.setPercentWidth(41);
	    ColumnConstraints gdpQuestionCol3 = new ColumnConstraints();
	    gdpQuestionCol3.setPercentWidth(31);

	    RowConstraints gdpQuestionRow1 = new RowConstraints();
	    gdpQuestionRow1.setPercentHeight(73);
	    RowConstraints gdpQuestionRow2 = new RowConstraints();
	    gdpQuestionRow2.setPercentHeight(23);
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

	    this.hbxCharacter = new HBox();
	    this.hbxCharacter.setId("hbxCharacter");
	    //this.impCharacter = new ImagePattern(null);
    	this.recCharacter = new Rectangle();
		this.recCharacter.setWidth(110);
		this.recCharacter.setHeight(110);
		this.recCharacter.setArcHeight(8);
		this.recCharacter.setArcWidth(8);
		
		//Initialization of the knowledge components: ##############################################
		
	    this.vbxKnowledge = new VBox();
	    this.vbxKnowledge.setPadding(new Insets(0,0,10,0));
	    this.vbxKnowledge.setAlignment(Pos.BOTTOM_CENTER);
	    this.vbxKnowledge.setSpacing(10);

	    this.lblKnowledge = new Label("0%");
	    this.pgbKnowledge = new VerticalProgressBar(20, 440);
	    this.pgbKnowledge.getProgressBar().setProgress(0.0);
	    this.pgbKnowledge.getProgressBar().setStyle("-fx-accent: #A2232C");
	    this.imvKnowledge = new ImageView(res.imvKnowledgeIcon);

	    //Initialization of the button components: #################################################

		this.gdpButtons = new GridPane();
		this.gdpButtons.setPadding(new Insets(10,10,10,10));
		//this.gdpButtons.setGridLinesVisible(true);
		
		this.vbxInfoLabel = new VBox();
		this.vbxInfoLabel.setAlignment(Pos.CENTER);
		this.vbxInfoLabel.setPadding(new Insets(0,0,0,0));
		
		this.lblInfo = new Label("Is this the right character!");
		this.lblInfo.setId("lblIsThisRight");
		this.lblInfo.setTextAlignment(TextAlignment.CENTER);
		this.lblInfo.setWrapText(true);
		this.lblInfo.setPrefHeight(49);
		
		this.btnYes = new Button();
		this.btnYes.setId("btnYes");
		this.btnYes.setPrefSize(Integer.MAX_VALUE, 50);
		this.btnYes.setAlignment(Pos.CENTER);
		this.btnYes.setOnAction(aeh);
		
		this.btnNo = new Button();
		this.btnNo.setId("btnNo");
		this.btnNo.setPrefSize(Integer.MAX_VALUE, 50);
		this.btnNo.setAlignment(Pos.CENTER);
		this.btnNo.setOnAction(aeh);
		
		this.btnIdontKnow = new Button();
		this.btnIdontKnow.setId("btnIdontKnow");
		this.btnIdontKnow.setPrefSize(Integer.MAX_VALUE, 50);
		this.btnIdontKnow.setAlignment(Pos.CENTER);
		this.btnIdontKnow.setOnAction(aeh);
		
        
		// GameMode2 ###############################
		
		//Label that show the answer of Nappy:
		this.lblAnswer = new Label();
		this.lblAnswer.setId("lblAnswer");
		
		//Button to ask the question:
		this.btnAskQuestion = new Button();
		this.hbxAskQuestion = new HBox();
		this.hbxAskQuestion.setAlignment(Pos.CENTER);
		this.btnAskQuestion.setMinSize(150, 10);
		this.btnAskQuestion.setTextAlignment(TextAlignment.CENTER);
		this.btnAskQuestion.setOnAction(aeh);
		
		//The label where the question is shown is implemented through the lblInfo label!
		//The button to guess the character is implemented through the btnIdontKnow!
		
		//### Combobox for questions selection in gamemode2: #######################################
		
		//Combobox for a list of QuestAnsElement objects:
		this.cmbQuestions = new ComboBox<QuestAnsElement>();
		//Width of the combobox and the viewlist is set in the css-file!
		
		/* This definition create a list cell, this list cell object defines what content
		 * is shown in the combobox (not list view) and how this content looks like! */
		ListCell<QuestAnsElement> buttonCell = new ListCell<QuestAnsElement>() {
			
			  @Override protected void updateItem(QuestAnsElement qae, boolean empty) {
				  super.updateItem(qae, empty);
                  
                  if (empty) {
                      setText(null);
                      setGraphic(null);
                  } else {
                      setText(null);
                      if(qae.getAnswer() != "") {
                    	  setText(res.cmbQuestionsTextYouveAskThisQuestionAlready);
                      }
                      else {
                    	  setText(qae.getQuestion());
                      }
                  }
			  }
			};
		
		//Set the configured button cell to the combobox:
		this.cmbQuestions.setButtonCell(buttonCell);
		
		/* This definition create a list view with list cell objects, this list view defines
		 * the list view (drop-down-content) of the combobox. The current list cell object 
		 * defines the current content of the items (entries) in the combobox and how this 
		 * content looks like! */
		this.cmbQuestions.setCellFactory(new Callback<ListView<QuestAnsElement>, ListCell<QuestAnsElement>>() {
			
            @Override
            public ListCell<QuestAnsElement> call(ListView<QuestAnsElement> param) {
                
            	final ListCell<QuestAnsElement> cell = new ListCell<QuestAnsElement>() {
            		
                     @Override
                     public void updateItem(QuestAnsElement qae, boolean empty) {
                    	 
                    	 getListView().setMaxWidth(425);
                    	 super.updateItem(qae, empty);
                             
                         if (empty) {
                             setText(null);
                             setGraphic(null);
                         } else {
                             setText(null);
                             
                         	Label lblQuest = new Label(qae.getQuestion());
                         	lblQuest.setStyle("-fx-text-fill: black;");
                         	Label lblAns   = new Label(qae.getAnswer());
                         	lblAns.setStyle("-fx-text-fill: black;");
                         	setStyle("-fx-background-color: #FFFFFF;");
                         	Image image = new Image(GlobalReferences.CURSORS_PATH + "pointer.png");
                     		setCursor(new ImageCursor(image,10,1));
                         	GridPane grid = new GridPane();
                         	grid.setMaxWidth(425);
                         	grid.setPadding(new Insets(0,5,0,0));
                         	if(qae.getAnswer() != "") {
                         		//grid.setStyle("-fx-background-color: #C0C0C0;");
                         		setStyle("-fx-background-color: #E0E0E0;");
                         		image = new Image(GlobalReferences.CURSORS_PATH + "not-allowed.png");
                         		setCursor(new ImageCursor(image,5,5));
                             	lblQuest.setStyle("-fx-text-fill: #A5A5A5;");
                             	lblAns.setStyle("-fx-text-fill: #A5A5A5;");
                         	}
                         	
                         	//Set the column-rate:
                         	ColumnConstraints col1 = new ColumnConstraints();
                         	col1.setPercentWidth(90);
                         	col1.setHalignment(HPos.LEFT);
                         	ColumnConstraints col2 = new ColumnConstraints();
                         	col2.setPercentWidth(10);
                         	col2.setHalignment(HPos.RIGHT);
                         	grid.getColumnConstraints().addAll(col1, col2);
                         	grid.add(lblQuest, 0, 0);
                         	grid.add(lblAns, 1, 0);
                 		

                         	setGraphic(grid);
                         }
                         
                     }
             };
             return cell;
         }
     });
		
		//Set action listener:
		this.cmbQuestions.setOnAction(aeh);
		
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

		//Add the three number of questions components to the vertical box:
		this.vbxNoOfQuest.getChildren().addAll(
			this.lblNoOfQuest,
			this.pgbNoOfQuest.getProgressHolder(),
			this.imvNoOfQuest
		);
        
		//Add the question label to the positioning grid-pane:
		//this.gdpQuestion.add(this.lblQuestion, 1, 1);
		//MUST BE DONE IN THE CONTROLER BECAUSE THE DEPENDING TO LOGICAL PROCESS-FLOW!!!
		
		//Add the nappy-image and the positioning grid-pane to the stack-pane:
		this.skpPicText.getChildren().addAll(this.imvNappy, this.gdpQuestion);
        
		//Add the three knowledge components to the vertical box:
		this.vbxKnowledge.getChildren().addAll(
				this.lblKnowledge,
				this.pgbKnowledge.getProgressHolder(),
				this.imvKnowledge
			);
        
		//Add the three main elements to the main grid-pane:
		this.gdpProgressBarPic.add(this.vbxNoOfQuest, 0, 0);
		this.gdpProgressBarPic.add(this.skpPicText, 1, 0);
		this.gdpProgressBarPic.add(this.vbxKnowledge, 2, 0);
        
		this.vbxInfoLabel.getChildren().add(this.lblInfo);
		//Add the buttons to the button grid-pane:
		//this.gdpButtons.add(this.btnYes, 0, 0);
		//this.gdpButtons.add(this.btnNo, 1, 0);
		//this.gdpButtons.add(this.btnIdontKnow, 0, 1, 2, 1);
		//MUST BE DONE IN THE CONTROLER BECAUSE THE DEPENDING TO LOGICAL PROCESS-FLOW!!!
		
		
		this.hbxAskQuestion.getChildren().add(this.btnAskQuestion);
		
	}

	//Method that initialize the stage (window) settings:
	private void initStage() {

		//Create scene and set their properties:
		this.scene = new Scene(this.bdpRootPane, 445, 693);	
		this.scene.getStylesheets().add(MainStageView.class.getResource("MainStageCSS.css").toExternalForm());; 
		this.scene.setCursor(new ImageCursor(new Image(GlobalReferences.CURSORS_PATH + "left_ptr.png"), 0, 0));
		
		//Set stage properties:
		this.setScene(this.scene);
		this.setTitle("Nappy, the ingenious");
		this.setResizable(false);
		this.getIcons().addAll(
			new Image(GlobalReferences.ICONS_PATH + "16x16/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "32x32/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "48x48/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "64x64/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "128x128/icon.png"),
			new Image(GlobalReferences.ICONS_PATH + "256x256/icon.png")
		);
		
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################