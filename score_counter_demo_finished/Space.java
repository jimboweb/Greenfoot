import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    //*************************************************************************************
    //Code Clip 1
    Counter counter = new Counter();    //Creates a Counter object
    //End Code Clip 1
    //*************************************************************************************
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
        
    //***********************************************************************************
    //Code Clip 2:
    //This will return the counter to the Cherries so it can call the AddScore() method. 
    public Counter getCounter()
    {         
        return counter; 
    }
    //End Code Clip 2
    //***********************************************************************************

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(counter, 100, 40);
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
