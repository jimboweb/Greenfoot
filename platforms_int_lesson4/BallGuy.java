import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGuy extends Actor
{
    /**
     * Act - do whatever the BallGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocationWithScroll(getX() -5, getY());
        } 
        if(Greenfoot.isKeyDown("right"))
        {
            setLocationWithScroll(getX()+5, getY());
        } 
    } 
    
    public void setLocationWithScroll(int newX, int newY)
    {
        Sky mySky = (Sky)getWorld();
        int shiftX = newX - getX();
        int shiftY = newY - getY();
        mySky.shiftScreen(shiftX, shiftY);
    }
}
