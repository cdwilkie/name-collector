import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava2 {

    public static void main(String[] args) {
        //Create JFrame
        //Add HelloCOmponent2 to JFrame
        //show JFrame
    }
}

class HelloComponent2 extends JFrame
    implements MouseMotionListener {

    String message;
    int messageX = 125, messageY = 95;

    public HelloComponent2(String message) {
        this.message = message;
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        g.drawString(message, messageX, messageY);
    }

    public void mouseDragged(MouseEvent e) {
        messageX = e.getX();
        messageY = e.getY();

        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        
    }


}

