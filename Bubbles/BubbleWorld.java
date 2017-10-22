import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BubbleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BubbleWorld extends World
{
    Bubble bubble1 = new Bubble();
    /**
     * Constructor for objects of class BubbleWorld.
     * 
     */
    public BubbleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(bubble1, 100, 100);
    }
}
