import java.util.Arrays;
public class Sorting {
  // name of the class needs to be the same as the name of the file 
  public static int Compare(String s1, String s2)
    
    //Call method to compare both strings 
  {int count = 0;
    int length=0;
    if(s1.length()<s2.length())
      //using an if statement to compare the length of both strings. 
    {length = s1.length();
    }
    //If nothing happen here go out of the loop 
    else{length = s2.length();}
    //Run for loop using the counter
    for  (int i = 0; i<length; i++)
    {
      if((int)s1.charAt(i) > (int)s2.charAt(i))
        
      {
        return 1;
      }
      if((int)s1.charAt(i) < (int)s2.charAt(i))
      {
        return -1;
      }
    }
    return 0;
  }
  
  //call method linearSearch 
  public static int linearSearch(String [] a, String t)
  {
    
    for (int i= 0; i< a.length ; i++)
    {
      if (a[i]== t)
      {return i;}
      
      
    }
    return -1;
  }
  // call method binarySearch 
  public static int BinarySearch(String [] a , String t)
  {
    
    int min =0 ;
    int max= a.length -1;
    // use the while loop to compare max with min 
    while ( max>=min)
    {
      int mid = (max+min)/2;
      
      if (a[mid]== t)
      {
        return mid;
      }
      else if (Compare (a[mid],t)== -1)
      {
        min= mid +1;
        
      }
      else 
      {
        max= mid-1;
      }
      
    }return -1;
    
  }
  // use this method to sort through bubbleSort 
  public static int bubbleSort(String[] myArray) {
    int n= myArray.length; 
    boolean swapped= true;
    //int i;
    int counter=0;
    while (swapped)
      // use the while loop to initialize the loop till the condition is satisfied 
    { 
      swapped=false; 
      for (int i=1; i<=n-1; i++)
      { 
        counter++;
        if (Compare(myArray[i-1], myArray[i]) == 1)
        {
          String temp; 
          
          temp= myArray[i];
          myArray[i]=myArray[i-1]; 
          myArray[i-1]=temp; 
          swapped=true; 
        }
        
      }
    }
    return counter;
  }
  
  public static int combSort(String[] myArray) {
    int gap; 
    
    gap= myArray.length;
    
    double shrink= 1.5;  
    
    boolean swapped=true; 
    //int i=0;
    int counter=0;
    
    while (swapped ||(gap!=1))
      
    {
      gap= (int)(gap/shrink); 
      
      if (gap<1)
        
      {
        gap=1; 
        
      }
      
      swapped= false; 
      int i=0;
      //int counter=0;
      
      while ((i+gap)<myArray.length)
        
      {
        
        counter++;
        if (Compare(myArray[i],myArray[i+gap])==1)
          
        {
          String temp; 
          
          temp= myArray[i];
          myArray[i]=myArray[i+gap]; 
          myArray[i+gap]=temp; 
          swapped=true; 
        }
        
        i++;
        
        
      }// System.out.println(Arrays.toString(myArray));
    }
    return counter;
  }
  
  public static void plotBubbleSortTest(int N_MAX) {
    /* 
     * bubble_sort_results[N] = the number of comparisons made
     * when sorting an array of size N.
     */
    int[] bubble_sort_results = new int[N_MAX];
    
    /*
     * For each array size between 1 (the smallest array size)
     * and N_MAX (an upper limit passed to this method), we will:
     * 1) create a random test array
     * 2) sort it, and store the number of comparisons in bubble_sort_results
     * MAKE SURE THAT YOUR METHOD IS ACTUALLY SORTING THE TEST ARRAY!!!!!!
     */
    for (int i = 1; i < N_MAX; i++) {
      String[] test_array = ArrayUtilities.getRandomNamesArray(i);
      bubble_sort_results[i] = bubbleSort(test_array);
    }
    
    // plot window
    // The argument passed to  PlotWindow is the title of the window
    PlotWindow pw = new PlotWindow("Bubble Sort!");
    
    // add a plot to the window using our results array
    /*
     *  The first argument for addPlot is a name for your data set
     *  The second argument for addPlot is an array of integers,
     *  In position "N" in the array, you should put the number of
     *  comparisons that your algorithm made, when sorting an array
     *  of size N. For example, bubble_sort_results[100] will contain
     *  the number of comparisons made for sorting an array of 100 elements
     */
    pw.addPlot("BubbleSort", bubble_sort_results);
  }
  
  public static void plotCombSortTest(int N_MAX) {
    // the results array
    int[] comb_sort_results = new int[N_MAX];
    
    // test sorting for arrays from size 1 to N_MAX
    // MAKE SURE THAT YOUR METHOD IS ACTUALLY SORTING THE TEST ARRAY!!!!!!
    for (int i = 1; i < N_MAX; i++) {
      String[] test_array = ArrayUtilities.getRandomNamesArray(i);
      comb_sort_results[i] = combSort(test_array);
      //comb sort mehtod is faster because it has few comparisons.
    }
    // create a plot window
    PlotWindow pw = new PlotWindow("Comb Sort!");
    // add a plot to the window using our results array
    pw.addPlot("CombSort", comb_sort_results);
  }   
  
  public static void plotCombBubble(int bubble, int comb)
  { int[] bubble_results= new int[bubble];
    int[] comb_results= new int[comb]; 
    for (int i =1; i<comb; i++)
    {
      String[]test_array= ArrayUtilities.getRandomNamesArray(i);
      comb_results[i]= combSort(test_array);
    }
    
    for (int i=1; i<bubble; i++)
    {
      String[]test_array= ArrayUtilities.getRandomNamesArray(i);
      bubble_results[i]= bubbleSort(test_array); 
      
    }
    PlotWindow pw= new PlotWindow("Comb and bubble Sort!"); 
    pw.addPlot("comb sorting compare", comb_results); 
    pw.addPlot("bubble sorting compare", bubble_results);
  }
  
  /*
   * TODO:  implement the plotCombBubble method
   * This method should plot the results from both sorting methods 
   * in the same window.
   * Hint: Create a single PlotWindow, but use the addPlot method twice,
   * once for each sorting algorithm
   */
  
  public static void main(String[] args) {
    // uncomment the following lines when you want to test your sorting methods
    plotBubbleSortTest(100);
    plotCombSortTest(100);
    //plotCombBubble(100);
    String[] a = {"Vladimir", "Ismail", "Priya", "Jiequn", "Melanie", "Camilo", "Jonathan"} ;
    String target= "Ismail";
    
    plotCombBubble(100,100);
    
    // System.out.println(BinarySearch(a,"Melanie"));
    // System.out.println(bubbleSort(a));
    
    
  }
}
