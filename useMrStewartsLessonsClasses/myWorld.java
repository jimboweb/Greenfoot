import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class myWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class myWorld extends World
{

    /**
     * Constructor for objects of class myWorld.
     * 
     */
    public myWorld()
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
        Target target = new Target();
        addObject(target, 531, 240);
        Target target2 = new Target();
        addObject(target2, 270, 217);
        Target target3 = new Target();
        addObject(target3, 142, 313);
        Target target4 = new Target();
        addObject(target4, 67, 88);
        Target target5 = new Target();
        addObject(target5, 496, 106);
        Grabber grabber = new Grabber();
        addObject(grabber, 285, 107);
    }
}
