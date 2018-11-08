public class Country {
  //TODO create this object.
  private String name;
  private boolean isConnected;
  City [] cities;
  
  public Country( String countryName , int a, int maxDist)
  {  
    
    name=countryName;
    cities= new City[a];
    
    for(int i =0; i<a;i++)
    {
      cities[i]= new City();
    }
    
    int b=0;
    while(b<a)
    {
      cities[b].setNeighbours(maxDist,cities);
      b++;
    }
    
    
    
  }
  
  public String getName()
  {
    return name; 
  }
  
  public City[] getCities()
  {
    return cities; 
  }
  
  public boolean setConnectivity()
  {  
    //isConnected= true;
    cities[0].explore();
    for (int i = 0; i<cities.length; i++)
    {
      if(cities[i].getCityBoolean()== false)
      {
        return false;
      }
      
      
    }
    return true;}
}