import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bananas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bananas extends SpaceActors
{
    int horizontalSpeed = Greenfoot.getRandomNumber(5)-3;
    int verticalSpeed = Greenfoot.getRandomNumber(5)-3;
    /**
     * Act - do whatever the Bananas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(horizontalSpeed, verticalSpeed);
        wrapAtEdge();
    }    
}
