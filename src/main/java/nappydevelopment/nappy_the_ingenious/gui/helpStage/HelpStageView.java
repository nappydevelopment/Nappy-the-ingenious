package nappydevelopment.nappy_the_ingenious.gui.helpStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;

//### IMPORTS ##############################################################################################################################
public class HelpStageView extends Stage {
	
//### ATTRIBUTES ###########################################################################################################################
	
//### COMPONENTS ###########################################################################################################################

	Scene scene;
		
	BorderPane bdpRootPane;
	
    WebView browser;
    
    WebEngine webEngine; 
		
//### CONSTRUCTORS #########################################################################################################################
		
	public HelpStageView(HelpStageResources res, EventHandler<ActionEvent> aeh) {
		this.initComponents(res, aeh);
		this.structureComponents();
		this.initStage(res);
	}
		
//### INITIAL METHODS ######################################################################################################################
		
	//Method that initialize the gui-components:
	private void initComponents(HelpStageResources res, EventHandler<ActionEvent> aeh) {
			
		this.bdpRootPane = new BorderPane();
		
        this.browser = new WebView();
        this.webEngine = browser.getEngine();
        //load the instructions-html-file;
        //webEngine.load(GlobalReferences.HTML_PATH + "instruction_de.html");
	}
		
	//Method that structure (add components to their parent node) the gui-components:
	private void structureComponents() {
		this.bdpRootPane.setCenter(this.browser);
	}
		
	//Method that initialize the stage (window) settings:
	private void initStage(HelpStageResources res) {
			
		this.scene = new Scene(this.bdpRootPane, 700, 700);
		this.setScene(this.scene);
			
		this.getIcons().addAll(res.stageIcon16x16);
		this.setResizable(false);
		
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################