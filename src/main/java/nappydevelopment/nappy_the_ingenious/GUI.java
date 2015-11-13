package nappydevelopment.nappy_the_ingenious;

import javafx.application.Application;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.gui.MainStageController;
import nappydevelopment.nappy_the_ingenious.gui.fxml.MainStage;

//### IMPORTS ##############################################################################################################################
public class GUI extends Application {
	
//### STAGES ###############################################################################################################################
	
	private MainStageController mainStageController;
	private Controller controller;

//### GETTER / SETTER ######################################################################################################################	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	
	@Override
	//Method that starts the JavaFX-Application:
	public void start(Stage stage) throws Exception {
		
		//Create a new main-stage-controller:
		this.mainStageController = new MainStageController();
		
		//Initialize the view of the main stage (here as separate step!):
		this.mainStageController.initView();
		
		//Show the main-stage-window:
		this.mainStageController.showStartView();
	}
	
	public void stop() {
		System.out.println("Exit");
	}
	
}
//### EOF ##################################################################################################################################