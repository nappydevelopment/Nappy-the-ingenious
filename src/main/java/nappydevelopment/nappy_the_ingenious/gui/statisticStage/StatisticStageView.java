package nappydevelopment.nappy_the_ingenious.gui.statisticStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	GridPane gdpTopFivePlayer;
	Label lblP1Position;
	Label lblP1Name;
	Label lblP1Value;
	Label lblP2Position;
	Label lblP2Name;
	Label lblP2Value;
	Label lblP3Position;
	Label lblP3Name;
	Label lblP3Value;
	Label lblP4Position;
	Label lblP4Name;
	Label lblP4Value;
	Label lblP5Position;
	Label lblP5Name;
	Label lblP5Value;
	
	TitledBorderPane tbpTopFiveCharacter;
	GridPane gdpTopFiveCharacter;
	Label lblC1Position;
	Label lblC1Name;
	Label lblC1Counter;
	Label lblC2Position;
	Label lblC2Name;
	Label lblC2Counter;
	Label lblC3Position;
	Label lblC3Name;
	Label lblC3Counter;
	Label lblC4Position;
	Label lblC4Name;
	Label lblC4Counter;
	Label lblC5Position;
	Label lblC5Name;
	Label lblC5Counter;
	
	HBox hbxOkButton;
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
		this.bdpRootPane.setPadding(new Insets(20, 20, 20, 20));
		this.vbxContent = new VBox(20);
		
		this.tbpTopFivePlayer = new TitledBorderPane();
		this.gdpTopFivePlayer = new GridPane();
		this.gdpTopFivePlayer.setVgap(8);
		this.lblP1Position = new Label();
		this.lblP1Name = new Label();
		this.lblP1Value = new Label();
		this.lblP2Position = new Label();
		this.lblP2Name = new Label();
		this.lblP2Value = new Label();
		this.lblP3Position = new Label();
		this.lblP3Name = new Label();
		this.lblP3Value = new Label();
		this.lblP4Position = new Label();
		this.lblP4Name = new Label();
		this.lblP4Value = new Label();
		this.lblP5Position = new Label();
		this.lblP5Name = new Label();
		this.lblP5Value = new Label();
		
		this.gdpTopFiveCharacter = new GridPane();
		this.tbpTopFiveCharacter = new TitledBorderPane();
		this.gdpTopFiveCharacter = new GridPane();
		this.gdpTopFiveCharacter.setVgap(8);
		
		this.lblC1Position = new Label();
		this.lblC1Name = new Label();
		this.lblC1Counter = new Label();
		
		this.lblC2Position = new Label();
		this.lblC2Name = new Label();
		this.lblC2Counter = new Label();
		
		this.lblC3Position = new Label();
		this.lblC3Name = new Label();
		this.lblC3Counter = new Label();
		
		this.lblC4Position = new Label();
		this.lblC4Name = new Label();
		this.lblC4Counter = new Label();
		
		this.lblC5Position = new Label();
		this.lblC5Name = new Label();
		this.lblC5Counter = new Label();
		
		this.hbxOkButton = new HBox();
		this.hbxOkButton.setAlignment(Pos.CENTER_RIGHT);
		
		this.btnOk = new Button();
		this.btnOk.setPrefWidth(80);
		this.btnOk.setOnAction(aeh);
	}
	
	//Method that structure (add components to their parent node) the gui-components:
	private void structureComponents() {
		
	    ColumnConstraints col1 = new ColumnConstraints();
	    ColumnConstraints col2 = new ColumnConstraints();
	    ColumnConstraints col3 = new ColumnConstraints();
	    
	    col1.setPercentWidth(15);
	    col1.setHalignment(HPos.LEFT);
	    col2.setPercentWidth(70);
	    col3.setPercentWidth(15);
	    col3.setHalignment(HPos.RIGHT);
	    
	    this.gdpTopFivePlayer.getColumnConstraints().clear();
	    this.gdpTopFivePlayer.getColumnConstraints().addAll(col1, col2, col3);
	    
		this.gdpTopFivePlayer.add(this.lblP1Position, 0, 0);
		this.gdpTopFivePlayer.add(this.lblP1Name, 1, 0);
		this.gdpTopFivePlayer.add(this.lblP1Value, 2, 0);
		this.gdpTopFivePlayer.add(this.lblP2Position, 0, 1);
		this.gdpTopFivePlayer.add(this.lblP2Name, 1, 1);
		this.gdpTopFivePlayer.add(this.lblP2Value, 2, 1);
		this.gdpTopFivePlayer.add(this.lblP3Position, 0, 2);
		this.gdpTopFivePlayer.add(this.lblP3Name, 1, 2);
		this.gdpTopFivePlayer.add(this.lblP3Value, 2, 2);
		this.gdpTopFivePlayer.add(this.lblP4Position, 0, 3);
		this.gdpTopFivePlayer.add(this.lblP4Name, 1, 3);
		this.gdpTopFivePlayer.add(this.lblP4Value, 2, 3);
		this.gdpTopFivePlayer.add(this.lblP5Position, 0, 4);
		this.gdpTopFivePlayer.add(this.lblP5Name, 1, 4);
		this.gdpTopFivePlayer.add(this.lblP5Value, 2, 4);
		
		this.tbpTopFivePlayer.setContent(this.gdpTopFivePlayer);
		
	    this.gdpTopFiveCharacter.getColumnConstraints().clear();
	    this.gdpTopFiveCharacter.getColumnConstraints().addAll(col1, col2, col3);
		
	    this.gdpTopFiveCharacter.add(this.lblC1Position, 0, 0);
	    this.gdpTopFiveCharacter.add(this.lblC1Name, 1, 0);
	    this.gdpTopFiveCharacter.add(this.lblC1Counter, 2, 0);
	    this.gdpTopFiveCharacter.add(this.lblC2Position, 0, 1);
	    this.gdpTopFiveCharacter.add(this.lblC2Name, 1, 1);
	    this.gdpTopFiveCharacter.add(this.lblC2Counter, 2, 1);
	    this.gdpTopFiveCharacter.add(this.lblC3Position, 0, 2);
	    this.gdpTopFiveCharacter.add(this.lblC3Name, 1, 2);
	    this.gdpTopFiveCharacter.add(this.lblC3Counter, 2, 2);
	    this.gdpTopFiveCharacter.add(this.lblC4Position, 0, 3);
	    this.gdpTopFiveCharacter.add(this.lblC4Name, 1, 3);
	    this.gdpTopFiveCharacter.add(this.lblC4Counter, 2, 3);
	    this.gdpTopFiveCharacter.add(this.lblC5Position, 0, 4);
	    this.gdpTopFiveCharacter.add(this.lblC5Name, 1, 4);
	    this.gdpTopFiveCharacter.add(this.lblC5Counter, 2, 4);
	    
	    this.tbpTopFiveCharacter.setContent(this.gdpTopFiveCharacter);
	    
		this.hbxOkButton.getChildren().add(this.btnOk);
		
		this.vbxContent.getChildren().addAll(this.tbpTopFivePlayer, this.tbpTopFiveCharacter, this.hbxOkButton);
		
		this.bdpRootPane.setCenter(this.vbxContent);
	}
	
	//Method that initialize the stage (window) settings:
	private void initStage(StatisticStageResources res) {
		
		this.scene = new Scene(this.bdpRootPane, 400, 427);
		this.setScene(this.scene);
		
		this.getIcons().addAll(res.stageIcon16x16);
		
		this.setMinWidth(400);
		this.setMinHeight(465);
		this.setMaxWidth(500);
		this.setMaxHeight(465);
		this.setResizable(true);
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################