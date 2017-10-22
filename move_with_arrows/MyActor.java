import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyActor extends Actor
{
    /**
     * Act - do whatever the MyActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        MoveWithArrows mwa = new MoveWithArrows(this, 5);
    public void act() 
    {
        mwa.moveWithArrows();
    }    
}
