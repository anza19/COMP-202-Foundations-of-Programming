import java.awt.Color;
import becker.robots.*;
import becker.robots.City;

  public class RobotsMoveLights {
  // Archibald Haddock (123456789)
  // COMP-202B, Section 0 (Winter 2010)
  // Instructor: Cuthbert Calculus
  // Assignment 4, Question 2
  
  public static void move_right(Robot robot) 
  {
    //Method allowing for right turns by invoking three left turns.
    robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
  }
  public static void moveToDiagonal(Robot robot) {
    
   //Invoking move to allow forward motion to collect flashers. 
    robot.move();
    int steps = 1;
    while(robot.canPickThing())   
    { 
      //Using conditionals to check whether there are anyother flashers.
      if(robot.canPickThing())
        robot.pickThing();
        robot.move();
        steps++;
    }
    robot.turnLeft();
    robot.turnLeft();
    
    //For loop allows us to regain original position
    for(int i=0;i<steps;i++)
    {
      robot.move();
    }
    
    robot.turnLeft();
    robot.turnLeft();
    
    //For loop allowing for diagonal motion and allows to deposit flashers.
    for(int i=0; i<steps-1;i++)
    {
      robot.move();
      robot.putThing();
      move_right(robot);
      robot.move();
      robot.turnLeft();
    }
    robot.move();
 
  }
  
  public static void main(String[] args) {
    final int LIGHT_STREET = 1;
    final int LIGHT_AVENUE = 1;
    final int NUMBER_FLASHERS = 6;
    
    City montreal = new City(12,12);
    
    Robot asimo = new Robot(montreal, LIGHT_STREET,
                            LIGHT_AVENUE - 1, Direction.EAST);
    
    for (int i = 0; i < NUMBER_FLASHERS; i++) {
      new Flasher(montreal, LIGHT_STREET, LIGHT_AVENUE + i,
                  true);
    }   
    
    moveToDiagonal(asimo);  
  }
  
}
