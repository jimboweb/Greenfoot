import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mousetrap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mousetrap extends Actor
{
    /**
     * Act - do whatever the Mousetrap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor mouse = getOneIntersectingObject(Mouse.class);
        if(mouse!=null)
            getWorld().removeObject(mouse);
    }    
}
