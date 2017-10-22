import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheWorld extends World
{
    TheActor theactor = new TheActor();
    /**
     * Constructor for objects of class TheWorld.
     * 
     */
    public TheWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        addObject(theactor, getWidth()/2, getHeight()/2);
    }
}
