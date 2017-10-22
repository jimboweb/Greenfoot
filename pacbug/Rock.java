import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        // Add your action code here.
    }
    public int rockWidth()
    {
        GreenfootImage image = getImage();  
        return image.getWidth();
    }
    public int rockHeight()
    {
        GreenfootImage image = getImage();  
        return image.getHeight();
    }
     
}
