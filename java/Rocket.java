import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    DriftMove driftmove = new DriftMove(this, 6);
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        driftmove.drift();
        driftmove.turnAccelArrows();
        driftmove.bounceAtEdge();
        // Add your action code here.
    }    
}