import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aphid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aphid extends Actor
{
    /**
     * Act - do whatever the Aphid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Mover.class))
        {
            getWorld().removeObject(this);
            ScoreBoard.addScore(5);
        }
    }    
}







