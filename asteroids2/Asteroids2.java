import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroids2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroids2 extends World
{

    /**
     * Constructor for objects of class Asteroids2.
     * 
     */
    public Asteroids2()
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
        Ship ship = new Ship();
        addObject(ship, 257, 209);
    }
}
