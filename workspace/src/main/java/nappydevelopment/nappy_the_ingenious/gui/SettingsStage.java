package nappydevelopment.nappy_the_ingenious.gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Main;

//### IMPORTS ##############################################################################################################################

public class SettingsStage extends Stage {
//### CONSTANTS ############################################################################################################################

//### ATTRIBUTES ###########################################################################################################################

//### COMPONENTS ###########################################################################################################################
	Scene scene;
	BorderPane bdpRoot;
	
//### CONSTRUCTORS #########################################################################################################################
	
	public SettingsStage() {
		this.bdpRoot = new BorderPane();
		this.scene = new Scene(this.bdpRoot, 600, 500);
		this.setScene(this.scene);
		this.setTitle("Nappy, the ingenious - Einstellungen");
		this.getIcons().add(new Image(Main.ICONS_PATH + "16x16/settings.png"));
		this.setResizable(true);
	}
	
//### INITIAL METHODS ######################################################################################################################

//### INNER CLASSES ########################################################################################################################

//### GETTER/SETTER ########################################################################################################################

//### METHODS ##############################################################################################################################
}
//### EOF ##################################################################################################################################