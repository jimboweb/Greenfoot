import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class StartText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartText extends Actor
{
    public StartText() 
    {
        GreenfootImage introText = new GreenfootImage("Click to start", 24, Color.BLUE, Color.WHITE);
        setImage(introText);
    }
    /**
     * Act - do whatever the StartText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Sand());
        }
    }    
}
