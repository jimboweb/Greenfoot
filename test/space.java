import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class space extends World
{
    private rocket theRocket;
    /**
     * Constructor for objects of class space.
     * 
     */
    public space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        theRocket = new rocket();
        addObject(theRocket, 300, 200);
        addObject(new diags(), 300, 100);
        
    }
    
    public rocket getRocket(){
        return theRocket;
    }
    
    public void act(){
    }
}
