import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates and makes visible a JFrame window.
 * 
 */
public class HelloJava2 {

/**
 * Creates the JFrame titled 'hellojava2' and adds the
 * instantiated HelloComponent2 to the frame.  Frame is set to 
 * exit on close and has default dimensions 300x300.
 * @param args holds command-line arguments
 */
    public static void main(String[] args) {
        JFrame frame = new JFrame ("hellojava2");
        frame.add(new HelloComponent2("Hello, Java!"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        
    }// end main
}

/**
 * Creates a mouse-draggable string component.
 */
class HelloComponent2 extends JComponent
    implements MouseMotionListener {

    String message;
    int messageX = 125, messageY = 95;

 /**
  * Constructor accepts string for message.
  * @param message stores message to be used for interactive text
  */   
    public HelloComponent2(String message) {
        this.message = message;
        addMouseMotionListener(this);
    }
/**
 * Override that draws the message at the x and y coordinates
 * @param g Graphics area for drawing
 */
    public void paintComponent(Graphics g) {
        g.drawString(message, messageX, messageY);
    }

/**
 * Collects the x and y coordinate of the mouse cursor when dragged
 * then updates the image by repainting
 */
    public void mouseDragged(MouseEvent e) {
        messageX = e.getX();
        messageY = e.getY();

        repaint();
    }

/**
 * Not currently implemented. Will detail behavior
 * for detected mouse movement.
 */    
    public void mouseMoved(MouseEvent e) {

    }


}

