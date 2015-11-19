package nappydevelopment.nappy_the_ingenious.gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.GlobalReferences;

public class StatisticStage extends Stage {
	
	Scene scene;
	BorderPane bdpRoot;
	
	public StatisticStage() {
		this.bdpRoot = new BorderPane();
		this.scene = new Scene(this.bdpRoot, 600, 500);
		this.setScene(this.scene);
		this.setTitle("Nappy, the ingenious - Statistik");
		this.getIcons().add(new Image(GlobalReferences.ICONS_PATH + "16x16/statistic.png"));
		this.setResizable(true);
	}
}
