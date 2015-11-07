package nappydevelopment.nappy_the_ingenious.gui.fxml;

//### IMPORTS ##############################################################################################################################
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddCharacterStage extends Stage {
	
	//Default-Constructor:
	public AddCharacterStage() {
		
	}
	
	/* init [method]: Method that initialize the stage (load the FXML-file and set stage settings) *//**
	 * 
	 * @throws IOException
	 */
	public void init()throws IOException {
		
		//Load the FXML document
		GridPane gdpRoot = FXMLLoader.<GridPane>load(getClass().getResource("AddCharacterFXML.fxml"));
		
		//Set new scene with the root-container form the FXML-file: 
		this.setScene(new Scene(gdpRoot));
		
		//Set stage-settings:
		this.setTitle("Nappy, the ingenious - Neuer Charakter hinzufügen");
	}
	
}
//### EOF ##################################################################################################################################
