package helloworld;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava3 {

   public static void main(String[] args) {
      JFrame frame = new JFrame("HelloJava3");
      frame.add(new HelloComponent3("Hello, Java"));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300,300);
      frame.setVisible(true);
   }//end main()
}//end HelloJava3

class HelloComponent3 extends JComponent
    implements MouseMotionListener, ActionListener {

   String message;
   int messageX = 125, messageY = 95;
   
   JButton theButton;

   int colorIndex;
   static Color[] someColors = {
      Color.black, Color.red, Color.green, Color.blue, Color.magenta}; 
   
   public HelloComponent3(String message) {
      this.message = message;
      theButton = new JButton("Change Color");
      setLayout(new FlowLayout());
      add(theButton);
      theButton.addActionListener(this);
      addMouseMotionListener(this);
   }//end HelloComponent3 Constructor

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

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == theButton) {
         changeColor();
      }
   }

   synchronized private void changeColor() {
      if (++colorIndex == someColors.length) {
         colorIndex = 0;
      }
      setForeground(currentColor());
      repaint();
   }

   synchronized private Color currentColor() {
      return someColors[colorIndex];
   }
}
