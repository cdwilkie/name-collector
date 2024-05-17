import java.util.Scanner;



/** NameCollector is a program that prompts the user for
 * information: Name (string), age (int), and height (double).
 * Information is the output to screen 
 */

public class NameCollector {
   private String startPrompt, userName;
   private int userAge;
   private double userInches;
   private Scanner scanner;

   public NameCollector() {
      setPrompt();
      showPrompt();
      scanner = new Scanner(System.in);
      userName = scanner.next();
      userAge = scanner.nextInt();
      userInches = scanner.nextDouble();
      showResults();

      

   }

   private void setPrompt() {
      this.startPrompt = "Welcome! Please enter your name, age, and height (inches)";
   }

   private void showPrompt() {
      System.out.println(this.startPrompt);
   }

   public void showResults() {
      String outputMessage = "The information you provided\n";
      outputMessage += "\tName:\t" + userName + "\n";
      outputMessage += "\tAge:\t" + userAge + "\n";
      outputMessage += "\tHeight:\t" + userInches + "\n";
      System.out.println(outputMessage);
   }
  
  
  
  
  
  
  
  
   public static void main(String[] args) {
      NameCollector nameDemo = new NameCollector();


   }//end main()

}