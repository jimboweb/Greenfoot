import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bricks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bricks extends World
{

    /**
     * Constructor for objects of class Bricks.
     * 
     */
    public Bricks()
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
        BlueGuy blueguy = new BlueGuy();
        addObject(blueguy, 50, 50);
        BlueGuy blueguy2 = new BlueGuy();
        addObject(blueguy2, 200, 200);
        BlueGuy bob = new BlueGuy();
        addObject(bob, 100, 100);
    }
}
