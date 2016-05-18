package nappydevelopment.nappyTheIngenious.gui.settingsStage;

//### IMPORTS ##############################################################################################################################
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.Program;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.GameMode;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;

/* SettingsStageController [class] *//**
 * 
 * @author Manuel Bothner
 *
 */
public class SettingsStageController {

//### ATTRIBUTES ###########################################################################################################################
	
	private Program program;
	
	protected SettingsStageView view;
	private SettingsStageResources res;
	private ViewActionEventHandler aeh;

//### CONSTRUCTORS #########################################################################################################################
	
	public SettingsStageController(Program prog) {
		this.program = prog;
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	//Initialize the view:
	public void initView() {
		
		//Initialize the resources for the view:
		this.res = new SettingsStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new SettingsStageView(this.res, this.aeh);
		//Set the bindings to the view-components:
		this.initViewBindings();
		
	}
	
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
		
		this.view.titleProperty().bind(this.res.stageTitleText);
		
		this.view.lblLanguage.textProperty().bind(this.res.lblLanguageText);
		this.view.rdbGerman.textProperty().bind(this.res.rdbGerman);
		this.view.rdbEnglish.textProperty().bind(this.res.rdbEnglish);
		this.view.lblColorScheme.textProperty().bind(this.res.lblColorScheme);
		this.view.rdbBright.textProperty().bind(this.res.rdbBright);
		this.view.rdbDark.textProperty().bind(this.res.rdbDark);
		this.view.lblGameMode.textProperty().bind(this.res.lblGameMode);
		this.view.rdbBothModes.textProperty().bind(this.res.rdbBothModes);
		this.view.rdbOnlyMode1.textProperty().bind(this.res.rdbOnlyMode1);
		this.view.btnApply.textProperty().bind(this.res.btnApply);
		this.view.btnAbort.textProperty().bind(this.res.btnAbort);
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

	/* changeThemeToDarkTheme [method]: *//**
	 * 
	 */
	public void changeThemeToDarkTheme() {
		
		this.view.getScene().getStylesheets().clear();
		this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
		this.view.getScene().getStylesheets().add(SettingsStageView.class.getResource("SettingsStageCSS.css").toExternalForm());
	}
	
	/* changeThemeToBrightTheme [method]: *//**
	 * 
	 */
	public void changeThemeToBrightTheme() {
		
		this.view.getScene().getStylesheets().clear();
		//The following command is not really necessary because through the clear Method about the bright (normal) theme is implicit set:
		//this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/BrightTheme.css");
		this.view.getScene().getStylesheets().add(SettingsStageView.class.getResource("SettingsStageCSS.css").toExternalForm());
	}
	
	
	public void changeLanguageToGerman() {
		this.res.setTextsToGerman();
	}
	
	public void changeLanguageToEnglish() {
		this.res.setTextsToEnglish();
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################