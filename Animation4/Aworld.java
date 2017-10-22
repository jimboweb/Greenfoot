import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aworld extends World
{

    /**
     * Constructor for objects of class Aworld.
     * 
     */
    public Aworld()
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
        Link link = new Link();
        addObject(link, 260, 240);
    }
}
