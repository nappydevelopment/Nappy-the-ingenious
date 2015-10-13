package application.stages;

import application.Main;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelpStage extends Stage {
	
	private Scene scene;
    private final WebView browser;
    private final WebEngine webEngine; 
    
    
    public HelpStage() {
        this.browser = new WebView();
        this.webEngine = browser.getEngine();
        webEngine.load(Main.HTML_PATH + "instruction.html");
   
        
		this.scene = new Scene(this.browser, 600, 500);
		this.setScene(this.scene);
		this.setTitle("Nappy, the ingenious - Spielanleitung");
		this.getIcons().add(new Image(Main.ICONS_PATH + "16x16/game.png"));
		this.setResizable(true);
		this.show();
    }
	
}
