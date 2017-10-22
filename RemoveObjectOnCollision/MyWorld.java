import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
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
        Fly fly = new Fly();
        addObject(fly, 272, 174);
        Pizza pizza = new Pizza();
        addObject(pizza, 513, 47);
        Pizza pizza2 = new Pizza();
        addObject(pizza2, 495, 277);
        Pizza pizza3 = new Pizza();
        addObject(pizza3, 67, 368);
        Pizza pizza4 = new Pizza();
        addObject(pizza4, 76, 88);
    }
}
