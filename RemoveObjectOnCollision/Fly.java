import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{
    MoveWithArrows mwa = new MoveWithArrows(this);
    RemoveObjectOnCollision rooc = new RemoveObjectOnCollision(this,Pizza.class);
    int pizzasGrabbed = 0;
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mwa.MoveActorWithArrows(10);
        pizzasGrabbed += rooc.removeObjectOnCollision();
    }    
}
