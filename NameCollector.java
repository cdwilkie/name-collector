import java.util.Scanner;



/** NameCollector is a program that prompts the user for
 * information: Name (string), age (int), and height (double).
 * Information is the output to screen 
 */

public class NameCollector {
   
   private String thePrompt, userName, outputMessage;
   private int userAge;
   private double userInches;

   public NameCollector() {
      setPrompt();
      userName = "";
      userAge = 0;
      userInches = 0.0;
   }

   public void setPrompt() {
      thePrompt = "Welcome!\nPlease enter your: <Name>, <Age>, and <Height-Inches>";
   }
   
   public String getPrompt() {
      return thePrompt;
   }

   public void showPrompt() {
      System.out.println(thePrompt);
   }

   public void setUserName(String inputName) {
      userName = inputName;
   }

   public String getUsername() {
      return userName;
   }

   public void setAge(int inputAge) {
      userAge = inputAge;
   }

   public int getAge() {
      return userAge;
   }

   public void setInches(double inputInches) {
      userInches = inputInches;
   }

   public double getInches() {
      return userInches;
   }

   public void setOutputMessage() {
      outputMessage = "You entered:\n\tName:\t" + userName;
      outputMessage += "\n\tAge:\t" + userAge;
      outputMessage += "\n\tInches:\t" + userInches;
   }

   public String getOutputMessage() {
      return outputMessage;
   }
   
   public static void main(String[] args) {
      //Scanner scanner = new Scanner(System.in);
      NameCollector newDemo = new NameCollector();
      newDemo.showPrompt();

      try (Scanner scanner = new Scanner(System.in)) 
      {
         newDemo.setUserName(scanner.next());
         newDemo.setAge(scanner.nextInt());
         newDemo.setInches(scanner.nextDouble());
         newDemo.setOutputMessage();
         System.out.println(newDemo.getOutputMessage());
      }
      catch (Exception e) {
         System.out.println("Something wrong occured");
      }

      
      
      
   }

}