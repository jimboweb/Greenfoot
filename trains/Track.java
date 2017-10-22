import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track extends Actor
{
    int[] connectedStations;
    public Track(TrainSystem system, Station station0, Station station1){
        GreenfootImage myImage = new GreenfootImage(1,1);
        int s0x = station0.getX();
        int s1x = station1.getX();
        int s0y = station0.getY();
        int s1y = station1.getY();
        int myX = (s0x + s1x)/2;
        int myY = (s0y + s1y)/2;
        system.addObject(this, myX, myY);
        turnTowards(s1x, s1y);
        int d = (int)Math.sqrt(Math.pow((s0x-s1x),2)+Math.pow((s0y-s1y),2));
        setImage(new GreenfootImage(d,1));
        myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawLine(0,0,d,0);
}
    /**
     * Act - do whatever the Track wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
