import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ControlCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlCommand extends Actor
{
    Platforms myPlatforms;
    String keyboard = "Left/right to run, up to jump. Press 'm' to switch to mouse control.";
    String mouse = "Move mouse to run, click to jump. Press 'k' to switch to keyboard control.";
    String displayString = keyboard;
    BallGuy ballguy;
    
    public ControlCommand(BallGuy bg)
    {
        update();
        ballguy = bg;
    }
    public void act()
    {
        if(displayString == keyboard && Greenfoot.isKeyDown("m"))
        {
            displayString = mouse;
            ballguy.switchControls("mouse");
        } 
        
        if(displayString == mouse && Greenfoot.isKeyDown("k"))
        {
            displayString = keyboard;
            ballguy.switchControls("keyboard");
        }
        update();
    }
    
    public void update()
    {
        setImage(new GreenfootImage(displayString, 20, Color.WHITE, Color.BLACK));
    }
  
}
