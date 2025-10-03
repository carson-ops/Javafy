import java.awt.*;
import javax.swing.*;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// Main class
class Main {

    private JButton audiobutton; // using variable in more than one method


    public void initUI() { // Can't use main since it's a static method
        // Creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Actually closes the program instead of staying open forever
        frame.setSize(900, 600); // w x h

        JPanel bottompanel = new JPanel();
        JButton psbutton = new JButton("Pause"); // mPlayer.play();
        JButton rsbutton = new JButton("Play"); // mPlayer.pause();

        
        JPanel toppanel = new JPanel();

        JButton audiobutton = new JButton("Select Audio");
        audiobutton.addActionListener(e -> OpenDialog());
        // TODO: Listen for button press -> GrabAudio() -> Media loaded & Media player ready

        bottompanel.add(psbutton);
        bottompanel.add(rsbutton);

        toppanel.add(audiobutton);


        frame.add(bottompanel, BorderLayout.SOUTH); // push button to bottom
        frame.add(toppanel, BorderLayout.NORTH);

        // making the frame visible
        frame.setVisible(true);
    }

    public void OpenDialog() { // button component
        final JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(audiobutton);
    }

    public static void main(String[] args)
    
    {
        /*JButton audiobutton = new JButton("Select Audio");
        audiobutton.addActionListener(e -> {
            final JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(audiobutton);
        }); */ // Man oh man, I decided to make a non-static method to reference OpenDialog even though I could've done the comment above -_-
               // Stil allows me to work in the OpenDialog method which helps with organization

        new Main().initUI();
    }

}