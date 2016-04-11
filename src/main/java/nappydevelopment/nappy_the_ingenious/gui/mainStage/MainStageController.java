//### MainStageController.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.mainStage;

import java.awt.RenderingHints;
//### IMPORTS ##############################################################################################################################
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.Spieler;
import nappydevelopment.nappy_the_ingenious.util.Utils;
import nappydevelopment.nappy_the_ingenious.util.statistics.TopFiveGenerator;

import java.sql.Statement;

//Class that handles the interactions of the main-stage with the program-logic:
public class MainStageController {
	
//### ATTRIBUTES ###########################################################################################################################
	
	private boolean initialShowing;
	
	private boolean gameIsFinished;
	
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
				
			if(src == view.mniNewGame || src == view.btnNewGame) {
				//Start a new game;
				System.out.println("Start a new game");
				MainStageController.this.showGamemode1View();
			}
			else if(src == view.mniAbortGame) {
				//Abort the current game!
				System.out.println("Abort the current game");
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
				System.out.println("Clicked the Yes-Button");
				MainStageController.this.res.askedQuestions+=1;
				if(MainStageController.this.gameIsFinished) {
					MainStageController.this.program.abortCurrentGame();
				}
				else {
					MainStageController.this.program.setCurrentAnswer(Answer.YES);
					MainStageController.this.showNextQuestion();
				}
			}
			else if(src == view.btnNo) {
				System.out.println("Clicked the No-Button");
				MainStageController.this.res.askedQuestions+=1;
				if(MainStageController.this.gameIsFinished) {
					MainStageController.this.program.abortCurrentGame();
				}
				else {
					MainStageController.this.program.setCurrentAnswer(Answer.NO);
					MainStageController.this.showNextQuestion();
				}
			}
			else if(src == view.btnIdontKnow) {
				System.out.println("Clicked the I don't Know Button");
				MainStageController.this.program.setCurrentAnswer(Answer.DONT_KNOW);
				MainStageController.this.showNextQuestion();
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
		
		//Show dialog and read out the result:
		Optional<ButtonType> result = alert.showAndWait();
		
		//If the user confirm the game abortion:
		if (result.get() == bttApply){
		    this.program.abortCurrentGameWithoutStatistics();
		}
	}
	
	private void showNextQuestion() {
		
		this.view.pgbKnowledge.getProgressBar().setProgress(this.program.getSureness());
		this.view.lblKnowledge.setText("" + (int)(this.program.getSureness() * 100) + "%");
		this.view.pgbNoOfQuest.getProgressBar().setProgress(this.program.getNoOfQuestionsPercent());
		this.view.lblNoOfQuest.setText("" + this.program.getNoOfQuestions());
		
		if(this.program.getIsSure() == Answer.YES) {
			System.out.println(this.program.getCharacter());
			//this.view.lblQuestion.setText(this.res.iThinkItIsText.get() + "\n" + this.program.getCharacter().getName());
			this.view.lblQuestion.setText("");
			this.view.impCharacter = new ImagePattern(Utils.getScaledInstance(this.program.getCharacter().getWikiImage(), 110, 110, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
			this.view.recCharacter.setFill(this.view.impCharacter);
			this.view.hbxCharacter.getChildren().remove(this.view.recCharacter);
			this.view.hbxCharacter.getChildren().add(this.view.recCharacter);
			//this.view.gdpQuestion.getChildren().
			//this.view.gdpQuestion.setGridLinesVisible(true);
			this.view.gdpQuestion.getChildren().remove(this.view.lblQuestion);
			this.view.hbxQuestion.getChildren().remove(this.view.hbxCharacter);
			this.view.hbxQuestion.getChildren().add(this.view.hbxCharacter);
			this.view.gdpQuestion.setAlignment(Pos.CENTER);
			this.view.gdpQuestion.add(this.view.hbxQuestion, 1, 1);
			this.view.btnIdontKnow.setDisable(true);
			this.gameIsFinished = true;
		}
		else if(this.program.getIsSure() == Answer.DONT_KNOW) {
			this.view.lblQuestion.setText(this.res.iDontKnowYourCharacterText.get());
	
			this.view.btnIdontKnow.setDisable(true);
			this.view.btnYes.setDisable(true);
			this.view.btnNo.setDisable(true);
			this.gameIsFinished = true;
		}
		else if (this.program.getIsSure() == Answer.NO){
			this.view.lblQuestion.setText(this.program.getCurrentQuestion());
		}
	
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
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
	
	/* showGamemode1View [method]: *//**
	 * 
	 */
	public void showGamemode1View() {
		
		//Start a new Game:
		this.program.startCurrentGame();
		this.gameIsFinished = false;
		//Enable the "abort game" menu-item:
		this.view.mniAbortGame.setDisable(false);
		//Disable the "new game" menu-item:
		this.view.mniNewGame.setDisable(true);
		this.view.mniSettings.setDisable(true);
		
		this.view.gdpQuestion.getChildren().remove(this.view.hbxQuestion);
		this.view.gdpQuestion.getChildren().remove(this.view.lblQuestion);
		this.view.gdpQuestion.add(this.view.lblQuestion, 1, 1);
		
		//Reset view of old game:
		this.view.btnIdontKnow.setDisable(false);
		this.view.pgbKnowledge.getProgressBar().setProgress(0.0);
		this.view.pgbNoOfQuest.getProgressBar().setProgress(0.0);
		this.view.lblNoOfQuest.setText("0");
		this.view.lblKnowledge.setText("0%");
		this.view.btnYes.setDisable(false);
		this.view.btnNo.setDisable(false);
		//Set the needed panes to the root-pane:
		this.view.bdpRootPane.setTop(this.view.mnbMenuBar);
		this.view.bdpRootPane.setCenter(this.view.gdpProgressBarPic);
		this.view.bdpRootPane.setBottom(this.view.gdpButtons);
		this.view.getScene().setRoot(this.view.bdpRootPane);
		
		this.view.lblQuestion.setText(this.program.getCurrentQuestion());
		//Show the stage:
		this.view.show();
		System.out.println(this.view.gdpQuestion.getWidth());
	}
	
	/* showGamemode2View [method]: *//**
	 * 
	 */
	public void showGamemode2View() {
		
	}

	public MainStageResources getRes(){
		return res;
	}

	public void berechnePunktzahl(){
		/*TODO
		Algo zum Berechnen der Punktzahl hier einfügen
		 */
		Spieler aktuellerSpieler = new Spieler("Günther", 20, 20, 12345);
		boolean won_mode1 = true;
		boolean won_mode2 = false;



		TopFiveGenerator t5g = new TopFiveGenerator();
		ArrayList<Spieler> topPlayers = t5g.getTopFivePlayers();
		topPlayers.add(aktuellerSpieler);

		topPlayers.sort(new Comparator<Spieler>() {
            /* TODO
            * Comparator anhand zu ermittelnder Kriterien erweitern */
            @Override
            public int compare(Spieler spieler1, Spieler spieler2) {
                if(spieler1.getGesamtPunktzahl()<spieler2.getGesamtPunktzahl()){
                    return 0;
                }
                if(spieler1.getGesamtPunktzahl()>spieler2.getGesamtPunktzahl()){
                    return 1;
                }
                return 0;
            }
        });

		topPlayers.remove(topPlayers.lastIndexOf(Spieler.class));

		try{
			Statement st = DatabaseProvider.getStatement();
			st.execute(
					"DROP TABLE IF EXISTS HIGHSCORES; \n" +
							"CREATE TABLE HIGHSCORES( \n" +
							"ID INT PRIMARY KEY, \n" +
							"player_name VARCHAR, \n" +
							"win_mode1 Boolean, \n" +
							"win_mode2 Boolean, \n" +
							"questions_nappy INT, \n" +
							"questions_spieler INT, \n" +
							"score INT );"
							);
			int playerStat = 0;
			for (Spieler player: topPlayers) {
				playerStat +=1;
				st.execute(
						"Insert Into HIGHSCORES value(" +
								playerStat + ", " +
								player.getAnzeigeName() + ", " +
								won_mode1 + ", " +
								won_mode2 + ", " +
								player.getFragen_nappy() + ", " +
								player.getFragen_spieler() + ", " +
								player.getGesamtPunktzahl() + ");"
				);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}


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