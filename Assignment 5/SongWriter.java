import java.util.ArrayList;
import java.util.Hashtable;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SongWriter{
  private Hashtable<Integer,String> pitchToNote;
  
  // The constructor of this class
  public SongWriter(){
    this.initPitchToNoteDictionary();
  }
  
  // This initialises the pitchToNote dictionary,
  // which will be used by you to convert pitch numbers
  // to note letters
  public void initPitchToNoteDictionary(){
    pitchToNote  = new Hashtable<Integer, String>();
    pitchToNote.put(60, "C");
    pitchToNote.put(61, "C#");
    pitchToNote.put(62, "D");
    pitchToNote.put(63, "D#");
    pitchToNote.put(64, "E");
    pitchToNote.put(65, "F");
    pitchToNote.put(66, "F#");
    pitchToNote.put(67, "G");
    pitchToNote.put(68, "G#");
    pitchToNote.put(69, "A");
    pitchToNote.put(70, "A#");
    pitchToNote.put(71, "B");
  }
  
  // This method converts a single MidiNote to its notestring representation
  public String noteToString(MidiNote note){
    String result = "";
    
    if(note.isSilent())
    {
      result+="P";
    }
    else
    {
      if(note.getOctave()!=0)
      {
        //System.out.println(note.getPitch() +" "+ " "+ 12*note.getOctave() +" " +  (note.getPitch() - 12*note.getOctave()) );
        result+=pitchToNote.get(note.getPitch() - 12*note.getOctave()); //notes.getPitch + 12*note.getOctave();
      }
      else
      {
        result+=pitchToNote.get(note.getPitch());
      }
    }
    
    
    
    
    // TODO: Q4.a.
    return result;
  }
  
  // This method converts a MidiTrack to its notestring representation.
  // You should use the noteToString method here
  public  String trackToString(MidiTrack track){ 
    ArrayList<MidiNote> notes = track.getNotes();
    String result = "";
    int previous_octave = 0;
    MidiNote current_note;
    int diff =0;
    int i=0;   
    
    for(i=0; i<notes.size();i++)
    { 
      current_note=notes.get(i); 
      
      if(current_note.getOctave()>0 && i==0)
      {
        for(int a = 0; a <current_note.getOctave();a++)
        {
          result+=">";
        }
      }
      else if(current_note.getOctave()<0 && i==0)
      {
        for(int a = 0; a <-current_note.getOctave();a++)
        {
          result+="<";
        }
      }
      else if( i!=0 && current_note.getOctave()-notes.get(i-1).getOctave()>0 ) 
      {
        diff = current_note.getOctave()-notes.get(i-1).getOctave();
        for(int a = 0; a <diff;a++)
        {
          result+=">";
        }
      }
      else if( i!=0 &&(current_note.getOctave() - notes.get(i-1).getOctave())<0) 
      { diff = current_note.getOctave()-notes.get(i-1).getOctave();
        
        for(int a = 0; a >diff;a--)
        {
          result+="<";
        }
      }
      
      
      /*else if(  current_note.getOctave()-notes.get(i-1).getOctave()>0 ) // if the octave >0 
       { diff = current_note.getOctave()-notes.get(i-1).getOctave();
       for(int a = 0; a <diff;a++)
       {
       result+=">";
       }
       }
       if( i!= 0 ){diff = current_note.getOctave()-notes.get(i-1).getOctave(); System.out.println(diff + " the real thing " + i);}
       
       
       if( i!= 0 && (current_note.getOctave() - notes.get(i-1).getOctave())<0) // if the octave <0 
       { diff = current_note.getOctave()-notes.get(i-1).getOctave();
       
       for(int a = diff; a >0;a--)
       {
       result+="<";
       }
       }*/
      
      
      
      
      //System.out.print(notes.get(i).getDuration()+noteToString(notes.get(i))); 
      
      //System.out.println(current_note.getOctave() );
      if(notes.get(i).getDuration()==1)
{
  result+=noteToString(notes.get(i));
}
else
{  
  result+= notes.get(i).getDuration() + noteToString(notes.get(i));
}
}
System.out.println(result);



// TODO: Q4.b.

/* 
 * A hint for octaves: if the octave of the previous MidiNote was -1
 * and the octave of the current MidiNote is +3, we will have 
 * to append ">>>>" to the result string.
 */

return result;
}

  public void writeToFile(Song s1 , String file_path) throws IOException
  {
   
    
      FileWriter fw = new FileWriter(file_path);
      BufferedWriter bw = new BufferedWriter(fw);
      
      String toWrite = "";
      
      toWrite += s1.getBPM(); System.out.println(s1.getBPM());
       bw.write("bpm = "+toWrite);
       bw.newLine();
   toWrite = s1.getName();
      bw.write("name = " +toWrite);
      bw.newLine();
       if(s1.getSoundbank()!=null)
       {
         toWrite =String.valueOf( s1.getSoundbank());
         bw.write("soundbank = "+toWrite );
         bw.newLine();
       }
        for(int i = 0; i< s1.myTracks.size();i++)
        { toWrite = String.valueOf(s1.myTracks.get(i).getInstrumentId());
      bw.write("Instrument = "+ toWrite);
      bw.newLine(); 
      
       toWrite = trackToString(s1.myTracks.get(i));
      bw.write("track = "+ toWrite);
      bw.newLine();
        } 
      
      
       bw.close();      
      
    
    
  }
    // TODO Q4.c.
    // Implement the void writeToFile( Song s1 , String file_path) method
    // This method writes the properties of the Song s1 object
    // and writes them into a file in the location specified by 
    // file_path. This file should have the same format as the sample
    // files in the 'data/' folder.
    
    public static void main( String[] args)
    {
      // TODO: Q4.d.
      // Create a Song object
      Song idk = new Song();
      
      try{idk.loadFromFile("./data/07.txt"); idk.revert();} catch(Exception e){}
      SongWriter my = new SongWriter();
      for(int i = 0; i< idk.myTracks.size();i++ )
      {
        my.trackToString(idk.myTracks.get(i));
        System.out.println();
      }
      System.out.println(idk.getName());
      
      try{
          my.writeToFile(idk ,"./data/"+idk.getName()+"_reverse"+".txt");}
          catch(Exception e){}
      // Load text file using the given song_filename, remember to 
      // catch the appropriate Exceptions, print meaningful messages!
      // e.g. if the file was not found, print "The file FILENAME_HERE was not found"
      
      // call the revert method of the song object.
      
      // Create a SongWriter object here, and call its writeToFile( Song s, String file_location) method.
      
    }
    }