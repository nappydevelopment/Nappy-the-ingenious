//### MainStage.java #######################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui;

//### IMPORTS ##############################################################################################################################

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Main;
import nappydevelopment.nappy_the_ingenious.data.WikiCharacter;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import nappydevelopment.nappy_the_ingenious.util.MatchInformation;


/* MainStage [class]: Represent the main window of the application *//**
 * 
 * @author Manuel Bothner
 *
 */
public class MainStage extends Stage {
	
//### PRIVATE ATTRIBUTES ###################################################################################################################	
	
	private List<WikiCharacter> characters;
	
	private Stage statisticStage;	//Statistic-Window!
	private Stage settingsStage;	//Settings-Window!
	private Stage helpStage;		//Help-Window!
	private Stage wikiStage;		//Wiki-Window!
	private Stage infoStage;		//Info-Window!
	
//### PRIVATE COMPONENTS ###################################################################################################################	

	//Start scene that shows the program-start-view:
	private Scene startScene;
	
	//Root pane (container) that contains all GUI-components:
	private BorderPane bdpRootPane;
	
	//### Menu-Bar-Components: #####################################################################
	private MenuBar mnbMenuBar;
	//First Menu:
	private Menu mnuGame;
	private MenuItem mniNewGame;
	private MenuItem mniAbrotGame;
	private SeparatorMenuItem smiGame1;
	private MenuItem mniStatistic;
	private MenuItem mniSettings;
	private SeparatorMenuItem smiGame2;
	private MenuItem mniExit;
	//Second Menu:
	private Menu mnuHelp;
	private MenuItem mniHelp;
	private MenuItem mniWiki;
	private SeparatorMenuItem smiHelp1;
	private MenuItem mniInfo;
	//### Content-Pane-Components: #################################################################
	private GridPane gdpStartViewContentPane;
	
	private Button btnNewGame;
	private Separator sepSVCP1;
	private Button btnStatistic;
	private Button btnWiki;
	private Button btnHelp;
	
	private Scene gameScene;
	
	private HBox hbxAnswerButtons;
	private Button btnAnswerYes;
	private Button btnAnswerNo;
	
	//##################################
	private HBox hbxButtons;
	private GridPane gdpButtons;
	
	private Button btnYes;
	private Button btnNo;
	private Button btnDontKnow;
	
	private EventHandler<ActionEvent> evhActionEvents;
	
//### CONSTRUCTORS #########################################################################################################################
	
	/* Default constructor [constructor]: Default constructor to create a main stage *//**
	 * 
	 */
	public MainStage() {
		this.initEventHandler();
		this.initAttributes();
		this.initComponents();
		this.initStage();
	}
	
//### INITIAL METHODS ######################################################################################################################
	
	private void initEventHandler() {
		
		this.evhActionEvents = new EventHandler<ActionEvent>() {

			@Override
			/* handle [method]: Method that handle the occurred events:*/
			public void handle(ActionEvent e) {
				
				Object src = e.getSource();
				
				if(src == MainStage.this.mniNewGame || src == MainStage.this.btnNewGame) {
					MainStage.this.showGameMode1Scene();
				}
				else if(src == MainStage.this.mniAbrotGame) {
					MainStage.this.showGameAbrotDialog();
				}
				else if(src == MainStage.this.mniStatistic || src == MainStage.this.btnStatistic) {
					MainStage.this.showStatisticStage();
				}
				else if(src == MainStage.this.mniSettings) {
					MainStage.this.showSettingsStage();
				}
				else if(src == MainStage.this.mniExit) {
					Platform.exit();
				}
				else if (src == MainStage.this.mniHelp || src == MainStage.this.btnHelp) {
					MainStage.this.showHelpStage();
				}
				else if(src == MainStage.this.mniWiki || src == MainStage.this.btnWiki) {
					MainStage.this.showWikiStage();
				}
				else if(src == MainStage.this.mniInfo) {
					MainStage.this.showInfoStage();
				}
			}
			
		};
	}
	
	private void initAttributes() {
		this.characters = new LinkedList<WikiCharacter>();
		this.characters.add(new WikiCharacter("Abraham Simpson", "Abe", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/abraham_simpson.png"))));
		this.characters.add(new WikiCharacter("Agnes Skinner", "Mrs. Skinner", "Agnes Skinner ist die Mutter von Seymour Skinner dem Grundschulrektor von Springfield. Sie zeigt in Bezug auf ihren Sohn einen starkten Kontrollzwang und verbietet im jegliche sozialen Kontakte. Zudem behandelt sie ihn als wäre er immernoch ein kleines Kind.", new Image(MainStage.class.getResourceAsStream("/images/wiki/agnes_skinner.png"))));
		this.characters.add(new WikiCharacter("Anthony d'Amico", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/anthony_d'amico.png"))));
		this.characters.add(new WikiCharacter("Apu Nahasapeemapetilon", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/apu_nahasapeemapetilon.png"))));
		this.characters.add(new WikiCharacter("Arnold Pye", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/arnold_pye.png"))));
		this.characters.add(new WikiCharacter("Artie Ziff", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/artie_ziff.png"))));
		this.characters.add(new WikiCharacter("Barney Gumble", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/barney_gumble.png"))));
		this.characters.add(new WikiCharacter("Barry Duffman", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/barry_duffman.png"))));
		this.characters.add(new WikiCharacter("Bart Simpson", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/bart_simpson.png"))));
		this.characters.add(new WikiCharacter("Bernice Hibbert", "", "Bernice Hibbert ist offenbar eine starke Alkoholikerin. Sie muss bei der Polizei einen Film gegen Trunkenheit am Steuer anschauen und fällt in Ohnmacht, als sie liest, dass die Prohibition wieder eingeführt wird. Herheiratet ist sie mit dem Arzt Julius Hibbert.", new Image(MainStage.class.getResourceAsStream("/images/wiki/bernice_hibbert.png"))));
		this.characters.add(new WikiCharacter("Brandine Spuckler", "", "Brandine Spuckler verkörpert zusammen mit ihrem Mann das typische Bild von Hinterwäldlern. Sie ist ungepflegt, Analphabetin und sehr einfältig. Sie hat 50 Kinder und ist mit ihrem eigenen Bruder Cletus verheiratet. Cletus ist offenbar nur der Vater von zwei Kindern.", new Image(MainStage.class.getResourceAsStream("/images/wiki/brandine_spuckler.png"))));
		this.characters.add(new WikiCharacter("Carl Carlson", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/carl_carlson.png"))));
		this.characters.add(new WikiCharacter("Cecile Terwilliger", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/cecile_terwilliger.png"))));	
		this.characters.add(new WikiCharacter("Charles Montgomery Burns", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/charles_montgomery_burns.png"))));
		this.characters.add(new WikiCharacter("Chester J. Lampwick", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/chester_j._lampwick.png"))));
		this.characters.add(new WikiCharacter("Chester Turley", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/chester_turley.png"))));
		this.characters.add(new WikiCharacter("Clancy Bouvier", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/clancy_bouvier.png"))));
		this.characters.add(new WikiCharacter("Clancy Wiggum", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/clancy_wiggum.png"))));
		this.characters.add(new WikiCharacter("Cletus Spuckler", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/cletus_spuckler.png"))));
		this.characters.add(new WikiCharacter("Dewey Largo", "", "Beschreibung", new Image(MainStage.class.getResourceAsStream("/images/wiki/dewey_largo.png"))));
	}
	
	private void initComponents() {
		
		this.bdpRootPane = new BorderPane();
		
		//### Menu-Bar-Components ##################################################################
		this.mnbMenuBar = new MenuBar();
		//First menu:
		this.mnuGame = new Menu("Spiel");
		this.mniNewGame = new MenuItem("Neues Spiel", 
				                        new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/new_game.png"))));
		this.mniNewGame.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.mniAbrotGame = new MenuItem("Spiel abbrechen", 
										new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/abort_game.png"))));
		this.mniAbrotGame.setDisable(true);
		this.mniAbrotGame.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.smiGame1 = new SeparatorMenuItem();
		this.mniStatistic = new MenuItem("Statistik", 
				                         new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/statistic.png"))));
		this.mniStatistic.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.mniSettings = new MenuItem("Einstellungen", 
				                         new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/settings.png"))));
		this.mniSettings.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.smiGame2 = new SeparatorMenuItem();
		this.mniExit = new MenuItem("Beenden", 
									 new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/exit.png"))));
		this.mniExit.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		//Add items to the menu:
		this.mnuGame.getItems().addAll(this.mniNewGame, this.mniAbrotGame, this.smiGame1, this.mniStatistic, this.mniSettings, 
									   this.smiGame2, this.mniExit);
		//Second menu:
		this.mnuHelp = new Menu("Hilfe");
		this.mniHelp = new MenuItem("Spielanleitung", 
									 new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/help.png"))));
		this.mniHelp.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.mniWiki = new MenuItem("Wiki", new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/wiki.png"))));
		this.mniWiki.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.smiHelp1 = new SeparatorMenuItem();
		this.mniInfo = new MenuItem("Info", 
									 new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/info.png"))));
		this.mniInfo.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		//Add items to the menu:
		this.mnuHelp.getItems().addAll(this.mniHelp, this.mniWiki, this.smiHelp1, this.mniInfo);
		
		//Add menus to the menu-bar:
		this.mnbMenuBar.getMenus().addAll(this.mnuGame, this.mnuHelp);
		
		//##########################################################################################
		
		this.gdpStartViewContentPane = new GridPane();
		this.gdpStartViewContentPane.setHgap(0.0);
		this.gdpStartViewContentPane.setVgap(15);
		
		this.btnNewGame = new Button("Neues Spiel");
		this.btnNewGame.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/new_game.png"))));
		this.btnNewGame.setPrefSize(150, 40);
		this.btnNewGame.setAlignment(Pos.BASELINE_LEFT);
		this.btnNewGame.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);

		this.sepSVCP1 = new Separator();
		this.btnStatistic = new Button("Statistik");
		this.btnStatistic.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/statistic.png"))));
		this.btnStatistic.setPrefSize(150, 40);
		this.btnStatistic.setAlignment(Pos.BASELINE_LEFT);
		this.btnStatistic.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.btnWiki = new Button("Wiki");
		this.btnWiki.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/wiki.png"))));
		this.btnWiki.setPrefSize(150, 40);
		this.btnWiki.setAlignment(Pos.BASELINE_LEFT);
		this.btnWiki.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.btnHelp = new Button("Spielanleitung");
		this.btnHelp.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/help.png"))));
		this.btnHelp.setAlignment(Pos.BASELINE_LEFT);
		this.btnHelp.setPrefSize(150, 40);
		this.btnHelp.addEventHandler(ActionEvent.ACTION, this.evhActionEvents);
		
		this.gdpStartViewContentPane.add(this.btnNewGame, 0, 0);
		this.gdpStartViewContentPane.add(this.sepSVCP1, 0, 1);
		this.gdpStartViewContentPane.add(this.btnWiki, 0, 2);
		this.gdpStartViewContentPane.add(this.btnStatistic, 0, 3);
		this.gdpStartViewContentPane.add(this.btnHelp, 0, 4);
		this.gdpStartViewContentPane.setAlignment(Pos.CENTER);
		this.gdpStartViewContentPane.autosize();
		
		//Add menu-bar to the root-pane:
		this.bdpRootPane.setTop(this.mnbMenuBar);
		this.bdpRootPane.setCenter(this.gdpStartViewContentPane);
	}
	
	private void initStage() {
		
		this.startScene = new Scene(this.bdpRootPane, 300, 400);
		this.setScene(this.startScene);
		this.setTitle("Nappy, the ingenious");
		this.getIcons().add(new Image(Main.ICONS_PATH + "16x16/game.png"));
		this.setResizable(true);
		this.show();
		
	}
	
//### PRIVATE METHODS ######################################################################################################################
	
	//### Show other stages (windows) ##########################################
	
	private void showStartScene() {
		this.mniAbrotGame.setDisable(true);
		this.bdpRootPane.setCenter(this.gdpStartViewContentPane);
		this.bdpRootPane.setBottom(null);
	}
	
	private void showGameMode1Scene() {
		
		this.hbxButtons = new HBox();
		this.gdpButtons = new GridPane();
		this.gdpButtons.setPadding(new Insets(10,10,10,10));
	
		//this.gdpButtons.setGridLinesVisible(true);
		this.btnYes = new Button("Ja");
		this.btnYes.setPrefSize(Integer.MAX_VALUE, 40);
		this.btnNo = new Button("Nein");
		this.btnNo.setPrefSize(Integer.MAX_VALUE, 40);
		this.btnDontKnow = new Button("Ich weiß nicht");
		this.btnDontKnow.setPrefSize(Integer.MAX_VALUE, 40);
		
		this.gdpButtons.add(this.btnYes, 0, 0);
		this.gdpButtons.add(this.btnNo, 1, 0);
		this.gdpButtons.add(this.btnDontKnow, 0, 1, 2, 1);
		
		//this.hbxButtons.getChildren().add(this.gdpButtons);
		//this.bdpRootPane = new BorderPane();
		//Add menu-bar to the root-pane:
		//this.bdpRootPane.setTop(this.mnbMenuBar);
		this.bdpRootPane.setCenter(null);
		this.bdpRootPane.setBottom(this.gdpButtons);
		
		//Menu
		this.mniAbrotGame.setDisable(false);
		
		//this.setScene(new Scene(this.bdpRootPane, 300, 400));
		
	}
	
	private void showHelpStage() {
		
		this.helpStage = new HelpStage();
		this.helpStage.show();
	}
	
	private void showWikiStage() {
		
		this.wikiStage = new WikiStage(this.characters);
		
		//Necessary that this stage waits till the wiki stage is closed:
		this.wikiStage.initOwner(this);
		this.wikiStage.initModality(Modality.WINDOW_MODAL);
		
		this.wikiStage.show();
	}
	
	private void showInfoStage() {
		
		this.infoStage = new InfoStage();
		
		//Necessary that this stage waits till the wiki stage is closed:
		this.infoStage.initModality(Modality.WINDOW_MODAL);
		this.infoStage.initOwner(this);
		this.infoStage.show();
	}
	
	private void showStatisticStage() {
		this.statisticStage = new StatisticStage();
		this.statisticStage.show();	
	}
	
	private void showSettingsStage() {
		this.settingsStage = new SettingsStage();
		this.settingsStage.show();
	}
	
	//### Show other scenes (game-screens) #####################################
	
	private void showGameAbrotDialog() {
		
		ButtonType bttCancel = new ButtonType("Abbrechen");
		ButtonType bttApply = new ButtonType("Spiel abbrechen");
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Nappy, the ingenious");
		alert.setHeaderText("Spiel abbrechen?");
		alert.setContentText("Möchten Sie das aktuelle Spiel wirklich abbrechen?");
		alert.getButtonTypes().setAll(bttApply, bttCancel);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == bttApply){
		    this.showStartScene();
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
	}
	
}
//### EOF ##################################################################################################################################