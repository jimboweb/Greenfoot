import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends World
{

    /**
     * Constructor for objects of class Water.
     * 
     */
    public Water()
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
        addObject(fish, 400, 212);
        for(int i= 0;i<10; i++)
        {
            Fly fly = new Fly();
            addObject(fly, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        }
    }
}


