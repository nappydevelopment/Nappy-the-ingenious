package nappydevelopment.nappy_the_ingenious.gui.wikiStage;

import java.awt.RenderingHints;
import java.util.List;
import java.util.ListIterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import nappydevelopment.nappy_the_ingenious.gui.components.TitledBorderPane;
import nappydevelopment.nappy_the_ingenious.util.Utils;

//### IMPORTS ##############################################################################################################################
public class WikiStageView extends Stage {
	
//### ATTRIBUTES ###########################################################################################################################
		
	//Flag for alternating background-colors of the character-entries:
	private Boolean colorFlag = true;
	
//### COMPONENTS ###########################################################################################################################

	Scene scene;
			
	BorderPane bdpRootPane;
	
	//### Top-Bar: #############################################################
	VBox vbxTopBar;
	HBox hbxSearchBar;
	ImageView imvSearchIcon;
	TextField txfSearchField;
	HBox hbxFilter;
	VBox vbxFilterIcon;
	ImageView imvFilterIcon;
	TitledBorderPane tbpGender;
	HBox hbxGenderContent;
	ToggleGroup  tggGender;
	RadioButton rbtMale;
	RadioButton rbtFemale;
	TitledBorderPane tbpAge;
	HBox hbxAgeContent;
	ToggleGroup tggAge;
	RadioButton rbtYoung;
	RadioButton rbtMiddle;
	RadioButton rbtOld;
	
	
	//### Content ##############################################################
	ScrollPane scpContentPane;
	VBox vbxContentPane;
	//The components for the several characters will dynamically generated!
			
//### CONSTRUCTORS #########################################################################################################################
			
	public WikiStageView(WikiStageResources res, EventHandler<ActionEvent> aeh, List<WikiCharacter> chars) {
		this.initComponents(res, aeh, chars);
		this.structureComponents();
		this.initStage(res);
	}
			
//### INITIAL METHODS ######################################################################################################################
			
	//Method that initialize the gui-components:
	private void initComponents(WikiStageResources res, EventHandler<ActionEvent> aeh, List<WikiCharacter> chars) {
				
		this.bdpRootPane = new BorderPane();
		
		this.scpContentPane = new ScrollPane();
		this.scpContentPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.scpContentPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.scpContentPane.setFitToWidth(true);
		
		this.vbxContentPane = new VBox();
		this.vbxContentPane.setPadding(new Insets(5,5,5,5));
		this.vbxContentPane.setSpacing(5);
		
		//### Top-Bar: #########################################################
		this.vbxTopBar = new VBox();
		
		this.hbxSearchBar = new HBox();
		this.hbxSearchBar.setPadding(new Insets(10,10,10,10));
		this.hbxSearchBar.setSpacing(10);
		this.hbxSearchBar.setAlignment(Pos.CENTER_LEFT);
		this.hbxSearchBar.getStyleClass().add("hbox");	
		this.imvSearchIcon = new ImageView(new Image(WikiStageView.class.getResourceAsStream("/icons/32x32/search.png")));
		this.txfSearchField = new TextField();
		this.txfSearchField.setPrefWidth(1000);
		
		this.hbxFilter = new HBox();
		this.hbxFilter.setPadding(new Insets(10,10,10,10));
		this.hbxFilter.setSpacing(10);
		this.hbxFilter.getStyleClass().add("hbox");
		//this.hbxFilter.setAlignment(Pos.CENTER);
		this.vbxFilterIcon = new VBox();
		this.vbxFilterIcon.setAlignment(Pos.CENTER_LEFT);
		this.imvFilterIcon = new ImageView(new Image(WikiStageView.class.getResourceAsStream("/icons/32x32/filter.png")));
		this.tbpGender = new TitledBorderPane();
		this.tbpGender.setStyle("-fx-content-display: top;" +
                                "-fx-border-color: white;" +
			                    "-fx-border-width: 2;");
		this.tbpGender.lblTitle.setStyle("-fx-translate-y: -12; -fx-background-color: #2f4f4f; -fx-translate-x: +12;");
		this.tbpGender.lblTitle.setTextFill(Color.WHITE);
		this.hbxGenderContent = new HBox(10);
		this.tggGender = new ToggleGroup();
		this.rbtMale = new RadioButton("Male");
		this.rbtMale.setToggleGroup(this.tggGender);
		this.rbtMale.setTextFill(Color.WHITE);
		this.rbtFemale = new RadioButton("Female");
		this.rbtFemale.setToggleGroup(this.tggGender);
		this.rbtFemale.setTextFill(Color.WHITE);
		
		this.tbpAge = new TitledBorderPane();
		this.hbxAgeContent = new HBox(10);
		this.tggAge = new ToggleGroup();
		this.rbtYoung = new RadioButton("Young");
		this.rbtYoung.setTextFill(Color.WHITE);
		this.rbtYoung.setToggleGroup(this.tggAge);
		this.rbtMiddle = new RadioButton("Middle");
		this.rbtMiddle.setTextFill(Color.WHITE);
		this.rbtMiddle.setToggleGroup(this.tggAge);
		this.rbtOld = new RadioButton("Old");
		this.rbtOld.setTextFill(Color.WHITE);
		this.rbtOld.setToggleGroup(this.tggAge);
		this.tbpAge.setStyle("-fx-content-display: top;" +
	              "-fx-border-color: white;" +
				  "-fx-border-width: 2;");
			this.tbpAge.lblTitle.setStyle("-fx-translate-y: -12; -fx-background-color: #2f4f4f; -fx-translate-x: +12;");
			this.tbpAge.lblTitle.setTextFill(Color.WHITE);
		

		//######################################################################
		
		//### Generate content wiki-character ##################################
		
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
        	
        	ImagePattern imgPat = null;
        	
        	if(curCharacter.getWikiImage() == null) {
        		System.out.println("Image Null");
        	}
        	else {
        		imgPat = new ImagePattern(Utils.getScaledInstance(curCharacter.getWikiImage(), 90, 90, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
        	}
        	//ImagePattern imgPat = new ImagePattern(Utils.getScaledInstance(curCharacter.getWikiImage(), 90, 90, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
        	//ImagePattern imgPat = new ImagePattern(Utils.getScaledInstance(new Image(GlobalReferences.IMAGES_PATH + "wiki/homer_simpson.png"), 90, 90, RenderingHints.VALUE_INTERPOLATION_BICUBIC, 0.80, true));
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
    		if(curCharacter.getNickname() == null) {
    			lblName = new Label(curCharacter.getName());
    		}
    		else if(!curCharacter.getNickname().equals("")) {
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
        
	}
			
	//Method that structure (add components to their parent node) the gui-components:
	private void structureComponents() {
		
		
		this.hbxSearchBar.getChildren().addAll(this.imvSearchIcon, this.txfSearchField);
		
		this.vbxFilterIcon.getChildren().add(this.imvFilterIcon);
		this.hbxGenderContent.getChildren().addAll(this.rbtMale, this.rbtFemale);
		this.tbpGender.setTitleText("Gender");
		this.tbpGender.setContent(this.hbxGenderContent);
		
		this.hbxAgeContent.getChildren().addAll(this.rbtYoung, this.rbtMiddle, this.rbtOld);
		this.tbpAge.setTitleText("Age");
		this.tbpAge.setContent(this.hbxAgeContent);
        
		this.hbxFilter.getChildren().addAll(this.vbxFilterIcon, this.tbpGender, new Group(), this.tbpAge);
		
		this.vbxTopBar.getChildren().addAll(this.hbxSearchBar, this.hbxFilter);
		
		this.bdpRootPane.setTop(this.vbxTopBar);
		this.scpContentPane.setContent(this.vbxContentPane);
		this.bdpRootPane.setCenter(this.scpContentPane);
	}
			
	//Method that initialize the stage (window) settings:
	private void initStage(WikiStageResources res) {
				
		this.scene = new Scene(this.bdpRootPane, 750, 750);
		this.scene.getStylesheets().add(WikiStageView.class.getResource("WikiStageCSS.css").toExternalForm());
		this.setScene(this.scene);
				
		this.getIcons().addAll(res.stageIcon16x16);
				
		
	}

//##########################################################################################################################################
}
//### EOF ##################################################################################################################################