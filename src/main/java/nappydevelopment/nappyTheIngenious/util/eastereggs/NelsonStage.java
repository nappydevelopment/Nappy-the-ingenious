package nappydevelopment.nappyTheIngenious.util.eastereggs;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import javafx.scene.image.Image;
import java.awt.*;


public class NelsonStage extends Stage {

    private int counter;
    int width = 490;
    int height = 490;
    private Scene scene;
    private BorderPane bdpRootPane;
    private ImageView imvNelson;
    private Image imgNelsonR;
    private Image imgNelsonL;

    public static NelsonStage createNewNelson() {
        return new NelsonStage(1);
    }

    NelsonStage(int timesOpened) {
        this.counter = timesOpened;
        initComponents();
        structureComponents();
        initStage();

        try {
            new SoundPlayer("haha");
        }catch (Exception e){
            System.out.println("Sound won't play on Travis!");
        }finally {
            this.setAlwaysOnTop(true);
            this.show();
        }
    }

    private void initComponents() {
        this.bdpRootPane = new BorderPane();
        this.imgNelsonR = new Image(GlobalReferences.IMAGES_PATH + "general/NelsonEasterEggR.png");
        this.imgNelsonL = new Image(GlobalReferences.IMAGES_PATH + "general/NelsonEasterEggL.png");
        if(Math.random()<0.5){
            imvNelson = new ImageView(imgNelsonL);
        }else {
            this.imvNelson = new ImageView(imgNelsonR);
        }
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
        try {
            this.setX(Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - width) + 1);
            this.setY(Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - height) + 1);
        } catch (java.awt.HeadlessException e){
            System.out.println("This is a Nelson Exception!");
        }
        this.setOnCloseRequest(new EventHandler<javafx.stage.WindowEvent>() {
            @Override
            public void handle(javafx.stage.WindowEvent event) {
                exitForm();
            }
        });

    }

    private void exitForm() {
        if (counter < 3) {
            new NelsonStage(counter + 1);
            new NelsonStage(counter + 1);
        }
    }
}
