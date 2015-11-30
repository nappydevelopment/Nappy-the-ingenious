package nappydevelopment.nappy_the_ingenious.gui.wikiStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//### IMPORTS ##############################################################################################################################
public class WikiStageView extends Stage {
	
//### ATTRIBUTES ###########################################################################################################################
		
//### COMPONENTS ###########################################################################################################################

	Scene scene;
			
	BorderPane bdpRootPane;
			
//### CONSTRUCTORS #########################################################################################################################
			
	public WikiStageView(WikiStageResources res, EventHandler<ActionEvent> aeh) {
		this.initComponents(res, aeh);
		this.structureComponents();
		this.initStage(res);
	}
			
//### INITIAL METHODS ######################################################################################################################
			
	//Method that initialize the gui-components:
	private void initComponents(WikiStageResources res, EventHandler<ActionEvent> aeh) {
				
		this.bdpRootPane = new BorderPane();
	}
			
	//Method that structure (add components to their parent node) the gui-components:
	private void structureComponents() {
				
	}
			
	//Method that initialize the stage (window) settings:
	private void initStage(WikiStageResources res) {
				
		this.scene = new Scene(this.bdpRootPane, 350, 307);
		this.setScene(this.scene);
				
		this.getIcons().addAll(res.stageIcon16x16, res.stageIcon32x32);
				
		
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################