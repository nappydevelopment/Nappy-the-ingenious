package nappydevelopment.nappy_the_ingenious;

//### IMPORTS ##############################################################################################################################

import javafx.application.Application;
import javafx.stage.Stage;
import nappydevelopment.nappy_the_ingenious.gui.MainStage;

import java.io.File;

public class Main extends Application {

    public static final String ICONS_PATH = "/icons/";
    public static final String IMAGES_PATH = "/images/";
    public static final String HTML_PATH = new File(new File("").getAbsolutePath() + "\\src\\main\\html\\").toURI().toString();
    public static final String FONTS_PATH = new File(new File("").getAbsolutePath() + "\\res\\fonts\\").toURI().toString();

//### PRIVATE COMPONENTS ###################################################################################################################

    //Primary-stage (represent the Window like JFrame in Swing):
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {primaryStage = new MainStage();
    }

    //Main-method:
    public static void main(String[] args) {
        launch(args);
    }


}
//### EOF ##################################################################################################################################