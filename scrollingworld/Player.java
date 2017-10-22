import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    MoveObstructedByObstacle moa = new MoveObstructedByObstacle(this, Wall.class);
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        World theWorld = getWorld();
        if(theWorld instanceof ScrollingWorld)
        {
            moa.moveWithArrowsOb(5);
            ScrollingWorld sw = (ScrollingWorld)getWorld();
            sw.scrollAround(this);
        }
    }    

}
