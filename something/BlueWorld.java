import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueWorld extends World
{

    /**
     * Constructor for objects of class BlueWorld.
     * 
     */
    public BlueWorld()
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
        addObject(fish, 289, 209);
        Bee bee = new Bee();
        addObject(bee, 508, 143);
        Bee bee2 = new Bee();
        addObject(bee2, 104, 88);
        Bee bee3 = new Bee();
        addObject(bee3, 208, 353);
        Fly fly = new Fly();
        addObject(fly, 543, 305);
        Fly fly2 = new Fly();
        addObject(fly2, 399, 154);
        Fly fly3 = new Fly();
        addObject(fly3, 354, 77);
        Fly fly4 = new Fly();
        addObject(fly4, 76, 179);
        Fly fly5 = new Fly();
        addObject(fly5, 43, 315);
        Fly fly6 = new Fly();
        addObject(fly6, 345, 327);
    }
}
