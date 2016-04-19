package nappydevelopment.nappy_the_ingenious;

import java.util.List;

//### IMPORTS ##############################################################################################################################
import javafx.application.Application;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.CharacterProvider;
import nappydevelopment.nappy_the_ingenious.data.Game;
import nappydevelopment.nappy_the_ingenious.data.Gamemode;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
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
		
		System.out.println("JavaFX-Application - Init");
		
		//Initialize Logic and Game:
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
		
		System.out.println("JavaFX-Application - Start");
		
		//Read out the list with wiki-characters:
		List<WikiCharacter> chars = CharacterProvider.getCharacters(Language.GERMAN);
		
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
		
		System.out.println("JavaFX-Application - Run");
		
		//Show the main-stage-window:
		this.mainStageController.showStartView();
		
	}
	
	//Method that is called when the JavaFX-Application is shutdown:
	@Override
	public void stop() {
		System.out.println("JavaFX-Application - Stop");
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	//### Show stages ##############################################################################
	
	public void showStatisticStage(Stage owner) {
		this.statisticStageController.show(owner);
	}
	
	public void showSettingsStage(Stage owner) {
		this.settingsStageController.show(owner);
	}
	
	public void showHelpStage(Stage owner) {
		this.helpStageController.show(owner);
	}
	
	public void showWikiStage(Stage owner) {
		this.wikiStageController.show(owner);
	}
	
	public void showInfoStage(Stage owner) {
		this.infoStageController.show(owner);
	}
	
	//### Apply settings ###########################################################################
	
	public void applySettings() {
		
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
	
	/* startCurrentGame [method]: Method that starts a Game and initialize the logic *//**
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
    
	public void setAnswer(Answer answer) {
		
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
		this.mainStageController.updateInfo(this.game.getNoOfQuestionsNappyInPercent(),
                                            this.gm1Logic.getSureness());
		
		//Check if nappy knows the character:
		if(this.gm1Logic.isSure() == true) {
			this.mainStageController.showGuessedCharacter(this.gm1Logic.getCharacter(Settings.getLanguage()));			                                    
		}
		//Ask the next question:
		else if (this.gm1Logic.isSure() == false) {
			this.mainStageController.showQuestion(this.gm1Logic.getQuestion(Settings.getLanguage()));
		}
		else if (this.gm1Logic.isSure() == null) {
			this.mainStageController.showNappyDontKnow();
		}
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

		/* TODO
		Punkteberechnung hier, Datenbankspeicherung hier
		Refactoring !!!!
		 */
		this.mainStageController.initSave();

		this.gm1Logic = null;
		this.gm2Logic = null;
		this.game = null;
		this.mainStageController.showStartView();
	}
	
	/* abortGame [method]: Method to abort a current game *//**
	 * 
	 */
	public void abortGame() {
		
		this.gm1Logic = null;
		this.gm2Logic = null;
		this.game = null;
		this.mainStageController.showStartView();
	}
	
	//### Methods for gamemode1 ####################################################################
	
	public String getCurrentQuestion() {
		//this.noOfQuestions += 0.05;
		return this.gm1Logic.getQuestion(Settings.getLanguage());
	}
	
	public void setCurrentAnswer(Answer answer) {
		

	}
	
	public Answer getIsSure() {
		
		if(this.gm1Logic.isSure() == null) {
			return Answer.DONT_KNOW;
		}
		else if (this.gm1Logic.isSure() == false) {
			return Answer.NO;
		}
		else {
			return Answer.YES;
		}
	}

	public double getSureness() {
		return this.gm1Logic.getSureness();
	}

	public WikiCharacter getCharacter() {
		System.out.println(this.gm1Logic.getCharacter(Language.GERMAN));
		return this.gm1Logic.getCharacter(Settings.getLanguage());
	}

	public int getNoOfQuestions() {
		return this.game.getNoOfQuestionsNappy();
	}
	
	public float getNoOfQuestionsPercent() {
		return ((float)this.game.getNoOfQuestionsNappy() * 0.05F);
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