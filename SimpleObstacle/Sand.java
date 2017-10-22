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
        Bug bug = new Bug();
        addObject(bug, 201, 185);
        Wall wall = new Wall();
        addObject(wall, 274, 191);
        Wall wall2 = new Wall();
        addObject(wall2, 280, 147);
        wall2.setLocation(274, 143);
        Wall wall3 = new Wall();
        addObject(wall3, 281, 100);
        wall3.setLocation(274, 94);
        Wall wall4 = new Wall();
        addObject(wall4, 215, 85);
        wall4.setLocation(224, 93);
        Wall wall5 = new Wall();
        addObject(wall5, 175, 99);
        wall5.setLocation(174, 93);
        Wall wall6 = new Wall();
        addObject(wall6, 130, 99);
        wall6.setLocation(126, 94);
        Wall wall7 = new Wall();
        addObject(wall7, 133, 152);
        wall7.setLocation(127, 145);
    }
}
