import java.util.Random;

public class City {
  private static String[] namePrefixes = { "Chiguiro", "Maracas", "Raccoon",
    "Glass", "Iron", "Spring", "Winter", "Autumn", "Summer", "Godel",
    "Recursion", "Escher", "PowPow", "LOL", "Cheese", "MasterRoshi", "Pants", "Dork",
    "Cat", "Liszt", "Hysteria", "Cool", "Ennui", "Tortoise", "Mudkip", "Tonkatsu", 
    "Rainy", "Slump", "Tortilla", "Rodizio", "Ajiaco", "Sunny" };
  
  private static String[] nameSuffixes = { "ville", "vale", "_City", "town", "ton",
    "hill", "field", "land", "ia", "furt", "grad", "lia", "stadt", "stan" };
  
  private String name;
  private Vector2D pos;
  private City[] neighbours; 
  
  private boolean explored = false;
  
  public City() {
    //TODO complete constructor.
    //Generate a random name that is combination of a random prefix and suffix.
    //Initialize the initial position as a vector.
    //Max x and max y value should be 150.
    name = namePrefixes[(int)(Math.random()*namePrefixes.length)] + nameSuffixes[(int)(Math.random()*nameSuffixes.length)];
    double x1= (int)(Math.random()*151); 
    double y1= (int)(Math.random()*151); 
    
    pos= new Vector2D( x1, y1);
    neighbours= new City[14];
    
    {
      
    }
    
    
  }
  
  //maxDist is the further distance apart two cities can be and still be connected.
  //Return the number of neighbours found
  //If there are j neighbours, then the last length-j spots of neighbours should be null
  //And the first j elements should be city objects
  public void setNeighbours(double maxDist, City[] cities)
  {     
    int i=0;
    int k=0;
    
    while(i<cities.length)
    {
      if(this.pos.distance(cities[i].pos)<maxDist)
      {
      neighbours[k]=cities[i];
      k++;
      }
      i++;
    }
      
      }
       
      
      
      
      
        
      
    
    //TODO
    
    //return -1;
  
  
  //Searches to see which cities are connected to the current city.
  //If a city can be reached, its boolean 'explore' value will be true after this method is called
  //Otherwise, it will be false.
  public void explore() {
    this.explored= true;
    for (int i =0 ; i<neighbours.length;i++)
    {
      if(neighbours[i] != null && neighbours[i].explored == false)
      {
        neighbours[i].explore();
      }
    }
  }
  
  public Vector2D getPos()
  {
    return pos;
  }
  
  public String getName() {
    return name;
  }
  
  public City[] getNeighbours(){
    return neighbours;
  }
  
  public boolean getCityBoolean()
  {
   return explored; 
  }
  
}

