//Muhammad Anza Khan, McGill ID: 260618490
public class Question2
{
  public static void main(String[] args)
  {
    //order to draw axis, lines and parabola.
    int maxX=10;
    int maxY=10;
    
    for(int y=maxY;y>=-maxY;y--)
    {
      for(int x=-maxX;x<=maxX;x++)
      {
        System.out.print(DrawAxis(x,y));
        if(DrawAxis(x,y)=="")
        {
          DrawLine(x,y,1.0,2.0);
          System.out.print(DrawLine(x,y,1.0,2.0));
          if(DrawLine(x,y,1.0,2.0)=="")
          {
            System.out.print(DrawParabola(x,y,0.3,1,-4));
          }
        }
        
      }
      System.out.println();
    }
  }
  
  public static String DrawAxis(int x, int y)
  {
    //return the character to be drawn.
    //return empty string if nothing needs to drawn here.
    if(x==0 && y==0)
    {
      return ".";
    }
    else if(x==0 && y==10)
    {
      return "^";
    }
    else if(y==0 && x==10)
    {
      return ">";
    }
    else if(x==0 && y!=0)
    {
      return "|";
    }
    else if(y==0 && x!=0)
    {
      return "-";
    }
    else
    {
      return "";
    }
    
  }
  
  public static String DrawLine(int x, int y, double a, double b)
  {
    //use the linear form y=ax + b
    //return the character to be drawn.
    //return empty string if nothing needs to be drawn here.
    if(y==a*x+b)
    {
      return "*";
    }
    return "";
    
  }
  
  public static String DrawParabola(int x, int y, double a,double b, double c)
  {
    //use the parabola form y = ax^2 + b*x +c
    //return the character to be drawn here
    //return empty string if nothing needs to be drawn here.
    if(y-2<=a*x*x +b*x +c && y+2>=a*x*x+b*x+c)
    {
      return "#";
    }
    return " ";
  }
}