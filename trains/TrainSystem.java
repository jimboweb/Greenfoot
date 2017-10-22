import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class System here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainSystem extends World
{
    private ArrayList<Station> stations = new ArrayList<Station>();
    private ArrayList<Track> tracks = new ArrayList<Track>();

    int connectingStation = -1;
    /**
     * Constructor for objects of class System.
     * 
     */
    public TrainSystem()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {

        StationButton stationbutton = new StationButton();
        addObject(stationbutton, 1046, 75);
        stationbutton.setLocation(1131, 30);
    }
    
    public void act(){
        
    }
    
    public Station addStation(int mouseX, int mouseY){
        Station newStation = new Station(stations.size());
        stations.add(newStation);
        addObject(newStation, mouseX, mouseY);
        return newStation;
    }
    
    public void removeStation(Station st){
        removeObject(st);
    }
    
    public Station getStation(int index){
        if(index<stations.size())
            return stations.get(index);
        else
            return null;
    }
    
    public Track addTrack(Station station0, Station station1){
        Track newTrack = new Track(this, station0, station1);
        tracks.add(newTrack);
        return newTrack;
    }
    
    public void setConnectingStation(Station st){
        connectingStation = st.getIndex();
    }
    
    public int getConnectingStation(){
        return connectingStation;
    }
    
    public void clearConnectingStation(){
        connectingStation = -1;
    }
    
}
