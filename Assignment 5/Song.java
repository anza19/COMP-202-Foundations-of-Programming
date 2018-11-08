import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

public class Song{
    String myName;
    int myBeatsPerMinute;
    String mySoundbank;
    ArrayList<MidiTrack> myTracks;
    MidiTrack inst_track;
    
    // The constructor of this class
    public Song(){
        myTracks = new ArrayList<MidiTrack>();
        myBeatsPerMinute = 200;
        mySoundbank = "";
        myName = "Default_Name";
    }

    // GETTER METHODS

    public String getName(){
       return myName;
    }

    public String getSoundbank(){
       return mySoundbank;
    }
    
    public int getBPM(){
        return myBeatsPerMinute;
    }

    public ArrayList<MidiTrack> getTracks(){
        return myTracks;
    }

    public void loadFromFile(String file_path) throws IOException
    {
      
      
        FileReader fr = new FileReader(file_path);
        
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        
        while(line!=null)
        {
          if(line.startsWith("bpm")) 
          {
            String [] split = line.split("=");
            myBeatsPerMinute= Integer.parseInt((split [1]).trim());  System.out.println(myBeatsPerMinute);
          }
          
          else if(line.startsWith("name"))
          {
            String [] split = line.split("=");
            myName= split [1].trim(); System.out.println(myName);
          }
          
          else if(line.startsWith("soundbank")) 
          {
            String [] split = line.split("=");
            mySoundbank= split [1].trim(); System.out.println(mySoundbank);
          }
          else if(line.startsWith("instrument")) 
          {
            String [] split = line.split("=");
            inst_track =new MidiTrack(Integer.parseInt(split [1].trim())); 
           // myTracks.add(inst_track); 
            line=br.readLine();//System.out.println(Integer.parseInt(split [1].trim())+ "this si the instruments  ");
            
            split = line.split("=");
            inst_track.loadNoteString(split[1].trim());
            myTracks.add(inst_track);
            System.out.println(myTracks);//.get().getInstrumentId()+"this si the instruments  "); 
          }
          else if(line.startsWith("track"))
          {
            String [] split = line.split("=");System.out.println("i am here");
            inst_track =new MidiTrack(0);
            inst_track.loadNoteString(split[1].trim());
            myTracks.add(inst_track);
          }
          
           
        
          line = br.readLine();
        }
      
    }
    
    // TODO: Q3.a.
    // Implement void loadFromFile(String file_path) method
    // This method loads the properties and build the tracks of this
    // song object from a file in the location specified by 
    // file

    public void revert(){
        for (int i = 0; i<myTracks.size(); i++){
            myTracks.get(i).revert();
        }
    }
}