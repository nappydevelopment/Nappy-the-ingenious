package nappydevelopment.nappy_the_ingenious.gui.statisticStage;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.Player;
import nappydevelopment.nappy_the_ingenious.gui.settingsStage.SettingsStageController;
import nappydevelopment.nappy_the_ingenious.util.statistics.TopFiveGenerator;

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
		
		this.view.tbpTopFivePlayer.bindTitleText(this.res.tbpTopFivePlayerText);
		
		this.view.lblP1Position.textProperty().bind(this.res.lblP1PositionText);
		this.view.lblP1Name.textProperty().bind(this.res.lblP1NameText);
		this.view.lblP1Value.textProperty().bind(this.res.lblP1ValueText);
		this.view.lblP2Position.textProperty().bind(this.res.lblP2PositionText);
		this.view.lblP2Name.textProperty().bind(this.res.lblP2NameText);
		this.view.lblP2Value.textProperty().bind(this.res.lblP2ValueText);
		this.view.lblP3Position.textProperty().bind(this.res.lblP3PositionText);
		this.view.lblP3Name.textProperty().bind(this.res.lblP3NameText);
		this.view.lblP3Value.textProperty().bind(this.res.lblP3ValueText);
		this.view.lblP4Position.textProperty().bind(this.res.lblP4PositionText);
		this.view.lblP4Name.textProperty().bind(this.res.lblP4NameText);
		this.view.lblP4Value.textProperty().bind(this.res.lblP4ValueText);
		this.view.lblP5Position.textProperty().bind(this.res.lblP5PositionText);
		this.view.lblP5Name.textProperty().bind(this.res.lblP5NameText);
		this.view.lblP5Value.textProperty().bind(this.res.lblP5ValueText);
		
		this.view.tbpTopFiveCharacter.bindTitleText(this.res.tbpTopFiveCharacterText);
		this.view.lblC1Position.textProperty().bind(this.res.lblC1PositionText);
		this.view.lblC1Name.textProperty().bind(this.res.lblC1NameText);
		this.view.lblC1Counter.textProperty().bind(this.res.lblC1CounterText);
		this.view.lblC2Position.textProperty().bind(this.res.lblC2PositionText);
		this.view.lblC2Name.textProperty().bind(this.res.lblC2NameText);
		this.view.lblC2Counter.textProperty().bind(this.res.lblC2CounterText);
		this.view.lblC3Position.textProperty().bind(this.res.lblC3PositionText);
		this.view.lblC3Name.textProperty().bind(this.res.lblC3NameText);
		this.view.lblC3Counter.textProperty().bind(this.res.lblC3CounterText);
		this.view.lblC4Position.textProperty().bind(this.res.lblC4PositionText);
		this.view.lblC4Name.textProperty().bind(this.res.lblC4NameText);
		this.view.lblC4Counter.textProperty().bind(this.res.lblC4CounterText);
		this.view.lblC5Position.textProperty().bind(this.res.lblC5PositionText);
		this.view.lblC5Name.textProperty().bind(this.res.lblC5NameText);
		this.view.lblC5Counter.textProperty().bind(this.res.lblC5CounterText);
		
		this.view.btnOk.textProperty().bind(this.res.btnOkText);
		
		this.view.titleProperty().bind(this.res.stageTitleText);
			
	}
	
	
//### INNER CLASSES ########################################################################################################################

	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
					 
		@Override
		public void handle(ActionEvent e) {
	    	  
			Object src = e.getSource();
					
			if(src == view.btnOk) {
				//Close stage!
				System.out.println("Abort settings");
				StatisticStageController.this.view.close();
			}
			else {
				System.out.println("Unkwon EventHandler-Source!!!");
			}
		}
		
	}

//### PRIVATE METHODS ######################################################################################################################
	
	private void readOutTopFivePlayer() {
		
		TopFiveGenerator tfGen = new TopFiveGenerator();
		ArrayList<Player> tfp = tfGen.getTopFivePlayers();
		
		Player curPlayer = tfp.get(0);
		
		this.res.lblP1NameText.set(curPlayer.getAnzeigeName());
		this.res.lblP1ValueText.set(curPlayer.getFragen_nappy() + "/" + curPlayer.getFragen_spieler());
		
		curPlayer = tfp.get(1);
		
		this.res.lblP2NameText.set(curPlayer.getAnzeigeName());
		this.res.lblP2ValueText.set(curPlayer.getFragen_nappy() + "/" + curPlayer.getFragen_spieler());
		
		curPlayer = tfp.get(2);
		
		this.res.lblP3NameText.set(curPlayer.getAnzeigeName());
		this.res.lblP3ValueText.set(curPlayer.getFragen_nappy() + "/" + curPlayer.getFragen_spieler());
		
		curPlayer = tfp.get(3);
		
		this.res.lblP4NameText.set(curPlayer.getAnzeigeName());
		this.res.lblP4ValueText.set(curPlayer.getFragen_nappy() + "/" + curPlayer.getFragen_spieler());
		
		curPlayer = tfp.get(4);
		
		this.res.lblP5NameText.set(curPlayer.getAnzeigeName());
		this.res.lblP5ValueText.set(curPlayer.getFragen_nappy() + "/" + curPlayer.getFragen_spieler());
		
		//ArrayList<WikiCharacter> tfc = tfGen.
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	public void show(Stage owner) {
		
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
		
		this.readOutTopFivePlayer();
		
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