public class DoublyLinkedList{
  Node start;
  int length;
  
  
  public DoublyLinkedList()
  {
    this.start = null;
    this.length = 0;
    
  }
  
  //Go through, check if value exists.
  //If it does, return the Node that matches
  //If it doesn't find it, return null
  public Node find( String value )
  {
    boolean check = true; 
    Node s = start;
    
    while (check)
    {
      if(s==null)
      {
        return null;
      }  
      else if(s.data == value)
      {
        return s;
      }
      s= s.next;
      
      
    }
    return null;
  }
  
  //Method to insert a new node at the start of list.
  public void insertStart( String value)
  {
    // TODO create a node with the input value and add it to the list
    
    Node s = start;
    Node adding= new Node(); 
    adding.CreateList(value);
    
    if(s == null)
    {
      start=adding.start;
    }
    else
    {
      
      adding.CreateList(value);
      start= adding.start;
      adding.start.setNext(s);
      s.setPrevious(adding.start);
      
    }
  }
  
  //Insert a node at the end.
  public void insertEnd( String value )
  {
    Node adding= new Node(); 
    adding.CreateList(value);
    
    Node s = start;
    
    while(s!=null)
    {
      
      if(s.next==null)
      {
        s.setNext(adding.start);
        s.next.setPrevious(s);
        
        return ;
      }
      s = s.next;
    }
    
  }
  
  // remove all the occurences of the value in the list
  public void remove( String value )
  {
    Node adding= new Node(); 
    adding.CreateList(value);
    
    Node s = start;
    
    while(s!=null)
    { 
      
      if(s.data== value && s==start)
      {
        start= s.next;
        s=start;
      }
      if(s.data == value && s!=start)
      {// System.out.println(s.prev.data);
        s.previous.setNext(s.next);
      }
      s=s.next;
    }
    
  }
  
  // remove from the list the Node at the position given
  // by the value of index.
  public void removeAtIndex( int index )
  {
    Node s = start; 
    int ListLength=0;
    while(s!=null)
    { 
      
      if(index == 0 && ListLength==0)
      {
        start= s.next;
      }
      
      if(index != 0 && ListLength!=0 && index==ListLength)
      {
        s.previous.setNext(s.next);
      }
      ListLength++;
      s=s.next;
    }
    
    
  }
  
  //String in reverse order method
  public String toStringReverse(){
    String result = "";
    Node s= start;
    
    Node s1;
    while(s!=null)
    { 
      
      if(s.next==null)
      { 
        while (s.data != start.data)
        {
          
          result+= s.data;
          s=s.previous;
          
        }
        return result + start.data;
      }
      s=s.next;
      
      
    }
    return result;
  }
  
  //ToString for debugging and printing
  public String toString()
  {
    
    String str = "";
    Node pointer = start;
    while ( pointer != null ) 
    {
      str += " "+pointer.data;
      pointer = pointer.next;
    }        
    return str;
  }
  
  public static void main (String[] args)
  {
    DoublyLinkedList list = new DoublyLinkedList();
    String once = "And you may find yourself ";
    
    list.insertStart("I am helpless. ");
    
    list.insertEnd(once);
    
    list.insertEnd("I do not believe ");
    list.insertEnd("Hello!. ");
    list.insertEnd("There is hope. ");
    
    Node n = list.find(once);
    n.data += " in a shotgun shack.";
    
    System.out.println(list);
    list.remove(once);
    list.removeAtIndex(4);
    System.out.println(list);
    System.out.println(list.toStringReverse());

  }
}




    