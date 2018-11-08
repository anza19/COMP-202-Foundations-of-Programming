import java.util.ArrayList;
import java.util.Hashtable;

public class MidiTrack
{
  private Hashtable<Character,Integer> noteToPitch;
  
  private ArrayList<MidiNote> notes;
  private int instrumentId;
  // private String nodestring;
  
  // The constructor for this class
  public MidiTrack(int instrumentId)
  {
    notes = new ArrayList<MidiNote>();
    this.instrumentId = instrumentId;
    
    this.initPitchDictionary();
  }
  
  // This initialises the noteToPitch dictionary,
  // which will be used by you to convert note letters
  // to pitch numbers
  public void initPitchDictionary()
  {
    noteToPitch  = new Hashtable<Character, Integer>();
    noteToPitch.put('C', 60);
    noteToPitch.put('D', 62);
    noteToPitch.put('E', 64);
    noteToPitch.put('F', 65);
    noteToPitch.put('G', 67);
    noteToPitch.put('A', 69);
    noteToPitch.put('B', 71);
  }
  
  // GETTER METHODS
  public ArrayList<MidiNote> getNotes()
  {
    return notes;
  }
  
  public int getInstrumentId()
  {
    return instrumentId;
  }
  
  // This method converts notestrings like
  // <<3E3P2E2GP2EPDP8C<8B>
  // to an ArrayList of MidiNote objects 
  // ( the notes attribute of this class )
  public void loadNoteString(String notestring)
  {
    // convert the letters in the notestring to upper case
    notestring = notestring.toUpperCase(); 
    int duration = 0;
    int pitch = 0;
    int octave = 0;
    int flat =-1;
    int sharp=1;
    int counter=1;
    
    
    // TODO: Q2. implement this method
    // Q2.a. Notes
    
    for(int i =0; i< notestring.length(); i++) 
    {
      if(notestring.charAt(i)==62)
      {
        pitch+=12;
      }
      if(notestring.charAt(i)==60) 
      {
        pitch= -12 + pitch;
      }
      
      for(int j =65; j<=71 ;j++) 
      {
        
        if(notestring.charAt(i)==j)
        { 
          while(counter<3)
          {
            
            for(int num =48 ; num <= 57; num++) 
            {
              if(i>=counter && notestring.charAt(i-counter)==num )
              { 
                duration=(num-48)*(int)(Math.pow(10,counter-1)) +duration;
              }
            }
            if(duration ==0)
            {
              counter =3;
            }
            counter++;
          }
          if(i<notestring.length()-1 && notestring.charAt(i+1)==35  ) 
          {
            char convert= (char)j;
            notes.add(new MidiNote(noteToPitch.get(convert)+pitch+sharp,duration)); duration=0;
          }
          else if(i<notestring.length()-1 && notestring.charAt(i+1)==33) 
          {
            char convert= (char)j;
            notes.add(new MidiNote(noteToPitch.get(convert)+pitch+flat,duration)); duration=0;
          }
          else 
            //If there is no # or !
          {
            char convert= (char)j ;
            notes.add(new MidiNote(noteToPitch.get(convert)+pitch,duration)); duration=0;
          }
          counter= 1;
        }
      }
      
      if(notestring.charAt(i)=='P') 
        //checking for pauses.
      {
        while(counter<3)
        {
          
          for(int num =48 ; num <= 57; num++) 
          {
            if(i>=counter && notestring.charAt(i-counter)==num )
            { 
              duration=(num-48)*(int)(Math.pow(10,counter-1)) +duration;
            }
          }
          if(duration ==0)
          {
            counter =3;
          }
          counter++;
        }
        MidiNote b = new MidiNote(60+pitch,duration);
        notes.add(b); 
        b.setSilent(true);
        duration=0;
        counter=1;
        //notes.get(0).setSilent(true);
        
        
      }
    } 
    
    // Q2.b. Pauses
    // Q2.c. Durations
    // Q2.d. Octaves
    // Q2.e. Flat and sharp notes
    // Hint1: use a for loop with conditional statements
    // Hint2: Use the get method of the noteToPitch object (Hashtable class)
  }
  
  public void revert()
  {
    ArrayList<MidiNote> reversedTrack = new ArrayList<MidiNote>();     
    for ( int i = notes.size() - 1; i >= 0; i--){
      MidiNote oldNote = notes.get(i);
      //Create a newNote
      MidiNote newNote = new MidiNote(oldNote.getPitch(), oldNote.getDuration());
      
      //If there was a pause in the note, check
      if(oldNote.isSilent()){
        newNote.setSilent(true);
      }
      
      //Add the note to the ArrayList
      reversedTrack.add(newNote);
    }
    notes = reversedTrack;
  }
  
  // This will only be called if you try to run this file directly
  // You may use this to test your code.
  public static void main(String[] args)
  {
    //String notestring = "<<3E3P2E2GP2EPDP8C<8B>3E3P2E2GP2EPDP8C<8B>";
    String notestring = "12CEF";
    int instrumentId = 0;
    Song mySong = new Song ();
    try
    {
      mySong.loadFromFile("./data/08.txt");
    }
    catch(Exception e)
    {

    }
    
    
    
    
    // Build the MidiTrack object
    MidiTrack newTrack = new MidiTrack(instrumentId);
    newTrack.initPitchDictionary();
    newTrack . loadNoteString ( notestring ); 
    
    System.out.println(newTrack.notes);
    
    
    
    // Build a MusicInterpreter and set a playing speed
    MusicInterpreter mi = new MusicInterpreter(); //mi . setBPM (1200);mi . loadSingleTrack ( newTrack );mi.play();
    // Load the track and play it
    mi.setBPM(1200);
    mi.loadSingleTrack( newTrack );
    //System.out.println("reached");
    //mi.loadSong(mySong);
    
    
    SongWriter write = new SongWriter();
    write.trackToString(newTrack);
    
    
    
    //mi.play();
    // Close the player so that your program terminates
    // mi.close();
    
    
    
  }
}
