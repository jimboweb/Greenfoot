import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{
    int rightSideOfScreen;
    int bottomOfScreen;
    
    public void addedToWorld(World water)
    {
        rightSideOfScreen = water.getWidth() - 1;
        bottomOfScreen = water.getHeight() - 1;
    }
    
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        if(Greenfoot.getRandomNumber(20)==1)
        {
            setRotation(Greenfoot.getRandomNumber(360));
        }
        
        int x = getX();
        int y = getY();
        
        if(x<=0 || y<=0 || x >= rightSideOfScreen || y >= bottomOfScreen)
        {
            turn(180);
        }
    }    
}