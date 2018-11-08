//Complete this class.
public class Vector2D {
  
  
  
  private double x;
  private double y;
  
  public Vector2D(double x, double y) ]
  {
    this.x=x;
    this.y=y;
  }
  
  public void PrintContent()
  {
    System.out.println("The x coordinate of the vector is: "+x );
    System.out.println("The y coordinate of the vector is: "+y );
  }
  
  public double getX()   
  {
    return this.x;
  }
  
  public double getY()  
  {
    return  this.y;
  }
  
  public double distance ( Vector2D w)  ]
  {
    
   
    return Math.sqrt(((x - w.x)*(x - w.x) + (y - w.y)*(y - w.y)));
 
  }
  
}
