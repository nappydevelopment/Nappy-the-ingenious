//### MainStageView.java #########################################################################################################################

package nappydevelopment.nappy_the_ingenious.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.Main;

//### IMPORTS ##############################################################################################################################

public class MainStageView extends Stage {

//### COMPONENTS ###########################################################################################################################

	//### Content of all views on the main-stage ###################################################
	
	//Scene of the stage:
	Scene startScene;
		
	//Root pane (container) that contains all GUI-components:
	BorderPane bdpRootPane;
		
	//Components of the menu-bar:
	MenuBar mnbMenuBar;
	//First menu:
	Menu mnuGame;
	MenuItem mniNewGame;
	MenuItem mniAbrotGame;
	SeparatorMenuItem smiGame1;
	MenuItem mniStatistic;
	MenuItem mniSettings;
	SeparatorMenuItem smiGame2;
	MenuItem mniExit;
	//Second menu:
	Menu mnuHelp;
	MenuItem mniHelp;
	MenuItem mniWiki;
	SeparatorMenuItem smiHelp1;
	MenuItem mniInfo;
	
	//### Content of the start-view ################################################################

	GridPane gdpStartViewContentPane;
	Button btnNewGame;
	Separator sepSVCP1;
	Button btnStatistic;
	Button btnWiki;
	Button btnHelp;
		
	//### Content of the Gamemode1 View ############################################################
	
	//### Content of the Gamemode1 View ############################################################
	
	
//### CONSTRUCTORS #########################################################################################################################
	
	public MainStageView() {
		initComponents();
		initStage();
	}
	
//### INITAL METHODS #######################################################################################################################
		
	private void initComponents() {
		
		this.bdpRootPane = new BorderPane();
		
		//### Menu-Bar-Components ##################################################################
		this.mnbMenuBar = new MenuBar();
		//First menu:
		this.mnuGame = new Menu("Spiel");
		this.mniNewGame = new MenuItem("Neues Spiel", 
				                        new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/new_game.png"))));
		
		this.mniAbrotGame = new MenuItem("Spiel abbrechen", 
										new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/abort_game.png"))));
		this.mniAbrotGame.setDisable(true);
		this.smiGame1 = new SeparatorMenuItem();
		
		this.mniStatistic = new MenuItem("Statistik");
		this.mniStatistic.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/statistic.png"))));
		
		this.mniSettings = new MenuItem("Einstellungen", 
				                         new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/settings.png"))));
		this.smiGame2 = new SeparatorMenuItem();
		this.mniExit = new MenuItem("Beenden", 
									 new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/exit.png"))));
		//Add items to the menu:
		this.mnuGame.getItems().addAll(this.mniNewGame, this.mniAbrotGame, this.smiGame1, this.mniStatistic, this.mniSettings, 
									   this.smiGame2, this.mniExit);
		//Second menu:
		this.mnuHelp = new Menu("Hilfe");
		this.mniHelp = new MenuItem("Spielanleitung", 
									 new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/help.png"))));
		this.mniWiki = new MenuItem("Wiki", new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/wiki.png"))));
		this.smiHelp1 = new SeparatorMenuItem();
		this.mniInfo = new MenuItem("Info", 
									 new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/16x16/info.png"))));
		//Add items to the menu:
		this.mnuHelp.getItems().addAll(this.mniHelp, this.mniWiki, this.smiHelp1, this.mniInfo);
		
		//Add menus to the menu-bar:
		this.mnbMenuBar.getMenus().addAll(this.mnuGame, this.mnuHelp);
		
		//### Components of the start-view #########################################################
		
		this.gdpStartViewContentPane = new GridPane();
		this.gdpStartViewContentPane.setHgap(0.0);
		this.gdpStartViewContentPane.setVgap(15);
		
		this.btnNewGame = new Button("Neues Spiel");
		this.btnNewGame.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/new_game.png"))));
		this.btnNewGame.setPrefSize(150, 40);
		this.btnNewGame.setAlignment(Pos.BASELINE_LEFT);

		this.sepSVCP1 = new Separator();
		this.btnStatistic = new Button("Statistik");
		this.btnStatistic.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/statistic.png"))));
		this.btnStatistic.setPrefSize(150, 40);
		this.btnStatistic.setAlignment(Pos.BASELINE_LEFT);
		
		this.btnWiki = new Button("Wiki");
		this.btnWiki.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/wiki.png"))));
		this.btnWiki.setPrefSize(150, 40);
		this.btnWiki.setAlignment(Pos.BASELINE_LEFT);
		
		this.btnHelp = new Button("Spielanleitung");
		this.btnHelp.setGraphic(new ImageView(new Image(MainStage.class.getResourceAsStream("/icons/32x32/help.png"))));
		this.btnHelp.setAlignment(Pos.BASELINE_LEFT);
		this.btnHelp.setPrefSize(150, 40);
		
		this.gdpStartViewContentPane.add(this.btnNewGame, 0, 0);
		this.gdpStartViewContentPane.add(this.sepSVCP1, 0, 1);
		this.gdpStartViewContentPane.add(this.btnWiki, 0, 2);
		this.gdpStartViewContentPane.add(this.btnStatistic, 0, 3);
		this.gdpStartViewContentPane.add(this.btnHelp, 0, 4);
		this.gdpStartViewContentPane.setAlignment(Pos.CENTER);
		this.gdpStartViewContentPane.autosize();
		
		//Add menu-bar to the root-pane:
		this.bdpRootPane.setTop(this.mnbMenuBar);
		
	}
	
	private void initStage() {
		this.startScene = new Scene(this.bdpRootPane, 300, 400);
		this.setScene(this.startScene);
		this.setTitle("Nappy, the ingenious");
		this.getIcons().addAll(new Image(Main.ICONS_PATH + "16x16/icon.png"),
							   new Image(Main.ICONS_PATH + "32x32/icon.png"),
							   new Image(Main.ICONS_PATH + "48x48/icon.png"),
							   new Image(Main.ICONS_PATH + "64x64/icon.png"),
							   new Image(Main.ICONS_PATH + "128x128/icon.png"),
							   new Image(Main.ICONS_PATH + "256x256/icon.png"));
		this.setResizable(true);
	}
	
	//### PUBLIC METHODS #######################################################################################################################
	
	public void showStartView() {
		
		//Set the start-view-pane to the root-pane:
		this.bdpRootPane.setCenter(this.gdpStartViewContentPane);
		//Show the stage:
		this.show();
	}
	
	public void showGamemode1View() {
		
	}
}
//### EOF ##################################################################################################################################