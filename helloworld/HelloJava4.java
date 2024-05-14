package helloworld;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloJava4");
        frame.add(new HelloComponent4("Hello, Java!"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

class HelloComponent4 extends JComponent
     implements MouseMotionListener, ActionListener, Runnable {
    
    String theMessage;
    int messageX = 125, messageY = 95; // Starting coordinates of message
    JButton theButton;

    int colorIndex;
    static Color[] someColors = {
        Color.black, Color.red, Color.green, Color.blue, Color.magenta};

    boolean blinkState;

    public HelloComponent4(String message) {
        theMessage = message;
        theButton = new JButton("Change Color");
        setLayout(new FlowLayout());
        add(theButton);
        theButton.addActionListener(this);
        addMouseMotionListener(this);
        Thread t = new Thread(this);
        t.start();
    }//end constructor

    public void paintComponent(Graphics g) {
        g.setColor(blinkState ? getBackground() : currentColor());
        g.drawString(theMessage, messageX, messageY);
    }//end paintComponent()

    public void mouseDragged(MouseEvent e) {
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }//end mouseDragged()

    public void mouseMoved(MouseEvent e) {
        //empty
    }//end mouseMoved()

    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == theButton) {
            changeColor();
        }//end if button clicked
    }//end actionPerformed()

    synchronized private void changeColor() {
        if (++colorIndex == someColors.length) {
            colorIndex = 0;
        }
        setForeground(currentColor());
        repaint();
    }//end changeColor()

    synchronized private Color currentColor() {
        return someColors[colorIndex];
    }//end currentColor()

    public void run() {
        try {
            while(true) {
                blinkState = !blinkState;
                repaint();
                Thread.sleep(300);
            }
        }//end try
        catch (InterruptedException ie) {
            //empty
        }//end catch
     }


}
