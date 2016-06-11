package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import nappydevelopment.nappyTheIngenious.GlobalReferences;

import java.awt.*;

/**
 * Created by Marc on 30.05.2016.
 */
public class NappyStage extends Stage {

    int width = 590;
    int height = 800;
    private Scene scene;
    private BorderPane bdpRootPane;
    private BorderPane bdpImagePane;
    private BorderPane bdpTextPane;
    private ImageView imvNappy;
    private Image nappyImg;
    private javafx.scene.control.TextArea textArea;
    SoundPlayer soundPlayer;


    NappyStage() {
        initComponents();
        structureComponents();
        initStage();
        soundPlayer = new SoundPlayer("think", this);
        this.setAlwaysOnTop(true);
        this.show();
    }

    private void initComponents() {
        this.bdpRootPane = new BorderPane();
        this.bdpImagePane = new BorderPane();
        this.bdpTextPane = new BorderPane();
        this.nappyImg = new Image(GlobalReferences.IMAGES_PATH + "general/nappy.png");
        this.imvNappy = new ImageView(nappyImg);

        this.textArea = new TextArea();
        this.textArea.setText("\"Nappy - the Ingenious\"\r\n" +
                "Nappy ist ein Genie in allen Fragen, die die Simpsons betreffen! \r\n " +
                "Er kennt alle Charaktere der Serie und ist in der Lage, diesee anhand einfacher \"Ja-Nein\" Fragen zu erraten.\r\n" +
                "Sein unermessliches Wissen bezieht dieser clevere Kopf über die Windel, welche sein Haupt ziert. \r\nSie ist sein Ein und Alles " +
                "Er zieht seine Windel niemals aus und wird dies auch in Zukunft nicht tun. \r\n Somit wird es schwierig, ihn überhaupt zu schlagen!\r\n" +
                "Bist du in der Lage Nappy zu schlagen? Dann versuch doch dein Glück!");
        this.textArea.setEditable(false);

    }

    private void structureComponents() {
        this.bdpRootPane.setTop(bdpImagePane);
        this.bdpRootPane.setCenter(bdpTextPane);

        this.bdpImagePane.setTop(this.imvNappy);
        this.bdpTextPane.setCenter(this.textArea);
    }

    private void initStage() {
        this.scene = new Scene(this.bdpRootPane, width, height);
        this.setScene(this.scene);
        this.setResizable(false);
        this.getIcons().add(new Image(GlobalReferences.ICONS_PATH + "16x16/icon.png"));
        //Set owner and modality by the first start of the stage:
        this.initModality(Modality.APPLICATION_MODAL);
        this.setOnCloseRequest(new EventHandler<javafx.stage.WindowEvent>() {
            @Override
            public void handle(javafx.stage.WindowEvent event) {
                exitForm();
            }
        });

    }

    private void exitForm() {
        soundPlayer.stopCurrentTune();
    }

}