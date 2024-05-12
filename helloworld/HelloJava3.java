package helloworld;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava3 {

   public static void main(String[] args) {
      JFrame frame = new JFrame("HelloJava3");
      //frame.add(new HelloComponent3("Hello, Java"));
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
   }
}
