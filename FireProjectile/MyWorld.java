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
        RedBalloon redballoon = new RedBalloon();
        addObject(redballoon, 466, 267);
        RedBalloon redballoon2 = new RedBalloon();
        addObject(redballoon2, 178, 318);
        RedBalloon redballoon3 = new RedBalloon();
        addObject(redballoon3, 140, 67);
        Car car = new Car();
        addObject(car, 184, 170);
    }
}
