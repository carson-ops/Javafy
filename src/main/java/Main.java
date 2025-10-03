import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// Main class
class Main {

    private JButton audiobutton; // using variable in more than one method
    private JLabel currentsong;


    public void initUI() { // Can't use main since it's a static method
        // Creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Actually closes the program instead of staying open forever
        frame.setSize(900, 600); // w x h

        JPanel bottompanel = new JPanel(); // bottom of screen
        JButton psbutton = new JButton("Pause"); // mPlayer.play();
        JButton rsbutton = new JButton("Play"); // mPlayer.pause();

        
        JPanel toppanel = new JPanel(); // top of screen
        JButton audiobutton = new JButton("Select Audio");

        audiobutton.addActionListener(e -> OpenDialog());
        // TODO: Listen for button press -> GrabAudio() -> Media loaded & Media player ready

        JPanel midpanel = new JPanel(); // middle of screen
        currentsong = new JLabel("No Song Picked."); // NOTE: don't redeclare fields, just assign them | stumped me when I called JLabel before current song

        bottompanel.add(psbutton);
        bottompanel.add(rsbutton);

        toppanel.add(audiobutton);

        midpanel.add(currentsong);

        frame.add(bottompanel, BorderLayout.SOUTH); // push button to bottom
        frame.add(toppanel, BorderLayout.NORTH);
        frame.add(midpanel, BorderLayout.CENTER);

        // making the frame visible 
        frame.setVisible(true);
    }

    public void OpenDialog() { // button component
        final JFileChooser fc = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("MP3 File","mp3", "MP4 File", "mp4", "WAV File", ".wav");
        fc.setFileFilter(filter);
        int result = fc.showDialog(audiobutton, "Pick Song");

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            if (file == null) {
                currentsong.setText("No Song Picked! test"); 
            } else {
                currentsong.setText("Song Playing: " + file);
            }
             
        }
    }

    public static void main(String[] args) {

        /*JButton audiobutton = new JButton("Select Audio");
        audiobutton.addActionListener(e -> {
            final JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(audiobutton);
        }); */ // Man oh man, I decided to make a non-static method to reference OpenDialog even though I could've done the comment above -_-
               // Stil allows me to work in the OpenDialog method which helps with organization

        new Main().initUI();
    }

}