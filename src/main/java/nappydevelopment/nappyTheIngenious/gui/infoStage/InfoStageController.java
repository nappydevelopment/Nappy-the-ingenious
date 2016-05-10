package nappydevelopment.nappyTheIngenious.gui.infoStage;
//### IMPORTS ##############################################################################################################################

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.Program;
import nappydevelopment.nappyTheIngenious.exception.ChangeLanguageException;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class InfoStageController {


	//Reference to the program-logic:
	private Program program;
	
	//Class that represents the main-stage-view:
	private InfoStageView view;
	private InfoStageResources res;
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
	
	/* changeThemeToDarkTheme [method]: *//**
	 * 
	 */
	public void changeThemeToDarkTheme() {
		
		this.view.getScene().getStylesheets().clear();
		this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
		this.view.getScene().getStylesheets().add(InfoStageView.class.getResource("InfoStageCSS.css").toExternalForm());
	}
	
	/* changeThemeToBrightTheme [method]: *//**
	 * 
	 */
	public void changeThemeToBrightTheme() {
		
		this.view.getScene().getStylesheets().clear();
		//The following command is not really necessary because through the clear Method about the bright (normal) theme is implicit set:
		//this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/BrightTheme.css");
		this.view.getScene().getStylesheets().add(InfoStageView.class.getResource("InfoStageCSS.css").toExternalForm());
	}
	
	
	/* changeLanguageToGerman [method]: *//**
	 * 
	 */
	public void changeLanguageToGerman() throws ChangeLanguageException {

		this.res.setTextsToGerman();
	}
	
	/* changeLanguageToEnglish [method]: *//**
	 * 
	 */
	public void changeLanguageToEnglish() throws ChangeLanguageException {

		this.res.setTextsToEnglish();
	}

//### PRIVATE METHODS #######################################################################################################################

    private void openBlogInBrowser() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            URI uri = null;
            try {
                uri = new URI("https://nappydevelopment.wordpress.com/");
            } catch (URISyntaxException urie) {
                urie.printStackTrace();
            }
            if (desktop.isSupported(Desktop.Action.MAIL)) {
                try {
                    desktop.browse(uri);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    private void openEmailClient() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            URI uri = null;
            try {
                uri = new URI("mailto:nappydevelopment@gmail.com");
            } catch (URISyntaxException urie) {
                urie.printStackTrace();
            }
            if (desktop.isSupported(Desktop.Action.MAIL)) {
                try {
                    desktop.mail(uri); // alternately, pass a mailto: URI in here
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }


//##########################################################################################################################################
}
//### EOF ##################################################################################################################################