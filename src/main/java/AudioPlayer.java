import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class AudioPlayer {

    private MediaPlayer mediaplayer;


    public void load(File file) {
        String uri = file.toURI().toString(); // C:/.../.../.../... -> file:/C:/.../.../.../...
        Media media = new Media(uri); // created to supplement mediaplayer
        mediaplayer = new MediaPlayer(media);
    }

    public void pause() {
        if (mediaplayer != null) { // make sure mediplayer has something
            mediaplayer.pause();
        }
    }

    public void stop() {
        if (mediaplayer != null) {
            mediaplayer.stop();
        }
    }

    public void play() {
        if (mediaplayer != null){
            mediaplayer.play();
        }
    }
}
