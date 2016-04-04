package nappydevelopment.nappy_the_ingenious.gui.components;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
//### IMPORTS ##############################################################################################################################
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class TitledBorderPane extends StackPane {
//### CONSTANTS ############################################################################################################################

//### ATTRIBUTES ###########################################################################################################################

//### COMPONENTS ###########################################################################################################################
	
	Label lblTitle;
	Node nodContent;
	
//### CONSTRUCTORS #########################################################################################################################
	
	public TitledBorderPane(String title, Node content) {
		
		    Label lblTitle = new Label("  " + title + "  ");
		    Font lblFont = lblTitle.getFont();
		    lblTitle.setFont(Font.font(lblFont.getName(), 14));
		    lblTitle.setStyle("-fx-translate-y: -12; -fx-background-color: #F4F4F4; -fx-translate-x: +12;");
		    StackPane.setAlignment(lblTitle, Pos.TOP_LEFT);

		    StackPane contentPane = new StackPane();
		    content.setStyle("-fx-padding: 26 10 10 10;");
		    contentPane.getChildren().add(content);

		    this.setStyle("-fx-content-display: top;" +
		    			  "-fx-border-insets: 20 15 15 15;" +
                          "-fx-border-color: black;" +
		    			  "-fx-border-width: 2;");
		    this.getChildren().addAll(lblTitle, contentPane);
		  }
	
//### INITIAL METHODS ######################################################################################################################

//### INNER CLASSES ########################################################################################################################

//### GETTER/SETTER ########################################################################################################################
  
	public void setTitle(String title) {
	   this.lblTitle.setText("  " + title + "  ");
   }
	
//### METHODS ##############################################################################################################################}
}
//### EOF ##################################################################################################################################