import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{   
    Counter counter = new Counter();
    HealthCounter healthcounter = new HealthCounter();
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }
    
    public Counter getCounter()
    {
        return counter;
    }
    
    public HealthCounter getHealthCounter()
    {
        return healthcounter;
    }


    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(counter, 100, 40);
        addObject (healthcounter, 200, 40);
        PieShip pieship = new PieShip();
        addObject(pieship, getWidth()/2, getHeight()/2);
        Bananas bananas = new Bananas();
        addObject(bananas, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Bananas bananas2 = new Bananas();
        addObject(bananas2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Bananas bananas3 = new Bananas();
        addObject(bananas3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Bananas bananas4 = new Bananas();
        addObject(bananas4, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Bananas bananas5 = new Bananas();
        addObject(bananas5, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Bananas bananas6 = new Bananas();
        addObject(bananas6, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
}
