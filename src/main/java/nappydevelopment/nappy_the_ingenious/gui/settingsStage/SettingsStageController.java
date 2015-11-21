package nappydevelopment.nappy_the_ingenious.gui.settingsStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.settings.ColorScheme;
import nappydevelopment.nappy_the_ingenious.data.settings.GameMode;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;


//### IMPORTS ##############################################################################################################################
public class SettingsStageController {

//### ATTRIBUTES ###########################################################################################################################
	
	private Program program;
	
	private SettingsStageView view;
	private ViewActionEventHandler viewActionEventHandler;

//### CONSTRUCTORS #########################################################################################################################
	
	public SettingsStageController(Program prog) {
		this.program = prog;
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	public void initView() {
		
		//Initialize the action-event-handler for the view-components:
		this.viewActionEventHandler = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new SettingsStageView(this.viewActionEventHandler);
		//Set the bindings to the view-components:
		this.initViewBindings();
		
	}
	
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
		
		this.view.titleProperty().bind(SettingsStageResources.stageTitleText);
		
		this.view.lblLanguage.textProperty().bind(SettingsStageResources.lblLanguageText);
		this.view.rdbGerman.textProperty().bind(SettingsStageResources.rdbGerman);
		this.view.rdbEnglish.textProperty().bind(SettingsStageResources.rdbEnglish);
		this.view.lblColorScheme.textProperty().bind(SettingsStageResources.lblColorScheme);
		this.view.rdbBright.textProperty().bind(SettingsStageResources.rdbBright);
		this.view.rdbDark.textProperty().bind(SettingsStageResources.rdbDark);
		this.view.lblGameMode.textProperty().bind(SettingsStageResources.lblGameMode);
		this.view.rdbBothModes.textProperty().bind(SettingsStageResources.rdbBothModes);
		this.view.rdbOnlyMode1.textProperty().bind(SettingsStageResources.rdbOnlyMode1);
		this.view.btnApply.textProperty().bind(SettingsStageResources.btnApply);
		this.view.btnAbort.textProperty().bind(SettingsStageResources.btnAbort);
	}
	
//### INNER CLASSES ########################################################################################################################
	
	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
			 
		@Override
		public void handle(ActionEvent e) {
		    	  
			Object src = e.getSource();
					
			if(src == view.btnApply) {
				//Apply the taken settings!
				System.out.println("Apply settings");
				SettingsStageController.this.applySettingChanges();
			}
			else if(src == view.btnAbort) {
				//Close stage!
				System.out.println("Abort settings");
				SettingsStageController.this.view.close();
			}
			else {
				System.out.println("Unkwon EventHandler-Source!!!");
			}
			
		}
		 
	}

//### PRIVATE METHODS ######################################################################################################################
	
	private void applySettingChanges() {
		
		if(this.view.rdbGerman.isSelected()) {
			Settings.setLanguage(Language.GERMAN);
		}
		else {
			Settings.setLanguage(Language.ENGLISH);
		}
		
		if(this.view.rdbBright.isSelected()) {
			Settings.setColoScheme(ColorScheme.BRIGHT);
		}
		else {
			Settings.setColoScheme(ColorScheme.DARK);
		}
		
		if(this.view.rdbBothModes.isSelected()) {
			Settings.setGameMode(GameMode.BOTH_MODES);
		}
		else {
			Settings.setGameMode(GameMode.ONLY_MODE1);
		}
		
		//Here you need to read out the changes!
		this.view.close();
		
		this.program.applySettings();
	}
	
	private void loadSettings() {
		
		if(Settings.getLanguage() == Language.GERMAN) {
			this.view.rdbGerman.setSelected(true);
		}
		else {
			this.view.rdbEnglish.setSelected(true);
		}
		
		if(Settings.getColoScheme() == ColorScheme.BRIGHT) {
			this.view.rdbBright.setSelected(true);
		}
		else {
			this.view.rdbDark.setSelected(true);
		}
		
		if(Settings.getGameMode() == GameMode.BOTH_MODES) {
			this.view.rdbBothModes.setSelected(true);
		}
		else {
			this.view.rdbOnlyMode1.setSelected(true);
		}
		
	}
	
//### PUBLIC METHODS ####################################################################################################################### 
	
	public void show(Stage owner) {
		
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
		
		this.loadSettings();
		this.view.show();
	}
	
	public void changeLanguageToGerman() {
		SettingsStageResources.setTextsToGerman();
	}
	
	public void changeLanguageToEnglish() {
		SettingsStageResources.setTextsToEnglish();
	}
	
}
//### EOF ##################################################################################################################################