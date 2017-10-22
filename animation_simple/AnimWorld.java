import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimWorld extends World
{

    /**
     * Constructor for objects of class AnimWorld.
     * 
     */
    public AnimWorld()
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
        Fish fish = new Fish();
        addObject(fish, 230, 227);

        Frog frog = new Frog();
        addObject(frog, 357, 247);
        int frogs = getObjects(Frog.class).size();
    }
}














