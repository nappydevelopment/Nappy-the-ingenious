//### Program.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious;

//### IMPORTS ##############################################################################################################################

import java.util.List;
//JavaFX imports:
import javafx.application.Application;
import javafx.stage.Stage;
//Nappy imports:
import nappydevelopment.nappy_the_ingenious.data.*;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;
import nappydevelopment.nappy_the_ingenious.gui.helpStage.HelpStageController;
import nappydevelopment.nappy_the_ingenious.gui.infoStage.InfoStageController;
import nappydevelopment.nappy_the_ingenious.gui.mainStage.MainStageController;
import nappydevelopment.nappy_the_ingenious.gui.settingsStage.SettingsStageController;
import nappydevelopment.nappy_the_ingenious.gui.statisticStage.StatisticStageController;
import nappydevelopment.nappy_the_ingenious.gui.wikiStage.WikiStageController;
import nappydevelopment.nappy_the_ingenious.util.gamemode1.Gamemode1;
import nappydevelopment.nappy_the_ingenious.util.gamemode2.Gamemode2;


public class Program extends Application {

//### PUBLIC CONSTANTS #####################################################################################################################
	
	public static final boolean DEBUG = true;
	
//### ATTRIBUTES ###########################################################################################################################
	
	//Logic:
	private Gamemode1 gm1Logic;
	private Gamemode2 gm2Logic;
	
	//Object that represents the current game:
	private Game game;
	
//### STAGES ###############################################################################################################################
	
	private MainStageController mainStageController;
	private StatisticStageController statisticStageController;
	private SettingsStageController settingsStageController;
	private HelpStageController helpStageController;
	private WikiStageController wikiStageController;
	private InfoStageController infoStageController;
	
//### JAVA-FX-APPLICATION METHODS ##########################################################################################################
	
	//Method that is called before the start-method is called:
	@Override
	public void init() {
		
		//Print status message:
		System.out.println("JavaFX-Application - Init");
		
		//Initialize logic and game:
		this.gm1Logic = null;
		this.gm2Logic = null;
		this.game = null;
		
		//Init the stage-controller:
		this.mainStageController = new MainStageController(this);
		this.statisticStageController = new StatisticStageController(this);
		this.settingsStageController = new SettingsStageController(this);
		this.helpStageController = new HelpStageController(this);
		this.wikiStageController = new WikiStageController(this);
		this.infoStageController = new InfoStageController(this);
		

	}
	
	//Method that starts the JavaFX-Application:
	@Override
	public void start(Stage stage) throws Exception {
		
		//Print status message:
		System.out.println("JavaFX-Application - Start");
		
		//Read out the list with wiki-characters:
		List<WikiCharacter> chars = CharacterProvider.getCharacters();
		
		//Initialize the view of the stages:
		this.mainStageController.initView();
		this.statisticStageController.initView();
		this.settingsStageController.initView();
		this.helpStageController.initView();
		this.wikiStageController.initView(chars);
		this.infoStageController.initView();
		
		//Set the language of the stages to German:
		this.mainStageController.changeLanguageToGerman();
		this.statisticStageController.changeLanguageToGerman();
		this.settingsStageController.changeLanguageToGerman();
		this.helpStageController.changeLanguageToGerman();
		this.wikiStageController.changeLanguageToGerman();
		this.infoStageController.changeLanguageToGerman();
		
		//Print status message:
		System.out.println("JavaFX-Application - Run");
		
		//Show the main-stage-window:
		this.mainStageController.showStartView();
		
	}
	
	//Method that is called when the JavaFX-Application is shutdown:
	@Override
	public void stop() {
		
		//Print status message:
		System.out.println("JavaFX-Application - Stop");
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	//### Methods to show stages ###################################################################
		
	/* showStatisticStage [method]: Method to show the statistic-stage: *//*
	 * 
	 */
	public void showStatisticStage(Stage owner) {
		this.statisticStageController.show(owner);
	}
	
	/* showSettingsStage [method]: Method to show the settings-stage: *//**
	 * 
	 * @param owner
	 */
	public void showSettingsStage(Stage owner) {
		this.settingsStageController.show(owner);
	}
	
	/* showHelpStage [method]: Method to show the help-stage: *//**
	 * 
	 * @param owner
	 */
	public void showHelpStage(Stage owner) {
		this.helpStageController.show(owner);
	}
	
	/* showWikiStage [method]: Method to show the wiki-stage: */
	public void showWikiStage(Stage owner) {
		this.wikiStageController.show(owner);
	}
	
	/* showInfoStage [method]: Method to show the info-stage: */
	public void showInfoStage(Stage owner) {
		this.infoStageController.show(owner);
	}
	
	//### Method to apply settings #################################################################
	
	/* applySettings [method]: Method to apply the settings for all stages *//**
	 * 
	 */
	public void applySettings() {
		
		//Apply the language setting:
		if(Settings.getLanguage() == Language.GERMAN) {
			this.mainStageController.changeLanguageToGerman();
			this.statisticStageController.changeLanguageToGerman();
			this.settingsStageController.changeLanguageToGerman();
			this.helpStageController.changeLanguageToGerman();
			this.wikiStageController.changeLanguageToGerman();
			this.infoStageController.changeLanguageToGerman();
		}
		else {
			this.mainStageController.changeLanguageToEnglish();
			this.statisticStageController.changeLanguageToEnglish();
			this.settingsStageController.changeLanguageToEnglish();
			this.helpStageController.changeLanguageToEnglish();
			this.wikiStageController.changeLanguageToEnglish();
			this.infoStageController.changeLanguageToEnglish();
		}
		
	}
	
	//### Methods for game general control & info ##################################################
	
	/* existsAnActiveGame [method]: Method that tell if an active game exists *//**
	 * 
	 * @return
	 */
	public boolean existsAnActiveGame() {
		
		return this.game.isActive();
	}
	
	/* startGame [method]: Method that starts a Game and initialize the logic *//**
	 * 
	 */
	public void startGame() {
		
		//Initialize the logic:
		this.gm1Logic = new Gamemode1();
		//this.gm2Logic = new Gamemode2(null);
		
		//Set Flag for a started game:
		this.game = new Game();
		this.game.setActive(true);
		this.game.setActiveGamemode(Gamemode.GAMEMODE1);
		
		//Show the gamemode1:
		this.mainStageController.showGamemode1View();
		
		//Show the first Question:
		this.mainStageController.showQuestion(this.gm1Logic.getQuestion(Settings.getLanguage()));
	}
    
	/* finishGameWithoutStatistics [method]: Method to finish a game without writing a statistics entry *//**
	 * 
	 */
	public void finishGameWithoutStatistics() {
		
		//Erase logics:
		this.gm1Logic = null;
		this.gm2Logic = null;
		//Erase game:
		this.game = null;
		//Show start view:
		this.mainStageController.showStartView();
	}

	/* finishGameWithStatistics [method]: Method to finish a game and if necessary write a statistics entry *//**
	 * 
	 */
	public void finishGameWithStatistics() {
		String spielerName = this.mainStageController.showEnterNameDialog();
		if(spielerName != null){
			this.writeStatistics(spielerName);
		}
		this.gm1Logic = null;
		this.gm2Logic = null;
		this.game = null;
		this.mainStageController.showStartView();
	}

	/* writeStatistics [method]: Method that write a statistic entry *//**
	 * 
	 * @param spielerName
	 */
	private void writeStatistics(String spielerName) {
		SaveStatisticInfos.createAndSavePlayer(spielerName, this.game);
	}
    
	/* abortGame [method]: Method to abort a current game */
	public void abortGame() {
		
		this.gm1Logic = null;
		this.gm2Logic = null;
		this.game = null;
		this.mainStageController.showStartView();
	}
	
	//### Methods for gamemode1 ####################################################################
	
	/* setAnswer [method]: Method that sets the answer to the current question *//**
	 * 
	 * @param answer
	 */
	public void setAnswer(Answer answer) {
		
		//### If the gamemode 1 is still active ####################################################
		if(this.game.isGamemode1Finish() == false) {
			
			//Write answer in the logic:
			if(answer == Answer.YES) {
				this.gm1Logic.setAnswer(true);
			}
			else if(answer == Answer.NO) {
				this.gm1Logic.setAnswer(false);
			}
			else if(answer == Answer.DONT_KNOW) {
				this.gm1Logic.setAnswer(null);
			}
		
			//Increase the number of questions that nappy need:
			this.game.increaseNoOfQuestionsNappy();
		
			//Update info elements (Progress-Bars):
			this.mainStageController.updateInfo(this.game.getNoOfQuestionsNappy(),
												this.game.getNoOfQuestionsNappyInPercent(),
												this.gm1Logic.getSureness());
		
			//Check if nappy knows the character:
			if(this.gm1Logic.isSure() == true) {
				this.mainStageController.showGuessedCharacter(this.gm1Logic.getCharacter());
				this.game.setCharacterNappy(this.gm1Logic.getCharacter());
				this.game.setGamemode1Finish(true);
			}
			//Check if nappy is sure but don't knows the character:
			else if (this.gm1Logic.isSure() == null) {
				this.mainStageController.showNappyDontKnow();
				this.game.setGamemode1Finish(true);
			}
			//Ask the next question:
			else if (this.gm1Logic.isSure() == false) {
				this.mainStageController.showQuestion(this.gm1Logic.getQuestion(Settings.getLanguage()));
			}
		}
		//### If the gamemode 1 is finsh ###########################################################
		else {
			
			//If nappy guessed the character right:
			if(answer == Answer.YES) {
				this.game.setNappyRight(true);
			}
			//If nappy was wrong
			else {
				this.game.setNappyRight(false);
			}
			
			//Show status dialog gamemode 1:
			boolean result = this.mainStageController.showStatusDialogGM1(this.game.isNappyRight(),
                             this.game.getNoOfQuestionsNappy(),
                             this.game.getCharacterNappy().getWikiImage(),
                             this.game.getCharacterNappy().getName());
			
			//If Player want to play gamemode 2:
			if(result) {
				//TODO!
			}
			else {
				//Finish game with no statistics:
				this.finishGameWithoutStatistics();
			}
		}
	}
	
	/* finishGamemode1 [method]: Method that finish gamemode1 an set if nappy guess the right character *//**
	 * 
	 * @param isNappyRight
	 */
	public void finishGamemode1(boolean isNappyRight) {
		
	}
	
	//### Methods for gamemode2 ####################################################################
	
	
//### MAIN METHOD ##########################################################################################################################
	
	//Main-method that starts the JavaFX-Platform:
	public static void main(String[] args) {
    	
    	//Start JavaFX-Platform with the JavaFX-Application class gui:
    	Application.launch(args);
    }
  
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################