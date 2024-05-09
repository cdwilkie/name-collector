import java.util.Scanner;


class NameCollector {
   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      System.out.println("Please input a series of characters");
      String newName = scanner.nextLine();
      System.out.println("You enetered " + newName);

   }

}