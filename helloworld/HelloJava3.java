package helloworld;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates a window with an interactive button which changes
 * the displayed message's color. Color cycles through index
 * of specififed colors.
 */
public class HelloJava3 {

   /**
    * Creates a JFrame and adds the custom HelloJava3 component.
    * @param args Command line arguments, not utitlized
    */
   public static void main(String[] args) {
      JFrame frame = new JFrame("HelloJava3");
      frame.add(new HelloComponent3("Hello, Java"));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300,300);
      frame.setVisible(true);
   }//end main()
}//end HelloJava3

/**
 * Extends JComponent to create a label with a message that appears in 
 * frame. Text can be dragged with mouse by use of mouselistener. Also has
 * JButton that changes color of text. 
 *  
 */
class HelloComponent3 extends JComponent
    implements MouseMotionListener, ActionListener {

   String message;
   int messageX = 125, messageY = 95; // Starting location
   
   JButton theButton;

   int colorIndex;
   // list of desired colors
   static Color[] someColors = {
      Color.black, Color.red, Color.green, Color.blue, Color.magenta}; 
   
   // Constructor  
   public HelloComponent3(String message) {
      this.message = message;
      theButton = new JButton("Change Color");
      setLayout(new FlowLayout());
      add(theButton);
      theButton.addActionListener(this);
      addMouseMotionListener(this);
   }//end HelloComponent3 Constructor

   //Redraw message
   public void paintComponent(Graphics g) {
      g.drawString(message, messageX, messageY);
   }//end paintComponent()

   //Collect message location with mouse drag and redraw
   public void mouseDragged(MouseEvent e) {
      messageX = e.getX();
      messageY = e.getY();
      repaint();
   }//end mouseDragged()

   //Not used
   public void mouseMoved(MouseEvent e) {

   }//end mouseMoved()

   //Update color when button is clicked
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == theButton) {
         changeColor();
      }//end if button clicked
   }//end actionPerformed()

   // Update text color
   synchronized private void changeColor() {
      if (++colorIndex == someColors.length) {
         colorIndex = 0;
      }//end if arrayindex oob
      setForeground(currentColor());
      repaint();
   }//end changeColor()

   // Retrieve current color of text
   synchronized private Color currentColor() {
      return someColors[colorIndex];
   }//end currentColor()
}//end HelloComponent3
