//### MainStageController.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.mainStage;


//### IMPORTS ##############################################################################################################################
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.Character;
import nappydevelopment.nappy_the_ingenious.data.settings.ColorScheme;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;
import nappydevelopment.nappy_the_ingenious.util.Utils;

import java.awt.*;
import java.util.List;
import java.util.Optional;


//Class that handles the interactions of the main-stage with the program-logic:
public class MainStageController {
	
//### ATTRIBUTES ###########################################################################################################################
	
	private boolean initialShowing;
	
	//Reference to the program-logic:
	private Program program;
	
	//Class that represents the main-stage-view:
	private MainStageView view;
	private MainStageResources res;
	private ViewActionEventHandler aeh;
	
//### CONSTRUCTORS #########################################################################################################################
	
	//Default Constructor:
	public MainStageController(Program prog) {
		
		//Init the flag for the initial showing:
		this.initialShowing = false;
		
		//Set reference to program-logic:
		this.program = prog;
		
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	/* initView [method]: *//**
	 * 
	 */
	public void initView() {
		
		//Initialize the resources for the view:
		this.res = new MainStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new MainStageView(this.res, this.aeh);
		//Set the bindings to the view-components:
		this.initViewBindings();
		
	}
	
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
		
		//Menu-Texts:
		this.view.mnuGame.textProperty().bind(this.res.mnuGameText);
		this.view.mniNewGame.textProperty().bind(this.res.mniNewGameText);
		this.view.mniAbortGame.textProperty().bind(this.res.mniAbortGameText);
		this.view.mniStatistic.textProperty().bind(this.res.mniStatisticText);
		this.view.mniSettings.textProperty().bind(this.res.mniSettingsText);
		this.view.mniExit.textProperty().bind(this.res.mniExitText);
		this.view.mnuHelp.textProperty().bind(this.res.mnuHelpText);
		this.view.mniHelp.textProperty().bind(this.res.mniHelpText);
		this.view.mniWiki.textProperty().bind(this.res.mniWikiText);
		this.view.mniInfo.textProperty().bind(this.res.mniInfoText);
		
		//Button-Texts:
		this.view.btnNewGame.textProperty().bind(this.res.btnNewGameText);
		this.view.btnWiki.textProperty().bind(this.res.btnWikiText);
		this.view.btnStatistic.textProperty().bind(this.res.btnStatisticText);
		this.view.btnHelp.textProperty().bind(this.res.btnHelpText);
		
		this.view.btnYes.textProperty().bind(this.res.btnYesText);
		this.view.btnNo.textProperty().bind(this.res.btnNoText);
		this.view.btnIdontKnow.textProperty().bind(this.res.btnIdontKnow);
		
		//Stage-Properties:
		this.view.titleProperty().bind(this.res.stageTitleText);
	}

//### EVENT HANDLER ########################################################################################################################
	
	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
		 
		@Override
		public void handle(ActionEvent e) {
	    	  
			Object src = e.getSource();
		
			//Start a new game:
			if(src == view.mniNewGame || src == view.btnNewGame) {
				
				//Print status message:
				if(Program.DEBUG) { System.out.println("Start a new game"); }
				//Call program method to start a new game:
				MainStageController.this.program.startGame();
			}
			//Abort the current game:
			else if(src == view.mniAbortGame) {
				
				//Print status message:
				System.out.println("Abort the current game");
				//Show the Dialog to confirm the abortion:
				MainStageController.this.showAbortGameDialog();
			}
			else if(src == view.mniStatistic || src == view.btnStatistic) {
				//Show the statistic-stage!
				System.out.println("Show the statistic stage");
				MainStageController.this.program.showStatisticStage(MainStageController.this.view);
			}
			else if(src == view.mniSettings) {
				//Show the settings-stage!
				System.out.println("Show the settings stage");
				//Call the function in the program-logic to show the settings-stage:
				MainStageController.this.program.showSettingsStage(MainStageController.this.view);
			}
			else if(src == view.mniExit) {
				//Exit the JavaFX-Application!
				System.out.println("Exit game");
				Platform.exit();
			}
			else if (src == view.mniHelp || src == view.btnHelp) {
				//Show the help-stage!
				System.out.println("Show the help stage");
				MainStageController.this.program.showHelpStage(MainStageController.this.view);
			}
			else if(src == view.mniWiki || src == view.btnWiki) {
				//Show the wiki-stage!
				System.out.println("Show the wiki stage");
				MainStageController.this.program.showWikiStage(MainStageController.this.view);
			}
			else if(src == view.mniInfo) {
				//Show the info-stage!
				System.out.println("Show the info stage");
				MainStageController.this.program.showInfoStage(MainStageController.this.view);
			}
			else if(src == view.btnYes) {
				
				//Act the button as yes button for questions:
				if("btnYes".equals(((Button)src).getId())) {
					MainStageController.this.program.setQuestionAnswer(Answer.YES);
				}
				//Acts the button as right button for the guessed character:
				else if("btnRight".equals(((Button)src).getId())) {
					MainStageController.this.program.setIfNappyIsRight(Answer.YES);
				}
			}
			else if(src == view.btnNo) {
				
				//Act the button as yes button for questions:
				if("btnNo".equals(((Button)src).getId())) {
					MainStageController.this.program.setQuestionAnswer(Answer.NO);
				}
				//Acts the button as right button for the guessed character:
				else if("btnWrong".equals(((Button)src).getId())) {
					MainStageController.this.program.setIfNappyIsRight(Answer.NO);
				}
					
			}
			else if(src == view.btnIdontKnow) {
		
				if("btnIdontKnow".equals(((Button)src).getId())) {
					MainStageController.this.program.setQuestionAnswer(Answer.DONT_KNOW);
				}
				else if("btnContinue".equals(((Button)src).getId())) {
					MainStageController.this.program.setIfNappyIsRight(Answer.DONT_KNOW);
				}
				
			}
			else if(src == view.btnAskQuestion) {
				
				MainStageController.this.program.askQuestion(MainStageController.this.view.cmbQuestions.getValue());
			}
			else if(src == view.cmbQuestions) {
				//Adopt the question from the combobox to the label:
				MainStageController.this.adoptQuestion();
			}
			else {
				System.out.println("Unkwon EventHandler-Source!!!");
			}
			
		}
		
	}
	
//### PRIVATE METHODS ######################################################################################################################
	
	//Method that creates a Dialog where the user must confirm the game abortion:
	private void showAbortGameDialog() {
		
		//Create dialog:
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		
		
		//Create the dialog buttons:
		ButtonType bttApply = new ButtonType(this.res.abortGameDialogBtnApplyText);
		ButtonType bttCancel = new ButtonType(this.res.abortGameDialogBtnCancelText);
		
		//Set properties of the dialog:
		alert.setTitle(this.res.abortGameDialogTitle);
		alert.setHeaderText(this.res.abortGameDialogHeaderText);
		alert.setContentText(this.res.abortGameDialogContentText);
		alert.getButtonTypes().setAll(bttApply, bttCancel);
		
		if(Settings.getColoScheme() == ColorScheme.DARK) {
			alert.getDialogPane().getStylesheets().clear();
			alert.getDialogPane().getStylesheets().add("/nappydevelopment/nappy_the_ingenious/gui/globalStyle/DarkTheme.css");
		}
		
		//Show dialog and read out the result:
		Optional<ButtonType> result = alert.showAndWait();
		
		//If the user confirm the game abortion:
		if (result.get() == bttApply){
		    this.program.abortGame();;
		}
	}
	
	
   
    
    /* updateInfo [method]: Method to update the progress elements (progress-bars / -labels) *//**
     * 
     * @param noq
     * @param noqInPercent
     * @param surness
     */
	public void updateInfo(int noq, float noqInPercent, float surness) {
		
		this.view.pgbKnowledge.getProgressBar().setProgress(surness);
		this.view.lblKnowledge.setText("" + (int)(surness * 100) + "%");
		this.view.pgbNoOfQuest.getProgressBar().setProgress(noqInPercent);
		this.view.lblNoOfQuest.setText("" + noq);
	}
	

//### PUBLIC METHODS #######################################################################################################################
	
	//### Methods to show the start view ###########################################################
	
	/* showStartView [method]: *//**
	 * 	
	 */
	public void showStartView() {
		
		//If the main-stage shown for the first time:
		if(!this.initialShowing) {
			
			/*************************************************
			 * This Code adds all views and gui-components   *
			 * to a stack-pane (some visible some invisible) *
			 * this stack-pane is set as root-pane of the    *
			 * stage! This is necessary because apart from   *
			 * that it's not possible to read out the size   *
			 * of components that are not on the start-view  *
			 * and get shown later on the stage!             * 
			 *************************************************/
			
			StackPane skpRoot = new StackPane();
			
			BorderPane bdpRootPane1 = new BorderPane();
			BorderPane bdpRootPane2 = new BorderPane();
			
			bdpRootPane1.setTop(this.view.mnbMenuBar);
			bdpRootPane1.setCenter(this.view.gdpStartViewContentPane);
			
			bdpRootPane2.setCenter(this.view.gdpProgressBarPic);
			bdpRootPane2.setBottom(this.view.gdpButtons);
			
			skpRoot.getChildren().addAll(bdpRootPane2, bdpRootPane1);
			skpRoot.getChildren().get(0).setVisible(false);
			
			this.view.getScene().setRoot(skpRoot);
			
			this.initialShowing = true;
		}
		else {
			
			//Set the start-view-pane to the root-pane:
			this.view.bdpRootPane.setTop(this.view.mnbMenuBar);
			this.view.bdpRootPane.setCenter(this.view.gdpStartViewContentPane);
			this.view.bdpRootPane.setBottom(null);
			this.view.getScene().setRoot(this.view.bdpRootPane);
		}
		
		//Disable the "abort game" menu-item:
		this.view.mniAbortGame.setDisable(true);
		//Disable the "new game" menu-item:
		this.view.mniNewGame.setDisable(false);
		this.view.mniSettings.setDisable(false);
		this.view.mniStatistic.setDisable(false);
		this.view.btnStatistic.setDisable(false);
		
		//Show the stage:
		this.view.show();
		
	}
	
	//### Methods for gamemode 1 ###################################################################
	
	/* showGamemode1View [method]: *//**
	 * 
	 */
	public void showGamemode1View() {

		//Reset Button id's
		this.view.btnNo.setId("btnNo");
		this.view.btnYes.setId("btnYes");
		
		//Enable the "abort game" menu-item:
		this.view.mniAbortGame.setDisable(false);
		//Disable the "new game" menu-item:
		this.view.mniNewGame.setDisable(true);
		this.view.mniSettings.setDisable(true);
		
		//Eventually remove the character picture:
		this.view.gdpQuestion.getChildren().clear();;
		//Add the question lable to the positioning-grid:
		this.view.gdpQuestion.add(this.view.lblQuestion, 1, 1);
		
		//Reset view of old game:
		this.view.pgbKnowledge.getProgressBar().setProgress(0.0);
		this.view.pgbNoOfQuest.getProgressBar().setProgress(0.0);
		this.view.lblNoOfQuest.setText("0");
		this.view.lblKnowledge.setText("0%");	
		this.view.btnYes.setDisable(false);
		this.view.btnYes.setId("btnYes");
		this.view.btnNo.setDisable(false);
		this.view.btnNo.setId("btnNo");
		this.view.btnIdontKnow.setDisable(false);
		this.view.btnIdontKnow.setId("btnIdontKnow");
		
		this.res.setBtnYesTextToYes();
		this.res.setBtnNoTextToNo();
		this.res.setBtnIdontKnowTextToIdontKnow();
		
		this.view.gdpButtons.getChildren().clear();
		
		//Add the buttons to the button grid-pane:
		this.view.gdpButtons.add(this.view.btnYes, 0, 0);
		this.view.gdpButtons.add(this.view.btnNo, 1, 0);
		this.view.gdpButtons.add(this.view.btnIdontKnow, 0, 1, 2, 1);
		
		//Set the needed panes to the root-pane:
		this.view.bdpRootPane.setTop(this.view.mnbMenuBar);
		this.view.bdpRootPane.setCenter(this.view.gdpProgressBarPic);
		this.view.bdpRootPane.setBottom(this.view.gdpButtons);
		
		//Set the root-pane as root-pane of the scene:
		this.view.getScene().setRoot(this.view.bdpRootPane);
		
		System.out.println("Size: " + this.view.gdpProgressBarPic.getHeight() + ", " + this.view.gdpProgressBarPic.getWidth());
	}
	
	//Method that shows the next question:
	public void showQuestion(String question) {
		
		this.view.lblQuestion.setText(question);
	}
	
	//Method that shows the character that nappy guessed:
	public void showGuessedCharacter(Character character) {
		
		//Show info label with the guessed character name:
		this.view.lblInfo.setText(this.res.lblInfoTextIKnowYourCharacter + " " + character.getName() + "!");
		
		//Clear text of the question label:
		this.view.lblQuestion.setText("");
		this.res.setBtnYesTextToRight();
		this.res.setBtnNoTextToWrong();
        
		//Get the picture of the guessed character:
		this.view.impCharacter = new ImagePattern(Utils.getScaledInstance(character.getWikiImage(),
				                                                          110,
				                                                          110, 
				                                                          RenderingHints.VALUE_INTERPOLATION_BICUBIC,
				                                                          0.80,
				                                                          true));
		this.view.recCharacter.setFill(this.view.impCharacter);
		
		//Remove eventually the old picture and add the (new) picture:
		this.view.hbxCharacter.getChildren().remove(this.view.recCharacter);
		this.view.hbxCharacter.getChildren().add(this.view.recCharacter);
		
		//Remove eventually the old picture and add the picture to the question box:
		this.view.hbxCenterPic.getChildren().remove(this.view.hbxCharacter);
		this.view.hbxCenterPic.getChildren().add(this.view.hbxCharacter);
		
		//Remove the question label from the positioning grid-pane:
		this.view.gdpQuestion.getChildren().remove(this.view.lblQuestion);
		//Add the horizontal box with the picture to the positioning grid-pane:
		this.view.gdpQuestion.add(this.view.hbxCenterPic, 1, 1);
		
		//### Change the buttons grid pane #########################################################
		
		//Clear the grid pane:
		this.view.gdpButtons.getChildren().clear();
		
		//Set the new ids for the buttons that acts now in a other context:
		this.view.btnYes.setId("btnRight");
		this.view.btnNo.setId("btnWrong");
		
		//Add the buttons and the info label to the button grid-pane:
		this.view.gdpButtons.add(this.view.vbxInfoLabel, 0, 0, 2, 1);
		this.view.gdpButtons.add(this.view.btnYes, 0, 1);
		this.view.gdpButtons.add(this.view.btnNo, 1, 1);

		
	}
    
	/* showNappyDontKnowView [method]: */
	public void showNappyDontKnow() {
		
		this.view.lblInfo.setText(this.res.lblInfoTextIDontKnowYourCharacterText);
		
		//Clear text of the question label:
		this.view.lblQuestion.setText("");
		this.view.btnIdontKnow.setId("btnContinue");
		this.res.setBtnIdontKnowTextToContinue();
		
		this.view.btnYes.setDisable(true);
		this.view.btnNo.setDisable(true);
		
		//Get the picture of a questionmark:
		Image img = new Image(GlobalReferences.IMAGES_PATH + "general/questionmark.png");
		
		this.view.impCharacter = new ImagePattern(Utils.getScaledInstance(img, 110, 110, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
		this.view.recCharacter.setFill(this.view.impCharacter);
		
		//Remove eventually the old picture and add the (new) picture:
		this.view.hbxCharacter.getChildren().remove(this.view.recCharacter);
		this.view.hbxCharacter.getChildren().add(this.view.recCharacter);
		
		//Remove eventually the old picture and add the picture to the question box:
		this.view.hbxCenterPic.getChildren().remove(this.view.hbxCharacter);
		this.view.hbxCenterPic.getChildren().add(this.view.hbxCharacter);
		
		//Remove the question label from the positioning grid-pane:
		this.view.gdpQuestion.getChildren().remove(this.view.lblQuestion);
		//Add the horizontal box with the picture to the positioning grid-pane:
		this.view.gdpQuestion.add(this.view.hbxCenterPic, 1, 1);
		
		this.view.gdpButtons.getChildren().clear();
		
		//Add the buttons to the button grid-pane:
		this.view.gdpButtons.add(this.view.vbxInfoLabel, 0, 0, 2, 1);
		this.view.gdpButtons.add(this.view.btnIdontKnow, 0, 1, 2, 1);
		
	}
	
	
	public boolean showStatusDialogGM1(boolean askForMode2, Answer isNappyRight, int noOfQuestions, Image imgCharacter, String nameCharacter) {
	    	
			//Create the dialog buttons:
			ButtonType bttApply = new ButtonType(this.res.statusDialogGM1BtnApplyText);
			ButtonType bttCancel = new ButtonType(this.res.statusDialogGM1BtnCancelText);
			ButtonType bttOk = new ButtonType(this.res.statusDialogGM1BtnOkText);
	    	
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	
	    	if(isNappyRight == Answer.YES) {
	    	
	    		alert.setHeaderText(this.res.statusDialogGM1StatusTextRight1 + 
	    			            	nameCharacter + 
	    			            	this.res.statusDialogGM1StatusTextRight2 +
	    			            	"\n" +
	    			            	this.res.statusDialogGM1StatusTextRight3 +
	    			            	noOfQuestions + 
	    			            	this.res.statusDialogGM1StatusTextRight4);
	    		
			    HBox hbxCharacter = new HBox();
			    hbxCharacter.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 5, 0, 0, 0);" +
			                          "-fx-padding: 5;" +
			                          "-fx-background-color: #FFD90F;" +
			                          "-fx-background-radius: 5;");
			    ImagePattern impCharacter = new ImagePattern(Utils.getScaledInstance(imgCharacter, 110, 110, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
			    
		    	Rectangle recCharacter = new Rectangle();
				recCharacter.setWidth(110);
				recCharacter.setHeight(110);
				recCharacter.setArcHeight(8);
				recCharacter.setArcWidth(8);
				recCharacter.setFill(impCharacter);
				
				hbxCharacter.getChildren().add(recCharacter);
	    		
	    		alert.setGraphic(hbxCharacter);
	    	}
	    	else {
	    		
	    		alert.setHeaderText(this.res.statusDialogGM1StatusTextWrong);
	    		alert.setGraphic(new Group());
	    	}
	    	
			if(Settings.getColoScheme() == ColorScheme.DARK) {
				alert.getDialogPane().getStylesheets().clear();
				alert.getDialogPane().getStylesheets().add("/nappydevelopment/nappy_the_ingenious/gui/globalStyle/DarkTheme.css");
			}
			
	    	alert.setTitle(this.res.statusDialogGM1Title);
	    	
	    	
	    	if(askForMode2 == true) {
	    		alert.getButtonTypes().setAll(bttApply, bttCancel);
	    		alert.setContentText(this.res.statusDialogGM1Question);
	    	}
	    	else {
	    		alert.getButtonTypes().setAll(bttOk);
	    	}
	    	
	    	Optional<ButtonType> result = alert.showAndWait();
	    	
	    	if (result.get() == bttApply){
	    	    return true;
	    	} else {
	    	    return false;
	    	}
	    }
	    
	
	//### Methods for gamemode 2 ###################################################################
	
	/* showGamemode2View [method]: *//**
	 * 
	 */
	public void showGamemode2View() {
		
		//Reset progress-bars:
		this.view.pgbKnowledge.getProgressBar().setPrefSize(380, 20);
		this.view.pgbKnowledge.getProgressBar().setProgress(0.0);
		this.view.pgbNoOfQuest.getProgressBar().setPrefSize(380, 20);
		this.view.pgbNoOfQuest.getProgressBar().setProgress(0.0);
		//Reset the progress-labels:
		this.view.lblNoOfQuest.setText("0");
		this.view.lblKnowledge.setText("0%");
		
		
		this.view.gdpProgressBarPic.getChildren().clear();
		
		this.view.imvNappy.setImage(this.res.imvNappyImageGM2);
	    this.view.imvNappy.setFitHeight(401);
	    this.view.imvNappy.setFitWidth(340);
	    
		//Add the nappy-image and the positioning grid-pane to the stack-pane:
		this.view.skpPicText.getChildren().clear();
		
		this.view.gdpQuestion.getChildren().clear();
		this.view.gdpQuestion.getColumnConstraints().clear();
		this.view.gdpQuestion.getRowConstraints().clear();
		
	    //Set the column-rate:
	    ColumnConstraints gdpQuestionCol1 = new ColumnConstraints();
	    gdpQuestionCol1.setPercentWidth(11);
	    ColumnConstraints gdpQuestionCol2 = new ColumnConstraints();
	    gdpQuestionCol2.setPercentWidth(40);
	    ColumnConstraints gdpQuestionCol3 = new ColumnConstraints();
	    gdpQuestionCol3.setPercentWidth(49);

	    RowConstraints gdpQuestionRow1 = new RowConstraints();
	    gdpQuestionRow1.setPercentHeight(16.2);
	    RowConstraints gdpQuestionRow2 = new RowConstraints();
	    gdpQuestionRow2.setPercentHeight(20);
	    RowConstraints gdpQuestionRow3 = new RowConstraints();
	    gdpQuestionRow3.setPercentHeight(63.8);

	    this.view.gdpQuestion.getColumnConstraints().addAll(
	    	gdpQuestionCol1,
	    	gdpQuestionCol2,
	    	gdpQuestionCol3
	    );

	    this.view.gdpQuestion.getRowConstraints().addAll(
	    	gdpQuestionRow1,
	    	gdpQuestionRow2,
	    	gdpQuestionRow3
	    );
		
	    this.view.gdpQuestion.add(this.view.lblAnswer, 1,1);
	    this.view.skpPicText.getChildren().addAll(this.view.imvNappy, this.view.gdpQuestion);
		
		//Add the three main elements to the main grid-pane:
		this.view.gdpProgressBarPic.add(this.view.vbxNoOfQuest, 0, 0);
		this.view.gdpProgressBarPic.add(this.view.skpPicText, 1, 0);
		this.view.gdpProgressBarPic.add(this.view.vbxKnowledge, 2, 0);
		this.view.gdpProgressBarPic.setPadding(new Insets(10,10,0,10));
		
		this.view.gdpButtons.getChildren().clear();
		this.view.gdpButtons.setVgap(10);
		this.view.gdpButtons.setPadding(new Insets(0,10,10,10));
		
		
		this.view.btnIdontKnow.setId("btnIknow");
		this.res.setBtnIdontKnowTextToIknow();
		
		this.view.gdpButtons.add(this.view.vbxInfoLabel, 0, 0);
		this.view.gdpButtons.add(this.view.cmbQuestions, 0, 1);
		this.view.gdpButtons.add(this.view.hbxAskQuestion, 0, 2);
		this.view.gdpButtons.add(this.view.btnIdontKnow, 0, 4);
		//this.view.gdpButtons.setGridLinesVisible(true);
		//this.view.gdpProgressBarPic.setGridLinesVisible(true);
		
		this.view.bdpRootPane.getChildren().clear();
		this.view.bdpRootPane.setBottom(this.view.gdpButtons);
		this.view.bdpRootPane.setTop(this.view.mnbMenuBar);
		this.view.bdpRootPane.setCenter(this.view.gdpProgressBarPic);
		
	}

	/* showAnswer [method]: Method to show the answer form Nappy to a question *//**
	 * 
	 * @param answer
	 */
	public void showAnswer(String answer) {
		this.view.lblAnswer.setText(answer);
	}
	
	/* showQuestions [method]: Method to set the questions in the combobox *//**
	 * 
	 * @param questions
	 */
	public void showQuestions(Boolean isTheFirstQuestion, List<String> questions) {	
		
		this.view.cmbQuestions.getItems().clear();
		this.view.cmbQuestions.getItems().addAll(questions);
		
		if(isTheFirstQuestion) {
			System.out.println("Is the first question!");
			this.view.cmbQuestions.setValue(this.res.cmbQuestionsTextSelectAQuestion);
			this.view.lblInfo.setText(this.res.lblInfoTextPleaseSelectAQuestion);
		}
		else {
			this.view.cmbQuestions.setValue(this.res.cmbQuestionsTextSelectNextQuestion);
		}

		this.view.btnAskQuestion.setDisable(true);
	}
	
	/* adoptQuestion [method]: Method that shows the selected question of the combobox in the label *//**
	 * 
	 */
	private void adoptQuestion() {
		
		if(this.view.cmbQuestions.getItems().isEmpty()) {
			return;
		}
		if(this.view.cmbQuestions.getValue() != this.res.cmbQuestionsTextSelectAQuestion &&
		   this.view.cmbQuestions.getValue() != this.res.cmbQuestionsTextSelectNextQuestion) {
			
		   this.view.lblInfo.setText(this.view.cmbQuestions.getValue());
		   this.view.lblAnswer.setText("");
		   this.view.btnAskQuestion.setDisable(false);
		}
		else {
			this.view.cmbQuestions.setValue(this.res.cmbQuestionsTextSelectNextQuestion);
			this.view.btnAskQuestion.setDisable(true);
		}
	}
	
	

	public String showEnterNameDialog() {

		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle(this.res.enterNameDialogTitle);
		dialog.setHeaderText(this.res.enterNameDialogHeaderText);
		dialog.setContentText(this.res.enterNameDialogContentText);

		//Set properties of the dialog:
		//alert.getButtonTypes().setAll(bttApply, bttCancel);

		if(Settings.getColoScheme() == ColorScheme.DARK) {
			dialog.getDialogPane().getStylesheets().clear();
			dialog.getDialogPane().getStylesheets().add("/nappydevelopment/nappy_the_ingenious/gui/globalStyle/DarkTheme.css");
		}
		
        // Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		
		if (result.isPresent()){
			System.out.println("Your name: " + result.get());
			return result.get();
		}
		return null;
	}

	
	/* changeThemeToDarkTheme [method]: *//**
	 * 
	 */
	public void changeThemeToDarkTheme() {
		
		this.view.getScene().getStylesheets().clear();
		this.view.getScene().getStylesheets().add("/nappydevelopment/nappy_the_ingenious/gui/globalStyle/DarkTheme.css");
		this.view.getScene().getStylesheets().add(MainStageView.class.getResource("MainStageCSS.css").toExternalForm());
	}
	
	/* changeThemeToBrightTheme [method]: *//**
	 * 
	 */
	public void changeThemeToBrightTheme() {
		
		this.view.getScene().getStylesheets().clear();
		//The following command is not really necessary because through the clear Method about the bright (normal) theme is implicit set:
		//this.view.getScene().getStylesheets().add("/nappydevelopment/nappy_the_ingenious/gui/globalStyle/BrightTheme.css");
		this.view.getScene().getStylesheets().add(MainStageView.class.getResource("MainStageCSS.css").toExternalForm());
	}
	
	/* changeLanguageToGerman [method]: *//**
	 * 
	 */
	public void changeLanguageToGerman() {
		this.res.setTextsToGerman();
	}
	
	/* changeLanguageToEnglish [method]: *//**
	 * 
	 */
	public void changeLanguageToEnglish() {
		this.res.setTextsToEnglish();
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################