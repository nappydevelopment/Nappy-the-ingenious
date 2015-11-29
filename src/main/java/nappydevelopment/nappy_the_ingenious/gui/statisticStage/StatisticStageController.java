package nappydevelopment.nappy_the_ingenious.gui.statisticStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Program;

//### IMPORTS ##############################################################################################################################
public class StatisticStageController {

//### ATTRIBUTES ###########################################################################################################################
	
	private Program program;
	
	private StatisticStageView view;
	private StatisticStageResources res;
	private ViewActionEventHandler aeh;
	
//### CONSTRUCTORS #########################################################################################################################
	
	public StatisticStageController(Program prog) {
		this.program = prog;
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	//Initialize the view:
	public void initView() {
		
		//Initialize the resources for the view:
		this.res = new StatisticStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new StatisticStageView(this.res, this.aeh);
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
		
		this.view.show();
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