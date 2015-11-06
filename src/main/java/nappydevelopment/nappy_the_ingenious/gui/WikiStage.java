//### WikiStage.java #######################################################################################################################
package nappydevelopment.nappy_the_ingenious.gui;

//### IMPORTS ##############################################################################################################################
import java.awt.RenderingHints;
import java.util.List;
import java.util.ListIterator;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.util.Utils;

/* WikiStage [class]: Class that represent the wiki-window *//**
 * 
 * @author Manuel Bothner
 *
 */
public class WikiStage extends Stage {
	
	//Flag for alternating background-colors of the character-entries:
	private Boolean colorFlag = true;
	
//### PRIVATE COMPONENTS ###################################################################################################################	
	
	//Scene for the window:
	private Scene wikiScene;
	//Root Pane (Container) of the window:
	private BorderPane bdpRootPane;	
	//### Top-Bar: #############################################################
	private HBox hbxSearchBar;
	private ImageView imvSearchIcon;
	private TextField txfSearchField;
	private Separator sepSearchBar1;
	private Button btnAddNewCharacter;
	//### Content ##############################################################
	private ScrollPane scpContentPane;
	private VBox vbxContentPane;
	//The components for the several characters will dynamically generated!
	
//### CONSTRUCTORS #########################################################################################################################	
	
	/* WikiStage [constructor]: Default constructor: *//**
	 * 
	 * @param characters
	 */
	public WikiStage(List<WikiCharacter> characters) {
		this.initComponents(characters);
		this.initStage();
	}
	
//### INITIAL METHODS ######################################################################################################################	
	
	/* initComponents [method]: Method that initialize the GUI-components of the stage: */
	private void initComponents(List<WikiCharacter> characters) {
		
		this.bdpRootPane = new BorderPane();
		this.scpContentPane = new ScrollPane();
		this.scpContentPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.scpContentPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.scpContentPane.setFitToWidth(true);
		this.vbxContentPane = new VBox();
		this.vbxContentPane.setPadding(new Insets(5,5,5,5));
		this.vbxContentPane.setSpacing(5);
		
		//### Top-Bar: #########################################################
		this.hbxSearchBar = new HBox();
		this.hbxSearchBar.setPadding(new Insets(10,10,10,10));
		this.hbxSearchBar.setSpacing(10);
		this.hbxSearchBar.setAlignment(Pos.CENTER_LEFT);
		this.hbxSearchBar.getStyleClass().add("hbox");	
		this.imvSearchIcon = new ImageView(new Image(MainStage.class.getResourceAsStream("/main/icons/32x32/search.png")));
		this.txfSearchField = new TextField();
		this.txfSearchField.setPrefWidth(500);
		this.sepSearchBar1 = new Separator();
		this.sepSearchBar1.setOrientation(Orientation.VERTICAL);
		this.btnAddNewCharacter = new Button();
		this.btnAddNewCharacter.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/main/icons/32x32/add_character.png"))));
		this.hbxSearchBar.getChildren().addAll(this.imvSearchIcon, this.txfSearchField, this.sepSearchBar1, this.btnAddNewCharacter);
		//######################################################################
		
		//### Generate content wiki-character ##################################
		
		long time1 = System.currentTimeMillis();
		
        ListIterator<WikiCharacter> listIterator = characters.listIterator();
        
        while (listIterator.hasNext()) {
        	
        	//Read out current character:
        	WikiCharacter curCharacter = listIterator.next();
        	
        	//Set-up horizontal box that contains all gui-elements for the current character:
            HBox hbxBox = new HBox();
            hbxBox.setSpacing(10);
            hbxBox.setPadding(new Insets(6,6,6,6));
            //Set alternating the style (background) of the box:
        	if(this.colorFlag == true) {
        		hbxBox.getStyleClass().add("hbxEntry1");
        		this.colorFlag = false;
        	}
        	else {
        		hbxBox.getStyleClass().add("hbxEntry2");
        		this.colorFlag = true;
        	}
            //Set-up vertical box that contains the name and description labels:
        	VBox vbxBox = new VBox();
        	//Set-up image-pattern for the rectangle:
        	ImagePattern imgPat = new ImagePattern(Utils.getScaledInstance(curCharacter.getWikiImage(), 90, 90, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
        	//Set-up rectangle that contains the character-image:
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
    		if(!curCharacter.getNickname().equals("")) {
    			lblName = new Label(curCharacter.getName() + " (" + curCharacter.getNickname() + ")");
    		}
    		else {
    			lblName = new Label(curCharacter.getName());
    		}
        	
        	lblName.getStyleClass().add("lblName");
        	Label lblDescription = new Label(curCharacter.getDescription());
        	lblDescription.setTextAlignment(TextAlignment.JUSTIFY);
        	lblDescription.setWrapText(true);
        	//Add elements to their containers: 
        	vbxBox.getChildren().addAll(lblName, lblDescription);
        	hbxBox.getChildren().addAll(hbxImage, vbxBox);
        	
        	//Add current character-gui-elements to the main-container:
        	this.vbxContentPane.getChildren().add(hbxBox);
        }
        
        long time2 = System.currentTimeMillis();
        System.out.println("Time: " + (time2 - time1));
		
		this.bdpRootPane.setTop(this.hbxSearchBar);
		this.scpContentPane.setContent(this.vbxContentPane);
		this.bdpRootPane.setCenter(this.scpContentPane);
	}
	
	/* initStage [method]: Method that initialize the stage */
	private void initStage() {
		//Create the window-scene with the root-pane and a fix size:
		this.wikiScene = new Scene(this.bdpRootPane, 550, 700);
		//Include the stylesheet:
		this.wikiScene.getStylesheets().add(MainStage.class.getResource("WikiStage.css").toExternalForm());
		this.setScene(this.wikiScene);
		this.setTitle("Nappy, the ingenious - Wiki");
		this.getIcons().add(new Image(MainStage.class.getResourceAsStream("/main/icons/16x16/wiki.png")));
		this.setResizable(true);
	}
	
}
//### EOF ##################################################################################################################################