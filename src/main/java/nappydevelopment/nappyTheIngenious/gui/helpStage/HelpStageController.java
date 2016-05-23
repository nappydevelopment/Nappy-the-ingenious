package nappydevelopment.nappyTheIngenious.gui.helpStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;


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

	public void applySettings() {
		this.changeColorScheme();
		this.changeLanguage();

		// somewhat both of the above
		// loads instruction_(de|en)_(dark|bright).html
		this.view.webEngine.load(
			HelpStageController.class.getResource(
				"/html/instruction_" +
				Settings.getLanguage().getCode().toLowerCase() +
				"_" +
				Settings.getColoScheme().toString().toLowerCase() +
				".html"
			).toExternalForm()
		);
	}

	private void changeLanguage(){
		switch(Settings.getLanguage()){
			case ENGLISH:
				this.res.changeLanguageToEnglish();
				break;
			case GERMAN:
				this.res.changeLanguageToGerman();
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	private void changeColorScheme(){
		this.view.getScene().getStylesheets().clear();
		if(Settings.getColoScheme() == ColorScheme.DARK) {
			this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
		}
		this.view.getScene().getStylesheets().add(HelpStageView.class.getResource("HelpStageCSS.css").toExternalForm());
	}

		
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################