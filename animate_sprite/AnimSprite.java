import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimSprite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimSprite extends Actor
{
    Animation sheet = new Animation("animate_disc.gif", 10, 6);
    
    public AnimSprite()
    {
        setImage(sheet.animate(4));
    }
    
    /**
     * Act - do whatever the AnimSprite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(sheet.animate(4));
    }    
}
