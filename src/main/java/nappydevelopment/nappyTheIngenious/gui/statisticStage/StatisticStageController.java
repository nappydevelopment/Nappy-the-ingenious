package nappydevelopment.nappyTheIngenious.gui.statisticStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.Program;
import nappydevelopment.nappyTheIngenious.data.Player;
import nappydevelopment.nappyTheIngenious.data.StatisticCharacter;
import nappydevelopment.nappyTheIngenious.data.settings.Language;
import nappydevelopment.nappyTheIngenious.util.statistics.StatisticStuffGenerator;

import java.util.ArrayList;

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
		
		this.view.lblP1Position.textProperty().bind(this.res.lblPlayerPositionTexts[0]);
		this.view.lblP1Name.textProperty().bind(this.res.lblPlayerNameTexts[0]);
		this.view.lblP1Value.textProperty().bind(this.res.lblPlayerValueTexts[0]);
		this.view.lblP2Position.textProperty().bind(this.res.lblPlayerPositionTexts[1]);
		this.view.lblP2Name.textProperty().bind(this.res.lblPlayerNameTexts[1]);
		this.view.lblP2Value.textProperty().bind(this.res.lblPlayerValueTexts[1]);
		this.view.lblP3Position.textProperty().bind(this.res.lblPlayerPositionTexts[2]);
		this.view.lblP3Name.textProperty().bind(this.res.lblPlayerNameTexts[2]);
		this.view.lblP3Value.textProperty().bind(this.res.lblPlayerValueTexts[2]);
		this.view.lblP4Position.textProperty().bind(this.res.lblPlayerPositionTexts[3]);
		this.view.lblP4Name.textProperty().bind(this.res.lblPlayerNameTexts[3]);
		this.view.lblP4Value.textProperty().bind(this.res.lblPlayerValueTexts[3]);
		this.view.lblP5Position.textProperty().bind(this.res.lblPlayerPositionTexts[4]);
		this.view.lblP5Name.textProperty().bind(this.res.lblPlayerNameTexts[4]);
		this.view.lblP5Value.textProperty().bind(this.res.lblPlayerValueTexts[4]);
		
		this.view.tbpTopFiveCharacter.bindTitleText(this.res.tbpTopFiveCharacterText);
		this.view.lblC1Position.textProperty().bind(this.res.lblCharacterPositionTexts[0]);
		this.view.lblC1Name.textProperty().bind(this.res.lblCharacterNameTexts[0]);
		this.view.lblC1Counter.textProperty().bind(this.res.lblCharacterCounterTexts[0]);
		this.view.lblC2Position.textProperty().bind(this.res.lblCharacterPositionTexts[1]);
		this.view.lblC2Name.textProperty().bind(this.res.lblCharacterNameTexts[1]);
		this.view.lblC2Counter.textProperty().bind(this.res.lblCharacterCounterTexts[1]);
		this.view.lblC3Position.textProperty().bind(this.res.lblCharacterPositionTexts[2]);
		this.view.lblC3Name.textProperty().bind(this.res.lblCharacterNameTexts[2]);
		this.view.lblC3Counter.textProperty().bind(this.res.lblCharacterCounterTexts[2]);
		this.view.lblC4Position.textProperty().bind(this.res.lblCharacterPositionTexts[3]);
		this.view.lblC4Name.textProperty().bind(this.res.lblCharacterNameTexts[3]);
		this.view.lblC4Counter.textProperty().bind(this.res.lblCharacterCounterTexts[3]);
		this.view.lblC5Position.textProperty().bind(this.res.lblCharacterPositionTexts[4]);
		this.view.lblC5Name.textProperty().bind(this.res.lblCharacterNameTexts[4]);
		this.view.lblC5Counter.textProperty().bind(this.res.lblCharacterCounterTexts[4]);
		
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
		
		StatisticStuffGenerator tfGen = new StatisticStuffGenerator();
		
		ArrayList<Player> tfp = tfGen.getTopFivePlayers();
		Player curPlayer = null;
		
		for(int i = 0; i < tfp.size(); i++) {
			
			curPlayer = tfp.get(i);
			this.res.lblPlayerNameTexts[i].set(curPlayer.getPlayerName());
			this.res.lblPlayerValueTexts[i].set(curPlayer.getQuestions_nappy() + "/" + curPlayer.getQuestions_player());
		}
		
		ArrayList<StatisticCharacter> tfc = tfGen.getTopFivePlayedCharacters();
		StatisticCharacter curCharacter = null;
		
		for(int i = 0; i < tfc.size(); i++) {
			
			curCharacter = tfc.get(i);
			this.res.lblCharacterNameTexts[i].set(curCharacter.getName());
			this.res.lblCharacterCounterTexts[i].set("" + curCharacter.getAmount());
		}
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
	
	
	/* changeThemeToDarkTheme [method]: *//**
	 * 
	 */
	public void changeThemeToDarkTheme() {
		
		this.view.getScene().getStylesheets().clear();
		this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
		this.view.getScene().getStylesheets().add(StatisticStageView.class.getResource("StatisticStageCSS.css").toExternalForm());
	}
	
	/* changeThemeToBrightTheme [method]: *//**
	 * 
	 */
	public void changeThemeToBrightTheme() {
		
		this.view.getScene().getStylesheets().clear();
		//The following command is not really necessary because through the clear Method about the bright (normal) theme is implicit set:
		//this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/BrightTheme.css");
		this.view.getScene().getStylesheets().add(StatisticStageView.class.getResource("StatisticStageCSS.css").toExternalForm());
	}
	
	
	public void changeLanguageTo(Language l) {
		this.res.setTextsTo(l);
	}
	
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################