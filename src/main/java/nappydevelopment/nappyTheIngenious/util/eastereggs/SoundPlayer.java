package nappydevelopment.nappyTheIngenious.util.eastereggs;

import com.sun.media.jfxmedia.MediaException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import nappydevelopment.nappyTheIngenious.GlobalReferences;
import java.net.URISyntaxException;

public class SoundPlayer {

    MediaPlayer mediaPlayer;

    public SoundPlayer(String str){
        try {
            String bip = Thread.currentThread().getContextClassLoader().getResource(GlobalReferences.SOUND_PATH + str + ".mp3").toURI().toString();
            Media hit = new Media(bip);
            mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public SoundPlayer(String str, NappyStage stage){
        try {
            String bip = Thread.currentThread().getContextClassLoader().getResource(GlobalReferences.SOUND_PATH + str + ".mp3").toURI().toString();
            Media hit = new Media(bip);
            mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void stopCurrentTune(){
        try {
            mediaPlayer.stop();
        } catch (Exception e) {
        e.printStackTrace();
    }

    }

}
