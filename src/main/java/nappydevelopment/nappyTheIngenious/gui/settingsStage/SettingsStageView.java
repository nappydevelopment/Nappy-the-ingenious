package nappydevelopment.nappyTheIngenious.gui.settingsStage;

//### IMPORTS ##############################################################################################################################
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/* SettingsStageView [class]: *//**
 * 
 * @author Manuel Bothner
 *
 */
public class SettingsStageView extends Stage {

//### GUI COMPONENTS #######################################################################################################################
	
	Scene scene;
	
	BorderPane bdpRootPane;
	
	GridPane gdpSettingOptions;
	
	GridPane gdpLanguage;
	Label lblLanguage;
	ToggleGroup tggLanguage;
	RadioButton rdbGerman;
	RadioButton rdbEnglish;
	
	GridPane gdpColorScheme;
	Label lblColorScheme;
	ToggleGroup tggColorScheme;
	RadioButton rdbBright;
	RadioButton rdbDark;
	
	GridPane gdpGameMode;
	Label lblGameMode;
	ToggleGroup tggGameMode;
	RadioButton rdbOnlyMode1;
	RadioButton rdbBothModes;
	
	HBox hbxBottom;
	GridPane gdpButtons;
	
	Button btnAbort;
	Button btnApply;
	
//### CONSTRUCTORS #########################################################################################################################
	
	public SettingsStageView(SettingsStageResources res, EventHandler<ActionEvent> aeh) {
		this.initComponents(res, aeh);
		this.structureComponents();
		this.initStage(res);
	}
			
//### INITAL METHODS #######################################################################################################################
	
	//Method that initialize the gui-components:
	private void initComponents(SettingsStageResources res, EventHandler<ActionEvent> aeh) {
		
		this.bdpRootPane = new BorderPane();
		
		this.gdpSettingOptions = new GridPane();
		this.gdpSettingOptions.setVgap(25);
		//this.gdpSettingOptions.setGridLinesVisible(true);
		this.gdpSettingOptions.setPadding(new Insets(25, 25, 0, 25));
		this.gdpSettingOptions.setAlignment(Pos.CENTER);
		
		ColumnConstraints col1 = new ColumnConstraints();
	    col1.setPercentWidth(50);
	    ColumnConstraints col2 = new ColumnConstraints();
	    col2.setPercentWidth(50);
	    
		this.gdpLanguage = new GridPane();
		this.gdpLanguage.setHgap(30);
		this.gdpLanguage.setVgap(10);
		this.gdpLanguage.setPrefSize(300, 300);
		this.gdpLanguage.getColumnConstraints().addAll(col1,col2);
		this.lblLanguage = new Label();
		this.tggLanguage = new ToggleGroup();
		this.rdbGerman = new RadioButton();
		this.rdbGerman.setToggleGroup(this.tggLanguage);
		this.rdbEnglish = new RadioButton();
		this.rdbEnglish.setToggleGroup(this.tggLanguage);
		
		this.gdpColorScheme = new GridPane();
		this.gdpColorScheme.setHgap(30);
		this.gdpColorScheme.setVgap(10);
		this.gdpColorScheme.setPrefSize(300, 300);
		this.gdpColorScheme.getColumnConstraints().addAll(col1,col2);
		this.lblColorScheme = new Label();
		this.tggColorScheme = new ToggleGroup();
		this.rdbBright = new RadioButton();
		this.rdbBright.setToggleGroup(this.tggColorScheme);
		this.rdbDark = new RadioButton();
		this.rdbDark.setToggleGroup(this.tggColorScheme);
		
		this.gdpGameMode = new GridPane();
		this.gdpGameMode.setHgap(30);
		this.gdpGameMode.setVgap(10);
		this.gdpGameMode.setPrefSize(300, 300);
		this.gdpGameMode.getColumnConstraints().addAll(col1,col2);
		this.lblGameMode = new Label();
		this.tggGameMode = new ToggleGroup();
		this.rdbBothModes = new RadioButton();
		this.rdbBothModes.setToggleGroup(this.tggGameMode);
		this.rdbOnlyMode1 = new RadioButton();
		this.rdbOnlyMode1.setToggleGroup(this.tggGameMode);
		this.rdbOnlyMode1.setOnAction(aeh);
		
		this.hbxBottom = new HBox();
		this.hbxBottom.setAlignment(Pos.CENTER_RIGHT);
		this.hbxBottom.setPadding(new Insets(50, 25, 25, 25));
		
		this.gdpButtons = new GridPane();
		this.gdpButtons.setHgap(30);
		
		this.btnAbort = new Button();
		this.btnAbort.setOnAction(aeh);
		this.btnApply = new Button();
		this.btnApply.setOnAction(aeh);
		
	}
	
	//Method that structure (add components to their parent node) the gui-components:
	private void structureComponents() {
		
		this.gdpLanguage.add(this.lblLanguage, 0, 0, 2, 1);
		this.gdpLanguage.add(this.rdbGerman, 0, 1);
		this.gdpLanguage.add(this.rdbEnglish, 1, 1);
		
		this.gdpColorScheme.add(this.lblColorScheme, 0, 0);
		this.gdpColorScheme.add(this.rdbBright, 0, 1);
		this.gdpColorScheme.add(this.rdbDark, 1, 1);
		
		this.gdpGameMode.add(this.lblGameMode, 0, 0);
		this.gdpGameMode.add(this.rdbBothModes, 0, 1);
		this.gdpGameMode.add(this.rdbOnlyMode1, 1, 1);
		
		this.gdpSettingOptions.add(this.gdpLanguage, 0, 0);
		this.gdpSettingOptions.add(this.gdpColorScheme, 0, 1);
		this.gdpSettingOptions.add(this.gdpGameMode, 0, 2);
		this.gdpSettingOptions.autosize();
		
		this.bdpRootPane.setCenter(this.gdpSettingOptions);
		
		this.gdpButtons.add(this.btnAbort, 0, 0);
		this.gdpButtons.add(this.btnApply, 1, 0);
		this.hbxBottom.getChildren().add(this.gdpButtons);
		
		this.bdpRootPane.setBottom(this.hbxBottom);
		this.bdpRootPane.autosize();
	}
	
	//Method that initialize the stage (window) settings:
	private void initStage(SettingsStageResources res) {
		
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