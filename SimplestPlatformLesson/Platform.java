import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    public Platform()
    {
        GreenfootImage myImage = new GreenfootImage(150,25);
        myImage.setColor(Color.BLUE);
        myImage.fillRect(0,0,myImage.getWidth(),myImage.getHeight());
        setImage(myImage);
    }
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
