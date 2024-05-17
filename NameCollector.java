import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class NameCollector extends JFrame{
   JFrame baseFrame;
   JLabel nameFieldLabel;
   JTextField nameTextField;
   
   public NameCollector() {
      baseFrame = new JFrame("Name Collector");
      this.setLayout(new FlowLayout());
      nameFieldLabel = new JLabel("Name: ");
      nameTextField = new JTextField(30);
      this.add(nameFieldLabel);
      this.add(nameTextField);
   }

   public String getName() {
      return nameTextField.getText();
   }

   public void paintComponent(Graphics g) {
      g.drawString(this.getName(), 125, 95);
   }
   
   
   public static void main(String[] args) {
      /* 
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please input a series of characters");
      String newName = scanner.nextLine();
      System.out.println("You enetered " + newName);
      scanner.close();
      */
      NameCollector newDemo = new NameCollector();
      newDemo.setSize(500, 500);
      newDemo.setVisible(true);
      newDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      while (true) {
         newDemo.repaint();
      }
      
      
   }

}
