import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frog extends Actor
{
    DriftMove driftmove = new DriftMove(this, 6);
    public void addedToWorld(World w)
    {
        driftmove.setRandomSpeed(4, 4);
    }
    /**
     * Act - do whatever the Frog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        driftmove.drift();
        driftmove.bounceAtEdge();
    }    
}
