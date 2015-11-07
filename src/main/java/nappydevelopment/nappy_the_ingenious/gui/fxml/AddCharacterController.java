package nappydevelopment.nappy_the_ingenious.gui.fxml;

//### IMPORTS ##############################################################################################################################
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class AddCharacterController {
	
	@FXML
	private GridPane gdpRoot;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnAbort;
	
	
	public AddCharacterController() {}
	
	@FXML
	private void initialize() {
		System.out.println("Initializing AddCharacterController!");
	}
	
	@FXML
	private void btnNextOnAction() {
		System.out.println("Next");
	}
	
	@FXML
	private void btnAbortOnAction() {
		System.out.println("Abort");
	}
}
//### EOF ##################################################################################################################################