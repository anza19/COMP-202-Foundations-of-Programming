//Muhammad Anza Khan, McGill ID 260618490
import java.util.Scanner;
public class Question1
{
  public static void main(String[] args)
  {
    //statement to take user input
    System.out.println("Please input a binary number.");
    Scanner inputKeyboard = new Scanner (System.in);
    String binary =inputKeyboard.nextLine();
    
    //while loop to ask the user to continously re-enter input if not binary.
    while(CheckInputCorrect(binary)==false)
    {
      System.out.println("Please enter a binary number.");
      binary = inputKeyboard.nextLine();
    }
    
    
    System.out.println("That is a correct binary number.");
    System.out.println(BinaryToNumber(binary));
    
  }
  
  public static boolean CheckInputCorrect(String binary)
  {
    
    //using loops to check whether user input is valid or not.
    //if not valid, i.e not a combination of '0's or '1's, it returns a false and asks the user to enter again.
    //if valid, it stores the value.
    
    char value;
    int a = 0;
    while(a < binary.length())
    {
      value = binary.charAt(a);
      if(value == '1' || value == '0')
      {
        a++;
        
      }
      else
      {
        
        return false;
        
      }
      
    }
    
    return true;
    
    
  }
  
  
  public static int BinaryToNumber(String numberInput)
  {
    //using a series of loops to convert binary to decimal.
    
    int decimal = 0;
    int output =  0;
    for(int i = numberInput.length()-1; i>= 0; i--)
    {
      if(numberInput.charAt(i) == '1')
      {
        output = output + (int)(Math.pow(2, decimal));
        decimal++;
      }
        else
        {
          decimal++;
        }
        
      }
    return output;
    
     
  }
  
}




