//Muhammad Anza Khan McGill ID: 260618490
import java.util.Scanner;
public class Question2 {
  public static void main(String[] args)
    //Its like the green flag in Scratch
  {
    System.out.println(" Hal: How many laws of robotics are there according to Isaac Asmiov?");
    //Printing out question
    Scanner inputKeyboard = new Scanner(System.in);
    //input for scanner to allow user to key in the value.
    String inputUser;
    //definig variable inputUser
    inputUser = inputKeyboard.nextLine();
    
    if (inputUser.equals("3") || inputUser.equals("Three") || inputUser.equals("three")) {
      System.out.println(" Hal: That is correct. ");
    } else {
      System.out.println(" Hal: That is incorrect. There are three laws of robotics according to Isaac Asimov. They are as follows: ");
      System.out.println(" The first law states that a robot may not injure a human being or, through inaction, allow a human being to come to harm. ");
      System.out.println(" The second law states that a robot must obey the orders given to it by human beings, except where such orders would conflict with the First Law. ");
      System.out.println(" The third law states that a robot must protect its own existence as long as such protection does not conflict with the First or Second Law. ");
      
    }
    
  }
  
}