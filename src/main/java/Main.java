// TODO: Add Image in center of GUI from Audio image
// TODO: Change activelbl to, "Song Ended" after song is over
// TODO: Add audio volume slider
// TODO: Add Audio time tracker

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javafx.application.Platform;


// Main class
class Main {

    private JButton audiobutton; // using variable in more than one method
    private JLabel currentsong;
    private JLabel activelbl = new JLabel("");
    private File file;

    AudioPlayer audioplayer = new AudioPlayer();


    public void initUI() { // Can't use main since it's a static method
        // Creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Actually closes the program instead of staying open forever
        frame.setSize(900, 600); // w x h

        JPanel bottompanel = new JPanel(); // bottom of screen
        JButton psbutton = new JButton("Pause"); // mPlayer.play();
        JButton rsbutton = new JButton("Play"); // mPlayer.pause();

        psbutton.addActionListener(e -> {
            audioplayer.pause();
            if (file != null){
                activelbl.setText("| Song Paused.");
            }
        });

        rsbutton.addActionListener(e -> {
            audioplayer.play();
            if (file != null) {
                activelbl.setText("| Song Playing!");
            }
        });

        
        JPanel toppanel = new JPanel(); // top of screen
        audiobutton = new JButton("Select Audio");

        audiobutton.addActionListener(e -> OpenDialog());

        JPanel midpanel = new JPanel(); // middle of screen
        currentsong = new JLabel("No Song Picked."); // NOTE: don't redeclare fields, just assign them | stumped me when I called JLabel before current song
        activelbl = new JLabel("| Not Playing.");

        bottompanel.add(psbutton);
        bottompanel.add(rsbutton);

        toppanel.add(audiobutton);

        midpanel.add(currentsong);
        midpanel.add(activelbl);

        frame.add(bottompanel, BorderLayout.SOUTH); // push button to bottom
        frame.add(toppanel, BorderLayout.NORTH);
        frame.add(midpanel, BorderLayout.CENTER);

        // making the frame visible 
        frame.setVisible(true);
    }

    public void OpenDialog() { // button component
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filters = new FileNameExtensionFilter("Audio Files","mp3", "mp4", "wav"); // Switched FileFilter -> FileNameExtensionFilter for .getExtensions()
        fc.setFileFilter(filters); // applies filters variable

        int result = fc.showDialog(audiobutton, "Pick Song");

        if (result == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile(); // path to file | Undeclared File because it creates a new local variable, which inturns keeps file variable in main null ):
            String name = file.getName().toLowerCase();
            boolean matches = false;   
            
            for (String filter : filters.getExtensions()) { // equiv of for filter in filters in python
                if (name.endsWith("." + filter)) { // could probably get away with contains instead of endsWith
                    matches = true;
                    break;
                }
            }

            if (matches) {
                currentsong.setText("Current Song: " + name);
                audioplayer.load(file);
                audioplayer.play();
                activelbl.setText("| Song Playing!");
            } else if (!matches) {
                currentsong.setText("File Extension not Supported");
                file = null; // updating check on pause and play button
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

        Platform.startup(() -> {
            
        });
        new Main().initUI();
    }

}