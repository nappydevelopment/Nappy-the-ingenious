package nappydevelopment.nappy_the_ingenious;

//### IMPORTS ##############################################################################################################################
import javafx.application.Application;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;
import nappydevelopment.nappy_the_ingenious.gui.mainStage.MainStageController;
import nappydevelopment.nappy_the_ingenious.gui.settingsStage.SettingsStageController;
import nappydevelopment.nappy_the_ingenious.gui.settingsStage.SettingsStageResources;

public class Program extends Application {
	
//### STAGES ###############################################################################################################################
	
	private MainStageController mainStageController;
	private SettingsStageController settingsStageController;
	
//### JAVA-FX-APPLICATION METHODS ##########################################################################################################
	
	//Method that is called before the start-method is called:
	@Override
	public void init() {
		System.out.println("JavaFX-Application - Init");
		
		//Init the stage-controller:
		this.mainStageController = new MainStageController(this);
		this.settingsStageController = new SettingsStageController(this);

	}
	
	//Method that starts the JavaFX-Application:
	@Override
	public void start(Stage stage) throws Exception {
		
		//Initialize the view of the stages:
		this.mainStageController.initView();
		this.settingsStageController.initView();
		//Set the language of the main stage to English:
		this.mainStageController.changeLanguageToGerman();
		SettingsStageResources.setTextsToGerman();
		
		
		//Show the main-stage-window:
		this.mainStageController.showStartView();
	}
	
	//Method that is called when the JavaFX-Application is shutdown:
	@Override
	public void stop() {
		System.out.println("JavaFX-Application - Stop");
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	public void showSettingsStage(Stage owner) {
		this.settingsStageController.show(owner);
	}
	
	public void abortCurrentGame() {
		this.mainStageController.showStartView();
	}
	
	public void applySettings() {
		
		if(Settings.getLanguage() == Language.GERMAN) {
			this.mainStageController.changeLanguageToGerman();
			this.settingsStageController.changeLanguageToGerman();
		}
		else {
			this.mainStageController.changeLanguageToEnglish();
			this.settingsStageController.changeLanguageToEnglish();
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