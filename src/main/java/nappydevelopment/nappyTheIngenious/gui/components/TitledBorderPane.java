package nappydevelopment.nappyTheIngenious.gui.components;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
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
	
	public Label lblTitle;
	StackPane skpContent;
	Node nodContent;
	
//### CONSTRUCTORS #########################################################################################################################
	
	public TitledBorderPane(String title, Node content) {
		
		    Label lblTitle = new Label("  " + title + "  ");
		    Font lblFont = lblTitle.getFont();
		    lblTitle.setFont(Font.font(lblFont.getName(), 14));
		    lblTitle.setStyle("-fx-translate-y: -12; -fx-background-color: #F4F4F4; -fx-translate-x: +12;");
		    StackPane.setAlignment(lblTitle, Pos.TOP_LEFT);

		    StackPane contentPane = new StackPane();
		    //content.setStyle("-fx-padding: 26 10 10 10;");
		    contentPane.getChildren().add(content);

		    this.setStyle("-fx-content-display: top;" +
		    			  //"-fx-border-insets: 20 15 15 15;" +
                          "-fx-border-color: black;" +
		    			  "-fx-border-width: 2;");
		    this.getChildren().addAll(lblTitle, contentPane);
	}
	
	public TitledBorderPane() {
		
		this.lblTitle = new Label("  No Title  ");
		this.lblTitle.setFont(Font.font(this.lblTitle.getFont().getName(), 14));
		this.lblTitle.setStyle("-fx-translate-y: -12; -fx-background-color: #F4F4F4; -fx-translate-x: +12;");
		StackPane.setAlignment(lblTitle, Pos.TOP_LEFT);
		
		this.skpContent = new StackPane();
		this.skpContent.setPadding(new Insets(15, 15, 15, 15));
		
	    this.setStyle("-fx-content-display: top;" +
  			          "-fx-border-insets: 10 0 0 0;" +
                      "-fx-border-color: black;" +
  			          "-fx-border-width: 2;");
        this.getChildren().addAll(lblTitle, this.skpContent);
        
	}
	
//### INITIAL METHODS ######################################################################################################################

//### INNER CLASSES ########################################################################################################################

//### GETTER/SETTER ########################################################################################################################
  
	public void setTitleText(String text) {
	   this.lblTitle.setText("  " + text + "  ");
   }
	
	public void bindTitleText(StringProperty tbpTopFivePlayerText) {
		this.lblTitle.textProperty().bind(tbpTopFivePlayerText);
	}
	
	public void setContent(Node content) {
		this.nodContent = content;
		this.skpContent.getChildren().add(this.nodContent);
	}
	
	public void setTitlePosition(Pos pos) {
		
	}
	
//### METHODS ##############################################################################################################################}
}
//### EOF ##################################################################################################################################