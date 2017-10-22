import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube extends World
{
    Vector2d cubeCenter;
    Face topFace;
    int cubeSize = 50;
    /**
     * Constructor for objects of class Cube.
     * 
     */
    public Cube()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        cubeCenter = new Vector2d(getWidth()/2, getHeight()/2);
        topFace = new Face(this,
                            getWidth()/2,
                            10,
                            new Center(Color.RED, 50),
                            new Corner(Color.RED, 50),
                            new Side(Color.RED, 50),
                            new Corner(Color.RED, 50),
                            new Side(Color.RED, 50),
                            new Corner(Color.RED, 50),
                            new Side(Color.RED, 50),
                            new Corner(Color.RED, 50),
                            new Side(Color.RED, 50)
                            );                                
    }
    
    private void prepare()
    {

    }
    public void act()
    {
        topFace.draw();
    }
}
