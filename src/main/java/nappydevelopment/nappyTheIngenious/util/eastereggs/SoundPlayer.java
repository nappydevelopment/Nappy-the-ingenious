package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import nappydevelopment.nappyTheIngenious.GlobalReferences;

import java.net.URI;
import java.net.URISyntaxException;


public class SoundPlayer {

    public SoundPlayer(String str){
        try {
            String bip = Thread.currentThread().getContextClassLoader().getResource(GlobalReferences.SOUND_PATH + str + ".mp3").toURI().toString();
            Media hit = new Media(bip);
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
