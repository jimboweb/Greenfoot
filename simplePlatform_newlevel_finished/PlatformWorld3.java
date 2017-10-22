import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformWorld3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformWorld3 extends World
{

    /**
     * Constructor for objects of class PlatformWorld3.
     * 
     */
    public PlatformWorld3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        StaticText youWon = new StaticText(this,"YOU WIN!");
    }
}
