package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import nappydevelopment.nappyTheIngenious.GlobalReferences;

/**
 * Created by Marc on 17.05.2016.
 */
public class NappyStage extends Stage {
    int width = 490;
    int height = 490;
    private Scene scene;
    private BorderPane bdpRootPane;
    private ImageView imvNelson;
    private Image imgNappy;

    NappyStage() {
        initComponents();
        structureComponents();
        initStage();
        new SoundPlayer("haha");
        this.setAlwaysOnTop(true);
        this.show();
    }

    private void initComponents() {
        this.bdpRootPane = new BorderPane();

        this.imgNappy = new Image(GlobalReferences.IMAGES_PATH + "general/NelsonEastereggRechts.png");

    }

    private void structureComponents() {
        this.bdpRootPane.setCenter(this.imvNelson);
    }

    private void initStage() {
        this.scene = new Scene(this.bdpRootPane, width, height);
        this.setScene(this.scene);
        this.setResizable(false);
        this.getIcons().add(new Image(GlobalReferences.ICONS_PATH + "16x16/icon.png"));
        //Set owner and modality by the first start of the stage:
        this.initModality(Modality.APPLICATION_MODAL);
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(javafx.stage.WindowEvent event) {
                exitForm();
            }
        });

    }

    private void exitForm() {

    }
}
