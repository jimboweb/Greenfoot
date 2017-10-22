import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
/**
 * Write a description of class Station here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Station extends Actor
{
    //TODO: draws a double line when connecting, maybe shouldn't do that
    private boolean removeMe = false;
    private boolean placed = false;
    private MouseInfo mi;
    private int index;
    private ArrayList<Integer> connectedStations;
    private TrainSystem system;
    Station newConnectedStation = null;
    
    /**
     * diagnostic only. Creates a station without an index.
     */
    public Station(){
        GreenfootImage img = new GreenfootImage(10,10);
        img.setColor(Color.RED);
        img.fillOval(0, 0, img.getWidth(), img.getHeight());
        setImage(img);
        this.connectedStations = new ArrayList<Integer>();
    }
    
    /**
     * Creates a station with an index. Should match the index in the TrainSystem. 
     */
    public Station(int index){
        GreenfootImage img = new GreenfootImage(10,10);
        img.setColor(Color.RED);
        img.fillOval(0, 0, img.getWidth(), img.getHeight());
        setImage(img);
        this.index = index;
        this.connectedStations = new ArrayList<Integer>();
    }
    
    public void addedToWorld(World w){
        system=(TrainSystem)w;
    }
    /**
     * Act - do whatever the Station wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!placed){
            followMouse();
        } else if(Greenfoot.mouseClicked(this)){
            newConnectedStation = system.addStation(0, 0);
            system.setConnectingStation(this);
        }
        
        if(removeMe){
            system.removeStation(this);
        }
        
    }
    
    /**
     * followMouse is what the station does before it is placed: follow the mouse around
     * until user clicks
     */
   private void followMouse(){
            mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX(), mi.getY());
            if(Greenfoot.mouseClicked(this)){
                placeStation();
            }
    }
    
    
    /**
     * placeStation either sets the station down where it is or 
     * replaces this station with the existing one it's touching
     */
    private void placeStation(){
        placed = true;
        int cStation = system.getConnectingStation();
        if(cStation!=-1){
            Station touchingStation = (Station)getOneIntersectingObject(Station.class);
            if(touchingStation==null){
                connectToStation(cStation);
            } else {
                touchingStation.connectToStation(cStation);
                removeMe = true;
            }
        } 
        if(!removeMe) {
            system.showText(index+"", getX()+20, getY()+20);
        }


    }
    
    /**
     * Adds the indexed station to the array of stations this one is connected
     * to. Also connects the other station to this one. Adds a track
     * in both directions.  (TODO: should there only be one?)
     * @param index - the index of the station connecting to in the TrainSystem's array of stations
     */
    public void connectToStation(int index){
        Station connectedStation = system.getStation(index);
        if(connectedStation!=null && !isConnected(connectedStation)){
            connectedStations.add(index);
            system.addTrack(this, connectedStation);
            connectedStation.connectToStation(this.index);
        }
        system.clearConnectingStation();
    }

    public int getIndex(){
        return index;
    }
    
    public ArrayList<Integer> getConnectedStations(){
        return connectedStations;
    }
    
    public Station getConnectedSation(int index){
        if(connectedStations.contains(index))
            return system.getStation(index);
        else 
            return null;
    }
    
    public boolean isConnected(Station st){
        return connectedStations.contains(st.getIndex());
    }
    
}
