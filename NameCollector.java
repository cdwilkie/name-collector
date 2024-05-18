import java.util.Scanner;



/** NameCollector is a program that prompts the user for
 * information: Name (string), age (int), and height (double).
 * Information is the output to screen 
 */

public class NameCollector {
   
   private String thePrompt, userName, outputMessage;
   private int userAge;
   private double userInches;

   /**
    * Constructor initializes all variables with values
    */
   public NameCollector() {
      setPrompt();
      userName = "";
      userAge = 0;
      userInches = 0.0;
   }//end Constructor

   private void setPrompt() {
      thePrompt = "Welcome!\nPlease enter your: <Name>, <Age>, and <Height-Inches>";
   }//end setPrompt()
   
   public String getPrompt() {
      return thePrompt;
   }//end getPrompt()

   public void showPrompt() {
      System.out.println(thePrompt);
   }//end showPrompt()

   public void setUserName(String inputName) {
      userName = inputName;
   }//end setUserName()

   public String getUsername() {
      return userName;
   }//end getUserName

   public void setAge(int inputAge) {
      userAge = inputAge;
   }//end setAge()

   public int getAge() {
      return userAge;
   }// end getAge()

   public void setInches(double inputInches) {
      userInches = inputInches;
   }//end setInches()

   public double getInches() {
      return userInches;
   }//end getInches()

   public void setOutputMessage() {
      outputMessage = "You entered:\n\tName:\t" + userName;
      outputMessage += "\n\tAge:\t" + userAge;
      outputMessage += "\n\tInches:\t" + userInches;
   }//end setOuputMessage

   public String getOutputMessage() {
      return outputMessage;
   }//end getOutputMessage
   
/**
 * Constructs an instance of NameCollector to store
 * the user provided <Name>, <Age>, and <Inches>. Attempts
 * to collect the information from System.in and display
 * the data to console.
 * @param args command line input - not used
 */
   public static void main(String[] args) {
      //Scanner scanner = new Scanner(System.in);
      NameCollector newDemo = new NameCollector();
      newDemo.showPrompt();                     // Print prompt to console

      try (Scanner scanner = new Scanner(System.in)) 
      {
         newDemo.setUserName(scanner.next());   // Store username from input
         newDemo.setAge(scanner.nextInt());     // Store userage from input
         newDemo.setInches(scanner.nextDouble());// Store userInches from input
         newDemo.setOutputMessage();            // Update the output message
         System.out.println(newDemo.getOutputMessage());//Display data to console
      }//end try
      catch (Exception e) {
         System.out.println("Something wrong occured");
      }//end catch
      
   }//end main()

}//end NameCollector