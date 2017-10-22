import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ErrorMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ErrorMessage extends Actor
{
    /**
     * Act - do whatever the ErrorMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ErrorMessage(String m) 
    {
        setImage(new GreenfootImage(m, 16, Color.WHITE, Color.BLACK));
    }    
}
