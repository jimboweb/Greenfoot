import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cherry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cherry extends Actor
{
    /**
     * Act - do whatever the Cherry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
