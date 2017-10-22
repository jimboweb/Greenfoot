import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    DriftMove dm = new DriftMove(this);
    public void addedToWorld(World w)
    {
                dm.setRandomSpeed(5, 5);
    }
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        dm.drift();
        dm.bounceAtEdge();
        dm.bounceOffObject(Ball.class);
    }    
}
