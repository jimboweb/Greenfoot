import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cliffs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliffs extends World
{

    /**
     * Constructor for objects of class Cliffs.
     * 
     */
    JetPackGuy theGuy;
    Platform platforms;
    diags theDiags;
    public Cliffs()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1);
        theGuy = new JetPackGuy();
        platforms = new Platform();
        theDiags = new diags();
        addObject(platforms, 200, 300);
        addObject(theGuy, 200, 100);
        addObject(theDiags, 200, 20);
    }
    public JetPackGuy getGuy(){
        return theGuy;
    }
}
