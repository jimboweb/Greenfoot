import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    private Color color;

    public Box(Color c)
    {
        this.color = c;
        getImage().setColor(c);
        getImage().fill();
    }
    
    public Color getColor()
    {
        return color;
    }
}
