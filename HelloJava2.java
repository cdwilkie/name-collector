import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame ("hellojava2");
        frame.add(new HelloComponent2("Hello, Java!"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        
    }// end main
}

class HelloComponent2 extends JComponent
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

