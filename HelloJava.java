
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
import javax.swing.JFrame;

public class HelloJava{
    public static void main(String[] args) {

    
        JFrame helloFrame = new JFrame("Hello, Java!");
        helloFrame.setSize(300, 300);
        helloFrame.setVisible(true);
   

    /*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    */
    }
    /*
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Frame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    */
}