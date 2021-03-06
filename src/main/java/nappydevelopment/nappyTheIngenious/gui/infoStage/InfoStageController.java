package nappydevelopment.nappyTheIngenious.gui.infoStage;
//### IMPORTS ##############################################################################################################################

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.Program;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class InfoStageController {


	//Reference to the program-logic:
	private Program program;
	
	//Class that represents the main-stage-view:
	protected InfoStageView view;
	protected InfoStageResources res;
	private ViewActionEventHandler aeh;
	
//### CONSTRUCTORS #########################################################################################################################
	
	//Default Constructor:
	public InfoStageController(Program prog) {
		
		//Set reference to program-logic:
		this.program = prog;
		
	}

//### INITIAL METHODS ######################################################################################################################
	
	//Initialize the view:
	public void initView() {
			
		//Initialize the resources for the view:
		this.res = new InfoStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new InfoStageView(this.res, this.aeh);
		//Set the bindings to the view-components:
		this.initViewBindings();
			
	}
		
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
		
		this.view.titleProperty().bind(this.res.stageTitleText);
		
		this.view.lblTitle.textProperty().bind(this.res.lblTitleText);
		this.view.lblDescription.textProperty().bind(this.res.lblDescriptionText);
		this.view.lblDevelopedBy.textProperty().bind(this.res.lblDevelopedByText);
		this.view.lblName1.textProperty().bind(this.res.lblName1Text);
		this.view.lblName2.textProperty().bind(this.res.lblName2Text);
		this.view.lblName3.textProperty().bind(this.res.lblName3Text);
		this.view.lblName4.textProperty().bind(this.res.lblName4Text);
		this.view.lblNappyDevelopment.textProperty().bind(this.res.lblNappyDevelopmentText);
		
	}
		
//### INNER CLASSES ########################################################################################################################
	
	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
			 
		@Override
		public void handle(ActionEvent e) {
			
			Object src = e.getSource();
			
			if(src == view.linkBlog) {
				System.out.println("Open Blog in Browser");
                openBlogInBrowser();
			}
			if(src == view.linkMail) {
				System.out.println("Open e-mail program");
                openEmailClient();
			}
		}
		
	}

//### PUBLIC METHODS #######################################################################################################################
	
	/* show [method]: Method that shows the info-stage *//**
	 * 
	 */
	public void show(Stage owner) {
		
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
		
		this.view.show();
	}

	public void applySettings() {
		this.view.getScene().getStylesheets().clear();
		if(Settings.getColoScheme() == ColorScheme.DARK){
			this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
		}
		this.view.getScene().getStylesheets().add(InfoStageView.class.getResource("InfoStageCSS.css").toExternalForm());

		switch(Settings.getLanguage()){
			case ENGLISH:
				this.res.changeLanguageToEnglish();
				break;
			case GERMAN:
				this.res.changeLanguageToGerman();
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

//### PRIVATE METHODS #######################################################################################################################

	/* Open a website with the standard browser
	*
	 */
    private void openBlogInBrowser() {
        if (!Desktop.isDesktopSupported()) {
			return;
		}
		if (!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			return;
		}
		try {
			URI website = new URI("https://nappydevelopment.wordpress.com/");
			if(System.getProperty("os.name").contains("Windows")) {
				Desktop.getDesktop().browse(website);
			} else {
				// seems like there is no other way
				// mac probably still fails here
				Runtime.getRuntime().exec("/usr/bin/xdg-open "+ website.toString());
			}
		} catch (IOException|URISyntaxException e){
			e.printStackTrace();
		}
    }

	/* 	Open the standard mailclient
	*	Set mailto
	 */
    private void openEmailClient() {
        if (!Desktop.isDesktopSupported()){
			return;
		}
		if(!Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {
			return;
		}
		try {
			URI mail = new URI("mailto:nappydevelopment@gmail.com");
			if(System.getProperty("os.name").contains("Windows")) {
				Desktop.getDesktop().mail(mail);
			} else {
				Runtime.getRuntime().exec("/usr/bin/xdg-open " + mail.toString());
			}
		} catch (URISyntaxException|IOException e) {
			e.printStackTrace();
		}
	}


//##########################################################################################################################################
}
//### EOF ##################################################################################################################################