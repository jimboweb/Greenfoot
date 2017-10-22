import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Ladybug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ladybug extends Actor
{
    /**
     * Act - do whatever the Ladybug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MoveWithArrows mwa = new MoveWithArrows(this);
    public void addedToWorld(World w)
    {
        StaticText st = new StaticText(w, "My text here", 16, Color.RED, Color.YELLOW, 100, 100);
    }
    public void act() 
    {
        mwa.MoveActorWithArrows(10);
    }    
}
