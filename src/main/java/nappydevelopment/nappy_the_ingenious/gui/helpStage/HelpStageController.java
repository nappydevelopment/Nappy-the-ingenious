package nappydevelopment.nappy_the_ingenious.gui.helpStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;


//### IMPORTS ##############################################################################################################################
public class HelpStageController {

//### ATTRIBUTES ###########################################################################################################################
	
	private Language curLang;
	
	private Program program;
		
	private HelpStageView view;
	private HelpStageResources res;
	private ViewActionEventHandler aeh;
		
//### CONSTRUCTORS #########################################################################################################################
		
	public HelpStageController(Program prog) {
		this.program = prog;
		this.curLang = null;
	}
		
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
				
		}
			
	}
		
//### PUBLIC METHODS #######################################################################################################################
		
	public void show(Stage owner) {
			
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
		
		if(this.curLang == Language.GERMAN) {
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_de.html");
		}
		else if(this.curLang == Language.ENGLISH) {
			System.out.println("English");
			this.view.webEngine.load(GlobalReferences.HTML_PATH + "instruction_en.html");
		}
		
		this.view.show();
	}
		
	public void changeLanguageToGerman() {
		this.curLang = Language.GERMAN;
		this.res.setTextsToGerman();
	}
		
	public void changeLanguageToEnglish() {
		this.curLang = Language.ENGLISH;
		this.res.setTextsToEnglish();	
	}
		
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################