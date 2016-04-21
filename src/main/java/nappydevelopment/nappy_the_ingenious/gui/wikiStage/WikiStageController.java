package nappydevelopment.nappy_the_ingenious.gui.wikiStage;

import java.awt.RenderingHints;
import java.util.List;
import java.util.ListIterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Program;
import nappydevelopment.nappy_the_ingenious.data.CharacterProvider;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.data.settings.Settings;
import nappydevelopment.nappy_the_ingenious.util.Utils;


//### IMPORTS ##############################################################################################################################
public class WikiStageController {


//### ATTRIBUTES ###########################################################################################################################
	
	private Program program;
			
	private WikiStageView view;
	private WikiStageResources res;
	private ViewActionEventHandler aeh;
	
	private List<WikiCharacter> characters;
			
//### CONSTRUCTORS #########################################################################################################################
			
	public WikiStageController(Program prog) {
		this.program = prog;
	}
			
//### INITIAL METHODS ######################################################################################################################
			
	//Initialize the view:
	public void initView(List<WikiCharacter> chars) {
				
		//Initialize the resources for the view:
		this.res = new WikiStageResources();
		//Initialize the action-event-handler for the view-components:
		this.aeh = new ViewActionEventHandler();
		//Initialize the view:
		this.view = new WikiStageView(this.res, this.aeh, chars);
		//Set character list:
		this.characters = chars;
		//Set the bindings to the view-components:
		this.initViewBindings();
				
	}
			
	//Method that binds properties to the gui-components:
	private void initViewBindings() {
					
		this.view.titleProperty().bind(this.res.stageTitleText);
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

	//Event-Handler that handles all ActionEvents of the view
	private class ViewActionEventHandler implements EventHandler<ActionEvent> {
							 
		@Override
		public void handle(ActionEvent e) {
		
			if(e.getSource() == view.btnResetFilter) {
				WikiStageController.this.resetFilter();
			}
			else if(e.getSource() == view.txfSearchField) {
				WikiStageController.this.changeCharacterListView(CharacterProvider.search(WikiStageController.this.characters,
						                                                       WikiStageController.this.view.txfSearchField.getText()));
			}
		}
				
	}

//### PRIVATE METHODS ######################################################################################################################
	
	private void resetFilter() {
		
		this.view.rbtMale.setSelected(false);
		this.view.rbtFemale.setSelected(false);
		this.view.rbtYoung.setSelected(false);
		this.view.rbtMiddle.setSelected(false);
		this.view.rbtOld.setSelected(false);
		this.view.txfSearchField.setText("");
		
	}
	
	private void changeCharacterListView(List<WikiCharacter> chars) {
		
		Boolean colorFlag = true;
		
		//### Generate content wiki-character ##################################
		this.view.vbxContentPane.getChildren().clear();
		
        ListIterator<WikiCharacter> listIterator = chars.listIterator();
        
        //Run through all wiki-characters:
        while (listIterator.hasNext()) {
        	
        	//Read out current character:
        	WikiCharacter curCharacter = listIterator.next();
        	
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
        		imgPat = new ImagePattern(Utils.getScaledInstance(curCharacter.getWikiImage(), 90, 90, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
        	}
        	
        	Rectangle imgRec = new Rectangle();
    		imgRec.setWidth(90);
    		imgRec.setHeight(90);
    		imgRec.setFill(imgPat);
    		imgRec.setArcHeight(8);
    		imgRec.setArcWidth(8);
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
        	
        	//Add current character-gui-elements to the main-container:
        	
        	this.view.vbxContentPane.getChildren().add(hbxBox);
    		//this.view.bdpRootPane.setCenter(new Group());
        }	
        
    	this.view.scpContentPane.setContent(this.view.vbxContentPane);
		this.view.bdpRootPane.setCenter(this.view.scpContentPane);
	}
	
//### PUBLIC METHODS #######################################################################################################################
			
	public void show(Stage owner) {
				
		//Set owner and modality by the first start of the stage:
		if(this.view.getOwner() == null) {
			this.view.initOwner(owner);
			this.view.initModality(Modality.WINDOW_MODAL);
		}
	    this.resetFilter();
		this.view.show();
	}
			
	public void changeLanguageToGerman() {
		this.res.setTextsToGerman();
	}
			
	public void changeLanguageToEnglish() {
		this.res.setTextsToEnglish();	
	}
			
//##########################################################################################################################################
}
//### EOF ##################################################################################################################################