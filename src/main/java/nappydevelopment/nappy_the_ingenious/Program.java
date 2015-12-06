package nappydevelopment.nappy_the_ingenious;

import java.util.LinkedList;
import java.util.List;

//### IMPORTS ##############################################################################################################################
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.data.Answer;
import nappydevelopment.nappy_the_ingenious.data.CharacterProvider;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;
import nappydevelopment.nappy_the_ingenious.gui.helpStage.HelpStageController;
import nappydevelopment.nappy_the_ingenious.gui.infoStage.InfoStageController;
import nappydevelopment.nappy_the_ingenious.gui.mainStage.MainStageController;
import nappydevelopment.nappy_the_ingenious.gui.settingsStage.SettingsStageController;
import nappydevelopment.nappy_the_ingenious.gui.statisticStage.StatisticStageController;
import nappydevelopment.nappy_the_ingenious.gui.wikiStage.WikiStageController;
import nappydevelopment.nappy_the_ingenious.gui.wikiStage.WikiStageView;
import nappydevelopment.nappy_the_ingenious.util.gamemode1.QuestionGenerator;

public class Program extends Application {

//### ATTRIBUTES ###########################################################################################################################
	
	private QuestionGenerator questGen;
	
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
		
		this.questGen = null;
		
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
		
		List<WikiCharacter> chars = CharacterProvider.getCharacters(Language.GERMAN);
		//List<WikiCharacter> chars = new LinkedList<WikiCharacter>();
		if(chars == null) {
			System.out.println("Null!");
		}
		
		
		//Initialize the view of the stages:
		this.mainStageController.initView();
		this.statisticStageController.initView();
		this.settingsStageController.initView();
		this.helpStageController.initView();
		this.wikiStageController.initView(chars);
		this.infoStageController.initView();
		
		//Set the language of the main stage to English:
		this.mainStageController.changeLanguageToGerman();
		this.statisticStageController.changeLanguageToGerman();
		this.settingsStageController.changeLanguageToGerman();
		this.helpStageController.changeLanguageToGerman();
		this.wikiStageController.changeLanguageToGerman();
		this.infoStageController.changeLanguageToGerman();
		
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
	
	//##############################################################################################
	
	public void startCurrentGame() {
		this.questGen = new QuestionGenerator();
	}
	
	public String getCurrentQuestion() {
		return this.questGen.getQuestion(Settings.getLanguage());
	}
	
	public double getKnowledge() {
		if(this.questGen.isSure()) {
			return 1.0;
		}
		else {
			return 0.2;
		}
	}
	
	public String getCharacter() {
		return this.questGen.getCharacter(Settings.getLanguage()).getName();
	}
	
	public void setCurrentAnswer(Answer answer) {
		
		if(answer == Answer.YES) {
			this.questGen.setAnswer(true);
		}
		else if(answer == Answer.NO) {
			this.questGen.setAnswer(false);
		}
		/*else if(answer == Answer.DONT_KNOW) {
			this.questGen.setAnswer(null);
		}*/
	}
	
	public void abortCurrentGame() {
		this.questGen = null;
		this.mainStageController.showStartView();
	}
	
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
		
//### MAIN METHOD ##########################################################################################################################
	
	//Main-method that starts the JavaFX-Platform:
	public static void main(String[] args) {
    	
    	//Start JavaFX-Platform with the JavaFX-Application class gui:
    	Application.launch(args);
    }
  
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################