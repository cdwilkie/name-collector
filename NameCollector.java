import java.util.Scanner;



/** NameCollector is a class that prompts the user for
 * information: Name (string), age (int), and height (double).
 * Information is the output to screen. Contains a main() driver
 * to demonstrate class functionality. 
 */

public class NameCollector {

   public static void main (String [] args) {
      Scanner scanner = new Scanner(System.in);
      NameCollector newDemo = new NameCollector(scanner);
      newDemo.run();
   }// end main()


   private String userName;
   private int userAge;
   private double userInches;
   private Scanner scanner;

   // Constructors
   // Default initializes userName, userAge, and userInches
   public NameCollector() {
      userName = "";
      userAge = 0;
      userInches = 0.0;
   }

   // Overloaded constructor accepts scanner reference
   public NameCollector (Scanner scanner) {
      this();
      this.scanner = scanner;
   }

   // Getters
   public String getName() {
      return userName;
   }//end getName()

   public int getAge() {
      return userAge;
   }//end getAge()

   public double getInches() {
      return userInches;
   }//end userInches()

   // Setters
   public void setName(String userName) {
      this.userName = userName;
   }//end setName()

   public void setAge(int userAge) {
      this.userAge = userAge;
   }//end setAge()

   public void setInches(double userInches) {
      this.userInches = userInches;
   }//end setInches()

   // Messages
   public void greetUser() {
      System.out.println(
         "Hello, User.\n\nPlease enter your:\n" +
         "\tFirst Name:\n\tAge:\n\tHeight(Inches)\n"
      );
   }//end greetUser()

   public void showResults() {
      System.out.println(
         "Hello " + userName + ". You are " +
         userAge + " years old and " + userInches +
         " inches tall."
      );
   }//end showResults()

   public void run() {
      greetUser();
      try {
         this.userName = scanner.next();
         this.userAge = scanner.nextInt();
         this.userInches = scanner.nextDouble();
         showResults();
      }  
      catch (Exception e) {
         System.out.println(
            "Error - Please Enter only your first name, your age, and your " + 
            "height (in inches)"
            );
      }

   }


}//end NameCollector