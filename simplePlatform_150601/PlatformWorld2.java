import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformWorld2 extends World
{

    /**
     * Constructor for objects of class PlatformWorld2.
     * 
     */
    public PlatformWorld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }

    private void prepare()
    {
        PlatformJumper platformjumper = new PlatformJumper();
        addObject(platformjumper, 46, 492);

    }

}
