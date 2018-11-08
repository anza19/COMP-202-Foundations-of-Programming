public class Node{
  
  // TODO modify this class so that it 
  // stores a reference to the previous 
  // element in the list
  
  String data;
  Node next;
  Node previous;
  Node start;
  Node current;
  Node always = null;
  
  
  //Constructor 1
  public Node ()
  {
    start = null;
  }
  
  //Constructor 2
  public Node(String input_data){
    this.data = input_data;
    this.next = null;
    this.previous = null;
    
    
  }
  public void CreateList (String input_data)
  {
    Node NewString = new Node(input_data) ;
    
    if(start == null)
    {
      start = NewString;
      current = NewString;
      DoublyLinkedList list = new DoublyLinkedList();
      list.start = start;
      return;
    }
    if (next == null && start !=null)
    {
      NewString.setPrevious(current);
      current.setNext(NewString);
      
      current = NewString;
      current.setNext(null);
      
    }
    
    
  }
  
  
  public void setNext(Node n)
  {
    this.next= n;
  }
  
  public void setPrevious(Node n)
  {
    this.previous= n;
  }
  
  
}
