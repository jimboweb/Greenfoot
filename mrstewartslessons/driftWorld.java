import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class driftWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class driftWorld extends World
{
    Timer timer = new Timer(this);
    /**
     * Constructor for objects of class driftWorld.
     * 
     */
    public driftWorld()
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
        Rocket rocket = new Rocket();
        addObject(rocket, 265, 209);
        Balloon balloon = new Balloon();
        addObject(balloon, 444, 113);
        balloon.setLocation(443, 207);
        Ball ball = new Ball();
        addObject(ball, 412, 359);
        Ball ball2 = new Ball();
        addObject(ball2, 460, 98);
        Ball ball3 = new Ball();
        addObject(ball3, 164, 91);
        Ball ball4 = new Ball();
        addObject(ball4, 154, 275);
        timer.startTime();
        
    }
    
    public void started()
    {
        timer.startTime();
    }
    
    public void act()
    {
        timer.showTime();
        
    }
}
