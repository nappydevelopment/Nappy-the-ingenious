//### Program.java #########################################################################################################################

package nappydevelopment.nappyTheIngenious;

//### IMPORTS ##############################################################################################################################

//JavaFX imports:
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
//Nappy imports:
import nappydevelopment.nappyTheIngenious.data.*;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import nappydevelopment.nappyTheIngenious.exception.*;
import nappydevelopment.nappyTheIngenious.gamemodes.gamemode1.GameMode1;
import nappydevelopment.nappyTheIngenious.gamemodes.gamemode2.GameMode2;
import nappydevelopment.nappyTheIngenious.gui.helpStage.HelpStageController;
import nappydevelopment.nappyTheIngenious.gui.infoStage.InfoStageController;
import nappydevelopment.nappyTheIngenious.gui.mainStage.MainStageController;
import nappydevelopment.nappyTheIngenious.gui.settingsStage.SettingsStageController;
import nappydevelopment.nappyTheIngenious.gui.statisticStage.StatisticStageController;
import nappydevelopment.nappyTheIngenious.gui.wikiStage.WikiStageController;

import java.util.List;
import java.util.ListIterator;



public class Program extends Application {

//### PUBLIC CONSTANTS #####################################################################################################################
	
	public static final boolean DEBUG = true;
	
//### ATTRIBUTES ###########################################################################################################################
	
	//Logic:
	private GameMode1 gm1Logic;
	private GameMode2 gm2Logic;
	
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
		this.helpStageController = new HelpStageController();
		this.wikiStageController = new WikiStageController(this);
		this.infoStageController = new InfoStageController(this);
		

	}
	
	//Method that starts the JavaFX-Application:
	@Override
	public void start(Stage primarystage) throws Exception {
		
		//Print status message:
		System.out.println("JavaFX-Application - Start");
		
		//Read out the list with wiki-characters:
		List<Character> chars = CharacterProvider.getCharacters();
		
		//Initialize the view of the stages:
		this.mainStageController.initView(primarystage);
		this.statisticStageController.initView();
		this.settingsStageController.initView();
		this.helpStageController.initView();
		this.wikiStageController.initView(chars);
		this.infoStageController.initView();

		this.applySettings();

		//Print status message:
		System.out.println("JavaFX-Application - Run");

		//Show the main-stage-window:
		this.mainStageController.showStartView();
	}
	
	//Method that is called when the JavaFX-Application is shutdown:
	@Override
	public void stop() {

		try{
			Settings.saveToDatabase();
		}catch(CouldNotSaveToDatabase couldNotSaveToDatabase){
			couldNotSaveToDatabase.printStackTrace();
		}

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
		
		//Apply the language/ColorScheme settings:
        //TODO: add custom exception to the other controller's
		this.mainStageController.applySettings();
		this.statisticStageController.applySettings();
		this.settingsStageController.applySettings();
		this.helpStageController.applySettings();
		this.wikiStageController.applySettings();
		this.infoStageController.applySettings();
	}
	
	//### Methods for game general control & info ##################################################
	
	/* startGame [method]: Method that starts a Game and initialize the logic *//**
	 * 
	 */
	public void startGame() {
		
		//Initialize the logic:
		this.gm1Logic = new GameMode1(Settings.getLanguage());
		//TODO: No consistently logic interface:
		this.gm2Logic = new GameMode2(Settings.getLanguage());
		
		//Initialize a new game:
		this.game = new Game();
		
		//Call method to start gamemode1:
        this.startGamemode1();
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
	public void finishGameWithStatistics(boolean restart) {
		
		//Show dialog to enter the player name:
		String spielerName = this.mainStageController.showEnterNameDialog();
		
		//If the player entered a name:
		if(spielerName != null) {
			//Write the player into statistic:
			this.writeStatistics(spielerName);
		}
		
		//Erase logics:
		this.gm1Logic = null;
		this.gm2Logic = null;
		//Erase game:
		this.game = null;
		
		//Show start view:
		if(restart) {
			this.startGame();;
		}
		else {
			this.mainStageController.showStartView();
		}
		
	}

	public boolean existAnActiveGame() {
		return (this.game != null);
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
		
		//Erase logic:
		this.gm1Logic = null;
		this.gm2Logic = null;
		//Erase game:
		this.game = null;
		
		//Show start view:
		this.mainStageController.showStartView();
	}
	
	//### Methods for gamemode1 ####################################################################
	
	/* startGamemode1 [method]: Method that starts gamemode1 *//**
	 * 
	 */
	private void startGamemode1() {
		
		//Show the gamemode1:
		this.mainStageController.showGamemode1View();
		
		//Show the first Question:
		try{
			this.mainStageController.showQuestion(this.gm1Logic.getQuestion());
		}catch(NoMoreQuestions|GameHasFinished e){
			e.printStackTrace();
		}
	}
	
	/* setQuestionAnswer [method]: Method that sets the answer to the current question *//**
	 * 
	 * @param answer
	 */
	public void setQuestionAnswer(Answer answer){

		try{
			//Write answer in the logic:
			this.gm1Logic.setAnswer(answer);

			if(this.gm1Logic.getNumDunno() >= 4) {
				this.mainStageController.blockIdontKnow();
			}

			//Increase the number of questions that nappy needed:
			this.game.increaseNoOfQuestionsNappy();

			//Update info elements (Progress-Bars):
			this.mainStageController.updateInfoGM1(
				this.game.getNoOfQuestionsNappy(),
				this.game.getNoOfQuestionsNappyInPercent(),
				this.gm1Logic.getSureness()
			);

			switch(this.gm1Logic.isSure()){
				case SURE:
					//nappy knows the character:
					Character chr = this.gm1Logic.endGame();
					this.mainStageController.showGuessedCharacter(chr);
					this.game.setCharacterNappy(chr);
					break;
				case DONTKNOW:
					//nappy is sure that he doesn't know the character:
					this.mainStageController.showNappyDontKnow();
					break;
				case UNSURE:
					//Ask the next question:
					this.mainStageController.showQuestion(this.gm1Logic.getQuestion());
					break;
				default:
					throw new IllegalArgumentException("");
			}
		}catch(NoActiveQuestion|CantFinishGameMode|NoMoreQuestions|GameHasFinished e){
			e.printStackTrace();
		}
		
	}
	
	/* setIfNappyIsRight [method]: Method that set if nappy guess the right character *//**
	 * 
	 * @param isNappyRight
	 */
	public void setIfNappyIsRight(Answer isNappyRight) {
		
		//Set if nappy guessed the character right or not:
		this.game.setNappyRight(isNappyRight);
		
		//finish the gamemode1:
        this.finishGamemode1();
	}
	
	/* finishGamemode1 [method]: Method that show the status dialog of gamemode1 and start gamemode2 or finish the game */
	private void finishGamemode1() {
		
		boolean playGM2;
		
		//If Nappy could not guess the character (not the same as Nappy guess the worng character):
		if(game.isNappyRight() == Answer.DONT_KNOW) {
			//Show status dialog gamemode1:
			playGM2 = this.mainStageController.showStatusDialogGM1(
					         	  Settings.getGameMode().askForGamemode2(),
					         	  this.game.isNappyRight(),
					         	  this.game.getNoOfQuestionsNappy(),
					         	  null,
					         	  null);
		}
		else {
			//Show status dialog gamemode1:
			playGM2 = this.mainStageController.showStatusDialogGM1(
					         	  Settings.getGameMode().askForGamemode2(),
					         	  this.game.isNappyRight(),
					         	  this.game.getNoOfQuestionsNappy(),
					         	  this.game.getCharacterNappy().getWikiImage(),
					         	  this.game.getCharacterNappy().getName());
		}

		//Add the played Character into the statistics
		if(this.game.isNappyRight() == Answer.YES) {
			SaveStatisticInfos.createAndSaveCharakter(this.game.getCharacterNappy());
		}

		//If Player want to play gamemode2:
		if(playGM2) {
			//Start gamemode2:
			this.startGamemode2();
		}
		else {
			//Finish game with no statistics:
			this.finishGameWithoutStatistics();
		}
		
	}
	
	//### Methods for gamemode2 ####################################################################
	
	private void startGamemode2() {
		
		this.game.setGamemode2Active(true);
		
		//Read out the questions that the player can ask:
		//TODO: Not really nice logic should return a list of questions (Strings) depending on a language parameter:
		try{
			List<String> questions = gm2Logic.getQuestions();

			//Generate a list iterator:
			ListIterator<String> listIterator = questions.listIterator();

			//Run through the list:
			while (listIterator.hasNext()) {

				//Read out current element:
				String question = listIterator.next();

				this.game.getQal().add(new QuestAnsElement(question));
			}
		}catch(GameHasFinished gameHasFinished){
			gameHasFinished.printStackTrace();
		}
		
		
		this.mainStageController.showGamemode2View();
		this.mainStageController.updateInfoGM2(0, 0.0F, this.game.getNoOfQuestionsNappy(), this.game.getNoOfQuestionsNappyInPercent());
		this.mainStageController.showQuestions(true, this.game.getQal());
	}
	
	public void askQuestion(String question) {
		
		try {
			
			this.game.increasNoOfQuestionsPlayer();
			
			this.mainStageController.updateInfoGM2(
					this.game.getNoOfQuestionsPlayer(),
					this.game.getNoOfQuestionsPlayerInPercent(),
					this.game.getNoOfQuestionsNappy(),
					this.game.getNoOfQuestionsNappyInPercent()
				);
			
			Answer answer = this.gm2Logic.askQuestion(question);
			this.mainStageController.showAnswer(answer.getText());
			this.game.getQal().setAnswer(question, answer);
			//Read out the new list of questions:
			//List<String> questions = gm2Logic.getQuestions();
			//Show the new list:
			this.mainStageController.showQuestions(false, this.game.getQal());
			
			
		} catch(InvalidQuestion|GameHasFinished e){
			e.printStackTrace();
		}
	}

	public void setQuestionFilter(String filter) {
		//Show the new list:
		System.out.println("METHOD setQuestionFilter - filter: " + filter);
		QuestAnsList a = this.game.getQal().filter(filter);
		System.out.println(a.size());
		boolean firstQuestion = (this.game.getNoOfQuestionsPlayer() == 0);
		this.mainStageController.showQuestions(firstQuestion, this.game.getQal().filter(filter));
	}
	
	public void showCharacterSelection(Stage owner) {
		this.wikiStageController.showForSelection(owner);
	}
	
	public void setSelectedCharacter(Character character) {
		
		if(this.game != null && this.game.isGamemode2Active()) {
			System.out.println(character.getName());
			if(this.wikiStageController.showConfirmSelectionDialog(character)) {
				this.wikiStageController.closeView();
				this.game.setCharacterPlayer(character);
				try {
					this.game.setPlayerRight(this.gm2Logic.makeGuess(character));
					Character nappysChar = this.gm2Logic.endGame();
					this.mainStageController.showStatusDialogGM2(this.game.isPlayerRight(), this.game.getNoOfQuestionsPlayer(), character, nappysChar);
				} catch (GameHasFinished e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void showGameResultView() {
		this.mainStageController.showGameResultView(
				this.game.getCharacterNappy(), 
				this.game.isNappyRightBoolean(), 
				this.game.getNoOfQuestionsNappy(), 
				this.game.getCharacterPlayer(), 
				this.game.isPlayerRight(),
				this.game.getNoOfQuestionsPlayer(),
				this.game.isWinPlayer());
	}
	
//### MAIN METHOD ##########################################################################################################################
	
	//Main-method that starts the JavaFX-Platform:
	public static void main(String[] args) {
    	//Start JavaFX-Platform with the JavaFX-Application class gui:
    	Application.launch(args);
    }
  
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################