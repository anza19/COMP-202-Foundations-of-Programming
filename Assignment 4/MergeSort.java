import java.util.Arrays;
public class MergeSort {
  
  //Here is a test array. You may use it or change it to test with other examples.
  public static void main(String[] args){
    String[] a = {"apple", "orange", "banana", "pear", "grapefruit","gfd"};
    System.out.println(Arrays.toString(a));
    a = mergeSort(a);
    System.out.println(Arrays.toString(a));
    //compareTo(a);
  }
  
  /*
   * This is the recursive sorting method, mergeSort.
   * Your task is to implement the merge method described below.
   */
  public static String[] mergeSort(String[] a){
    
    if(a.length<2)
      return a;
    int middle = a.length/2;
    String[] left = new String [middle];
    String[] right = new String [a.length-middle];
    int i=0;
    for(i=0; i<middle; i++)
      left[i] = a[i];
    for(int j=0; j<right.length; j++){
      right[j] = a[i];
      i++;
    }
   
   left = mergeSort(left);
    right = mergeSort(right);
    String[] result = merge(left,right);
    
    return result;
  }
  
  /*
   * This method merges two sorted arrays. They might be of slightly different lengths.
   * The resulting array should be sorted and should contain all values (including duplicates)
   * from the original two input arrays.
   */
  public static String[] merge(String[] l, String[] r){
    //TO BE COMPLETED
 
    String [] combined=  new String [l.length+r.length];
    int x=0;
    int y=0;
   for(int i = 0; i<combined.length; ++i)
   { 
      if(x==l.length)
      {// If left array is equal to 1 , then the right array string is assigned to combined[1]
        
        combined[i]=r[y];
        y++;
      }
      else if(y==r.length)
      {// Or if the right arrray is equal to 1 , then left array string is assigned to combined[1]
        
        combined[i]=l[x];
        x++;
      }  
      else if(l[x].compareTo(r[y])<0)
      {  
        combined[i]= l[x];
        x++;
      }
      else
      { 
        combined[i]= r[y];
        y++;
      } 
    }
    return combined;
  }
  
}
