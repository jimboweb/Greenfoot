import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blox extends World
{

    /**
     * Constructor for objects of class Blox.
     * 
     */
    public Blox()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Guy guy = new Guy();
        addObject(guy, 24, 17);
        Guy guy2 = new Guy();
        addObject(guy2, 100, 17);
        Guy bob = new Guy();
        addObject(bob, 200, 17);
    }
}
