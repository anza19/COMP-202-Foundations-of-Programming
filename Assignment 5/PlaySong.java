import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PlaySong
{
  public static void main( String[] args)
  {
    MusicInterpreter myMusicPlayer = new MusicInterpreter();
    // uncomment this line to print the available instruments
    //System.out.println(myMusicPlayer.availableInstruments());
    
    // TODO: Q3. b
    
    // Create a Song object
    
    // load text file using the given song_filename, 
    // remember to catch the appropriate Exceptions
    
    // Play it
    
    
    
    int instrumentId =0;
    Song mySong = new Song ();
    try 
    {
      mySong.loadFromFile("./data/06.txt");
    }
    catch(IOException e)
    {
      System.out.println("There is an IO exception.");
      System.out.println(e);
      
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      System.out.println("There is an ArrayIndexOutOfBoundsException.");
      System.out.println(e);
      
    }
    catch (NullPointerException e) 
    {
      System.out.println("There is a NullPointerException.");
      System.out.println(e);
      
    }
    catch (Exception e) {
      
    }
    
    
    
    // Build the MidiTrack object
    //MidiTrack newTrack = new MidiTrack(instrumentId);
    
    
    
    
    
    
    
    // Build a MusicInterpreter and set a playing speed
    MusicInterpreter mi = new MusicInterpreter();
    
    mi.loadSong(mySong);
    
    
    
    mi.play();
    // Close the player so that your program terminates
    mi.close();
  }
}