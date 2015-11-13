//### MainStage.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui.fxml;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Main;

//### IMPORTS ##############################################################################################################################

public class MainStage extends Stage {

//### PUBLIC CONSTANTS #####################################################################################################################

//### PRIVAT CONSTANTS #####################################################################################################################

//### PUBLIC STATIC VARIABLES ##############################################################################################################

//### PRIVATE STATIC VARIABLES #############################################################################################################

//### PRIVATE ATTRIBUTES ###################################################################################################################

//### COMPONENTS ###########################################################################################################################

//### EVENT-HANDLER ########################################################################################################################

//### CONSTRUCTORS #########################################################################################################################

	//Default-Constructor:
	public MainStage() {
		
	}
	
//### INITAL METHODS #######################################################################################################################

	/* init [method]: Method that initialize the stage (load the FXML-file and set stage settings) *//**
	 * 
	 * @throws IOException
	 */
	public void init()throws IOException {
		
		//Load the FXML document
		BorderPane brpRoot = FXMLLoader.<BorderPane>load(getClass().getResource("MainStageFXML.fxml"));
		
		//Set new scene with the root-container form the FXML-file: 
		this.setScene(new Scene(brpRoot, 300, 400));
		//Set title of the window:
		this.setTitle("Nappy, the ingenious");
		//Set icons of the window:
		this.getIcons().addAll(new Image(Main.ICONS_PATH + "16x16/icon.png"),
							   new Image(Main.ICONS_PATH + "32x32/icon.png"),
							   new Image(Main.ICONS_PATH + "48x48/icon.png"),
							   new Image(Main.ICONS_PATH + "64x64/icon.png"),
							   new Image(Main.ICONS_PATH + "128x128/icon.png"),
							   new Image(Main.ICONS_PATH + "256x256/icon.png"));
		//Allow to resize the window:
		this.setResizable(true);
	}
	
//### INNER CLASSES ########################################################################################################################

//### PRIAVTE STATIC METHODS ###############################################################################################################

//### PUBLIC STATIC METHODS ################################################################################################################

//### PRIVATE METHODS ######################################################################################################################

//### GETTER/SETTER METHODS ################################################################################################################

//### PUBLIC METHODS #######################################################################################################################

}
//### EOF ##################################################################################################################################