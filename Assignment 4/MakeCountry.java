public class MakeCountry {
 public static void main(String[] args){
  //Chaning this number will change the number of cities in the country.
  int numCities = 15;
  //You can rename your country to whatever you like.
  String countryName = "Canada";
  //TODO Create the country
  Country myCountry=new Country(countryName,numCities,35);
  
  //TODO Check if this country is connected. 
  boolean connected = myCountry.setConnectivity();
  
  System.out.println(countryName + " is connected... " + connected);
  
  //Once every thing else is complete, uncomment line below to display the image.
  CountryMap map = new CountryMap(myCountry.getCities(), myCountry.getName());
 }
}
