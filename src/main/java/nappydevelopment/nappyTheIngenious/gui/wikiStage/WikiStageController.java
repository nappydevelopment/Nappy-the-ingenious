//### WikiStageController.java #############################################################################################################
package nappydevelopment.nappyTheIngenious.gui.wikiStage;

//### IMPORTS ##############################################################################################################################
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import nappydevelopment.nappyTheIngenious.Program;
import nappydevelopment.nappyTheIngenious.data.CharacterProvider;
import nappydevelopment.nappyTheIngenious.data.character.Age;
import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterFilter;
import nappydevelopment.nappyTheIngenious.data.character.Gender;
import nappydevelopment.nappyTheIngenious.data.settings.ColorScheme;
import nappydevelopment.nappyTheIngenious.data.settings.Settings;
import nappydevelopment.nappyTheIngenious.util.Utils;

import java.awt.RenderingHints;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;


public class WikiStageController {

//### ATTRIBUTES ###########################################################################################################################
	
	//Flag that mark the first show of the stage (necessary because there is no reset of filters):
	private boolean initialShowing;
			
	
	//Reference to the program-logic:
	private Program program;
	
	protected WikiStageView view;
	protected WikiStageResources res;
	private ViewActionEventHandler aeh;
	private ViewKeyEventHandler keh;
	private ViewMouseEventHandler meh;
	
	//List with the characters of the wiki:
	private List<Character> characters;
			
//### CONSTRUCTORS #########################################################################################################################
			
	public WikiStageController(Program prog) {
		this.program = prog;
	}
			
//### INITIAL METHODS ######################################################################################################################
			
	//Initialize the view:
	public void initView(List<Character> chars) {
				
		//Initialize the resources for the view:
		this.res = new WikiStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the key-event-handler for the view-components:
		this.keh = new ViewKeyEventHandler();
		
		this.meh = new ViewMouseEventHandler();
		//Initialize the view:
		this.view = new WikiStageView(this.res, this.aeh, this.keh, this.meh, chars);
		//Set flag for initial show of the view:
		this.initialShowing = true;
		//Set character list:
		this.characters = chars;
		
		//Set the bindings to the view-components:
		this.initViewBindings();
				
	}
			
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
					
		this.view.tbpGender.bindTitleText(this.res.tbpGenderText);
		this.view.rbtMale.textProperty().bind(this.res.rbtMaleText);
		this.view.rbtFemale.textProperty().bind(this.res.rbtFemaleText);
		this.view.tbpAge.bindTitleText(this.res.tbpAgeText);
		this.view.rbtYoung.textProperty().bind(this.res.rbpYoungText);
		this.view.rbtMiddle.textProperty().bind(this.res.rbpMiddleText);
		this.view.rbtOld.textProperty().bind(this.res.rbpOldText);
		this.view.btnResetFilter.textProperty().bind(this.res.btnResetFilterText);
	}
			
//### INNER CLASSES ########################################################################################################################

	//Event-Handler that handles all ActionEvents of the view:
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
							 
		@Override
		public void handle(ActionEvent e) {
		
			Object src = e.getSource();
			
			if(src == view.btnResetFilter) {
				WikiStageController.this.resetFilter();
			}
			else if(src == view.rbtFemale || 
					src == view.rbtMale   ||
					src == view.rbtYoung  ||
					src == view.rbtMiddle ||
					src == view.rbtOld  /*||
					src == view.txfSearchField*/) {
				WikiStageController.this.applyFilter();
			}

		}
				
	}
	
	//Event-Handler that handles all KeyEvents of the view:
	private class ViewKeyEventHandler implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent e) {
			
			if(e.getSource() == view.txfSearchField) {
				WikiStageController.this.applyFilter();
			}
			
		}
		
	}

	private class ViewMouseEventHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			if(WikiStageController.this.res.selectionFlag) {
				WikiStageController.this.program.setSelectedCharacter((Character)((Rectangle)event.getSource()).getUserData());
			}
		}
	}
		
//### PRIVATE METHODS ######################################################################################################################
	
	/* applyFilter [method]: Method that applies the filter options *//**
	 * 
	 */
	private void applyFilter() {
		
		Age age = Age.UNKNOWN;
		Gender gender = Gender.UNKNOWN;
		
		if(this.view.tggAge.getSelectedToggle() != null) {
			age = (Age) this.view.tggAge.getSelectedToggle().getUserData();
		}
        
		if(this.view.tggGender.getSelectedToggle() != null) {
			gender = (Gender) this.view.tggGender.getSelectedToggle().getUserData();
		}
		
		//Create a new character filter:
		CharacterFilter filter = new CharacterFilter(WikiStageController.this.view.txfSearchField.getText(), gender, age);
		//Update character list:
		this.adaptCharacterList(CharacterProvider.search(WikiStageController.this.characters, filter));
		
	}
	
	/* resetFilter [method]: Method that reset the filter (radio buttons & text field) *//**
	 * 
	 */
	private void resetFilter() {
		
		//Reset filter elements:
		this.view.rbtMale.setSelected(false);
		this.view.rbtFemale.setSelected(false);
		this.view.rbtYoung.setSelected(false);
		this.view.rbtMiddle.setSelected(false);
		this.view.rbtOld.setSelected(false);
		this.view.txfSearchField.setText("");
		
		//Reset character list:
		this.adaptCharacterList(this.characters);
		
	}

	/* adaptCharacterList [method]: Method that adapt the shown character list depending on the set filters *//**
	 * 
	 * @param chars
	 */
	private void adaptCharacterList(List<Character> chars) {
		
		Boolean colorFlag = true;
		
		//### Generate content wiki-character ##################################
		this.view.vbxContentPane.getChildren().clear();
		
		System.out.println("RENDERING FAST!!!");
        ListIterator<Character> listIterator = chars.listIterator();
        
        //Run through all wiki-characters:
        while (listIterator.hasNext()) {
        	
        	//Read out current character:
        	Character curCharacter = listIterator.next();
        	
        	//Set-up horizontal box that contains all gui-elements for the current character:
            HBox hbxBox = new HBox();
            hbxBox.setSpacing(10);
            hbxBox.setPadding(new Insets(6,6,6,6));
            //Set alternating the style (background) of the box:
        	if(colorFlag == true) {
        		hbxBox.getStyleClass().add("hbxEntry1");
        		colorFlag = false;
        	}
        	else {
        		hbxBox.getStyleClass().add("hbxEntry2");
        		colorFlag = true;
        	}
            //Set-up vertical box that contains the name and description labels:
        	VBox vbxBox = new VBox();
        	//Set-up image-pattern for the rectangle:
        	
        	ImagePattern imgPat = null;
        	
        	if(curCharacter.getWikiImage() == null) {
        		System.out.println("Image Null");
        	}
        	else {
        		//imgPat = new ImagePattern(Utils.getScaledInstance(curCharacter.getWikiImage(), 90, 90, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, false));
				try{
					imgPat = new ImagePattern(res.charNameImageMap.get(curCharacter.getName()));
				} catch (NullPointerException e){
					e.printStackTrace();
				}

        	}
        	
        	Rectangle imgRec = new Rectangle();
    		imgRec.setWidth(90);
    		imgRec.setHeight(90);
    		imgRec.setFill(imgPat);
    		imgRec.setArcHeight(8);
    		imgRec.setArcWidth(8);
    		imgRec.setOnMouseClicked(this.meh);
    		imgRec.setUserData(curCharacter);
    		//Set-up horizontal box that contains the image:
    		HBox hbxImage = new HBox();
    		hbxImage.setId("hbxEntry1");
    		hbxImage.getChildren().add(imgRec);
    		//Set-up labels for name and description:
    		Label lblName = null;
    		if(curCharacter.getNickname(Settings.getLanguage()) == null) {
    			lblName = new Label(curCharacter.getName());
    		}
    		else if(!curCharacter.getNickname(Settings.getLanguage()).equals("")) {
    			lblName = new Label(curCharacter.getName() + " (" + curCharacter.getNickname(Settings.getLanguage()) + ")");
    		}
    		else {
    			lblName = new Label(curCharacter.getName());
    		}
        	
        	lblName.getStyleClass().add("lblName");
        	Label lblDescription = new Label(curCharacter.getDescription(Settings.getLanguage()));
        	lblDescription.setTextAlignment(TextAlignment.JUSTIFY);
        	lblDescription.setWrapText(true);
        	//Add elements to their containers: 
        	vbxBox.getChildren().addAll(lblName, lblDescription);
        	hbxBox.getChildren().addAll(hbxImage, vbxBox);   	
        	this.view.vbxContentPane.getChildren().add(hbxBox);
 
        }	
        
    	this.view.scpContentPane.setContent(this.view.vbxContentPane);
		this.view.bdpRootPane.setCenter(this.view.scpContentPane);
	}
	
//### PUBLIC METHODS #######################################################################################################################
		
	public void showForSelection(Stage owner) {
		this.res.selectionFlag = true;
		this.show(owner);
		this.view.setTitle(res.stageTitleText2);
	}
	
	/* show [method]: Method that shows the stage *//**
	 * 
	 * @param owner
	 */
	public void show(Stage owner) {
				
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
		
		//Check if this is that fist time that the stage is shown:
		if(this.initialShowing) {
			//Change flag:
			this.initialShowing = false;
		}
		//Was the stage open before:
		else {
			//Reset filters:
			this.resetFilter();
		}
		
		//Show the stage:
		this.view.show();
	}
	
	public boolean showConfirmSelectionDialog(Character character) {
		
		//Create the dialog buttons:
		ButtonType bttApply = new ButtonType(this.res.confirmDialogBtnApplyText);
		ButtonType bttCancel = new ButtonType(this.res.confirmDialogBtnCancelText);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	
 		Image image = new Image(GlobalReferences.CURSORS_PATH + "left_ptr.png");
		alert.getDialogPane().setCursor(new ImageCursor(image,0,0));
    		
		HBox hbxCharacter = new HBox();
		hbxCharacter.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 5, 0, 0, 0);" +
			"-fx-padding: 5;" +
		    "-fx-background-color: #FFD90F;" +
		    "-fx-background-radius: 5;"
		);
		
		ImagePattern impCharacter = new ImagePattern(Utils.getScaledInstance(character.getWikiImage(), 110, 110, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
		    
	    Rectangle recCharacter = new Rectangle();
		recCharacter.setWidth(110);
		recCharacter.setHeight(110);
		recCharacter.setArcHeight(8);
		recCharacter.setArcWidth(8);
		recCharacter.setFill(impCharacter);
			
		hbxCharacter.getChildren().add(recCharacter);
    	
    	alert.setTitle(this.res.confirmDialogTitle);
    	alert.setHeaderText(this.res.confirmDialogHeaderText1 + character.getName() + this.res.confirmDialogHeaderText2);
    	alert.setContentText(this.res.confirmDialogContentText);
    	alert.setGraphic(hbxCharacter);
    	alert.getButtonTypes().setAll(bttApply, bttCancel);
    	
		if(Settings.getColoScheme() == ColorScheme.DARK) {
			alert.getDialogPane().getStylesheets().clear();
			alert.getDialogPane().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
		}
		    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == bttApply){
    	    return true;
    	} else {
    	    return false;
    	}
	}
	
	public void closeView() {
		this.view.close();
	}
	
	public void applySettings() {
		this.view.getScene().getStylesheets().clear();
		if(Settings.getColoScheme() == ColorScheme.DARK){
			this.view.getScene().getStylesheets().add("/nappydevelopment/nappyTheIngenious/gui/globalStyle/DarkTheme.css");
		}
		this.view.getScene().getStylesheets().add(WikiStageView.class.getResource("WikiStageCSS.css").toExternalForm());

		switch(Settings.getLanguage()){
			case GERMAN:
				this.res.changeLanguageToGerman();
				break;
			case ENGLISH:
				this.res.changeLanguageToEnglish();
				break;
			default:
				throw new IllegalArgumentException("unknown Language");
		}
	}
			
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################