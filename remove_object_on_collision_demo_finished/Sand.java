import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sand extends World
{

    /**
     * Constructor for objects of class Sand.
     * 
     */
    public Sand()
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
        GoldBuggy goldbuggy = new GoldBuggy();
        addObject(goldbuggy, 286, 197);
        Gold gold = new Gold();
        addObject(gold, 473, 72);
        Gold gold2 = new Gold();
        addObject(gold2, 480, 309);
        Gold gold3 = new Gold();
        addObject(gold3, 147, 336);
        Gold gold4 = new Gold();
        addObject(gold4, 126, 60);
    }
}
