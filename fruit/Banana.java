import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Actor
{
    int worldHeight;
    World myWorld;
    public void addedToWorld(World background)
    {
        myWorld = background;
        worldHeight = background.getHeight();
    }
    public void act() 
    {
        setLocation(getX(), getY()+1);
        
        if(getY()>=worldHeight - 5)
        {
            myWorld.removeObject(this);
        }
    }    
}
