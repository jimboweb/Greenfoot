import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class diags here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class diags extends Actor
{
    /**
     * Act - do whatever the diags wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public diags(){
        setImage(new GreenfootImage("  ", 20, Color.WHITE, Color.BLACK));
        
    }
    public void act() 
    {
       space theWorld = (space) getWorld();
       rocket theRocket = theWorld.getRocket();
       int deltaX = theRocket.deltaX;
       int deltaY = theRocket.deltaY;
       int rot = theRocket.getRotation();
       setImage(new GreenfootImage("deltaX = "+ deltaX + " deltaY = " + deltaY + " rotation = " + rot, 20,  Color.WHITE, Color.BLACK));
    }    
}
