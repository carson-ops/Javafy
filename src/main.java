import java.awt.*;
import javax.swing.*;


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
        JButton psbutton = new JButton("Pause");
        JButton rsbutton = new JButton("Resume");

        JPanel toppanel = new JPanel();
        JButton audiobutton = new JButton("Select Audio");

        bottompanel.add(psbutton);
        bottompanel.add(rsbutton);
        toppanel.add(audiobutton);

        frame.add(bottompanel, BorderLayout.SOUTH); // push button to bottom
        frame.add(toppanel, BorderLayout.NORTH);

        // making the frame visible
        frame.setVisible(true);
    }

    static void GrabAudio(String audiofile) {

    }
}