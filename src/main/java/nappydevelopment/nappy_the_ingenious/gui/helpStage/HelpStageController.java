package nappydevelopment.nappy_the_ingenious.gui.helpStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.settings.ColorScheme;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;
import nappydevelopment.nappy_the_ingenious.gui.mainStage.MainStageView;


//### IMPORTS ##############################################################################################################################
public class HelpStageController {

//### ATTRIBUTES ###########################################################################################################################
		
	private HelpStageView view;
	private HelpStageResources res;
	private ViewActionEventHandler aeh;
		
//### CONSTRUCTORS #########################################################################################################################
		
	public HelpStageController() {}
		
//### INITIAL METHODS ######################################################################################################################
		
	//Initialize the view:
	public void initView() {
			
		//Initialize the resources for the view:
		this.res = new HelpStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new HelpStageView(this.res, this.aeh);
		//Set the bindings to the view-components:
		this.initViewBindings();
			
	}
		
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
				
		this.view.titleProperty().bind(this.res.stageTitleText);
				
	}
		
		
//### INNER CLASSES ########################################################################################################################

	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
						 
		@Override
		public void handle(ActionEvent e) {
			//Nothing to do here
		}
			
	}
		
//### PUBLIC METHODS #######################################################################################################################
		
	public void show(Stage owner) {
			
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
		
		this.view.show();
	}
		
	/* changeThemeToDarkTheme [method]: *//**
	 * 
	 */
	public void changeThemeToDarkTheme() {
		
		this.view.getScene().getStylesheets().clear();
		this.view.getScene().getStylesheets().add("/nappydevelopment/nappy_the_ingenious/gui/globalStyle/DarkTheme.css");
		this.view.getScene().getStylesheets().add(HelpStageView.class.getResource("HelpStageCSS.css").toExternalForm());
		
		if(Settings.getLanguage() == Language.GERMAN) {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_de_dark.html");
		}
		else {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_en_dark.html");
		}
		
	}
	
	/* changeThemeToBrightTheme [method]: *//**
	 * 
	 */
	public void changeThemeToBrightTheme() {
		
		this.view.getScene().getStylesheets().clear();
		//The following command is not really necessary because through the clear Method about the bright (normal) theme is implicit set:
		//this.view.getScene().getStylesheets().add("/nappydevelopment/nappy_the_ingenious/gui/globalStyle/BrightTheme.css");
		this.view.getScene().getStylesheets().add(HelpStageView.class.getResource("HelpStageCSS.css").toExternalForm());
		
		if(Settings.getLanguage() == Language.GERMAN) {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_de_dark.html");
		}
		else {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_en_dark.html");
		}
		
	}
	
	
	public void changeLanguageToGerman() {
		
		this.res.setTextsToGerman();
		
		if(Settings.getColoScheme() == ColorScheme.BRIGHT) {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_de_bright.html");
		}
		else {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_de_dark.html");
		}
	}
		
	public void changeLanguageToEnglish() {
		
		this.res.setTextsToEnglish();
		
		if(Settings.getColoScheme() == ColorScheme.BRIGHT) {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_en_bright.html");
		}
		else {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_en_dark.html");
		}
		
	}
		
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################