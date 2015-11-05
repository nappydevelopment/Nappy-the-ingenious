package nappydevelopment.nappy_the_ingenious;

import javafx.application.Application;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.gui.MainStage;

//### IMPORTS ##############################################################################################################################
public class GUI extends Application {
	
//### STAGES ###############################################################################################################################
	
	private MainStage mainStage;
	private Controller controller;

//### GETTER / SETTER ######################################################################################################################	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	@Override
	public void start(Stage stage) throws Exception {
		
		this.mainStage = new MainStage();
		stage = this.mainStage;
		stage.show();
	}
	
}
//### EOF ##################################################################################################################################