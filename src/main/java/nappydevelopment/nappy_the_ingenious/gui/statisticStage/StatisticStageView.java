package nappydevelopment.nappy_the_ingenious.gui.statisticStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.gui.components.TitledBorderPane;

//### IMPORTS ##############################################################################################################################
public class StatisticStageView extends Stage {

//### ATTRIBUTES ###########################################################################################################################
	
//### COMPONENTS ###########################################################################################################################

	Scene scene;
	
	BorderPane bdpRootPane;
	
	VBox vbxContent;
	
	TitledBorderPane tbpTopFivePlayer;
	BorderPane bdpTopFivePlayer;
	
	TitledBorderPane tbpTopFiveCharacter;
	BorderPane bdpTopFivePlayerCharacter;
	
	Button btnOk;
	
//### CONSTRUCTORS #########################################################################################################################
	
	public StatisticStageView(StatisticStageResources res, EventHandler<ActionEvent> aeh) {
		this.initComponents(res, aeh);
		this.structureComponents();
		this.initStage(res);
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	//Method that initialize the gui-components:
	private void initComponents(StatisticStageResources res, EventHandler<ActionEvent> aeh) {
		
		this.bdpRootPane = new BorderPane();
		this.vbxContent = new VBox(10);
		
		this.bdpTopFivePlayer = new BorderPane();
		this.tbpTopFivePlayer = new TitledBorderPane("Top Five Player", this.bdpTopFivePlayer);
		
		this.bdpTopFivePlayerCharacter = new BorderPane();
		this.tbpTopFiveCharacter = new TitledBorderPane("Top Five Character", this.bdpTopFivePlayerCharacter);
		
		
		
	}
	
	//Method that structure (add components to their parent node) the gui-components:
	private void structureComponents() {
		
		this.vbxContent.getChildren().addAll(this.tbpTopFivePlayer, this.tbpTopFiveCharacter);
		this.bdpRootPane.setCenter(this.vbxContent);
	}
	
	//Method that initialize the stage (window) settings:
	private void initStage(StatisticStageResources res) {
		
		this.scene = new Scene(this.bdpRootPane, 350, 307);
		this.setScene(this.scene);
		
		this.getIcons().addAll(res.stageIcon16x16);
		
		this.setMinWidth(200);
		this.setMinHeight(200);
		this.setMaxWidth(500);
		this.setMaxHeight(500);
		this.setResizable(true);
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################