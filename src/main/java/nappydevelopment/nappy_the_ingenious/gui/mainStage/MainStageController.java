//### MainStageController.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.mainStage;

//### IMPORTS ##############################################################################################################################
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nappydevelopment.nappy_the_ingenious.Program;

//Class that handles the interactions of the main-stage with the program-logic:
public class MainStageController {
	
//### ATTRIBUTES ###########################################################################################################################
	
	//Reference to the program-logic:
	private Program program;
	
	//Class that represents the main-stage-view:
	private MainStageView view;
	private MainStageResources res;
	private ViewActionEventHandler viewActionEventHandler;
	
//### CONSTRUCTORS #########################################################################################################################
	
	//Default Constructor:
	public MainStageController(Program prog) {
		
		//Set reference to program-logic:
		this.program = prog;
		
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	/* initView [method]: *//**
	 * 
	 */
	public void initView() {
		
		//Initialize the resources for the view:
		this.res = new MainStageResources();
		//Initialize the action-event-handler for the view-components:
		this.viewActionEventHandler = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new MainStageView(this.res, this.viewActionEventHandler);
		//Set the bindings to the view-components:
		this.initViewBindings();
		
	}
	
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
		
		//Menu-Texts:
		this.view.mnuGame.textProperty().bind(this.res.mnuGameText);
		this.view.mniNewGame.textProperty().bind(this.res.mniNewGameText);
		this.view.mniAbortGame.textProperty().bind(this.res.mniAbortGameText);
		this.view.mniStatistic.textProperty().bind(this.res.mniStatisticText);
		this.view.mniSettings.textProperty().bind(this.res.mniSettingsText);
		this.view.mniExit.textProperty().bind(this.res.mniExitText);
		this.view.mnuHelp.textProperty().bind(this.res.mnuHelpText);
		this.view.mniHelp.textProperty().bind(this.res.mniHelpText);
		this.view.mniWiki.textProperty().bind(this.res.mniWikiText);
		this.view.mniInfo.textProperty().bind(this.res.mniInfoText);
		
		//Button-Texts:
		this.view.btnNewGame.textProperty().bind(this.res.btnNewGameText);
		this.view.btnWiki.textProperty().bind(this.res.btnWikiText);
		this.view.btnStatistic.textProperty().bind(this.res.btnStatisticText);
		this.view.btnHelp.textProperty().bind(this.res.btnHelpText);
		
		this.view.btnYes.textProperty().bind(this.res.btnYesText);
		this.view.btnNo.textProperty().bind(this.res.btnNoText);
		this.view.btnIdontKnow.textProperty().bind(this.res.btnIdontKnow);
	}

	
//### EVENT HANDLER ########################################################################################################################
	
	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
		 
		@Override
		public void handle(ActionEvent e) {
	    	  
			Object src = e.getSource();
				
			if(src == view.mniNewGame || src == view.btnNewGame) {
				//Start a new game;
				System.out.println("Start a new game");
				MainStageController.this.showGamemode1View();
			}
			else if(src == view.mniAbortGame) {
				//Abort the current game!
				System.out.println("Abort the current game");
			}
			else if(src == view.mniStatistic || src == view.btnStatistic) {
				//Show the statistic-stage!
				System.out.println("Show the statistic stage");
			}
			else if(src == view.mniSettings) {
				//Show the settings-stage!
				System.out.println("Show the settings stage");
				//Call the function in the program-logic to show the settings-stage:
				MainStageController.this.program.showSettingsStage(MainStageController.this.view);
			}
			else if(src == view.mniExit) {
				//Exit the JavaFX-Application!
				System.out.println("Exit game");
				Platform.exit();
			}
			else if (src == view.mniHelp || src == view.btnHelp) {
				//Show the help-stage!
				System.out.println("Show the help stage");
			}
			else if(src == view.mniWiki || src == view.btnWiki) {
				//Show the wiki-stage!
				System.out.println("Show the wiki stage");
			}
			else if(src == view.mniInfo) {
				//Show the info-stage!
				System.out.println("Show the info stage");
			}
			else {
				System.out.println("Unkwon EventHandler-Source!!!");
			}
			
		}
		
	}
	
//### PUBLIC METHODS #######################################################################################################################
	
	/* showStartView [method]: *//**
	 * 	
	 */
	public void showStartView() {
		
		//Disable the "abort game" menu-item:
		this.view.mniAbortGame.setDisable(true);
		//Set the start-view-pane to the root-pane:
		this.view.bdpRootPane.setCenter(this.view.gdpStartViewContentPane);
		//Show the stage:
		this.view.show();
		
	}
	
	/* showGamemode1View [method]: *//**
	 * 
	 */
	public void showGamemode1View() {
		
		//Enable the "abort game" menu-item:
		this.view.mniAbortGame.setDisable(false);
		//Set the needed panes to the root-pane:
		this.view.bdpRootPane.setTop(this.view.mnbMenuBar);
		this.view.bdpRootPane.setCenter(this.view.gdpProgressBarPic);
		this.view.bdpRootPane.setBottom(this.view.gdpButtons);
		//Show the stage:
		//this.view.show();	Not needed main-stage is always shown after the call of showStartView!
	}
	
	/* showGamemode2View [method]: *//**
	 * 
	 */
	public void showGamemode2View() {
		
	}
	
	/* changeLanguageToGerman [method]: *//**
	 * 
	 */
	public void changeLanguageToGerman() {
		this.res.setTextsToGerman();
	}
	
	/* changeLanguageToEnglish [method]: *//**
	 * 
	 */
	public void changeLanguageToEnglish() {
		this.res.setTextsToEnglish();
	}
}
//### EOF ##################################################################################################################################