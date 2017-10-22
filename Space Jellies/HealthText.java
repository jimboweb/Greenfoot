import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HealthText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthText extends Actor
{
    /**
     * Act - do whatever the HealthText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HealthText()
    {
        setImage(new GreenfootImage("Health",24,Color.RED, Color.BLACK));
    }
}
