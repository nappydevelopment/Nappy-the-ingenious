//### MainStageController.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui;

//### IMPORTS ##############################################################################################################################

public class MainStageController {
	
//### ATTRIBUTES ###########################################################################################################################
	
	//Class that represents the main-stage-view:
	private MainStageView view;
	
	
	//Default Constructor:
	public MainStageController() {
		
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	//Method that initialize the MainStage-View:
	public void initView() {
		this.view = new MainStageView();
	}
	
	
	
	
	private void initViewBindings() {
		
	}
	
	private void initEventHandlers() {
		
	}
	
	
//### PUBLIC METHODS #######################################################################################################################
	
	
	public void showStartView() {
		this.view.showStartView();
	}
	
	public void showGamemode1View() {
		
	}
	
	public void showGamemode2View() {
		
	}
	
}
//### EOF ##################################################################################################################################