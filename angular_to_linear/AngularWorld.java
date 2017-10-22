import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class AngularWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AngularWorld extends World
{

    /**
     * Constructor for objects of class AngularWorld.
     * 
     */
    public AngularWorld()
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
        Circle bigCircle = new Circle(150, Color.BLUE);
        addObject(bigCircle, 100, 200);
        Hinge hinge = new Hinge(30, Color.BLACK, bigCircle.getX(), bigCircle.getY());
        addObject(hinge, 50, 200);
        Piston piston = new Piston(this, hinge, 100, 20);
        Connector c = new Connector(this, hinge, piston);
    }
}










