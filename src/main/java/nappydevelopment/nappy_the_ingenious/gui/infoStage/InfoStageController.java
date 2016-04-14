package nappydevelopment.nappy_the_ingenious.gui.infoStage;
//### IMPORTS ##############################################################################################################################

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.settings.Language;

public class InfoStageController {
	
	
	//Reference to the program-logic:
	private Program program;
	
	//Class that represents the main-stage-view:
	private InfoStageView view;
	private InfoStageResources res;
	private ViewActionEventHandler aeh;
	
//### CONSTRUCTORS #########################################################################################################################
	
	//Default Constructor:
	public InfoStageController(Program prog) {
		
		//Set reference to program-logic:
		this.program = prog;
		
	}

//### INITIAL METHODS ######################################################################################################################
	
	//Initialize the view:
	public void initView() {
			
		//Initialize the resources for the view:
		this.res = new InfoStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new InfoStageView(this.res, this.aeh);
		//Set the bindings to the view-components:
		this.initViewBindings();
			
	}
		
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
		
		this.view.titleProperty().bind(this.res.stageTitleText);
		
		this.view.lblTitle.textProperty().bind(this.res.lblTitleText);
		this.view.lblDescription.textProperty().bind(this.res.lblDescriptionText);
		this.view.lblDevelopedBy.textProperty().bind(this.res.lblDevelopedByText);
		this.view.lblName1.textProperty().bind(this.res.lblName1Text);
		this.view.lblName2.textProperty().bind(this.res.lblName2Text);
		this.view.lblName3.textProperty().bind(this.res.lblName3Text);
		this.view.lblName4.textProperty().bind(this.res.lblName4Text);
		this.view.lblNappyDevelopment.textProperty().bind(this.res.lblNappyDevelopmentText);
		this.view.lblBlog.textProperty().bind(this.res.lblBlogText);
		this.view.lblEmail.textProperty().bind(this.res.lblEmailText);
		
	}
		
//### INNER CLASSES ########################################################################################################################
	
	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
			 
		@Override
		public void handle(ActionEvent e) {
			
			Object src = e.getSource();
			
			if(src == InfoStageController.this.view.lblBlog) {
				System.out.println("Open Blog in Browser");
			}
			else if(src == InfoStageController.this.view.lblEmail) {
				System.out.println("Open e-mail program");
			}
		}
		
	}

//### PUBLIC METHODS #######################################################################################################################
	
	/* show [method]: Method that shows the info-stage *//**
	 * 
	 */
	public void show(Stage owner) {
		
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
		
		this.view.show();
	}
	
	/* changeLanguageToGerman [method]: *//**
	 * 
	 */
	public void changeLanguageToGerman() {
		
		this.res.setTextsToGerman();
	}
	
	/* changeLanguageToEnglish [method]: *//**
	 * 
	 */
	public void changeLanguageToEnglish() {
		this.res.setTextsToEnglish();
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################