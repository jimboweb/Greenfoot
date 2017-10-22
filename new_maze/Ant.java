import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class And here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Actor
{
    /**
     * Act - do whatever the And wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        if(getWorld().getBackground().getColorAt(getX(), getY()).equals(Color.RED))
            move(-5);
        if(Greenfoot.isKeyDown("left"))
            turn(-15);
        else if (Greenfoot.isKeyDown("right"))
            turn(15);
    }    
}
