import java.awt.*;
import javax.swing.*;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// Main class
class Main {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Actually closes the program instead of staying open forever
        frame.setSize(900, 600); // w x h

        JPanel bottompanel = new JPanel();
        JButton psbutton = new JButton("Pause"); // mPlayer.play();
        JButton rsbutton = new JButton("Play"); // mPlayer.pause();

        JPanel toppanel = new JPanel();
        JButton audiobutton = new JButton("Select Audio");
        // TODO: Listen for button press -> GrabAudio() -> Media loaded & Media player ready

        bottompanel.add(psbutton);
        bottompanel.add(rsbutton);

        toppanel.add(audiobutton);

        frame.add(bottompanel, BorderLayout.SOUTH); // push button to bottom
        frame.add(toppanel, BorderLayout.NORTH);

        // making the frame visible
        frame.setVisible(true);
    }

    static void GrabAudio() {
        // TODO: "Select Audio" pressed -> File explorer window pops up (certain extensions allowed) -> grab file path.
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog();

        //Media med = new Media(getClass().getResource(fc).toExternalForm());
        //MediaPlayer mPlayer = new MediaPlayer(med);
    }

}